package com.shenzhen.teamway.assessctloffivesys;

import com.shenzhen.teamway.assessctloffivesys.mqttconsumer.MqttFutureComsumer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssessctloffivesysApplication implements CommandLineRunner {

    private Logger logger = Logger.getLogger(AssessctloffivesysApplication.class);

    @Autowired
    private MqttFutureComsumer mqttFutureComsumer;

    public static void main(String[] args) {

        SpringApplication.run(AssessctloffivesysApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        mqttFutureComsumer.mqttConsumer();

    }
}
