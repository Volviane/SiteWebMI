package com.mi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mi.model.Role;
import com.mi.services.RoleService;

import org.springframework.ui.Model;

@Controller
public class AdministratorController {
	
	@Autowired
	RoleService roleService;
	
	
	
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


		//create administrator get method
		@RequestMapping(value = { "/registrationAdministrator" }, method = RequestMethod.GET)
		public String createForm(Model model,HttpServletRequest req) {
			System.out.println("inscription d'un admin");
			return "registrationAdministrator";
		}
		
		//connexion d'un administrateur

		@RequestMapping(value = { "/connectionAdministrator" }, method = RequestMethod.GET)
		public String loginForm(Model model,HttpServletRequest req) {
			System.out.println("connexion  d'un admin");

			return "connectionAdministrator";
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

}
