package ro.sda.model;

import javax.persistence.Column;
import java.util.Objects;

@javax.persistence.Entity
public class School extends Entity{

    @Column
    private String name;

    @Column
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof School)) return false;
        School school = (School) o;
        return id == school.id &&
                name.equals(school.name) &&
                address.equals(school.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, address);
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                '}';
    }
}
