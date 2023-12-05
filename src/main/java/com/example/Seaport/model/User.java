package com.example.Seaport.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name="users")
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Ship> ships;
     public User(String name, String email, String password) {
        this.email = email;
        this.password = password;
        this.name = name;
     }

     public User() {}
    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }
    public List<Ship> getShips() {
        return ships;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
