package com.mycompany.role;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class Role {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @Column(nullable = false,unique = false,length = 45)
    private String email;
}
