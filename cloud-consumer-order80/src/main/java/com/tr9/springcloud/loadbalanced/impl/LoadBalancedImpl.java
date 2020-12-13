package com.tr9.springcloud.loadbalanced.impl;

import com.tr9.springcloud.loadbalanced.Loadbalanced;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class LoadBalancedImpl implements Loadbalanced {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current, next;

        do {
            current = this.atomicInteger.get();
            System.out.println("AtomicInteger:" + atomicInteger);
            System.out.println("current:" + current);
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
            System.out.println("next:" + next);
        } while (!this.atomicInteger.compareAndSet(current, next));

        System.out.println("AtomicInteger:" + atomicInteger);
        System.out.println("*****第" + next + "次访问*****");
        return next;
    }

    @Override
    public ServiceInstance serviceInstance(List<ServiceInstance> serviceInstances) {

        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
