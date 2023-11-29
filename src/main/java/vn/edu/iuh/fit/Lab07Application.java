package vn.edu.iuh.fit;

import net.datafaker.Faker;
import net.datafaker.providers.base.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.models.Customer;
import vn.edu.iuh.fit.repositories.CustomerRepository;

@SpringBootApplication
public class Lab07Application {
@Autowired
private CustomerRepository customerRepository;
    public static void main(String[] args) {
        SpringApplication.run(Lab07Application.class, args);
    }

//        @Bean
//           CommandLineRunner createDataCustomer(){
//        return args -> {
//            Faker faker = new Faker();
//          Device devices = faker.device();
//            for (int i = 0; i < 200; i++) {
//                Customer customer =  new Customer(
//                        devices.modelName(),
//                        faker.lorem().paragraph(30),devices.
//                );
//                customerRepository.save(customer);
//            }
//        };
//        }
}
