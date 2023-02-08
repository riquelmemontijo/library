package com.biblioteca.domain.role;

import java.util.UUID;

//@Entity
//@Table(name = "role")
public class Role {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(nullable = false, unique = true)
    private UUID id;
    private String name;

//    @Override
    public String getAuthority() {
        return this.name;
    }
}
