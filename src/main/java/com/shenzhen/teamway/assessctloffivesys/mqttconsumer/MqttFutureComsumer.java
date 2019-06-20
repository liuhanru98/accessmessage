package com.shenzhen.teamway.assessctloffivesys.mqttconsumer;

import com.alibaba.fastjson.JSONObject;
import com.shenzhen.teamway.assessctloffivesys.model.*;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.Logger;
import org.fusesource.mqtt.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;


/**
 * @program: fusesourcemqttdemo
 * @description:
 * @author: liuhanru
 * @create: 2019-05-28 15:42
 **/
@Service
public class MqttFutureComsumer {

    private static Logger logger = Logger.getLogger(MqttFutureComsumer.class);

    @Autowired
    private FutureConnection connection;
    @Autowired
    private Producer<String, String> producer;

    @Autowired
    private ExecutorService pool;

    private boolean flagThread = true;

    private String topicName = "mqttkafka";
    //private String topicName1 = "resourceTopic";

    @Autowired
    private RestTemplate restTemplate;

    private String urlRest = "http://192.168.0.127:8080";
    private String urlRest1 = "http://192.168.12.220:8888";


    @Async("pool")
    public void mqttConsumer() throws Exception{
            int count = 0;
            while (flagThread) {
        //for(int i = 0; i < 3; i++){
            count++;
            //接收消息内容的内容
            Future<Message> futrueMessage = connection.receive();
            Message message = futrueMessage.await();
            byte[] payload = message.getPayload();

            //将收到的消息转成实体对象
            String json = new String(payload);
            AccessMessage accessMessage = JSONObject.parseObject(json, AccessMessage.class);
            Payload payloadInfo = accessMessage.getPayload();
            GatewayInfo gatewayInfo = accessMessage.getGatewayInfo();
            HostInfo hostInfo = accessMessage.getHostInfo();
            ChannelInfo channelInfo = accessMessage.getChannelInfo();

            //将需要持久化的消息存入数据库
            try {
                restTemplate.postForEntity(urlRest + "/insert", json, String.class);
                restTemplate.postForEntity(urlRest1 + "/save", json, String.class);
                logger.info("======================调用服务成功并成功存入数据=======================");
            }catch (Exception e){
                e.printStackTrace();
            }

            //将收到的图片信息转换成图片
                /*FileOutputStream fos = new FileOutputStream("D:\\test\\teamway\\testChange"+count+".jpg"); //change path of image according to you
                byteArray = Base64.decodeBase64(new String(payload));
                fos.write(byteArray);*/

            // 往kafka服务器发送消息
            producer.send(new ProducerRecord<>(topicName, "1",json));
            //producer.send(new ProducerRecord<>(topicName1, "1","+++++++++++++++++++++hello world+++++++++++++++++++"));

            logger.info("MQTTClient Message  Count:"+count+"  Topic="+message.getTopic()+" Content :"+json);
            //logger.info("MQTTClient Message  Count:"+count+"  Topic="+message.getTopic()+" Content :"+"  DoorId:"+accessctrInfo.getDoorId()+"  DoorName:"+accessctrInfo.getDoorName()+"  UserName:"+accessctrInfo.getUserName());
            //签收消息的回执
            message.ack();
        }

    }
}