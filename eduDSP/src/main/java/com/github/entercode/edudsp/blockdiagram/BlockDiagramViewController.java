package com.github.entercode.edudsp.blockdiagram;

import java.awt.Point;
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
	
	private boolean isFuncSelect = false;
	private boolean selecting = false;
	
	private GraphicsContext gc;
	private Point selectS, selectE;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		gc = fx_canvas_blockdiagramview.getGraphicsContext2D();
		
		selectS = new Point(0, 0);
		selectE = new Point(0, 0);
		
		initEventHandler();
		
		BlockDiagramViewAnimator bda = new BlockDiagramViewAnimator(gc);
		//bda.start();
	}
	
	
	
	
	public void initEventHandler() {
		fx_canvas_blockdiagramview.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				selectS.setLocation((int)event.getX(), (int)event.getY());
				System.out.println("pr" + selectS);
				if(isFuncSelect) {
					selecting = true;
					System.out.println("h");
				}
			}
		});
		fx_canvas_blockdiagramview.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				selectE.setLocation((int)event.getX(), (int)event.getY());
				System.out.println("re" + selectE);
				selecting = false;
			}
		});
		fx_canvas_blockdiagramview.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(selecting) {
					int x = 0, y = 0, w, h;
					
					x = (int)event.getX();
					y = (int)event.getY();
					w = x - selectS.x;
					h = y - selectS.y;
					
					// Width
					if(w < 0) w *= -1;
					else x = (int)selectS.x;
					
					// Height
					if(h < 0) h *= -1;
					else y = (int)selectS.y;
					
					
					
					gc.setLineWidth(1.0);
					gc.strokeRect(0.5 + x, 0.5 + y, w, h);
					gc.stroke();
				}
			}
		});
	}
	
	public void onAction_button_block_cursor() {
		fx_canvas_blockdiagramview.setCursor(new ImageCursor(new Image("/image/icon/cursor.png", 24, 24, true, true)));
	}
	public void onAction_button_block_select() {
		fx_canvas_blockdiagramview.setCursor(new ImageCursor(new Image("/image/icon/select.png", 24, 24, true, true)));
		isFuncSelect = true;
	}
	public void onMouseMoved() {
//		System.out.println("md");
//		if(selecting) {
//			System.out.println("m");
//			gc.rect(selectS.x, selectS.y, selectE.x, selectE.y);
//		}
//		gc.rect(selectS.x, selectS.y, selectE.x, selectE.y);
	}
	public void onMouseReleased() {
		
	}
	public void onMouseClicked() {
		
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
