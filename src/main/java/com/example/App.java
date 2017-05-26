package com.example;

import java.net.InetAddress;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/**
 * @author nicola
 * @since 25/05/2017
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Component
    public static class Routes extends RouteBuilder {

        public void configure() throws Exception {

            from("master:mymap:timer:send?period=5000")
                    .setBody().constant(InetAddress.getLocalHost().getHostName())
                    .log("Sending hostname: ${body}")
                    .to("telegram:bots?chatId={{chat-id}}");

        }
    }

}
