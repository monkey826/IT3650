package samsung.java.view;

import java.awt.event.ActionListener;
import javax.swing.JButton;

public interface IServerUI {

    /**
     * 
     * @return Server Port
     */
    public int getServerPort();
    /**
     * 
     * @return Button Start
     */
    public JButton getStartButton();
    /**
     * 
     * @return Button Stop
     */
    public JButton getStopButton();
    /**
     * Set Start Listener
     * @param listener 
     */
    public void setStartActionListener(ActionListener listener);
    /**
     * Set Stop listener 
     * @param listener 
     */
    public void setStopActionListener(ActionListener listener);
    /**
     * Close ServerUI form
     */
    public void closeForm();

}
