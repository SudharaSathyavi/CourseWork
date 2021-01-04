package controller;

import com.jfoenix.controls.JFXComboBox;
import entity.Student;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.StudentModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DisplayStudentController implements Initializable {
    public JFXComboBox<String> cmbCourse;
    public JFXComboBox<Integer> cmbBatch;
    public TableView<StudentModel> tblStudent;
    public TableColumn<StudentModel, String> colStudentId;
    public TableColumn<StudentModel, String> colStudentName;
    public TableColumn<StudentModel, String> colAddress;
    public TableColumn<StudentModel, String> colContact;
    public TableColumn<StudentModel, String> colDateOfBirth;
    public TableColumn<StudentModel, String> colGender;

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Session session = sessionFactory.openSession();

        List courseCodes = session.createNativeQuery("SELECT code FROM Course").list();
        cmbCourse.getItems().clear();
        cmbCourse.getItems().addAll(courseCodes);

        session.close();

        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colDateOfBirth.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        cmbBatch.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                Session session = sessionFactory.openSession();

                List<String> list = session.createNativeQuery("SELECT Student_Id FROM Registration WHERE " +
                        "Course_Code='" + cmbCourse.getValue() + "' AND batchNo='" + cmbBatch.getValue() + "'").list();


                tblStudent.getItems().clear();

                for (String id : list) {
                    Student student = getStudent(id);
                    tblStudent.getItems().add(new StudentModel(
                            student.getStudentId(),
                            student.getStudentName(),
                            student.getAddress(),
                            student.getContact(),
                            student.getDateOfBirth(),
                            student.getGender()
                    ));
                }


                session.close();
            }
        });

        cmbCourse.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Session session = sessionFactory.openSession();

                List batches = session.createNativeQuery("SELECT DISTINCT batchNo FROM Registration WHERE " +
                        "Course_Code='" + cmbCourse.getValue() + "'").list();

                tblStudent.getItems().clear();
                cmbBatch.getItems().clear();
                cmbBatch.getItems().addAll(batches);


                session.close();
            }
        });



    }

    private Student getStudent(String studentId) {
        Session session = sessionFactory.openSession();
        Student student = session.get(Student.class, studentId);

        session.close();
        return student;
    }
}
