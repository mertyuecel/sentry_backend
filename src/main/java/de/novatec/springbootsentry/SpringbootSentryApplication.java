package de.novatec.springbootsentry;

import io.sentry.Sentry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootSentryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSentryApplication.class, args);
	}

}
