package com.barath.app.model;

import java.io.Serializable;

public class User implements Serializable {

    private Long userId;


    private String userName;


    private int userAge;


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
