package main.model.tests;

import org.junit.Assert;
import org.junit.Test;

import main.model.factories.SquareFactory;
import main.model.square.Square;

public class SquareTests {

	@Test
	public void SquareTests_GetValue() {
		Square square = SquareFactory.getSquare("0", true);
		Assert.assertEquals("0", square.getValue());
	}

	@Test
	public void SquareTests_Modifiable() {
		Square square = SquareFactory.getSquare("0", true);
		square.setValue("1");
		Assert.assertEquals("1", square.getValue());
	}

	@Test
	public void SquareTests_NotModifiable() {
		Square square = SquareFactory.getSquare("0", false);
		square.setValue("0");
		Assert.assertEquals("0", square.getValue());
	}

	@Test
	public void SquareTests_ChangeValue_NotModifiable() {
		Square square = SquareFactory.getSquare("0", false);
		square.changeValue();
		Assert.assertEquals("0", square.getValue());
	}

	@Test
	public void SquareTests_ChangeValue_Modifiable() {
		Square square = SquareFactory.getSquare("0", true);
		square.changeValue();
		Assert.assertEquals("1", square.getValue());
	}

}
