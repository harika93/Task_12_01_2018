package com.model;
// Generated Jun 18, 2019 12:09:32 PM by Hibernate Tools 5.1.7.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Student generated by hbm2java
 */
@Entity
@Table(name = "student", catalog = "boot_exception")
public class Student implements java.io.Serializable {

	private Long studentId;
	private long studentRollNo;
	private String studentName;

	public Student() {
	}

	public Student(long studentRollNo) {
		this.studentRollNo = studentRollNo;
	}

	public Student(long studentRollNo, String studentName) {
		this.studentRollNo = studentRollNo;
		this.studentName = studentName;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "STUDENT_ID", unique = true, nullable = false)
	public Long getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	@Column(name = "STUDENT_ROLL_NO", nullable = false)
	public long getStudentRollNo() {
		return this.studentRollNo;
	}

	public void setStudentRollNo(long studentRollNo) {
		this.studentRollNo = studentRollNo;
	}

	@Column(name = "STUDENT_NAME", length = 256)
	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

}
