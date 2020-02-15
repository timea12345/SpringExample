package ro.sda.model;

import java.util.Objects;

public class School {

    private String name;
    private int id;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
