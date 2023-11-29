package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.Customer;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.repositories.CustomerRepository;


import java.util.List;

@Service
public class CustomerServices {
    @Autowired
    private CustomerRepository repository;
    public List<Customer> findCusByName(String name){
        return repository.getCusByNameIndexParam(name);
    }
}
