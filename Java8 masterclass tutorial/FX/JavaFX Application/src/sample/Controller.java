package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class Controller {

    @FXML
    private Label label;

    @FXML
    private Button button4;

    @FXML
    private GridPane gridPane;

    @FXML
    private WebView webView;

    public void initialize() {
        button4.setEffect(new DropShadow());
    }

    @FXML
    public void handleMouseEnter() {
        label.setScaleX(2.0);
        label.setScaleY(2.0);
    }

    @FXML
    public void handleMouseExit() {
        label.setScaleX(1.0);
        label.setScaleY(1.0);
    }

    @FXML
    public void handleClick() {
        FileChooser chooser = new FileChooser();                                        //Choosing a file

        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Zip", "*.zip"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );

        //File file = chooser.showOpenDialog(gridPane.getScene().getWindow());
        File file = chooser.showSaveDialog(gridPane.getScene().getWindow());
        //DirectoryChooser chooser = new DirectoryChooser();                            //Choosing a directory/ folder
        //File file = chooser.showDialog(gridPane.getScene().getWindow());              //MAKE THE DIALOG A MODAL WINDOW SO WE CANNOT OPEN ANOTHER WINDOW OR INTERACT WITH OTHER WINDOWS WHILE ITS OPEN
        if(file != null) {
            System.out.println(file.getPath());
        } else {
            System.out.println("Chooser was cancelled");
        }

        /*
        //FOR SELECTING MULTIPLE FILES TO OPEN/SAVE etc AT ONCE
        List<File> file = chooser.showOpenMultipleDialog(gridPane.getScene().getWindow());
        if(file != null) {
            for(int i=0; i<file.size(); i++) {
                System.out.println(file.get(i));
            }
        } else {
            System.out.println("Chooser was cancelled");
        }*/
    }

    @FXML
    public void handleLinkClick() {

        //OPENS THE LINK TO THE OSs NATIVE BROWSER
        /*try {
            Desktop.getDesktop().browse(new URI("http://www.javafx.com"));
        } catch(IOException e) {
            e.printStackTrace();
        } catch(URISyntaxException e) {
            e.printStackTrace();
        }*/

        //OPENS THE LINK TO A WEBVIEW INSIDE OUR JAVA APP
        WebEngine engine = webView.getEngine();
        engine.load("http://www.javafx.com");
    }

}
