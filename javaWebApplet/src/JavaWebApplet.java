import java.awt.*;

public class JavaWebApplet extends javax.swing.JApplet {
    public void init() {}

    public void paint(Graphics screen) {
        Graphics2D screen2D = (Graphics2D) screen;
        screen2D.drawString("java web applet", 30, 30);
    }
}
