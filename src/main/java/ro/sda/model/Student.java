package ro.sda.model;

import javax.persistence.Column;
import java.util.Objects;

@javax.persistence.Entity
public class Student extends Entity {

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String cnp;

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cnp='" + cnp + '\'' +
                ", id=" + id +
                '}';
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id == student.id &&
                firstName.equals(student.firstName) &&
                lastName.equals(student.lastName) &&
                cnp.equals(student.cnp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, cnp, id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
