package puntocentrolinea;
import javax.swing.*;
import java.awt.*;

class Punto {
    double x;
    double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void coordenadasCartesianas() {
        System.out.println("Los puntos del plano cartesiano son: (" + x + ", " + y + ")");
    }

    public void coordenadasPolares() {
        double c = Math.sqrt(x * x + y * y);
        double a = Math.atan2(y, x);
        System.out.println("Las coordenadas polares son: (r = " + c + ", θ = " + a + ")");
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

class Linea extends JPanel {
    Punto p1;
    Punto p2;

    public Linea(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
        setPreferredSize(new Dimension(5000, 5000));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.drawLine((int) p1.x, (int) p1.y, (int) p2.x, (int) p2.y);
    }

    public String toString() {
        return "Línea desde el punto " + p1.toString() + " hasta el punto " + p2.toString();
    }

    public void dibujarLinea() {
        System.out.println("Dibujando una línea desde el punto " + p1.toString() + " hasta el punto " + p2.toString());
        JFrame frame = new JFrame("Dibujar Línea");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
    }
}

class Circulo extends JPanel {
    Punto centro;
    float radio;

    public Circulo(Punto centro, float radio) {
        this.centro = centro;
        this.radio = radio;
        setPreferredSize(new Dimension(5000, 5000));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        int diameter = (int) (radio * 2);
        g.drawOval((int) (centro.x - radio), (int) (centro.y - radio), diameter, diameter);
    }

    public String toString() {
        return "Círculo con centro en los puntos: " + centro.toString() + " y con radio " + radio;
    }

    public void dibujaCirculo() {
        System.out.println("Dibujando un círculo con centro en los puntos " + centro.toString() + " y con radio " + radio);
        JFrame frame = new JFrame("Dibujar Círculo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
    }
}

public class PuntoCentroLinea {
    public static void main(String[] args) {
        Punto a = new Punto(11, 3);
        Punto b = new Punto(23, 22);

        System.out.println("Primer punto");
        a.coordenadasCartesianas();
        a.coordenadasPolares();

        System.out.println("Segundo punto");
        b.coordenadasCartesianas();
        b.coordenadasPolares();

        System.out.println("_Línea__");
        Linea l = new Linea(a, b);
        l.toString();
        l.dibujarLinea();

        System.out.println("_Círculo_");
        Circulo c = new Circulo(a, 5.1f);
        c.toString();
        c.dibujaCirculo();

        Circulo d = new Circulo(b, 5.1f);
        d.toString();
        d.dibujaCirculo();
    }
}
