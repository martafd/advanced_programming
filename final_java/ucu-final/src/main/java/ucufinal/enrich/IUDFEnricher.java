package ucufinal.enrich;

import org.apache.spark.sql.api.java.UDF1;

public interface IUDFEnricher extends UDF1<String, String> {
    public String getUDFname();
}
