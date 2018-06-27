package com.mi.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.multipart.MultipartFile;

import com.mi.model.Teacher;
import com.mi.model.Administrator;
import com.mi.model.Communique;
import com.mi.model.Document;
import com.mi.model.Role;
import com.mi.repositories.CommuniqueRepository;
import com.mi.repositories.CourseRepository;
import com.mi.repositories.DocumentRepository;
import com.mi.repositories.EventRepository;
import com.mi.repositories.GradeRepository;
import com.mi.repositories.JuryRepository;
import com.mi.repositories.LevelRepository;
import com.mi.repositories.OptionRepository;
import com.mi.repositories.RoleRepository;
import com.mi.repositories.TeachersRepository;

@Controller
@MultipartConfig(fileSizeThreshold=1024*1024*2,maxFileSize=1024*1024*10,maxRequestSize=1024*1024*50)
public class TeacherController {

	public static final Logger logger = LoggerFactory.getLogger(TeacherController.class);
	private static final String SAVE_DIR="SiteWebMI/Documents";


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

		return "homeTeacher";
	}



	//connexion d'un enseignant
	@RequestMapping(value = { "/loginTeacher" }, method = RequestMethod.GET)
	public String loginForm(Model model,HttpServletRequest req) {
		System.out.println("connexion  d'un enseignant get");

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
					UserDetails users = loadUserByUsername(login);
					//System.out.println("Humm tu as reussi a me mettre en session tu es forte ma petite 11111111111" + users);
					UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(users, null,
							users.getAuthorities());
					SecurityContextHolder.getContext().setAuthentication(authToken);

					Authentication auth = SecurityContextHolder.getContext().getAuthentication();

					if (!(auth instanceof AnonymousAuthenticationToken)) {
						System.out.println("Humm tu as reussi a me mettre en session tu es forte ma petite " + SecurityContextHolder.getContext().getAuthentication().getName());

						model.addAttribute("succes", "You have been login successfully."
								+SecurityContextHolder.getContext().getAuthentication().getName());
						req.setAttribute("succes", "You have been login successfully."
								+SecurityContextHolder.getContext().getAuthentication().getName());
						return "homeTeacher";
					}
					return "loginTeacher";



				} else {
					logger.error("Teacher with password {} not found.", password);
					model.addAttribute("error", "Password not found.");
					req.setAttribute("error", "Password not found.");
				}
			} else {
				logger.error("Teacher with password {} not found.", login);
				model.addAttribute("error", "login not found, teacher"+ login + "doesn't exist");
				req.setAttribute("error", "login not found, teacher"+ login + "doesn't exist");

			}
		} catch (Exception ex) {
			logger.error("Teacher with pseudonym {} not found.", login);
			model.addAttribute("error", "login not found, teacher"+ login + "doesn't exist");
			req.setAttribute("error", "login not found, teacher"+ login + "doesn't exist");
		}

		//return "redirect:/TeacherHome";
		return "loginTeacher";
	}

	//modifier les parametres de connexion get method
	@RequestMapping(value = { "/updateParameter" }, method = RequestMethod.GET)
	public String updateParameterGet(Model model,HttpServletRequest req) {
		System.out.println("modifier les parametre de connexion get");
		return "updateParameter";
	}

	@RequestMapping(value = { "/updateParameter" }, method = RequestMethod.POST)
	@Transactional
	public String updateParameterPost(Model model, HttpServletRequest req) throws ParseException {
		System.out.println("updateParameter Post");

		String login= req.getParameter("login");
		String password= req.getParameter("password");
		String teacherSession= SecurityContextHolder.getContext().getAuthentication().getName();
		Teacher teacher = teachersRepository.findByLogin(teacherSession);

		System.out.println(login);
		System.out.println(password);


		teacher.setLogin(login);
		teacher.setPassword(password);
		teachersRepository.save(teacher);

		model.addAttribute("teacher", "sucess ");

		return "updateParameter";
	}

	//ajouter un document
	@RequestMapping(value = { "/addDocument" }, method = RequestMethod.GET)
	public String addDocumentGet(Model model,HttpServletRequest req) {
		System.out.println("addDocument get");
		return "addDocument";
	}

	@RequestMapping(value = { "/addDocument" }, method = RequestMethod.POST)
	@Transactional
	public String addDocumentPost(Model model, HttpServletRequest req,@RequestParam("file") MultipartFile file) throws ParseException {
		
		String documentTitle= req.getParameter("documentTitle");
		String documentAbstract= req.getParameter("documentAbstract");
		String documentType= req.getParameter("documentType");
		String documentName= req.getParameter("documentName");
		String createDate= req.getParameter("createDate");
		
		String authorSession= SecurityContextHolder.getContext().getAuthentication().getName();
		Teacher author = teachersRepository.findByLogin(authorSession);
		
		int ret=upload(file,documentName,authorSession);
		Document document= new Document();
		
		if(ret==1){
			document.setDocumentAbstract(documentAbstract);
			document.setDocumentTitle(documentTitle);
			document.setAuthor(author);
		
			documentRepository.save(document);
			model.addAttribute("document", "document ajoute avec sucess");
			
			return "addDocumentSucess";
		}else{
			model.addAttribute("document", "erreur d'ajout du document");
			return "addDocument";
		}
	}








	//upload methode
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
