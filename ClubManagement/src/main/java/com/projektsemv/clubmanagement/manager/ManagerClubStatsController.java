package com.projektsemv.clubmanagement.manager;

import com.projektsemv.clubmanagement.ChangeController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

import static com.projektsemv.clubmanagement.ChartsCreator.*;
import static com.projektsemv.clubmanagement.UserInfo.UserType.*;

public class ManagerClubStatsController implements Initializable {
    @FXML
    private Button buttonOption1, buttonOption2, buttonOption3, buttonOptions, buttonLogOut;
    @FXML
    private Button attendanceStatsButton, resultsStatsButton;
    @FXML
    private Label username, statsInfoLabel, statsInfoData, mainStatsLabel;
    @FXML
    private BarChart barChart;
    @FXML
    private PieChart resultStatsChart;
    @FXML
    private LineChart resultStatsChartLine,attendanceStatsChartLine;
    @FXML
    private StackPane stackPaneStats;
    @FXML
    private TableView financeTable;

    @Override
    public void initialize (URL url, ResourceBundle resourceBundle){
        resultStatsChart.setData(resultStatsChartData());
        resultStatsChart.setLegendVisible(false);

        resultStatsChartLine.setData(resultStatsChartLineData());

        attendanceStatsChartLine.setData(attendanceStatsChartData());

        resultStatsChart.setVisible(true);
        resultStatsChartLine.setVisible(false);
        attendanceStatsChartLine.setVisible(false);

        buttonLogOut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ChangeController.changeScene(actionEvent, "login-panel.fxml", "Panel logowania", MANAGER);
            }
        });
        buttonOption1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ChangeController.changeScene(actionEvent, "manager-club-page.fxml", "Strona klubu", MANAGER);
            }
        });
        buttonOption2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ChangeController.changeScene(actionEvent, "manager-list-of-users.fxml", "Lista użytkowników", MANAGER);
            }
        });

        buttonOption3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ChangeController.changeScene(actionEvent, "manager-messages-panel.fxml", "Wiadomości", MANAGER);
            }
        });
        resultsStatsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(attendanceStatsChartLine.isVisible()){
                    attendanceStatsChartLine.setVisible(false);
                    resultStatsChart.setVisible(true);
                }else if(resultStatsChart.isVisible()){
                    resultStatsChartLine.setVisible(true);
                    resultStatsChart.setVisible(false);
                }else if(resultStatsChartLine.isVisible()){
                    resultStatsChartLine.setVisible(false);
                    resultStatsChart.setVisible(true);
                }
            }
        });
        attendanceStatsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                resultStatsChartLine.setVisible(false);
                resultStatsChart.setVisible(false);
                attendanceStatsChartLine.setVisible(true);

            }
        });
    }
}
