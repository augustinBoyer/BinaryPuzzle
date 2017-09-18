package main.model.tests;

import org.junit.Assert;
import org.junit.Test;

import main.exceptions.NameException;
import main.exceptions.NumberMatchesException;
import main.model.factories.PlayerFactory;
import main.model.player.Player;

public class PlayerTests {
	@Test
	public void getFirstName_Test() throws NameException, NumberMatchesException {
		Player player = PlayerFactory.getPlayer("TestFirstName", "TestLastName");
		Assert.assertEquals(player.getFirstName(), "TestFirstName");
	}

	@Test
	public void getLastName_Test() throws NameException, NumberMatchesException {
		Player player = PlayerFactory.getPlayer("TestFirstName", "TestLastName");
		Assert.assertEquals(player.getLastName(), "TestLastName");
	}

	@SuppressWarnings("unused")
	@Test(expected = NameException.class)
	public void playerFactory_Test_LastNameEmpty() throws NameException, NumberMatchesException {
		Player player = PlayerFactory.getPlayer("", "TestLastName");
	}

	@SuppressWarnings("unused")
	@Test(expected = NameException.class)
	public void playerFactory_Test_FirstNameEmpty() throws NameException, NumberMatchesException {
		Player player = PlayerFactory.getPlayer("TestFirstName", "");
	}
}
