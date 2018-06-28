package com.mi.controller;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mi.model.AcademicYear;
import com.mi.model.Administrator;
import com.mi.model.Communique;
import com.mi.model.Course;
import com.mi.model.Cycle;
import com.mi.model.Event;
import com.mi.model.Grade;
import com.mi.model.Jury;
import com.mi.model.Level;
import com.mi.model.Option;
import com.mi.model.ResearchDomain;
import com.mi.model.Role;
import com.mi.model.Teacher;
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
@SessionAttributes("Administrator") 
public class AdministratorController/* implements UserDetailsService */{
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

	//Home administrator
	@RequestMapping(value = "/homeAdministrator", method = RequestMethod.GET)
	public String homeAdmin(Model model) {
		System.out.println("home admin get");

		return "homeAdministrator";
	}

	//Add role get methode
	@RequestMapping(value = "/addRole", method = RequestMethod.GET)
	public String roleGet(Model model) {
		System.out.println("addrole get");

		return "addRole";
	}

	//Add role post methode
	@RequestMapping(value = "/addRole", method = RequestMethod.POST)
	public String rolePost(Model model, HttpServletRequest req)  {
		System.out.println("addrole post");

		String roleName= req.getParameter("nameRole");
		Role roles = new Role();
		if (roleName.equalsIgnoreCase("ROLE_STUDENTS")) {
			roleRepository.save(roles);
			//role.setUsers(new HashSet<>(studentRepository.findAll()));
			//roleRepository.save(role);
		} else if (roleName.equalsIgnoreCase("ROLE_TEACHERS")) {
			roleRepository.save(roles);
			//role.setAdmin(new HashSet<>(teachersRepository.findAll()));
			//roleRepository.save(role);

		} else if (roleName.equalsIgnoreCase("ROLE_ADMIN")) {
			//role.setName(roleName);
			roles.setRoleName(roleName);
			//roles.setAdmins(new HashSet<>(administratorRepository.findAll()));
			try {
				roleRepository.save(roles);
				System.out.println("done");
				model.addAttribute("roles", roles);
				req.setAttribute("role", roles);
			} catch (Exception e) {
				model.addAttribute("error", "echec d'enregistrement");
				// TODO: handle exception
			}
			
		}
		
		return "addRole";
	}
	//Liste role method
	@RequestMapping(value = { "/roleList" }, method = RequestMethod.GET)
	public String roleList(Model model,HttpServletRequest req) {
		System.out.println("listrole");

		List<Role> listOfRole = roleRepository.findAll();
		for(Role r:listOfRole){
			System.out.println(r.getRoleName());
		}
		if (listOfRole.isEmpty()) {
			model.addAttribute("error", error);
		}
		model.addAttribute("roles", listOfRole);
		req.setAttribute("roles", listOfRole);
		return "roleList";
	}


	//create administrator get method
	@RequestMapping(value = { "/registrationAdministrator" }, method = RequestMethod.GET)
	public String createForm(Model model,HttpServletRequest req) {
		System.out.println("inscription d'un admin");
		return "registrationAdministrator";
	}
	//create administrator post method
	@RequestMapping(value = { "/registrationAdministrator" }, method = RequestMethod.POST)
	public String create(Model model,HttpServletRequest req) {
		System.out.println("inscription d'un admin");

		String login= req.getParameter("login");
		String password= req.getParameter("password");
		Role role = roleRepository.findByRoleName("ROLE_ADMIN");
		Set<Role> rolelist=new HashSet<Role>();
		rolelist.add(role);
		Administrator administrator= new Administrator();
		administrator.setLogin(login);
		administrator.setPassword(bCryptPasswordEncoder.encode(password));
		administrator.setPasswordSec(cryptographe(password));
		//	administrator.setRoles(rolelist);
		//Modification de setRole(idRole) en setRole(role)
		administrator.getRoles().add(role);
		//administratorRepository.deleteAll();
		
		try {
			administratorRepository.save(administrator);
			System.out.println("done");
			model.addAttribute("administrators", "succesfully to create administrator wiht parameter :: " + login + " and " + password);
			req.setAttribute("administrators", "succesfully to create administrator wiht parameter :: " + login + " and " + password);

		} catch (Exception e) {
			model.addAttribute("error", "echec d'enregistrement");
			// TODO: handle exception
		}

		
		return "registrationAdministrator";
	}

	//connexion d'un administrateur

	@RequestMapping(value = { "/connectionAdministrator" }, method = RequestMethod.GET)
	public String loginForm(Model model,HttpServletRequest req) {
		System.out.println("connexion  d'un admin");

		return "connectionAdministrator";
	}

	@RequestMapping(value = { "/connectionAdministrator" }, method = RequestMethod.POST)
	public String login(Model model,@ModelAttribute("loginAdmin") Administrator admin, HttpServletRequest req) {
		System.out.println("connexion  d'un admin");

		String loginAdmin = req.getParameter("login");
		String passwordAdmin = req.getParameter("password");
		System.out.println("-------------------------------");
		System.out.println(loginAdmin);
		System.out.println("-------------------------------");

		System.out.println("-------------------------------");
		System.out.println(passwordAdmin);
		// recherche du membre dans la base de donnees
		try {
			System.out.println("c'est le try");
			Administrator administrator = new Administrator();
			administrator = administratorRepository.findByLogin(loginAdmin);
			System.out.println(administrator);
			if (administrator != null) {
				String pass = cryptographe(passwordAdmin);
				System.out.println(pass);
				if (pass.equals(administrator.getPasswordSec())) {
					System.out.println("deuxieme if c'est moi");
					

					HttpSession session = req.getSession();
					session.setAttribute( "administrator", administrator );
					
					Administrator administratorName = (Administrator) session.getAttribute( "administrator" );
					
					System.out.println("je suis en session avec http et mon nom est : " + administratorName.getLogin());
					
					model.addAttribute("Administrators", "You have been login successfully." + administratorName.getLogin());
						//req.setAttribute("succes", "You have been login successfully. " +administratorName);
						
						return "homeAdministrator";
					
					//return "connectionAdministrator";



				} else {
					logger.error("Administrator with password {} not found.", passwordAdmin);
					model.addAttribute("errorPassword", "Password not found.");
					req.setAttribute("errorPassword", "Password not found.");
				}
			} else {
				logger.error("Administrator with password {} not found.", loginAdmin);
				model.addAttribute("errorLogin", "login not found, adminstrator"+ loginAdmin + "doesn't exist");
				req.setAttribute("errorLogin", "login not found, adminstrator"+ loginAdmin + "doesn't exist");

			}
		} catch (Exception ex) {
			logger.error("Administrator with pseudonym {} not found.", loginAdmin);
			model.addAttribute("errorLogin", "login not found, adminstrator"+ loginAdmin + "doesn't exist");
			req.setAttribute("errorLogin", "login not found, adminstrator"+ loginAdmin + "doesn't exist");
		}
		System.out.println("ma petite laisse tomber c'est pas a ton niveau ma fille" );

		//return "redirect:/administratorHome";
		return "connectionAdministrator";
	}
	
	@RequestMapping(value = "/retrieve", method = RequestMethod.GET)
	public void retrieve(String error, String logout, Authentication authenticationg, Principal principal,
			HttpServletRequest request) {
		System.out.println("revettttttttttttttttttttttttttttttttttttt");
		HttpSession session = request.getSession();
		Administrator administratorName =  (Administrator) session.getAttribute( "administrator" );
		
		System.out.println("je suis en session avec http et mon nom est : " + administratorName.getLogin());
		

	}
	
	
	//Version de connexion avec spring security
	
	/*@RequestMapping(value = { "/connectionAdministrator" }, method = RequestMethod.POST)
	public String login(Model model,@ModelAttribute("loginAdmin") Administrator admin, HttpServletRequest req) {
		System.out.println("connexion  d'un admin");

		String loginAdmin = req.getParameter("login");
		String passwordAdmin = req.getParameter("password");
		System.out.println("-------------------------------");
		System.out.println(loginAdmin);
		System.out.println("-------------------------------");

		System.out.println("-------------------------------");
		System.out.println(passwordAdmin);
		// recherche du membre dans la base de donnees
		try {
			System.out.println("c'est le try");
			Administrator administrator = new Administrator();
			administrator = administratorRepository.findByLogin(loginAdmin);
			System.out.println(administrator);
			if (administrator != null) {
				String pass = cryptographe(passwordAdmin);
				System.out.println(pass);
				if (pass.equals(administrator.getPasswordSec())) {
					System.out.println("deuxieme if c'est moi");
					UserDetails users = loadUserByUsername(loginAdmin);
					//System.out.println("Humm tu as reussi a me mettre en session tu es forte ma petite 11111111111" + users);
					Authentication authToken = new UsernamePasswordAuthenticationToken(users, null,
							users.getAuthorities());
					//SecurityContextHolder.getContext().setAuthentication(authToken);
					SecurityContextHolder.getContext().setAuthentication(authToken);
					//SecurityContextHolder.getContext().getAuthentication().getPrincipal();

					
					Authentication request = new UsernamePasswordAuthenticationToken(users,users.getAuthorities());
			        Authentication result = am.authenticate(request);
			        SecurityContextHolder.getContext().setAuthentication(result);
					Authentication auth = SecurityContextHolder.getContext().getAuthentication();

					if (!(auth instanceof AnonymousAuthenticationToken)) {
						System.out.println(users.getAuthorities()+" Humm tu as reussi a me mettre en session tu es forte ma petite " + SecurityContextHolder.getContext().getAuthentication().getName());

						model.addAttribute("Administrators", "You have been login successfully."
								+SecurityContextHolder.getContext().getAuthentication().getName());
						req.setAttribute("succes", "You have been login successfully."
								+SecurityContextHolder.getContext().getAuthentication().getName());
						return "homeAdministrator";
					}
					return "connectionAdministrator";



				} else {
					logger.error("Administrator with password {} not found.", passwordAdmin);
					model.addAttribute("errorPassword", "Password not found.");
					req.setAttribute("errorPassword", "Password not found.");
				}
			} else {
				logger.error("Administrator with password {} not found.", loginAdmin);
				model.addAttribute("errorLogin", "login not found, adminstrator"+ loginAdmin + "doesn't exist");
				req.setAttribute("errorLogin", "login not found, adminstrator"+ loginAdmin + "doesn't exist");

			}
		} catch (Exception ex) {
			logger.error("Administrator with pseudonym {} not found.", loginAdmin);
			model.addAttribute("errorLogin", "login not found, adminstrator"+ loginAdmin + "doesn't exist");
			req.setAttribute("errorLogin", "login not found, adminstrator"+ loginAdmin + "doesn't exist");
		}
		System.out.println("ma petite laisse tomber c'est pas a ton niveau ma fille" );

		//return "redirect:/administratorHome";
		return "connectionAdministrator";
	}
	*/
	
	
	/*// retrieve user in session
	@RequestMapping(value = "/retrieve", method = RequestMethod.GET)
	public void retrieve(String error, String logout, Authentication authenticationg, Principal principal,
			HttpServletRequest request) {
		System.out.println("revettttttttttttttttttttttttttttttttttttt");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//String userDetails = SecurityContextHolder.getContext().getAuthentication().getName();
		if(SecurityContextHolder.getContext().getAuthentication()==null){
			System.out.println("suis le if");
			System.out.println(auth);
		}else{
			System.out.println("je suis en session Saphir et mon nom est  " + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		}
		
		 * if (userDetails instanceof UserDetails) { return ((UserDetails)
		 * userDetails).getUsername(); }
		 

		//	return userDetails;

	}
	
	*/

	// ajouter les cycles


	@RequestMapping(value = "/addCycle", method = RequestMethod.GET)
	public String cycleGet(Model model,HttpServletRequest req) {
		System.out.println("add cycle  get");

		return "addCycle";
	}

	@RequestMapping(value = "/addCycle", method = RequestMethod.POST)
	public String cyclePost(Model model, HttpServletRequest req)  {
		System.out.println("add Cycle  post");

		String cycleName= req.getParameter("cycleName");
		Cycle cycle = new Cycle();
		cycle.setCycleName(cycleName);
		//cycleRepository.deleteAll();
		//cycleService.saveCycle(cycle);
		try {
			cycleRepository.save(cycle);
			model.addAttribute("cycles", "succesfully to create cylcle:: " + cycleName);
			req.setAttribute("cycles", "succesfully to create cylcle:: " + cycleName);
			System.out.println("done");
		} catch (Exception e) {
			model.addAttribute("error", "echec d'enregistrement ");
			// TODO: handle exception
		}
		
		return "addCycle";
	}

	//lister tous les cycles
	@RequestMapping(value = { "/cycleList" }, method = RequestMethod.GET)
	public String cycleList(Model model,HttpServletRequest req) {
		System.out.println("cycleList");

		List<Cycle> listOfCycle = cycleRepository.findAll();

		if (listOfCycle.isEmpty()) {
			model.addAttribute("error", "liste vide");
			req.setAttribute("error", error);
		}
		model.addAttribute("cycles", listOfCycle);
		req.setAttribute("cycles", listOfCycle);
		return "cycleList";
	}

	//list les option d'un cycle
	@RequestMapping(value = { "/cycleListOption" }, method = RequestMethod.GET)
	public String cycleListLevel(Model model, HttpServletRequest req) {
		System.out.println("cycleListOption");
		String cycleName= req.getParameter("cycleName");

		Cycle cycle =cycleRepository.findByCycleName(cycleName);

		Set<Option> listOfOption=cycle.getOptions();;
		if (listOfOption.isEmpty()) {
			model.addAttribute("error", "liste vide");
		}
		model.addAttribute("cycleOption", listOfOption);
		req.setAttribute("cycleOption", listOfOption);
		return "cycleListOption";
	}

	//ajouter les options 

	@RequestMapping(value = "/addOption", method = RequestMethod.GET)
	public String optionGet(Model model,HttpServletRequest req) {
		System.out.println("addOption get");

		List<Cycle> cycles = cycleRepository.findAll();
		for (Cycle cycle : cycles) {
			System.out.println(cycle.getCycleName());
		}
		model.addAttribute("cycles", cycles);
		return "addOption";
	}

	@RequestMapping(value = "/addOption", method = RequestMethod.POST)
	public String optionPost(Model model, HttpServletRequest req)  {

		System.out.println("add Option post");
		String optionName= req.getParameter("optionName");
		String cycleName= req.getParameter("cycleName");

		System.out.println("~~~~~~~~~~~~~~~~");
		System.out.println(cycleName);
		System.out.println("~~~~~~~~~~~~~~~~");
		System.out.println(optionName);

		Cycle cycle = cycleRepository.findByCycleName(cycleName);

		Option option = new Option();
		option.setOptionName(optionName);
		option.setCycle(cycle);
		try {
			optionRepository.save(option);
			System.out.println("done");
			model.addAttribute("options", "succesfully to create option :: "+ optionName);
			req.setAttribute("options", "succesfully to create option :: "+ optionName);

			
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", "echec d'eregistrement ");
		}
		
		return "addOption";
	}

	// liste de tous les option
	@RequestMapping(value = { "/optionList" }, method = RequestMethod.GET)
	public String optionList(Model model,HttpServletRequest req) {
		System.out.println("optionList");

		List<Option> listOfOption = optionRepository.findAll();
		List<String> finalList = new ArrayList<String>();
		if (listOfOption.isEmpty()) {
			model.addAttribute("error", "liste vide");
		}
		model.addAttribute("options", listOfOption);
		req.setAttribute("options",finalList);
		return "optionList";
	}


	// ajouter les niveaux
	@RequestMapping(value = "/addLevel", method = RequestMethod.GET)
	public String levelGet(Model model,HttpServletRequest req) {
		System.out.println("add level  get");
		List<Option> options = optionRepository.findAll();
		for (Option option : options) {
			System.out.println(option.getOptionName());
		}
		model.addAttribute("options", options);

		return "addLevel";
	}


	@RequestMapping(value = "/addLevel", method = RequestMethod.POST)
	public String levelPost(Model model, HttpServletRequest req)  {
		System.out.println("add level  post");

		String levelName= req.getParameter("levelName");
		String optionName= req.getParameter("optionName");

		System.out.println("~~~~~~~~~~~~~~~~");
		System.out.println(levelName);
		System.out.println("~~~~~~~~~~~~~~~~");
		System.out.println(optionName);

		Level level = new Level();
		Option option = optionRepository.findByOptionName(optionName);
		System.out.println(option);
		level.setLevelName(optionName+levelName);
		level.setOption(option);
		//levelRepository.deleteAll();
		try {
			levelRepository.save(level);
			System.out.println("done");
			model.addAttribute("levels", "succesfully to create level:: " +levelName);
			req.setAttribute("success", "succesfully to create level:: " +levelName);
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", "echec d'enregistremnt");
			
		}
		
		return "addLevel";
	}

	// liste de tous les niveaux
	@RequestMapping(value = { "/levelList" }, method = RequestMethod.GET)
	public String levelList(Model model,HttpServletRequest req) {
		System.out.println("levelList");

		List<Level> listOfLevel = levelRepository.findAll();
		//List<String> finalList = new ArrayList<String>();

		if (listOfLevel.isEmpty()) {
			model.addAttribute("error", "liste vide");
		}
		model.addAttribute("levels", listOfLevel);
		req.setAttribute("levels", listOfLevel);
		return "levelList";
	}

	//ajouter les UVs

	@RequestMapping(value = "/addCourse", method = RequestMethod.GET)
	public String coursesGet(Model model,HttpServletRequest req) {
		System.out.println("addCourse get");

		List<Level> listOfLevel = levelRepository.findAll();
		List<String> finalList = new ArrayList<String>();

		if (listOfLevel.isEmpty()) {
			model.addAttribute("error", error);
		}
		model.addAttribute("levels", listOfLevel);
		req.setAttribute("level", finalList);

		return "addCourse";
	}

	@RequestMapping(value = "/addCourse", method = RequestMethod.POST)
	public String coursesPost(Model model, HttpServletRequest req)  {


		System.out.println("add Course post");
		String courseCode= req.getParameter("courseCode");
		String courseName= req.getParameter("courseName");
		String semesters= req.getParameter("semester");
		String levelName= req.getParameter("levelName");
		String semester= "Semestre"+semesters;
		Course course = new Course();
		Level level = levelRepository.findByLevelName(levelName);
		course.setLevel(level);
		course.setCourseTitle(courseName);
		course.setCourseCode(courseCode);
		course.setSemester(semester);
		try {
			courseRepository.save(course);
			System.out.println("~~~~done~~~~");
			model.addAttribute("courses", "succesfully to create course :: " + courseName);
			req.setAttribute("courses", "succesfully to create course :: " + courseName);
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", "echec d'enregistrement");
		}
		

		return "addCourse";
	}

	@RequestMapping(value = { "/courseList" }, method = RequestMethod.GET)
	public String courseList(Model model,HttpServletRequest req) {
		System.out.println("coursesList");

		List<Course> listOfCourse = courseRepository.findAll();

		if (listOfCourse.isEmpty()) {

			model.addAttribute("error", error);
		}

		model.addAttribute("courses", listOfCourse);
		req.setAttribute("course", listOfCourse);

		return "courseList";
	}
	//list des uv sachant le niveau
	@RequestMapping(value = { "/courseListLevel" }, method = RequestMethod.GET)
	public String courseListLevel(Model model, HttpServletRequest req) {
		System.out.println("courseListLevel");
		String levelName= req.getParameter("levelName");
		Level level =levelRepository.findByLevelName(levelName);
		Set<Course> listOfCourse= level.getCourses();
		if (listOfCourse.isEmpty()) {
			model.addAttribute("error", "liste vide");
		}
		model.addAttribute("cycleOptions", listOfCourse);
		req.setAttribute("cycleOptions", listOfCourse);

		return "coursesList";
	}

	//enregisrtre les grades
	@RequestMapping(value = { "/addGrade" }, method = RequestMethod.GET)
	public String gradeGet(Model model) {
		System.out.println("addGrade GET");

		return "addGrade";
	}

	@RequestMapping(value = { "/addGrade" }, method = RequestMethod.POST)
	public String gradePost(Model model, HttpServletRequest req) {
		System.out.println("addGrade POST");

		String gradeName=req.getParameter("gradeName");

		Grade grade =new Grade();

		grade.setGradeName(gradeName);
		
		try {
			gradeRepository.save(grade);
			System.out.println("~~~~done~~~");
			model.addAttribute("grades", "succesfully to create grade:: " +gradeName);
			req.setAttribute("grades", "succesfully to create grade:: " +gradeName);
			
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", "echec d'enregistrement");
		}

		

		return "addGrade";
	}
	
	@RequestMapping(value = { "/gradeList" }, method = RequestMethod.GET)
	public String listGradePost(Model model, HttpServletRequest req) {
		System.out.println("addGrade POST");

		System.out.println("coursesList");

		List<Grade> listOfGrade = gradeRepository.findAll();

		if (listOfGrade.isEmpty()) {

			model.addAttribute("error", "liste vide");
		}

		model.addAttribute("grades", listOfGrade);
		req.setAttribute("grades", listOfGrade);


		return "gradeList";
	}

	//enregisrtre un ensegnant
	@RequestMapping(value = { "/createTeacher" }, method = RequestMethod.GET)
	public String createTeacherGet(Model model,HttpServletRequest req) {
		System.out.println("createTeacher GET");

		List<Grade> listOfGrade = gradeRepository.findAll();

		if (listOfGrade.isEmpty()) {

			model.addAttribute("error", "liste vide");
		}

		model.addAttribute("grades", listOfGrade);
		req.setAttribute("course", listOfGrade);

		return "createTeacher";
	}
	@RequestMapping(value = { "/createTeacher" }, method = RequestMethod.POST)
	@Transactional
	public String createTeacherPost(Model model, HttpServletRequest req) throws AddressException, MessagingException {
		System.out.println("createTeacher post");

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



		String lastName= req.getParameter("lastName");
		String firstName= req.getParameter("firstName");
		String emailAdress= req.getParameter("emailAdress");
		//String phone= req.getParameter("teacherPhone");
		String gradeName= req.getParameter("gradeName");
		Grade grade = gradeRepository.findByGradeName(gradeName);
		String login = "login"+firstName;
		String password = emailAdress+"pass";
		String passwordSec = emailAdress+"pass";
		String subject1 = "Registration Information";
		Teacher teacher = new Teacher();
		teacher.setLastName(lastName);
		teacher.setFirstName(firstName);
		teacher.setEmailAdress(emailAdress);
		teacher.setGrade(grade);
		teacher.setLogin(login);
		teacher.setPassword(bCryptPasswordEncoder.encode(password));
		teacher.setPasswordSec(cryptographe(passwordSec));
		String content1 = "Compte cr�� avec succ�s, vos informations se pr�sentent comme suit:  \n"
				+teacher.getLastName() + " \n"
				+ teacher.getLogin() +"\n"
				+ decryptographe(teacher.getPasswordSec())+"\n"
				+ "...\n"
				+ "Pour vous connecter a votre espace personnel cliquez ici :\n"
				+ "http://localhost:8080/SpringMvcJdbcTemplate/connectionTeachers";
		// String form="saphirmfogo@gmail.com";V
		MimeMessage msg = new MimeMessage(session);
		/// msg.setFrom(new InternetAddress(form));
		msg.setRecipients(MimeMessage.RecipientType.TO, emailAdress);
		msg.setSubject(subject1);
		msg.setText(content1);
		msg.setSentDate(new Date());
try {
	teachersRepository.save(teacher);
	Transport transport = session.getTransport("smtp");
	transport.connect("smtp.gmail.com", "saphirmfogo@gmail.com", "best1234");
	transport.sendMessage(msg, msg.getAllRecipients());
	transport.close();
	System.out.println("Sent message successfully....");
	model.addAttribute("teachers", "succesfully to create teacher wiht parameter :: " + login + " and " + password);
	req.setAttribute("teacherSucces", "succesfully to create teacher wiht parameter :: " + login + " and " + password);

} catch (Exception e) {
	// TODO: handle exception
	model.addAttribute("error", "echec d'enregistrment");
	
}
		
		return "createTeacher";
	}
	@RequestMapping(value = { "/teacherList" }, method = RequestMethod.GET)
	public String teacherList(Model model, HttpServletRequest req) {
		System.out.println("teacherList");

		List<Teacher> listOfTeacher =teachersRepository.findAll();

		if (listOfTeacher.isEmpty()) {
			model.addAttribute("error", "liste vide");
		}
		model.addAttribute("teachers", listOfTeacher);
		req.setAttribute("teacher", listOfTeacher);

		return "teacherList";
	}



	/*//enregisrtre des jurys pour l'ouverture d'une annee academique 
	@RequestMapping(value = { "/openAcademicYear" }, method = RequestMethod.GET)
	public String openAcademicYearGet(Model model,HttpServletRequest req) {
		System.out.println("openAcademicYear GET");


		List<Level> listOfLevel = levelRepository.findAll();
		List<Teacher> listOfTeacher = teachersRepository.findAll();

		if (listOfLevel.isEmpty() && listOfTeacher.isEmpty()) {
			model.addAttribute("error", error);
		}
		model.addAttribute("levels", listOfLevel);
		model.addAttribute("teachers", listOfTeacher);

		return "openAcademicYear";
	}*/

	/*@RequestMapping(value = { "/openAcademicYear" }, method = RequestMethod.POST)
	public String openAcademicYearPost(Model model, HttpServletRequest req) {
		System.out.println("openAcademicYear Post");

		String academicYear= req.getParameter("academicYear");
		String juryPresidentName= req.getParameter("juryPresidentName");
		String juryLevelName= req.getParameter("juryLevelName");

		Teacher juryPresident = teachersRepository.findByLastName(juryPresidentName);
		Level juryLevel = levelRepository.findByLevelName(juryLevelName);
		Jury jury = new Jury();
		jury.setAcademicYear(academicYear);
		jury.setJuryLevel(juryLevel);
		jury.setJuryPresident(juryPresident);

		juryRepository.save(jury);
		req.setAttribute("jury", "jury cree avec succes");
		model.addAttribute("jury", "jury cree avec succes");


		return "openAcademicYear";
	}
*/


	//autre version de l'ouverture de l'annee academique

		@RequestMapping(value = { "/openAcademicYear" }, method = RequestMethod.GET)
	public String openAcademicYearGet(Model model,HttpServletRequest req) {
		System.out.println("openAcademicYear GET");


		return "openAcademicYear";

		}

	@RequestMapping(value = { "/openAcademicYear" }, method = RequestMethod.POST)
	public String openAcademicYearPost(Model model,HttpServletRequest req) {
		System.out.println("openAcademicYear Post");
		String academicYear= req.getParameter("academicYear");

		AcademicYear academicYears = new AcademicYear();

		academicYears.setAcademicYear(academicYear);
		academicYearRepository.save(academicYears);

		return "openAcademicYear";
	}

		@RequestMapping(value = { "/createJury" }, method = RequestMethod.GET)
	public String createJuryYearGet(Model model,HttpServletRequest req) {
		System.out.println("createJury GET");

			List<Level> listOfLevel = levelRepository.findAll();
		List<Teacher> listOfTeacher = teachersRepository.findAll();

		if (listOfLevel.isEmpty() && listOfTeacher.isEmpty()) {
			model.addAttribute("error", error);
		}
		model.addAttribute("levels", listOfLevel);
		model.addAttribute("teachers", listOfTeacher);

		return "createJury";
	}


		@RequestMapping(value = { "/createJury" }, method = RequestMethod.POST)
	public String createJuryPost(Model model, HttpServletRequest req) {
		System.out.println("createJury Post");

		String academicYear= req.getParameter("academicYear");
		String juryPresidentName= req.getParameter("juryPresidentName");
		String juryLevelName= req.getParameter("juryLevelName");

		Teacher juryPresident = teachersRepository.findByLastName(juryPresidentName);
		AcademicYear academicYears = academicYearRepository.findByAcademicYear(academicYear);
		Level juryLevel = levelRepository.findByLevelName(juryLevelName);
		 Jury jury = new Jury();
		 jury.setAcademicYear(academicYears);
		 jury.setJuryLevel(juryLevel);
		 jury.setJuryPresident(juryPresident);
		 try {
			 juryRepository.save(jury);
			 model.addAttribute("jurys", "jury cree avec succes");
			 req.setAttribute("jury", "jury cree avec succes");
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", "echec d'enregistrement");
		}
		


		return "createJury";
	}

	//editer un communique
	@RequestMapping(value = { "/editNews" }, method = RequestMethod.GET)
	public String createCommuniqueGet(Model model,HttpServletRequest req) {
		System.out.println("editNews GET");

		return "editNews";
	}

	@RequestMapping(value = { "/editNews" }, method = RequestMethod.POST)
	@Transactional
	public String createCommuniquePost(Model model, HttpServletRequest req) throws ParseException {
		System.out.println("editNews Post");

		String communiqueTitle= req.getParameter("newsTitle");
		String communiqueContent= req.getParameter("newsContent");
		String publicationDate= req.getParameter("publicationDate");
		/*String adminSession= SecurityContextHolder.getContext().getAuthentication().getName();
		Administrator admin = administratorRepository.findByLogin(adminSession);*/
		HttpSession session = req.getSession();
		Administrator administratorName =  (Administrator) session.getAttribute( "administrator" );

		System.out.println(communiqueTitle);
		System.out.println(communiqueContent);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date publicateDate = sdf.parse(publicationDate);


		Communique communique = new Communique();

		communique.setCommuniqueTitle(communiqueTitle);
		communique.setCommuniqueContent(communiqueContent);
		communique.setPublicationDate(publicateDate);
		communique.setAdmin(administratorName);

try {
	communiqueRepository.save(communique);
	req.setAttribute("communique", "communiquee cree avec succes");
	model.addAttribute("communiques", "communiquee cree avec succes");

} catch (Exception e) {
	// TODO: handle exception
	model.addAttribute("error", "echec d'enregistrement");
}
		
		return "editNews";
	}

	@RequestMapping(value = { "/listNews" }, method = RequestMethod.GET)
	public String listCommuniqueGet(Model model,HttpServletRequest req) {
		System.out.println("listNews GET");

		List<Communique> listOfCommunique = communiqueRepository.findAll();

		if (listOfCommunique.isEmpty() ) {
			model.addAttribute("error", "liste vide");
		}
		model.addAttribute("communiques", listOfCommunique);

		return "listNews";
	}



	//creation d'un evennement
	@RequestMapping(value = { "/createEvent" }, method = RequestMethod.GET)
	public String createEventGet(Model model,HttpServletRequest req) {
		System.out.println("createEvent GET");

		return "createEvent";
	}

	@RequestMapping(value = { "/createEvent" }, method = RequestMethod.POST)
	@Transactional
	public String createEventPost(Model model, HttpServletRequest req) throws ParseException {
		System.out.println("createEvent Post");

		String eventTitle= req.getParameter("eventTitle");
		String eventDescription= req.getParameter("eventDescription");
		String eventBeginDateName= req.getParameter("eventBeginDate");
		String eventEndDateName= req.getParameter("eventEndDate");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date eventBeginDate = sdf.parse(eventBeginDateName);
		Date eventEndDate = sdf.parse(eventEndDateName);

		Event event = new Event();

		event.setEventBeginDate(eventBeginDate);
		event.setEventEndDate(eventEndDate);
		event.setEventDescription(eventDescription);
		event.setEventTitle(eventTitle);
		try {
			eventRepository.save(event);
			model.addAttribute("events", "Evenement cree avec succes");
			
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", "echec d'enregistrement");
		}
		

		return "createEvent";
	}

	@RequestMapping(value = { "/listEvent" }, method = RequestMethod.GET)
	public String listEventGet(Model model,HttpServletRequest req) {
		System.out.println("createCommunique GET");

		List<Event> listOfEvent = eventRepository.findAll();

		if (listOfEvent.isEmpty() ) {
			model.addAttribute("error", "error : liste vide");
		}
		model.addAttribute("events", listOfEvent);

		return "listEvent";
	}
	
	// ajouter les dommaine de competence
	
		@RequestMapping(value = { "/addResearchDomain" }, method = RequestMethod.GET)
		public String addReseachDomainGet(Model model,HttpServletRequest req) {
			System.out.println("addReseachDomain GET");
			
			List<Option> listOfOption = optionRepository.findAll();

			if (listOfOption.isEmpty() ) {
				model.addAttribute("error", "error : liste vide");
			}
			model.addAttribute("options", listOfOption);

			return "addResearchDomain";
		}

		@RequestMapping(value = { "/addResearchDomain" }, method = RequestMethod.POST)
		@Transactional
		public String addReseachDomainPost(Model model, HttpServletRequest req) throws ParseException {
			System.out.println("addReseachDomain Post");

			String optionName= req.getParameter("optionName");
			String domainLabel= req.getParameter("domainLabel");
			String domainDescription= req.getParameter("domainDescription");
			
			Option option = optionRepository.findOne(optionName);
			

			ResearchDomain researchDomain = new ResearchDomain();

			researchDomain.setDomainDescription(domainDescription);
			researchDomain.setDomainLabel(domainLabel);
			
			try {
				researchDomainRepository.save(researchDomain);
				model.addAttribute("researchDomains", "Domaine de recherche  cree avec succes");
				
			} catch (Exception e) {
				// TODO: handle exception
				model.addAttribute("error", "echec d'enregistrement");
			}
			

			return "addResearchDomain";
		}
		
		@RequestMapping(value = { "/listResearchDomain" }, method = RequestMethod.GET)
		public String listResearchDomainGet(Model model,HttpServletRequest req) {
			System.out.println("createCommunique GET");

			List<ResearchDomain> listOfResearchDomain = researchDomainRepository.findAll();

			if (listOfResearchDomain.isEmpty() ) {
				model.addAttribute("error", "error : liste vide");
			}
			model.addAttribute("researchDomains", listOfResearchDomain);

			return "listResearchDomain";
		}


	// se deconnecter
	@RequestMapping(value = "/logoutAdministrator", method = RequestMethod.GET)
	public String logoutPost(HttpServletRequest request, HttpServletResponse response, Model model) {

		  HttpSession session = request.getSession();
		  session.setAttribute( "administrator", null );
		  model.addAttribute("sessionOut", "la session a ete supprimme");

		return "connectionAdministrator";
	}
}
