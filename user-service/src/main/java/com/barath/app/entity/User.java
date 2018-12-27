package com.barath.app.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;


/**
 * 
 * @author barath
 *
 */
@Entity
@Table(name="USER")
public class User implements Serializable {

	private static final long serialVersionUID = 5954679009373777305L;

	@Id
    @Column(name="USER_ID")
    private Long userId;

    @Column(name="USER_NAME")
    @NotNull(message="user name cannot be null")
    private String userName;

    @Column(name="USER_AGE")
    @NotNull(message="user age cannot be null")
    private int userAge;

    @Column(name="USER_GENDER")
    @Enumerated(EnumType.STRING)
    private Gender userGender;

    public enum Gender{
        MALE,FEMALE
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public Gender getUserGender() {
        return userGender;
    }

    public void setUserGender(Gender userGender) {
        this.userGender = userGender;
    }

    public User(Long userId, String userName, int userAge, Gender userGender) {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
        this.userGender = userGender;
    }

    protected User() {
    }

    @Override
    public String toString() {
        return "USER{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", userGender=" + userGender +
                '}';
    }
}
