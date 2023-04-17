import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

public class Deskovky extends JFrame {
    private JButton dalsiButton;
    private JButton predchoziButton;
    private JCheckBox zakoupenoCheckBox;
    private JTextArea textArea1;
    private JPanel panel1;
    private JSlider slider1;
    private JTable table1;
    private int indexSeznamu = 0;
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenu menuHelp;
    private JMenuItem miOpenFile;


    private JFileChooser fileChooserOpen = new JFileChooser(".");

    private Data data = new Data();




    private void initComponents() {
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuFile = new JMenu("File");
        menuFile.setMnemonic(KeyEvent.VK_F); // Menu File se vyvolá klávesou F
        menuBar.add(menuFile);
        menuHelp = new JMenu("Help");
        menuBar.add(menuHelp);

        miOpenFile = new JMenuItem("Open...", KeyEvent.VK_O);
        menuFile.add(miOpenFile);

        miOpenFile.addActionListener(e -> openFile());

        dalsiButton.addActionListener(e -> posunNaDalsi());
        zobrazData();
    }

    private void openFile() {
        int vysledek = fileChooserOpen.showOpenDialog(this);
        if (vysledek == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooserOpen.getSelectedFile();
            // String selectedFilePath = selectedFile.getPath();
            // JOptionPane.showMessageDialog(this,
            //         "Chceš otevřít soubor: "+selectedFilePath);
            data.loadFromFile(selectedFile);
            zobrazData();
        }
    }

    private void posunNaDalsi() {
        data.next();
        zobrazData();
    }

    private void zobrazData() {
        table1.setText(data.getAktualniJmeno());
        table1.setText(data.getAktualniIndex());
    }
    public Deskovky() {
        vypln();
        initComponents();
        predchoziButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indexSeznamu--;
                vypln();
            }
        });
        dalsiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indexSeznamu++;
                vypln();
            }
        });
    }

    public void vypln(){
        CteniZeSouboru cteniZeSouboru = new CteniZeSouboru();
        cteniZeSouboru.vypis();
        List<Deskovky> seznam = cteniZeSouboru.getListDeskovky();
        Deskovky deskovky = seznam.get(indexSeznamu);
        table1.setText(deskovky.getNazev());
        slider1.setValue(deskovky.getOblibenost());
        zakoupenoCheckBox.setSelected(deskovky.isKoupeno());
    }

    public static void main(String[] args) {
        Deskovky h = new Deskovky();
        h.setContentPane(h.panel1);

        h.setVisible(true);
        h.pack();
        h.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}