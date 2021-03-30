package name.ludengke95;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SparkStarterExample implements CommandLineRunner {

    @Autowired
    private SparkSession sparkSession;

    public static void main(String[] args) {
        SpringApplication.run(SparkStarterExample.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Dataset<Row> in = sparkSession.read().option("header", "true").csv("./spark-starter-example/1.in");
        in.createOrReplaceTempView("in_data");
        sparkSession.sql("select name,date,sum(num) as num from in_data group by name,date").createOrReplaceTempView("tmp");
        sparkSession.sql("select name,date,sum(num) over(partition by name) from tmp").show();
    }
}
