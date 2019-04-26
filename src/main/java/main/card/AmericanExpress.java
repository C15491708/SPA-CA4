package main.card;

import main.controller.ApplicationController;

public class AmericanExpress extends AbstractValidator {

	public AmericanExpress(ApplicationController app, String cardName, String LongCardNum, int expiryDateMonth,
			int expiryDateYear, String cvv) {

		super(app, cardName, LongCardNum, expiryDateMonth, expiryDateYear, cvv);

	}

	

	protected boolean validateLongCardNumLength() {

		boolean NumError = false;

		if (LongCardNum.length() != 15 ) {
			if(LongCardNum.length() != 16) {
				NumError = true;
			}

		} else {

			for (int i = 0; i < LongCardNum.length(); i++) {

				if (LongCardNum.charAt(i) > '9' || LongCardNum.charAt(i) < '0') {
					NumError = true;

				}

			}

		}

		return !NumError;
	}

	protected boolean validateLongCardNumFormat() {


		boolean FormatError = false;

		if (LongCardNum.charAt(0) == '3' && (LongCardNum.charAt(1) == '4' || LongCardNum.charAt(1) == '5')) {

		} else {

			FormatError = true;

		}

		return !FormatError;

	}

}
