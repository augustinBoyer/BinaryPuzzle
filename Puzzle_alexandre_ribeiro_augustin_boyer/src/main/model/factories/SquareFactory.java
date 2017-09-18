package main.model.factories;

import main.model.square.Square;

public class SquareFactory {

	public static Square getSquare(String b, Boolean changeable) {
		return new Square(b, changeable);
	}
}
