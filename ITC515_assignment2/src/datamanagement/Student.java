package datamanagement;

public class Student implements IStudent {
	private Integer id;
	private String firstName;
	private String lastName;
	private StudentUnitRecordList studentUnitRecordList;

	public Student(Integer id, String firstName, String lastName, StudentUnitRecordList studentUnitRecordList) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentUnitRecordList = studentUnitRecordList == null ? new StudentUnitRecordList() : studentUnitRecordList;
	}

	public Integer getId() {
		return this.id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {

		this.lastName = lastName;
	}

	public void addUnitRecord(IStudentUnitRecord record) {
		studentUnitRecordList.add(record);
	}

	public IStudentUnitRecord getUnitRecord(String unitCode) {
		for (IStudentUnitRecord studentUnitRecord : studentUnitRecordList){
			if (studentUnitRecord.getUnitCode().equals(unitCode)){
				return studentUnitRecord;
			}
		}
		return null;
	}

	public StudentUnitRecordList getUnitRecords() {
		return studentUnitRecordList;
	}
}
