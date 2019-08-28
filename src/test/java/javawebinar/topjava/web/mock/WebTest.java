package javawebinar.topjava.web.mock;

import javawebinar.topjava.service.UserService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@ContextConfiguration({
		"classpath:spring/spring-app.xml",
		"classpath:spring/spring-mvc.xml",
		"classpath:spring/spring-db.xml"
})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
abstract public class WebTest {
	protected MockMvc mockMvc;

	@Autowired
	private UserService userService;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@PostConstruct
	void postConstruct() {
		mockMvc = MockMvcBuilders.
				webAppContextSetup(webApplicationContext).
				apply(springSecurity()).
				build();
	}

	@Before
	public void setUp() {
		userService.evictCache();
	}
}
