package name.ludengke95;

import org.apache.spark.api.java.function.Function2;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Order(1)
public class SparkStreamingStarterExample implements CommandLineRunner {

    @Autowired
    private JavaStreamingContext context;

    public static void main(String[] args) {
        SpringApplication.run(SparkStreamingStarterExample.class,args);
    }

    @Override
    public void run(String... args) {
        JavaReceiverInputDStream<String> stringJavaReceiverInputDStream = context.socketTextStream("127.0.0.1", 3333);
        JavaPairDStream<String, Integer> result = stringJavaReceiverInputDStream
                .flatMap(s -> Arrays.asList(s.split(" ")).iterator())
                .mapPartitionsToPair(stringIterator -> {
                    List<Tuple2<String, Integer>> list = new ArrayList<>();
                    stringIterator.forEachRemaining(s -> list.add(Tuple2.apply(s, 1)));
                    return list.iterator();
                })
                .reduceByKey((x, y) -> x + y);
        result.print();
    }
}
