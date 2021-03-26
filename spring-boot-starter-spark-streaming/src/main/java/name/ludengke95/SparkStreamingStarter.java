package name.ludengke95;

import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Integer.MAX_VALUE)
public class SparkStreamingStarter implements CommandLineRunner {

    @Autowired
    private JavaStreamingContext context;

    @Override
    public void run(String... args) throws Exception {
        context.start();
        context.awaitTermination();
    }
}
