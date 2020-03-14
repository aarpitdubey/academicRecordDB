package com.aarpitdubey.ManyToMany;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Runner 
{
	public static void main(String[] args) {
		
		  SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		  
		  StudentDto astha = new StudentDto();
		  astha.setName("Astha");
		  astha.setStream("CSE");
		  
		  StudentDto arpit = new StudentDto();
		  arpit.setName("Arpit");
		  arpit.setStream("CSE");
		  
		  StudentDto rohan = new StudentDto();
		  rohan.setName("Rohan");
		  rohan.setStream("ECE");
		  
		  StudentDto baadsha = new StudentDto();
		  baadsha.setName("Baadsha");
		  baadsha.setStream("Mech");
		  
		  StudentDto majdur = new StudentDto();
		  majdur.setName("majdur");
		  majdur.setStream("civil");
		  
		  TeacherDto shishiraSir = new TeacherDto();
		  shishiraSir.setName("ShishiraSir");
		  shishiraSir.setSubjectClass("Java");
		  
		  
		  TeacherDto raghuSir = new TeacherDto();
		  raghuSir.setName("RaghuSir");
		  raghuSir.setSubjectClass("Programming");
		  
		  
		  TeacherDto shambhuSir = new TeacherDto();
		  shambhuSir.setName("ShambhuSir");
		  shambhuSir.setSubjectClass("Aptitude");
		  
		  TeacherDto vivekSir = new TeacherDto();
		  vivekSir.setName("VivekSir");
		  vivekSir.setSubjectClass("Core Java");
		  
		  
		  // 4 list for teacher
		  
		  List<StudentDto> studentListforShishiraSir = Arrays.asList(astha, rohan, baadsha);
		  List<StudentDto> studentListforRaghuSir = Arrays.asList(astha, arpit, baadsha, rohan, majdur);
		  List<StudentDto> studentListforShambhuSir = Arrays.asList(astha, arpit);
		  List<StudentDto> studentListforVivekSir = Arrays.asList(baadsha);
		  
		  List<TeacherDto> listForAstha = Arrays.asList(raghuSir, shishiraSir, shambhuSir);
		  List<TeacherDto> listForArpit = Arrays.asList(raghuSir, shambhuSir);
		  List<TeacherDto> listForBaadsha = Arrays.asList(raghuSir, shishiraSir);
		  List<TeacherDto> listForRohan = Arrays.asList(raghuSir, shishiraSir);
		  List<TeacherDto> listForMajdur = Arrays.asList(raghuSir);
		  
		  // relation
		  
		  shishiraSir.setStudents(studentListforShishiraSir);
		  raghuSir.setStudents(studentListforShishiraSir);
		  shambhuSir.setStudents(studentListforShishiraSir);
		  vivekSir.setStudents(studentListforShishiraSir);
		  
		  astha.setTeachers(listForAstha);
		  arpit.setTeachers(listForArpit);
		  rohan.setTeachers(listForRohan);
		  baadsha.setTeachers(listForBaadsha);
		  majdur.setTeachers(listForMajdur);
		  
		  Session session = sessionFactory.openSession();
		  Transaction transaction=session.beginTransaction();
		  
		  session.save(shishiraSir);
		  session.save(shambhuSir);
		  session.save(raghuSir);
		  session.save(vivekSir);
		  
		  session.save(astha);
		  session.save(arpit);
		  session.save(rohan);
		  session.save(baadsha);
		  session.save(majdur);
		  
		  
		  transaction.commit();
		  session.close();
		  sessionFactory.close();
		 
	}

}
