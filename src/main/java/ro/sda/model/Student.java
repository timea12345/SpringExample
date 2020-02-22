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

    @Column
    private String gender;

    @Column
    private int age;

    @Column
    private String email;

    public Student() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getFirstName() {
        return firstName;
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
        return age == student.age &&
                firstName.equals(student.firstName) &&
                lastName.equals(student.lastName) &&
                cnp.equals(student.cnp) &&
                gender.equals(student.gender) &&
                email.equals(student.email);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cnp='" + cnp + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, cnp, gender, age, email);
    }

    public static Builder newInstance() {
        return new Builder();
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String cnp;
        private String gender;
        private String email;
        private int age;

        public Builder cnp(String cnp) {
            this.cnp = cnp;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Student build() {
            Student student = new Student();

            student.setCnp(cnp);
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setGender(gender);
            student.setAge(age);
            student.setEmail(email);

            return student;
        }


    }
}
