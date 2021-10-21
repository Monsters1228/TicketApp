package jee.ticket.dao;

import jee.ticket.domain.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao {
    //使用静态变量，只保存一份副本
    private  static  List<User> userList  = new ArrayList<User>();;
    //静态变量， 用户ID号，全局唯一
    private static  volatile long USER_ID_SEQUENCE = 5000;
    //构造函数
    public UserDao(){
        //只初始化1次,添加
        if(userList.size()==0) {
            //初始化数据
            for (int i = 0; i < 10; ++i) {
                User user = new User("user"+i, "user"+i);
                user.setStatus(1);
                user.setEmail("test@aliyun.oom");
                this.insert(user);
            }
            //添加管理员
            User admin = new User("admin" , "123");
            admin.setRole("ROLE_ADMIN");
            this.insert(admin);
        }
    }
    //根据id查找User对象
    public User findById(long id){
        return userList.stream().filter(u -> u.getId() == id)
                .findFirst().get();
    }
    //根据用户名查找User对象
    public User findByUsernamePassWord(final String username, final String password){
        // 使用函数式编程
        return userList.stream().filter(user -> // 使用filter过滤
                user.getUsername().equals(username)
                        && user.getPassword().equals(password))
                .findFirst().get();
    }
    //查找所有的User对象
    public List findAll(){
        return userList;
    }
    // 添加用户,使用同步加锁
    public synchronized void insert(User user){
        //生成用户id
        USER_ID_SEQUENCE++;
        user.setId(USER_ID_SEQUENCE);
        userList.add(user);
        System.out.println(user+": "+userList.size());
    }
    //删除用户
    public void deleteById(long id) {
        User user = userList.stream().filter(u -> u.getId() == id)
                .findFirst().get();
        userList.remove(user);
    }
}

