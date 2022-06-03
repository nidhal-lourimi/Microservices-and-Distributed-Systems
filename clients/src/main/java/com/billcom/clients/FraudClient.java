package com.billcom.clients;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
@FeignClient(
        value = "fraud",
        path = "api/v1/fraud-check"
)
public interface FraudClient {
}
*/
 /** another way */
@FeignClient("fraud")

public interface FraudClient {

     @GetMapping(path = "api/v1/fraud-check/{customerId}")
    FraudCheckResponse isFraudster (
             @PathVariable("customerId") Integer customerID);


}

