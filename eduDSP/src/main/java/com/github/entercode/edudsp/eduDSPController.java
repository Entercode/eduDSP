/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.entercode.edudsp;

import com.github.entercode.edudsp.blockdiagram.BlockDiagramViewController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

/**
 *
 * @author entercode
 */
public class eduDSPController implements Initializable {

	@FXML
	private Label fx_label_status;
	
	@FXML
	private BlockDiagramViewController bdvc;
	
	@FXML
	private Canvas fx_canvas_deb;
	
	public GraphicsContext gc;
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// something
		
		fx_label_status.setText("loaded");
		
		
	}
}

