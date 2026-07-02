package com.vti.Repository;

import com.vti.enitity.Account;
import com.vti.enitity.Group;

import java.util.List;

public interface IGroupRepository {
    List<Group> findAll();
    void cretea(Group group);
    void Update(Integer id,String name);
    void delete(Integer id);
}
