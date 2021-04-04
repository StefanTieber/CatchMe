package utils;

public class Vector {
    public float x;
    public float y;

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void add(Vector vector) {
        x += vector.x;
        y += vector.y;
    }

    public static Vector add(Vector vector1, Vector vector2) {
        return new Vector(vector1.x + vector2.x, vector1.y + vector2.y);
    }

    public float getLength() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public float getDirection() {
        return (float) Math.atan2(y, x);
    }

    public void setLength(float length) {
        float oldLength = getLength();
        x = x * length / oldLength;
        y = y * length / oldLength;
    }

    public void normalizeLength() {
        setLength(1);
    }
}
