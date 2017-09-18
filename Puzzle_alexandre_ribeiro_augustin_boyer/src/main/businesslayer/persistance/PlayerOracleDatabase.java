package main.businesslayer.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.businesslayer.IPlayerRepository;
import main.exceptions.NameException;
import main.exceptions.NumberMatchesException;
import main.model.factories.PlayerFactory;
import main.model.factories.StatisticFactory;
import main.model.player.Player;
import main.model.player.Statistic;
import oracle.jdbc.pool.OracleDataSource;

public class PlayerOracleDatabase implements IPlayerRepository {
	private Connection connection;

	public PlayerOracleDatabase() throws SQLException {
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setUser("sys as sysdba");
		dataSource.setPassword("root");
		dataSource.setDatabaseName("xe");
		dataSource.setServerName("localhost");
		dataSource.setPortNumber(1521);
		dataSource.setDriverType("thin");
		this.connection = dataSource.getConnection();
	}

	@Override
	public void close() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Player select(String id) {
		Player player = null;
		if (id != null) {
			try {

				String firstName = "";
				String lastName = "";

				String queryPlayer = "SELECT * FROM Player WHERE Id = ?";
				String queryStatistic = "SELECT * FROM Statistic WHERE Id = ?";
				PreparedStatement stmtPlayer = this.connection.prepareStatement(queryPlayer);
				stmtPlayer.setString(1, id);
				ResultSet rs = stmtPlayer.executeQuery();
				while (rs.next()) {
					firstName = rs.getString("FirstName");
					lastName = rs.getString("LastName");
				}
				player = PlayerFactory.getPlayer(firstName, lastName);

				Statistic stats = StatisticFactory.getStatistic();
				PreparedStatement stmtStatistic = this.connection.prepareStatement(queryStatistic);
				stmtStatistic.setString(1, id);
				rs = stmtStatistic.executeQuery();
				while (rs.next()) {
					stats.setNbPlayed(Integer.parseInt(rs.getString("NbPlayed")));
					stats.setNbResolved(Integer.parseInt(rs.getString("NbResolved")));
				}
				player.setStats(stats);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NumberMatchesException e) {
				e.printStackTrace();
			} catch (NameException e) {
				e.printStackTrace();
			}
		}
		return player;
	}

	@Override
	public void insert(Player player) {
		if (player != null) {

			String firstName = "";
			String lastName = "";
			String querySearch = "SELECT FirstName, LastName FROM Player WHERE FirstName = ? AND LastName = ?";

			PreparedStatement stmtSearch;
			try {
				stmtSearch = this.connection.prepareStatement(querySearch);
				stmtSearch.setString(1, player.getFirstName());
				stmtSearch.setString(2, player.getLastName());
				ResultSet rs = stmtSearch.executeQuery();
				while (rs.next()) {
					firstName = rs.getString("FirstName");
					lastName = rs.getString("LastName");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if (firstName == "" && lastName == "") {
				String queryPlayer = "INSERT INTO Player (Id, FirstName, LastName) VALUES (seq_PlayerId.nextval, ?, ?)";
				String queryStat = "INSERT INTO Statistic (Id, NbPlayed, NbResolved) VALUES (seq_PlayerId.currval, ?, ?)";
				Statistic stat = player.getStats();
				try {
					PreparedStatement stmt = this.connection.prepareStatement(queryPlayer);
					stmt.setString(1, player.getFirstName());
					stmt.setString(2, player.getLastName());
					stmt.executeUpdate();

					PreparedStatement stmtStat = this.connection.prepareStatement(queryStat);
					stmtStat.setString(1, Integer.toString(stat.getNbPlayed()));
					stmtStat.setString(2, Integer.toString(stat.getNbResolved()));
					stmtStat.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update(Player player, String id) {
		if (player != null) {
			if (id != null) {
				try {
					String query = "UPDATE Statistic SET NbPlayed= ?, NbResolved= ? WHERE id= ?";
					PreparedStatement stmt = this.connection.prepareStatement(query);
					stmt.setString(1, Integer.toString(player.getNbPlayed()));
					stmt.setString(2, Integer.toString(player.getNbResolved()));
					stmt.setString(3, id);
					stmt.executeQuery();

				} catch (NumberMatchesException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String getPlayerId(String firstName, String lastName) {
		String id = null;
		try {
			String query = "SELECT ID FROM Player WHERE FirstName = ? AND LastName = ?";
			PreparedStatement stmt = this.connection.prepareStatement(query);
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				id = rs.getString("ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
}
