package org.academiadecodigo.bootcamp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CustomerController {

    @RequestMapping(method = RequestMethod.GET, value = "/customer")
    public String doGetCustomer(Model model) {

        // set attributes to the customer
        Customer customer = new Customer();

        customer.setId(1);
        customer.setFirstName("Ze Maria");
        customer.setLastName("DKSG");
        customer.setEmail("zm.dksg@gmail.com");
        customer.setPhone("910521277");

        // add an attribute to the request
        model.addAttribute("customer",customer);

        // return the view name
        return "customer-view";

    }
}
