package datamanagement;

public class StudentProxy implements IStudent {
	private Integer studentId_;
	private String lastName_;

	private String firstName_;
	private StudentManager studentManager_;

	public StudentProxy(Integer id, String firstName, String lastName) {
		this.studentId_ = id;
		this.lastName_ = firstName;

		this.firstName_ = lastName;
		this.studentManager_ = StudentManager.get();
	}

	public Integer getId() {
		return studentId_;

	}

	public String getFirstName() {
		return lastName_;
	}

	public String getLastName() {
		return firstName_;
	}

	public void setFirstName(String firstName) {

		studentManager_.getStudent(studentId_).setFirstName(firstName);
	}

	public void setLastName(String lastName) {

		studentManager_.getStudent(studentId_).setLastName(lastName);
	}

	public void addUnitRecord(IStudentUnitRecord record) {
		studentManager_.getStudent(studentId_).addUnitRecord(record);
	}

	public IStudentUnitRecord getUnitRecord(String unitCode) {

		return studentManager_.getStudent(studentId_).getUnitRecord(unitCode);
	}

	public StudentUnitRecordList getUnitRecords() {
		return studentManager_.getStudent(studentId_).getUnitRecords();
	}
}
