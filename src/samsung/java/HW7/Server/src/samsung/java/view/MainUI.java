package samsung.java.view;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Dao Nam Tien
 *
 */
@SuppressWarnings("serial")
public class MainUI extends JFrame implements IMainUI {

    public JComboBox<String> boxSensor = new JComboBox<>();
    private static JPanel panel;
    private JButton btnShowData = new JButton();

    public MainUI() {
        LookAndFeel old = UIManager.getLookAndFeel();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            old = null;
        }
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 10, 600, 450);

        boxSensor = new JComboBox<>();
        panel.add(boxSensor);
        boxSensor.setBounds(40, 35, 80, 20);
        
        btnShowData = new JButton(" Show data ");
        panel.add(btnShowData);
        btnShowData.setBounds(150, 20, 100, 40);
        btnShowData.setToolTipText(" Be sure to start all sensor Client !");
        JLabel label = new JLabel("Select a sensor");
        panel.add(label);
        label.setBounds(40, 15, 100, 20);
        /**
         * Table data
         */
        String colName[] = {"Time", "Date", "Temperature", "Humidity"};
        String rowData[][] = {{" ", " ", " ", " "}};
        JTable table = new JTable(rowData, colName);
        table.setFillsViewportHeight(true);
        table.getTableHeader().setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 14));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40, 65, 500, 350);
        panel.add(scrollPane);

        /**
         * Edit JFrame
         */
        Container cp = this.getContentPane();
        cp.add(panel);
        validate();
        setTitle(" Weather Sensor ");
        setSize(600, 480);
        setResizable(false);
        setIconImage(getIconImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    /**
     * (non-Javadoc)
     *
     * @see
     * samsung.java.view.IMainUI#setFileActionListener(ActionListener)
     */
    @Override
    public void showDataActionListener(ActionListener listener) {
        this.btnShowData.addActionListener(listener);
    }

    /**
     * (non-Javadoc)
     *
     * @see samsung.java.view.IMainUI#showTable(String[], String[][])
     */
    @Override
    public void showTable(String colName[], String rowData[][]) {
        panel.remove(2);
        JTable table = new JTable(rowData, colName);
        table.setEnabled(false);
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40, 65, 500, 350);
        panel.add(scrollPane);
        table.repaint();
        validate();
    }

    /**
     * (non-Javadoc)
     *
     * @see samsung.java.view.IMainUI#getBoxSensor()
     */
    @Override
    public JComboBox<String> getBoxSensor() {
        return this.boxSensor;
    }
    
    /**
     * (non-Javadoc)
     *
     * @see samsung.java.view.IMainUI#closeForm()
     */
    @Override
    public void closeForm() {
        super.dispose();
    }
}
