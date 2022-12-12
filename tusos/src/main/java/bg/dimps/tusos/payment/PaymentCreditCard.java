package bg.dimps.tusos.payment;

public class PaymentCreditCard extends BasePayment{

	public PaymentCreditCard(long paymentId) {
		super(paymentId);
	}
	
	@Override
	public PaymentMethod getPaymentMethod() {
		return PaymentMethod.CREDITCARD;
	}

}
