package com.archi.training.introspect.shoping.cart.customerservice;

import com.archi.training.introspect.shoping.cart.customerservice.model.Customer;
import com.archi.training.introspect.shoping.cart.customerservice.repository.CustomerRepository;
import com.archi.training.introspect.shoping.cart.customerservice.util.CustomerStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class CustomerServiceApplication {

    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }


    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            customerRepository.save(new Customer(Math.abs(new Random().nextLong()), "Hirusha Minal", "No 05, 1st Lane, Issadeen Town, Matara, Sri Lanka",  "No 05, 1st Lane, Issadeen Town, Matara, Sri Lanka", "hiru@hotmail.com", "+94412234567", CustomerStatus.ACTIVE));
            customerRepository.save(new Customer(Math.abs(new Random().nextLong()), "Pramudi Pravindya", "No 42, Janatha Mawatha, Colombo 04, Sri Lanka",  "No 38, Nawinna, Maharagama, Sri Lanka", "pramupl@gmail.com", "+9411224875", CustomerStatus.REGISTERED));
            customerRepository.save(new Customer(Math.abs(new Random().nextLong()), "Lakshmi Rishal", "No 123B, Mumbai, India",  "No 123B, Mumbai, India", "lrishal@hotmail.com", "+91212234567", CustomerStatus.ACTIVE));
            customerRepository.save(new Customer(Math.abs(new Random().nextLong()), "John Kane", "No 38, Park Street, New York, US",  "No 38, Park Street, New York, US", "johnk@gmail.com", "+1111224875", CustomerStatus.SUSPEND));
            customerRepository.save(new Customer(Math.abs(new Random().nextLong()), "Minoj Rishal", "No 7/21, Chennai, India",  "No 89, Cross street, Mumbai, India", "minojv@gmail.com", "+91908765478", CustomerStatus.ACTIVE));

        };
    }
}


