public final class Ponto2D {
    private final double x;
    private final double y;

    public Ponto2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public static void main(String[] args) {
        Ponto2D ponto = new Ponto2D(3.0, 4.0);

        System.out.println("Coordenadas: (" + ponto.getX() + ", " + ponto.getY() + ")");
    }
}
