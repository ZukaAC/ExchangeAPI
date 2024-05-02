package projects.zuka;

import projects.zuka.connection.Connection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("projects.zuka")
@EntityScan("projects.zuka.persistence.model")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}