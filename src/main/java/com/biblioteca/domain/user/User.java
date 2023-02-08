package com.biblioteca.domain.user;

import com.biblioteca.domain.role.Role;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

//@Entity
//@Table(name = "user")
public class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(nullable = false, unique = true)
    private UUID id;
    private String name;
    private String login;
    private String password;
    private String email;
    private String phoneNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "user_roles",
//               joinColumns = @JoinColumn(name = "id_user"),
//               inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Set<Role> roles;


}
