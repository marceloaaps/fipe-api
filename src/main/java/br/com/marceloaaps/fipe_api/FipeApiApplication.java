package br.com.marceloaaps.fipe_api;

import br.com.marceloaaps.fipe_api.view.Menu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FipeApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FipeApiApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Menu menu = new Menu();
		menu.showMenu();
	}
}
