package ucufinal.enrich;


import org.apache.spark.sql.Dataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataEnricherManager {

//    @Autowired
//    private JavaSparkContext sparkContext;
//
//    @Autowired
//    private SQLContext sqlContext;

    @Autowired
    private List<IStackColumnEnricher> stackers;

    public Dataset enrich(Dataset df) {
        for (IStackColumnEnricher stacker : stackers) {
            df = stacker.stackColumn(df);
        }
        return df;
    }
}
