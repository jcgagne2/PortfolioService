package ch.bdt.spike.spring.cloud.portfolioservice;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@Slf4j
public class ObservedAspectConfig {
    @Bean
    public ObservedAspect observedAspect(ObservationRegistry observationRegistry) {
        log.info("installing ObservedAspectConfig");
        return new ObservedAspect(observationRegistry);
    }
}