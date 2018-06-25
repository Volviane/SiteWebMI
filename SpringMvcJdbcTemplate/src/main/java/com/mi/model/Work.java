package com.mi.model;

import java.io.Serializable;

import javax.persistence.*;

//@Entity
//@Table(name="TRAVAUX")
//@DiscriminatorValue("TRAVAUX")
public class Work extends Document implements Serializable {
	
	/*@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TRAVAUX")
	private int idWork;*/

	
	public Work() {
		// TODO Auto-generated constructor stub
	}

}
