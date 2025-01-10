public class Vector3D {
    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getZ() {
        return z;
    }
    public String toString() {
        return String.format ("(%.2f, %.2f, %.2f)", getX(), getY(), getZ());
    }

    public double getMagnitude() {
        double total = Math.pow(getX(), 2) + Math.pow(getY(), 2) + Math.pow(getZ(), 2);
        return Math.sqrt(total);
    }

    public Vector3D normalize() {
        double newX = getX() / getMagnitude();
        double newY = getY() / getMagnitude();
        double newZ = getZ() / getMagnitude();
        return new Vector3D(newX, newY, newZ);
    }

    public Vector3D add(Vector3D two) {
        double newX = getX() + two.getX();
        double newY = getY() + two.getY();
        double newZ = getZ() + two.getZ();
        return new Vector3D(newX, newY, newZ);
    }

    public Vector3D multiply(final int num) {
        double newX = getX() * num;
        double newY = getY() * num;
        double newZ = getZ() * num;
        return new Vector3D(newX, newY, newZ);
    }

    public double dotProduct(Vector3D two) {
        return getX() * two.getX() + getY() * two.getY() + getZ() * two.getZ();
    }

    public double angleBetween(Vector3D two) {
        double dot = dotProduct(two);
        double multMagnitude = getMagnitude() * two.getMagnitude();
        return Math.toDegrees(Math.acos(dot / multMagnitude));
    }

    public Vector3D crossProduct(Vector3D two) {
        double newX = getY() * two.getZ() - getZ() * two.getY();
        double newY = getZ() * two.getX() - getX() * two.getZ();
        double newZ = getX() * two.getY() - getY() * two.getX();
        return new Vector3D(newX, newY, newZ);
    }

    public static void main(String args[]) {
        Vector3D first = new Vector3D(3.9999, 4.0, 5.499);
        Vector3D second = new Vector3D(2.0, 2.5, 1.0);
        System.out.println(first.toString());
        System.out.println(first.getMagnitude());
        System.out.println(first.normalize());
        System.out.println(first.add(second));
        System.out.println(first.multiply(2));
        System.out.println(first.dotProduct(second));
        System.out.println(first.angleBetween(second));
        System.out.println(first.crossProduct(second));
    }
}