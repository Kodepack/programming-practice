package datamanagement;
/**
 * 
 * @author Kishantha
 * 21-08-2016: Formated the code. added comments
 *
 *
 */

/**
 * 
 * CheckGradeController class
 *
 */
public class CheckGradeController {

	//checkGradeUI will hold an object for 
	CheckGradeUI checkGradeUI;
	String currentUnitCode = null;
	Integer currentStudentID = null;
	//A variable to keep track of change mode or view mode
	boolean changed = false;

	public CheckGradeController() {
	}

	public void execute() {
		checkGradeUI = new CheckGradeUI(this);
		checkGradeUI.setState1(false);

		checkGradeUI.setState2(false);
		checkGradeUI.setState3(false);
		checkGradeUI.setState4(false);
		checkGradeUI.setState5(false);
		checkGradeUI.setState6(false);
		checkGradeUI.Refresh3();

		ListUnitsController listUnitsCTL = new ListUnitsController();
		listUnitsCTL.listUnits(checkGradeUI);
		checkGradeUI.setVisible(true);
		checkGradeUI.setState1(true);
	}

	public void unitSelected(String code) {

		if (code.equals("NONE"))
			checkGradeUI.setState2(false);
		else {
			ListStudentsController lsCTL = new ListStudentsController();
			lsCTL.listStudents(checkGradeUI, code);
			currentUnitCode = code;
			checkGradeUI.setState2(true);
		}
		checkGradeUI.setState3(false);
	}

	public void studentSelected(Integer id) {
		currentStudentID = id;
		if (currentStudentID.intValue() == 0) {
			checkGradeUI.Refresh3();
			checkGradeUI.setState3(false);
			checkGradeUI.setState4(false);
			checkGradeUI.setState5(false);
			checkGradeUI.setState6(false);
		}

		else {
			IStudent s = StudentManager.get().getStudent(id);

			IStudentUnitRecord r = s.getUnitRecord(currentUnitCode);

			checkGradeUI.setRecord(r);
			checkGradeUI.setState3(true);
			checkGradeUI.setState4(true);
			checkGradeUI.setState5(false);
			checkGradeUI.setState6(false);
			changed = false;

		}
	}

	public String checkGrade(float assignmentMarks, float practicleMarks, float examMarks) {
		IUnit unit = UnitManager.unitMap().getUnit(currentUnitCode);
		String grade = unit.getGrade(assignmentMarks, practicleMarks, examMarks);
		checkGradeUI.setState4(true);
		checkGradeUI.setState5(false);
		if (changed) {
			checkGradeUI.setState6(true);
		}
		return grade;
	}

	public void enableChangeMarks() {
		checkGradeUI.setState4(false);
		checkGradeUI.setState6(false);
		checkGradeUI.setState5(true);
		changed = true;
	}

	public void saveGrade(float assignmentMarks, float practicleMarks, float examMarks) {

		IUnit u = UnitManager.unitMap().getUnit(currentUnitCode);
		IStudent s = StudentManager.get().getStudent(currentStudentID);

		IStudentUnitRecord studentUnitRecord = s.getUnitRecord(currentUnitCode);
		studentUnitRecord.setAsg1(assignmentMarks);
		studentUnitRecord.setAsg2(practicleMarks);
		studentUnitRecord.setExam(examMarks);
		StudentUnitRecordManager.instance().saveRecord(studentUnitRecord);
		checkGradeUI.setState4(true);
		checkGradeUI.setState5(false);
		checkGradeUI.setState6(false);
	}
}
