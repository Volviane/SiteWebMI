package com.mi.dao;

import java.util.List;

import com.mi.model.Student;
import com.mi.model.User;

public interface StudentDAO {
	public int saveOrUpdate(Student contact);/*1=Update Success, 2=Update failed, 3=Insertion Success and 
	4=Insertion Failed*/

	public void delete(int inscriptionCode);

	public Student get(int inscriptionCode);
	public Student getByMail(String email);
	public User getByEmailAndPassword(String email,String password,String quality);
    
	public List<Student> list();
}
