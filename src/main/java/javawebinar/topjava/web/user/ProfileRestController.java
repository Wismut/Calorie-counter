package javawebinar.topjava.web.user;

import javawebinar.topjava.LoggedUser;
import javawebinar.topjava.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/profile")
public class ProfileRestController {
	@Autowired
	private UserHelper helper;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User get() {
		return helper.get(LoggedUser.id());
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void delete() {
		helper.delete(LoggedUser.id());
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody User user) {
		helper.update(user);
	}

	@RequestMapping(value = "/text", method = RequestMethod.GET)
	public String textUTF() {
		return "Текст";
	}
}
