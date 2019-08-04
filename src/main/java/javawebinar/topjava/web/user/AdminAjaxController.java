package javawebinar.topjava.web.user;

import javawebinar.topjava.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ajax/admin/users")
public class AdminAjaxController {

	@Autowired
	private UserHelper helper;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAll() {
		return helper.getAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User get(@PathVariable("id") int id) {
		return helper.get(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		helper.delete(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void update(@PathVariable("id") int id,
	                   @RequestParam("name") String name,
	                   @RequestParam("password") String password,
	                   @RequestParam("email") String email) {

	}
}
