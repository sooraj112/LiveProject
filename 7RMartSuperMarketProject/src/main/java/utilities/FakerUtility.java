package utilities;

import com.github.javafaker.Faker;

public class FakerUtility {
	Faker faker = new Faker();

	public String createRandomUsername() {
		return faker.name().username();

	}

	public String createRandomPassword() {
		return faker.internet().password();

	}

	public String createRandomEmail() {
		return faker.internet().emailAddress();

	}

	public String createRandomName() {
		return faker.name().fullName();

	}

}
