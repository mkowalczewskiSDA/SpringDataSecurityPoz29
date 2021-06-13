package com.example.SpringDataSecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortalUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PU_ID")
    private int id;
    @Column(name = "PU_LOGIN", unique = true)
    private String login;
    @Column(name = "PU_FIRSTNAME")
    private String firstName;
    @Column(name = "PU_LASTNAME")
    private String lastName;
    @Column(name = "PU_EMAIL")
    private String email;
    @Column(name = "PU_PASSWORD")
    private String password;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "portal_user_roles",
            joinColumns = @JoinColumn(name = "PUR_PU_ID"),
            inverseJoinColumns = @JoinColumn(name = "PUR_RO_ID"))
    private Set<Role> roles;

}
