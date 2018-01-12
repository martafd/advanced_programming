package ucufinal.validate;

import org.apache.spark.sql.Dataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidationManager {
    @Autowired
    private List<IStackColumnValidator> validators;

    public Dataset validate(Dataset df) {
        for (IStackColumnValidator validator: validators) {
            df = validator.validate(df);
        }
        return df;
    }
}
