package com.archi.training.introspect.shoping.cart.customerservice.repository;

import com.archi.training.introspect.shoping.cart.customerservice.model.Customer;
import com.archi.training.introspect.shoping.cart.customerservice.util.CustomerStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Component
public class CustomerRepository {

    private static List<Customer> customerList = new ArrayList<>();

    public void save(final Customer customer) {
        customerList.add(customer);
    }


    public List<Customer> getAll() {
        return customerList;
    }


    public List<Customer> getByName(final String name) {
        List<Customer> filteredCustomers = customerList.stream().filter(customer -> customer.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
        return filteredCustomers;
    }


}
