package cn.photoflash.user.smsUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.Properties;
import org.junit.Test;

public class SendSms {
	private static String apikey;
	private static String content; // 固定模板
	private static String registerContent;
	static {
		Properties pro = new Properties();
		try {
			pro.load(SendSms.class.getClassLoader().getResourceAsStream("sms_template.properties"));
		} catch (IOException e) {
			System.out.println("加载出错！");
		}
		apikey = pro.getProperty("apikey");
		content = pro.getProperty("content");
		registerContent = pro.getProperty("RegisterContent");
	}

	@Test
	public void fun2() {
		send("18186149445", "" + 1123312);
	}

	// 使用固定的末模板发送信息
	public static void send(String mobile, String code) {
		// 替换验证码
		String text = MessageFormat.format(content, code);
		try {
			JavaSmsApi.sendSms(apikey, text, mobile);
		} catch (IOException e) {
			System.out.println("发送信息失败！");
		}
	}

	// 使用固定的末模板发送信息
	public static void sendByPhone(String mobile, String code) {
		// 替换验证码
		String text = MessageFormat.format(registerContent, code);
		try {
			JavaSmsApi.sendSms(apikey, text, mobile);
		} catch (IOException e) {
			System.out.println("发送信息失败！");
		}
	}

	@Test
	public void fun() {
		System.out.println(apikey);
		String str = MessageFormat.format(content, 123);
		System.out.println(MessageFormat.format(content, 123));
		System.out.println(str);
		try {
			System.out.println(JavaSmsApi.getUserInfo(apikey));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		send("18186149445", "4534");
	}
}
