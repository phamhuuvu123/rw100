package com.vti.Repository;

import com.vti.enitity.Group;
import com.vti.enitity.GroupAccount;

import java.util.List;

public interface IGroupAccountRepository { List<GroupAccount> findAll();
    void cretea(GroupAccount groupAccount);
    void Update(Integer id,Group group);
    void delete(Integer id);
}
