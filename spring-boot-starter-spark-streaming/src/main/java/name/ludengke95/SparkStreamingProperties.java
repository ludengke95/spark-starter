package name.ludengke95;

import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.Durations;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * spark streaming 应用配置信息
 * @author ldk
 */
@Component
@ConfigurationProperties(prefix = "spring.spark.streaming")
public class SparkStreamingProperties {
    private final static Duration DEFAULT_DURATION = Durations.seconds(10);

    private Duration startDuration;

    /**
     * 启动间隔，单位秒
     */
    private int duration;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @PostConstruct
    public void init(){
        if(duration==0){
            this.startDuration = DEFAULT_DURATION;
        }else {
            this.startDuration = Durations.seconds(duration);
        }
    }

    public Duration getStartDuration() {
        return startDuration;
    }
}
