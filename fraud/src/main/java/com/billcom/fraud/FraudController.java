package com.billcom.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@Slf4j
@RequestMapping("api/v1/fraud-check")
public class FraudController {


    @Autowired
    private final FraudCheckHistoryService fraudCheckHistoryService;

    @GetMapping(path ="{customerId}")
    public FraudCheckResponse isFraudster(
            @PathVariable("customerId") Integer customerId){
        Boolean isFraudulentCustomer = fraudCheckHistoryService.isFraudulentCustomer(customerId);
        log.info("fraud check request for customer {}",customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}

