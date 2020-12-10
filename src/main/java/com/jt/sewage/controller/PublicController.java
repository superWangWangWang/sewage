package com.jt.sewage.controller;

import com.jt.sewage.entity.SewageUser;
import com.jt.sewage.service.impl.UserServiceImpl;
import com.jt.sewage.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("public")
public class PublicController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("login")
    public String getLogin(){

        return "public/login";
    }

    @PostMapping("login")
    @ResponseBody
    public ResultVo postLogin(SewageUser user, HttpServletResponse response){
        ResultVo resultVo = new ResultVo();
        System.out.println(user+"==================");
        //查询
        SewageUser u = userServiceImpl.finUserByAccount(user.getAccount());
        if (u != null){
            if (u.getPwd().equals(user.getPwd())){
                if (u.getDelete() == 1){
                    resultVo.setMsg("账号已注销");
                }else {
                    request.getSession().setAttribute("user", user);
                    resultVo.setCode(0);
                    resultVo.setMsg("登录成功");
                    //将用户放进session
                    request.getSession().setAttribute("user", user);

                    Cookie cookie1 = new Cookie("sewage_account", user.getAccount());
                    Cookie cookie2 = new Cookie("sewage_password", user.getPwd());
                    cookie1.setMaxAge(60 * 60 * 24 * 7);
                    cookie2.setMaxAge(60 * 60 * 24 * 7);
                    cookie1.setPath("/");
                    cookie2.setPath("/");
                    response.addCookie(cookie1);
                    response.addCookie(cookie2);
                }
            }else {

                resultVo.setMsg("账号密码不匹配");
            }



        }else {
            resultVo.setMsg("账号密码不匹配");
        }
        return resultVo;
    }
}
