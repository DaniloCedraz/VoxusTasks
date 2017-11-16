package br.com.voxus.ui;

import br.com.voxus.model.Task;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    TableView<Task> table;
    TextField nameInput, descInput, priorityInput;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Tasks Voxus");

        //Name column
        TableColumn<Task, String> nameColumn = new TableColumn<>("Nome");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));

        //Price column
        TableColumn<Task, Double> descColumn = new TableColumn<>("Descricao");
        descColumn.setMinWidth(100);
        descColumn.setCellValueFactory(new PropertyValueFactory<>("descricao"));

        //Quantity column
        TableColumn<Task, String> priorityColumn = new TableColumn<>("Prioridade");
        priorityColumn.setMinWidth(100);
        priorityColumn.setCellValueFactory(new PropertyValueFactory<>("prioridade"));

        //Name input
        nameInput = new TextField();
        nameInput.setPromptText("Nome");
        nameInput.setMinWidth(100);

        //Description input
        descInput = new TextField();
        descInput.setPromptText("Descricao");
        descInput.setMinWidth(100);
        //Priority input
        priorityInput = new TextField();
        priorityInput.setPromptText("Prioridade");

        //Button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, descInput, priorityInput, addButton, deleteButton);

        table = new TableView<>();
        table.setItems(getTask());
        table.getColumns().addAll(nameColumn, descColumn, priorityColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    //Add button clicked
    public void addButtonClicked(){
        Task Task = new Task();
        Task.setNome(nameInput.getText());
        Task.setDescricao(descInput.getText());
        Task.setPrioridade(Integer.parseInt(priorityInput.getText()));
        table.getItems().add(Task);
        nameInput.clear();
        descInput.clear();
        priorityInput.clear();
    }

    //Delete button clicked
    public void deleteButtonClicked(){
        ObservableList<Task> TaskSelected, allTasks;
        allTasks = table.getItems();
        TaskSelected = table.getSelectionModel().getSelectedItems();
        TaskSelected.forEach(allTasks::remove);
    }

    //Get all of the Tasks
    public ObservableList<Task> getTask(){
        ObservableList<Task> Tasks = FXCollections.observableArrayList();
     //  Tasks.add(new Task());
        return Tasks;
    }


}