package com.mycompany.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {
public Long countById(Integer id);

List<User> findByfirstname(String firstname);

@Query(value = "select * from users order by email",nativeQuery = true)
List <User> findOrderByemail();
}
