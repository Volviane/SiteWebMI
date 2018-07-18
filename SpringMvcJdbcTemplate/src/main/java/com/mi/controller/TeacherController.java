package com.mi.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
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

import com.mi.model.AcademicYear;
import com.mi.model.Document;
import com.mi.model.Grade;
import com.mi.model.Jury;
import com.mi.model.ResearchDomain;
import com.mi.model.Result;
import com.mi.model.Teacher;
import com.mi.repositories.AcademicYearRepository;
import com.mi.repositories.CommuniqueRepository;
import com.mi.repositories.CourseRepository;
import com.mi.repositories.DocumentRepository;
import com.mi.repositories.EventRepository;
import com.mi.repositories.GradeRepository;
import com.mi.repositories.JuryRepository;
import com.mi.repositories.LevelRepository;
import com.mi.repositories.OptionRepository;
import com.mi.repositories.ResearchDomainRepository;
import com.mi.repositories.ResultRepository;
import com.mi.repositories.RoleRepository;
import com.mi.repositories.TeachersRepository;

@Controller
@SessionAttributes("Teacher")
@MultipartConfig(fileSizeThreshold=1024*1024*2,maxFileSize=1024*1024*10,maxRequestSize=1024*1024*50)
public class TeacherController {

	public static final Logger logger = LoggerFactory.getLogger(TeacherController.class);
	private static final String SAVE_DIR="resources"+File.separator+"userResources"+File.separator+"img";
	//C:\Program Files\Apache Software Foundation\Tomcat 7.0\webapps
	@Autowired
	ServletContext context;


	
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
	ResultRepository resultRepository;


	@Autowired
	OptionRepository optionRepository;

	@Autowired
	ResearchDomainRepository researchDomainRepository;
	@Autowired
	AcademicYearRepository academicYearRepository;



	/*	@Autowired
	UserDetailsServices use;*/

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	//private String error = "error message";

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

	public String homeTeacher(Model model,HttpServletRequest req) {
		System.out.println("home enseignant get");
		
		//String login = req.getParameter("login");
//		String coption = req.getParameter("o");
//		String option ="mail";
//		if(option.equals(decryptographe(coption))){
			//Teacher teacher = teachersRepository.findByLogin(login);
//			HttpSession session = req.getSession();
//			session.setAttribute( "teacher", teacher );
//		}
		
		//model.addAttribute("error", "");

		return "teacher/homeTeacher";
	}


/*
	//connexion d'un enseignant
	@RequestMapping(value = { "/loginTeacher" }, method = RequestMethod.GET)
	public String loginForm(Model model,HttpServletRequest req) {
		System.out.println("connexion  d'un enseignant get");
		model.addAttribute("errorLogin", "");
		model.addAttribute("errorPassword", "");
		return "index";
	}*/

	@RequestMapping(value = { "/loginTeacher" }, method = RequestMethod.POST)
	public String login(Model model,@ModelAttribute("loginAdmin") Teacher admin, HttpServletRequest req, HttpServletResponse resp) {
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
			Teacher teacher = teachersRepository.findByLogin(login);
			System.out.println(teacher);
			if (teacher != null) {
				String pass = cryptographe(password);
				System.out.println(pass);
				if (pass.equals(teacher.getPasswordSec())) {
					System.out.println("deuxieme if c'est moi");
					
					HttpSession session = req.getSession();
					session.setAttribute( "teacher", teacher );
					
					long documentsNumber = documentRepository.countByAuthor(teacher);
					long articlesNumber = documentRepository.countByDocumentTypeAndAuthor("Article de Recherche",teacher);
					long coursNumber = documentRepository.countByDocumentTypeAndAuthor("Support de Cours",teacher);
					long ficheTdNumber = documentRepository.countByDocumentTypeAndAuthor("Fiche de TD",teacher);
					long epreuvesNumber = documentRepository.countByDocumentTypeAndAuthor("Epreuve",teacher);
					long correctionEpreuvesNumber = documentRepository.countByDocumentTypeAndAuthor("Correction Epreuve",teacher);
					
					session.setAttribute( "documentsNumber", documentsNumber );
					session.setAttribute( "articlesNumber", articlesNumber );
					session.setAttribute( "coursNumber", coursNumber );
					session.setAttribute( "ficheTdNumber", ficheTdNumber );
					session.setAttribute( "epreuvesNumber", epreuvesNumber );
					session.setAttribute( "correctionEpreuvesNumber", correctionEpreuvesNumber );
					
					
					Teacher teacherName = (Teacher) session.getAttribute( "teacher" );
					
					System.out.println("je suis en session avec http et mon nom est : " + teacherName.getLogin());
					
					
					model.addAttribute("teachers", "Vous etes connectez a votre espace personne. M. " + teacherName.getLogin());
					model.addAttribute("teachs", teacher);
					 resp.sendRedirect("homeTeacher");
					return "teacher/homeTeacher";

				} else {
					logger.error("Teacher with password {} not found.", password);
					
					model.addAttribute("errorPassword", "Mot de passe incorrect.");
					req.setAttribute("errorPassword", "Mot de passe incorrect.");
				}
			} else {
				logger.error("Teacher with password {} not found.", login);
				
				
				model.addAttribute("errorLogin", "L'enseignant "+ login + " n'existe pas");
				req.setAttribute("errorLogin", "L'enseignant "+ login + " n'existe pas");

			}
		} catch (Exception ex) {
			logger.error("Teacher with pseudonym {} not found.", login);
			
			model.addAttribute("errorLogin", "L'enseignant "+ login + "n'existe pas");
			req.setAttribute("errorLogin", "L'enseignant "+ login + "n'existe pas");
		}

		//return "redirect:/TeacherHome";
		return "index";
	}

	//modifier les parametres de connexion get method
	@RequestMapping(value = { "/updateParameterTeacher" }, method = RequestMethod.GET)
	public String updateParameterGet(Model model,HttpServletRequest req) {
		System.out.println("modifier les parametre de connexion get");
		model.addAttribute("error", "");
		return "teacher/updateParameterTeacher";
	}

	@RequestMapping(value = { "/updateParameterTeacher" }, method = RequestMethod.POST)
	@Transactional
	public String updateParameterPost(Model model, HttpServletRequest req) throws ParseException, MessagingException {
		System.out.println("updateParameters Post");
		
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
		Session sessions = Session.getInstance(properties, null);

		String login= req.getParameter("login");
		String password= req.getParameter("password");
		String newlogin= req.getParameter("newLogin");
		String newpassword= req.getParameter("newPassword");
		
		
		HttpSession session = req.getSession();
		Teacher teacher =  (Teacher) session.getAttribute( "teacher" );

		System.out.println(newlogin);
		System.out.println(newpassword);
		System.out.println(teacher.getLogin());

		
		if(teacher.getLogin().equals(login)){
			
			
			if (teacher.getPasswordSec().equals(cryptographe(password))){
				System.out.println(teacher.toString());
				teacher.setLogin(newlogin);
				teacher.setPasswordSec(cryptographe(newpassword));
				teacher.setPassword(bCryptPasswordEncoder.encode(newpassword));
				System.out.println(teacher.getPasswordSec());
				teachersRepository.save(teacher);
				
				String content1 = "M./Mme " + teacher.getFirstName()+ " vos parametres de connexions ont ete modifies"+ " \n"
						+"Login :: " +teacher.getLastName() + " \n"
						+"Password :: Retenez bien votre mot de passe\n"
						
						+ "Pour vous connecter a votre espace personnel cliquez ici :\n"
						+ "http://localhost:8080/SpringMvcJdbcTemplate/login";
				String subject1="MODIFICATION DES PARAMETRES DE CONNEXIONS";
				MimeMessage msg = new MimeMessage(sessions);
				/// msg.setFrom(new InternetAddress(form));
				msg.setRecipients(MimeMessage.RecipientType.TO, teacher.getEmailAdress());
				msg.setSubject(subject1);
				msg.setText(content1);
				msg.setSentDate(new Date());
				try{
				Transport transport = sessions.getTransport("smtp");
				transport.connect("smtp.gmail.com", "saphirmfogo@gmail.com", "best1234");
				transport.sendMessage(msg, msg.getAllRecipients());
				transport.close();
				model.addAttribute("teachers", "Vos param�tres ont �t� modifi�s avec succ�s.");
				}catch(Exception ex){
					model.addAttribute("teachers", "Parametre modifier mais echec de notification par mail");
					
				}
			}else{
				model.addAttribute("errorPassword", "Veuillez entrer votre ancien mot de passe");
				
			}
		}else{
			model.addAttribute("errorLogin", "Veuillez entrer votre ancien login");
		}
		

		return "teacher/updateParameterTeacher";
	}

	//ajouter un document
	@RequestMapping(value = { "/addDocument" }, method = RequestMethod.GET)
	public String addDocumentGet(Model model,HttpServletRequest req) {
		System.out.println("addDocument get");
		
		model.addAttribute("error", "");
		return "teacher/addDocument";
	}

	@RequestMapping(value = { "/addDocument" }, method = RequestMethod.POST)
	/*@Transactional*/
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
		Date createDate = new Date();
		/*String d=date+"";
		
		Date createDate = sdf.parse(d);*/

		System.out.println(createDate);
		
		try {
			HttpSession session = req.getSession();
			Teacher author =  (Teacher) session.getAttribute( "teacher" );
			System.out.println(author);
			String documentName= documentTitle+"_"+createYear+".pdf";
			System.out.println(author.getFirstName());
			byte[] bytes = file.getBytes();
			File dir = new File(SAVE_DIR);
			if (!dir.exists())
				dir.mkdirs();
			
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(context.getRealPath("") + File.separator  +SAVE_DIR + File.separator + documentName));
			stream.write(bytes);
			stream.close();
			System.out.println(author);
		
			//String documentNames=SAVE_DIR + File.separator + documentName;
			Document document= new Document();
			
				//document.setDocumentDescription(documentDescription);
				document.setDocumentTitle(documentTitle);
			
				document.setDocumentType(documentType);
				
				document.setDocumentName(documentName);
			
				document.setCreateDate(createDate);
				
				document.setAuthor(author);
				

				documentRepository.save(document);
				model.addAttribute("documents", "Enregistrement r�ussi: document ajout� avec sucess");

			
			
		} catch (Exception e) {
			
			model.addAttribute("error", "Echec d'enregistrement: Une �rreur est survenue lors de l'ajout du document.");
			
		}
		
		return "teacher/addDocument";
			/*
		*/
	}
	
	// on donne le nom d'un enseignant ion retourne ses documents
	
		@RequestMapping(value = { "/listDocuments" }, method = RequestMethod.GET)
	public String listDocumentsGet(Model model,HttpServletRequest req) {
			System.out.println("listDocuments get");
		model.addAttribute("error", " ");
			HttpSession session = req.getSession();
			Teacher author =  (Teacher) session.getAttribute( "teacher" );
			
		List<Document> listOfdocuments= documentRepository.findByAuthor(author);
			
		if(listOfdocuments.isEmpty()){
			
			model.addAttribute("error", "liste de documents vide");
			}else{
				model.addAttribute("documents", listOfdocuments);
			}
			
			return "teacher/listDocuments";
		}
		
		//liste des documents en fonction du type
		@RequestMapping(value = { "/listDocumentsByType" }, method = RequestMethod.GET)
		public String listDocumentsByTypeGet(Model model,HttpServletRequest req) {
			System.out.println("listDocuments get");
		model.addAttribute("error", " ");
			HttpSession session = req.getSession();
			Teacher author =  (Teacher) session.getAttribute( "teacher" );
			String documentType =req.getParameter("documentType");
			
			List<Document> listOfdocuments= documentRepository.findByAuthorAndDocumentType(author, documentType);
			
			if(listOfdocuments.isEmpty()){
			
			model.addAttribute("error", "Aucun "+documentType+" n'a �t� ajout�.");
			}else{
				model.addAttribute("documents", listOfdocuments);
				model.addAttribute("documentType", documentType);
			}
			//model.addAttribute("documentType", documentType);
			return "teacher/listDocumentsByType";
		}
		
		//chercher un document en particuier avec son id
		@RequestMapping(value = { "/documentsDescription" }, method = RequestMethod.GET)
		public String documentsDescriptionGet(Model model,HttpServletRequest req) {
			System.out.println("listDocuments get");
			
			/*HttpSession session = req.getSession();
			Teacher author =  (Teacher) session.getAttribute( "teacher" );*/
			String idDoc =req.getParameter("idDocument");
		model.addAttribute("error", " ");
			Long idDocument=Long.parseLong(idDoc);
			
			Document documents= documentRepository.findByIdDocument(idDocument);
			
			if(documents==null){
			
			model.addAttribute("error", "Aucun document n'a �t� ajout�.");
			}else{
				model.addAttribute("documents", documents);
			}
			return "teacher/documentsDescription";
		}
	
	

	//modifier un document
	@RequestMapping(value = { "/updateDocument" }, method = RequestMethod.GET)
	public String updateDocumentGet(Model model,HttpServletRequest req) {
		System.out.println("updateDocument get");
		//model.addAttribute("error", "");
		return "teacher/updateDocument";
	}


	@RequestMapping(value = { "/updateDocument" }, method = RequestMethod.POST)
	@Transactional
	public String updateDocumentPost(Model model, HttpServletRequest req,@RequestParam("file") MultipartFile file) throws ParseException {

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
		Date createDate = new Date();
		/*String d=date+"";
		
		Date createDate = sdf.parse(d);*/

		System.out.println(createDate);
		
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
					new FileOutputStream(context.getRealPath("") + File.separator  +SAVE_DIR + File.separator + documentName));
			stream.write(bytes);
			stream.close();
		
			//String documentNames=SAVE_DIR + File.separator + documentName;
			Document document= new Document();

				document.setDocumentDescription(documentDescription);
				document.setDocumentTitle(documentTitle);
				document.setDocumentType(documentType);
			document.setDocumentName(documentName);
				document.setCreateDate(createDate);
				document.setAuthor(author);

				documentRepository.save(document);
				model.addAttribute("documents", "Enregistrement r�ussi: document ajout� avec sucess");

			
			
		} catch (Exception e) {
			
			model.addAttribute("error", "Echec d'enregistrement: Une �rreur est survenue lors de l'ajout du document.");
			
		}
		return "teacher/updateDocument";
	}

	// editer le profil

	@RequestMapping(value = { "/editProfil" }, method = RequestMethod.GET)
	public String editProfilGet(Model model,HttpServletRequest req) {
		System.out.println("editProfil get");
		model.addAttribute("error", " ");
		HttpSession session = req.getSession();
		Teacher teacher =  (Teacher) session.getAttribute( "teacher" );
		List<ResearchDomain> listOfResearchDomain = researchDomainRepository.findAll();
		//Teacher teacher = teachersRepository.findByLogin(authors.getLogin());
		
		List<Grade> grades = gradeRepository.findAll(); 

		if (listOfResearchDomain.isEmpty() ) {
			model.addAttribute("error", "error : liste vide");
		}
		model.addAttribute("researchDomains", listOfResearchDomain);
		model.addAttribute("teachers", teacher);
		model.addAttribute("grades", grades);
		
		//model.addAttribute("error", "");
		return "teacher/editProfil";
	}

	@RequestMapping(value = { "/editProfil" }, method = RequestMethod.POST)
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
		Teacher teacher =  (Teacher) session.getAttribute( "teacher" );
		
		//Teacher teacher = teachersRepository.findByLogin(authors.getLogin());

		ResearchDomain researchDomain=researchDomainRepository.findByDomainLabel(domainLabel);
		Grade grade = gradeRepository.findByGradeName(gradeName);

		/*if(teacher==null){
			model.addAttribute("error", "erreur d'ajout du document; veuillez vous connecter d'abord");
			
		}else{
		*/	
			String pictureName= lastName+"_"+firstName+"profil.png";
			byte[] bytes = file.getBytes();
			File dir = new File(SAVE_DIR);
			if (!dir.exists())
				dir.mkdirs();
			
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(context.getRealPath("") + File.separator  + SAVE_DIR + File.separator + pictureName));
			stream.write(bytes);
			stream.close();
		
			//String pictureNames=SAVE_DIR + File.separator + pictureName;
			
			
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
			teacher.setPictureName(pictureName);
		
			
			teachersRepository.save(teacher);
			model.addAttribute("teachers", "Profil �dit� avec succ�s");
		
		//}
		return "teacher/editProfil";
	}
	
	// se deconnecter
		@RequestMapping(value = "/logoutTeacher", method = RequestMethod.GET)
		public String logoutPost(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		model.addAttribute("error", " ");
			  HttpSession session = request.getSession();
			  //session.invalidate();
			  session.setAttribute( "teacher", null );
			 // model.addAttribute("teachers", "La session a ete supprimme");

			response.sendRedirect("index");
			return "index";
		}

		// information pour afficher la page personnelle
		@RequestMapping(value = "/informationTeacher", method = RequestMethod.GET)
		public String InformationTeacherGet(HttpServletRequest request, HttpServletResponse response, Model model) {
			System.out.println("InformationTeacher get");
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
			
			return "teacher/informationTeacher";
		}

		
	//methode pour liste les enseignants a un internaute	
		@RequestMapping(value = { "/viewTeacherList" }, method = RequestMethod.GET)
		public String teacherList(Model model, HttpServletRequest req) {
			System.out.println("teacherList");
		model.addAttribute("error", " ");
			List<Teacher> listOfTeacher =teachersRepository.findAll();

			if (listOfTeacher.isEmpty()) {
				model.addAttribute("error", "Aucun compte enseignant n'a �t� cr��.");
			}
			model.addAttribute("teachers", listOfTeacher);
			req.setAttribute("teacher", listOfTeacher);

			return "viewTeacherList";
		}

		@RequestMapping(value = { "/editResult" }, method = RequestMethod.GET)
		public String editResultGet(Model model,HttpServletRequest req) {
			System.out.println("createCommunique GET");
		model.addAttribute("error", " ");
			List<AcademicYear> listOfAcademicYear = academicYearRepository.findAll();

			if (listOfAcademicYear.isEmpty() ) {
				model.addAttribute("error", "Aucune Ann�e acad�mique d�finie.");
			}
			model.addAttribute("academicYear", listOfAcademicYear);

		return "teacher/editResult";
		}
		
		
		//editer un resultat
		
		@RequestMapping(value = { "/editResult" }, method = RequestMethod.POST)
	//	@Transactional
		public String editResultPost(Model model, HttpServletRequest req,@RequestParam("files") MultipartFile file) throws ParseException, IOException, ServletException {

			String sessions= req.getParameter("session");
			//String academicYear= req.getParameter("academicYear");
			String resultTitle= req.getParameter("resultTitle");

			//AcademicYear year= academicYearRepository.findByAcademicYear(academicYear);
			
			System.out.println(sessions);
			//System.out.println(academicYear);
			System.out.println(resultTitle);
			//Calendar calendarCourante = Calendar.getInstance();
			//int createYear = calendarCourante.get(Calendar.YEAR);
			//int createMonth = calendarCourante.get(Calendar.YEAR);
			
		
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			//Date createDate = sdf.parse(createYear);
			
			try {
				
				String resultFileName= resultTitle+"_"+sessions+".png";
				
				byte[] bytes = file.getBytes();
				File dir = new File(SAVE_DIR);
				if (!dir.exists())
					dir.mkdirs();
				
				BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(context.getRealPath("") + File.separator  +SAVE_DIR + File.separator + resultFileName));
				stream.write(bytes);
				stream.close();
			
			//String resultFileNames=SAVE_DIR + File.separator + resultFileName;
				Result result= new Result();

				//result.setAcademicYear(year);
			result.setResultFileName(resultFileName);
				result.setResultTitle(resultTitle);
				result.setSession(sessions);
				

				resultRepository.save(result);
				model.addAttribute("resutls", "R�sultat post� avec sucess");

				
				
			} catch (Exception e) {
				
				model.addAttribute("error", "Une erreur est survenue lors de l'enregistrement du fichier. Veuillez reessayer.");
				
			}
			
			return "teacher/editResult";
				/*
			*/
		}
		
		
		@RequestMapping(value = { "/listResult" }, method = RequestMethod.GET)
		public String listResultGet(Model model,HttpServletRequest req) {
			System.out.println("list result GET");
			HttpSession session = req.getSession();
			Teacher teacher =  (Teacher) session.getAttribute( "teacher" );
			
			List<Result> listOfResult = resultRepository.findByJury_JuryPresident(teacher);
			
			if (listOfResult.isEmpty() ) {
				model.addAttribute("error", "Aucun r�sultat n'a �t� d�fini");
			}
			model.addAttribute("results", listOfResult);

			return "listResult";
		}
		
		@RequestMapping(value = { "/viewResult" }, method = RequestMethod.GET)
		public String viewResultGet(Model model,HttpServletRequest req) {
			System.out.println("list result GET");
			
			List<Result> listOfResult = resultRepository.findAll();
			
			if (listOfResult.isEmpty() ) {
				model.addAttribute("error", "Aucun r�sultat n'a �t� d�fini");
			}
			model.addAttribute("results", listOfResult);

			return "viewResult";
		}
		
		@RequestMapping(value = { "/viewImageResult" }, method = RequestMethod.GET)
		public String viewImageResultGet(Model model,HttpServletRequest req) {
			System.out.println("viewImageResult GET");
			
			String name = req.getParameter("idResult");
			Long idResult=Long.parseLong(name);
			Result result=resultRepository.findByIdResult(idResult);
			
			model.addAttribute("results", result);

			return "viewImageResult";
		}





	


}
