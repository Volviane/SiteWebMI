package com.mi.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.mi.model.Article;
import com.mi.model.Cycle;
import com.mi.model.Document;
import com.mi.model.Event;
import com.mi.model.Level;
import com.mi.model.Option;
import com.mi.model.Participation;
import com.mi.model.Student;
import com.mi.model.Teacher;
import com.mi.repositories.AcademicYearRepository;
import com.mi.repositories.AdministratorRepository;
import com.mi.repositories.ArticleRepository;
import com.mi.repositories.CommuniqueRepository;
import com.mi.repositories.CourseRepository;
import com.mi.repositories.CycleRepository;
import com.mi.repositories.EventRepository;
import com.mi.repositories.GradeRepository;
import com.mi.repositories.JuryRepository;
import com.mi.repositories.LevelRepository;
import com.mi.repositories.OptionRepository;
import com.mi.repositories.ParticipationRepository;
import com.mi.repositories.ResearchDomainRepository;
import com.mi.repositories.RoleRepository;
import com.mi.repositories.StudentRepository;
import com.mi.repositories.TeachersRepository;

@Controller
@SessionAttributes("Student") 
@MultipartConfig(fileSizeThreshold=1024*1024*2,maxFileSize=1024*1024*10,maxRequestSize=1024*1024*50)
public class StudentController {
	
	public static final Logger logger = LoggerFactory.getLogger(AdministratorController.class);
	
	private static final String SAVE_DIR=/*"C:"+File.separator+"Users"+File.separator+"MFOGO"+File.separator+"Documents"+File.separator+"Master1"+File.separator+"Semestre2"
			+ ""+File.separator+"Projet"+File.separator+"workspace"+File.separator+*/"SiteWebMI"+File.separator+"SpringMvcJdbcTemplate"+File.separator+"Documents";

	
	@Autowired
	ResearchDomainRepository researchDomainRepository;
	
	@Autowired
	CycleRepository cycleRepository;

	@Autowired
	AcademicYearRepository academicYearRepository;

	
	@Autowired
	LevelRepository levelRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	GradeRepository gradeRepository;
	
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	TeachersRepository teachersRepository;

	@Autowired
	CommuniqueRepository communiqueRepository;

	@Autowired 
	JuryRepository juryRepository;


	@Autowired 
	EventRepository eventRepository;


	@Autowired
	AdministratorRepository administratorRepository;

	@Autowired
	OptionRepository optionRepository;
	
	@Autowired
	ParticipationRepository participationRepository;
	
	@Autowired
	ArticleRepository articleRepository;



	/*	@Autowired
	UserDetailsServices use;*/

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	/*chiffrement de mot de passe*/
	public static String cryptographe(String name) {

		String crypte = "";
		for (int i = 0; i < name.length(); i++) {
			int c = name.charAt(i) ^ 48;
			char crypteC = (char) c;
			/*if (crypteC == '\\') {
				crypte = crypte + "\\" + crypteC;
			}*/
			crypte = crypte + crypteC;
		}

		return crypte;
	}
	/*dechiffrement de mot de passe*/
	public static String decryptographe(String password) {
		String aCrypter = "";
		for (int i = 0; i < password.length(); i++) {
			int c = password.charAt(i) ^ 48;
			aCrypter = aCrypter + (char) c;
		}

		return aCrypter;
	}
	
	//Home etudiant
		@RequestMapping(value = "/homeStudent", method = RequestMethod.GET)
		public String homeStudent(Model model) {
			System.out.println("home etudiant get");
			model.addAttribute("error", "");

			return "student/homeStudent";
		}
	
		// inscription a un evennement
		@SuppressWarnings("unused")
		@RequestMapping(value = "/registrationStudent", method = RequestMethod.GET)
		public String registrationStudentGet(HttpServletRequest request,Model model) {
			System.out.println("registrationStudent get");
			model.addAttribute("error", "");
			
			String name = request.getParameter("idEvent");
			Long idEvent=Long.parseLong(name);
			Event event =eventRepository.findByIdEvent(idEvent);
			
			List<Option> listOfOption = optionRepository.findAll();
			List<String> finalList = new ArrayList<String>();
			
			
			
			List<Level> listOfLevel = levelRepository.findAll();
			//List<String> finalList = new ArrayList<String>();

			
			
			
			List<Event> listOfEvent = eventRepository.findAll();

			
			
			List<Cycle> cycles = cycleRepository.findAll();
			
			model.addAttribute("events", event);
			model.addAttribute("levels", listOfLevel);
			model.addAttribute("cycles", cycles);
			model.addAttribute("options", listOfOption);
			//model.addAttribute("events", listOfEvent);

			return "student/registrationStudent";
		}
		
		
		@RequestMapping(value = "/registrationStudent", method = RequestMethod.POST)
		public String registrationStudentPost(Model model , HttpServletRequest req) {
			System.out.println("registrationStudent Post");
			
			
			
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
			String matricule= req.getParameter("matricule");
			String studentLevel= req.getParameter("studentLevel");
			String eventName= req.getParameter("eventName");
			String email= req.getParameter("email");
			//String sexe= req.getParameter("sexe");
			String login = lastName;
			String password ="pass";
			
			List<Option> listOfOption = optionRepository.findAll();
			List<String> finalList = new ArrayList<String>();
			
			model.addAttribute("options", listOfOption);
			
			List<Level> listOfLevel = levelRepository.findAll();
			//List<String> finalList = new ArrayList<String>();

			
			model.addAttribute("levels", listOfLevel);
			
			List<Event> listOfEvent = eventRepository.findAll();

			
			model.addAttribute("events", listOfEvent);
			
			List<Cycle> cycles = cycleRepository.findAll();
			
			model.addAttribute("cycles", cycles);
			
			
			
			
			Level level=levelRepository.findByLevelName(studentLevel);
			Event event=eventRepository.findByEventTitle(eventName);
			
			Student student =new Student();
			Participation participation = new Participation();
			 
			
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setLogin(login);
			student.setPassword(bCryptPasswordEncoder.encode(password));
			student.setPasswordSec(cryptographe(password));
			student.setMatricule(matricule);
			student.setStudentLevel(level);
			student.setEmailAdress(email);
			try {
				studentRepository.save(student);
				
				Student stud = studentRepository.findByLogin(login);
				
				participation.setEvent(event);
				participation.setParticipant(stud);
				
				participationRepository.save(participation);
				
				String content1 = "Compte cr�� avec succ�s, vos informations se pr�sentent comme suit:  \n"
						+stud.getLastName() + " \n"
						+ stud.getLogin() +"\n"
						+ decryptographe(stud.getPasswordSec())+"\n"
						+ "...\n"
						+ "Pour vous connecter a votre espace personnel cliquez ici :\n"
						+ "http://localhost:8080/SpringMvcJdbcTemplate/login";
				String subject1="INSCRIPTION A UN EVENNEMENT";
				MimeMessage msg = new MimeMessage(session);
				/// msg.setFrom(new InternetAddress(form));
				msg.setRecipients(MimeMessage.RecipientType.TO, email);
				msg.setSubject(subject1);
				msg.setText(content1);
				msg.setSentDate(new Date());
				
				Transport transport = session.getTransport("smtp");
				transport.connect("smtp.gmail.com", "saphirmfogo@gmail.com", "best1234");
				transport.sendMessage(msg, msg.getAllRecipients());
				transport.close();
				System.out.println("Sent message successfully....");
				model.addAttribute("students", "creation du compte avec success avec les parametres :: " + login + " et " + password);
				req.setAttribute("teacherSucces", "succesfully to create teacher wiht parameter :: " + login + " and " + password);

				
			} catch (Exception e) {
				// TODO: handle exception
				model.addAttribute("error", "echec d'enregistrment");
			}

			return "student/registrationStudent";
		}
		
		
		
		

		//modifier les parametres de connexion get method
		@RequestMapping(value = { "/updateParameterStudent" }, method = RequestMethod.GET)
		public String updateParameterStudentGet(Model model,HttpServletRequest req) {
		
			System.out.println("modifier les parametre de connexion get");
			model.addAttribute("error", "");
			model.addAttribute("errorLogin", "");
			model.addAttribute("errorPassword", "");
			return "student/updateParameterStudent";
		}

		@RequestMapping(value = { "/updateParameterStudent" }, method = RequestMethod.POST)
		@Transactional
		public String updateParameterPost(Model model, HttpServletRequest req) throws ParseException {
			System.out.println("updateParameterStudent Post");

			String login= req.getParameter("login");
			String password= req.getParameter("password");
			String newlogin= req.getParameter("newLogin");
			String newpassword= req.getParameter("newPassword");
			
			
			HttpSession session = req.getSession();
			Student student =  (Student) session.getAttribute( "student" );

			System.out.println(login);
			System.out.println(password);
			System.out.println("=======================");
			System.out.println(newlogin);
			System.out.println(newpassword);
			
			
			if(student.getLogin().equals(login)){
				
				if (decryptographe(student.getPasswordSec()).equals(password)){
					
					student.setLogin(newlogin);
					student.setPassword(bCryptPasswordEncoder.encode(newpassword));
					student.setPasswordSec(cryptographe(newpassword));
					studentRepository.save(student);
				
				model.addAttribute("students", "vos parametres ont ete modifies");

				}else{
					model.addAttribute("errorPassword", "Veuillez entrez votre ancien mot de passe");
					
				}
			}else{
				model.addAttribute("errorLogin", "Veuillez entrez votre ancien login");
			}


			return "student/updateParameterStudent";
		}

		//ajouter un document
		@RequestMapping(value = { "/addArticle" }, method = RequestMethod.GET)
		public String addArticleGet(Model model,HttpServletRequest req) {
			System.out.println("addArticle get");
			
			model.addAttribute("error", "");
			return "student/addArticle";
		}

		@RequestMapping(value = { "/addArticle" }, method = RequestMethod.POST)
		@Transactional
		public String addDocumentPost(Model model, HttpServletRequest req,@RequestParam("files") MultipartFile file) throws ParseException, IOException, ServletException {

			String articleTitle= req.getParameter("articleTitle");
			String articleAbstract= req.getParameter("articleAbstract");
			String eventName= req.getParameter("eventName");

			Calendar calendarCourante = Calendar.getInstance();
			//int createYear = calendarCourante.get(Calendar.YEAR);
			int createMonth = calendarCourante.get(Calendar.YEAR);
			String createYear= createMonth+"";
		
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			//Date createDate = sdf.parse(createYear);
			
			try {
				HttpSession session = req.getSession();
				Student author =  (Student) session.getAttribute( "student" );
				Event event= eventRepository.findByEventTitle(eventName);
				Participation participation = participationRepository.findByParticipantAndEvent(author, event); 
				
				String articleName= articleTitle+"_"+createYear+".pdf";
				System.out.println(author.getFirstName());
				byte[] bytes = file.getBytes();
				File dir = new File(SAVE_DIR);
				if (!dir.exists())
					dir.mkdirs();
				
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(SAVE_DIR + File.separator + articleName));
				stream.write(bytes);
				stream.close();
			
				String articleNames=SAVE_DIR + File.separator + articleName;
				
				Article article= new Article();
				
				
				article.setArticleTitle(articleTitle);
				article.setArticleAbstract(articleAbstract);
				article.setArticleName(articleNames);
				article.setAuthor(author);
				
				articleRepository.save(article);
				
				Article art =articleRepository.findByArticleTitle(articleTitle);
				
				participation.setStudentArticle(art);
				
				participationRepository.save(participation);

				model.addAttribute("articles", "article ajoute avec sucess");
				model.addAttribute("partications", "mise a jour de la participation");

				
				
			} catch (Exception e) {
				// TODO: handle exception
				model.addAttribute("error", "erreur d'ajout de l'article");
				
			}
			
			return "student/addArticle";
				/*
			*/
		}
		
		//lister les article par evennement
		@RequestMapping(value = { "/listArticle" }, method = RequestMethod.GET)
		public String listArticleGet(Model model,HttpServletRequest req) {
			System.out.println("listArticle get");
			model.addAttribute("error", "");
			String eventTitle = req.getParameter("eventTItle");
			Event event= eventRepository.findByEventTitle(eventTitle);
			 
			List<Participation> participation =participationRepository.findByEvent(event);
			List<Article> article =new ArrayList<>() ;
			List<Student> student =new ArrayList<>() ;
			for(Participation part: participation){
				
				article.add(part.getStudentArticle());
				student.add(part.getParticipant());
			
			}
			
			model.addAttribute("articles", article);
			model.addAttribute("students", student);
			return "student/listArticle";
		}
		
		
		// se deconnecter
		@RequestMapping(value = "/logoutStudent", method = RequestMethod.GET)
		public String logoutStudentPost(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {

			  HttpSession session = request.getSession();
			  session.setAttribute( "student", null );
			  
			  model.addAttribute("students", "la session a ete supprimme");
			  
			  response.sendRedirect("index");

			return "index";
		}
		
		
		

		
		

	

	
}
