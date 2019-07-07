package javawebinar.topjava;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import javawebinar.topjava.web.user.UserRestController;

import java.util.Arrays;

public class SpringMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/mock.xml");
		System.out.println("\n" + Arrays.toString(appCtx.getBeanDefinitionNames()) + "\n");
		UserRestController appCtxBean = appCtx.getBean(UserRestController.class);
		appCtx.close();
	}
}
