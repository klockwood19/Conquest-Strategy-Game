package com.kyle.galactic_conquest.menus;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.animation.FadeTransition;
import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Menu extends Application{
	
	private GameMenu gameMenu;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Pane root = new Pane();
		root.setPrefSize(900,600);
		
		InputStream is = Files.newInputStream(Paths.get("images/mistCastle.jpg"));
		Image img = new Image(is);
		
		ImageView imgView = new ImageView(img);
		imgView.setFitHeight(600);
		imgView.setFitWidth(900);
		
		gameMenu = new GameMenu();
		
		root.getChildren().addAll(imgView, gameMenu);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private class GameMenu extends Parent {
		public GameMenu() {
			VBox menu0 = new VBox(10);
			VBox menu1 = new VBox(10); // value of 10 is distance between two elements
			
			menu0.setTranslateX(100);
			menu0.setTranslateY(200);
			
			menu1.setTranslateX(100);
			menu1.setTranslateX(200); // this is for an animation effect
			
			MenuButton btnResume = new MenuButton("Resume");
			btnResume.setOnMouseClicked(event -> {
				FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
				ft.setFromValue(1);
				ft.setToValue(0);
				ft.setOnFinished(evt -> this.setVisible(false));
				ft.play();
			});
			
			MenuButton btnOptions = new MenuButton("Options");
			MenuButton btnExit = new MenuButton("EXIT");
			btnExit.setOnMouseClicked(event -> {
				System.exit(0);
			});
			
			menu0.getChildren().addAll(btnResume,btnOptions,btnExit);
			
			Rectangle background = new Rectangle(800,600);
			background.setFill(Color.GREY);
			background.setOpacity(0.4);
			
			getChildren().addAll(background,menu0);
		}
	}
	
	public static class MenuButton extends StackPane {
		private Text text;
		
		public MenuButton(String name) {
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
	
	public static void main(String[] args) {
		launch(args);
	}
	
	}