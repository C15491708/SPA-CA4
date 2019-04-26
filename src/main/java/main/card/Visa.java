package main.card;

import main.controller.ApplicationController;

public class Visa extends AbstractValidator {

	public Visa(ApplicationController app, String cardName, String LongCardNum, int expiryDateMonth,
			int expiryDateYear, String cvv) {

		super(app, cardName, LongCardNum, expiryDateMonth, expiryDateYear, cvv);

	}



	protected boolean validateLongCardNumFormat() {



		boolean FormatError = false;

		if (LongCardNum.charAt(0) != '7') {

			FormatError = true;									

		}
		else {


		}

		return !FormatError;

	}

}
