package com.rjfoods.model;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {

	public static void successfullyRegister(String username, String userEmail) {

		String subject = "Welcome to RJ Foods Delivery! Registration is Successful";
		String body = "Thank you " + username + " for registering with RJ Foods Delivery! "
				+ "We are thrilled to have you on board. " + "Your registration has been successfully completed, "
				+ "and you can now enjoy a wide range of delicious meals delivered right to your doorstep.\n\n"
				+ "Best regards,\n" + "The RJ Foods Delivery Team";

		try {
			Mail.sendMail(userEmail, subject, body);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void forgotPassword(String userEmail, int otp) {

		String subject = "Forgot Passord ";
		String body = "Welcome to RJ foods " + "\nYour New Password is " + otp + " Best regards,\n"
				+ "The RJ Foods Delivery Team";

		try {
			Mail.sendMail(userEmail, subject, body);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void passwordChange(String userEmail, String otp) {

		String subject = "Password successfully changed ";
		String body = "Your Password is Succesfully changed " + "\nYour New Password is " + otp + " Best regards,\n"
				+ "The RJ Foods Delivery Team";

		try {
			Mail.sendMail(userEmail, subject, body);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void sendMail(String recipientMailId, String subject, String body) {

		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.port", "587");

		String emailId = "rhutikjagtap68@gmail.com"; // admin/company mail-id
		String password = "qaic lfwi pfrt arhn"; // generated password

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(emailId, password);
			}
		});

		try {
			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(emailId));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientMailId));
			message.setSubject(subject);
			message.setContent(body, "text/html");

			Transport.send(message);
			System.out.println("Message Sent Successfully!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
