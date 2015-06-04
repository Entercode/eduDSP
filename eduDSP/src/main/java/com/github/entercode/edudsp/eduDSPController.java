/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.entercode.edudsp.controller;

import java.net.URL;
import java.util.ResourceBundle;
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
	public Canvas fx_canvas_blockdiagram;
	
	public GraphicsContext gc;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// something
		System.out.println("hoge");
		fx_label_status.setText("loaded");
		gc = fx_canvas_blockdiagram.getGraphicsContext2D();
		
		draw(gc);
	}
	
	public void draw(GraphicsContext gc) {
//		gc.drawImage(new Image(getClass().getResource("/yahagi.png").getPath()), 100, 100);
		//gc.drawImage(new Image("/Users/entercode/Git/eduDSP/eduDSP/build/resources/main/yahagi.png"), 100, 100);
		gc.drawImage(new Image("/image/yahagi.png"), 100, 100);
	}
}
