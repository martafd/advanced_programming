package ucufinal.conf;

import org.apache.spark.SparkConf;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("PROD")
public class ProdConf {

    @Value("${app.name}")
    private String appName;

    @Value("${spark.home}")
    private String sparkHome;

    @Value("${master.uri}")
    private String masterUri;

    @Bean
    public SparkConf sparkConf(){
        SparkConf conf= new SparkConf();
        conf.setMaster(masterUri);
        conf.setAppName("PROD_ucufinal");
        return conf;
    }
}
