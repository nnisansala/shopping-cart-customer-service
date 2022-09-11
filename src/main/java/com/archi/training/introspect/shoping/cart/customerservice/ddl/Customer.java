package com.archi.training.introspect.shoping.cart.customerservice.ddl;

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
    private boolean active;

    @Override
    public String toString() {
        return "Customer [id=" + id + ", Name=" + name + ", Address=" + address + ", Billing Address="
                + billingAddress + ", Email=" + email + ", Contact Number=" + contactNumber + ", Is Active= " + active+"]";
    }
}
