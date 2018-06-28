package com.mi.controller;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mi.model.Event;
import com.mi.model.Level;
import com.mi.model.Participation;
import com.mi.model.Student;
import com.mi.repositories.AcademicYearRepository;
import com.mi.repositories.AdministratorRepository;
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

			return "homeStudent";
		}
	
		// inscription a un evennement
		@RequestMapping(value = "/registrationStudent", method = RequestMethod.GET)
		public String registrationStudentGet(Model model) {
			System.out.println("registrationStudent get");

			return "registrationStudent";
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

			return "registrationStudent";
		}
		
		

	

	
}
