package com.mycompany;

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

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired private UserRepository repo;
    @Test
    public void testAddNew(){
        User user=new User();
        user.setEmail("cedricmwiliklikwa@gmail.com");
        user.setFirstname("yves");
        user.setLastname("ldld");
        user.setPassword("ddkkd");
   User saveUser= repo.save(user);
        Assertions.assertThat(saveUser).isNotNull();
        Assertions.assertThat(saveUser.getId()).isGreaterThan(0);
    }
    @Test
    public void testListAll(){
        Iterable<User> users=repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);
        for(User user : users){
            System.err.println(user);
        }
    }

    @Test
    public void testUpdate(){
       Integer userId=2;
       Optional<User> userOptional=repo.findById(userId);
       User user=userOptional.get();
       user.setPassword("hello430");
       repo.save(user);
       User updateUser=repo.findById(userId).get();
       Assertions.assertThat(updateUser.getPassword()).isEqualTo("hello430");
    }
    @Test
    public  void testGet(){
        Integer userId=2;
        Optional<User> optionalUer=repo.findById(userId);
        User user=optionalUer.get();
        System.err.println(optionalUer.get());
    }
    @Test
    public  void testGetfirst(){
        String firstname="Hhh";
        List<User> optionalUer=repo.findByfirstname(firstname);

        System.err.println(optionalUer);
    }
    @Test
    public void testDelete(){
        Integer userId=2;
        repo.deleteById(userId);
        Optional<User> optionalUser=repo.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();
    }
}
