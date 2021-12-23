package demo.controller;

import demo.Bean.Password;
import demo.Bean.User;
import demo.mapper.PasswordMapper;
import demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class test {
    @Autowired
    UserMapper userMapper;
    @Autowired
    PasswordMapper passwordMapper;

    /**
     * 测试获取数据
     * @return
     */
    @RequestMapping("/getuser")
    public String add() {
        List<User> allUser = userMapper.getAllUser();
        for (User user : allUser) {
            System.out.println(user);
        }
        return "success";
    }
    /**
     * 测试获取数据
     * @return
     */
    @RequestMapping("/getpsd")
    public String addpsd() {
        List<Password> all = passwordMapper.getAll();
        for (Password user : all) {
            System.out.println(user);
        }
        return "success";
    }
    /**
     * 测试添加数据
     * @return
     */
    @RequestMapping("/deluser/{id}")
    public String addus(@PathVariable("id") int id) {
        System.out.println(userMapper.removeUser(id));
        return "success";
    }
    /**
     * 测试添加数据
     * @return
     */
    @RequestMapping("/delpsd/{id}")
    public String addwwpsd(@PathVariable("id") int id) {
        System.out.println(passwordMapper.removePassowrd(id));
        return "success";
    }
}
