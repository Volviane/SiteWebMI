package com.mi.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mi.dao.ArticleDAO;
import com.mi.dao.StudentDAO;
import com.mi.model.Article;
import com.mi.model.User;

@Controller
@MultipartConfig(fileSizeThreshold=1024*1024*2,maxFileSize=1024*1024*10,maxRequestSize=1024*1024*50)
public class UploadController {
	String operationResult=null;
	@Autowired 
	ArticleDAO articleDAO;
	@Autowired
	StudentDAO studentDAO;

	private static final String SAVE_DIR="Doctoriales/Arcticles";

	static private int codes=0;

	@RequestMapping(value = "/interUpload", method = RequestMethod.GET)
	public String updateParameterGet1(Model model, HttpServletRequest req) {
		System.out.println("interUpdate get");
		operationResult="User Don't Exists";
		req.setAttribute("operationResult", operationResult);
		return "interUpload";
	}

	@RequestMapping(value = "/uploadArticle", method = RequestMethod.GET)
	public String uploadArticleGet(Model model) {
		System.out.println("/interUpload get");

		return "interUpload";
	}

	@RequestMapping(value = "/uploadArticle1", method = RequestMethod.POST)
	public String uploadArticlePost1(Model model, HttpServletRequest req) {
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String quality = req.getParameter("quality");

		User user=studentDAO.getByEmailAndPassword(email, password,quality);
		if(user!=null){
			req.setAttribute("user", user);
			return "uploadArticle";
		}
		else{
			return "redirect:/interUpload";
		}
	}

	int upload(MultipartFile file,String name,String option){
		int ret=0;
		try {
			byte[] bytes = file.getBytes();

			// Creating the directory to store file
			String rootPath = System.getProperty("catalina.home");
			File dir = new File(rootPath + File.separator + SAVE_DIR+"/"+option);
			if (!dir.exists())
				dir.mkdirs();

			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath()
					+ File.separator + name);
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
			ret=1;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return ret;
		}
	}
	
	@RequestMapping(value = "/uploadArticle", method = RequestMethod.POST)
	public String uploadArticlePost(HttpServletRequest req,@RequestParam("file") MultipartFile file,
			@RequestParam("userOption") String option, @RequestParam("userId") int userId1,
			@RequestParam("userLastName") String userLastName, 
			@RequestParam("userFirstName") String userFirstName,@RequestParam("title") String title,
			@RequestParam("abstract") String abstractArticle,
			@RequestParam("keywords") String keywords) {
		System.out.println("/uploadArticle post");
System.out.println("1++++++++");
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

		int userId=new Integer(userId1);
		String firstName=null;
		String subject1 = "Article Soumis ";
		System.out.println("2++++++++");
		List<String> emailAdress= new ArrayList<String>();
		emailAdress.add("miguelfoko@gmail.com");
		emailAdress.add("saphir@gmail.com");
		String articleName=userId+"_"+userLastName+"_"+userFirstName+"_"+option+".pdf";
		Article article=new Article(0, title, abstractArticle, SAVE_DIR+"/"+option+"/"+ articleName, keywords, userId);
		String content1 = "Article soumis avec succes, ci dessous, les informations le concernant  \n"
				+ article  ;
		try {
			System.out.println("3++++++++");
			int ret=upload(file,articleName,option);
			System.out.println("4++++++++");
			if(ret==1){
				int res=articleDAO.saveOrUpdate(article);
				System.out.println("5+++++");
				if(res==3){//Succ�s de l'op�ration
					String s=null;
					try{
						for(String email:emailAdress){
							MimeMessage msg = new MimeMessage(session);
							/// msg.setFrom(new InternetAddress(form));
							msg.setRecipients(MimeMessage.RecipientType.TO, email);
							System.out.println(email);
							msg.setSubject(subject1);
							msg.setText(content1);
							Multipart multipart = new MimeMultipart();
							MimeBodyPart messageBodyPart = new MimeBodyPart();
							DataSource source = new FileDataSource(articleName);
							messageBodyPart.setDataHandler(new DataHandler(source));
							messageBodyPart.setFileName(articleName.replaceAll(".*_/", ""));
							multipart.addBodyPart(messageBodyPart);
							msg.setContent(multipart);
							msg.setSentDate(new Date());
							Transport transport = session.getTransport("smtp");
							transport.connect("smtp.gmail.com", "saphirmfogo@gmail.com", "best1234");
							transport.sendMessage(msg, msg.getAllRecipients());
							transport.close();
							return "redirect:/uploadEnds";
						}
						
					}catch(Exception e){
						 return "redirect:/uploadEndsBut";
					}
				}else{
					if(res==4){
						return "redirect:/uploadFalse";
					}else{
						return "redirect:/uploadFalseOther";
					}
				}
			}else{
				return "redirect:/uploadFalseUnable";
			}

		} catch (Exception e) {
			// TODO: handle exception
		}




		return "redirect:/uploadFalse";
	}
	@RequestMapping(value = "/uploadEnds", method = RequestMethod.GET)
	public String uploadArticleGetC(Model model, HttpServletRequest req) {
		System.out.println("/uploadEnds get");
		operationResult="Upload r�ussie, consultez votre boite mail pour voir les informations relatives � votre "
				+ "soumission";
		req.setAttribute("operationResult", operationResult);
		return "interUpload";
	}

	@RequestMapping(value = "/uploadEndsBut", method = RequestMethod.GET)
	public String uploadArticleGetCC(Model model, HttpServletRequest req) {
		System.out.println("/uploadEndsBut get");
		operationResult="Upload r�ussie, Mais notification non envoy� � cause d'un probl�me li� au serveur de mail";
		req.setAttribute("operationResult", operationResult);
		return "interUpload";
	}

	@RequestMapping(value = "/uploadFalse", method = RequestMethod.GET)
	public String uploadArticleGetD(Model model, HttpServletRequest req) {
		System.out.println("/uploadFalse get");
		operationResult="Echec de l'op�ration, Probl�me interne � la base de donn�es";
		req.setAttribute("operationResult", operationResult);
		return "interUpload";
	}

	@RequestMapping(value = "/uploadFalseOther", method = RequestMethod.GET)
	public String uploadArticleGetDD(Model model, HttpServletRequest req) {
		System.out.println("/uploadFalseOther get");
		operationResult="Echec de l'op�ration, Probl_me de connexion � la Base de Donn�es";
		req.setAttribute("operationResult", operationResult);
		return "interUpload";
	}
	
	@RequestMapping(value = "/uploadFalseUnable", method = RequestMethod.GET)
	public String uploadArticleGetDDD(Model model, HttpServletRequest req) {
		System.out.println("/uploadFalseOther get");
		operationResult="Echec de l'op�ration, T�l�chargement du fichier impossible";
		req.setAttribute("operationResult", operationResult);
		return "interUpload";
	}
	// Modifier l'article

	@RequestMapping(value = "/updateArticle", method = RequestMethod.GET)
	public String updateArticleGet(Model model) {
		System.out.println("/updateArticle get");

		return "updateArticle";
	}


	@RequestMapping(value = "/updateArticle", method = RequestMethod.POST)
	public String updateArticlePost(Model model, HttpServletRequest req) {
		System.out.println("/updateArticle post");

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

		String codeSub= req.getParameter("codeSumission");
		String code= req.getParameter("codeRegistration");
		int codeRegistration= Integer.parseInt(code);
		String title= req.getParameter("title");
		String option= req.getParameter("option");
		String abstractArticle= req.getParameter("abstract");
		String firstName=null;
		String artcleNames1=null;

		File fichier = new File(artcleNames1);
		fichier.delete();

		String subject1 = "Soumission d'un article ";
		String content1 = "Soumission d'un article  \n"
				+ "le resume de cet article est :" + abstractArticle +
				" le code de soumission de cet article est " + codeSub  ;

		List<String> emailAdress= new ArrayList<String>();
		emailAdress.add("toto@gmail.com");
		emailAdress.add("saphir@gmail.com");

		File cheminFich= new File(SAVE_DIR);
		String artcleName=codeSub+"_"+firstName+"_"+title+".pdf";
		Part part=null;
		if(!cheminFich.exists()) cheminFich.mkdir();
		try {
			part=req.getPart("file");
			String artcleNames=SAVE_DIR + File.separator + artcleName;
			part.write(SAVE_DIR + File.separator + artcleName);


			for(String email:emailAdress){
				MimeMessage msg = new MimeMessage(session);
				/// msg.setFrom(new InternetAddress(form));
				msg.setRecipients(MimeMessage.RecipientType.TO, email);
				System.out.println(email);
				msg.setSubject(subject1);
				msg.setText(content1);
				Multipart multipart = new MimeMultipart();
				MimeBodyPart messageBodyPart = new MimeBodyPart();
				DataSource source = new FileDataSource(artcleName);
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(artcleName.replaceAll(".*_/", ""));
				multipart.addBodyPart(messageBodyPart);
				msg.setContent(multipart);
				msg.setSentDate(new Date());
				Transport transport = session.getTransport("smtp");
				transport.connect("smtp.gmail.com", "saphirmfogo@gmail.com", "best1234");
				transport.sendMessage(msg, msg.getAllRecipients());
				transport.close();
			}


		} catch (Exception e) {
			// TODO: handle exception
		}

		return "redirect:/updateArticle";
	}
}
