package com.tr9.springcloud.loadbalanced;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface Loadbalanced {

    ServiceInstance serviceInstance(List<ServiceInstance> serviceInstances);
}
