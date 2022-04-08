import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Student> studentsList = createStudentsList();

        System.out.println("Список уникальных курсов, на которые подписаны студенты:");
        var courses = getCourseList(studentsList);
        courses.stream().map(c->c.getCourseName()).forEach(System.out::println);
        System.out.println();

        System.out.println("Три самых любознательных студента:");
        var std = get3Students(studentsList);
        std.stream().map(s->s.getName()).forEach(System.out::println);
        System.out.println();

        System.out.println("Список студентов, которые посещают курс " + PHILOSOPHY);
        var stdCourse = getStdCourse(studentsList,PHILOSOPHY);
        stdCourse.stream().map(s->s.getName()).forEach(System.out::println);
        System.out.println();
    }

    private static List<Course> getCourseList(List<Student> students) {
        return new ArrayList<>(
                students.stream()
                        .map(s -> new HashSet<>(s.getAllCourses()))
                        .reduce((courses1, courses2) -> {
                            HashSet<Course> list = new HashSet<>(courses1);
                            list.addAll(courses2);
                            return list;
                        }).get()
        );
    }

    private  static List<Student> get3Students(List<Student> students){
        return students.stream()
                .sorted(Comparator.comparingInt(o -> -o.getAllCourses().size()))
                .limit(3)
                .toList();
    }

    private static List<Student> getStdCourse(List<Student> students, Course course){
        return
                students.stream()
                        .filter(s->s.getAllCourses().contains(course))
                        .toList();

    }

    public static final Course RUSSIAN = new CourseImplementation("Русский язык");
    public static final Course ENGLISH = new CourseImplementation("Английский язык");
    public static final Course LITERATURE = new CourseImplementation("Литература");
    public static final Course MATH = new CourseImplementation("Математика");
    public static final Course CHEMISTRY = new CourseImplementation("Химия");
    public static final Course PHYSICS = new CourseImplementation("Физика");
    public static final Course HISTORY = new CourseImplementation("История");
    public static final Course PHILOSOPHY = new CourseImplementation("Философия");
    public static final Course PSYCHOLOGY = new CourseImplementation("Психология");
    public static final Course DRAWING = new CourseImplementation("Черчение");

    public static List<Student> createStudentsList(){
        return new ArrayList<Student>(Arrays.asList(
                new StudentImplementation("Анастасия Петрова", new ArrayList<>(Arrays.asList(RUSSIAN, ENGLISH, LITERATURE)) ),
                new StudentImplementation("Елена Иванова",new ArrayList<>(Arrays.asList(RUSSIAN, MATH, HISTORY, PHILOSOPHY))),
                new StudentImplementation("Александр Сидоров",new ArrayList<>(Arrays.asList(ENGLISH, MATH, CHEMISTRY, PHYSICS, HISTORY, PHILOSOPHY))),
                new StudentImplementation("Петр Миронов",new ArrayList<>(Arrays.asList(RUSSIAN, MATH, CHEMISTRY, HISTORY, PHILOSOPHY))),
                new StudentImplementation("Олег Михайлов",new ArrayList<>(Arrays.asList(ENGLISH, HISTORY, CHEMISTRY))),
                new StudentImplementation("Екатерина Васильева",new ArrayList<>(Arrays.asList(ENGLISH, LITERATURE))),
                new StudentImplementation("Мария Завьялова",new ArrayList<>(Arrays.asList(RUSSIAN, ENGLISH, LITERATURE, MATH, CHEMISTRY, PHYSICS, PHILOSOPHY)))
        )
        );
    }

}
