package com.sda.training.zoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class FileReaderConfiguration {

//	@Value("${sda.zoo.application.file-path}")
//	private String filePath;
	private final ZooConfiguration zooConfiguration;

	@Bean
	public BufferedReader fileReader() throws IOException {
		Path path = Path.of(zooConfiguration.getFilePath());
		BufferedReader bufferedReader = Files.newBufferedReader(path);
		return bufferedReader;
	}
}
