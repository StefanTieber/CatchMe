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

    public static Vector distance(Position position1, Position position2) {
        float deltaX = position2.x - position1.x;
        float deltaY = position2.y - position1.y;
        return new Vector(deltaX, deltaY);
    }
}
