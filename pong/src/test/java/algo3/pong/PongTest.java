package algo3.pong;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import algo3.pong.Pong.Paddle;

public class PongTest {
	@Test
	public void testInitialState() {
		var pong = new Pong();
		
		assertEquals(0, pong.score(Paddle.LEFT));
		assertEquals(0, pong.score(Paddle.RIGHT));
		assertEquals(Pong.H / 2, pong.paddlePosition(Paddle.LEFT), 0);
		assertEquals(Pong.H / 2, pong.paddlePosition(Paddle.RIGHT), 0);
		assertTrue(pong.ballPosition().equals(new Vec2D(Pong.W / 2, Pong.H / 2)));
		assertFalse(pong.ballVelocity().equals(Vec2D.ZERO));
	}

	@Test
	public void testAdvanceBall() {
		var pong = new Pong();
		var initialBallPos = pong.ballPosition();
		
		pong.update(new ArrayList<>(), Pong.MS_PER_FRAME * 1_000_000);
		
		assertFalse(pong.ballPosition().equals(initialBallPos));
	}

	@Test
	public void testGoalRight() {
		var pong = new Pong();
		pong.setBallPosition(new Vec2D(Pong.W - 1, Pong.H / 2));
		pong.setBallVelocity(new Vec2D(1, 0));
		pong.setPaddlePosition(Paddle.RIGHT, Pong.H); // make sure the paddle doesn't catch the ball
				
		pong.update(new ArrayList<>(), Pong.MS_PER_FRAME * 1_000_000);
		
		assertEquals(1, pong.score(Paddle.LEFT));
		assertEquals(0, pong.score(Paddle.RIGHT));
		assertTrue(pong.ballPosition().equals(new Vec2D(Pong.W / 2, Pong.H / 2)));
		assertFalse(pong.ballVelocity().equals(Vec2D.ZERO));
	}
	
	// TODO: falta testear:
	// - que se puede hacer gol a la izquierda
	// - que podemos mover las paletas
	// - que podemos resetear el juego
	// - que la pelota choca con las paletas
}
