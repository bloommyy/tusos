package bg.dimps.tusos.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import bg.dimps.tusos.payment.BasePayment;
import bg.dimps.tusos.repositories.PaymentRepository;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentRepository paymentRepo;

    public PaymentController(PaymentRepository paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    @GetMapping("/load")
    public String loadPayment(){
        return "payment";
    }

  
}
