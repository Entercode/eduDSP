/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.entercode.edudsp.blockdiagram.block;

import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 * Block class for block-diagram
 * 
 * @author entercode
 */
public abstract class Block {
	
	private String name = "Null";
	private int id = 0;
	private int width = 0;
	private int height = 0;
	private Image texture;
	/*
		Signal direction
		L -> R = 0, U -> B = 1, R -> L = 2, B -> U = 3
	*/
	private int direction = 0;
	
	private ArrayList<Block> outputArray;
	
	private double inputValue;
	private double outputValue;
	
	public Block(String name, int id,
			int width, int height, String relativePath) {
		this.name = name;
		this.id = id;
		this.width = width;
		this.height = height;
		this.texture = new Image(relativePath);
	}
	
	
	/*
		Accessor
	*/
	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setImage(Image image) {
		this.texture = image;
	}
}
