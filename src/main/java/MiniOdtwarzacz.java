import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

public class MiniOdtwarzacz {

    static JFrame ramka = new JFrame("Moje pierwsze muzyczne video");
    static MojPanelGraf panel;

    public static void main (String[] args) {
        MiniOdtwarzacz mini = new MiniOdtwarzacz();
        mini.doRoboty();

    }

    public void konfigurujGUI() {
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new MojPanelGraf();
        ramka.setContentPane(panel);
        ramka.setBounds(30, 30, 300, 300);
        ramka.setVisible(true);
    }

    public void doRoboty() {
        konfigurujGUI();

        try {
            Sequencer sekwenser = MidiSystem.getSequencer();
            sekwenser.open();
            sekwenser.addControllerEventListener(panel, new int[] {127});
            Sequence sekwencja = new Sequence(Sequence.PPQ, 4);
            Track sciezka = sekwencja.createTrack();

            int r = 0;
            for (int i = 1; i < 200; i+=4){
                r = (int) ((Math.random() * 50) + 1);
                sciezka.add(tworzZdarzenie(144, 1, r, 100, i));
                sciezka.add(tworzZdarzenie(176, 1, 127, 0, i));
                sciezka.add(tworzZdarzenie(128, 1, r, 100, i + 2));
            }

            sekwenser.setSequence(sekwencja);
            sekwenser.setTempoInBPM(220);
            sekwenser.start();
        } catch (Exception ex) {ex.printStackTrace();}
    }

    public static MidiEvent tworzZdarzenie(int plc, int kanal, int jeden, int dwa, int takt) {
        MidiEvent zdarzenie = null;

        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(plc, kanal, jeden, dwa);
            zdarzenie = new MidiEvent(a, takt);
        } catch (Exception e) { }
        return zdarzenie;
    }

    class MojPanelGraf extends JPanel implements  ControllerEventListener {
        boolean komuniat = false;

        public void controlChange(ShortMessage zdarzenie) {
            komuniat = true;
            repaint();
        }

        public void paintComponent (Graphics g) {
            if (komuniat) {
                Graphics2D g2 = (Graphics2D) g;

                int c = (int) (Math.random() * 250);
                int z = (int) (Math.random() * 250);
                int n = (int) (Math.random() * 250);

                g.setColor(new Color(c, z, n));

                int wys = (int) ((Math.random() * 120) + 10);
                int szer = (int) ((Math.random() * 120) + 10);

                int x = (int) ((Math.random() * 40) + 10);
                int y = (int) ((Math.random() * 40) + 10);

                g.drawRect(x, y, wys, szer);
                g.drawString("LA!", (x + wys) / 2, (y + szer) / 2 );
                komuniat = false;
            }
        }
    }
}
