package com.jt.sewage.interceptor;




import com.jt.sewage.entity.SewageUser;
import com.jt.sewage.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 拦截器
 */

public class MyInterceptor implements HandlerInterceptor {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();
        HttpSession session = request.getSession();


        //登录页面和登录接口的url不拦截  ///talent/public/login
        System.out.println("--------------" + path);
        if ("/".equals(path) || "/public/".equals(path) || "/public".equals(path)){
            response.sendRedirect(request.getContextPath()+"/public/login");
            return false;
        }


        if (path.indexOf("public") != -1 || "/error".equals(path)){//访问的是公共路径，允许
            return true;
        }else {
            //查询session是否有user对象
            SewageUser user = (SewageUser)request.getSession().getAttribute("user");
            if (user == null){//没有登录，不允许访问
                if (checkLogin(request)){
                    //需要判断身份
                    return true;
                }else {
                    response.sendRedirect(request.getContextPath() + "/public/login");
                    return false;
                }
            }else {
                //需要判断是不是 用户/公司 user.type
               return true;
            }
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //System.out.println("postHandle==========================");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //System.out.println("afterCompletion==========================");
    }

    /**
     * 检查是否cookies中有登录痕迹
     * @return
     */
    private boolean checkLogin(HttpServletRequest request){

        Cookie[] cookies = request.getCookies();
        String account = "";//account
        String pwd = "";//account
        if (cookies != null){

            for (Cookie c : cookies){
                if ("sewage_account".equals(c.getName())){
                    account = c.getValue();
                    System.out.println("cookies账号======"+account);
                }
                if ("sewage_password".equals(c.getName())){
                    pwd = c.getValue();
                    System.out.println("cookies密码======"+pwd);
                }
            }
            //查询数据库
            SewageUser user = userServiceImpl.finUserByAccount(account);
            if (user != null){
                if (user.getPwd().equals(pwd)){
                    if (user.getDelete() == 0){
                        request.getSession().setAttribute("user",user);
                        return true;
                    }else {
                        return false;
                    }

                }
            }

        }
        return false;
    }
}
