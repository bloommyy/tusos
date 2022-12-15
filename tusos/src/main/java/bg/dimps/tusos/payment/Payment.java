package bg.dimps.tusos.payment;

public interface Payment {
	public float getSum(); 
	public PaymentMethod getPaymentMethod();
	public void setSum(float sum);
	
}
