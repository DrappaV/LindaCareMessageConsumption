package com.lindacare.messageconsumption.jms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

@Configuration
public class JmsConnectionFactoryConfig {
    @Value("${jsa.activemq.broker.url}")
	String brokerUrl;

    @Value("${jsa.activemq.borker.username}")
	String userName;

    @Value("${jsa.activemq.borker.password}")
	String password;

/*
 * Initial ConnectionFactory
 */
@Bean
public ConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(brokerUrl);
        connectionFactory.setUserName(userName);
        connectionFactory.setPassword(password);
        return connectionFactory;
        }


@Bean
public JmsTemplate jmsTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        return template;
        }
}