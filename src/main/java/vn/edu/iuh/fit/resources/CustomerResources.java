package vn.edu.iuh.fit.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.models.Customer;
import vn.edu.iuh.fit.services.CustomerServices;

import java.util.List;

//@RestController
public class CustomerResources {
   // @Autowired
    private CustomerServices services;
    @GetMapping("/api/v1/health")
    public ResponseEntity<String> heartbeat(){
        return ResponseEntity.ok("live");
    }

    @GetMapping("/api/v1/search/{name}")
    public List<Customer> findCustomerByName(@PathVariable("name") String name){
        return services.findCusByName(name);
    }
}
