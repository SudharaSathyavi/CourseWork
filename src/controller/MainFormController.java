package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {
    public JFXButton btnAddCourse;
    public JFXButton btnRegistration;
    public JFXButton btnStudentDetail;
    public AnchorPane rootPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnAddCourse.fire();
    }

    public void btnAddCourseOnAction(ActionEvent actionEvent) {
        try {
            Parent load = FXMLLoader.load(getClass().getResource("../view/AddCourse.fxml"));
            rootPane.getChildren().clear();
            rootPane.getChildren().add(load);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnRegistrationOnAction(ActionEvent actionEvent) {
        try {
            Parent load = FXMLLoader.load(getClass().getResource("/view/StudentRegistration.fxml"));
            rootPane.getChildren().clear();
            rootPane.getChildren().add(load);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnStudentDetailOnAction(ActionEvent actionEvent) {
        try {
            Parent load = FXMLLoader.load(getClass().getResource("/view/DisplayStudent.fxml"));
            rootPane.getChildren().clear();
            rootPane.getChildren().add(load);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
