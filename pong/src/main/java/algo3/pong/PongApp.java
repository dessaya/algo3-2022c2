package algo3.pong;

import static algo3.pong.Pong.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class PongApp extends Application {	
    final Map<KeyCode, Action> controls = Map.of(
	        KeyCode.Q, new ActionMovePaddle(Paddle.LEFT, -1),
	        KeyCode.A, new ActionMovePaddle(Paddle.LEFT, +1),
	        KeyCode.UP, new ActionMovePaddle(Paddle.RIGHT, -1),
	        KeyCode.DOWN, new ActionMovePaddle(Paddle.RIGHT, +1),
	        KeyCode.R, new ActionReset()
    		);
    
    public static void main(String[] args) {
        Application.launch();
    }
    
	@Override
    public void start(Stage stage) {
		stage.setTitle("Pong");
		
		var root = new Group();
        var canvas = new Canvas(W, H);
        root.getChildren().add(canvas);
  
        var scene = new Scene(root, canvas.getWidth(), canvas.getHeight(), Color.BLACK);
        stage.setScene(scene);
        
        setupMainLoop(scene, canvas.getGraphicsContext2D());
        stage.show();        
	}
    
	void setupMainLoop(Scene scene, GraphicsContext gc) {
		var keysPressed = new HashSet<KeyCode>();		
        scene.setOnKeyPressed(e -> { keysPressed.add(e.getCode()); });
        scene.setOnKeyReleased(e -> { keysPressed.remove(e.getCode()); });

        new AnimationTimer() {
        	Pong pong = new Pong();
        	
        	long last = 0;
        	
    		@Override
			public void handle(long now) {
		        render(gc, pong);

		        var actions = new ArrayList<Action>();
		        for (var k : keysPressed) {
		        	var action = controls.get(k);
		        	if (action != null) {
		        		actions.add(action);
		        	}
		        }
		        
		        long dt = last == 0 ? 0 : now - last;
		        pong.update(actions, dt);
		        last = now;
			}
		}.start();
    }
	
    private void render(GraphicsContext gc, Pong pong) {
    	gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    	drawPaddle(gc, pong, Paddle.LEFT);
        drawPaddle(gc, pong, Paddle.RIGHT);
        drawBall(gc, pong);
        drawScore(gc, pong);
    }

    private void drawPaddle(GraphicsContext gc, Pong pong, Paddle p) {
    	double x = p == Paddle.LEFT ? PADDLE_GAP : H - PADDLE_GAP;
    	double y = pong.paddlePosition(p);
    	gc.setFill(Color.WHITE);
		gc.fillRect(
    			x - PADDLE_WIDTH / 2,
    			y - PADDLE_HEIGHT / 2,
    			PADDLE_WIDTH,
    			PADDLE_HEIGHT
    			);
    }

    private void drawBall(GraphicsContext gc, Pong pong) {
    	var ball = pong.ballPosition();
    	gc.setFill(Color.WHITE);
    	gc.fillOval(
    			ball.x - BALL_RADIUS,
    			ball.y - BALL_RADIUS,
    			BALL_RADIUS * 2,
    			BALL_RADIUS * 2
    			);
    }

    private void drawScore(GraphicsContext gc, Pong pong) {
    	gc.setFill(Color.WHITE);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.TOP);
    	gc.fillText("%d - %d".formatted(pong.score(Paddle.LEFT), pong.score(Paddle.RIGHT)), W / 2, 10);
    }
}