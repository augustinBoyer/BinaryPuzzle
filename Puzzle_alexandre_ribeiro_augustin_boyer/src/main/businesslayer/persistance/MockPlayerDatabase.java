package main.businesslayer.persistance;

import java.util.ArrayList;

import main.businesslayer.IPlayerRepository;
import main.exceptions.NameException;
import main.exceptions.NumberMatchesException;
import main.model.player.Player;
import main.model.player.Statistic;

public class MockPlayerDatabase implements IPlayerRepository {
	private ArrayList<Player> playerList;

	public ArrayList<Player> getPlayerList() {
		return this.playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}

	public MockPlayerDatabase() throws NameException, NumberMatchesException {
		this.setPlayerList(new ArrayList<>());
	}

	@Override
	public void close() {
	}

	@Override
	public Player select(String id) {
		Player player = null;
		if (id != null) {
			try {
				int index = Integer.parseInt(id);
				player = this.playerList.get(index);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return player;
	}

	@Override
	public void insert(Player t) {
		if (t != null) {
			String id = this.getPlayerId(t.getFirstName(), t.getLastName());
			if (id == null && !this.getPlayerList().contains(t)) {
				this.getPlayerList().add(t);
			}
		}
	}

	@Override
	public void update(Player t, String id) {
		if (t != null) {
			Player player = this.select(id);
			if (player != null) {
				Statistic stats = t.getStats();
				player.setStats(stats);
			}
		}
	}

	@Override
	public String getPlayerId(String firstName, String lastName) {
		String index = null;
		for (int i = 0; i < this.playerList.size(); i++) {
			if (this.playerList.get(i).getFirstName().equals(firstName)
					&& this.playerList.get(i).getLastName().equals(lastName)) {
				index = Integer.toString(i);
			}
		}
		return index;
	}
}
