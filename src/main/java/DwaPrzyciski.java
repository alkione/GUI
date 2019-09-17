import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DwaPrzyciski {

    JFrame ramka;
    JLabel etykieta;

    public static void main (String[] args){
        DwaPrzyciski gui = new DwaPrzyciski();
        gui.doRoboty();

    }

    public void doRoboty() {
        ramka = new JFrame();
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton przyciskEtyk = new JButton("Zmień etykietę");
        przyciskEtyk.addActionListener(new EtykietaListener());

        JButton przyciskKolor = new JButton("Zmień kolor");
        przyciskKolor.addActionListener(new KolorListener());

        etykieta = new JLabel("Oto etykieta");
        MojPanelGraficzny panel = new MojPanelGraficzny();

        ramka.getContentPane().add(BorderLayout.SOUTH, przyciskKolor);
        ramka.getContentPane().add(BorderLayout.CENTER, panel);
        ramka.getContentPane().add(BorderLayout.EAST, przyciskEtyk);
        ramka.getContentPane().add(BorderLayout.WEST, etykieta);

        ramka.setSize(400,300);
        ramka.setVisible(true);
    }

    class EtykietaListener implements ActionListener {
        public void actionPerformed(ActionEvent zdarzenie){
            etykieta.setText("Haloo!!");
        }
    }

    class KolorListener implements ActionListener {
        public void actionPerformed(ActionEvent zdarzenie){
            ramka.repaint();
        }
    }
}
