package org.ludengke95;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class SparkAutoConfiguration {

    @Bean
    public SparkSession createSparkSession(SparkProperties sparkProperties){
        SparkConf conf = new SparkConf();
        conf.setAppName(sparkProperties.getAppName());
        conf.setMaster(sparkProperties.getMaster());
        //使用conf::set设置conf，取代java容器到scala容器的转化
        sparkProperties.getOther().forEach(conf::set);
        SparkSession session = SparkSession.builder().config(conf).getOrCreate();
        return session;
    }
}
