package com.mi.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
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

import com.mi.model.Communique;
import com.mi.model.Document;
import com.mi.model.Event;
import com.mi.model.Grade;
import com.mi.model.Jury;
import com.mi.model.ResearchDomain;
import com.mi.model.Result;
import com.mi.model.Student;
import com.mi.model.Teacher;
import com.mi.repositories.AcademicYearRepository;
import com.mi.repositories.AdministratorRepository;
import com.mi.repositories.ArticleRepository;
import com.mi.repositories.CommuniqueRepository;
import com.mi.repositories.CourseRepository;
import com.mi.repositories.CycleRepository;
import com.mi.repositories.DocumentRepository;
import com.mi.repositories.EventRepository;
import com.mi.repositories.GradeRepository;
import com.mi.repositories.JuryRepository;
import com.mi.repositories.LevelRepository;
import com.mi.repositories.OptionRepository;
import com.mi.repositories.ParticipationRepository;
import com.mi.repositories.ResearchDomainRepository;
import com.mi.repositories.ResultRepository;
import com.mi.repositories.RoleRepository;
import com.mi.repositories.StudentRepository;
import com.mi.repositories.TeachersRepository;

@Controller
public class InternetSurferController {
	
public static final Logger logger = LoggerFactory.getLogger(AdministratorController.class);
	
	private static final String SAVE_DIR="resources"+File.separator+"userResources"+File.separator+"img";

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
	
	@Autowired
	ResultRepository resultRepository;
	
	@Autowired
	DocumentRepository documentRepository;




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
	
	//Home principale pour les internautes
			@RequestMapping(value = "/index", method = RequestMethod.GET)
			public String homePrincipal(Model model) {
				System.out.println("home Principal get");
				
				List<Result> listOfResult = resultRepository.findAll();
				List<Document> listOfDocument = documentRepository.findAll();
				List<Teacher> listOfTeacher = teachersRepository.findAll();
				List<Event> listOfEvent = eventRepository.findAll();
				List<Communique> listOfCommunique = communiqueRepository.findAll();
				
				model.addAttribute("results", listOfResult);
				model.addAttribute("documents", listOfDocument);
				model.addAttribute("teachers", listOfTeacher);
				model.addAttribute("events", listOfEvent);
				model.addAttribute("communique", listOfCommunique);
				model.addAttribute("error", "");
				
				

				return "index";
			}
			
			//pour la consultation des evennements
			@RequestMapping(value = { "/viewEvent" }, method = RequestMethod.GET)
			public String viewEventGet(Model model,HttpServletRequest req) {
				System.out.println("viewEvent GET");

				List<Event> listOfEvent = eventRepository.findAll();

				if (listOfEvent.isEmpty() ) {
					model.addAttribute("error", "error : liste vide");
				}
				model.addAttribute("events", listOfEvent);

				return "viewEvent";
			}
			//pour la consultation des communique
			@RequestMapping(value = { "/viewNews" }, method = RequestMethod.GET)
			public String viewNewsGet(Model model,HttpServletRequest req) {
				System.out.println("listNews GET");
				

				List<Communique> listOfCommunique = communiqueRepository.findAll();

				if (listOfCommunique.isEmpty() ) {
					model.addAttribute("error", "liste vide");
				}
				model.addAttribute("communiques", listOfCommunique);

				return "viewNews";
			}
			//pour la consultation des resultats
			@RequestMapping(value = { "/viewResult" }, method = RequestMethod.GET)
			public String viewResultGet(Model model,HttpServletRequest req) {
				System.out.println("list result GET");

				List<Result> listOfResult = resultRepository.findAll();
				
				if (listOfResult.isEmpty() ) {
					model.addAttribute("error", "error : liste vide");
				}
				model.addAttribute("results", listOfResult);

				return "viewResult";
			}
			
			// information pour afficher la page personnelle
			@RequestMapping(value = "/viewPersonalPage", method = RequestMethod.GET)
			public String InformationTeacherGet(HttpServletRequest request, HttpServletResponse response, Model model) {
				System.out.println("viewPersonalPage get");
				model.addAttribute("error", "");
				
				String name = request.getParameter("idTeacher");
				Long idTeacher=Long.parseLong(name);
				
				Teacher teach = teachersRepository.findByIdTeacher(idTeacher);
				ResearchDomain recher= teach.getResearchDomain();
				Grade grade =teach.getGrade();
				Set<Jury> jury = teach.getJury();
				model.addAttribute("teachers", teach);
				model.addAttribute("researchDomains", recher);
				model.addAttribute("grades", grade);
				model.addAttribute("jurys", jury);
				
				return "viewPersonalPage";
			}

			
			
			//Connexion de l'enseignant et de l'etudiant
			
			@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
			public String loginFormGet(Model model,HttpServletRequest req) {
				System.out.println("connexion  page get");
				model.addAttribute("errorLogin", "");
				model.addAttribute("errorPassword", "");
				return "index";
			}

			@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
			public String loginStudentPost(Model model,@ModelAttribute("loginAdmin") Teacher admin, HttpServletRequest req,HttpServletResponse resp) throws IOException {
				System.out.println("connexion  page post");

				String login = req.getParameter("login");
				String password = req.getParameter("password");
				int etatEtudiant=0;
				int etatEnseignant=0;
				
				System.out.println("-------------------------------");
				System.out.println(login);
				System.out.println("-------------------------------");

				System.out.println("-------------------------------");
				System.out.println(password);
				// recherche du membre dans la base de donnees
				//try {
					//System.out.println("c'est le try");
				//	Student student =  studentRepository.findByLogin(login);
				//	Teacher teacher = teachersRepository.findByLogin(login);
					//System.out.println(student);
					
					if(studentRepository.findByLogin(login)==null){
						etatEtudiant=1;
					}else{
						etatEtudiant=11;
					}
					if(teachersRepository.findByLogin(login)==null){
						etatEnseignant=2;
					}else{
						etatEnseignant=22;
					}
					
					
					if(etatEtudiant==11){
						Student student =  studentRepository.findByLogin(login);
						String pass = cryptographe(password);
						System.out.println(pass);
						if (pass.equals(student.getPasswordSec())) {
							System.out.println("deuxieme if c'est moi de l'etudiant");
							
							HttpSession session = req.getSession();
							session.setAttribute( "student", student );
							
							Student studentName = (Student) session.getAttribute( "student" );
							
							System.out.println("je suis en session avec http et mon nom est : " + studentName.getLogin());
							
							model.addAttribute("students", "Vous etes connectez a votre espace personne. M./Mne." + studentName.getLogin());
							 
							resp.sendRedirect("homeStudent");
							return "student/homeStudent";

						} else {
							logger.error("Teacher with password {} not found.", password);
							model.addAttribute("errorPassword", "Mot de passe mal saisi.");
							model.addAttribute("modalOpen", true);
							req.setAttribute("errorPassword", "Mot de passe mal saisi.");
						}
						
					}
					
					if(etatEnseignant==22){
						Teacher teacher = teachersRepository.findByLogin(login);
						String pass = cryptographe(password);
						System.out.println(pass);
						if (pass.equals(teacher.getPasswordSec())) {
							System.out.println("deuxieme if de l'enseignant");
							
							HttpSession session = req.getSession();
							session.setAttribute( "teacher", teacher );
							
							Teacher teacherName = (Teacher) session.getAttribute( "teacher" );
							
							System.out.println("je suis en session avec http et mon nom est : " + teacherName.getLogin());
							
							model.addAttribute("teachers", "Vous etes connectez a votre espace personne. M. " + teacherName.getLogin());
							model.addAttribute("teachs", teacher);
							
							resp.sendRedirect("homeTeacher");
							return "teacher/homeTeacher";

						} else {
							logger.error("Teacher with password {} not found.", password);
							model.addAttribute("errorPassword", "Mot de passe mal saisi.");
							req.setAttribute("errorPassword", "Mot de passe mal saisi.");
							model.addAttribute("modalOpen", true);
						}
					}
					
					if(etatEtudiant==1 && etatEnseignant==2){
						model.addAttribute("errorLogin", "login mal saisi. l'utilisateur " + login + " n'existe pas");
						req.setAttribute("errorLogin", "login mal saisi, l'utilisateur "+ login + "n'existe pas");
						model.addAttribute("modalOpen", true);
					}
					
				return "index";
			}

			// masterAlgebra
			@RequestMapping(value = "/masterAlgebra", method = RequestMethod.GET)
			public String masterAlgebra(Model model) {
				System.out.println("masterAlgebra get");
				model.addAttribute("error", "");

				return "masterAlgebra";
			}
				
				// masterAnalysis
				@RequestMapping(value = "/masterAnalysis", method = RequestMethod.GET)
				public String masterAnalysis(Model model) {
					System.out.println("masterAnalysis get");
					model.addAttribute("error", "");


					return "masterAnalysis";

				}
				
				// masterRsd
				@RequestMapping(value = "/masterRsd", method = RequestMethod.GET)
				public String masterRsd(Model model) {
					System.out.println("masterRsd get");
					model.addAttribute("error", "");

					return "masterRsd";

				}
				
				// masterRsd
				@RequestMapping(value = "/licenceMi", method = RequestMethod.GET)
				public String licenceMi(Model model) {
					System.out.println("licenceMi get");
					model.addAttribute("error", "");

					return "licenceMi";

				}
				
				
				//Mes tests
				
				// editer le profil

				@RequestMapping(value = { "/editProfilTest" }, method = RequestMethod.GET)
				public String editProfilGet(Model model,HttpServletRequest req) {
					System.out.println("editProfil get");
					HttpSession session = req.getSession();
					Teacher authors =  (Teacher) session.getAttribute( "teacher" );
					List<ResearchDomain> listOfResearchDomain = researchDomainRepository.findAll();
					Teacher teacher = teachersRepository.findByLogin(authors.getLogin());

					if (listOfResearchDomain.isEmpty() ) {
						model.addAttribute("error", "error : liste vide");
					}
					model.addAttribute("researchDomains", listOfResearchDomain);
					model.addAttribute("teachers", teacher);

					//model.addAttribute("error", "");
					return "teacher/editProfilTest";
				}
				
				@Autowired
				ServletContext context;
				
				@RequestMapping(value = { "/editProfilTest" }, method = RequestMethod.POST)
				@Transactional
				public String editProfilPost(Model model, HttpServletRequest req,@RequestParam("files") MultipartFile file) throws ParseException, IOException {

					String domainLabel= req.getParameter("domainLabel");
					String phoneNumber= req.getParameter("phoneNumber");
					String lastName= req.getParameter("lastName");
					String firstName= req.getParameter("firstName");
					String emailAdress= req.getParameter("emailAdress");
					String sex= req.getParameter("sex");
					String birthPlace= req.getParameter("birthPlace");
					String gradeName= req.getParameter("grade");
					String birth= req.getParameter("birthDate");
					String description= req.getParameter("teacherDescription");

					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
					Date birthDate = sdf.parse(birth);

					HttpSession session = req.getSession();
					Teacher authors =  (Teacher) session.getAttribute( "teacher" );

					Teacher teacher = teachersRepository.findByLogin(authors.getLogin());

					ResearchDomain researchDomain=researchDomainRepository.findByDomainLabel(domainLabel);
					Grade grade = gradeRepository.findByGradeName(gradeName);

					if(teacher==null){
						model.addAttribute("error", "erreur d'ajout du document; veuillez vous connecter d'abord");

					}else{

						String pictureName= lastName+"_"+firstName+"profil.png";
						byte[] bytes = file.getBytes();
						File dir = new File(SAVE_DIR);
						if (!dir.exists())
							dir.mkdirs();

						BufferedOutputStream stream = new BufferedOutputStream(
								new FileOutputStream(context.getRealPath("") + File.separator  + SAVE_DIR + File.separator + pictureName));
						stream.write(bytes);
						stream.close();

						String pictureNames=context.getRealPath("") + File.separator  +SAVE_DIR + File.separator + pictureName;


						teacher.setBirthDate(birthDate);
						teacher.setPhoneNumber(phoneNumber);
						teacher.setResearchDomain(researchDomain);
						teacher.setBirthPlace(birthPlace);
						teacher.setDescriptionEnseignant(description);
						teacher.setEmailAdress(emailAdress);
						teacher.setFirstName(firstName);
						teacher.setGrade(grade);
						teacher.setSexe(sex);
						teacher.setLastName(lastName);
						teacher.setPictureName(pictureNames);


						teachersRepository.save(teacher);
						model.addAttribute("teachers", teacher);

					}
					return "teacher/editProfilTest";
				}


}
