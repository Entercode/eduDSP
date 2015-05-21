package com.github.entercode.edudsp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class eduDSP extends Application {
	
    public static void main(String[] args) {
		launch(args);
		System.out.println("helloworld");
		
    }

	@Override
	public void start(Stage stage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("/eduDSP.fxml"));
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        stage.show();
		
		Thread.sleep(3000);
		
		//fx_label_status.setText("Loaded");
	}
}
