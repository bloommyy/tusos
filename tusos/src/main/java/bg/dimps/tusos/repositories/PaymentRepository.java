package bg.dimps.tusos.repositories;

import bg.dimps.tusos.payment.BasePayment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<BasePayment,Long> {
    List<BasePayment> findByPaymentId(long paymentId);
}
