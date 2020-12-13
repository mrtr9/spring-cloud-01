package com.tr9.springcloud.serivce;

import com.tr9.springcloud.entities.Payment;

public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
