package com.xworkz.finalProject.entity;



import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="add_technologies")

public class AddTechnologyEntity {
	
@Id

@Column(name="tech_id")
private int id;
@Column(name="technology_name")
private String techName;
@Column(name="lang")	
private String language;
@Column(name="owner_name")	
private String owner;
@Column(name="supp_from")	
private String supportFrom;
@Column(name="supp_to")	
private String supportTo;
@Column(name="licence_name")	
private  String license;
@Column(name="open_source")	
private String openSource;
@Column(name="os_type")	
private String osType;
@Column(name = "created_by")
private String createdBy;

@Column(name = "created_date")
private LocalDateTime createdDate;

@Column(name = "updated_by")
private String updatedBy;

@Column(name = "updated_date")
private LocalDateTime updatedDate;


@ManyToOne
@JoinColumn(name="userId",referencedColumnName = "user_id")
private SignUpEntity signUpEntity;

}
