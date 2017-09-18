package main.model.factories;

import main.exceptions.NameException;
import main.exceptions.NumberMatchesException;
import main.model.player.Player;

public class PlayerFactory {
	public static Player getPlayer(String firstName, String lastName) throws NameException, NumberMatchesException {
		return new Player(firstName, lastName);
	}
}
