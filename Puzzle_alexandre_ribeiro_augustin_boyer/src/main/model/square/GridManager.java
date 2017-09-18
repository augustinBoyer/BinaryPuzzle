package main.model.square;

import java.util.ArrayList;

import main.exceptions.GridSizeException;
import main.model.Observed;
import main.model.factories.SquareFactory;
import main.view.Observer;

public class GridManager extends Observed {
	private static int SIZE;
	private Square[][] table;

	private final static int SHIFT = 1;

	Square square;

	public GridManager(int size, ArrayList<Observer> observers) throws GridSizeException {
		if (observers != null) {
			for (Observer o : observers) {
				this.addObserver(o);
			}
		}
		this.setSize(size);
		this.setTable(new Square[this.SIZE][this.SIZE]);
	}

	public Square[][] getTable() {
		return this.table;
	}

	public void setTable(Square[][] table) {
		this.table = table;
	}

	public Square getSquare(int x, int y) {
		return this.table[x][y];
	}

	public void setSquare(Square square) {
		this.square = square;
	}

	private void setSize(int size) throws GridSizeException {
		if (size % 2 != 0) {
			throw new GridSizeException("La taille doit être paire");
		} else if (size < 0) {
			throw new GridSizeException("La taille doit être positive");
		} else {
			this.SIZE = size;
		}
	}

	public static int getSize() {
		return SIZE;
	}

	public void fillTable(ArrayList<String> game) {

		for (int i = 0; i < this.SIZE; i++) {
			String a = game.get(i);

			for (int j = 0; j < this.SIZE; j++) {

				this.fillSquare(j, a);

				this.alert(i, j);
			}
		}
	}

	private void fillSquare(int j, String a) {
		String b = a.substring(j, j + this.SHIFT);
		boolean changeable = (b.equals(SquareValue.EMPTY.getValue()));
		this.square = SquareFactory.getSquare(b, changeable);
	}

	private void alert(int i, int j) {
		this.getTable()[i][j] = this.square;
		this.alertAllToNewSquare(i, j, this.square.getValue());
	}

	public boolean compareRow(int i, int j, boolean sense) {
		return (this.getRow(i, sense).equals(this.getRow(j, sense)));
	}

	public String getRow(int x, boolean sense) {
		String column = new String();

		for (int j = 0; j < this.SIZE; j++) {
			if (sense) {
				column += this.getSquareValue(x, j);
			} else {
				column += this.getSquareValue(j, x);
			}

		}
		return column;
	}

	public boolean compareSquares(int x, int y) {

		boolean isValid = false;

		if (x > 0 && x < this.SIZE - this.SHIFT) {
			isValid = (this.getSquareValue(x, y).equals(this.getSquareValue(x - this.SHIFT, y))
					&& this.getSquareValue(x, y).equals(this.getSquareValue(x + this.SHIFT, y)));
		}

		if (y > 0 && y < this.SIZE - this.SHIFT && !isValid) {
			isValid = (this.getSquareValue(x, y).equals(this.getSquareValue(x, y - this.SHIFT))
					&& this.getSquareValue(x, y).equals(this.getSquareValue(x, y + this.SHIFT)));
		}
		return isValid;
	}

	public String getSquareValue(int i, int j) {
		return this.getTable()[i][j].getValue();
	}

	public void changeValue(int x, int y) {
		this.table[x][y].changeValue();
		this.alertAllToChangedSquare(x, y, this.getSquareValue(x, y));
	}
}
