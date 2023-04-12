package com.xworkz.finalProject.entity;



import java.time.LocalDateTime;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="project_table")
@NamedQuery(name="findall",query="select entity from SignUpEntity entity")
@NamedQuery(name="findByUser",query="select count(*) from SignUpEntity entity where entity.userId=:userName")
@NamedQuery(name="findByEmaiId",query="select count(*) from SignUpEntity entity where entity.email=:mail")
@NamedQuery(name="findByMobileNo",query="select count(*) from SignUpEntity entity where entity.mobile=:mobileNo")
@NamedQuery(name="FindByUserId",query="select entity from SignUpEntity entity where entity.userId=:user")
@NamedQuery(name="loginCount",query="update SignUpEntity entity set entity.count=:counts where entity.userId=:u")
//@NamedQuery(name="reset",query="select entity from SignUpEntity entity where entity.email=:resetEmail")
public class SignUpEntity extends AbstractAuditDto{
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobile")
	private long mobile;
	
	@Column(name="password")
	private String password;
	
	@Column(name="confirm_password")
	private String confirmPassword;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="created_date")
	private LocalDateTime createdDate;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	@Column(name="updated_date")
	private LocalDateTime updatedDate;
@Column(name="login")
	private int count;

//private boolean resetPassword;
	

}
