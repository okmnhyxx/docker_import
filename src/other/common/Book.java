package other.common;

import java.util.List;
import java.util.Map;

/**
 * @author kexia.lu on 2017/10/23.
 */
public class Book {

    private Student[] studentArr;

    private Boolean ok1;

    private boolean ok2;



    private Long id; //0

    private String name;

    private int number; //2

    private List<Integer> randomList;

    List<Student> studentList;

    private Map<String, Student> studentMap; //4


    private Student student; //6

    public Boolean getOk1() {
        return ok1;
    }

    public void setOk1(Boolean ok1) {
        this.ok1 = ok1;
    }

    public boolean isOk2() {
        return ok2;
    }

    public void setOk2(boolean ok2) {
        this.ok2 = ok2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Integer> getRandomList() {
        return randomList;
    }

    public void setRandomList(List<Integer> randomList) {
        this.randomList = randomList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Map<String, Student> getStudentMap() {
        return studentMap;
    }

    public void setStudentMap(Map<String, Student> studentMap) {
        this.studentMap = studentMap;
    }

    public Student[] getStudentArr() {
        return studentArr;
    }

    public void setStudentArr(Student[] studentArr) {
        this.studentArr = studentArr;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
