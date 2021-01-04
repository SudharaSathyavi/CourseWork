package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {

    @Id
    private String code;
    private String courseName;
    private int duration;
    private double courseFee;

    @OneToMany(mappedBy = "course")
    private List<Registration> registrationList;

    public Course(String code, String courseName, int duration, double courseFee) {
        this.code = code;
        this.courseName = courseName;
        this.duration = duration;
        this.courseFee = courseFee;
        registrationList = new ArrayList<>();
    }

    public Course() {
        registrationList = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(double courseFee) {
        this.courseFee = courseFee;
    }

    public List<Registration> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<Registration> registrationList) {
        this.registrationList = registrationList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "code='" + code + '\'' +
                ", courseName='" + courseName + '\'' +
                ", duration=" + duration +
                ", courseFee=" + courseFee +
                ", registrationList=" + registrationList +
                '}';
    }
}
