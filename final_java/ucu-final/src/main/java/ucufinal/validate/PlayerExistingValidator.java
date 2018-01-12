package ucufinal.validate;

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
public class PlayerExistingValidator implements IStackColumnValidator, IUDFValidator {

    private Map<String, String> teams = new HashMap<>();

    @PostConstruct
    public void init() {
        try {
            Properties teamsProps = PropertiesLoaderUtils.loadAllProperties("teams.properties");
            for (String country : teamsProps.stringPropertyNames()) {
                for (String player : teamsProps.getProperty(country).split(",")) {
                    teams.put(player, country);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Boolean call(String s) throws Exception {
        return this.teams.containsKey(s);
    }

    @Override
    public String getUDFname() {
        return "playerExisting";
    }

    @Override
    public Dataset validate(Dataset df) {
        return df.filter(callUDF(this.getUDFname(), (col("from"))))
                .filter(callUDF(this.getUDFname(), (col("to"))));
    }
}
