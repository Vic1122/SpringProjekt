package com.Vic1122.Library.repository;

import com.Vic1122.Library.domain.Role;
import com.Vic1122.Library.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addUser(User user) {
        if (user != null) {
            boolean userExists = getUser(user.getUserName()) != null;

            if (!userExists)
                em.persist(user);
        }
    }

    @Transactional
    public void addRoleToUser(String userName, Role role) {
        if (userName != null && role != null) {
            User user = getUser(userName);
            if(user != null) {
                user.addRole(role);
                role.setUser(user);
                em.persist(role);
                em.merge(user);
            }
        }
    }

    public User getUser(String userName) {
        List<User> users = em.createQuery("from User u where u.userName = :userName", User.class)
                .setParameter("userName", userName)
                .getResultList();

        if (users == null)
            return null;
        if (users.isEmpty())
            return null;

        return users.get(0);
    }
}
