package ro.sda.model;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.util.Objects;

@javax.persistence.Entity
public class Student extends Entity {

    @Column
    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @Column
    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @Column
    @Size(min = 13, max = 13, message = "not valid")
    @Digits(integer = 13, fraction = 0, message = "CNP must have only digits")
    private String cnp;

    @Column
    @NotBlank(message = "Gender is mandatory")
    private String gender;

    @Column
    @Min(value = 1, message = "Age has to be at least 1")
    @Max(value = 80, message = "Age has to be max 80")
    @NotNull(message = "not null!!")
    private Integer age;

    @Column
    @NotBlank(message = "Email is mandatory")
    @Email(message = "email has to be valid")
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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
