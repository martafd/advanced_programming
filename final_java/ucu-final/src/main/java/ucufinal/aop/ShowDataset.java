package ucufinal.aop;

import org.apache.spark.sql.Dataset;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Profile("DEV")
public class ShowDataset {
    @After("execution(org.apache.spark.sql.Dataset ucufinal.util.DataManager.getData(..)")
    public Dataset print(ProceedingJoinPoint pjp) {
        Dataset df = null;
        try {
            df = (Dataset) pjp.proceed();
            df.show();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return df;
    }
}
