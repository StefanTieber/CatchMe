package utils;

public class Position {
    public float x;
    public float y;

    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void move(Vector vector) {
        x += vector.x;
        y += vector.y;
    }
}
