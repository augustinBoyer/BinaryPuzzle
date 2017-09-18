package main.model.validator;

import main.model.square.GridManager;

public class ValidateAllSquaresFilled extends AbstractValidator {

	@Override
	public boolean validate(GridManager grid) {
		Boolean isValid = true;
		for (int i = 0; i < grid.getSize(); i++) {
			for (int j = 0; j < grid.getSize(); j++) {
				String b = grid.getSquareValue(i, j);

				if (b.equals(" ")) {
					isValid = false;
					break;
				}
			}

			if (!isValid) {
				break;
			}
		}
		return isValid;
	}

}
