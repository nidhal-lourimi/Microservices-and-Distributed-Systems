package com.billcom.customer;


import com.billcom.clients.FraudCheckResponse;
import com.billcom.clients.FraudClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Service
public final class CustomerService {
    private final CustomerRepository customerRepository;

    /*private final RestTemplate restTemplate;*/
     private final FraudClient fraudClient;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);
        /** rest template */
        /*FraudCheckResponse fraudCheckResponse = restTemplate
                .getForObject("http://FRAUD/api/v1/fraud-check/{customerId}",
                        FraudCheckResponse.class,
                        customer.getId());*/
        /** open OpenFeign/*/
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
        if (fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }

    }

}
