package main.model.validator;

import main.model.square.GridManager;

public class ValidateUnique extends AbstractValidator {

	@Override
	public boolean validate(GridManager grid) {

		boolean isUnique = true;
		for (int i = 0; i < grid.getSize(); i++) {
			for (int j = i + 1; j < grid.getSize(); j++) {
				if (grid.compareRow(i, j, true) || grid.compareRow(i, j, false)) {
					isUnique = false;
					break;
				}
			}

			if (!isUnique) {
				break;
			}
		}

		return isUnique;
	}

}
