package name.ludengke95;

import org.apache.spark.SparkConf;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class SparkStreamingAutoConfiguration {

    @Bean
    public JavaStreamingContext createSparkStreamingContext(SparkConf sparkConf,SparkStreamingProperties sparkStreamingProperties){
        JavaStreamingContext context = new JavaStreamingContext(sparkConf, sparkStreamingProperties.getStartDuration());
        return context;
    }
}
