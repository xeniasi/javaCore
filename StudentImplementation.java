import java.util.List;

public class StudentImplementation implements Student{

    private String name;
    private List<Course> courses;

    public StudentImplementation(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Course> getAllCourses() {
        return courses;
    }
}
