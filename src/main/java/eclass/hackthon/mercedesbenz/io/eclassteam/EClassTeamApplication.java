package eclass.hackthon.mercedesbenz.io.eclassteam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class EClassTeamApplication {
    public static void main(String[] args) {
        SpringApplication.run(EClassTeamApplication.class, args);
    }

}
