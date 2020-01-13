package hu.flowacademy.eta.demo.timeoff.service;

import hu.flowacademy.eta.demo.timeoff.model.Holiday;
import hu.flowacademy.eta.demo.timeoff.model.User;
import hu.flowacademy.eta.demo.timeoff.model.dto.HolidayDTO;
import hu.flowacademy.eta.demo.timeoff.repository.HolidayRepository;
import hu.flowacademy.eta.demo.timeoff.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class HolidayService {
    private HolidayRepository holidayRepository;
    private UserRepository userRepository;

    public void addHoliday(HolidayDTO holidayDTO) {
        // TODO: investigate ModelMapper to replace this stuff, or encapsulate logic in HolidayDTO with a toHoliday() method
        Holiday holiday = new Holiday();
        holiday.setStartDate(holidayDTO.getStartDate());
        holiday.setEndDate(holidayDTO.getEndDate());
        holiday.setStatus("PENDING"); // TODO: use enum here
        holiday.setType(holidayDTO.getType()); // TODO: same here

        Optional<User> u = userRepository.findById(holidayDTO.getUserId()); // TODO: Optional error handling

        if(u.isPresent()) {
            // Bind holiday with user
            holiday.setUser(u.get());
            holidayRepository.save(holiday);
            // TODO: decrement available holidays count (create AvailableHolidaysRepository, modify object)
        } else {
            throw new RuntimeException("User cannot be found."); // TODO: proper error handling
        }
    }
}
