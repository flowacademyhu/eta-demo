package hu.flowacademy.eta.demo.funwithbeans;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fun2")
public class AnotherCreativeResource {

    private final BasicSingletonBean basicSingletonBean;
    private final AlwaysNewInstance alwaysNewInstance;

    public AnotherCreativeResource(BasicSingletonBean basicSingletonBean, AlwaysNewInstance alwaysNewInstance) {
        this.basicSingletonBean = basicSingletonBean;
        this.alwaysNewInstance = alwaysNewInstance;
    }

    @GetMapping("/basic")
    public int getBasicCount() {
        return BasicSingletonBean.getCounter();
    }

    @GetMapping("/alwaysnew")
    public int getAlwaysnew() {
        return AlwaysNewInstance.getCounter();
    }

    @GetMapping("/request")
    public int getReq(RequestScopeBean requestScopeBean) {
        return requestScopeBean.getCounter();
    }
}
