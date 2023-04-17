import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Deskovky extends JFrame {
    private JPanel panelMain;
    private JTable table1;

    private JCheckBox checkBox;
    private JButton predchoziButton;
    private JButton dalsiButton;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JTextField textField1;

    ButtonGroup btnGroup = new ButtonGroup();

    int pocetStranke=0;
    private List<Deskovky1> seznam = new ArrayList<>();
    private Table model;
    public Deskovky() {
        initTable();
        vypis(0);
        btnGroup.add(radioButton1);
        btnGroup.add(radioButton2);
        btnGroup.add(radioButton3);
        predchoziButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pocetStranke--;
                vypis(pocetStranke);


            }
        });
        dalsiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CteniZeSouboru cteni = new CteniZeSouboru();
                pocetStranke++;
                vypis(pocetStranke);
            }
        });
    }
    private void initTable() {
        CteniZeSouboru souborDeskovka = new CteniZeSouboru();
        seznam = CteniZeSouboru.vypisSoubor("deskovky.txt",";");
        model = new Table(seznam);
        table1.setModel(model);
    }
    void vypis(int index) {
        CteniZeSouboru souborDeskovka = new CteniZeSouboru();
        seznam = CteniZeSouboru.vypisSoubor("deskovky.txt",";");
        if (index == seznam.size()-1){
            predchoziButton.setEnabled(true);
            dalsiButton.setEnabled(false);
        } else if (index == 0) {
            predchoziButton.setEnabled(false);
            dalsiButton.setEnabled(true);
        } else {
            predchoziButton.setEnabled(true);
            dalsiButton.setEnabled(true);
        }
        Deskovky1 pocetSeznam = seznam.get(index);
        textField1.setText(pocetSeznam.getNazev());
        if(pocetSeznam.isZakoupeno()== true) {
            checkBox.setSelected(true);
        } else {
            checkBox.setSelected(false);
        }

        if(pocetSeznam.getOblibenost()==1) {
            radioButton1.setSelected(true);
        } else {
            radioButton1.setSelected(false);
        } if (pocetSeznam.getOblibenost()==2) {
            radioButton2.setSelected(true);
        } else {
            radioButton2.setSelected(false);
        } if (pocetSeznam.getOblibenost()== 3) {
            radioButton3.setSelected(true);
        } else {
            radioButton3.setSelected(false);
        }








    }


    public static void main(String[] args) {
        Deskovky h = new Deskovky();
        h.setContentPane(h.panelMain);

        h.setTitle("tabulka");
        h.pack();
        h.setVisible(true);
        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}