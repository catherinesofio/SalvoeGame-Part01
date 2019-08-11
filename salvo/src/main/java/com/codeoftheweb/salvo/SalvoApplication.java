package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepository, GameRepository gameRepository, GamePlayerRepository gamePlayerRepository){
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

			gamePlayerRepository.save(new GamePlayer(game1.getCreationDate(), player1, game1));
			gamePlayerRepository.save(new GamePlayer(game1.getCreationDate(), player2, game1));
			gamePlayerRepository.save(new GamePlayer(game2.getCreationDate(), player1, game2));
			gamePlayerRepository.save(new GamePlayer(game2.getCreationDate(), player2, game2));
			gamePlayerRepository.save(new GamePlayer(game3.getCreationDate(), player2, game3));
			gamePlayerRepository.save(new GamePlayer(game3.getCreationDate(), player4, game3));
			gamePlayerRepository.save(new GamePlayer(game4.getCreationDate(), player2, game4));
			gamePlayerRepository.save(new GamePlayer(game4.getCreationDate(), player1, game4));
			gamePlayerRepository.save(new GamePlayer(game5.getCreationDate(), player4, game5));
			gamePlayerRepository.save(new GamePlayer(game5.getCreationDate(), player1, game5));
			gamePlayerRepository.save(new GamePlayer(game6.getCreationDate(), player3, game6));
			gamePlayerRepository.save(new GamePlayer(game6.getCreationDate(), null, game6));
			gamePlayerRepository.save(new GamePlayer(game7.getCreationDate(), player4, game7));
			gamePlayerRepository.save(new GamePlayer(game7.getCreationDate(), null, game7));
			gamePlayerRepository.save(new GamePlayer(game8.getCreationDate(), player3, game8));
			gamePlayerRepository.save(new GamePlayer(game8.getCreationDate(), player4, game8));
		};
	}

}
