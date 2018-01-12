package ucufinal.validate;

import org.apache.spark.sql.api.java.UDF1;

public interface IUDFValidator extends UDF1<String, Boolean> {
    public String getUDFname();
}
