package com.vti.Reporisoty;

import com.vti.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAccountRepository extends JpaRepository<Account, Integer> {
    Account findByUsername(String username);
    List<Account> findByFullName(String fullName);
    boolean existsByUsername(String username);
    List<Account> findByFullNameAndUsername(String fullName, String username);
    boolean existsByUsernameAndIdNot(String name,Integer id);
    boolean existsByEmailAndIdNot(String name,Integer id);
}