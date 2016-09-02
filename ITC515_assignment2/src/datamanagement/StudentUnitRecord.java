package datamanagement;

public class StudentUnitRecord implements IStudentUnitRecord {
	private Integer studentId_;
	private String unitCode_;
	private float assignment1_, assignment2_, exam_;

	public StudentUnitRecord(Integer id, String code, float asg1, float asg2, float exam) {
		this.studentId_ = id;
		this.unitCode_ = code;
		this.setAssignment1Marks(asg1);
		this.setAssignment2Marks(asg2);
		this.setExamMarks(exam);
	}

	public Integer getStudentId() {
		return studentId_;
	}

	public String getUnitCode() {
		return unitCode_;
	}


	public void setAssignment1Marks(float assignment1) {
		if (assignment1 < 0 || assignment1 > UnitManager.unitMap().getUnit(unitCode_).getAsg1Weight()) {
			// Marks will be Kept within marking

			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.assignment1_ = assignment1;
	}

	public float getAssignment1Marks() {

		return assignment1_;
	}


	public void setAssignment2Marks(float assignment2) {
		if (assignment2 < 0 || assignment2 > UnitManager.unitMap().getUnit(unitCode_).getAsg2Weight()) {

			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.assignment2_ = assignment2;

	}

	public float getAssignment2Marks() {
		return assignment2_;
	}


	public void setExamMarks(float exam) {
		if (exam < 0 || exam > UnitManager.unitMap().getUnit(unitCode_).getExamWeight()) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.exam_ = exam;

	}

	public float getExamMarks() {
		return exam_;
	}

	public float getTotalMarks() {
		return assignment1_ + assignment2_ + exam_;

	}
}
