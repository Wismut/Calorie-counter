package javawebinar.topjava.web.meal;

import javawebinar.topjava.web.mock.WebTest;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import static javawebinar.topjava.Profiles.DATAJPA;
import static javawebinar.topjava.Profiles.HSQLDB;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles({HSQLDB, DATAJPA})
public class UserMealControllerTest extends WebTest {
	@Test
	public void testMealList() throws Exception {
		mockMvc.perform(get("/meals"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("mealList"))
				.andExpect(forwardedUrl("/WEB-INF/jsp/mealList.jsp"));
	}
}
