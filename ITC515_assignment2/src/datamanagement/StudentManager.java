package datamanagement;

import java.util.List;
import org.jdom.Element; // changed to explicit import for org.jdom **


public class StudentManager {
	private static StudentManager studentManager_ = null; // variable forming class itself
	
	private StudentMap studentMap_; // class StudentMap separate class File
	private java.util.HashMap<String, StudentMap> unitMap_;

	public static StudentManager get() {
		if (studentManager_ == null){

			studentManager_ = new StudentManager();
		}
		return studentManager_;
	}

	private StudentManager() {

		studentMap_ = new StudentMap();
		unitMap_ = new java.util.HashMap<>();
	}

	public IStudent getStudent(Integer id) {
		IStudent is = studentMap_.get(id);
		return is != null ? is : createStudent(id);
	}

	private Element getStudentElement(Integer id) {
		for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentTable")
			 .getChildren("student"))
			
			if (id.toString().equals(el.getAttributeValue("sid"))){
				
				return el;
			}
		return null;
	}

	private IStudent createStudent(Integer id) {
		IStudent is;
		Element element = getStudentElement(id);
		if (element != null) {
			StudentUnitRecordList rlist = StudentUnitRecordManager.instance().getRecordsByStudent(id);
			is = new Student(new Integer(element.getAttributeValue("sid")), element.getAttributeValue("fname"),
					element.getAttributeValue("lname"), rlist);

			studentMap_.put(is.getId(), is);
			return is;
		}
		throw new RuntimeException("DBMD: createStudent : student not in file");
	}

	private IStudent createStudentProxy(Integer id) {
		Element element = getStudentElement(id);

		if (element != null)
			return new StudentProxy(id, element.getAttributeValue("fname"), element.getAttributeValue("lname"));
		throw new RuntimeException("DBMD: createStudent : student not in file");
	}

	public StudentMap getStudentsByUnit(String uc) {
		StudentMap studentMap = unitMap_.get(uc);
		if (studentMap != null) {

			return studentMap;
		}

		studentMap = new StudentMap();
		IStudent iStudent;
		StudentUnitRecordList ur = StudentUnitRecordManager.instance().getRecordsByUnit(uc);
		for (IStudentUnitRecord S : ur) {

			iStudent = createStudentProxy(new Integer(S.getStudentID()));
			studentMap.put(iStudent.getId(), iStudent);
		}
		unitMap_.put(uc, studentMap);
		return studentMap;
	}
}

