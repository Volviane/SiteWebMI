package com.mi.controller;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mi.dao.StudentDAO;
import com.mi.dao.TeacherDAO;
import com.mi.model.Student;
import com.mi.model.Teacher;
import com.mi.model.User;


@Controller

public class RegistrationController {
	String operationResult=null;
	@Autowired
	StudentDAO studentDAO;
	@Autowired
	TeacherDAO teacherDAO;
	static private int code=0;
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String uploadArticleGet(Model model) {
		System.out.println("/registration get");

		return "registration";
	}
	@RequestMapping(value = "/operationEnds", method = RequestMethod.GET)
	public String uploadArticleGetA(Model model, HttpServletRequest req) {
		System.out.println("/operationEnds get");
		operationResult="Op�ration r�ussie, consultez votre boite mail pour voir vos information sur notre plateforme";
		req.setAttribute("operationResult", operationResult);
		return "registration";
	}
	@RequestMapping(value = "/operationEndsBut", method = RequestMethod.GET)
	public String uploadArticleGetAA(Model model, HttpServletRequest req) {
		System.out.println("/operationEnds get");
		operationResult="Op�ration r�ussie (Serveur de mail non fonctionnel d'o� l'absence d'envoie de "
				+ "mail dans votre boite)";
		req.setAttribute("operationResult", operationResult);
		return "registration";
	}

	@RequestMapping(value = "/operationFalse", method = RequestMethod.GET)
	public String uploadArticleGetB(Model model, HttpServletRequest req) {
		System.out.println("/operationEnds get");
		operationResult="Echec de l'op�ration, cet utilisateur existe d�j�";
		req.setAttribute("operationResult", operationResult);
		return "registration";
	}

	@RequestMapping(value = "/operationFalseOther", method = RequestMethod.GET)
	public String uploadArticleGetBB(Model model, HttpServletRequest req) {
		System.out.println("/operationEnds get");
		operationResult="Echec de l'op�ration Pour des raisons li�es � la connexion � la Base de donn�es ";
		req.setAttribute("operationResult", operationResult);
		return "registration";
	}

	@RequestMapping(value = "/updateEnds", method = RequestMethod.GET)
	public String uploadArticleGetC(Model model, HttpServletRequest req) {
		System.out.println("/operationEnds get");
		operationResult="Mise � jour r�ussie, consultez votre boite mail pour voir vos information sur notre plateforme";
		req.setAttribute("operationResult", operationResult);
		return "interUpdate";
	}

	@RequestMapping(value = "/updateEndsBut", method = RequestMethod.GET)
	public String uploadArticleGetE(Model model, HttpServletRequest req) {
		System.out.println("/operationEnds get");
		operationResult="Mise � jour r�ussie (Serveur de mail non fonctionnel d'o� l'absence d'envoie de "
				+ "mail dans votre boite)";
		req.setAttribute("operationResult", operationResult);
		return "interUpdate";
	}

	@RequestMapping(value = "/updateFalse", method = RequestMethod.GET)
	public String uploadArticleGetD(Model model, HttpServletRequest req) {
		System.out.println("/operationEnds get");
		operationResult="Echec de l'op�ration, Pour des raisons li�es � l'ex�cution de la requ�te ";
		req.setAttribute("operationResult", operationResult);
		return "interUpdate";
	}
	@RequestMapping(value = "/updateFalseOther", method = RequestMethod.GET)
	public String uploadArticleGetDD(Model model, HttpServletRequest req) {
		System.out.println("/operationEnds get");
		operationResult="Echec de l'op�ration, Pour des raisons li�es � la connexion � la Base de donn�es";
		req.setAttribute("operationResult", operationResult);
		return "interUpdate";
	}


	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registrationPost(Model model, HttpServletRequest req) {
		/*System.out.println("registration post");

		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		// properties.put("mail.smtp.host", "smtp-relay.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.starttls.required", "false");
		properties.put("mail.smtp.connectiontimeout", "5000");
		properties.put("mail.smtp.timeout", "5000");
		properties.put("mail.smtp.writetimeout", "5000");
		Session session = Session.getInstance(properties, null);



		String firstName= req.getParameter("firstName");
		String lastName= req.getParameter("lastName");
		String universityName= req.getParameter("universityName");
		String option= req.getParameter("option");
		String email= req.getParameter("email");
		String quality= req.getParameter("quality");
		String sexe= req.getParameter("sexe");
		String labo= req.getParameter("laboratoire");
		int codeRegistration=code++;
		String login = lastName+firstName;
		String password = req.getParameter("password");

		String subject1 = "Registration Information";

		if(quality.equalsIgnoreCase("enseignant")){

			String grade= req.getParameter("grade");

			try{
				MimeMessage msg = new MimeMessage(session);
				/// msg.setFrom(new InternetAddress(form));
				msg.setRecipients(MimeMessage.RecipientType.TO, email);
				System.out.println(email);
				msg.setSubject(subject1);
				msg.setSentDate(new Date());
				Teacher teacher=new Teacher(0,lastName, firstName, universityName, email, 
						option, quality, password, labo, sexe);
				teacher.setGrade(grade);
				System.out.println(teacher);
				String content1 = "Compte cr�� avec succ�s, vos informations se pr�sentent comme suit:  \n"
						+teacher;
				msg.setText(content1);
				//Teacher s=teacherDAO.getByMail(teacher.getUserEmail());
				int res=teacherDAO.saveOrUpdate(teacher);
				if(res==3){//Succ�s de l'op�ration
					String s=null;
					try{
						Transport transport = session.getTransport("smtp");
						transport.connect("smtp.gmail.com", "saphirmfogo@gmail.com", "best1234");
						transport.sendMessage(msg, msg.getAllRecipients());
						transport.close();
						return "redirect:/operationEnds";
					}catch(Exception e){
						return "redirect:/operationEndsBut";
					}
				}else{
					if(res==4){
						return "redirect:/operationFalse";
					}else{
						return "redirect:/operationFalseOther";
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}

		}else if(quality.equalsIgnoreCase("etudiant")){

			String level= req.getParameter("level");

			try{
				MimeMessage msg = new MimeMessage(session);
				//msg.setFrom(new InternetAddress(form));
				msg.setRecipients(MimeMessage.RecipientType.TO, email);
				System.out.println(email);
				msg.setSubject(subject1);
				msg.setSentDate(new Date());

				Student student=new Student(0, lastName, firstName, universityName, email, 
						option, quality, password,labo,sexe);
				student.setStudentLevel(level);
				String content1 = "Compte cr�� avec succ�s, vos informations se pr�sentent comme suit:  \n"
						+student;
				msg.setText(content1);
				System.out.println("Insertion en attente+++++++++++++++++++++++++++++++");
				int res=studentDAO.saveOrUpdate(student);
				if(res==3){//Succ�s de l'op�ration
					String s=null;
					try{
						Transport transport = session.getTransport("smtp");
						transport.connect("smtp.gmail.com", "saphirmfogo@gmail.com", "best1234");
						transport.sendMessage(msg, msg.getAllRecipients());
						transport.close();
						System.out.println("Insertion r�ussie-----------------------------------");
						return "redirect:/operationEnds";
					}catch(Exception e){
						return "redirect:/operationEndsBut";
					}
				}else{
					if(res==4){
						return "redirect:/operationFalse";
					}else{
						return "redirect:/operationFalseOther";
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}*/

		return "redirect:/registration";
	}

	//Modification des parametres

	@RequestMapping(value = "/updateParameter", method = RequestMethod.GET)
	public String updateParameterGet(Model model, HttpServletRequest req) {
		System.out.println("interUpdate get");
		return "interUpdate";
	}

	@RequestMapping(value = "/interUpdate", method = RequestMethod.GET)
	public String updateParameterGet1(Model model, HttpServletRequest req) {
		System.out.println("interUpdate get");
		operationResult="User Don't Exists";
		req.setAttribute("operationResult", operationResult);
		return "interUpdate";
	}



	@RequestMapping(value = "/updateParameter", method = RequestMethod.POST)
	public String updateParameterPost(Model model, HttpServletRequest req) {
		System.out.println("updateParameter post");
		//		String codeRegistration = req.getParameter("codeRegistration");

		//chercher l'utilisateur ayant le codeReistration dans la bd et retourner a la vu 
		// avec model.addAllAttribute("Users" users) ou users est le dit utilisateur
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String quality = req.getParameter("quality");

		User user=studentDAO.getByEmailAndPassword(email, password,quality);
		if(user!=null){
			req.setAttribute("user", user);
			return "updateParameter";
		}
		else{
			return "redirect:/interUpdate";
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateParameterPost2(Model model, HttpServletRequest req) {
		/*System.out.println("update post");
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		// properties.put("mail.smtp.host", "smtp-relay.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.starttls.required", "false");
		properties.put("mail.smtp.connectiontimeout", "5000");
		properties.put("mail.smtp.timeout", "5000");
		properties.put("mail.smtp.writetimeout", "5000");
		Session session = Session.getInstance(properties, null);


		int userCode=new Integer(req.getParameter("userCode"));
		String firstName= req.getParameter("firstName");
		String lastName= req.getParameter("lastName");
		String universityName= req.getParameter("universityName");
		String option= req.getParameter("option");
		String email= req.getParameter("email");
		String quality= req.getParameter("quality");
		String sexe= req.getParameter("sexe");
		String labo= req.getParameter("laboratoire");
		String login = lastName+firstName;
		String password = req.getParameter("password");

		String subject1 = "Update Information";

		if(quality.equalsIgnoreCase("enseignant")){

			String grade= req.getParameter("grade");

			try{
				MimeMessage msg = new MimeMessage(session);
				msg.setRecipients(MimeMessage.RecipientType.TO, email);
				System.out.println(email);
				msg.setSubject(subject1);

				msg.setSentDate(new Date());
				Teacher teacher=new Teacher(userCode,lastName, firstName, universityName, email, 
						option, quality, password, labo, sexe);
				teacher.setGrade(grade);
				String content1 = "Mise � jour r�ussie de votre compte, vos nouvelles informations se pr�sentent comme suit:  \n"
						+teacher;
				msg.setText(content1);
				int res=teacherDAO.saveOrUpdate(teacher);
				if(res==1){//Succ�s de l'op�ration
					String s=null;
					try{
						Transport transport = session.getTransport("smtp");
						transport.connect("smtp.gmail.com", "saphirmfogo@gmail.com", "best1234");
						transport.sendMessage(msg, msg.getAllRecipients());
						transport.close();
						return "redirect:/updateEnds";
					}catch(Exception e){
						return "redirect:/updateEndsBut";
					}
				}else{
					if(res==2){
						return "redirect:/updateFalse";
					}else{
						return "redirect:/updateFalseOther";
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}

		}else if(quality.equalsIgnoreCase("etudiant")){

			String level= req.getParameter("level");

			try{
				MimeMessage msg = new MimeMessage(session);
				//msg.setFrom(new InternetAddress(form));
				msg.setRecipients(MimeMessage.RecipientType.TO, email);
				System.out.println(email);
				msg.setSubject(subject1);
				msg.setSentDate(new Date());

				Student student=new Student(userCode, lastName, firstName, universityName, email, 
						option, quality, password,labo,sexe);
				student.setStudentLevel(level);
				String content1 = "Mise � jour r�ussie de votre compte, vos nouvelles informations se pr�sentent comme suit:  \n"
						+student;
				msg.setText(content1);
				int res=studentDAO.saveOrUpdate(student);
				if(res==1){//Succ�s de l'op�ration
					String s=null;
					try{
						Transport transport = session.getTransport("smtp");
						transport.connect("smtp.gmail.com", "saphirmfogo@gmail.com", "best1234");
						transport.sendMessage(msg, msg.getAllRecipients());
						transport.close();
						return "redirect:/updateEnds";
					}catch(Exception e){
						return "redirect:/updateEndsBut";
					}
				}else{
					if(res==2){
						return "redirect:/updateFalse";
					}else{
						return "redirect:/updateFalseOther";
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}*/

		return "redirect:/registration";
	}

}
