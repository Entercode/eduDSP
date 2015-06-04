package com.github.entercode.edudsp.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

/**
 *
 * @author entercode
 */

public class BlockDiagramViewController implements Initializable {
	
	@FXML
	private Button fx_button_block_add;
	
	@FXML
	private Canvas fx_canvas_blockdiagram;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		GraphicsContext gc = fx_canvas_blockdiagram.getGraphicsContext2D();
		
		draw(gc);
	}
	
	public void draw(GraphicsContext gc) {
		gc.drawImage(new Image("/image/testhd.jpg"), 0, 0);
	}
}
