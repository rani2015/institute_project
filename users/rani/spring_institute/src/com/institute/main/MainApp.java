
package com.institute.main;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.institute.dao.CourseDAO;
import com.institute.dao.TeacherDAO;
import com.institute.dao.TraineeDAO;
import com.institute.dao.UsersDAO;
import com.institute.model.Course;
import com.institute.model.Trainee;
import com.institute.model.Users;



public class MainApp {
	public static void main(String[] args) {
		System.out.println("------------- start main ---------------");
		ApplicationContext context = new ClassPathXmlApplicationContext("institute-config.xml");
		//AnnotationConfigApplicationContext context  =new AnnotationConfigApplicationContext();
//		UsersDAO usersDAO = (UsersDAO)context.getBean("usersDAO");
//		Users traineeUser=usersDAO.getById(504);
//		System.out.println("creating trainee with user "+traineeUser);
		TraineeDAO traineedao= (TraineeDAO)context.getBean("traineeDAO");
//		Trainee trainee = new Trainee(traineeUser);
//		//trainee.setTraineeId(123);
//		//trainee.setTraineeId(traineeUser.getId());
//		trainee.setExperience("5 years");
//		trainee.setPrevCompany("XYZ");
//		trainee.setSkill("Java");
//		
//		 
//		trainee.setCreateDate(new Date());
//		
//		traineedao.save(trainee);
		Trainee trainee = (Trainee)traineedao.getById(504);
		 System.out.println("created trainee ");
		 System.out.println(trainee);
		 
		
	/*	AddressDAO Addrdao =(AddressDAO)context.getBean("addressDAO");
		Address address1= new Address();
		
		address1.setAddressLine1("Strawberry Ct");
		address1.setAddressLine2("2290");
		address1.setCity("Edison");
		address1.setState("NJ");
		address1.setCountry("US");
		address1.setZipcode("08888");
		//address1.setId(5);
	//	Addrdao.save(address1);
		//Addrdao.delete(address1);
		Address address2= new Address();
		address2.setAddressLine1("BlueBerry Ct");
		address2.setAddressLine2("2290");
		address2.setCity("Plainsboro");
		address2.setState("NJ");
		address2.setCountry("US");
		address2.setZipcode("09999");
		//address2.setId(6);
		
		//Addrdao.save(address2);
		
		Users users=new Users();
		//users.setId(123);
		users.setLoginId("log111");
		users.setPassword("password");
		users.setRoleId("role2");
		users.setFirstName("John");
		users.setMiddleName("Ammy");
		users.setLastName("Jo");
		
		users.setDateOfBirth(Date.from(LocalDate.of(1989,12,23).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		users.setEmailId("john@gmail.com");
		users.setLegalStatus("H1");
		users.setHomeNo("123-123-4565");
		users.setOfficeNo("156-156-1566");
		users.setCellNo("156-156-1565");
		
		users.setHiqualification("M.Tech");
		//  users.setHomeAddressId(3);
		//  users.setOfficeAddressId(4);
		users.setHomeAddres(address1);
		users.setOfficeAddress(address2);
		  users.setJoinDate(Date.from(LocalDate.of(2009,12,23).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		  users.setNote("He is admin");
		 // users.setCreatedId(100);
		 
		  users.setCreateDate(new Date());
		
		  
		  
		  users.setGender("Male");
		 
			
		
		
		  usersDAO.save(users);
		  
		  Users user=(Users)usersDAO.getById(123);
		  List<Users> usr =usersDAO.findAll();
		  System.out.println("*************users");
		  System.out.println(usr);
		  System.out.println("************user*");
		  System.out.println(user);
		  System.out.println("*************address");
//		  List<Address> add =Addrdao.findAll();
//			
//			System.out.println(add);
//		*/
	}
	
	
	
	public static void main2(String[] args) {
		System.out.println("------------- start main ---------------");
		ApplicationContext context = new ClassPathXmlApplicationContext("institute-config.xml");
		System.out.println("got the context ");
		System.out.println("\n --------------Course--------------------\n");
		CourseDAO courseDAO = (CourseDAO)context.getBean("courseDAO");
		TraineeDAO studDAO =(TraineeDAO)context.getBean("studentDAO");
		TeacherDAO teachDAO =(TeacherDAO)context.getBean("teacherDAO");
		Course course1 = new Course("C1","Java",120.10,30);
		Course course2 = new Course("C2","Spring",220.10,40);
		Course course3 = new Course("C3","HTML",20.00,40);
		System.out.println(" creating courses ..");
		courseDAO.save(course1);
		courseDAO.save(course2);
		courseDAO.save(course3);
		System.out.println("  courses created ..");
		
		/* System.out.println("\n --------------Student--------------------\n");
		Trainee stud1=new Trainee(100, "Veda", "Godishala", new Date(), 10, "123-123-1235", "456-456-7895", "test@gmail.com", "5th", "Female");
		Trainee stud2=new Trainee(101, "Aaanya", "N", new Date(), 10, "123-123-1235", "456-456-7895", "test@gmail.com", "play", "Female");
		Trainee stud3=new Trainee(102, "Siri", "P", new Date(), 10, "123-123-1235", "456-456-7895", "test@gmail.com", "play", "Female");
		Trainee stud4=new Trainee(103, "Arjun", "K", new Date(), 10, "123-123-1235", "456-456-7895", "test@gmail.com", "play", "Male");
		
		System.out.println(" creating Student ..");
		studDAO.save(stud1);
		studDAO.save(stud2);
		studDAO.save(stud3);
		studDAO.save(stud4);
		System.out.println("  Student created ..");
		
		System.out.println("Adding Courses to student");
		
		System.out.println(" getting student ..\n");
		stud1=studDAO.getById(100);
		System.out.println("  student .."+stud1+"\n");
		
		System.out.println(" adding courses to students  ");
		stud1.addCourse(course1);
		stud1.addCourse(course2);
		stud1.addCourse(course3);
		
		stud2.addCourse(course1);
		stud2.addCourse(course3);
		
		stud3.addCourse(course2);
		stud3.addCourse(course3);
		
		System.out.println(" saving students ");
		studDAO.save(stud1);
		studDAO.save(stud2);
		studDAO.save(stud3);
		System.out.println(" students saved with courses ");
		
		System.out.println(" get all details");
		List<Trainee> studList = studDAO.findAll();
		System.out.println(" ----------------------------------\n");
		for (Trainee student : studList) {
			System.out.println(" ------\n");
			System.out.println(student);
			int i=1;
			for (Course course : student.getCourses()) {
				System.out.println(" Course "+(i++)+ " : "+course);
			}
			System.out.println(" ------\n");
		}
		
		
		System.out.println(" ----------------------------------");
		System.out.println("\n --------------TEACHER--------------------\n");
		
		
		Teacher teach1=new Teacher(300, "Venkat", "K",  "123-123-1235", "456-456-7895", "test@gmail.com");
		Teacher teach2=new Teacher(301, "Malik", "N",  "123-123-1235", "456-456-7895", "test@gmail.com");
		Teacher teach3=new Teacher(302, "Ram", "G", "123-123-1235", "456-456-7895", "test@gmail.com");
		System.out.println(" creating Teacher ..");
		teachDAO.save(teach1);
		teachDAO.save(teach2);
		teachDAO.save(teach3);
		
		System.out.println("  Teacher created ..");
		
		System.out.println("Adding Courses to teacher");
		
		System.out.println(" getting teacher ..\n");
		teach1=teachDAO.getById(300);
		System.out.println("  teacher .."+teach1+"\n");
		
		System.out.println(" adding courses to teachers  ");
		teach1.addCourse(course1);
		teach1.addCourse(course2);
		teach1.addCourse(course3);
		
		teach2.addCourse(course1);
		teach2.addCourse(course3);
		
		teach3.addCourse(course2);
		teach3.addCourse(course3);
		
		System.out.println(" saving teachers ");
		teachDAO.save(teach1);
		teachDAO.save(teach2);
		teachDAO.save(teach3);
		System.out.println(" teachers saved with courses ");
		
		System.out.println(" get all details");
		List<Teacher> teachList = teachDAO.findAll();
		System.out.println(" ----------------------------------\n");
		for (Teacher teacher : teachList) {
			System.out.println(" ------\n");
			System.out.println(teacher);
			int i=1;
			for (Course course : teacher.getTeachCourses()) {
				System.out.println(" Course "+(i++)+ " : "+course);
			}
			System.out.println(" ------\n");
		}
	
		
		
		
		System.out.println("------------- End main ---------------");
	}*/

}
}
