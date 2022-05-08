package university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }
    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }
    public int getStudentCount(){
        return students.size();
    }
    public String registerStudent(Student student){
        if(students.size() == capacity){
            return "No seats in the university";
        }
        if(students.contains(student)){
            return "Student is already in the university";
        }
        students.add(student);
        return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
    }
    public String dismissStudent(Student student){
        if(students.contains(student)){
            students.remove(student);
            return "";
        }
        return "Student not found";
    }

    public Student getStudent(String firstName, String lastName){
        return students.stream().filter(s->s.getFirstName().equals(firstName) &&
                s.getLastName().equals(lastName)).findFirst().orElse(null);
    }

   public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<students.size(); i++){
            sb.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s",
                    students.get(i).getFirstName(), students.get(i).getLastName(), students.get(i).getBestSubject()));
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
   }
}
