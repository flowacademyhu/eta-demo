package hu.flowacademy.eta.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController // we use it instead of @Controller, we don't want to use view resolver and xml
@RequestMapping("/api") // it sets the base context path e.g.: localhost:8080/api
public class OurFirstResource {

    // example for data storage
    List<Object> list = new ArrayList<>();

    /**
     * listens on GET requests in /api/ path
     *
     * @return the whole list with actual values
     */
    @GetMapping("/")
    public List<Object> getList() {
        return list;
    }

    /**
     * listens on GET requests in /api/{id} path
     *
     * @param id is an index of the list
     * @return the exact element of list by index
     */
    @GetMapping("/{id}")
    public Object getListIndex(@PathVariable int id) {
        return list.get(id);
    }

    /**
     * listens on POST requests in /api/ path
     *
     * @param o is a basic JSON object representation
     * @return the created object
     */
    @PostMapping("/")
    public Object createNew(@RequestBody Map<String, Object> o) {
        list.add(o);
        return ResponseEntity.ok(o);
    }

    /**
     * listens on PUT requests in /api/{id} path
     *
     * @param id the index of the changeable element
     * @param o the new value of the element
     * @return the new value
     */
    @PutMapping("/{id}")
    public Object update(@PathVariable int id, @RequestBody Map<String, Object> o) {
        list.remove(id);
        list.add(o);
        return o;
    }

    /**
     * listens on GET requests in /api/{id} path
     *
     * @param id is an index of the list which will remove
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        list.remove(id);
    }

}
