package ucufinal.enrich;

import org.apache.spark.sql.Dataset;

public interface IStackColumnEnricher {
    public Dataset stackColumn(Dataset df);
}
