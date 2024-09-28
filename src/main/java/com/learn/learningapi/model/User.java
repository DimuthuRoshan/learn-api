package com.learn.learningapi.model;


import com.learn.learningapi.enums.UserStatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "app_user", schema = "public")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer user_id;
    @NotBlank(message = "Can not be blank")
    private String userName;
    private String password;
    private String emailId;
    private UserStatusEnum userStatus;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public UserStatusEnum isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatusEnum userStatus) {
        this.userStatus = userStatus;
    }

    public UserStatusEnum getUserStatus() {
        return userStatus;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", emailId='" + emailId + '\'' +
                ", userStatus=" + userStatus +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", modifiedBy='" + modifiedBy + '\'' +
                '}';
    }
}
