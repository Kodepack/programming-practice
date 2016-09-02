package datamanagement;

public class Unit implements IUnit {
	private String unitCode_;
	private String unitName_;
	private float column1_;
	private float column2_;
	private float column3_;
	private float column4_;
	private float column5_;
	private int assignment1_, assignment2_, exam_;

	private StudentUnitRecordList studentUnitRecordList;

	public Unit(String unitCode, String unitName, float column1, float column2, float column3, float column4,
			float column5, int assignment1, int assignment2, int exam, StudentUnitRecordList studentUnitRecordList) {

		this.unitCode_ = unitCode;
		this.unitName_ = unitName;
		this.column1_ = column1;
		this.column2_ = column2;
		this.column4_ = column3;
		this.column3_ = column4;
		this.column5_ = column5;
		this.setAssessmentWeights(assignment1, assignment2, exam);
		this.studentUnitRecordList = studentUnitRecordList == null ? new StudentUnitRecordList()
				: studentUnitRecordList;
	}

	public String getUnitCode() {
		return this.unitCode_;
	}

	public String getUnitName() {

		return this.unitName_;
	}

	public void setPsCutoff1(float cutoff) {
		this.column1_ = cutoff;
	}

	public float getPsCutoff() {
		return this.column1_;
	}

	public void setCrCutoff(float cutoff) {
		this.column2_ = cutoff;
	}

	public float getCrCutoff() {
		return this.column2_;
	}

	public void setDiCutoff(float cutoff) {
		this.column4_ = cutoff;
	}

	public float getDiCuttoff() {
		return this.column4_;
	}

	public void HDCutoff(float cutoff) {
		this.column3_ = cutoff;
	}

	public void setHdCutoff(float cutoff) {
		this.column3_ = cutoff;
	}

	public float getHdCutoff() {
		return this.column3_;

	}

	public void setAeCutoff(float cutoff) {
		this.column5_ = cutoff;
	}

	public float getAeCutoff() {
		return this.column5_;
	}

	public void addStudentRecord(IStudentUnitRecord record) {
		this.studentUnitRecordList.add(record);
	}

	public IStudentUnitRecord getStudentRecord(int studentID) {
		for (IStudentUnitRecord r : this.studentUnitRecordList) {
			if (r.getStudentId() == studentID)
				return r;
		}
		return null;
	}

	public StudentUnitRecordList listStudentRecords() {
		return this.studentUnitRecordList;
	}

	@Override
	public int getAsg1Weight() {
		return this.assignment1_;
	}

	@Override
	public int getAsg2Weight() {
		return this.assignment2_;
	}

	@Override
	public int getExamWeight() {
		return this.exam_;
	}

	@Override
	public void setAssessmentWeights(int assignment1, int assignment2, int exam) {
		if (assignment1 < 0 || assignment1 > 100 || assignment2 < 0 || assignment2 > 100 || exam < 0 || exam > 100) {
			throw new RuntimeException("Assessment weights cant be less than zero or greater than 100");
		}
		if (assignment1 + assignment2 + exam != 100) {
			throw new RuntimeException("Assessment weights must add to 100");
		}
		this.assignment1_ = assignment1;
		this.assignment2_ = assignment2;
		this.exam_ = exam;
	}

	private void setCutoffs(float ps, float cr, float di, float hd, float ae) {
		if (ps < 0 || ps > 100 || cr < 0 || cr > 100 || di < 0 || di > 100 || hd < 0 || hd > 100 || ae < 0
				|| ae > 100) {
			throw new RuntimeException("Assessment cutoffs cant be less than zero or greater than 100");
		}
		if (ae >= ps) {
			throw new RuntimeException("AE cutoff must be less than PS cutoff");
		}
		if (ps >= cr) {
			throw new RuntimeException("PS cutoff must be less than CR cutoff");
		}
		if (cr >= di) {
			throw new RuntimeException("CR cutoff must be less than DI cutoff");
		}
		if (di >= hd) {
			throw new RuntimeException("DI cutoff must be less than HD cutoff");
		}

	}

	public String getGrade(float f1, float f2, float f3) {
		float t = f1 + f2 + f3;

		if (f1 < 0 || f1 > this.assignment1_ || f2 < 0 || f2 > this.assignment2_ || f3 < 0 || f3 > this.exam_) {
			throw new RuntimeException("marks cannot be less than zero or greater than assessment weights");
		}

		if (t < this.column5_) {
			return "FL";
		} else if (t < this.column1_)
			return "AE";
		else if (t < this.column2_)
			return "PS";
		else if (t < this.column4_)
			return "CR";
		else if (t < this.column3_)
			return "DI";
		else
			return "HD";
	}


}