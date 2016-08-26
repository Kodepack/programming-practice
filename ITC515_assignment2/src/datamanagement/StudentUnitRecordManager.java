package datamanagement;

import java.util.List;
import org.jdom.*;

/**
 * @author andre
 *
 */
public class StudentUnitRecordManager {

	private static StudentUnitRecordManager studentUnitRecordManager_ = null;
	private StudentUnitRecordMap recordMap_;
	private java.util.HashMap<String, StudentUnitRecordList> unitRecordString_;
	private java.util.HashMap<Integer, StudentUnitRecordList> unitRecirdInt_;

	public static StudentUnitRecordManager instance() {
		if (studentUnitRecordManager_ == null)
			studentUnitRecordManager_ = new StudentUnitRecordManager();
		return studentUnitRecordManager_;
	}

	private StudentUnitRecordManager() {
		recordMap_ = new StudentUnitRecordMap();
		unitRecordString_ = new java.util.HashMap<>();
		unitRecirdInt_ = new java.util.HashMap<>();
	}

	public IStudentUnitRecord getStudentUnitRecord(Integer studentID, String unitCode) {
		IStudentUnitRecord ir = recordMap_.get(studentID.toString() + unitCode);
		return ir != null ? ir : createStudentUnitRecord(studentID, unitCode);
	}

	private IStudentUnitRecord createStudentUnitRecord(Integer unitId, String studentId) {
		IStudentUnitRecord iRecord;
		for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement()
				.getChild("studentUnitRecordTable").getChildren("record")) {
			if (unitId.toString().equals(el.getAttributeValue("sid")) && studentId.equals(el.getAttributeValue("uid"))) {
				iRecord = new StudentUnitRecord(new Integer(el.getAttributeValue("sid")), el.getAttributeValue("uid"),
						new Float(el.getAttributeValue("asg1")).floatValue(),
						new Float(el.getAttributeValue("asg2")).floatValue(),
						new Float(el.getAttributeValue("exam")).floatValue());
				recordMap_.put(iRecord.getStudentID().toString() + iRecord.getUnitCode(), iRecord);
				return iRecord;
			}
		}
		throw new RuntimeException("DBMD: createStudent : student unit record not in file");
	}

	public StudentUnitRecordList getRecordsByUnit(String unitCode) {
		StudentUnitRecordList recs = unitRecordString_.get(unitCode);
		if (recs != null)
			return recs;
		recs = new StudentUnitRecordList();
		for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement()
				.getChild("studentUnitRecordTable").getChildren("record")) {
			if (unitCode.equals(el.getAttributeValue("uid")))
				recs.add(new StudentUnitRecordProxy(new Integer(el.getAttributeValue("sid")),
						el.getAttributeValue("uid")));
		}
		if (recs.size() > 0)
			unitRecordString_.put(unitCode, recs); // be careful - this could be empty
		return recs;
	}

	public StudentUnitRecordList getRecordsByStudent(Integer studentID) {
		StudentUnitRecordList recs = unitRecirdInt_.get(studentID);
		if (recs != null)
			return recs;
		recs = new StudentUnitRecordList();
		for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement()
				.getChild("studentUnitRecordTable").getChildren("record"))
			if (studentID.toString().equals(el.getAttributeValue("sid")))
				recs.add(new StudentUnitRecordProxy(new Integer(el.getAttributeValue("sid")),
						el.getAttributeValue("uid")));
		if (recs.size() > 0)
			unitRecirdInt_.put(studentID, recs); // be careful - this could be empty
		return recs;
	}

	public void saveRecord(IStudentUnitRecord irec) {
		for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement()
				.getChild("studentUnitRecordTable").getChildren("record")) {
			if (irec.getStudentID().toString().equals(el.getAttributeValue("sid"))
					&& irec.getUnitCode().equals(el.getAttributeValue("uid"))) {
				el.setAttribute("asg1", new Float(irec.getAsg1()).toString());

				el.setAttribute("asg2", new Float(irec.getAsg2()).toString());
				el.setAttribute("exam", new Float(irec.getExam()).toString());
				XMLManager.getXML().saveDocument(); // write out the XML file
													// for continuous save
				return;
			}
		}

		throw new RuntimeException("DBMD: saveRecord : no such student record in data");
	}
}
