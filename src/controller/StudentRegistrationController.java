package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import entity.Course;
import entity.Registration;
import entity.Student;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class StudentRegistrationController implements Initializable {
    public JFXTextField txtStudentId;
    public JFXTextField txtStudentName;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;
    public JFXDatePicker txtDateofBirth;
    public JFXComboBox<String> cmbGender;
    public JFXTextField txtRegistrationid;
    public JFXTextField txtRegistrationFee;
    public JFXComboBox<String> cmbCourse;
    public JFXTextField txtBatch;
    public JFXButton btnRegister;

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmbGender.getItems().addAll("Male", "Female");

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List courseCodes = session.createNativeQuery("SELECT code FROM Course").list();
        cmbCourse.getItems().clear();
        cmbCourse.getItems().addAll(courseCodes);

        session.close();
    }

    public void btnRegisterOnAction(ActionEvent actionEvent) {

        Student student = new Student(
                txtStudentId.getText(),
                txtStudentName.getText(),
                txtAddress.getText(),
                txtContact.getText(),
                DateTimeFormatter.ofPattern("YYYY-MM-dd").format(txtDateofBirth.getValue()),
                cmbGender.getValue()
        );

        Course course = getCourse(cmbCourse.getValue());

        Registration registration = new Registration(
                txtRegistrationid.getText(),
                new SimpleDateFormat("YYYY-MM-dd").format(new Date()),
                Double.parseDouble(txtRegistrationFee.getText()),
                student,
                course,
                Integer.parseInt(txtBatch.getText())
        );

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.saveOrUpdate(student);
        session.save(registration);

        session.getTransaction().commit();
        session.close();
    }

    private Course getCourse(String courseCode) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Course course = session.get(Course.class, courseCode);

        session.close();
        return course;
    }


}
