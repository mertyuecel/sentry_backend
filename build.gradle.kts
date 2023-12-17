plugins {
	java
	id("org.springframework.boot") version "3.1.5"
	id("io.spring.dependency-management") version "1.1.3"
	id("io.sentry.jvm.gradle") version "4.0.0"
}

group = "de.novatec"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

sentry {
	// Generates a JVM (Java, Kotlin, etc.) source bundle and uploads your source code to Sentry.
	// This enables source context, allowing you to see your source
	// code as part of your stack traces in Sentry.
	includeSourceContext = true

	org = "none-ruy"
	projectName = "spring-sentry-demo"
	authToken = System.getenv("SENTRY_AUTH_TOKEN=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")
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")

	compileOnly("org.projectlombok:lombok")
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
