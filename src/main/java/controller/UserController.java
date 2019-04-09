package controller;

import command.LoginCommand;
import command.UserCommand;
import domain.User;
import exception.UserBlockedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/","/index"})
    public String index(Model model){

        model.addAttribute("command",new LoginCommand());
        return "index";
    }

    @RequestMapping(value = {"/reg_form"})
    public String regForm(Model model){

        model.addAttribute("command",new UserCommand());
        return "reg_form";
    }

    @RequestMapping(value = {"/register"})
    public String register(@ModelAttribute("command") UserCommand cmd, Model model){

        User user=cmd.getUser();
        user.setRole(userService.ROLE_USER);
        user.setLoginStatus(userService.LOGIN_STATUS_ACTİVE);
        userService.register(user);

        return "redirect:index?act=red";
    }

    @RequestMapping(value = {"/logout"})
    public String logout(Model model,HttpSession session){
        session.invalidate();
        return "redirect:index?act=lo";
    }

    @RequestMapping(value = {"/login"},method = RequestMethod.POST)
    public String handleLogin(@ModelAttribute("command") LoginCommand cmd,Model m,HttpSession httpSession){

        try {
            User user= userService.login(cmd.getLoginName(),cmd.getPassword());

            if(user==null){

                m.addAttribute("err","Login Failed!.Enter please valid username and password.");
                return "index";
            }

            else{

                if(user.getRole()==userService.ROLE_ADMİN){
                    addUserInSession(user,httpSession);
                    return "redirect:admin/dashboard";
                }
                else if(user.getRole()==userService.ROLE_USER){
                    addUserInSession(user,httpSession);
                    return "redirect:user/dashboard";
                }
                else
                {
                    m.addAttribute("err","İnvalid Login Role");
                    return "index";
                }


            }

        } catch (UserBlockedException e) {

            m.addAttribute("err",e.getMessage());

            return "index";

        }
    }

    @RequestMapping(value = {"/user/dashboard"})
    public String userDashboard(){

        return "userdashboard";
    }

    @RequestMapping(value = {"/admin/dashboard"})
    public String adminDashboard(){

        return "admindashboard";
    }

    private void addUserInSession(User user, HttpSession session){

        session.setAttribute("user",user);
        session.setAttribute("userId",user.getUserId());
        session.setAttribute("role",user.getRole());
    }

}
