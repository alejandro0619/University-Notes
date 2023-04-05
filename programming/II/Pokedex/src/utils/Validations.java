package utils;

import java.awt.TextField;

public class Validations {
	
	public boolean validateInputs(TextField input){
		if(input.getText().isEmpty() || input.getText().isBlank()) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
