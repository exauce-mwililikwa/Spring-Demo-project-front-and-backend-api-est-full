package com.mycompany;
import com.mycompany.role.Role;
import com.mycompany.role.RoleRepository;
import com.mycompany.user.User;
import com.mycompany.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.hibernate.loader.custom.sql.SQLQueryReturnProcessor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {
    @Autowired private RoleRepository repo;
    @Test
    @PostMapping("/add/test")
    public void testAddNew(){
        Role role=new Role();
        role.setEmail("cedricmwiliklikwa@gmail.com");

        Role saveUser= repo.save(role);
        Assertions.assertThat(saveUser).isNotNull();
        Assertions.assertThat(saveUser.getId()).isGreaterThan(0);
    }
}
