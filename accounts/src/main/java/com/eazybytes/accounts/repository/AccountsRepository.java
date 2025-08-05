package com.eazybytes.accounts.repository;

import com.eazybytes.accounts.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    Optional<Accounts> findByCustomerId(Long customerId);

    /*
    * This is to tell the spring data JPA that run this method in transaction mod
    * If in between of the transaction if any server error occurs then we can always roll back
    * to the exact state and we will be in safe hands
    * */
    @Transactional
    @Modifying
    void deleteByCustomerId(Long customerId);
}
