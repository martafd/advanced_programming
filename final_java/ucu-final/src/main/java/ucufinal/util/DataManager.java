package ucufinal.util;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;
import ucufinal.model.Event;

import java.io.IOException;
import java.util.*;

@Service
public class DataManager {

    @Value("${raw.data.location}")
    private String rawDataLocation;

    @Autowired
    private JavaSparkContext sparkContext;

    @Autowired
    private SQLContext sqlContext;

    public JavaRDD<String> readLines() {
        JavaRDD<String> lines = this.sparkContext.textFile(this.rawDataLocation);

        return lines.filter(s -> {
                    return s.length() > 0;
                });
    }
//        Set<String> playersSet = new LinkedHashSet<>();
//        System.out.println();
//
//        try {
//            Properties teams = PropertiesLoaderUtils.loadAllProperties("teams.properties");
//            for (String propName : teams.stringPropertyNames()) {
//                playersSet.addAll(Arrays.asList(teams.getProperty(propName).split(",")));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Players set is " + playersSet);
//
//        Dataset<Row> dataset = this.sqlContext.createDataset(lines.filter(s -> {
//            return s.length() > 0;
//        }));

//        JavaRDD<String> cleanLines = lines
//                .filter(s -> {
//                    return s.length() > 0;
//                })
//                .filter(s -> {
//
//                    Set<String> intersection = new HashSet<String>(s1); // use the copy constructor
//                    intersection.retainAll(s2);
//                    return
//                })

    private JavaRDD<String> cleanColumns(JavaRDD<String> rawData, Set<String> columns) {
        return rawData.map(s -> {
            StringBuilder sb = new StringBuilder();
            for (String keyVal : s.split(";")) {
                if (columns.contains(keyVal.split("=")[0])) {
                    sb.append(keyVal + ";");
                }
            }
            return sb.toString();
        });
    }

    private JavaRDD<String> cleanPlayers(JavaRDD<String> data, Set<String> players) {
        return data
                .filter(s -> {
                    Set<String> tmpPlayerSet = new HashSet<>();
                    String[] tmpPlayerArray = s.split(";");
                    tmpPlayerSet.addAll(Arrays.asList(tmpPlayerArray[1].split("=")[1],
                            tmpPlayerArray[2].split("=")[1]));
                    Set<String> intersection = new HashSet<String>(players); // use the copy constructor
                    intersection.retainAll(tmpPlayerSet);
//                    System.out.println(s + " " + intersection.size());
                    return intersection.size() == 2;
                });
    }


    private JavaRDD<String> cleanTime(JavaRDD<String> data) {
        return data.filter(s -> {
            return Integer.valueOf(s.split(";")[3].split("=")[1].split(":")[0]) < 90;
        });
    }


    private JavaRDD<String> cleanCardCodes(JavaRDD<String> data) {
        // I found that valid codes for 2 players is only 3 and 4
        Set<Integer> twoPlayersCodes = new HashSet<>();
        twoPlayersCodes.addAll(Arrays.asList(3, 4));

        return data.filter(s -> {
            int tmp_code = Integer.valueOf(s.split(";")[0].split("=")[1]);
            return twoPlayersCodes.contains(tmp_code);
        });
    }


    public Dataset getData() {
        System.out.println("getData");
        JavaRDD<String> rawData = this.readLines();
        Set<String> columns = new HashSet();


        try {
            Properties footballColumns = PropertiesLoaderUtils
                    .loadAllProperties("football_columns.properties");
            columns.addAll(Arrays.asList(footballColumns.getProperty("columnNames").split(",")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Columns is " + columns);

        JavaRDD<String> withoutColumns = this.cleanColumns(rawData, columns);

        Set<String> playersSet = new HashSet<>();

        try {
            Properties teams = PropertiesLoaderUtils.loadAllProperties("teams.properties");
            for (String propName : teams.stringPropertyNames()) {
                playersSet.addAll(Arrays.asList(teams.getProperty(propName).split(",")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        JavaRDD<String> cleanPlayers = this.cleanPlayers(withoutColumns, playersSet);

        JavaRDD<String> cleanTime = this.cleanTime(cleanPlayers);

        JavaRDD<String> cleanCardCodes = this.cleanCardCodes(cleanTime);
//                .map(s -> {
//            System.out.println(s);
//            return s;
//        });


//        System.out.println(cleanCardCodes.map(s -> s.length()).reduce((a, b) -> a + b));

        JavaRDD<Event> toDF = cleanCardCodes.map(s -> new Event(s));

        return sqlContext.createDataFrame(toDF, Event.class);
    }

}
