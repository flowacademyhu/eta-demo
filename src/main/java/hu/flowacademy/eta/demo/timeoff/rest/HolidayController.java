package hu.flowacademy.eta.demo.timeoff.rest;

import hu.flowacademy.eta.demo.timeoff.model.Holiday;
import hu.flowacademy.eta.demo.timeoff.model.dto.HolidayDTO;
import hu.flowacademy.eta.demo.timeoff.service.HolidayService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.patterns.DeclareTypeErrorOrWarning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j // Logger log = LoggerFactory.getLogger(<>.class);
@AllArgsConstructor
public class HolidayController {
    private HolidayService holidayService;

    // TODO: error handling
    // TODO: proper return values
    @PostMapping("/holiday")
    public void addHoliday(@RequestBody HolidayDTO holidayDTO) {
        log.info("Holiday DTO: {}", holidayDTO);
        holidayService.addHoliday(holidayDTO);
    }
}
