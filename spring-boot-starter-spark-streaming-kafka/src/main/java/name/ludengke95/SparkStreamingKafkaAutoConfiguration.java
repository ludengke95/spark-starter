package name.ludengke95;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class SparkStreamingKafkaAutoConfiguration {

    @Bean
    public JavaStreamingContext createSparkStreamingContext(SparkConf sparkConf){

        return null;
    }
}
