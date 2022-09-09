package com.bw.movie.utils;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Created by xyj on 2017/7/30.
 */
public class SendEmailUtil {

    private String host = ""; // smtp服务器
    private String from = ""; // 发件人地址
    private String user = ""; // 用户名
    private String pwd = ""; // 密码

    private static SendEmailUtil sendEmailUtil = null;

    public static SendEmailUtil init() {
        if (sendEmailUtil != null) {
            return sendEmailUtil;
        } else {
            EmailConfig emailConfig = EmailConfig.initConfig();
            sendEmailUtil = new SendEmailUtil();
            sendEmailUtil.from = emailConfig.getFrom();
            sendEmailUtil.user = emailConfig.getUser();
            sendEmailUtil.pwd = emailConfig.getPwd();
            sendEmailUtil.host = emailConfig.getHost();
            return sendEmailUtil;
        }
    }

    /**
     * 发送邮件
     *
     * @param to
     * @param title
     * @param content
     * @return
     */
    public boolean sendEmail(String to, String title, String content) {
        return send(to, title, content, null, null, null);
    }

    /**
     * 发送带附件的邮件
     *
     * @param to
     * @param title
     * @param content
     * @param affixPath
     * @param affixName
     * @return
     */
    public boolean sendEmail(String to, String title, String content, String affixPath, String affixName) {
        return send(to, title, content, affixPath, affixName, null);
    }

    /**
     * 发送带附件的邮件，入参是文件流
     *
     * @param to
     * @param title
     * @param content
     * @param inputStream
     * @return
     */
    public boolean sendEmail(String to, String title, String content, InputStream inputStream) {
        return send(to, title, content, "", "", inputStream);
    }

    private boolean send(String to, String title, String content, String affixPath, String affixName, InputStream inputStream) {
        Properties props = new Properties();

        // 设置发送邮件的邮件服务器的属性（这里使用网易的smtp服务器）
        props.put("mail.smtp.host", this.host);
        // 需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条）
        props.put("mail.smtp.auth", "true");

        // 用刚刚设置好的props对象构建一个session
        Session session = Session.getDefaultInstance(props);

        // 有了这句便可以在发送邮件的过程中在console处显示过程信息，供调试使
        // 用（你可以在控制台（console)上看到发送邮件的过程）
        session.setDebug(false);

        // 用session为参数定义消息对象
        MimeMessage message = new MimeMessage(session);
        try {
            // 加载发件人地址
            message.setFrom(new InternetAddress(this.from));
            // 加载收件人地址
            message.addRecipients(Message.RecipientType.TO, to);
            List<InternetAddress> list = new ArrayList();//不能使用string类型的类型，这样只能发送一个收件人
            String[] median = to.split(",");//对输入的多个邮件进行逗号分割
            for (int i = 0; i < median.length; i++) {
                list.add(new InternetAddress(median[i]));
            }
            InternetAddress[] address = (InternetAddress[]) list.toArray(new InternetAddress[list.size()]);
            message.addRecipients(Message.RecipientType.TO, address);
            // 加载标题
            message.setSubject(title);

            // 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
            Multipart multipart = new MimeMultipart();

            // 设置邮件的文本内容
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setText(content);
            multipart.addBodyPart(contentPart);
            // 添加附件
            BodyPart messageBodyPart = new MimeBodyPart();
            if (affixPath != null && !"".equals(affixPath)) {
                DataSource source = new FileDataSource(affixPath);
                // 添加附件的内容

                messageBodyPart.setDataHandler(new DataHandler(source));
                // 添加附件的标题
                // 这里很重要，通过下面的Base64编码的转换可以保证你的中文附件标题名在发送时不会变成乱码
                sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
                messageBodyPart.setFileName("=?GBK?B?" + enc.encode(affixName.getBytes()) + "?=");
                multipart.addBodyPart(messageBodyPart);
            } else if (inputStream != null && !"".equals(inputStream)) {
                DataSource source = new ByteArrayDataSource(inputStream, "application/png");
                messageBodyPart.setDataHandler(new DataHandler(source));
                // 添加附件的标题
                // 这里很重要，通过下面的Base64编码的转换可以保证你的中文附件标题名在发送时不会变成乱码
//                sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
                messageBodyPart.setFileName(new Date().getTime() + ".png");
                multipart.addBodyPart(messageBodyPart);
            }

            // 将multipart对象放到message中
            message.setContent(multipart);
            // 保存邮件
            message.saveChanges();
            // 发送邮件
            Transport transport = session.getTransport("smtp");
            // 连接服务器的邮箱
            transport.connect(this.host, this.user, this.pwd);
            // 把邮件发送出去
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        Thread sendEmail = new Thread(new SendEmailThread2("1510621690@qq.com"));
        sendEmail.start();
    }

}
