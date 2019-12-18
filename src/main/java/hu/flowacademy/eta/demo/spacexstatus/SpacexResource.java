package hu.flowacademy.eta.demo.spacexstatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/spacex")
public class SpacexResource {

    @Autowired
    private SpacexService spacexService;

    @GetMapping("/")
    public List<Rocket> getRockets() {
        return spacexService.getRockets();
    }

}
