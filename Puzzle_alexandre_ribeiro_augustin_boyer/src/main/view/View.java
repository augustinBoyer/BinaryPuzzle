package main.view;

import javafx.stage.Stage;
import main.controller.Controller;
import main.exceptions.GridSizeException;
import main.exceptions.NameException;
import main.exceptions.NumberMatchesException;
import main.model.factories.PuzzleFactory;
import main.model.square.SquareValue;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class View implements Observer {
	private Controller controller;
	private Stage stage;

	private GridPane grid;
	private BorderPane root;
	private TextField firstName;
	private TextField lastName;
	private Button newGame;
	private Button validate;
	private ComboBox<Integer> dimension;
	private ComboBox<Integer> choice;
	private Label nbPlayedLbl;
	private Label nbResolvedLbl;
	private Label message;

	ObservableList<Integer> choices;
	ObservableList<Integer> tab;
	private Label label;

	private final static int CELL_WIDTH = 50;
	private static int GRID_SIZE = 500;
	private final static int CELL_SIZE = 8;

	public View(Stage stage, Controller c) {
		this.controller = c;
		this.stage = stage;
	}

	public void show() {
		this.createGrid();
		this.createRoot(this.createStartScreen());
		this.createPrimaryStage(this.stage);
	}

	@SuppressWarnings("synthetic-access")
	private VBox createStartScreen() {
		Label firstNameLbl = new Label("Prénom :");
		this.firstName = new TextField();
		Label lastNameLbl = new Label("Last name :");
		this.lastName = new TextField();
		this.lastName.setOnKeyTyped(new TextFieldChanged());
		this.firstName.setOnKeyTyped(new TextFieldChanged());
		Label dimensionLbl = new Label("Dimension :");
		this.tab = FXCollections.observableArrayList(this.CELL_SIZE);
		this.dimension = new ComboBox<>(this.tab);
		this.dimension.getSelectionModel().selectFirst();
		Label choicesLbl = new Label("Choisissez votre puzzle :");
		this.choices = FXCollections.observableArrayList();
		for (int i = 0; i < PuzzleFactory.numberChoice; i++) {
			this.choices.add(i + 1);
		}
		this.choice = new ComboBox<>(this.choices);
		this.choice.getSelectionModel().selectFirst();
		this.newGame = new Button("Commencer");
		this.newGame.setDisable(true);
		this.newGame.setOnAction(new NewGameSelected());

		VBox startScreen = new VBox();
		startScreen.getChildren().addAll(firstNameLbl, this.firstName, lastNameLbl, this.lastName, dimensionLbl,
				this.dimension, choicesLbl, this.choice, this.newGame);
		return startScreen;
	}

	@SuppressWarnings("synthetic-access")
	private VBox createPlayerScreen(String playerNameString, String nbPlayed, String nbResolved) {
		Label playerName = new Label(playerNameString);
		this.nbPlayedLbl = new Label(nbPlayed);
		this.nbResolvedLbl = new Label(nbResolved);
		this.validate = new Button("Valider");
		this.validate.setOnAction(new ValidateGame());
		this.message = new Label();
		this.message.setTextFill(Color.RED);
		VBox playerScreen = new VBox();
		playerScreen.getChildren().addAll(playerName, this.nbPlayedLbl, this.nbResolvedLbl, this.validate,
				this.message);
		return playerScreen;
	}

	private void createPrimaryStage(Stage primaryStage) {
		Scene scene = new Scene(this.root);
		primaryStage.setTitle("Puzzle binaire");
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.show();
	}

	private void createRoot(VBox vBox) {
		this.root = new BorderPane();
		this.root.setCenter(this.grid);
		this.root.setLeft(vBox);
	}

	private void createGrid() {
		this.grid = new GridPane();
		this.grid.setPrefSize(this.GRID_SIZE, this.GRID_SIZE);
		this.grid.getColumnConstraints().add(new ColumnConstraints(this.CELL_WIDTH));
		this.grid.getRowConstraints().add(new RowConstraints(this.CELL_WIDTH));
	}

	public StackPane addPane(int i, int j, String s) {
		this.label = new Label(s);
		StackPane pane = new StackPane(this.label);
		this.grid.add(pane, j, i);
		pane.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		return pane;
	}

	public void managePane(int i, int j, StackPane pane) {
		pane.setOnMouseEntered(new ColorChangeGreen(pane));
		pane.setOnMouseExited(new ColorChangeWhite(pane));
		pane.setOnMouseClicked(new ChangeValue(i, j));
	}

	@Override
	public void reactToNewSquare(int i, int j, String value) {

		StackPane pane = this.addPane(i, j, value);

		this.grid.getColumnConstraints().add(new ColumnConstraints(this.CELL_WIDTH));

		this.grid.getRowConstraints().add(new RowConstraints(this.CELL_WIDTH));

		if (value.equals(SquareValue.EMPTY.getValue())) {
			this.label.setTextFill(Color.BLUE);
			pane.setStyle("-fx-background-color: white");
			this.managePane(i, j, pane);
		} else {
			this.label.setTextFill(Color.BLACK);
			pane.setStyle("-fx-background-color: darkgrey");
		}
	}

	@Override
	public void reactToChangedSquare(int i, int j, String s) {
		StackPane pane = this.addPane(i, j, s);
		this.managePane(i, j, pane);
	}

	@Override
	public void reactToGameOver(String message) {
		this.message.setText(message);
		this.validate.setDisable(true);
	}

	@Override
	public void reactToIncompleteGrid(String message) {
		this.message.setText(message);
	}

	@Override
	public void reactToTextFieldValidation(boolean isValid) {
		if (isValid) {
			View.this.newGame.setDisable(false);

		} else {
			View.this.newGame.setDisable(true);
		}
	}

	@Override
	public void reactToNewGame(String playerName, String nbPlayed, String nbResolved) {
		this.root.setLeft(this.createPlayerScreen(playerName, nbPlayed, nbResolved));
	}

	@Override
	public void reactToPlayerUpdate(String nbPlayed, String nbResolved) {
		this.nbPlayedLbl.setText(nbPlayed);
		this.nbResolvedLbl.setText(nbResolved);
	}

	private class NewGameSelected implements EventHandler<ActionEvent> {

		@SuppressWarnings("synthetic-access")
		@Override
		public void handle(ActionEvent e) {
			try {
				if (View.this.dimension.getSelectionModel().getSelectedItem() != null) {

					View.this.controller.newGame(
							Integer.parseUnsignedInt(
									View.this.dimension.getSelectionModel().getSelectedItem().toString()),
							Integer.parseUnsignedInt(View.this.choice.getSelectionModel().getSelectedItem().toString()),
							View.this.firstName.getText(), View.this.lastName.getText());
				}

			} catch (GridSizeException e1) {
				e1.printStackTrace();
			} catch (NumberMatchesException e2) {
				e2.printStackTrace();
			} catch (NameException e3) {
				e3.printStackTrace();
			}
		}
	}

	private class ValidateGame implements EventHandler<ActionEvent> {

		@SuppressWarnings("synthetic-access")
		@Override
		public void handle(ActionEvent e) {
			try {
				View.this.controller.validate();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	private class TextFieldChanged implements EventHandler<KeyEvent> {
		@SuppressWarnings("synthetic-access")
		@Override
		public void handle(KeyEvent e) {
			View.this.controller.textFieldsVaidate(View.this.firstName.getText(), View.this.lastName.getText());
		}
	}

	public class ColorChangeGreen implements EventHandler<MouseEvent> {
		private StackPane s;

		public ColorChangeGreen(StackPane stackPane) {
			this.s = stackPane;
		}

		@Override
		public void handle(MouseEvent e) {
			this.s.setStyle("-fx-background-color: green");
		}
	}

	public class ColorChangeWhite implements EventHandler<MouseEvent> {
		private StackPane s;

		public ColorChangeWhite(StackPane stackPane) {
			this.s = stackPane;
		}

		@Override
		public void handle(MouseEvent e) {
			this.s.setStyle("-fx-background-color: white");
		}
	}

	public class ChangeValue implements EventHandler<MouseEvent> {
		private int x;
		private int y;

		public ChangeValue(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@SuppressWarnings("synthetic-access")
		@Override
		public void handle(MouseEvent e) {
			View.this.controller.changeValue(this.x, this.y);
		}
	}
}
