
package com.springboot.server;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(
        name = "payment.provider",
        havingValue = "razorpay",
        matchIfMissing = true
)
public class RazorpayPayment implements PaymentService {

    @Override
    public String pay() {
        return "Razorpay Payment Done";
    }

    @Override
    public String transaction() {
        return "Razorpay Transaction Done";
    }

    @Override
    public String refund() {
        return "Razorpay Refund Done";
    }
}
