package com.travel.vision.api;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.travel.vision.api.models.Profile;
import com.travel.vision.api.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.PostConstruct;

@SpringBootApplication
public class TravelVisionApiApplication implements CommandLineRunner {
	@Value("${mongoDb.connectionString}")
	private String mongoDbConnectionString;

	@Autowired
	private ProfileRepository profileRepository;

	public TravelVisionApiApplication(String mongoDbConnectionString) {
		this.mongoDbConnectionString = mongoDbConnectionString;
	}

	@Override
	public void run(String... args) {
		System.err.println("=== Application Started ===");
		getMongoDbConnectionString();
		System.out.println("Profiles found with findAll():");
		System.out.println("-------------------------------");
		for (Profile profile : profileRepository.findAll()) {
			System.out.println(profile);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SpringApplication.run(TravelVisionApiApplication.class, args);
	}

	@PostConstruct
	public static MongoDatabase connectToMongoDb(String mongoDbConnectionString) {
		MongoClient mongoClient = MongoClients.create(mongoDbConnectionString);
		MongoDatabase database = mongoClient.getDatabase("TravelVision");
		return database;
	}

	public String getMongoDbConnectionString() {
		return mongoDbConnectionString;
	}
}
