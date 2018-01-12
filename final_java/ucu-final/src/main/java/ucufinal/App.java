package ucufinal;


import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ucufinal.enrich.DataEnricherManager;
import ucufinal.util.DataManager;
import ucufinal.util.UDFRegistrater;
import ucufinal.validate.ValidationManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
        JavaSparkContext sc = ctx.getBean(JavaSparkContext.class);

        DataManager dataManager = ctx.getBean(DataManager.class);
        Dataset df = dataManager.getData();
        df.show();

        DataEnricherManager enricherManager = ctx.getBean(DataEnricherManager.class);
        UDFRegistrater registrater = ctx.getBean(UDFRegistrater.class);
        registrater.register();

        df = enricherManager.enrich(df);
        df.show();

        ValidationManager validationManager = ctx.getBean(ValidationManager.class);
        df = validationManager.validate(df);


//        JavaRDD<String> lines = sc.textFile("data.txt");
//        JavaRDD<Integer> lineLengths = lines.map(s -> s.length());
//        int totalLength = lineLengths.reduce((a, b) -> a + b);

    }
}
