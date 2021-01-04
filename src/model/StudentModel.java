package model;

public class StudentModel {
    private String studentId;
    private String studentName;
    private String address;
    private String contact;
    private String dateOfBirth;
    private String gender;

    public StudentModel(String studentId, String studentName, String address, String contact, String dateOfBirth, String gender) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.address = address;
        this.contact = contact;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public StudentModel() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
