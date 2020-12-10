package com.jt.sewage.utils;

import com.jt.sewage.entity.SewageEmail;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
public class EmailUtils {
    public static void sendEmail(String msg, List<SewageEmail> emailList) throws MessagingException {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        // 创建Properties 类用于记录邮箱的一些属性
        Properties props = new Properties();
        // 表示SMTP发送邮件，必须进行身份验证
        props.put("mail.smtp.auth", "true");
        //此处填写SMTP服务器
        props.put("mail.smtp.host", "smtp.qq.com");
        //端口号，QQ邮箱端口587
        props.put("mail.smtp.port", "587");
        // 此处填写，写信人的账号
        props.put("mail.user", "");
        // 此处填写16位STMP口令
        props.put("mail.password", "");

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
        message.setFrom(form);

        // 设置收件人的邮箱
        String mList = "";
        for (int i = 0 ;i< emailList.size();i++){
            if (emailList.get(i).getDelete() == 0){
                mList = mList + emailList.get(i).getEmail();
                if (i != emailList.size() - 1){
                    mList = mList + ",";
                }
            }

        }
        //System.out.println("======================="+mList);
        if (mList != ""){//有需要发送的人员才进行下一步
            InternetAddress[] to = InternetAddress.parse(mList);
            //InternetAddress[] to = InternetAddress.parse("81297297@qq.com,876335051@qq.com,790816030@qq.com");
            message.setRecipients(RecipientType.TO, to);
            //message.addRecipients(RecipientType.TO,to);

//            Address[] allRecipients = message.getAllRecipients();
//            for(Address a : allRecipients){
//                System.out.println("======================="+a.toString());
//            }

            // 设置邮件标题
            message.setSubject("监控警报");

            // 设置邮件的内容体
            String content = "【" + time + "】<br> 数据出现异常,请及时处理！" +
                    "<br>" + msg +
                    "<br> " +
                    "http://115.159.93.246:6767/sewage/user/index";

            message.setContent(content, "text/html;charset=UTF-8");

            // 最后当然就是发送邮件啦
            Transport.send(message);
        }



    }
}
