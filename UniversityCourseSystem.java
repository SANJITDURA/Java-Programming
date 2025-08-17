abstract class Course {
    private String courseCode;
    private int credits;
    public Course(String courseCode, int credits) {
        if (courseCode == null || courseCode.isEmpty()) {
            throw new IllegalArgumentException("Course code cannot be null or empty");
        }
        if (credits <= 0) {
            throw new IllegalArgumentException("Credits must be greater than zero");
        }
        this.courseCode = courseCode;
        this.credits = credits;
    }
    public String getCourseCode() {
        return courseCode;
    }

    public int getCredits() {
        return credits;
    }
    public abstract int calculateWorkload();
}
class TheoryCourse extends Course {
    private int hoursPerWeek;

    public TheoryCourse(String courseCode, int credits, int hoursPerWeek) {
        super(courseCode, credits);
        if (hoursPerWeek <= 0) {
            throw new IllegalArgumentException("Hours per week must be greater than zero");
        }
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public int calculateWorkload() {
        return getCredits() * hoursPerWeek;
    }
}
class LabCourse extends Course {
    private int labHours;

    public LabCourse(String courseCode, int credits, int labHours) {
        super(courseCode, credits);
        if (labHours <= 0) {
            throw new IllegalArgumentException("Lab hours must be greater than zero");
        }
        this.labHours = labHours;
    }

    @Override
    public int calculateWorkload() {
        return getCredits() * labHours;
    }
}
public class UniversityCourseSystem {
    public static void main(String[] args) {
        Course[] courses = {
            new TheoryCourse("CS101", 3, 2),
            new LabCourse("CS102", 4, 3)
        };
        for (Course course : courses) {
            System.out.println("Course Code: " + course.getCourseCode() + 
                               ", Credits: " + course.getCredits() + 
                               ", Workload: " + course.calculateWorkload());
        }
    }
}
