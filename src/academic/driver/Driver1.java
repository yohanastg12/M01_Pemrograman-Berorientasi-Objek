// package academic.driver;
// //12S22022 - GRACE ARINTYA SIAHAAN
// //12S22050 - YOHANA SITANGGANG
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// import academic.model.Course;
// import academic.model.Enrollment;
// import academic.model.Student;
// import academic.model.Lecturer;

// public class Driver1 {

//     final static Scanner scanner = new Scanner(System.in);

//     public static void main(String[] _args) {
//         List<Course> courses = new ArrayList<>();
//         List<Student> students = new ArrayList<>();
//         List<Enrollment> enrollments = new ArrayList<>();
//         List<String> inputList = new ArrayList<>();
//         List<Lecturer> lecturers = new ArrayList<>();

//         do {
//             String input = scanner.nextLine();
//             if (input.equals("---")) {
//                 break;
//             }
//             inputList.add(input);
//         } while (true);

//         for (String input : inputList) {
//             String[] command = input.split("#");

//             switch (command[0]) {
//                 case "lecturer-add":
//                     if (command.length == 6) {
//                         Lecturer lecturer = new Lecturer(command[1], command[2], command[3], command[4], command[5]);
//                         if (!isDuplicateLecturer(lecturer, lecturers)) {
//                             lecturers.add(lecturer);
//                         }
//                     }
//                     break;
//                 case "course-add":
//                     if (command.length >= 6) {
//                         String[] lecturerInitials = command[5].split(",");
//                         List<Lecturer> courseLecturers = new ArrayList<>();
//                         List<String> lecturerNames = new ArrayList<>();
//                         for (String lecturerInitial : lecturerInitials) {
//                             for (Lecturer lecturer : lecturers) {
//                                 if (lecturer.getInitial().equals(lecturerInitial)) {
//                                     courseLecturers.add(lecturer);
//                                     lecturerNames.add(lecturer.getInitial() + " (" + lecturer.getEmail() + ")");
//                                     break;
//                                 }
//                             }
//                         }

//                         Course course = new Course(command[1], command[2], Integer.parseInt(command[3]), command[4], lecturerNames);
//                         if (!isDuplicateCourse(course, courses)) {
//                             courses.add(course);
//                         }
//                     }
//                     break;
//                 case "student-add":
//                     if (command.length == 5) {
//                         Student student = new Student(command[1], command[2], command[3], command[4]);
//                         if (!isDuplicateStudent(student, students)) {
//                             students.add(student);
//                         }
//                     }
//                     break;
//                 case "enrollment-add":
//                     if (command.length == 5) {
//                         Enrollment enrollment = new Enrollment(command[1], command[2], command[3], command[4]);
//                         if (!enrollments.contains(enrollment)) {
//                             enrollments.add(enrollment);
//                         }
//                     }
//                     break;
//                 case "enrollment-grade":
//                     if (command.length == 6) {
//                         String courseCode = command[1];
//                         String studentId = command[2];
//                         String academicYear = command[3];
//                         String semester = command[4];
//                         String grade = command[5];
                        
//                         // Cari Enrollment yang sesuai
//                         Enrollment targetEnrollment = findEnrollment(courseCode, studentId, academicYear, semester, enrollments);
                        
//                         // Jika ditemukan, set nilai grade
//                         if (targetEnrollment != null) {
//                             targetEnrollment.setGrade(grade);
//                         }
//                     }
//                     break;
//                 case "student-details":
//     if (command.length == 2) {
//         String studentId = command[1];
//         Student student = findStudentById(studentId, students);
//         if (student != null) {
//             List<Enrollment> studentEnrollments = findEnrollmentsById(studentId, enrollments);
//             double gpa = student.calculateGPA(studentEnrollments);
//             System.out.println(student.getId() + "|" + student.getName() + "|" + student.getYear() + "|" + student.getStudyProgram() + "|" + String.format("%.2f", gpa) + "|" + studentEnrollments.size());
//         }
//     }
//     break;

//                 default:
//                     break;
//             }
//         }

//         for (Lecturer lecturer : lecturers) {
//             System.out.println(lecturer);
//         }

//         for (Course course : courses) {
//             System.out.println(course);
//         }

//         for (Student student : students) {
//             System.out.println(student);
//         }

//         for (Enrollment enrollment : enrollments) {
//             System.out.println(enrollment);
//         }
//     }

//     private static boolean isDuplicateCourse(Course course, List<Course> courses) {
//         return courses.stream().anyMatch(c -> c.getCode().equals(course.getCode()));
//     }

//     private static boolean isDuplicateStudent(Student student, List<Student> students) {
//         return students.stream().anyMatch(s -> s.getId().equals(student.getId()));
//     }

//     private static boolean isDuplicateLecturer(Lecturer lecturer, List<Lecturer> lecturers) {
//         return lecturers.stream().anyMatch(e -> e.getName().equals(lecturer.getName()));
//     }

//     private static Enrollment findEnrollment(String courseCode, String studentId, String academicYear, String semester, List<Enrollment> enrollments) {
//         for (Enrollment enrollment : enrollments) {
//             if (enrollment.getCode().equals(courseCode) && 
//                 enrollment.getId().equals(studentId) &&
//                 enrollment.getAcademicYear().equals(academicYear) &&
//                 enrollment.getSemester().equals(semester)) {
//                 return enrollment;
//             }
//         }

// public double calculateGPA(List<Enrollment> enrollments) {
//     double totalGPA = 0;
//     int totalCredit = 0;
//     for (Enrollment enrollment : enrollments) {
//         if (enrollment.getId().equals(this.id)) {
//             Course course = findCourse(enrollment.getCode(), courses);
//             if (course != null) {
//                 String grade = enrollment.getGrade();
//                 if (grade.equals("A")) {
//                     totalGPA += 4.0 * course.getCredit();
//                 } else if (grade.equals("AB")) {
//                     totalGPA += 3.5 * course.getCredit();
//                 } else if (grade.equals("B")) {
//                     totalGPA += 3.0 * course.getCredit();
//                 } else if (grade.equals("BC")) {
//                     totalGPA += 2.5 * course.getCredit();
//                 } else if (grade.equals("C")) {
//                     totalGPA += 2.0 * course.getCredit();
//                 } else if (grade.equals("D")) {
//                     totalGPA += 1.0 * course.getCredit();
//                 } else if (grade.equals("E")) {
//                     totalGPA += 0.0 * course.getCredit();
//                 }
//                 totalCredit += course.getCredit();
//             }
//         }
//     }
//     return totalGPA / totalCredit;
// }
// // Mengambil nilai dari semua Enrollment yang sesuai dengan id mahasiswa
// private static Enrollment findEnrollment(String courseCode, String studentId, String academicYear, String semester, List<Enrollment> enrollments) {
//     for (Enrollment enrollment : enrollments) {
//         if (enrollment.getCode().equals(courseCode) && 
//             enrollment.getId().equals(studentId) &&
//             enrollment.getAcademicYear().equals(academicYear) &&
//             enrollment.getSemester().equals(semester)) {
//             return enrollment;
//         }
//     }
//     return null; // Add this line if no matching enrollment is found
// }
  