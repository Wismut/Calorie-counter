package javawebinar.topjava.web.user;

import javawebinar.topjava.LoggedUser;
import javawebinar.topjava.model.User;
import javawebinar.topjava.to.UserTo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(ProfileRestController.REST_URL)
public class ProfileRestController extends AbstractUserController {
	public static final String REST_URL = "/rest/profile";

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User get() {
		return super.get(LoggedUser.id());
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void delete() {
		super.delete(LoggedUser.id());
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody UserTo userTo) {
		LoggedUser.get().updateUserTo(userTo);
		super.update(userTo, LoggedUser.id());
	}

	@RequestMapping(value = "/text", method = RequestMethod.GET)
	public String testUTF() {
		return "Кириллица";
	}
}
