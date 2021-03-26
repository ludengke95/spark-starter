package org.ludengke95;

import scala.Tuple2;
import scala.collection.Seq;
import scala.collection.immutable.Map;

import java.util.List;
import java.util.stream.Collectors;

public class JavaScalaUtils {
    public static <K, V> scala.collection.immutable.Map<K, V> toScalaImmutableMap(java.util.Map<K, V> jmap){
        List<Tuple2<K, V>> tuples = jmap.entrySet()
                .stream()
                .map(e -> Tuple2.apply(e.getKey(), e.getValue()))
                .collect(Collectors.toList());

        Seq<Tuple2<K, V>> scalaSeq = scala.collection.JavaConverters.asScalaBufferConverter(tuples).asScala().toSeq();

        return (Map<K, V>) scala.collection.immutable.Map$.MODULE$.apply(scalaSeq);
    }
}
