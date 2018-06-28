package com.mi.controller;

import javax.servlet.annotation.MultipartConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
import com.mi.repositories.ResearchDomainRepository;
import com.mi.repositories.RoleRepository;
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

	

	
}
