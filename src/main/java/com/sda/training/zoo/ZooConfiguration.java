package com.sda.training.zoo;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "sda.zoo.application")
@Getter
@Setter
public class ZooConfiguration {
	private String filePath;
	private String zooName;
//	private List<String> owner;
//	private Map<String, String> hours;
}
