package algo3.pong;

public class Vec2D {
	public static final Vec2D ZERO = new Vec2D(0, 0);

	public final double x;
	public final double y;

	public Vec2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Vec2D other) {
		return this.x == other.x && this.y == other.y;
	}
	
	@Override
	public String toString() {
		return "(%f, %f)".formatted(x, y);
	}
}
