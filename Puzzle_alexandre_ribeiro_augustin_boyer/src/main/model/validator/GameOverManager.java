package main.model.validator;

import java.util.ArrayList;

import main.model.Observed;
import main.model.square.GridManager;
import main.view.Observer;

public class GameOverManager extends Observed {
	private ArrayList<AbstractValidator> validator;

	public GameOverManager(ArrayList<AbstractValidator> validators, ArrayList<Observer> observers) {
		this.validator = validators;
		if (observers != null) {
			for (Observer o : observers) {
				this.addObserver(o);
			}
		}
	}

	public boolean validate(GridManager grid) {
		String message = "Vous avez gagné";
		Boolean win = true;

		for (AbstractValidator val : this.validator) {
			if (!val.validate(grid)) {

				message = "Vous avez perdu";
				win = false;
				break;
			}
		}
		if (this.getObservers() != null) {
			this.alertAllToGameOver(message);
		}
		return win;
	}
}
