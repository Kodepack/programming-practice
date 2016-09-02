package datamanagement;
public class StudentUnitRecordProxy implements IStudentUnitRecord {
private Integer studentID;
private String unitCode;
private StudentUnitRecordManager mngr;
public StudentUnitRecordProxy( Integer id, String code ) 
{
this.studentID = id;this.unitCode = code;
this.mngr = StudentUnitRecordManager.instance();}
public Integer getStudentId() { return studentID;}
public String getUnitCode() { return unitCode; 
}
public void setAssignment1Marks(float mark) {
mngr.getStudentUnitRecord( studentID, unitCode ).setAssignment1Marks(mark);}
public float getAssignment1Marks() 
{
return mngr.getStudentUnitRecord( studentID, unitCode ).getAssignment1Marks();}
public void setAssignment2Marks(float mark) { mngr.getStudentUnitRecord( studentID, unitCode ).setAssignment2Marks(mark);}
public float getAssignment2Marks() {return mngr.getStudentUnitRecord( studentID, unitCode ).getAssignment2Marks();
}
public void setExamMarks(float mark) {mngr.getStudentUnitRecord( studentID, unitCode ).setExamMarks(mark);
}
public float getExamMarks() 
{
return mngr.getStudentUnitRecord( studentID, unitCode ).getExamMarks();}
public float getTotalMarks() {return mngr.getStudentUnitRecord( studentID, unitCode ).getTotalMarks();}}
