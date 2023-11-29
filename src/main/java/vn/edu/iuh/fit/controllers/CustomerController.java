package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vn.edu.iuh.fit.models.Customer;
import vn.edu.iuh.fit.repositories.CustomerRepository;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
  private  String  showCustomerList(Model model){
        model.addAttribute("customerPage",customerRepository.findAll());
        //tra ve trang web
        return "customer/list";
    }

    @GetMapping ("/customers/show-add-form")
    public String addCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customerAdd",customer);
        return "customer/add";
    }
    @PostMapping("/customers/add")
    public String add(
            @ModelAttribute("customerAdd")    Customer customer,
            BindingResult result , Model model) {
            customerRepository.save(customer);
        return "redirect:/customers";
    }
    @GetMapping ("/customers/delete/{id}")
    public String deleteCustomer(@PathVariable("id") long id) {
        Customer customer = customerRepository.findById(id).orElse(new Customer());
        customerRepository.delete(customer);
        return "redirect:/customers";
    }
    @GetMapping("/customers/show-edit-form/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Customer customer = customerRepository.findById(id).orElse(null);
        model.addAttribute("customerUpdate", customer);
        return "customer/update"; // Trả về view hiển thị form cập nhật thông tin khách hàng
    }
    @PostMapping("/customers/update/{id}")
    public String updateCustomer(@PathVariable("id") long id,
                                 @ModelAttribute("customerUpdate")  Customer updatedCustomer) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            customer.setName(updatedCustomer.getName());
            customer.setEmail(updatedCustomer.getEmail());
            customer.setAddress(updatedCustomer.getAddress());
            customer.setPhone(updatedCustomer.getPhone());

            customerRepository.save(customer);
        }
        return "redirect:/customers";
    }


}
