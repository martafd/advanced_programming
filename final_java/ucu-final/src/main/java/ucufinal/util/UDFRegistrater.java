package ucufinal.util;

import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucufinal.enrich.IUDFEnricher;
import ucufinal.validate.IUDFValidator;

import java.util.List;

@Service
public class UDFRegistrater {
    @Autowired
    private List<IUDFEnricher> udfEnrichers;

    @Autowired
    private List<IUDFValidator> udfValidators;

    @Autowired
    private SQLContext sqlContext;

    public void register() {
        for (IUDFEnricher udf : this.udfEnrichers) {
            sqlContext.udf().register(udf.getUDFname(), udf, DataTypes.StringType);
        }
        for (IUDFValidator udf: this.udfValidators) {
            sqlContext.udf().register(udf.getUDFname(), udf, DataTypes.BooleanType);
        }
    }


}
