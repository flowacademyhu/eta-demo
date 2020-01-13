package hu.flowacademy.eta.demo.timeoff.repository;

import hu.flowacademy.eta.demo.timeoff.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
