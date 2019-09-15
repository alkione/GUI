import javax.swing.*;
import java.awt.*;

public class MojPanelGraficzny extends JPanel {

    public void paintComponent(Graphics g){
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        int czerwony = (int) (Math.random() * 256);
        int zielony = (int) (Math.random() * 256);
        int niebieski = (int) (Math.random() * 256);

        Color kolorLosowy = new Color(czerwony, zielony, niebieski);
        g.setColor(kolorLosowy);
        g.fillOval(70, 70, 100, 100);

    }

}
