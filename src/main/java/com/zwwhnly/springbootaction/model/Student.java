package com.zwwhnly.springbootaction.model;

import javax.validation.constraints.*;

public class Student {
    @NotNull
    private String name;

    @NotNull
    @Min(7)
    private int age;

    @NotNull
    @Pattern(regexp = "^Man$|^Woman$|^UGM$")
    private String sex;

    /*@NotNull
    @Size(min = 1, max = 10)*/
    @Email
    @NotEmpty
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
