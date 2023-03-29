package com.mapr.demo.mqtt.simple;

import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.nio.charset.StandardCharsets;

public class Subscriber {

  public static void main(String[] args) throws MqttException {

    System.out.println("== START SUBSCRIBER ==");

    MqttClient client=new MqttClient("tcp://172.20.10.2:1883", MqttClient.generateClientId());
    client.connect();
    client.subscribe("iot_data", new IMqttMessageListener() {
      @Override
      /**
       * mqttMessage - мои данные
       */
      public void messageArrived(String s, MqttMessage mqttMessage) {
        System.out.println(new String(mqttMessage.getPayload(), StandardCharsets.UTF_8));
      }
    });

  }

}
