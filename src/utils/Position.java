package utils;

public class Position {
    public float x;
    public float y;

    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Position() {
        this.x = (float) Math.random();
        this.y = (float) Math.random();
    }

    public void add(Vector vector) {
        x += vector.x;
        y += vector.y;
    }
}
