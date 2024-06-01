import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.File;

public class Main extends Application {
    
    private TextField directoryPathField;
    private TextField searchField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("File Browser and Search");

        // Initialize directoryPathField
        directoryPathField = new TextField();
        directoryPathField.setPromptText("Enter directory path");

        // Initialize searchField
        searchField = new TextField();
        searchField.setPromptText("Enter search phrase");

        // Initialize browseButton
        Button browseButton = new Button("Browse");
        browseButton.setOnAction(e -> browseDirectory());

        // Initialize searchButton
        Button searchButton = new Button("Search");

        // Initialize HBox and VBox
        HBox hBox = new HBox(10, directoryPathField, browseButton);
        VBox vBox = new VBox(10, hBox, searchField, searchButton);

        // Initialize Scene
        Scene scene = new Scene(vBox, 600, 200);

        // Set scene and show stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void browseDirectory() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(null);

        if (selectedDirectory != null) {
            directoryPathField.setText(selectedDirectory.getAbsolutePath());
        }
    }
}
