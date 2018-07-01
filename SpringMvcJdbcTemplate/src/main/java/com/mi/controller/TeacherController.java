package com.mi.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

import com.mi.model.Teacher;
import com.mi.model.Administrator;
import com.mi.model.Communique;
import com.mi.model.Document;
import com.mi.model.Grade;
import com.mi.model.Jury;
import com.mi.model.ResearchDomain;
import com.mi.model.Role;
import com.mi.repositories.CommuniqueRepository;
import com.mi.repositories.CourseRepository;
import com.mi.repositories.DocumentRepository;
import com.mi.repositories.EventRepository;
import com.mi.repositories.GradeRepository;
import com.mi.repositories.JuryRepository;
import com.mi.repositories.LevelRepository;
import com.mi.repositories.OptionRepository;
import com.mi.repositories.ResearchDomainRepository;
import com.mi.repositories.RoleRepository;
import com.mi.repositories.TeachersRepository;

@Controller
@SessionAttributes("Teacher")
@MultipartConfig(fileSizeThreshold=1024*1024*2,maxFileSize=1024*1024*10,maxRequestSize=1024*1024*50)
public class TeacherController {

	public static final Logger logger = LoggerFactory.getLogger(TeacherController.class);
	private static final String SAVE_DIR=/*"C:"+File.separator+"Users"+File.separator+"MFOGO"+File.separator+"Documents"+File.separator+"Master1"+File.separator+"Semestre2"
			+ ""+File.separator+"Projet"+File.separator+"workspace"+File.separator+*/"SiteWebMI"+File.separator+"SpringMvcJdbcTemplate"+File.separator+"Documents";

	//C:\Program Files\Apache Software Foundation\Tomcat 7.0\webapps

	@Autowired
	DocumentRepository documentRepository;

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
	OptionRepository optionRepository;

	@Autowired
	ResearchDomainRepository researchDomainRepository;



	/*	@Autowired
	UserDetailsServices use;*/

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	private String error = "error message";

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

	//Home enseignant
	@RequestMapping(value = "/homeTeacher", method = RequestMethod.GET)
	public String homeTeacher(Model model) {
		System.out.println("home enseignant get");
		model.addAttribute("error", "");

		return "homeTeacher";
	}



	//connexion d'un enseignant
	@RequestMapping(value = { "/loginTeacher" }, method = RequestMethod.GET)
	public String loginForm(Model model,HttpServletRequest req) {
		System.out.println("connexion  d'un enseignant get");
		model.addAttribute("errorLogin", "");
		model.addAttribute("errorPassword", "");
		return "loginTeacher";
	}

	@RequestMapping(value = { "/loginTeacher" }, method = RequestMethod.POST)
	public String login(Model model,@ModelAttribute("loginAdmin") Teacher admin, HttpServletRequest req) {
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
			Teacher teacher = new Teacher();
			teacher = teachersRepository.findByLogin(login);
			System.out.println(teacher);
			if (teacher != null) {
				String pass = cryptographe(password);
				System.out.println(pass);
				if (pass.equals(teacher.getPasswordSec())) {
					System.out.println("deuxieme if c'est moi");
					
					HttpSession session = req.getSession();
					session.setAttribute( "teacher", teacher );
					
					Teacher teacherName = (Teacher) session.getAttribute( "teacher" );
					
					System.out.println("je suis en session avec http et mon nom est : " + teacherName.getLogin());
					
					model.addAttribute("teachers", "You have been login successfully." + teacherName.getLogin());
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
		return "loginTeacher";
	}

	//modifier les parametres de connexion get method
	@RequestMapping(value = { "/updateParameters" }, method = RequestMethod.GET)
	public String updateParameterGet(Model model,HttpServletRequest req) {
		System.out.println("modifier les parametre de connexion get");
		model.addAttribute("error", "");
		return "updateParameters";
	}

	@RequestMapping(value = { "/updateParameters" }, method = RequestMethod.POST)
	@Transactional
	public String updateParameterPost(Model model, HttpServletRequest req) throws ParseException {
		System.out.println("updateParameters Post");

		String login= req.getParameter("login");
		String password= req.getParameter("password");
		
		
		HttpSession session = req.getSession();
		Teacher teacher =  (Teacher) session.getAttribute( "teacher" );

		System.out.println(login);
		System.out.println(password);


		teacher.setLogin(login);
		teacher.setPassword(password);
		teachersRepository.save(teacher);

		model.addAttribute("teachers", "sucess ");

		return "updateParameters";
	}

	//ajouter un document
	@RequestMapping(value = { "/addDocument" }, method = RequestMethod.GET)
	public String addDocumentGet(Model model,HttpServletRequest req) {
		System.out.println("addDocument get");
		
		model.addAttribute("error", "");
		return "addDocument";
	}

	@RequestMapping(value = { "/addDocument" }, method = RequestMethod.POST)
	@Transactional
	public String addDocumentPost(Model model, HttpServletRequest req,@RequestParam("files") MultipartFile file) throws ParseException, IOException, ServletException {

		String documentTitle= req.getParameter("documentTitle");
		String documentDescription= req.getParameter("documentDescription");
		String documentType= req.getParameter("documentType");
		//String documentName= req.getParameter("documentName");
		//	String createDate= req.getParameter("createDate");
		

		Calendar calendarCourante = Calendar.getInstance();
		//int createYear = calendarCourante.get(Calendar.YEAR);
		int createMonth = calendarCourante.get(Calendar.YEAR);
		String createYear= createMonth+"";
	
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		//Date createDate = sdf.parse(createYear);
		
		try {
			HttpSession session = req.getSession();
			Teacher author =  (Teacher) session.getAttribute( "teacher" );
			
			String documentName= documentTitle+"_"+createYear+".pdf";
			System.out.println(author.getFirstName());
			byte[] bytes = file.getBytes();
			File dir = new File(SAVE_DIR);
			if (!dir.exists())
				dir.mkdirs();
			
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(SAVE_DIR + File.separator + documentName));
			stream.write(bytes);
			stream.close();
		
			String documentNames=SAVE_DIR + File.separator + documentName;
			Document document= new Document();

				document.setDocumentDescription(documentDescription);
				document.setDocumentTitle(documentTitle);
				document.setDocumentType(documentType);
				document.setDocumentName(documentNames);
			//	document.setCreateDate(createDate);
				document.setAuthor(author);

				documentRepository.save(document);
				model.addAttribute("documents", "document ajoute avec sucess");

			
			
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", "erreur d'ajout du document");
			
		}
		
		return "addDocument";
			/*
		*/
	}

	//modifier un document
	@RequestMapping(value = { "/updateDocument" }, method = RequestMethod.GET)
	public String updateDocumentGet(Model model,HttpServletRequest req) {
		System.out.println("updateDocument get");
		model.addAttribute("error", "");
		return "updateDocument";
	}


	@RequestMapping(value = { "/updateDocument" }, method = RequestMethod.POST)
	@Transactional
	public String updateDocumentPost(Model model, HttpServletRequest req,@RequestParam("file") MultipartFile file) throws ParseException {

		String documentTitle= req.getParameter("documentTitle");
		String documentDescription= req.getParameter("documentDescription");
		String documentType= req.getParameter("documentType");
		String documentName= req.getParameter("documentName");
		//	String createDate= req.getParameter("createDate");

		Calendar calendarCourante = Calendar.getInstance();
		//int createYear = calendarCourante.get(Calendar.YEAR);
		int createMonth = calendarCourante.get(Calendar.DATE);
		String createYear= createMonth+"";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date createDate = sdf.parse(createYear);


		HttpSession session = req.getSession();
		Teacher author =  (Teacher) session.getAttribute( "teacher" );
		
		System.out.println(author.getFirstName());

		String ret=upload(file,documentName,author.getFirstName());
		Document document= new Document();

		if(ret!=null){
			document.setDocumentDescription(documentDescription);
			document.setDocumentTitle(documentTitle);
			document.setDocumentType(documentType);
			document.setCreateDate(createDate);
			document.setAuthor(author);

			documentRepository.save(document);
			model.addAttribute("documents", "document ajoute avec sucess");

			return "updateDocument";
		}else{
			model.addAttribute("error", "erreur d'ajout du document");
			return "updateDocument";
		}
	}

	// editer le profil

	@RequestMapping(value = { "/editProfil" }, method = RequestMethod.GET)
	public String editProfilGet(Model model,HttpServletRequest req) {
		System.out.println("editProfil get");
		model.addAttribute("error", "");
		return "editProfil";
	}

	@RequestMapping(value = { "/editProfil" }, method = RequestMethod.POST)
	@Transactional
	public String editProfilPost(Model model, HttpServletRequest req,@RequestParam("file") MultipartFile file) throws ParseException {

		String domainLabel= req.getParameter("domainLabel");
		String phoneNumber= req.getParameter("phoneNumber");
		String birth= req.getParameter("birthDate");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date birthDate = sdf.parse(birth);

		HttpSession session = req.getSession();
		Teacher authors =  (Teacher) session.getAttribute( "teacher" );
		
		Teacher teacher = teachersRepository.findByLogin(authors.getLogin());

		ResearchDomain researchDomain=researchDomainRepository.findByDomainLabel(domainLabel);

		if(teacher==null){
			model.addAttribute("error", "erreur d'ajout du document; veuillez vous connecter d'abord");
			
		}else{
			teacher.setBirthDate(birthDate);
			teacher.setPhoneNumber(phoneNumber);
			teacher.setResearchDomain(researchDomain);
			teachersRepository.save(teacher);
			model.addAttribute("teachers", "profil edite avec succes");
		
		}
		return "editProfil";
	}
	
	// se deconnecter
		@RequestMapping(value = "/logoutTeacher", method = RequestMethod.GET)
		public String logoutPost(HttpServletRequest request, HttpServletResponse response, Model model) {

			  HttpSession session = request.getSession();
			  session.setAttribute( "teacher", null );
			  model.addAttribute("teachers", "la session a ete supprimme");

			return "connectionAdministrator";
		}

		// information pour afficher la page personnelle
		@RequestMapping(value = "/InformationTeacher", method = RequestMethod.GET)
		public String InformationTeacherGet(HttpServletRequest request, HttpServletResponse response, Model model) {
			System.out.println("InformationTeacher get");
			model.addAttribute("error", "");
			
			String name = request.getParameter("teacherName");
			
			Teacher teach = teachersRepository.findByLastName(name);
			ResearchDomain recher= teach.getResearchDomain();
			Grade grade =teach.getGrade();
			Set<Jury> jury = teach.getJury();
			model.addAttribute("teahers", teach);
			model.addAttribute("researchDomains", recher);
			model.addAttribute("grades", grade);
			model.addAttribute("jurys", jury);
			
			return "InformationTeacher";
		}









	//upload methode
	@SuppressWarnings("finally")
	String upload(MultipartFile file,String name,String option){
		String ret=null;
		try {
			byte[] bytes = file.getBytes();

			// Creating the directory to store file
			String rootPath = System.getProperty("catalina.home");
			//			File dir = new File(rootPath + File.separator + SAVE_DIR+File.separator+option);
			File dir = new File(SAVE_DIR);
			if (!dir.exists())
				dir.mkdirs();
			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath());
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
			ret=serverFile.getAbsolutePath();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return ret;
		}
	}
	

	//userDetails method
	//@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		System.out.println(login+" donne pardon");
		UserDetails userDetail=null;
		//Member user = memberRepository.findByPseudonym(pseudonym);
		Teacher teach = teachersRepository.findByLogin(login);
		System.out.println(teach.getLogin()+"tu es nulll???");
		if(teachersRepository.findByLogin(login)!=null) {

			System.out.println(teachersRepository.findByLogin(login)+"toototot");


			Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
			System.out.println("huoooo");
			for (Role role : teachersRepository.findByLogin(login).getRoles()){
				grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
				System.out.println("huoooo2222222222222222222"+ role);
			}
			System.out.println("huoooo333333333333333333");

			userDetail=new org.springframework.security.core.userdetails.User(teachersRepository.findByLogin(login).getLogin(), 
					teachersRepository.findByLogin(login).getPassword(), grantedAuthorities);
			System.out.println("huoooo444444444444444444444");

		}
		return userDetail;
	}


}
