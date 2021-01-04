package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entity.Course;
import javafx.event.ActionEvent;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import util.HibernateUtil;

public class AddCourseController {
    public JFXTextField txtCourseCode;
    public JFXTextField txtCourseName;
    public JFXTextField txtDuration;
    public JFXTextField txtCourseFee;
    public JFXButton btnAddCourse;
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void btnAddCourseOnAction(ActionEvent actionEvent) {


        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(new Course(
                txtCourseCode.getText(),
                txtCourseName.getText(),
                Integer.parseInt(txtDuration.getText()),
                Double.parseDouble(txtCourseFee.getText())
        ));

        session.getTransaction().commit();
        session.close();

    }
}
