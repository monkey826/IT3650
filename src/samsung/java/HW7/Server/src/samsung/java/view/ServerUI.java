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
 * Server UI
 *
 * @author Monkey
 */
@SuppressWarnings("serial")
public class ServerUI extends JFrame implements IServerUI {

    private final JTextField tfServerPort;
    public JButton btnStart;
    public JButton btnStop;

    /**
     * The constructor setting a client.
     */
    public ServerUI() {
        LookAndFeel old = UIManager.getLookAndFeel();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            old = null;
        }
        JLabel lbServerPort = new JLabel(" Server Port: ");
        tfServerPort = new JTextField(4);
        tfServerPort.setText("5050");
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");
        JPanel panel = new JPanel();
        panel.setLayout(null);
        lbServerPort.setBounds(10, 10, 100, 30);
        tfServerPort.setBounds(120, 10, 150, 30);
        btnStart.setBounds(50, 50, 80, 30);
        btnStop.setBounds(150, 50, 80, 30);
        btnStop.setEnabled(false);
        panel.add(lbServerPort);
        panel.add(tfServerPort);
        panel.add(btnStart);
        panel.add(btnStop);
        Container cp = this.getContentPane();
        cp.add(panel);
        setSize(300, 130);
        setTitle(" Server Setting ");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * (non-Javadoc)
     *
     * @see samsung.java.view.IServerUI#getStartButton()
     */
    @Override
    public JButton getStartButton() {
        return this.btnStart;
    }

    /**
     * (non-Javadoc)
     *
     * @see samsung.java.view.IServerUI#getStopButton()
     */
    @Override
    public JButton getStopButton() {
        return this.btnStop;
    }

    /**
     * (non-Javadoc)
     *
     * @see samsung.java.view.IServerUI#getServerPort()
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
     * @see samsung.java.view.IServerUI#setStartActionListener(java.awt.event.ActionListener) 
     */
    @Override
    public void setStartActionListener(ActionListener listener) {
        this.btnStart.addActionListener(listener);
    }
    /**
      * (non-Javadoc)
     * @see samsung.java.view.IServerUI#setStopActionListener(java.awt.event.ActionListener)() 
     */
    @Override
    public void setStopActionListener(ActionListener listener) {
        this.btnStop.addActionListener(listener);
    }
    /*
    * (non-Javadoc)
    * @see samsung.java.view.IServerUI#closeForm()
    */
    @Override
    public void closeForm() {
        super.dispose();
    }

}
