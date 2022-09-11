package com.archi.training.introspect.shoping.cart.customerservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerNotFoundException  extends  RuntimeException {

    private String errorCode;
    private String errorText;

}
