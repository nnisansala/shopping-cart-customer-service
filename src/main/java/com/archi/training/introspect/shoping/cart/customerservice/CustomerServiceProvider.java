package com.archi.training.introspect.shoping.cart.customerservice;

import com.archi.training.introspect.shoping.cart.customerservice.ddl.Customer;
import com.archi.training.introspect.shoping.cart.customerservice.repository.CustomerRepository;
import com.archi.training.introspect.shoping.cart.customerservice.util.CustomerStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerServiceProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceProvider.class);

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        LOGGER.debug("[getAllCustomers] Querying to get all active and suspended customers");
        final List<com.archi.training.introspect.shoping.cart.customerservice.model.Customer> customersFromDb = customerRepository.getAll();
        LOGGER.debug("[getAllCustomers] Querying completed and {} customers found", customersFromDb.size());
        return customersFromDb.stream().map(cust->new Customer(cust.getId(), cust.getName(),  cust.getAddress(), cust.getBillingAddress(), cust.getEmail(), cust.getContactNumber(),
                CustomerStatus.ACTIVE.equals(cust.getStatus()) ? true: false))
                .collect(Collectors.toList());

    }


    public List<Customer> getCustomerByName(final String name) {
        LOGGER.debug("[getCustomerByName] Querying to get customers by name {}", name);
        final List<com.archi.training.introspect.shoping.cart.customerservice.model.Customer> customersFromDb = customerRepository.getByName(name);
        if (!customersFromDb.isEmpty()) {
            LOGGER.debug("[getCustomerByName] Querying completed for customer with name {}", name);
            return customersFromDb.stream().map(cust->new Customer(cust.getId(), cust.getName(),  cust.getAddress(), cust.getBillingAddress(), cust.getEmail(), cust.getContactNumber(),
                    CustomerStatus.ACTIVE.equals(cust.getStatus()) ? true: false))
                    .collect(Collectors.toList());
        }
        throw new CustomerNotFoundException("SVC0001", "Customers not found for given name");
    }
}
