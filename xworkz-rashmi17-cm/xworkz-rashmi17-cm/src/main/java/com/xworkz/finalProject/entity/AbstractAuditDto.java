package com.xworkz.finalProject.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AbstractAuditDto implements Serializable {

	private String createdBy;
	private LocalDateTime createdDate;
	private String updatedBy;
	private LocalDateTime updatedDate;

}
