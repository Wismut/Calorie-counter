package javawebinar.topjava;

import javawebinar.topjava.web.meal.UserMealRestController;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;

public class SpringMain {
	public static void main(String[] args) {
		try (GenericXmlApplicationContext ctx = new GenericXmlApplicationContext()) {
			ctx.getEnvironment().setActiveProfiles("postgres");
			ctx.load("spring/spring-app.xml", "spring/spring-db.xml");
			ctx.refresh();
			System.out.println("\n" + Arrays.toString(ctx.getBeanDefinitionNames()) + "\n");
			UserMealRestController adminController = ctx.getBean(UserMealRestController.class);
			adminController.delete(7);
		}
	}
}
