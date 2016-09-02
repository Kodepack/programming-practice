package datamanagement;

/**
 * This is a student lister interface
 * 
 * @author jtulip
 *
 */
public interface IStudentLister {

	/**
	 * clearStudents shall remove all students from any concrete class that implements IStudentLister
	 */
	public void clearStudents();
	
	/**
	 * addStudent must add a concrete IStudent instance to the IStudentLister concrete class
	 * @param student
	 */
    public void addStudent(IStudent student);
}
