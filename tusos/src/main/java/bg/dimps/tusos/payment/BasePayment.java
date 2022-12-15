package bg.dimps.tusos.payment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name = "payment")
public class BasePayment implements Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	protected long paymentId;
	protected float sum;
	protected PaymentMethod paymentMethod;

	public Long getId() {
		return paymentId;
	}

	public void setId(Long id) {
		this.paymentId = id;
	}

	public BasePayment(long paymentId) {
		this.paymentId = paymentId;
		paymentMethod = PaymentMethod.NONE;
	}

	public BasePayment(float sum, PaymentMethod paymentMethod) {
		super();
		this.sum = sum;
		this.paymentMethod = paymentMethod;
	}

	public void setSum(float sum) {
		this.sum = sum;
	}

	@Override
	public float getSum() {
		return sum;
	}

	@Override
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}
	
}
