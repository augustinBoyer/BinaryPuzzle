package main.businesslayer;

import main.model.player.Player;

public interface IPlayerRepository extends IRepository<Player> {
	public String getPlayerId(String firstName, String lastName);
}
