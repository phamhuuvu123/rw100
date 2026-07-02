package org.example;


import com.vti.Repository.impl.AccountReoository;
import com.vti.Repository.impl.GroupRepository;
import com.vti.enitity.Account;
import com.vti.enitity.Group;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        GroupRepository groupRepository= new GroupRepository();
        List<Group> groups= groupRepository.findAll();
        for(Group group:groups)
        {
            System.out.println(group.toString());
        }
    }
}
