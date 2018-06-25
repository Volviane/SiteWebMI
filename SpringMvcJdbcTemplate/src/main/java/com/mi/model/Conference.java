package com.mi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="CONFERENCES")
public class Conference implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idConference;
	
	@Column(name="INITIATEUR")
	private Teacher initiator;
	
	@Temporal(TemporalType.TIME)
	private Date dateConférence;
	
	public Conference() {
		// TODO Auto-generated constructor stub
	}

}
