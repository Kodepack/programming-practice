package datamanagement;

public class StudentUnitRecord implements IStudentUnitRecord {
	private Integer studentId_;
	private String unitCode_;
	private float assignment1_, assignment2_, exam_;

	public StudentUnitRecord(Integer id, String code, float asg1, float asg2, float exam) {
		this.studentId_ = id;
		this.unitCode_ = code;
		this.setAsg1(asg1);
		this.setAsg2(asg2);
		this.setExam(exam);
	}

	public Integer getStudentID() {
		return studentId_;
	}

	public String getUnitCode() {
		return unitCode_;
	}

	public void setAsg1(float assignment1) {
		if (assignment1 < 0 || assignment1 > UnitManager.UM().getUnit(unitCode_).getAsg1Weight()) {
			// Marks will be Kept within marking
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.assignment1_ = assignment1;
	}

	public float getAsg1() {

		return assignment1_;
	}

	public void setAsg2(float assignment2) {
		if (assignment2 < 0 || assignment2 > UnitManager.UM().getUnit(unitCode_).getAsg2Weight()) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.assignment2_ = assignment2;

	}

	public float getAsg2() {
		return assignment2_;
	}

	public void setExam(float exam) {
		if (exam < 0 || exam > UnitManager.UM().getUnit(unitCode_).getExamWeight()) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.exam_ = exam;
	}

	public float getExam() {
		return exam_;
	}

	public float getTotal() {
		return assignment1_ + assignment2_ + exam_;

	}
}
