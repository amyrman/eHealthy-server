package com.ehealth.server.repository;

import com.ehealth.server.model.User;
import com.ehealth.server.resources.UserCredentials;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.NoResultException;


@ApplicationScoped
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(User user) {
        entityManager.persist(user);
    }
    // Method to find a user by credentials using UserCredentials DTO
    public User findUserByCredentials(@org.jetbrains.annotations.NotNull UserCredentials credentials) {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class);
        query.setParameter("username", credentials.getUsername());
        query.setParameter("password", credentials.getPassword());
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;  // Return null if no user is found
        }
    }
}
