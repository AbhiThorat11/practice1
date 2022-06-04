import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import  java.util.Properties;
public class main {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers","localhost:9092");
        props.put("key.serializer","org.apache.kafka.common.serialization.IntegerSerializer");
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
                Producer<Integer,String>producer = new KafkaProducer<Integer, String>(props);

                for (int i =0;i<=20;i++){
                    ProducerRecord<Integer,String> producerRecord= new ProducerRecord<Integer,String>("unboxingbigdata",i,"test message" + Integer.toString(i));
                    producer.send(producerRecord);
                }
                producer.close();
    }
}
