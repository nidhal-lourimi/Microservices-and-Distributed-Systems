package com.billcom.clients;

public record NotificationRequest( Integer toCustomerId,
                                   String toCustomerEmail,
                                   String message) {
}
