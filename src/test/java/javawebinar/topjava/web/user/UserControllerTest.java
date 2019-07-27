package javawebinar.topjava.web.user;

import javawebinar.topjava.web.mock.WebTest;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import static javawebinar.topjava.Profiles.DATAJPA;
import static javawebinar.topjava.Profiles.HSQLDB;
import static javawebinar.topjava.model.BaseEntity.START_SEQ;
import static javawebinar.topjava.model.UserTestData.USER;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ActiveProfiles({HSQLDB, DATAJPA})
public class UserControllerTest extends WebTest {

	@Test
	public void userList() throws Exception {
		mockMvc.perform(get("/users"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("userList"))
				.andExpect(forwardedUrl("/WEB-INF/jsp/userList.jsp"))
				.andExpect(model().attribute("userList", hasSize(2)))
				.andExpect(model().attribute("userList", hasItem(
						allOf(
								hasProperty("id", is(START_SEQ)),
								hasProperty("name", is(USER.getName()))
						)
				)));
	}
}
