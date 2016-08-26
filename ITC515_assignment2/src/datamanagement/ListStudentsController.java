package datamanagement;

public class ListStudentsController {
	
	//A private vairable to hold an instance of StudentManager
	private StudentManager studentManager_;

	/**
	 * This is the constructor of ListStudentsController 
	 * This will initialize the private variable by assigning the singleton instance from 
	 * StudentManager singleton class
	 */
	public ListStudentsController() {
		studentManager_ = StudentManager.get();
	}

	/**
	 * listStudents add students following the unitCode to the lister
	 * @param lister
	 * @param unitCode
	 */
	public void listStudents(IStudentLister lister, String unitCode) {
		lister.clearStudents();
		StudentMap students = studentManager_.getStudentsByUnit(unitCode);
		for (Integer id : students.keySet())
			lister.addStudent(students.get(id));
	}
}
