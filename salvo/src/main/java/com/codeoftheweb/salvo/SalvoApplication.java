package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepository, GameRepository gameRepository, GamePlayerRepository gamePlayerRepository, ShipRepository shipRepository){
		return args -> {
			Player player1 = playerRepository.save(new Player("Jack Bauer", "j.bauer@ctu.gov", "24"));
			Player player2 = playerRepository.save(new Player("Chloe O'Brian", "c.obrian@ctu.gov", "42"));
			Player player3 = playerRepository.save(new Player("Kim Bauer", "kim_bauer@gmail.com", "kb"));
			Player player4 = playerRepository.save(new Player("Tony Almeida", "t.almeida@ctu.gov", "mole"));

			Date date = new Date();
			int offset = 3600;

			Game game1 = gameRepository.save(new Game(date));
			Game game2 = gameRepository.save(new Game(Date.from(date.toInstant().plusSeconds(offset))));
			Game game3 = gameRepository.save(new Game(Date.from(date.toInstant().plusSeconds(offset * 2))));
			Game game4 = gameRepository.save(new Game(Date.from(date.toInstant().plusSeconds(offset * 3))));
			Game game5 = gameRepository.save(new Game(Date.from(date.toInstant().plusSeconds(offset * 4))));
			Game game6 = gameRepository.save(new Game(Date.from(date.toInstant().plusSeconds(offset * 5))));
			Game game7 = gameRepository.save(new Game(Date.from(date.toInstant().plusSeconds(offset * 6))));
			Game game8 = gameRepository.save(new Game(Date.from(date.toInstant().plusSeconds(offset * 7))));

			GamePlayer gamePlayer11 = gamePlayerRepository.save(new GamePlayer(game1.getCreationDate(), player1, game1));
			GamePlayer gamePlayer12 = gamePlayerRepository.save(new GamePlayer(game1.getCreationDate(), player2, game1));
			GamePlayer gamePlayer21 = gamePlayerRepository.save(new GamePlayer(game2.getCreationDate(), player1, game2));
			GamePlayer gamePlayer22 = gamePlayerRepository.save(new GamePlayer(game2.getCreationDate(), player2, game2));
			GamePlayer gamePlayer31 = gamePlayerRepository.save(new GamePlayer(game3.getCreationDate(), player2, game3));
			GamePlayer gamePlayer32 = gamePlayerRepository.save(new GamePlayer(game3.getCreationDate(), player4, game3));
			GamePlayer gamePlayer41 = gamePlayerRepository.save(new GamePlayer(game4.getCreationDate(), player2, game4));
			GamePlayer gamePlayer42 = gamePlayerRepository.save(new GamePlayer(game4.getCreationDate(), player1, game4));
			GamePlayer gamePlayer51 = gamePlayerRepository.save(new GamePlayer(game5.getCreationDate(), player4, game5));
			GamePlayer gamePlayer52 = gamePlayerRepository.save(new GamePlayer(game5.getCreationDate(), player1, game5));
			GamePlayer gamePlayer61 = gamePlayerRepository.save(new GamePlayer(game6.getCreationDate(), player3, game6));
			GamePlayer gamePlayer71 = gamePlayerRepository.save(new GamePlayer(game7.getCreationDate(), player4, game7));
			GamePlayer gamePlayer81 = gamePlayerRepository.save(new GamePlayer(game8.getCreationDate(), player3, game8));
			GamePlayer gamePlayer82 = gamePlayerRepository.save(new GamePlayer(game8.getCreationDate(), player4, game8));

			shipRepository.save(new Ship("Destroyer", Arrays.asList("H2", "H3", "H4"), gamePlayer11));
			shipRepository.save(new Ship("Submarine", Arrays.asList("E1", "F1", "G1"), gamePlayer11));
			shipRepository.save(new Ship("Patrol Boat", Arrays.asList("B4", "B5"), gamePlayer11));
			shipRepository.save(new Ship("Destroyer", Arrays.asList("B5", "C5", "D5"), gamePlayer12));
			shipRepository.save(new Ship("Patrol Boat", Arrays.asList("F1", "F2"), gamePlayer12));
			shipRepository.save(new Ship("Destroyer", Arrays.asList("B5", "C5", "D5"), gamePlayer21));
			shipRepository.save(new Ship("Patrol Boat", Arrays.asList("C6", "C7"), gamePlayer21));
			shipRepository.save(new Ship("Submarine", Arrays.asList("A2", "A3", "A4"), gamePlayer22));
			shipRepository.save(new Ship("Patrol Boat ", Arrays.asList("G6", "H6"), gamePlayer22));
			shipRepository.save(new Ship("Destroyer", Arrays.asList("B5", "C5", "D5"), gamePlayer22));
			shipRepository.save(new Ship("Patrol Boat", Arrays.asList("C6", "C7"), gamePlayer22));
			shipRepository.save(new Ship("Submarine", Arrays.asList("A2", "A3", "A4"), gamePlayer31));
			shipRepository.save(new Ship("Patrol Boat", Arrays.asList("G6", "H6"), gamePlayer31));
			shipRepository.save(new Ship("Destroyer", Arrays.asList("B5", "C5", "D5"), gamePlayer41));
			shipRepository.save(new Ship("Patrol Boat", Arrays.asList("G6", "H6"), gamePlayer41));
			shipRepository.save(new Ship("Destroyer", Arrays.asList("B5", "C5", "D5"), gamePlayer52));
			shipRepository.save(new Ship("Patrol Boat", Arrays.asList("C6", "C7"), gamePlayer52));
			shipRepository.save(new Ship("Submarine", Arrays.asList("A2", "A3", "A4"), gamePlayer51));
			shipRepository.save(new Ship("Patrol Boat", Arrays.asList("G6", "H6"), gamePlayer51));
			shipRepository.save(new Ship("Destroyer", Arrays.asList("B5", "C5", "D5"), gamePlayer61));
			shipRepository.save(new Ship("Patrol Boat", Arrays.asList("C6", "C7"), gamePlayer61));
			shipRepository.save(new Ship("Destroyer", Arrays.asList("B5", "C5", "D5"), gamePlayer81));
			shipRepository.save(new Ship("Patrol Boat", Arrays.asList("C6", "C7"), gamePlayer81));
			shipRepository.save(new Ship("Submarine", Arrays.asList("A2", "A3", "A4"), gamePlayer82));
			shipRepository.save(new Ship("Patrol Boat", Arrays.asList("G6", "H6"), gamePlayer82));
		};
	}

}
