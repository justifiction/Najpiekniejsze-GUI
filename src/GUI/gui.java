package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import wszystko.*;

public class gui extends JFrame {
    private JPanel MainPanel;
    private JPanel Panelprzyciskow;
    private JButton addfulfillmentcenterButton;
    private JButton removeCenterButton;
    private JButton sortCentersByCurrentButton;
    private JPanel panelprzyciskowproduktow;
    private JButton addNewProductButton;
    private JButton removeProductButton;
    private JPanel Paneltabel;
    private JTable table2;
    private JTable table;
    private JScrollPane JScrollPaneMagazines;
    private JScrollPane JScrollPaneProducts;
    private DisplayObjectTableModel productModel;
    private List<Item> list;
    private DisplayObjectTableModel2 centerModel;
    private List<FulfillmentCenter> list2;

    Fasada magazynyFasada;
    int i;
    public gui()
    {
         super("Justyna");
        createUIComponents();

        addfulfillmentcenterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                JTextField nazwaMagazynu = new JTextField();
                JTextField miejscowosc = new JTextField();
                JTextField calkowita_pojemnosc = new JTextField();


                Object [] hejka={"storage name",nazwaMagazynu,"miejscowosc", miejscowosc,"calkowita pojemnosc", calkowita_pojemnosc};

                   JOptionPane.showConfirmDialog(null, hejka, "Dodaj magazyn", JOptionPane.OK_CANCEL_OPTION);
                if (nazwaMagazynu.getText().equals("") || miejscowosc.getText().equals("") || calkowita_pojemnosc.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Nie podano danych",
                            null, JOptionPane.ERROR_MESSAGE);
                else {
                    try {
                        double s = Double.parseDouble(calkowita_pojemnosc.getText());
                        FulfillmentCenter mag = new FulfillmentCenter(nazwaMagazynu.getText(), miejscowosc.getText(), s);
                        centerModel.addRow(mag);
                        magazynyFasada.magazines.summary(); //spr czy dziala

                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Proszę podać wartość numeryczną",
                                null, JOptionPane.ERROR_MESSAGE);

                    }
                }
               }



        });


        removeCenterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int i= table.getSelectedRow();
                if(i >= 0){
                    centerModel.deleteRow(i);
                }
                else{
                    System.out.println("Delete Error");
                }
            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                i= table.getSelectedRow();
                productModel = new DisplayObjectTableModel(magazynyFasada.getProductlist(i));
                table2= new JTable(productModel);
                JScrollPaneProducts.setViewportView(table2);
            }
        });

        addNewProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JTextField nazwaPrzedmiotu = new JTextField();
                JTextField masa = new JTextField();
                String [] enumy={"ZAMOWIONY", "W_MAGAZYNIE", "SPRZEDANY"};
                JComboBox comboBox = new JComboBox(enumy);

                Object [] something={"nazwa przedmiotu",nazwaPrzedmiotu,"stan", comboBox,"masa", masa};
                JOptionPane.showConfirmDialog(null, something, "DODAJ PRZEDMIOT", JOptionPane.OK_CANCEL_OPTION);
                Integer item = (Integer)comboBox.getSelectedIndex();
                if (nazwaPrzedmiotu.getText().equals("") || item.equals("") || masa.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Nie podano danych",
                            null, JOptionPane.ERROR_MESSAGE);
                else {
                    try {
                        int s = Integer.valueOf(masa.getText());
                        SaleState y = SaleState.valueOf(enumy[item]);
                        Item rzecz = new Item(nazwaPrzedmiotu.getText(), y, s);
                        if (i >= 0) {
                            System.out.println(i);
                            magazynyFasada.addProduct(i, rzecz);
                            JScrollPaneProducts.setViewportView(table2);
                        } else {
                            System.out.println("Error");
                            JOptionPane.showMessageDialog(null, "Nie wybrano magazynu z listy",
                                    null, JOptionPane.ERROR_MESSAGE);
                        }
                        } catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(null, "Proszę podać wartość numeryczną",
                                    null, JOptionPane.ERROR_MESSAGE);

                        }

                }
            }
        });


        removeProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int s= table2.getSelectedRow();
                if(i >= 0 && s >=0){
                    System.out.println((String) table2.getValueAt(i,0));
                    magazynyFasada.deleteProduct(i, s);
                    JScrollPaneProducts.setViewportView(table2);
                }
                else{
                    System.out.println("Delete Error");
                }
            }
        });

        sortCentersByCurrentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                magazynyFasada.sortbycurrentload();
                JScrollPaneMagazines.setViewportView(table);
            }
        });
    }

    private void createUIComponents()  {
        // TODO: place custom component creation code here

        magazynyFasada=DataGenerator.getMagazyny();
       centerModel = new DisplayObjectTableModel2(magazynyFasada.getMagazinelist());
        table= new JTable(centerModel);
        JScrollPaneMagazines.setViewportView(table);
    }


    public static void main(String[] args){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        JFrame frame = new JFrame("GUI");
        frame.setSize(width/2, height/2);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new gui().MainPanel);
        frame.setPreferredSize(new Dimension(width/2, height/2));
        frame.pack();
        frame.validate();
        frame.setVisible(true);
    }


}
