package com.archi.training.introspect.shoping.cart.customerservice;

import com.archi.training.introspect.shoping.cart.customerservice.ddl.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/")
public class CustomerServiceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceController.class);

    @Autowired
    private CustomerServiceProvider customerServiceProvider;


    @GetMapping(value = "getAllCustomers", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getAllCustomers() {
         LOGGER.info("[getAllCustomers] [START] Request received to get all customer details");
         List<Customer> customerList = customerServiceProvider.getAllCustomers();
         if(customerList.isEmpty()) {
             LOGGER.info("[getAllCustomers] [END] No registered customers found");
             return new ResponseEntity<>("No Customers Found", HttpStatus.OK);
         } else {
             LOGGER.info("[getAllCustomers] [END] No of customers {}", customerList.size());
             return new ResponseEntity<>(customerList, HttpStatus.OK);
         }
    }

    @GetMapping(value = "getCustomerByName", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getCustomerByName(final @RequestParam String name) {
        LOGGER.info("[getCustomerByName][START] Request received to get customer by Name {}", name);
        try {
            List<Customer> customerList = customerServiceProvider.getCustomerByName(name);
            LOGGER.debug("[getCustomerByName] Customers {}", customerList.toString());
            LOGGER.info("[getCustomerByName][END] Customer found for given id {}", name);
            return new ResponseEntity<>(customerList, HttpStatus.OK);
        } catch (CustomerNotFoundException e) {
            LOGGER.info("[getCustomerByName][END] Customer not found for given id {}", name);
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }


}
