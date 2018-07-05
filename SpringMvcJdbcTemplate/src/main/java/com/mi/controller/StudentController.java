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
import org.springframework.web.multipart.MultipartFile;

import com.mi.model.Article;
import com.mi.model.Document;
import com.mi.model.Event;
import com.mi.model.Level;
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

			return "student/homeStudent";
		}
	
		// inscription a un evennement
		@RequestMapping(value = "/registrationStudent", method = RequestMethod.GET)
		public String registrationStudentGet(Model model) {
			System.out.println("registrationStudent get");

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
			String login = lastName+firstName;
			String password =lastName+"pass";
			
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
				
				String content1 = "Compte créé avec succès, vos informations se présentent comme suit:  \n"
						+stud.getLastName() + " \n"
						+ stud.getLogin() +"\n"
						+ decryptographe(stud.getPasswordSec())+"\n"
						+ "...\n"
						+ "Pour vous connecter a votre espace personnel cliquez ici :\n"
						+ "http://localhost:8080/SpringMvcJdbcTemplate/connectionTeachers";
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
				model.addAttribute("students", "succesfully to create student wiht parameter :: " + login + " and " + password);
				req.setAttribute("teacherSucces", "succesfully to create teacher wiht parameter :: " + login + " and " + password);

				
			} catch (Exception e) {
				// TODO: handle exception
				model.addAttribute("error", "echec d'enregistrment");
			}

			return "student/registrationStudent";
		}
		
		
		
		//connexion d'un enseignant
		@RequestMapping(value = { "/loginStudent" }, method = RequestMethod.GET)
		public String loginFormGet(Model model,HttpServletRequest req) {
			System.out.println("connexion  d'un etudiant get");
			model.addAttribute("errorLogin", "");
			model.addAttribute("errorPassword", "");
			return "student/loginStudent";
		}

		@RequestMapping(value = { "/loginStudent" }, method = RequestMethod.POST)
		public String loginStudentPost(Model model,@ModelAttribute("loginAdmin") Teacher admin, HttpServletRequest req) {
			System.out.println("connexion  d'un enseignant post");

			String login = req.getParameter("login");
			String password = req.getParameter("password");
			System.out.println("-------------------------------");
			System.out.println(login);
			System.out.println("-------------------------------");

			System.out.println("-------------------------------");
			System.out.println(password);
			// recherche du membre dans la base de donnees
			try {
				System.out.println("c'est le try");
				Student student =  studentRepository.findByLogin(login);
				System.out.println(student);
				if (student != null) {
					String pass = cryptographe(password);
					System.out.println(pass);
					if (pass.equals(student.getPasswordSec())) {
						System.out.println("deuxieme if c'est moi");
						
						HttpSession session = req.getSession();
						session.setAttribute( "student", student );
						
						Student studentName = (Student) session.getAttribute( "student" );
						
						System.out.println("je suis en session avec http et mon nom est : " + studentName.getLogin());
						
						model.addAttribute("teachers", "You have been login successfully." + studentName.getLogin());
						return "homeTeacher";

					} else {
						logger.error("Teacher with password {} not found.", password);
						model.addAttribute("errorPassword", "Password not found.");
						req.setAttribute("errorPassword", "Password not found.");
					}
				} else {
					logger.error("Teacher with password {} not found.", login);
					model.addAttribute("errorLogin", "login not found, teacher"+ login + "doesn't exist");
					req.setAttribute("errorLogin", "login not found, teacher"+ login + "doesn't exist");

				}
			} catch (Exception ex) {
				logger.error("Teacher with pseudonym {} not found.", login);
				model.addAttribute("errorLogin", "login not found, teacher"+ login + "doesn't exist");
				req.setAttribute("errorLogin", "login not found, teacher"+ login + "doesn't exist");
			}

			//return "redirect:/TeacherHome";
			return "student/loginStudent";
		}

		//modifier les parametres de connexion get method
		@RequestMapping(value = { "/updateParameterStudent" }, method = RequestMethod.GET)
		public String updateParameterStudentGet(Model model,HttpServletRequest req) {
			System.out.println("modifier les parametre de connexion get");
			model.addAttribute("error", "");
			return "student/updateParameterStudent";
		}

		@RequestMapping(value = { "/updateParameterStudent" }, method = RequestMethod.POST)
		@Transactional
		public String updateParameterPost(Model model, HttpServletRequest req) throws ParseException {
			System.out.println("updateParameterStudent Post");

			String login= req.getParameter("login");
			String password= req.getParameter("password");
			
			
			HttpSession session = req.getSession();
			Student student =  (Student) session.getAttribute( "student" );

			System.out.println(login);
			System.out.println(password);


			student.setLogin(login);
			student.setPassword(password);
			studentRepository.save(student);

			model.addAttribute("students", "sucess ");

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
		public String logoutStudentPost(HttpServletRequest request, HttpServletResponse response, Model model) {

			  HttpSession session = request.getSession();
			  session.setAttribute( "student", null );
			  model.addAttribute("students", "la session a ete supprimme");

			return "student/loginStudent";
		}
		
		
		

		
		

	

	
}
