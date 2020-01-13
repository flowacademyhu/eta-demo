package hu.flowacademy.eta.demo.timeoff.repository;

import hu.flowacademy.eta.demo.timeoff.model.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidayRepository extends JpaRepository<Holiday, Long> {
}
