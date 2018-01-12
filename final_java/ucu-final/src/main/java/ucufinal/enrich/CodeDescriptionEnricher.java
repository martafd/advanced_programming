package ucufinal.enrich;

import org.apache.spark.sql.Dataset;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static org.apache.spark.sql.functions.callUDF;
import static org.apache.spark.sql.functions.col;

@Service
public class CodeDescriptionEnricher implements IStackColumnEnricher, IUDFEnricher {

    private Map<Integer, String> codesDescriptions = new HashMap<>();

    @PostConstruct
    public void init() {
        try {
            Properties codes = PropertiesLoaderUtils.loadAllProperties("codes.properties");
            for (String propName : codes.stringPropertyNames()) {
                codesDescriptions.put(Integer.valueOf(propName), codes.getProperty(propName));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String call(String code) throws Exception {
        return codesDescriptions.get(Integer.valueOf(code));
    }


    @Override
    public Dataset stackColumn(Dataset df) {
        return df.withColumn("codeDescription",
                callUDF(this.getUDFname(), col("eventCode")));
    }

    @Override
    public String getUDFname() {
        return "getCodeDescription";
    }
}
