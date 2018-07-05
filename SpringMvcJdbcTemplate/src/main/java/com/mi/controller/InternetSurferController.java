package com.mi.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mi.model.Communique;
import com.mi.model.Document;
import com.mi.model.Event;
import com.mi.model.Result;
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
	
	//Home pricipal
			@RequestMapping(value = "/homePrincipal", method = RequestMethod.GET)
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
				
				

				return "homePrincipal";
			}
			
			
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


}
