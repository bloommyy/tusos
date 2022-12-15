package bg.dimps.tusos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class TusosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TusosApplication.class, args);
	}
	@GetMapping("/")
	public String hello() {
		return "greetings";
	}

}
