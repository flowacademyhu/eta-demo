package hu.flowacademy.eta.demo.funwithbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class FunWithBeans {

    @Bean
    public BasicSingletonBean basicSingletonBean() {
        return new BasicSingletonBean();
    }

    @Bean
    @Scope("prototype")
    public AlwaysNewInstance alwaysNewInstance() {
        return new AlwaysNewInstance();
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public RequestScopeBean requestScopeBean() {
        return new RequestScopeBean();
    }

}
