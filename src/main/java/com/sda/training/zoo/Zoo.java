package com.sda.training.zoo;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sda.training.zoo.animals.Animal;
import com.sda.training.zoo.animals.Raptile;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
//@RequiredArgsConstructor
public class Zoo implements CommandLineRunner {
	private final Animal animal1;
	private final Animal animal2;
	private final List<Raptile> raptiles;
	private final BufferedReader bufferedReader;

	@Value("${sda.zoo.application.zoo-name}")
	private String zooName;

	public Zoo(
		@Qualifier("elephant") Animal animal1,
		@Qualifier("penguin") Animal animal2,
		List<Raptile> raptiles,
		BufferedReader bufferedReader) {
		this.animal1 = animal1;
		this.animal2 = animal2;
		this.raptiles = raptiles;
		this.bufferedReader = bufferedReader;
	}

	//	@Autowired
//	public Zoo(Elephant elephant) {
//		this.elephant = elephant;
//	}

	@Override
	public void run(String... args) throws Exception {
		List<String> sounds = new ArrayList<>();
		sounds.add(animal1.sound());
		sounds.add(animal2.sound());

		log.info("Hello from {}", zooName);
		log.info(bufferedReader.readLine());

		sounds.forEach(log::info);

		raptiles.stream()
			.map(Raptile::raptileSound)
			.forEach(log::info);

//		for (Raptile raptile : raptiles) {
//			log.info(raptile.raptileSound());
//		}
	}
}
