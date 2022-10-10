package algo3.pong;

public class ActionReset implements Action {

	@Override
	public void apply(Pong pong) {
		pong.reset();
	}

}
