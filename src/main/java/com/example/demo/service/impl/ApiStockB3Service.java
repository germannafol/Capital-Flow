package com.example.demo.service.impl;

import com.example.demo.components.KafkaProducerComponent;
import com.example.demo.dto.ActionDTO;
import com.example.demo.service.IApiStockB3Service;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiStockB3Service implements IApiStockB3Service {

    // 38 - Injeção da lógica de envio da mensagem como producer do kafka
    @Autowired
    private KafkaProducerComponent kafkaProducerComponent;

    // 40 - Criação do field que recebe o valor do application
    @Value("${kafka.topico-acao-b3}")
    private String topico;

    // 43 - Injeta do application
    @Value("${api.b3.url-base}")
    private String urlApiBase;

    // 33 - Como vai publicar os dados no kafka
    public void updateValueStock(String codeStock) {
        // 34 - Consulta da api - Via criação de uma instância Rest Tempalete
        RestTemplate restTemplate = new RestTemplate();

        // 36 - Usar a biblioteca do google para converter o json para objeto
        Gson gson = new Gson();

        // 35 - Fazer o get na nossa API B3 - recebendo uma String Json
        String json = restTemplate.getForObject(createQueryUrlStock(codeStock), String.class);

        // 37 - Conversão - Observação, a AcaoFavorita é uma classe modelo, não pode ser manipulada, pois tem como foco o banco de dados. Criar DTO para receber os dados externos no lugar
        ActionDTO actionDTO = gson.fromJson(json, ActionDTO.class);

        // 39 - Enviar a mensagem com o objeto e o tópico configurado no application (10-12)
        kafkaProducerComponent.sendMessageCustom(topico, actionDTO);
    }

    // 41 - Criação do métod que captura a url
    private String createQueryUrlStock(String codeStock) {
        return urlApiBase + "/acoes/" + codeStock;
    }
}

