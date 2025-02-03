package com.example.demo.dao;

import com.example.demo.entities.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImp implements AccountDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void update(Account account) {
        entityManager.merge(account);
    }

    @Override
    public Account find(int id) {
        return entityManager.find(Account.class, id);
    }
}
