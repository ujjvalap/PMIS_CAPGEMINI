
package com.springboot.server;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(
        name = "payment.provider",
        havingValue = "stripe"
)
public class StripePaymentService implements PaymentService {

    @Override
    public String pay() {
        return "Stripe Payment Done";
    }

    @Override
    public String transaction() {
        return "Stripe Transaction Done";
    }

    @Override
    public String refund() {
        return "Stripe Refund Done";
    }
}
