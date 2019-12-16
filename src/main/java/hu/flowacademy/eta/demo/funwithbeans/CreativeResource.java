package hu.flowacademy.eta.demo.funwithbeans;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fun")
public class CreativeResource {

    private final BasicSingletonBean basicSingletonBean;
    private final AlwaysNewInstance alwaysNewInstance;
    private final RequestScopeBean requestScopeBean;

    public CreativeResource(BasicSingletonBean basicSingletonBean, AlwaysNewInstance alwaysNewInstance, RequestScopeBean requestScopeBean) {
        this.basicSingletonBean = basicSingletonBean;
        this.alwaysNewInstance = alwaysNewInstance;
        this.requestScopeBean = requestScopeBean;
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
    public int getReq() {
        return RequestScopeBean.getCounter();
    }
}
