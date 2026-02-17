import java.util.*;

enum Event {
    ENTER,
    SERVED
}

class Student /*implements Comparable<Student>*/ {
    private int id;
    private String name;
    private double cgpa;
    
    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    
    // @Override
    // public int compareTo(Student other) {
    //     return Comparator.comparingDouble(Student::getCGPA).reversed()
    //           .thenComparing(Student::getName)
    //           .thenComparingInt(Student::getID)
    //           .compare(this, other);
    // }
    
    public int getID() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getCGPA() {
        return cgpa;
    }
}

class StudentPriorities {
    public List<Student> getStudents(List<String> events) {
        Queue<Student> students = new PriorityQueue<>(
            Comparator.comparingDouble(Student::getCGPA).reversed()
              .thenComparing(Student::getName)
              .thenComparingInt(Student::getID));
        for (String event : events) {
            String[] data = event.split(" ");
            if (Event.ENTER.name().equals(data[0])) {
                students.add(new Student(Integer.parseInt(data[3]), data[1], Double.parseDouble(data[2])));
            } else if (Event.SERVED.name().equals(data[0])) {
                students.poll();
            }
        }
        
        List<Student> result = new ArrayList<>(students.size());
        while (!students.isEmpty()) {
            result.add(students.poll());
        }
        return result;
    }
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}