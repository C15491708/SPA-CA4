package main.card;

import main.controller.ApplicationController;

public class MasterCard extends AbstractValidator {

	public MasterCard(ApplicationController app, String cardName, String LongCardNum, int expiryDateMonth,
			int expiryDateYear, String cvv) {

		super(app, cardName, LongCardNum, expiryDateMonth, expiryDateYear, cvv);
	}
	
	

	protected boolean validateLongCardNumFormat() {


		boolean FormatError = false;
		
		if (LongCardNum.charAt(0) == '2' && (LongCardNum.charAt(1) >= '1' && LongCardNum.charAt(1) <= '9')) {
								
		}
		else {
				
			FormatError = true;									
											
		}
		
		return !FormatError;
			
	}

}
