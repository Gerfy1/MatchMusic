package com.gerfy.MatchMusic.MatchMusic;

import com.gerfy.MatchMusic.MatchMusic.principal.Main;
import com.gerfy.MatchMusic.MatchMusic.repository.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MatchMusicApplication implements CommandLineRunner {

	@Autowired
	private Repositorio repositorio;
	public static void main(String[] args) {
		SpringApplication.run(MatchMusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(repositorio);
		main.exibirMenu();
	}
}
