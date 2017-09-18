package main.controller;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import main.businesslayer.persistance.PlayerOracleDatabase;
import main.exceptions.GridSizeException;
import main.exceptions.NameException;
import main.exceptions.NumberMatchesException;
import main.model.Model;
import main.model.validator.AbstractValidator;
import main.model.validator.ValidateNumber;
import main.model.validator.ValidateSequence;
import main.model.validator.ValidateUnique;
import main.view.Observer;
import main.view.View;

public class Controller extends Application implements IController {
	private Observer view;
	private Model model;

	@Override
	public void start(Stage stage) throws Exception {
		this.view = new View(stage, this);
		this.model = new Model(new PlayerOracleDatabase(), this.getValidators());
		this.model.addObserver(this.view);
		this.view.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void newGame(int size, int game, String firstName, String lastName)
			throws GridSizeException, NameException, NumberMatchesException {
		this.model.newGame(size, game, firstName, lastName);
	}

	@Override
	public void changeValue(int x, int y) {
		this.model.changeValue(x, y);
	}

	public void validate() throws NumberMatchesException {
		this.model.gameOverManager();
	}

	@Override
	public ArrayList<AbstractValidator> getValidators() {
		ArrayList<AbstractValidator> validators = new ArrayList<>();
		validators.add(new ValidateNumber());
		validators.add(new ValidateSequence());
		validators.add(new ValidateUnique());
		return validators;
	}

	@Override
	public void textFieldsVaidate(String firstName, String lastName) {
		boolean isValid = true;
		if (firstName.trim().equals("") || lastName.trim().equals("")) {
			isValid = false;
		}
		this.view.reactToTextFieldValidation(isValid);
	}
}
