package datamanagement;

public class StudentUnitRecord implements IStudentUnitRecord {
	private Integer studentId;
	private String unitCode;
	private float assignment1, assignment2, exam;

	public StudentUnitRecord(Integer id, String code, float asg1, float asg2, float exam) {
		this.studentId = id;
		this.unitCode = code;
		this.setAsg1(asg1);
		this.setAsg2(asg2);
		this.setExam(exam);
	}

	public Integer getStudentID() {
		return studentId;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setAsg1(float a1) {
		if (a1 < 0 || a1 > UnitManager.UM().getUnit(unitCode).getAsg1Weight()) {
			// Marks will be Kept within marking
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.assignment1 = a1;
	}

	public float getAsg1() {

		return assignment1;
	}

	public void setAsg2(float a2) {
		if (a2 < 0 || a2 > UnitManager.UM().getUnit(unitCode).getAsg2Weight()) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.assignment2 = a2;

	}

	public float getAsg2() {
		return assignment2;
	}

	public void setExam(float ex) {
		if (ex < 0 || ex > UnitManager.UM().getUnit(unitCode).getExamWeight()) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.exam = ex;
	}

	public float getExam() {
		return exam;
	}

	public float getTotal() {
		return assignment1 + assignment2 + exam;

	}
}
