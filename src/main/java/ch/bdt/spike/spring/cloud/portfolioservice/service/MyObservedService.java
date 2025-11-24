package ch.bdt.spike.spring.cloud.portfolioservice.service;

import io.micrometer.observation.annotation.Observed;
import org.springframework.stereotype.Service;

@Service
public class MyObservedService {

    @Observed(name = "my sayHello", contextualName = "MyObservedService.sayHello")
    public String sayHello() {
        return "Hello World";
    }
}
