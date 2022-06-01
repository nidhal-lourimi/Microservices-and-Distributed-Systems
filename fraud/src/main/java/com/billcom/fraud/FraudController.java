package com.billcom.fraud;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudController {


    @Autowired
    private final FraudCheckHistoryService fraudCheckHistoryService;

    @GetMapping(path ="customerId" )
    public FraudCheckResponse isFraudster(
            @PathVariable("customerId") Integer customerId){
        Boolean isFraudulentCustomer = fraudCheckHistoryService.isFraudulentCustomer(customerId);

        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
