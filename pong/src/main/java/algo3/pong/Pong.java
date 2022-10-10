package algo3.pong;

import static java.lang.Math.abs;
import static java.lang.Math.random;
import static java.lang.Math.sqrt;

public class Pong {
	public static final int H = 300;
	public static final int W = 300;

	public enum Paddle { LEFT, RIGHT };
	
	public static final int PADDLE_GAP = 10;
	public static final int PADDLE_WIDTH = 10;
	public static final int PADDLE_HEIGHT = 60;

	public static final int BALL_RADIUS = 5;

	public static final int FPS = 60;
	public static final long MS_PER_FRAME = 1000 / FPS;
	public static final double VELOCITY = 150 / FPS;

	// the game state:
	
	private double[] paddles;
	private Vec2D ballPos;
	private Vec2D ballVel;
	private int[] score;
	private long msSinceLastFrame = 0;
	
	public Pong() {
		reset();
	}
	
	public void reset() {
		paddles = new double[]{H / 2, H / 2};
		score = new int[] {0, 0};
		startPoint();
	}

	private void startPoint() {
		ballPos = new Vec2D(W / 2, H / 2);
		ballVel = randomBallVelocity();
	}

	public void update(Iterable<Action> actions, long dt) {
		for (var action : actions)
			action.apply(this);
		
		// dt is in nanoseconds
		msSinceLastFrame += dt / 1_000_000;
		while (msSinceLastFrame >= MS_PER_FRAME) {
			msSinceLastFrame -= MS_PER_FRAME;
			moveBall();
			checkGoal();	
		}		
	}
	    		
	public void movePaddle(Paddle p, int dy) {
	    var y = paddlePosition(p);
	    y += dy * VELOCITY * 1.5;
	    if (y < 0) y = 0;
	    if (y > H) y = H;
	    setPaddlePosition(p, y);
	}

	private void moveBall() {
		var x = ballPos.x;
		var y = ballPos.y;
		var vx = ballVel.x;
		var vy = ballVel.y;

		x = x + vx * VELOCITY;
		y = y + vy * VELOCITY;

		if (y < BALL_RADIUS || y > H - BALL_RADIUS) {
			vy = -vy;
		}

		if (
				(vx < 0 && paddleCollision(Paddle.LEFT)) ||
				(vx > 0 && paddleCollision(Paddle.RIGHT))
		) {
			vx = -vx;
			vy += 2 * (random() - 0.5);
		}
		ballPos = new Vec2D(x, y);
		ballVel = new Vec2D(vx, vy);
	}
	
	private boolean paddleCollision(Paddle p) {
	    var bx = ballPos.x;
	    var by = ballPos.y;

	    var py = paddles[p.ordinal()];
	    var px = p == Paddle.LEFT ? PADDLE_GAP : H - PADDLE_GAP;

	    if (abs(bx - px) > PADDLE_WIDTH / 2 + BALL_RADIUS)
	    	return false;
	    if (abs(by - py) > PADDLE_HEIGHT / 2 + BALL_RADIUS)
	    	return false;
	    return true;
	}

	private void checkGoal() {
		var x = ballPos.x;
		var vx = ballVel.x;

		if (vx > 0 && x > W) {
			startPoint();
			score[0]++;
		}
		if (vx < 0 && x < 0) {
			startPoint();
			score[1]++;
		}
	}
    
	private Vec2D randomBallVelocity() {
		double vx = random() > 0.5 ? 1 : -1;
		double vy = random();
		var norm = sqrt (vx * vx + vy * vy);
		return new Vec2D(vx / norm, vy / norm);
	}

	public double paddlePosition(Paddle p) {
		return paddles[p.ordinal()];
	}

	public Vec2D ballPosition() {
		return ballPos;
	}

	public int score(Paddle p) {
		return score[p.ordinal()];
	}

	public void setPaddlePosition(Paddle p, double y) {
	    paddles[p.ordinal()] = y;
	}

	public Vec2D ballVelocity() {
		return ballVel;
	}

	public void setBallPosition(Vec2D pos) {
		ballPos = pos;
	}

	public void setBallVelocity(Vec2D vel) {
		ballVel = vel;
	}
}
