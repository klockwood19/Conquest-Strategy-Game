package com.kyle.galactic_conquest.menus;

import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Menu_Button extends StackPane {
	private Text text;
	
	public Menu_Button(String name) {
		text = new Text(name);
		text.setFill(Color.WHITE);
		text.setFont(text.getFont().font(20));
		
		
		Rectangle bg = new Rectangle(250,30);
		bg.setOpacity(0.6);
		bg.setFill(Color.BLACK);
		bg.setEffect(new GaussianBlur(3.5));
		
		setAlignment(Pos.CENTER_LEFT);
		setRotate(-0.5);
		getChildren().addAll(bg,text);
		
		setOnMouseEntered(event -> {
			bg.setTranslateX(10);
			text.setTranslateX(10);
			bg.setFill(Color.WHITE);
			text.setFill(Color.BLACK);
		});
		
		setOnMouseExited(event -> {
			bg.setTranslateX(0);
			text.setTranslateX(0);
			bg.setFill(Color.BLACK);
			text.setFill(Color.WHITE);
		});
		
		DropShadow drop = new DropShadow(50,Color.WHITE);
		drop.setInput(new Glow());
		
		setOnMousePressed(event -> {
			setEffect(drop); // add shadow glow effect when user clicks
		});
		setOnMouseReleased(event -> {
			setEffect(null); // remove glow effect when mouse released
		});
	}
	
	
	
}