package hu.flowacademy.eta.demo.config.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum Role {

    USER{
        @Override
        public GrantedAuthority toGrantedAuthority() {
            return new SimpleGrantedAuthority(this.name());
        }
    }, MODERATOR {
        @Override
        public GrantedAuthority toGrantedAuthority() {
            return new SimpleGrantedAuthority(this.name());
        }
    }, ADMIN {
        @Override
        public GrantedAuthority toGrantedAuthority() {
            return new SimpleGrantedAuthority(this.name());
        }
    };

    public abstract GrantedAuthority toGrantedAuthority();

}
