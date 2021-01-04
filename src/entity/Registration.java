package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Registration {
    @Id
    private String registrationId;
    private String registrationDate;
    private double registrationFee;

    @ManyToOne
    @JoinColumn(name = "Student_Id", referencedColumnName = "studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "Course_Code", referencedColumnName = "code")
    private Course course;

    private int batchNo;

    public Registration(String registrationId, String registrationDate, double registrationFee, Student student, Course course, int batchNo) {
        this.setRegistrationId(registrationId);
        this.setRegistrationDate(registrationDate);
        this.setRegistrationFee(registrationFee);
        this.setStudent(student);
        this.setCourse(course);
        this.setBatchNo(batchNo);
    }

    public Registration() {
    }


    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public double getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(double registrationFee) {
        this.registrationFee = registrationFee;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(int batchNo) {
        this.batchNo = batchNo;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "registrationId='" + registrationId + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", registrationFee=" + registrationFee +
                ", student=" + student +
                ", course=" + course +
                ", batchNo=" + batchNo +
                '}';
    }
}
