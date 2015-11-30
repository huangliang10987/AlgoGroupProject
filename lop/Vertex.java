package lop;

public class Vertex {
	public static enum color_t {
		BLUE, RED
	}

	public static enum direction_t {
		N, E, S, W, NE, NW, SE, SW
	}

	public int number;
	public String color;
	public String direction;
	public boolean discovered = false;

	@Override
	public String toString() {
		return "Vertex [number=" + number + ", color=" + color + ", direction="
				+ direction + ", discovered=" + discovered + "]";
	}

}
