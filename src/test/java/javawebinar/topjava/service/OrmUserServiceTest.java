package javawebinar.topjava.service;

import javawebinar.topjava.repository.JpaUtil;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class OrmUserServiceTest extends UserServiceTest {
	@Autowired
	private JpaUtil jpaUtil;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		jpaUtil.clear2ndLevelHibernateCache();
	}
}
