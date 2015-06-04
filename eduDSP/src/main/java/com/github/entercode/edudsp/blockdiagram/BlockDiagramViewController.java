package com.github.entercode.edudsp.blockdiagram;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author entercode
 */

public class BlockDiagramViewController implements Initializable {
	
	@FXML
	private Button fx_button_block_cursor;
	private Button fx_button_block_select;
	private Button fx_button_block_remove;
	private Button fx_button_block_add;
	private Button fx_button_block_delay;
	private Button fx_button_block_multipy;
	private Button fx_button_block_amplifire;
	
	
	@FXML
	private Canvas fx_canvas_blockdiagramview;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		GraphicsContext gc = fx_canvas_blockdiagramview.getGraphicsContext2D();
		initEventHandler();
				
		BlockDiagramViewAnimator bda = new BlockDiagramViewAnimator(gc);
		//bda.start();
	}
	
	
	
	
	public void initEventHandler() {
		fx_canvas_blockdiagramview.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
			}
		});
	}
	
	public void onAction_button_block_cursor() {
		fx_canvas_blockdiagramview.setCursor(new ImageCursor(new Image("/image/icon/cursor.png", 24, 24, true, true)));
	}
	public void onAction_button_block_select() {
		fx_canvas_blockdiagramview.setCursor(new ImageCursor(new Image("/image/icon/select.png", 24, 24, true, true)));
	}
	public void onAction_button_block_add() {
		fx_canvas_blockdiagramview.setCursor(new ImageCursor(new Image("/block/add/texture.png", 48, 48, true, true)));
	}
	public void onAction_button_block_delay() {
		fx_canvas_blockdiagramview.setCursor(new ImageCursor(new Image("/block/delay/texture.png", 48, 48, true, true)));
	}
	public void onAction_button_block_remove() {
		fx_canvas_blockdiagramview.setCursor(new ImageCursor(new Image("/image/icon/remove.png", 24,  24, true, true)));
	}
	public void onAction_button_block_multiply() {
		fx_canvas_blockdiagramview.setCursor(new ImageCursor(new Image("/block/multiply/texture.png", 48, 48, true, true)));
	}
	public void onAction_button_block_amplifire() {
		fx_canvas_blockdiagramview.setCursor(new ImageCursor(new Image("/block/amplifire/texture.png", 48, 48, true, true)));
	}
	
	
}
