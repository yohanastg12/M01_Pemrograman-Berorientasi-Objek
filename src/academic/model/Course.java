package academic.model;
//12S22022 - GRACE ARINTYA SIAHAAN
//12S22050 - YOHANA SITANGGANG
import java.util.List;

public class Course {
    private String code;
    private String name;
    private int credit;
    private String passingGrade;
    private List<String> lecturers;
//construct
    public Course(String code, String name, int credit, String passingGrade, List<String> lecturers) {
        this.code = code;
        this.name = name;
        this.credit = credit;
        this.passingGrade = passingGrade;
        this.lecturers = lecturers;
    }
//membuat setter getter nya
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
    }
    

    public String getPassingGrade() {
        return passingGrade;
    }

    public List<String> getLecturers() {
        return lecturers;
    }

    @Override
    public String toString() {
        StringBuilder lecturerString = new StringBuilder();
        for (String lecturer : lecturers) {
            lecturerString.append(lecturer).append(";");
        }
        return code + "|" + name + "|" + credit + "|" + passingGrade + "|" + lecturerString.toString().replaceAll(";$", "");
    }
}
