package hu.flowacademy.eta.demo.config.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    public static org.springframework.security.core.userdetails.User toAuthUser(User user) {
        return new org.springframework.security.core.userdetails.User(user.getPassword(), user.getPassword(), List.of(user.getRole().toGrantedAuthority()));
    }
}
