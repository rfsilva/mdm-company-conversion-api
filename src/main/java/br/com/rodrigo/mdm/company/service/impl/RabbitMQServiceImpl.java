package br.com.rodrigo.mdm.company.service.impl;

import br.com.rodrigo.mdm.company.config.*;
import br.com.rodrigo.mdm.company.service.*;
import lombok.extern.slf4j.*;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.*;

@Service
@Slf4j
public class RabbitMQServiceImpl implements RabbitMQService {

    @Override
    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receive(String message) {
        log.info("Mensagem recebida: {}", message);
    }
}
