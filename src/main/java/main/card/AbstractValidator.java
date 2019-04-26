package main.card;

import java.util.Calendar;

import main.controller.ApplicationController;



public abstract class AbstractValidator {

	protected ApplicationController app;

	protected String cardName;
	protected String LongCardNum;
	protected int expiryDateMonth;
	protected int expiryDateYear;
	protected String cvv;

	public AbstractValidator(ApplicationController app, String cardName, String LongCardNum, int expiryDateMonth,
			int expiryDateYear, String cvv) {
		this.app = app;
		this.cardName = cardName;
		this.LongCardNum = LongCardNum;
		this.expiryDateMonth = expiryDateMonth;
		this.expiryDateYear = expiryDateYear;
		this.cvv = cvv;
	}

	public boolean validate() {

		boolean NameValidator = validateCardName();

		if (NameValidator) {

			boolean expiryValidator = validateExpiryDate();

			if (expiryValidator) {
				
				boolean CvvValidator = validateCvv();
				
				if (CvvValidator) {

					boolean cardNumValidator = validateLongCardNumLength();

					if (cardNumValidator) {
						
						boolean LongCardNumFormatValidated = validateLongCardNumFormat();

						if (NameValidator && expiryValidator && cardNumValidator
							&& LongCardNumFormatValidated)
							return true;
						else
							return false;

					}
				}
			}
		}

		return false;

	}

	protected boolean validateCardName() {

		boolean NameError = false;

		if (cardName.length() == 0) {
			NameError = true;
		}

		return !NameError;

	}
	
	protected boolean validateLongCardNumLength() {

		boolean NumError = false;

		if (LongCardNum.length() != 16) {

			NumError = true;

		} else {

			for (int i = 0; i < 16; i++) {

				if (LongCardNum.charAt(i) > '9' || LongCardNum.charAt(i) < '0') {

					NumError = true;

				}
			}
		}

		return !NumError;

	}


	protected boolean validateExpiryDate() {

		boolean DateError = false;

		Calendar Today = Calendar.getInstance();

		int thisMonth = Today.get(Calendar.MONTH) + 1;

		int thisYear = Today.get(Calendar.YEAR);

		if (expiryDateYear < thisYear || (expiryDateYear == thisYear && expiryDateMonth < thisMonth)) {

			DateError = true;

		}

		return !DateError;

	}


	
	protected boolean validateCvv() {

		boolean cvvError = false;

		if (cvv.length() != 3 && cvv.length() != 4) {
			cvvError = true;
		}

		return !cvvError;

	}
	
	protected boolean validateLongCardNumFormat() {

		return false;

	}

}
