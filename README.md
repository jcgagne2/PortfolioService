Voir la branche `security-session-redis` pour une version avec
- Spring Security
- Session distribuée avec Spring Session + Redis


# Logs et Traces avec Open Telemetry java agent
Ajouter ceci à la ligne de commande (VM options)
```
-javaagent:PortfolioService/ressource/otel/opentelemetry-javaagent.jar
-Dotel.exporter.otlp.endpoint=https://seq.ne.ch/etic/ingest/otlp
-Dotel.exporter.otlp.headers=X-Seq-ApiKey=s3AHtZIKech5pEQvTA1j
-Dotel.logs.exporter=logging-otlp,otlp
-Dotel.traces.exporter=logging-otlp,otlp
-Dotel.metrics.exporter=none
```

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.5.7/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.5.7/maven-plugin/build-image.html)
* [Distributed Tracing Reference Guide](https://docs.micrometer.io/tracing/reference/index.html)
* [Getting Started with Distributed Tracing](https://docs.spring.io/spring-boot/3.5.7/reference/actuator/tracing.html)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/3.5.7/specification/configuration-metadata/annotation-processor.html)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/3.5.7/reference/using/devtools.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.5.7/reference/web/servlet.html)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/3.5.7/reference/web/reactive.html)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)



