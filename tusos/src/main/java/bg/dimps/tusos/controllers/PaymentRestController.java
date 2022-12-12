package bg.dimps.tusos.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bg.dimps.tusos.payment.BasePayment;
import bg.dimps.tusos.payment.PaymentMethod;
import bg.dimps.tusos.repositories.PaymentRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/doPay")
public class PaymentRestController {

    private final PaymentRepository paymentRepo;

    public PaymentRestController(PaymentRepository paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    @GetMapping("/do")
    public String doPay(long paymentId, float sum, PaymentMethod paymentMethod){
        return "";
    }

  
}
