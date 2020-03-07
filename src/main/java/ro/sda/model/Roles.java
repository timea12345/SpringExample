package ro.sda.model;

import netscape.security.Privilege;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Collection;

@Entity
public class Roles {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<LocalUser> users;

}
