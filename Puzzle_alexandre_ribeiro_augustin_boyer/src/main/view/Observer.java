package main.view;

public interface Observer {
	public void show();

	public void reactToNewSquare(int i, int j, String s);

	public void reactToChangedSquare(int i, int j, String s);

	public void reactToGameOver(String message);

	public void reactToPlayerUpdate(String nbPlayed, String nbResolved);

	public void reactToIncompleteGrid(String message);

	public void reactToTextFieldValidation(boolean isValid);

	public void reactToNewGame(String playerName, String nbPlayed, String nbResolved);
}
