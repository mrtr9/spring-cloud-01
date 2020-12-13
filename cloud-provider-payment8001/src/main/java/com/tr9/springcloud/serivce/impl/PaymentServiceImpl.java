package com.tr9.springcloud.serivce.impl;

import com.tr9.springcloud.dao.PaymentDao;
import com.tr9.springcloud.entities.Payment;
import com.tr9.springcloud.serivce.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
