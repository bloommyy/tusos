package bg.dimps.tusos.payment;

import static org.junit.Assert.fail;

import java.util.Calendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bg.dimps.tusos.payment.PaymentCreditCard;
import bg.dimps.tusos.payment.PaymentEasyPay;
import bg.dimps.tusos.payment.PaymentIBAN;
import bg.dimps.tusos.payment.SOSPayment;

class SOSPaymentTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testPayByEasyPay() {
		PaymentEasyPay paymentEasy = new PaymentEasyPay(0);
		paymentEasy.setSum(25.37f);

	}

	@Test
	void testPayByCreditCard() {
		PaymentCreditCard paymentCredit = new PaymentCreditCard(0);
		paymentCredit.setSum(25.37f);
		SOSPayment sos = new SOSPayment();
		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR, 2025);
		date.set(Calendar.MONTH, 7);
		boolean valid = sos.payByCreditCard(paymentCredit, "4444 4444 4444 4444", 345, "marian", date.getTime());
		if (!valid) {
			fail("failed to pay with Visa");
		}
		valid = sos.payByCreditCard(paymentCredit, "5244 4444 4444 4444", 345, "marian", date.getTime());
		if (!valid) {
			fail("failed to pay with Master Card");
		}
		date.set(Calendar.YEAR, 2021);
		valid = sos.payByCreditCard(paymentCredit, "5244 4444 4444 4444", 345, "marian", date.getTime());
		if (valid) {
			fail("possible to pay with expired Master Card");
		}
	}

	@Test
	void testPayByIBAN() {
		PaymentIBAN paymentIBAN = new PaymentIBAN(0);
		paymentIBAN.setSum(25.37f);

	}

}
