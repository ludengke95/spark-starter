package org.ludengke95;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * spark应用配置信息
 * @author ldk
 */
@Component
@ConfigurationProperties(prefix = "spring.spark")
public class SparkProperties {
    private final static String DEFAULT_APP_NAME = "spark-app";

    private final static int CPU_CORE = Runtime.getRuntime().availableProcessors();

    private final static String DEFAULT_MASTER = "local["+CPU_CORE+"]";

    private HashMap<String,String> other = new HashMap<>();

    private String appName = DEFAULT_APP_NAME;
    private String master = DEFAULT_MASTER;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public HashMap<String, String> getOther() {
        return other;
    }

    public void setOther(HashMap<String, String> other) {
        this.other = other;
    }
}
