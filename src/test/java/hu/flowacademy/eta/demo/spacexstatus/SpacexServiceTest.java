package hu.flowacademy.eta.demo.spacexstatus;

import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.List;

import static org.junit.Assert.*;

public class SpacexServiceTest {

    SpacexService spacexService = new SpacexService();

    @Test
    public void getRockets() {
        List<Rocket> rockets = spacexService.getRockets();
        assertEquals(rockets.size(),4);
    }
}