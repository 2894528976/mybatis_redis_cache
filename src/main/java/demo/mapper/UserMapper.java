package demo.mapper;

import demo.Bean.Password;
import demo.Bean.User;
import demo.config.RedisCache;
import lombok.Data;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {
//    @Insert("  insert into user(name) values (#{name})")
    int addUser(User user);
//    @Insert("    insert into user(name) values (#{name}) insert into password(password) values (#{password})")
    int addUserAndPassword(User user, Password password);
//    @Delete("delete user where id=#{id}")
    int removeUser(int id);
//
    User getUser(int id);
    List<User> getUserByUserName(String name);
//    @Select("    select * from user")
    List<User> getAllUser();
}
