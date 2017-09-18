package main.model.validator;

import main.model.square.GridManager;

public class ValidateSequence extends AbstractValidator {

	@Override
	public boolean validate(GridManager grid) {
		boolean isValid = true;

		for (int i = 0; i < grid.getSize(); i++) {
			for (int j = 0; j < grid.getSize(); j++) {
				// compareSquare returns a Boolean for comparison between both
				// (i-1, i and i+1) and (j-1, j and j+1)

				if (grid.compareSquares(i, j)) {
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
