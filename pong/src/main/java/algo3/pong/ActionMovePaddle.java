package algo3.pong;

import algo3.pong.Pong.Paddle;

public class ActionMovePaddle implements Action {
	private Paddle p;
	private int dy;

	public ActionMovePaddle(Paddle p, int dy) {
		this.p = p;
		this.dy = dy;
	}
	
	@Override
	public void apply(Pong pong) {
		pong.movePaddle(p, dy);
	}
}
