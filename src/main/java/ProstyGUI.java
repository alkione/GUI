import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ProstyGUI implements ActionListener {
    JButton przycisk;
    JFrame ramka;


    public static void main (String[] args){
        ProstyGUI appGUI = new ProstyGUI();
        appGUI.doDziela();
    }


        public void doDziela(){
            ramka = new JFrame();
            ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            przycisk = new JButton("Zmiana koloru");
            przycisk.addActionListener(this);

            MojPanelGraficzny panelG = new MojPanelGraficzny();

            ramka.getContentPane().add(BorderLayout.SOUTH, przycisk);
            ramka.getContentPane().add(BorderLayout.CENTER, panelG);
            ramka.setSize(300,300);
            ramka.setVisible(true);
        }

        public void actionPerformed(ActionEvent zdarzenie){
            ramka.repaint();
        }

    }
