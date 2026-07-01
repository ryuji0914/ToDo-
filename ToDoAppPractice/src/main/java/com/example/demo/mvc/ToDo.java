package com.example.demo.mvc;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("todo")
public class ToDo {
	@Id
	private Long taskId;
	private String taskName;
	private String detail;
	private String priority;
	private String todoStatus;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
