package bg.dimps.tusos.payment;

public class PaymentEasyPay extends BasePayment{

	public PaymentEasyPay(long paymentId) {
		super(paymentId);
	}
	
	@Override
	public PaymentMethod getPaymentMethod() {
		return PaymentMethod.EASYPAY;
	}

}
