package main.model.validator;

import main.model.square.GridManager;

public class ValidateNumber extends AbstractValidator {
	@Override
	public boolean validate(GridManager grid) {
		boolean isEqual = true;

		for (int i = 0; i < grid.getSize(); i++) {
			int countRow = 0;
			int countColumn = 0;

			for (int j = 0; j < grid.getSize(); j++) {
				// yes, it works .. almost sure :)

				countRow += Integer.parseInt(grid.getSquareValue(i, j));
				countColumn += Integer.parseInt(grid.getSquareValue(j, i));
			}

			if (countRow != grid.getSize() / 2 || countColumn != grid.getSize() / 2) {
				isEqual = false;
				break;
			}
		}

		return isEqual;
	}

}
