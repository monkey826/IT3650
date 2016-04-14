package samsung.java.view;

import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Client UI
 * @author Monkey 
 */
@SuppressWarnings("serial")
public class ClientUI extends JFrame implements IClientUI {

    private final JTextField tfServerAddress;
    private final JTextField tfServerPort;
    private final JButton btnConnect;
    private final JButton btnQuit;

    /**
     * The constructor setting a client.
     */
    public ClientUI() {
        LookAndFeel old = UIManager.getLookAndFeel();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            old = null;
        }
        JLabel lbServerAddress = new JLabel(" Server Address: ");
        JLabel lbServerPort = new JLabel(" Server Port: ");
        tfServerAddress = new JTextField(15);
        tfServerAddress.setText("127.0.0.1");
        tfServerPort = new JTextField(4);
        tfServerPort.setText("5050");
        btnConnect = new JButton("Connect");
        btnQuit = new JButton("Quit");
        JPanel panel = new JPanel();
        panel.setLayout(null);
        lbServerAddress.setBounds(10, 10, 100, 30);
        lbServerPort.setBounds(10, 50, 100, 30);
        tfServerAddress.setBounds(120, 10, 150, 30);
        tfServerPort.setBounds(120, 50, 150, 30);
        btnConnect.setBounds(50, 90, 80, 30);
        btnQuit.setBounds(150, 90, 80, 30);
        panel.add(lbServerAddress);
        panel.add(tfServerAddress);
        panel.add(lbServerPort);
        panel.add(tfServerPort);
        panel.add(btnConnect);
        panel.add(btnQuit);
        Container cp = this.getContentPane();
        cp.add(panel);
        setSize(300, 170);
        setTitle(" Client Setting ");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    /**
     * (non-Javadoc)
     *
     * @see samsung.java.view.IClientUI#getServerAddress() 
     */
    @Override
    public String getServerAddress() {
        return tfServerAddress.getText();
    }
    /**
     * (non-Javadoc)
     *
     * @see samsung.java.view.IClientUI#getServerPort()
     */
    @Override
    public int getServerPort() {
        int port = -1;
        if (!tfServerPort.getText().equals("")) {
            try {
                port = Integer.parseInt(tfServerPort.getText());
            } catch (NumberFormatException nfe) {
                System.out.println(nfe.getMessage());
            }
        } else {
            return 0;
        }
        return port;
    }

    /**
     * (non-Javadoc)
     *
     * @see samsung.java.view.IClientUI#setConnectActionListener(java.awt.event.ActionListener) 
     */
    @Override
    public void setConnectActionListener(ActionListener listener) {
        this.btnConnect.addActionListener(listener);
    }

    /**
    * (non-Javadoc)
     *
     * @see samsung.java.view.IClientUI#setQuitActionListener(java.awt.event.ActionListener)  
     */
    @Override
    public void setQuitActionListener(ActionListener listener) {
        this.btnQuit.addActionListener(listener);
    }
    /**
     * (non-Javadoc)
     *
     * @see samsung.java.view.IClientUI#close() 
     */
    @Override
    public void close() {
        super.dispose();
    }
}
