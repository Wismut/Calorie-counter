package javawebinar.topjava.web.user;

import javawebinar.topjava.model.User;
import javawebinar.topjava.service.UserService;
import javawebinar.topjava.to.UserTo;
import javawebinar.topjava.util.UserUtil;
import javawebinar.topjava.web.ExceptionInfoHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public abstract class AbstractUserController extends ExceptionInfoHandler {
    @Autowired
    private UserService service;

    public List<User> getAll() {
        LOG.info("getAll");
        List<User> all = service.getAll();
        all.forEach(u -> u.setPassword(null));
        return all;
    }

    public User get(int id) {
        LOG.info("get " + id);
        User user = service.get(id);
        user.setPassword(null);
        return user;
    }

    public User create(UserTo userTo) {
        LOG.info("create " + userTo);
        return create(UserUtil.createFromTo(userTo));
    }

    public User create(User user) {
        LOG.info("create " + user);
        user.setId(null);
        return service.save(UserUtil.encode(user));
    }

    public void delete(int id) {
        LOG.info("delete " + id);
        service.delete(id);
    }

    public void update(UserTo userTo, int id) {
        LOG.info("update " + userTo);
        userTo.setId(id);
        service.update(userTo);
    }

    public void update(User user, int id) {
        LOG.info("update " + user);
        user.setId(id);
        service.update(user);
    }

    public User getByMail(String email) {
        LOG.info("getByEmail " + email);
        return service.getByEmail(email);
    }

    public void enable(int id, boolean enable) {
        LOG.info("enable " + id);
        service.enable(id, enable);
    }
}
