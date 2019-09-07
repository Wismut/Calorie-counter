package javawebinar.topjava.web.user;

import javawebinar.topjava.model.Role;
import javawebinar.topjava.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ajax/admin/users")
public class AdminAjaxController extends AbstractUserController {
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAll() {
		return super.getAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User get(@PathVariable("id") int id) {
		return super.get(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		super.delete(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void update(@RequestParam("id") int id,
	                   @RequestParam("name") String name,
	                   @RequestParam("password") String password,
	                   @RequestParam("email") String email) {
		User user = new User(id, name, email, password, true, Role.ROLE_USER);
		if (id == 0) {
			super.create(user);
		} else {
			super.update(user, id);
		}
	}
}
