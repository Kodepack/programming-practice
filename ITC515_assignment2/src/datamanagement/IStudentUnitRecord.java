package datamanagement;

public interface IStudentUnitRecord {

	/**
	 * studentId getter
	 * @return studentId
	 */
    public Integer getStudentId();
    
    /**
     * unitCode getter
     * @return unitCode
     */
    public String getUnitCode();

    /**
     * assignment1Marks setter
     * @param marks
     */
    public void setAssignment1Marks(float marks);
    
    /**
     * Assignment 1 marks getter
     * @return assignment1marks
     */
    public float getAssignment1Marks();

    /**
     * Assignment  2marks setter
     * @param marks
     */
    public void setAssignment2Marks(float marks);
    
    
    /**
     * Assignment 2 marks getter
     * @return marks
     */
    public float getAssignment2Marks();

    
    /**
     * Exam marks setter
     * @param marks
     */
    public void setExamMarks(float marks);
    
    /**
     * Exam marks getter
     * @return marks
     */
    public float getExamMarks();

    /**
     * Total marks getter
     * @return marks
     */
    public float getTotalMarks();
}
