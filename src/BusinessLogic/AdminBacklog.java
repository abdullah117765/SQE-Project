package BusinessLogic;
import java.util.ArrayList;

import BusinessLogic.Admin;
import application.DB.*;
public class AdminBacklog  {


	private AdminBacklog() {
	}
	
	  private static AdminBacklog obj = new AdminBacklog();


	    public static AdminBacklog getInstance(){
	    	
	        return obj;
	    }

	
     

    public int addAdmin(String AdminId, String Name, String Password,String Salary, String PhoneNumber){
        if(AdminId.equalsIgnoreCase("00")){
            return -1;
        }
        Admin admin=new Admin(AdminId,Name, Password,Salary,PhoneNumber);
        int x1 = AdminDBHandler.getInstance().addadmin(admin);
        return x1;

    }
public ArrayList<Admin> DisplayAdmins(String id) {
    	
    	
    	ArrayList<Admin> adminlist= AdminDBHandler.getInstance().displayAdmin(id);
    	return adminlist;
    }
    
    
    public int Deleteadmin(String adminid) {
        if(adminid.equalsIgnoreCase("00")){
            return -1;
        }
    	int x1=AdminDBHandler.getInstance().Deleteadmin(adminid);
    	return x1;
    }
    
  public int SearchAdmin(String adminid) {
    	int x1= AdminDBHandler.getInstance().SearchAdmin(adminid);
    	return x1;
    }
  
    public int updateAdmin(Admin updateS, int x) {
    	// 1 for updating phone number
    	// 2 for updating Salary
    	int x1=AdminDBHandler.getInstance().updateAdmin(updateS,x);
    	return x1;
    }
    
    
    public int verifyAdmin(String Rollnumber, String password) {
    	int x1=AdminDBHandler.getInstance().verifyAdmin(Rollnumber, password);
    	return x1;
    }
    
    
    
    // course start from here
    
    public int  addCourse(String courseName, String credithour, String courseId){
        Course course=new Course(courseName,credithour, courseId);
       int x1= CourseDBHandler.getInstance().addCourse(course);
        if(x1==1){
            System.out.print("course added");

        }else{

            System.out.print("course not added");

        }

        return x1;
    }
    
public ArrayList<Course> SearchCourse(String courseid) {
    	
	ArrayList<Course> course= CourseDBHandler.getInstance().SearchCourse(courseid);
    if(course==null){
        System.out.print("courses not found");

    }else{

        System.out.print("courses are found");

    }
    	return course;
    }

    
public ArrayList<Course> DisplayCourse() {
    	ArrayList<Course> courselist= CourseDBHandler.getInstance().displayCourse();
    if(courselist==null){
        System.out.print("course not displayed");

    }else{

        System.out.print("course is displayed");

    }
    	return courselist;
    }
    
    
    public int DeleteCourse(String courseId) {
    	int x1=CourseDBHandler.getInstance().DeleteCourse(courseId);
        if(x1==-1){
            System.out.print("course not deleted");
        }else{
            System.out.print("course is deleted");

        }
    	return x1;
    }
    
    
    public int OfferCourse(String semId, String BatchId, String courseId,String  Department){
        Courseoffer offer=new Courseoffer(semId,BatchId, courseId,Department);
      int x1=CourseofferDBHandler.getInstance().OfferCourse(offer);

        if(x1==-1){

            System.out.print("course not offered");

        }else{

            System.out.print("course is offered");

        }
        return x1;
    }
    
    
    
public ArrayList<Courseoffer> DisplayOfferCourse(String semId,String batchId, String courseId, String Department) {
    Courseoffer offer=new Courseoffer(semId,batchId, courseId,Department);
    	ArrayList<Courseoffer> courseofferlist= CourseofferDBHandler.getInstance().DisplayOfferCourse(offer);
    if(courseofferlist==null){
        System.out.print("offered courses not displayed");

    }else{

        System.out.print("offered courses  is displayed");

    }
    	return courseofferlist;
    }
    
    
    public int unofferCourse(String semId, String batchId, String courseId, String Department) {
        Courseoffer offer=new Courseoffer(semId,batchId, courseId,Department);
    	int x1=CourseofferDBHandler.getInstance().unofferCourse(offer);
        if(x1==-1){
            System.out.print("course not unoffered");

        }else{

            System.out.print("course is unoffered");

        }

    	return x1;
    }
    
    
public int SearchofferCourse(String semId, String batchId, String courseId, String Department) {
    Courseoffer offer=new Courseoffer(semId,batchId, courseId,Department);
    int x1=CourseofferDBHandler.getInstance().SearchofferCourse(offer);
    if(x1==-1){
        System.out.print("course not found");

    }else{
        System.out.print("course is found");
    }
    	return x1;
    }
    
    
public int MakeAnnouncement(String announcement, String teachercheck, String studentcheck) {
            Announcement an=new Announcement(announcement, teachercheck, studentcheck);
	int x1=AnnouncementDBHandler.getInstance().MakeAnnouncement(an);
	return x1;
}

public ArrayList<Announcement> DisplayallAnnouncementfor(int x){
// if int x=2 then return teachers announcement only if int x=3 the student announcement will be returned
    ArrayList<Announcement> an1= AnnouncementDBHandler.getInstance().DisplayallAnnouncementfor(x);
	return an1;
}



}
