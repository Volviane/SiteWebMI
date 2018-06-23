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

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mi.model.Administrator;
import com.mi.model.Communique;
import com.mi.model.Course;
import com.mi.model.Cycle;
import com.mi.model.Event;
import com.mi.model.Grade;
import com.mi.model.Jury;
import com.mi.model.Level;
import com.mi.model.Option;
import com.mi.model.Role;
import com.mi.model.Teachers;
import com.mi.repositories.AdministratorRepository;
import com.mi.repositories.CycleRepository;
import com.mi.repositories.RoleRepository;
import com.mi.services.AdministratorService;
import com.mi.services.CourseService;
import com.mi.services.CycleService;
import com.mi.services.EventService;
import com.mi.services.GradeService;
import com.mi.services.JuryService;
import com.mi.services.LevelService;
import com.mi.services.OptionService;
import com.mi.services.RoleService;
import com.mi.services.TeachersService;
import com.mi.services.UserDetailsServices;

import org.springframework.ui.Model;

@Controller
public class AdministratorController/* implements UserDetailsService */{
	public static final Logger logger = LoggerFactory.getLogger(AdministratorController.class);

	@Autowired
	CycleRepository cycleReppository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	AdministratorRepository administratorRepository;
	
	@Autowired
	RoleService roleService;

	@Autowired
	AdministratorService administratorService;

	@Autowired
	CycleService cycleService;

	@Autowired
	OptionService optionService;

	@Autowired
	LevelService levelService;

	@Autowired
	CourseService courseService;

	@Autowired 
	GradeService gradeService;
	
	@Autowired 
	TeachersService teachersService;
	
	@Autowired 
	JuryService juryService;
	
	@Autowired 
	EventService eventService;



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
			roleRepository.save(roles);
			System.out.println("done");
		}
		model.addAttribute("roles",roles);
		req.setAttribute("role", roles);
		return "addRole";
	}
	//Liste role method
	@RequestMapping(value = { "/roleList" }, method = RequestMethod.GET)
	public String roleList(Model model,HttpServletRequest req) {
		System.out.println("listrole");

		List<Role> listOfRole = roleService.findAllRoles();
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

		String login= req.getParameter("loginAdmin");
		String password= req.getParameter("passwordAdmin");
		Role role = roleRepository.findByRoleName("ROLE_ADMIN");
		Set<Role> rolelist=new HashSet<Role>();
		rolelist.add(role);
		Administrator administrator= new Administrator();
		administrator.setLogin(login);
		administrator.setPassword(bCryptPasswordEncoder.encode(password));
		administrator.setPasswordSec(cryptographe(password));
		administrator.setRoles(rolelist);
		//Modification de setRole(idRole) en setRole(role)
		administrator.getRoles().add(role);
		//administratorRepository.deleteAll();
		administratorRepository.save(administrator);

		model.addAttribute("succes", "succesfully to create administrator wiht parameter :: " + login + " and " + password);
		req.setAttribute("succes", "succesfully to create administrator wiht parameter :: " + login + " and " + password);

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
					UserDetails users = loadUserByUsername(loginAdmin);
					//System.out.println("Humm tu as reussi a me mettre en session tu es forte ma petite 11111111111" + users);
					UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(users, null,
							users.getAuthorities());
					SecurityContextHolder.getContext().setAuthentication(authToken);
					System.out.println("Humm tu as reussi a me mettre en session tu es forte ma petite " + SecurityContextHolder.getContext().getAuthentication().getName());

					model.addAttribute("succes", "You have been login successfully."
							+SecurityContextHolder.getContext().getAuthentication().getName());
					req.setAttribute("succes", "You have been login successfully."
							+SecurityContextHolder.getContext().getAuthentication().getName());
				} else {
					logger.error("Administrator with password {} not found.", passwordAdmin);
					model.addAttribute("error", "Password not found.");
					req.setAttribute("error", "Password not found.");
				}
			} else {
				logger.error("Administrator with password {} not found.", loginAdmin);
				model.addAttribute("error", "login not found, adminstrator"+ loginAdmin + "doesn't exist");
				req.setAttribute("error", "login not found, adminstrator"+ loginAdmin + "doesn't exist");

			}
		} catch (Exception ex) {
			logger.error("Administrator with pseudonym {} not found.", loginAdmin);
			model.addAttribute("error", "login not found, adminstrator"+ loginAdmin + "doesn't exist");
			req.setAttribute("error", "login not found, adminstrator"+ loginAdmin + "doesn't exist");
		}

		//return "redirect:/administratorHome";
		return "homeAdministrator";
	}
// retrieve user in session
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/retrieve", method = RequestMethod.GET)
	public Object retrieve(String error, String logout, Authentication authenticationg, Principal principal,
			HttpServletRequest request) {
		String userDetails = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("je suis en session Saphir " + userDetails);
		/*
		 * if (userDetails instanceof UserDetails) { return ((UserDetails)
		 * userDetails).getUsername(); }
		 */

		return userDetails;

	}

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
		cycleReppository.save(cycle);
		req.setAttribute("success", "succesfully to create cylcle:: " + cycleName);
		System.out.println("done");
		return "addCycle";
	}

	//lister tous les cycles
	@RequestMapping(value = { "/cycleList" }, method = RequestMethod.GET)
	public String cycleList(Model model,HttpServletRequest req) {
		System.out.println("cycleList");

		List<Cycle> listOfCycle = cycleService.findAllCycles();

		if (listOfCycle.isEmpty()) {
			model.addAttribute("error", error);
			req.setAttribute("error", error);
		}
		model.addAttribute("cycle", listOfCycle);
		req.setAttribute("cycle", listOfCycle);
		return "cycleList";
	}

	//list les option d'un cycle
	@RequestMapping(value = { "/cycleListOption" }, method = RequestMethod.GET)
	public String cycleListLevel(Model model, HttpServletRequest req) {
		System.out.println("cycleListOption");
		String cycleName= req.getParameter("cycleName");
		
		Cycle cycle =cycleService.findByCycleName(cycleName);

		List<Option> listOfOption=optionService.findAllOptionsByCycle(cycle.getIdCycle());
					if (listOfOption.isEmpty()) {
						model.addAttribute("error", error);
					}
					model.addAttribute("cycleOption", listOfOption);
					 req.setAttribute("cycleOption", listOfOption);
		return "cycleListOption";
	}

	//ajouter les options 

	@RequestMapping(value = "/addOption", method = RequestMethod.GET)
	public String optionGet(Model model,HttpServletRequest req) {
		System.out.println("addOption get");
		
		List<Cycle> cycles = cycleReppository.findAll();
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

		Cycle cycle = cycleService.findByCycleName(cycleName);

		Option option = new Option();
		option.setOptionName(optionName);
		option.setCycle(cycle);
		optionService.saveOption(option);
		System.out.println("done");
		req.setAttribute("option", "succesfully to create option :: "+ optionName);

		return "addOption";
	}

	// liste de tous les option
	@RequestMapping(value = { "/optionList" }, method = RequestMethod.GET)
	public String optionList(Model model,HttpServletRequest req) {
		System.out.println("optionList");

		List<Option> listOfOption = optionService.findAllOptions();
		List<String> finalList = new ArrayList<String>();
		if (listOfOption.isEmpty()) {
			model.addAttribute("error", error);
		}
		model.addAttribute("options", finalList);
		req.setAttribute("options",finalList);
		return "optionList";
	}


	// ajouter les niveaux
	@RequestMapping(value = "/addLevel", method = RequestMethod.GET)
	public String levelGet(Model model,HttpServletRequest req) {
		System.out.println("add level  get");

		return "addLevel";
	}


	@RequestMapping(value = "/addLevel", method = RequestMethod.POST)
	public String levelPost(Model model, HttpServletRequest req)  {
		System.out.println("add level  post");

		String levelName= req.getParameter("levelName");
		String optionName= req.getParameter("optionName");
		Level level = new Level();
		Option option = optionService.findByOptionName(optionName);
		level.setLevelName(optionName+levelName);
		level.setOption(option);
		//levelRepository.deleteAll();
		levelService.saveLevel(level);
		System.out.println("done");
		req.setAttribute("success", "succesfully to create level:: " +levelName);
		return "addLevel";
	}

	// liste de tous les niveaux
	@RequestMapping(value = { "/levelList" }, method = RequestMethod.GET)
	public String levelList(Model model,HttpServletRequest req) {
		System.out.println("levelList");

		List<Level> listOfLevel = levelService.findAllLevels();
		List<String> finalList = new ArrayList<String>();

		if (listOfLevel.isEmpty()) {
			model.addAttribute("error", error);
		}
		model.addAttribute("level", finalList);
		req.setAttribute("level", finalList);
		return "levelList";
	}

	//ajouter les UVs

	@RequestMapping(value = "/addCourse", method = RequestMethod.GET)
	public String coursesGet(Model model,HttpServletRequest req) {
		System.out.println("addCourse get");

		return "addCourse";
	}

	@RequestMapping(value = "/addCourse", method = RequestMethod.POST)
	public String coursesPost(Model model, HttpServletRequest req)  {


		System.out.println("add Course post");
		String courseCode= req.getParameter("courseCode");
		String courseName= req.getParameter("courseName");
		String semester= req.getParameter("semester");
		String levelName= req.getParameter("levelName");
		Course course = new Course();
		Level level = levelService.findByLevelName(levelName);
		course.setLevel(level);
		course.setCourseTitle(courseName);
		course.setCourseCode(courseCode);
		course.setSemester(semester);
		courseService.saveCourse(course);
		System.out.println("~~~~done~~~~");
		req.setAttribute("success", "succesfully to create course :: " + courseName);

		return "addCourse";
	}

	@RequestMapping(value = { "/courseList" }, method = RequestMethod.GET)
	public String courseList(Model model,HttpServletRequest req) {
		System.out.println("coursesList");

		List<Course> listOfCourse = courseService.findAllCourses();

		if (listOfCourse.isEmpty()) {

			model.addAttribute("error", error);
		}

		model.addAttribute("course", listOfCourse);
		req.setAttribute("course", listOfCourse);

		return "coursesList";
	}
	//list des uv sachant le niveau
	@RequestMapping(value = { "/courseListLevel" }, method = RequestMethod.GET)
	public String courseListLevel(Model model, HttpServletRequest req) {
		System.out.println("courseListLevel");
		String levelName= req.getParameter("levelName");
		Level level =levelService.findByLevelName(levelName);
		List<Course> listOfCourse= courseService.findAllCourseByLevel(level.getIdLevel());
					if (listOfCourse.isEmpty()) {
						model.addAttribute("error", error);
					}
					model.addAttribute("cycleOption", listOfCourse);
					 req.setAttribute("cycleOption", listOfCourse);
		 
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

		gradeService.saveGrade(grade);
		System.out.println("~~~~done~~~");
		req.setAttribute("success", "succesfully to create grade:: " +gradeName);

		return "addGrade";
	}

	//enregisrtre un ensegnant
	@RequestMapping(value = { "/createTeacher" }, method = RequestMethod.GET)
	public String createTeacherGet(Model model,HttpServletRequest req) {
		System.out.println("createTeacher GET");

		return "createTeacher";
	}
	@RequestMapping(value = { "/createTeacher" }, method = RequestMethod.POST)
	@Transactional
	public String createTeacherPost(Model model, HttpServletRequest req) throws AddressException, MessagingException {
		System.out.println("createTeacher post");
		
		// Sender's email ID needs to be mentioned
		String from = "doctorialesnoreply@yahoo.com";
		String pass ="docto1234";
		String host = "smtp.mail.yahoo.com";

		// Get system properties
		Properties properties = System.getProperties();
		// Setup mail server
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.user", from);
		properties.put("mail.smtp.password", pass);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);
		
		String lastName= req.getParameter("lastName");
		String firstName= req.getParameter("firstName");
		String emailAdress= req.getParameter("emailAdress");
		String gradeName= req.getParameter("gradeName");
		Grade grade = gradeService.findByGradeName(gradeName);
		String login = "login"+firstName;
		String password = emailAdress+"pass";
		String subject1 = "Registration Information";
		Teachers teacher = new Teachers();
		teacher.setLastName(lastName);
		teacher.setFirstName(firstName);
		teacher.setEmailAdress(emailAdress);
		teacher.setGrade(grade.getIdGrade());
		teacher.setLogin(login);
		teacher.setPassword(bCryptPasswordEncoder.encode(password));
		String content1 = "Compte créé avec succès, vos informations se présentent comme suit:  \n"
				+teacher;
		MimeMessage message = new MimeMessage(session);
		// Set From: header field of the header.
		message.setFrom(new InternetAddress(from));
		// Set To: header field of the header.
		message.addRecipient(Message.RecipientType.TO,
				new InternetAddress(emailAdress));
		// Set Subject: header field
		message.setSubject(subject1);
		message.setText(content1);
		message.setSentDate(new Date());
		
		teachersService.saveTeachers(teacher);
		Transport transport = session.getTransport("smtp");
		transport.connect(host, from, pass);
		System.out.println("connect");
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
		System.out.println("Sent message successfully....");
		model.addAttribute("teacherSucces", "succesfully to create teacher wiht parameter :: " + login + " and " + password);
		 req.setAttribute("teacherSucces", "succesfully to create teacher wiht parameter :: " + login + " and " + password);

		return "createTeacher";
	}
	@RequestMapping(value = { "/teacherList" }, method = RequestMethod.GET)
	public String teacherList(Model model, HttpServletRequest req) {
		System.out.println("teacherList");
		
		List<Teachers> listOfTeacher =teachersService.findAllTeachers();
		
		if (listOfTeacher.isEmpty()) {
			model.addAttribute("error", error);
		}
		model.addAttribute("teacher", listOfTeacher);
		 req.setAttribute("teacher", listOfTeacher);

		return "teacherList";
	}



	//enregisrtre des jurys pour l'ouverture d'une annee academique 
	@RequestMapping(value = { "/openAcademicYear" }, method = RequestMethod.GET)
	public String openAcademicYearGet(Model model,HttpServletRequest req) {
		System.out.println("openAcademicYear GET");

		return "openAcademiqueYear";
	}
	
	@RequestMapping(value = { "/openAcademicYear" }, method = RequestMethod.POST)
	public String openAcademicYearPost(Model model, HttpServletRequest req) {
		System.out.println("openAcademicYear Post");
		
		String academicYear= req.getParameter("academicYear");
		String juryPresidentName= req.getParameter("juryPresidentName");
		String juryLevelName= req.getParameter("juryLevelName");
		
		Teachers juryPresident = teachersService.findByTeachersName(juryPresidentName);
		Level juryLevel = levelService.findByLevelName(juryLevelName);
		 Jury jury = new Jury();
		 jury.setAcademicYear(academicYear);
		 jury.setJuryLevel(juryLevel);
		 //jury.setJuryPresident(juryPresident);
		 
		 juryService.saveJury(jury);
		 req.setAttribute("jury", "jury cree avec succes");
		

		return "openAcademicYear";
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mi:ss");
		Date eventBeginDate = sdf.parse(eventBeginDateName);
		Date eventEndDate = sdf.parse(eventEndDateName);

		 Event event = new Event();
		 
		 event.setEventBeginDate(eventBeginDate);
		 event.setEventEndDate(eventEndDate);
		 event.setEventDescription(eventDescription);
		 event.setEventTitle(eventTitle);
		 
		 eventService.saveEvent(event);
		 req.setAttribute("event", "Evenement cree avec succes");

		return "createEvent";
	}




	//@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		System.out.println(login+" donne pardon");
		UserDetails userDetail=null;
		//Member user = memberRepository.findByPseudonym(pseudonym);
		if(administratorRepository.findByLogin(login)!=null) {
			System.out.println(administratorRepository.findByLogin(login)+"toototot");
			System.out.println(administratorRepository.findByLogin(login).getRoles());
			Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
			System.out.println("huoooo");
			/*for (Role role : administratorRepository.findByLogin(login).getRoles()){
							grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
							System.out.println("huoooo2222222222222222222");
						}*/
			System.out.println("huoooo333333333333333333");

			userDetail=new org.springframework.security.core.userdetails.User(administratorRepository.findByLogin(login).getLogin(), 
					administratorRepository.findByLogin(login).getPassword(), grantedAuthorities);
			System.out.println("huoooo444444444444444444444");


			/*}else if(teachersRepository.findByLogin(login)!=null) {

						System.out.println(teachersRepository.findByLogin(login)+"toototot");
						Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

						for (Role role : teachersRepository.findByLogin(login).getRole()){
							grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
						}

						userDetail=new org.springframework.security.core.userdetails.User(teachersRepository.findByLogin(login).getLogin(), 
								teachersRepository.findByLogin(login).getPassword(), grantedAuthorities);

					}else if(studentRepository.findByLogin(login)!=null) {

						System.out.println(studentRepository.findByLogin(login)+"toototot");
						Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

						for (Role role : studentRepository.findByLogin(login).getRole()){
							grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
						}

						userDetail=new org.springframework.security.core.userdetails.User(studentRepository.findByLogin(login).getLogin(), 
								studentRepository.findByLogin(login).getPassword(), grantedAuthorities);

					}*/
		return userDetail;

	}
		return userDetail;

	
		}
}
