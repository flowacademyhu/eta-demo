package hu.flowacademy.eta.demo.timeoff.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Data
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String username;
    private String password;
    private String role; // TODO: more sophisticated with enum

    @ManyToOne
    @JoinColumn
    private User boss;

    @OneToOne(cascade = CascadeType.PERSIST)
    private AvailableHolidays availableHolidays;
}
