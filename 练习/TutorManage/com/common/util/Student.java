package com.common.util;

import java.util.Date;

public class Student {
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", password=" + password + ", grade=" + grade + ", school="
				+ school + ", career=" + career + ", sclass=" + sclass + ", GPA=" + GPA + ", award=" + award + ", xb="
				+ xb + ", csrq=" + csrq + ", email=" + email + ", hobby=" + hobby + ", phone=" + phone + ", phone2="
				+ phone2 + "]";
	}
	String sno;
	String sname;
	String password;
	String grade;
	String school;
	String career;
	String sclass;
	String GPA;
	String award;
	int xb;
	Date csrq;
	String email;
	String hobby;
	String phone;
	String phone2;
	public Student(){};
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public String getGPA() {
		return GPA;
	}
	public void setGPA(String gPA) {
		GPA = gPA;
	}
	public String getAward() {
		return award;
	}
	public void setAward(String award) {
		this.award = award;
	}
	public int getXb() {
		return xb;
	}
	public void setXb(int xb) {
		this.xb = xb;
	}
	public Date getCsrq() {
		return csrq;
	}
	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	
}
