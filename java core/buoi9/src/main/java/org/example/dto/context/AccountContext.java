package org.example.dto.context;

import org.example.entity.Account;

import java.util.Map;

public class AccountContext {
     private Map<String,Account> MapbyNameusername;
     private Map<String,Account> mapByemail;

    public AccountContext(Map<String, Account> mapbyNameusername, Map<String, Account> mapByemail) {
        MapbyNameusername = mapbyNameusername;
        this.mapByemail = mapByemail;
    }

    public Map<String, Account> getMapbyNameusername() {
        return MapbyNameusername;
    }

    public void setMapbyNameusername(Map<String, Account> mapbyNameusername) {
        MapbyNameusername = mapbyNameusername;
    }

    public Map<String, Account> getMapByemail() {
        return mapByemail;
    }

    public void setMapByemail(Map<String, Account> mapByemail) {
        this.mapByemail = mapByemail;
    }
}
