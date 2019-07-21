package javawebinar.topjava.service.jdbc;

import javawebinar.topjava.service.UserServiceTest;
import org.springframework.test.context.ActiveProfiles;

import static javawebinar.topjava.Profiles.JDBC;
import static javawebinar.topjava.Profiles.POSTGRES;

@ActiveProfiles({POSTGRES, JDBC})
public class JdbcUserMealServiceTest extends UserServiceTest {

}
