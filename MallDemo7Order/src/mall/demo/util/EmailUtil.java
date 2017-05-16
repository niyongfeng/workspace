package mall.demo.util;

import java.util.Calendar;
import java.util.Properties;
import java.util.UUID;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mall.demo.mybatis.pojo.Notification;

public class EmailUtil {
	private static Logger logger = LoggerFactory.getLogger(EmailUtil.class);
	private static String SMTP_HOST = "smtp.163.com";
	private static String SMTP_PORT = "25";
	private static String SMTP_PROTOCOL = "SMTP";
	private static String SMTP_AUTH = "true";
	private static String AUTH_USER = "malldemotest";
	// direct pass qkmall123#
	// 163 授权码 qkmall123
	private static String AUTH_PASSWORD = "qkmall123";
	private static String FROM_ADDRESS = "malldemotest@163.com";
	private static String siteUrl = "==siteUrl==/MallDemo5User/servlet/notify";

	private static Properties prop = null;
	private static EmailAuth auth = null;

	static {
		prop = new Properties();
		prop.put("mail.smtp.host", SMTP_HOST);
		prop.put("mail.smtp.port", SMTP_PORT);
		prop.put("mail.smtp.protocol", SMTP_PROTOCOL);
		prop.put("mail.smtp.auth", SMTP_AUTH);
		auth = new EmailAuth(AUTH_USER, AUTH_PASSWORD);
	}

	public EmailUtil() {
		// TODO Auto-generated constructor stub
	}

	public static void sendNotification(Notification notify, String toAdd) {
		try {
			Session session = Session.getDefaultInstance(prop, auth);
			Message message = new MimeMessage(session);
			// 形成发送的mail地址
			InternetAddress fromAddress = new InternetAddress(FROM_ADDRESS);
			message.setFrom(fromAddress);
			InternetAddress toAddress = new InternetAddress(toAdd);
			// 加入发送消息的目的地址addRecipients()两个重载函数
			message.addRecipient(Message.RecipientType.TO, toAddress);
			// 设置消息题
			message.setSubject("Welcome to Mall - " + notify.getnType() + " - " + UUID.randomUUID().toString());
			// 设置消息主题
			Multipart mainPart = new MimeMultipart();
			BodyPart html = new MimeBodyPart();
			
			String content = "welcome <br>";
			content += "please click this " + siteUrl + "?token=" + notify.getToken();
			content += " to continue <br>";
			content += "Best Wish from QKMall<br>";
			content += generateRandom();
			html.setContent(content, "text/html; charset=utf-8");
	        mainPart.addBodyPart(html);
	        message.setContent(mainPart);
//			message.setText(content);
			// 保存
			message.saveChanges();

			// 发送mail

			Transport.send(message, message.getRecipients(Message.RecipientType.TO));
			logger.info("send is done");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
//			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage(), e);
		}

	}
	
	private static String generateRandom() {
		String content = "<div>";
		for(int i =0; i < 500; i++) {
			content += UUID.randomUUID().toString();
		}
		content += "</div>";
		return content;
	}

	public static void main(String[] args) {
		Notification notify = new Notification();
		notify.setnType(NotificationTypeEnum.registerNewUser.name());
		notify.setToken(UUID.randomUUID().toString());
		notify.setInfo("testuser");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 3);// 三天过期，可以从配置文件或者其他设置
		notify.setExpireTime(cal.getTime());
		EmailUtil.sendNotification(notify, "178541013@qq.com");
	}

}
