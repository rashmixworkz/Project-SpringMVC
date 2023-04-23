package com.xworkz.finalProject.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "project_table")
@NamedQuery(name = "findall", query = "select entity from SignUpEntity entity")
@NamedQuery(name = "findByUser", query = "select count(*) from SignUpEntity entity where entity.userId=:userName")
@NamedQuery(name = "findByEmaiId", query = "select count(*) from SignUpEntity entity where entity.email=:mail")
@NamedQuery(name = "findByMobileNo", query = "select count(*) from SignUpEntity entity where entity.mobile=:mobileNo")
@NamedQuery(name = "FindByUserId", query = "select entity from SignUpEntity entity where entity.userId=:user")
@NamedQuery(name = "FindByEmail", query = "select entity from SignUpEntity entity where entity.email=:um")
@NamedQuery(name = "loginCount", query = "update SignUpEntity entity set entity.count=:counts where entity.userId=:u")
@NamedQuery(name = "UpdatePassword", query = "update SignUpEntity entity set entity.password=:p,entity.resetPassword=:rs,entity.resetTime=:rt where entity.userId=:uu")

public class SignUpEntity extends AbstractAuditDto {
	@Id

	private int id;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile")
	private long mobile;

	@Column(name = "password")
	private String password;

	@Column(name = "confirm_password")
	private String confirmPassword;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_date")
	private LocalDateTime createdDate;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "updated_date")
	private LocalDateTime updatedDate;
	@Column(name = "login")
	private int count;
	@Column(name = "reset_password")
	private Boolean resetPassword;
	
	@Column(name = "time_set")
	private LocalTime resetTime;
	
	@Column(name="pic_name")
	private String pictureName;
	
	@OneToMany(mappedBy = "signUpEntity",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<AddTechnologyEntity> addTechnologyEntities;
}
