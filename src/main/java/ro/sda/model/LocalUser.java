package ro.sda.model;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class LocalUser extends ro.sda.model.Entity {

    @Column
    private String email;

    @Column
    private String password;

    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private Collection<Role> roles = new HashSet<>();

    public Collection<Role> getRoles() {
        return roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
