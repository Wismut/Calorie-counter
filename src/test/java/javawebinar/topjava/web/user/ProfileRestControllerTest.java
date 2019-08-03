package javawebinar.topjava.web.user;

import javawebinar.topjava.service.UserService;
import javawebinar.topjava.util.TestUtil;
import javawebinar.topjava.web.mock.WebTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import java.util.Collections;

import static javawebinar.topjava.Profiles.DATAJPA;
import static javawebinar.topjava.Profiles.HSQLDB;
import static javawebinar.topjava.model.UserTestData.*;
import static javawebinar.topjava.util.TestUtil.userHttpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles({HSQLDB, DATAJPA})
public class ProfileRestControllerTest extends WebTest {

	public static final String REST_URL = "/rest/profile/";

	@Autowired
	private UserService service;

	@Test
	public void testGet() throws Exception {
		TestUtil.print(mockMvc.perform(get(REST_URL)
				.with(userHttpBasic(USER)))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MATCHER.contentMatcher(USER)));
	}

	@Test
	public void testGetUnauth() throws Exception {
		mockMvc.perform(get(REST_URL).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isUnauthorized());
	}

	@Test
	public void testDelete() throws Exception {
		mockMvc.perform(delete(REST_URL).contentType(MediaType.APPLICATION_JSON)
				.with(userHttpBasic(USER)))
				.andExpect(status().isOk());
		MATCHER.assertListEquals(Collections.singletonList(ADMIN), service.getAll());
	}

	@Test
	public void testUpdate() throws Exception {
//        UserTo updated = new UserTo(USER.getId(), "newName", "newEmail", 1500);
//        updated.setPassword("newPassword");
//        mockMvc.perform(put(REST_URL).contentType(MediaType.APPLICATION_JSON)
//                .with(userHttpBasic(USER))
//                .content(JsonUtil.writeValue(updated)))
//                .andDo(print())
//                .andExpect(status().isOk());
//
//        User actual = service.get(USER.getId());
//        MATCHER.assertEquals(UserUtil.updateFromTo(actual, updated), actual);
	}
}