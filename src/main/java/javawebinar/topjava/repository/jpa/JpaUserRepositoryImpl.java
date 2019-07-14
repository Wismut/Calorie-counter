package javawebinar.topjava.repository.jpa;

import org.springframework.stereotype.Repository;
import javawebinar.topjava.model.User;
import javawebinar.topjava.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class JpaUserRepositoryImpl implements UserRepository {

/*
    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }
*/

	@PersistenceContext
	private EntityManager em;

	@Override
	public User save(User user) {
		if (user.isNew()) {
			em.persist(user);
		} else {
			em.merge(user);
		}
		return user;
	}

	@Override
	public User get(int id) {
		return em.find(User.class, id);
	}

	@Override
	public boolean delete(int id) {

/*
        User ref = em.getReference(User.class, id);
        em.remove(ref);

*/
		TypedQuery<User> query = em.createQuery("DELETE FROM User u WHERE u.id=:id", User.class);
		return query.setParameter("id", id).executeUpdate() != 0;
//        return em.createNamedQuery(User.DELETE).setParameter("id", id).executeUpdate() != 0;
	}

	@Override
	public User getByEmail(String email) {
		return null;
//        return em.createNamedQuery(User.BY_EMAIL, User.class).setParameter(1, email).getSingleResult();
	}

	@Override
	public List<User> getAll() {
		return null;
//        return em.createNamedQuery(User.ALL_SORTED, User.class).getResultList();
	}
}