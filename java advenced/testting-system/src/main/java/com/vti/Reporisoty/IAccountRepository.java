package com.vti.Reporisoty;

import com.vti.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;

public interface IAccountRepository extends JpaRepository<Account, Integer> {
}
