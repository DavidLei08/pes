package com.wang.controller;

import com.wang.pojo.Student;
import com.wang.pojo.User;
import com.wang.service.user.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;


@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model model){
        //获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登陆数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        try{
            subject.login(token);//执行登录的方法，如果没有异常就说明OK了
            Session session = subject.getSession();
            session.setAttribute("username",username);

            return "redirect:index";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }

    @RequestMapping("/user/list")
    public String userList(Model model){
        List<User> users = userService.queryUserList();
        model.addAttribute("users",users);
        return "user/list";
    }

    @RequestMapping("/user/role/{id}")
    public String userRole(@PathVariable Integer id,Model model){
        User user = userService.queryUserById(id);
        model.addAttribute("user",user);
        return "user/update";
    }

    @RequestMapping("/user/role/deal")
    @ResponseBody
    public HashMap<String, String> userRoleDeal(@RequestBody User user){
        HashMap<String, String> map = new HashMap<>();
        int i = userService.updateUser(user);
        if (i==1){
             map.put("msg","更改成功");
        }else{
             map.put("msg","更改失败");
        }
        return map;
    }

    @RequestMapping("/user/delete/{id}")
    @ResponseBody
    public HashMap deleteUser(@PathVariable Integer id){
        HashMap<String, String> map = new HashMap<>();
        if (userService.deleteUserById(id)==1){
            map.put("msg","删除成功");
        }else{
            map.put("msg","删除失败");
        }
        return map;
    }
}
