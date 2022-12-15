package bg.dimps.tusos.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bg.dimps.tusos.payment.BasePayment;
import bg.dimps.tusos.payment.Payment;
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
	public String loadPayment(@RequestParam(defaultValue = "0") float sum, Model model, HttpSession session) {
		System.out.println("sum= " + sum);
		Payment payment = new BasePayment(0);
		payment.setSum(sum);
		model.addAttribute(payment);
		return "payment";
	}

	@ResponseBody
	@GetMapping("/pay")
	public String doPayment() {
		return "doPayment";
	}

}
