package bg.dimps.tusos.payment;

import java.util.Date;

public class SOSPayment {

	public boolean payByEasyPay(Payment id) {
		return false;
	}

	// VISA starts with 4, master card with 51-55
	public boolean payByCreditCard(Payment id, String creditCardNumber, int cvc, String nameOnCard, Date expireDate) {
		creditCardNumber = creditCardNumber.replace(" ", "");
		
		if (creditCardNumber.matches("^(?:4[0-9]{12}(?:[0-9]{3})?|(?:5[1-5][0-9]{2}|222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12})$")) {
			int expireMonth = expireDate.getMonth();
			int expireYear = expireDate.getYear();
			Date now = new Date();
			int nowMonth = now.getMonth();
			int nowYear = now.getYear();
 			if(nowYear < expireYear || (nowYear == expireYear && nowMonth <= expireMonth)) {
 				return true;
 			}
		}
		return false;
	}

	// The IBAN number consists of a two-letter country code, followed by two check
	// digits, and up to thirty-five alphanumeric characters. These alphanumeric
	// characters are known as the basic bank account number (BBAN).
	public boolean payByIBAN(Payment id, String bac, String iban) {
		return false;
	}
}
