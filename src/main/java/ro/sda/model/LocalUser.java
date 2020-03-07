package ro.sda.model;

import javax.management.relation.Role;
import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Collection;

@Entity
public class LocalUser extends ro.sda.model.Entity {

    @Column
    private String email;

    @Column
    private String password;

    @ManyToMany(mappedBy = "users")
    private Collection<Roles> roles;

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
