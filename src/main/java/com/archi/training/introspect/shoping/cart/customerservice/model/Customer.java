package com.archi.training.introspect.shoping.cart.customerservice.model;

import com.archi.training.introspect.shoping.cart.customerservice.util.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private String address;
    private String billingAddress;
    private String email;
    private String contactNumber;
    private CustomerStatus status;
}
