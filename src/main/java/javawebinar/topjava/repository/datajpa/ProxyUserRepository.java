package javawebinar.topjava.repository.datajpa;

import javawebinar.topjava.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface ProxyUserRepository extends JpaRepository<User, Integer> {
	@Transactional
	@Modifying
	@Query("DELETE FROM User u WHERE u.id=:id")
	int delete(@Param("id") int id);

	@Override
	List<User> findAll(Sort sort);

	@Override
	@Transactional
	User save(User user);

	@Override
	User findOne(Integer id);

	User getByEmail(String email);
}
