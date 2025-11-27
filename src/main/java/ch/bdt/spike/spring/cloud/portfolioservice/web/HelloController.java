package ch.bdt.spike.spring.cloud.portfolioservice.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@Slf4j
public class HelloController {
    @Value("${spring.application.name}")
    private String applicationName;

    @RequestMapping("/")
    public String hello() {
        // On trouve le hostname
        String hostnameFromEnv = System.getenv("HOSTNAME");
        String hostname;
        try {
            hostname = InetAddress.getLocalHost().toString();
        } catch (UnknownHostException aE) {
            hostname = aE.getMessage();
        }
        return "hello from " + applicationName + ", v from env:" + hostnameFromEnv + ", hostname from code: " + hostname;
    }

}
