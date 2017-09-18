package main.model;

import java.sql.SQLException;
import java.util.ArrayList;

import main.businesslayer.IPlayerRepository;
import main.exceptions.GridSizeException;
import main.exceptions.NameException;
import main.exceptions.NumberMatchesException;
import main.model.Observed;
import main.model.factories.PlayerFactory;
import main.model.factories.PuzzleFactory;
import main.model.factories.StatisticFactory;
import main.model.player.Player;
import main.model.player.Statistic;
import main.model.square.GridManager;
import main.model.validator.AbstractValidator;
import main.model.validator.GameOverManager;
import main.model.validator.ValidateAllSquaresFilled;
import main.view.Observer;

public class Model extends Observed implements IModel {
	private GridManager grid;
	private GameOverManager gameOver;
	private IPlayerRepository playerRepository;
	private Player player;
	private String idPlayer;

	public Model(IPlayerRepository repository, ArrayList<AbstractValidator> validators) throws SQLException {
		this.playerRepository = repository;
		this.gameOver = new GameOverManager(validators, this.getObservers());
	}

	@Override
	public void newGame(int size, int game, String firstName, String lastName)
			throws GridSizeException, NameException, NumberMatchesException {
		for (Observer o : this.getObservers()) {
			this.gameOver.addObserver(o);
		}
		this.idPlayer = this.playerRepository.getPlayerId(firstName, lastName);
		if (this.idPlayer == null) {
			this.player = PlayerFactory.getPlayer(firstName, lastName);
			this.player.setStats(StatisticFactory.getStatistic());
			this.playerRepository.insert(this.player);
			this.idPlayer = this.playerRepository.getPlayerId(firstName, lastName);
		} else {
			this.player = this.playerRepository.select(this.idPlayer);
		}
		ArrayList<String> puzzle = PuzzleFactory.getPuzzle(game);
		this.grid = new GridManager(size, this.getObservers());
		this.grid.fillTable(puzzle);
		Statistic stat = this.player.getStats();
		String name = this.player.getFirstName() + " " + this.player.getLastName();
		String nbPlayed = this.getNbPlayedMessage(stat.getNbPlayed());
		String nbResolved = this.getNbResolvedMessage(stat.getNbResolved(), stat.getPercentage());
		this.alertAllToNewGame(name, nbPlayed, nbResolved);
	}

	public void gameOverManager() throws NumberMatchesException {
		ValidateAllSquaresFilled val = new ValidateAllSquaresFilled();
		if (this.grid != null && val.validate(this.grid)) {
			this.player.updateStats();
			if (this.gameOver.validate(this.grid)) {
				this.player.updateWinStats();
			}
			this.playerRepository.update(this.player, this.idPlayer);
			this.playerRepository.close();
			Statistic stats = this.player.getStats();
			String nbPlayed = this.getNbPlayedMessage(stats.getNbPlayed());
			String nbResolved = this.getNbResolvedMessage(stats.getNbResolved(), stats.getPercentage());
			this.alertAllToPlayerUpdate(nbPlayed, nbResolved);
		} else if (this.grid != null && !val.validate(this.grid)) {
			this.alertAllToIncompleteGrid("Veuillez remplir tous les carrés");
		}
	}

	@Override
	public void changeValue(int x, int y) {
		this.grid.changeValue(x, y);
	}

	@SuppressWarnings("static-method")
	private String getNbPlayedMessage(int nbPlayed) {
		return "Parties jouées : " + Integer.toString(nbPlayed);
	}

	@SuppressWarnings("static-method")
	private String getNbResolvedMessage(int nbResolved, double percentage) {
		return "Parties gagnées : " + Integer.toString(nbResolved) + " (" + Double.toString(percentage) + "%)";
	}
}
