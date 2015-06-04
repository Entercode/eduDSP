/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.entercode.edudsp.blockdiagram;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 *
 * @author entercode
 */
public class BlockDiagramViewAnimator extends AnimationTimer {
	Image yahagi = new Image("/image/yahagi.png");
	Image roma = new Image("/image/roma.png");
	GraphicsContext gc;
	
	public BlockDiagramViewAnimator(GraphicsContext gc) {
		this.gc = gc;
	}

	@Override
	public void handle(long now) {
		if((now % 2) == 1) gc.drawImage(yahagi, 0, 0);
		else gc.drawImage(roma, 0, 0);
	}
}
