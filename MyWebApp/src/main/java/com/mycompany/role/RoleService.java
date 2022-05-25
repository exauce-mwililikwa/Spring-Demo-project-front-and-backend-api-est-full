package com.mycompany.role;

import com.mycompany.user.User;
import com.mycompany.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired private RoleRepository repo;
    public List<Role> listAll(){
        return (List<Role>) repo.findAll();
    }
}
