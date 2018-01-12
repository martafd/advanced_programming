package ucufinal.validate;

import org.apache.spark.sql.Dataset;

public interface IStackColumnValidator {
    public Dataset validate(Dataset df);
}
