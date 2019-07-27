package javawebinar.topjava.service.datajpa;

import javawebinar.topjava.service.OrmUserServiceTest;
import org.springframework.test.context.ActiveProfiles;

import static javawebinar.topjava.Profiles.DATAJPA;
import static javawebinar.topjava.Profiles.POSTGRES;

@ActiveProfiles({POSTGRES, DATAJPA})
public class DataJpaUserServiceTest extends OrmUserServiceTest {

}
