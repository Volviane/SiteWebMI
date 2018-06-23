package com.mi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Dissertation")
//@Table(name="MEMOIRES")
@DiscriminatorValue("MEMOIRE")
public class Dissertation extends Document implements Serializable {

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="ID_MEMOIRE")
//	private int idDissertation;

	
	public Dissertation() {
		// TODO Auto-generated constructor stub
	}

}
