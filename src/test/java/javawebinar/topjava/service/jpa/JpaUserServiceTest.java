package javawebinar.topjava.service.jpa;

import javawebinar.topjava.service.OrmUserServiceTest;
import org.springframework.test.context.ActiveProfiles;

import static javawebinar.topjava.Profiles.JPA;
import static javawebinar.topjava.Profiles.POSTGRES;

@ActiveProfiles({POSTGRES, JPA})
public class JpaUserServiceTest extends OrmUserServiceTest {

}
