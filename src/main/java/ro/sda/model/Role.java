package ro.sda.model;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Collection;

@Entity
public class Role extends ro.sda.model.Entity {

    @Column
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_role",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")} )
    private Collection<LocalUser> users;


    public Collection<LocalUser> getUsers() {
        return users;
    }

    public void setUsers(Collection<LocalUser> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
