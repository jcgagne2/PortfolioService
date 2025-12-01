package ch.bdt.spike.spring.cloud.portfolioservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@Slf4j
public class PortfolioServiceApplication {

    // On ajoute un runner
    @Bean
    public CommandLineRunner applicationRunner(@Value("${spring.application.version}") String version) {
        return args -> {
            log.info("PortfolioServiceApplication started, v" + version);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(PortfolioServiceApplication.class, args);
    }

}
