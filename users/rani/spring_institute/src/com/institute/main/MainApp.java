
package com.institute.main;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.institute.dao.CourseDAO;
import com.institute.dao.CourseSectionDAO;
import com.institute.dao.SectionDAO;
import com.institute.dao.TrainerDAO;
import com.institute.dao.UsersDAO;
import com.institute.model.Address;
import com.institute.model.Course;
import com.institute.model.CourseSection;
import com.institute.model.Section;
import com.institute.model.Trainer;
import com.institute.model.Users;



public class MainApp {
	public static void main(String[] args) {
		System.out.println("------------- start main ---------------");
		ApplicationContext context = new ClassPathXmlApplicationContext("institute-config.xml");
	
		CourseDAO courseDAO = (CourseDAO)context.getBean("courseDAO");
		Course course1=courseDAO.getByCourseId("C1");
		Course course2=courseDAO.getByCourseId("C2");
		Course course3=courseDAO.getByCourseId("C3");
		System.out.println(course1.getId());
		System.out.println(course2.getId());
		System.out.println(course3.getId());
		System.out.println("*************");
		SectionDAO sectionDAO = (SectionDAO)context.getBean("sectionDAO");
		Section section1=sectionDAO.getById(1);
		Section section2=sectionDAO.getById(2);
		Section section3=sectionDAO.getById(3);
		System.out.println(section1);
		System.out.println(section2);
		System.out.println(section3);
		System.out.println("*************");
		CourseSection csection1 = new CourseSection(course1,section1,"ACTIVE");
		csection1.setCreateDate(new Date());
		CourseSection csection2 = new CourseSection(course1,section2,"ACTIVE");
		csection2.setCreateDate(new Date());
		CourseSection csection3 = new CourseSection(course1,section3,"ACTIVE");
		csection3.setCreateDate(new Date());
		
		CourseSection csection12 = new CourseSection(course2,section1,"ACTIVE");
		csection12.setCreateDate(new Date());
		CourseSection csection22 = new CourseSection(course2,section2,"ACTIVE");
		csection22.setCreateDate(new Date());
		CourseSection csection32 = new CourseSection(course2,section3,"ACTIVE");
		csection32.setCreateDate(new Date());
		
		CourseSection csection13 = new CourseSection(course3,section1,"ACTIVE");
		CourseSection csection23 = new CourseSection(course3,section2,"ACTIVE");
		CourseSection csection33 = new CourseSection(course3,section3,"ACTIVE");
		csection13.setCreateDate(new Date());
		csection23.setCreateDate(new Date());
		csection33.setCreateDate(new Date());
		CourseSectionDAO courseSectionDAO = (CourseSectionDAO)context.getBean("courseSectionDAO");
		
		courseSectionDAO.save(csection1);
		courseSectionDAO.save(csection2);
		courseSectionDAO.save(csection3);
		System.out.println("**************");
		
		courseSectionDAO.save(csection12);
		courseSectionDAO.save(csection22);
		courseSectionDAO.save(csection32);
		System.out.println("**************");
		
		courseSectionDAO.save(csection13);
		courseSectionDAO.save(csection23);
		courseSectionDAO.save(csection33);
		System.out.println("**************");
		List<CourseSection> list=courseSectionDAO.findAll();
		System.out.println("**************");
		System.out.println(list);
		
	}
	
	public static void main4(String[] args) {
		System.out.println("------------- start main ---------------");
		ApplicationContext context = new ClassPathXmlApplicationContext("institute-config.xml");
		SectionDAO sectionDAO = (SectionDAO)context.getBean("sectionDAO");
		Section section1 = new Section("Introduction","ACTIVE");
		Section section2 = new Section("Testing","ACTIVE");
		Section section3 = new Section("Basic","ACTIVE");
		sectionDAO.save(section1);
		sectionDAO.save(section2);
		sectionDAO.save(section3);
		List<Section> list=sectionDAO.findAll();
		System.out.println("**************");
		System.out.println(list);
		
	}
	public static void main3(String[] args) {
		System.out.println("------------- start main ---------------");
		ApplicationContext context = new ClassPathXmlApplicationContext("institute-config.xml");
		CourseDAO courseDAO = (CourseDAO)context.getBean("courseDAO");
		Course course1 = new Course("C1","Java","ACTIVE",120.10);
		Course course2 = new Course("C2","Spring","ACTIVE",220.10);
		Course course3 = new Course("C3","HTML","ACTIVE",20.00);
		courseDAO.save(course1);
		courseDAO.save(course2);
		courseDAO.save(course3);
		List<Course> list=courseDAO.findAll();
		System.out.println("**************");
		System.out.println(list);
		
	}
	public static void main1(String[] args) {
		System.out.println("------------- start main ---------------");
		ApplicationContext context = new ClassPathXmlApplicationContext("institute-config.xml");
		//AnnotationConfigApplicationContext context  =new AnnotationConfigApplicationContext();
		
		UsersDAO usersDAO = (UsersDAO)context.getBean("usersDAO");
		Users trainerUser=usersDAO.getById(507);
		System.out.println("creating trainer with user "+trainerUser);
		TrainerDAO trainerdao= (TrainerDAO)context.getBean("trainerDAO");
		Trainer trainer = new Trainer(trainerUser);
		//trainer.setTrainerId(123);
		//trainer.setTrainerId(trainerUser.getId());
		trainer.setCourseSecId(1);
		trainer.setFee(100);
		
		
		 
		trainer.setCreateDate(new Date());
		
		trainerdao.save(trainer);
		Trainer trainer1 = (Trainer)trainerdao.getById(504);
		 System.out.println("created trainer ");
		 System.out.println(trainer1);
		
		
		//***************************************
//		UsersDAO usersDAO = (UsersDAO)context.getBean("usersDAO");
//		Users traineeUser=usersDAO.getById(504);
//		System.out.println("creating trainee with user "+traineeUser);
//		TraineeDAO traineedao= (TraineeDAO)context.getBean("traineeDAO");
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
//		Trainee trainee1 = (Trainee)traineedao.getById(504);
//		 System.out.println("created trainee ");
//		 System.out.println(trainee1);
		 
		
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
	//CreateUser
	public static void mainCreateUser(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("institute-config.xml");
		UsersDAO usersDAO = (UsersDAO)context.getBean("usersDAO");
	Address address1= new Address();
		
		address1.setAddressLine1("WildBerry Ct");
		address1.setAddressLine2("5690");
		address1.setCity("Forest");
		address1.setState("NJ");
		address1.setCountry("US");
		address1.setZipcode("08858");
		//address1.setId(5);
	//	Addrdao.save(address1);
		//Addrdao.delete(address1);
		Address address2= new Address();
		address2.setAddressLine1("RedBerry Ct");
		address2.setAddressLine2("2390");
		address2.setCity("Plainsboro");
		address2.setState("NJ");
		address2.setCountry("US");
		address2.setZipcode("09599");
		//address2.setId(6);
		
		//Addrdao.save(address2);
		
		Users users=new Users();
		//users.setId(123);
		users.setLoginId("log111");
		users.setPassword("password");
		users.setRoleId("role2");
		users.setFirstName("Moose");
		users.setMiddleName("Door");
		users.setLastName("Pi");
		
		users.setDateOfBirth(Date.from(LocalDate.of(1989,12,23).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		users.setEmailId("moose@gmail.com");
		users.setLegalStatus("H1");
		users.setHomeNo("123-555-4565");
		users.setOfficeNo("156-555-1566");
		users.setCellNo("156-555-1565");
		
		users.setHiqualification("I.Tech");
		//  users.setHomeAddressId(3);
		//  users.setOfficeAddressId(4);
		users.setHomeAddres(address1);
		users.setOfficeAddress(address2);
		  users.setJoinDate(Date.from(LocalDate.of(2009,6,15).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		  users.setNote("He is admin");
		 // users.setCreatedId(100);
		 
		  users.setCreateDate(new Date());
		
		  
		  
		  users.setGender("Male");
		 
			
		
		
		  usersDAO.save(users);
		  
		//  Users user=(Users)usersDAO.getById(123);
		  List<Users> usr =usersDAO.findAll();
		  System.out.println("*************users");
		  System.out.println(usr);
		  System.out.println("************user*");
		//  System.out.println(user);
	
	}
	
	
/*	public static void main2(String[] args) {
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
	}

}*/
}
