package com.mi.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mi.services.AdministratorService;





@Service("UserDetailsService")
public class UserDetailsServices implements UserDetailsService  {
	
	@Autowired
	AdministratorService administratorRepository;
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		System.out.println(login+" donne pardon");
		UserDetails userDetail=null;
		//Member user = memberRepository.findByPseudonym(pseudonym);
		if(administratorRepository.findByLoginAdmin(login)!=null) {
			System.out.println(administratorRepository.findByLoginAdmin(login)+"toototot");
			Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

			/*for (Role role : administratorRepository.findByLoginAdmin(login).getRoles()){
				grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
			}*/
				
			userDetail=new org.springframework.security.core.userdetails.User(administratorRepository.findByLoginAdmin(login).getLogin(), 
					administratorRepository.findByLoginAdmin(login).getPassword(), grantedAuthorities);
			

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