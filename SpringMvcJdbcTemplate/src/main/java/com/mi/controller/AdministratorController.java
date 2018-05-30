package com.mi.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mi.model.Administrator;
import com.mi.model.Role;

import com.mi.services.AdministratorService;
import com.mi.services.RoleService;
import com.mi.services.UserDetailsServices;

import org.springframework.ui.Model;

@Controller
public class AdministratorController {
	public static final Logger logger = LoggerFactory.getLogger(AdministratorController.class);
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	AdministratorService administratorService;
	
	/*@Autowired
	UserDetailsServices use;*/
	
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
				roles.setRoleName(roleName);
				//role.setUsers(new HashSet<>(studentRepository.findAll()));
				//roleRepository.save(role);
			} else if (roleName.equalsIgnoreCase("ROLE_TEACHERS")) {
				roles.setRoleName(roleName);
				//role.setAdmin(new HashSet<>(teachersRepository.findAll()));
				//roleRepository.save(role);

			} else if (roleName.equalsIgnoreCase("ROLE_ADMIN")) {
				//role.setName(roleName);
				roles.setRoleName(roleName);
				//roles.setAdmins(new HashSet<>(administratorRepository.findAll()));
				roleService.saveRole(roles);
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
			Role role = roleService.findByRoleName("ROLE_ADMIN");
			Set<Role> setRole = new HashSet<>();
			setRole.add(role);

			Administrator administrator= new Administrator();
			administrator.setLogin(login);
			//administrator.setPassword(bCryptPasswordEncoder.encode(password));
			//administrator.setPasswordSec(cryptographe(password));
			//administrator.setRoles(setRole);
			//administratorRepository.deleteAll();
			administratorService.saveAdministrator(administrator);

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
				Administrator administrator = new Administrator();
				administrator = administratorService.findByLoginAdmin(loginAdmin);
				if (administrator != null) {
					String pass = cryptographe(passwordAdmin);
					System.out.println(pass);
					if (pass.equals(administrator.getPasswordSec())) {

						UserDetails users = loadUserByUsername(loginAdmin);
						System.out.println("Humm tu as reussi a me mettre en session tu es forte ma petite " + users);
						UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(users, null,
								users.getAuthorities());
						SecurityContextHolder.getContext().setAuthentication(authToken);

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

		
		// ajouter les cycles


				@RequestMapping(value = "/addCycle", method = RequestMethod.GET)
				public String cycleGet(Model model,HttpServletRequest req) {
					System.out.println("add cycle  get");

					return "addCycle";
				}

				
				//ajouter les options 

				@RequestMapping(value = "/addOption", method = RequestMethod.GET)
				public String optionGet(Model model,HttpServletRequest req) {
					System.out.println("addOption get");

					return "addOption";
				}
				// ajouter les niveaux
				@RequestMapping(value = "/addLevel", method = RequestMethod.GET)
				public String levelGet(Model model,HttpServletRequest req) {
					System.out.println("add level  get");

					return "addLevel";
				}
				
				//ajouter les UVs

				@RequestMapping(value = "/addCourse", method = RequestMethod.GET)
				public String coursesGet(Model model,HttpServletRequest req) {
					System.out.println("addCourse get");

					return "addCourse";
				}
				//enregisrtre les grades
				@RequestMapping(value = { "/addGrade" }, method = RequestMethod.GET)
				public String gradeGet(Model model) {
					System.out.println("addGrade GET");

					return "addGrade";
				}
				
				//enregisrtre un ensegnant
				@RequestMapping(value = { "/createTeacher" }, method = RequestMethod.GET)
				public String createTeacherGet(Model model,HttpServletRequest req) {
					System.out.println("createTeacher GET");

					return "createTeacher";
				}
				
				//creation d'un evennement
				@RequestMapping(value = { "/createEvent" }, method = RequestMethod.GET)
				public String createEventGet(Model model,HttpServletRequest req) {
					System.out.println("createEvent GET");

					return "createEvent";
				}
				
				//enregisrtre des jurys pour l'ouverture d'une annee academique 
				@RequestMapping(value = { "/openAcademicYear" }, method = RequestMethod.GET)
				public String openAcademicYearGet(Model model,HttpServletRequest req) {
					System.out.println("openAcademicYear GET");

					return "openAcademiqueYear";
				}
				
				
				
				
				
				
				@Transactional(readOnly = true)
				public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
					System.out.println(login+" donne pardon");
					UserDetails userDetail=null;
					//Member user = memberRepository.findByPseudonym(pseudonym);
					if(administratorService.findByLoginAdmin(login)!=null) {
						System.out.println(administratorService.findByLoginAdmin(login)+"toototot");
						Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

						/*for (Role role : administratorRepository.findByLoginAdmin(login).getRoles()){
							grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
						}*/
							
						userDetail=new org.springframework.security.core.userdetails.User(administratorService.findByLoginAdmin(login).getLogin(), 
								administratorService.findByLoginAdmin(login).getPassword(), grantedAuthorities);
						

					}/*else if(teachersRepository.findByLogin(login)!=null) {
					
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
				

}
