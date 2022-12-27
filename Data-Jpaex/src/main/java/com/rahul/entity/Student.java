package com.rahul.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "std_table")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "std_Id")
	private Integer stdId;
	
	@Column(name="std_Name")
	private String  stdName; 
	
	@Column(name="std_Fee")
	private double  stdFee; 
	
	public Student(String stdName, double stdFee) {
		super();
		this.stdName = stdName;
		this.stdFee = stdFee;
	}

}
