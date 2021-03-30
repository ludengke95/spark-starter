package name.ludengke95;

import org.apache.commons.lang.StringUtils;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;

/**
 * spark应用配置信息
 * @author ldk
 */
@Component
@ConfigurationProperties(prefix = "spring.spark-streaming.kafka")
public class SparkStreamingKafkaProperties {

    private final static Logger log = LoggerFactory.getLogger(SparkStreamingKafkaProperties.class);

    private final static Boolean DEFAULT_AUTO_COMMIT = true;
    private final static String DEFAULT_KEY_DESERIALIZER_CLASS = "StringDeserializer.class";
    private final static String DEFAULT_VALUE_DESERIALIZER_CLASS = "StringDeserializer.class";

    private Boolean autoCommit = DEFAULT_AUTO_COMMIT;

    private String bootstrapServers="";
    private String groupId="";
    private String autoOffsetReset="";

    private HashMap<String,String> other = new HashMap<>();

    private String keyDeserializer = DEFAULT_KEY_DESERIALIZER_CLASS;
    private String valueDeserializer = DEFAULT_VALUE_DESERIALIZER_CLASS;

    private Class keyDeserializerClass = StringDeserializer.class;
    private Class valueDeserializerClass = StringDeserializer.class;

    @PostConstruct
    private void init(){
        if(StringUtils.isEmpty(keyDeserializer)){
            log.warn("keyDeserializer is empty, default set StringDeserializer.class");
            keyDeserializer = DEFAULT_KEY_DESERIALIZER_CLASS;
            keyDeserializerClass = StringDeserializer.class;
        }

        if(StringUtils.isEmpty(valueDeserializer)){
            log.warn("valueDeserializer is empty, default set StringDeserializer.class");
            valueDeserializer = DEFAULT_VALUE_DESERIALIZER_CLASS;
            valueDeserializerClass = StringDeserializer.class;
        }

        if(StringUtils.isEmpty(bootstrapServers)){
            throw new IllegalArgumentException("bootstrapServers is required");
        }

        if(StringUtils.isEmpty(groupId)){
            throw new IllegalArgumentException("groupId is required");
        }
        if(StringUtils.isEmpty(autoOffsetReset)){
            throw new IllegalArgumentException("autoOffsetReset is required");
        }
    }

    public Boolean getAutoCommit() {
        return autoCommit;
    }

    public void setAutoCommit(Boolean autoCommit) {
        this.autoCommit = autoCommit;
    }

    public String getKeyDeserializer() {
        return keyDeserializer;
    }

    public void setKeyDeserializer(String keyDeserializer) {
        this.keyDeserializer = keyDeserializer;
    }

    public String getValueDeserializer() {
        return valueDeserializer;
    }

    public void setValueDeserializer(String valueDeserializer) {
        this.valueDeserializer = valueDeserializer;
    }

    public Class getKeyDeserializerClass() {
        return keyDeserializerClass;
    }

    public Class getValueDeserializerClass() {
        return valueDeserializerClass;
    }

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getAutoOffsetReset() {
        return autoOffsetReset;
    }

    public void setAutoOffsetReset(String autoOffsetReset) {
        this.autoOffsetReset = autoOffsetReset;
    }

    public HashMap<String, String> getOther() {
        return other;
    }

    public void setOther(HashMap<String, String> other) {
        this.other = other;
    }
}
