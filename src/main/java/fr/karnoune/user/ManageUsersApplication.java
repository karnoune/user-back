package fr.karnoune.user;

import fr.karnoune.user.model.User;
import fr.karnoune.user.repository.UserRepository;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ManageUsersApplication {



	public static void main(String[] args) {
		SpringApplication.run(ManageUsersApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI()
				.components(new Components())
				.info(new Info().title(""));
	}

	@Autowired
	UserRepository userRepository;

	@Bean
	@ConditionalOnProperty(prefix = "app", name = "db.init.enabled", havingValue = "true")
	public CommandLineRunner demoCommandLineRunner() {
		return args -> {

			User u1 = new User(1l, "Imad", "Karnoune", "imad.karnoune@gmail.com");
			User u2 = new User(2l, "Dupont", "more", "dupont.more@gmail.com");
			User u3 = new User(3l, "Jean", "marc", "jean.marc@gmail.com");
			User u4 = new User(4l, "Cedric", "duroc", "cedric.ducroc@gmail.com");

			userRepository.saveAll(List.of(u1, u2, u3, u4));

		};
	}

}
