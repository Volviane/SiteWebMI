package com.mi.dao;

import java.util.List;

import com.mi.model.Contact;

/**
 * Defines DAO operations for the contact model.
 * @author www.codejava.net
 *
 */
public interface ContactDAO {
	
	public void saveOrUpdate(Contact contact);
	
	public void delete(int contactId);
	
	public Contact get(int contactId);
	
	public List<Contact> list();
}
