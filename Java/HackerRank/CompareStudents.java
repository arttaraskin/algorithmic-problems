import java.util.*;

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

public class CompareStudents {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        //final Comparator<Student> compCgpa = (s1, s2) -> Double.compare(s1.getCgpa(), s2.getCgpa());
        studentList.sort(Comparator.comparingDouble(Student::getCgpa).reversed()
            .thenComparing(Comparator.comparing(Student::getFname))
            .thenComparing(Comparator.comparingInt(Student::getId)));

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
