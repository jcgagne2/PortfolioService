package ch.bdt.spike.spring.cloud.portfolioservice;

import ch.bdt.spike.spring.cloud.portfolioservice.service.MyObservedService;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ObservedAspectTest {

    @Autowired
    MyObservedService myObservedService;

    @Autowired
    ObservationRegistry registry;

    @Test
    void testObservedAspectWorks() {
        System.out.println("Before calling getPositionCount");
        myObservedService.sayHello();
        System.out.println("After calling getPositionCount");

        // Affiche les observations enregistrées
        Observation vCurrentObservation = registry.getCurrentObservation();
        assertNotNull(vCurrentObservation);
        vCurrentObservation.getContext().getName();
        System.out.println(vCurrentObservation.getContext().getName());
    }
}
