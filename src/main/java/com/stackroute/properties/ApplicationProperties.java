package com.stackroute.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.properties")
@Configuration("applicationProperties")
public class ApplicationProperties {

	@Value("${spring.data.mongodb.host}")
	private String host;
	@Value("${spring.data.mongodb.port}")
	private String port;
	@Value("${spring.data.mongodb.database}")
	private String database;

	public String getHost() {
		return host;
	}

	public String getPort() {
		return port;
	}

	public String getDatabase() {
		return database;
	}

	@Autowired
	private Environment env;

	public void method() {
		String eHost = env.getProperty(host);
		String ePort = env.getProperty(port);
		String eDatabase = env.getProperty(database);
		System.out.println("Using Environment " + eHost + " " + ePort + " " + eDatabase);

		System.out.println(" Using Value " + this.getHost() + " " + this.getPort() + " " + this.getDatabase());
	}

}
