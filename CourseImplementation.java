public class CourseImplementation implements Course{

    private String courseName;

    public CourseImplementation(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String getCourseName() {
        return courseName;
    }

    @Override
    public String toString() {
        return courseName;
    }
}
