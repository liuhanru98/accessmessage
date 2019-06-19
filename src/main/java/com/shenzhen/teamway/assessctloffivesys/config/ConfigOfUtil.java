package com.shenzhen.teamway.assessctloffivesys.config;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.fusesource.mqtt.client.FutureConnection;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.QoS;
import org.fusesource.mqtt.client.Topic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

import java.util.Properties;
import java.util.concurrent.*;

/**
 * @program: assessctloffivesys
 * @description:
 * @author: liuhanru
 * @create: 2019-05-30 16:09
 **/
@Configuration
@EnableAsync
public class ConfigOfUtil {

    /*@Bean
    public void mqttConsumerConfig(){
        MqttFutureComsumer mqttFutureComsumer = new MqttFutureComsumer();
        mqttFutureComsumer.mqttConsumer();
    }*/
    String json=null;
    private static String urlTcp = "tcp://192.168.0.134:1883";
    //private final static String CONNECTION_STRING = urlTcp;
    private final static String CONNECTION_STRING = urlTcp;
    private final static boolean CLEAN_START = true;
    private final static short KEEP_ALIVE = 30;// 低耗网络，但是又需要及时获取数据，心跳30s
    private final static String CLIENT_ID = "client";

    public static Topic[] topics = {
            new Topic("zhaohongyu", QoS.EXACTLY_ONCE),
            new Topic("tieyue", QoS.AT_LEAST_ONCE),
            new Topic("teamway", QoS.AT_MOST_ONCE) };

    public final static long RECONNECTION_ATTEMPT_MAX = 6;
    public final static long RECONNECTION_DELAY = 2000;

    public final static int SEND_BUFFER_SIZE = 2 * 1024 * 1024;// 发送最大缓冲为2M


    @Value("${collectionData.servers}")
    private  String services;
    @Value("${collectionData.port}")
    private  Integer port;
    @Value("${collectionData.topicName}")
    private  String topicName;

@Bean
@Scope("prototype")
    public FutureConnection mqttConsumer() throws Exception {
    // 创建MQTT对象
    MQTT mqtt = new MQTT();

    // 设置mqtt broker的ip和端口
    mqtt.setHost(CONNECTION_STRING);
    // 连接前清空会话信息
    mqtt.setCleanSession(CLEAN_START);
    // 设置重新连接的次数
    mqtt.setReconnectAttemptsMax(RECONNECTION_ATTEMPT_MAX);
    // 设置重连的间隔时间
    mqtt.setReconnectDelay(RECONNECTION_DELAY);
    // 设置心跳时间
    mqtt.setKeepAlive(KEEP_ALIVE);
    // 设置缓冲的大小
    mqtt.setSendBufferSize(SEND_BUFFER_SIZE);
    //设置客户端id
    mqtt.setClientId(CLIENT_ID);

    // 获取mqtt的连接对象BlockingConnection
    final FutureConnection connection = mqtt.futureConnection();
    connection.connect();
    connection.subscribe(topics);
    return connection;
}

@Bean
public  Producer<String, String> producer(){

    Properties props = new Properties();
    props.clear();
    props.put("bootstrap.servers", services + ':' + port);
    props.put("acks", "1");
    props.put("retry.backoff.ms", 500);
    props.put("retries", 2);
    props.put("batch.size", 16348);
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    Producer<String, String> producer =new KafkaProducer<String, String>(props);

    return producer;
}

    @Bean
    public ExecutorService pool(){
        ExecutorService pool = Executors.newSingleThreadExecutor();
        //ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(9, 10, 30, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<Runnable>());
        return pool;
    }

    //调用持久化服务
    @Bean
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectionRequestTimeout(30 * 1000);
        httpRequestFactory.setConnectTimeout(30 * 3000);
        httpRequestFactory.setReadTimeout(30 * 3000);
        return new RestTemplate(httpRequestFactory);
    }


}