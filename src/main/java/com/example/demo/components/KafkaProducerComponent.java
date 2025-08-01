package com.example.demo.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerComponent {
    private KafkaTemplate<String, String> kafkaTemplate;
    private KafkaTemplate<String, Object> customKafkaTemplate;

    // 7 - Construtor que vai ser injetado no kafkaTemplate
    @Autowired
    public KafkaProducerComponent(
            KafkaTemplate<String, String> kafkaTemplate,
            KafkaTemplate<String, Object> customKafkaTemplate
    ){
        this.kafkaTemplate = kafkaTemplate;
        this.customKafkaTemplate = customKafkaTemplate;
    }

    // 8 - Esse formato não vai ser usado, pois segue o padrão String, String
    public void sendMessage(String topicMessage, String topicName) {
        kafkaTemplate.send(topicName, topicMessage);
    }

    // 9 - Recebe um objeto e publica um Json no tópico referenciado
    public void sendMessageCustom(String topicName, Object topicMessage ){
        customKafkaTemplate.send(topicName, topicMessage);
    }
}
