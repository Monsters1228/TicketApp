package jee.ticket.domain;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    Long id;
    String username;
    String password;
    int status;                //0表示未激活，1表示激活
    Date createDate;
    String role; // ROLE_ADMIN表示管理员,ROLE_USER表示普通用户
    String email;
    String registerIp;
    public  User(){}
    //构造函数
    public User(String username, String password){
        this.username = username;
        this.password =password;
        this.status = 0;
        this.createDate = new Date();
        this.role ="ROLE_USER";
    }
}
