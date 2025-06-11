package xyz.catuns.recruiter_to_vendor.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user_entities")
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;


    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
