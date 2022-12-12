package bg.dimps.tusos.payment;

public class PaymentIBAN extends BasePayment{

	public PaymentIBAN(long paymentId) {
		super(paymentId);
	}
	
	@Override
	public PaymentMethod getPaymentMethod() {
		return PaymentMethod.IBAN;
	}

}
