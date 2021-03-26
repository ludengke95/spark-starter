package name.ludengke95;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * spark应用配置信息
 * @author ldk
 */
@Component
@ConfigurationProperties(prefix = "spring.spark.streaming")
public class SparkStreamingKafkaProperties {

}
