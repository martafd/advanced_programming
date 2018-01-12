package ucufinal.enrich;

import org.apache.spark.sql.Dataset;
import org.springframework.stereotype.Service;

import static org.apache.spark.sql.functions.callUDF;
import static org.apache.spark.sql.functions.col;

@Service
public class MatchTimeEnricher implements IStackColumnEnricher, IUDFEnricher {
    @Override
    public String call(String min) throws Exception {
        int tmpTime = Integer.valueOf(min.split(":")[0]);
        if (tmpTime > 45 && tmpTime <= 90) {
            return String.valueOf(2);
        } else if (tmpTime <= 45 && tmpTime >= 0) {
            return String.valueOf(1);
        } else {
            return null;
        }
    }

    @Override
    public Dataset stackColumn(Dataset df) {
        return df.withColumn("matchTime",
                callUDF(this.getUDFname(), col("eventTime")));
    }

    @Override
    public String getUDFname() {
        return "getMatchTime";
    }
}








