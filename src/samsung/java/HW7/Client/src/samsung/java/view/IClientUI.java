package samsung.java.view;

import java.awt.event.ActionListener;

public interface IClientUI {

    /**
     * 
     * @return Server Address
     */
    public String getServerAddress();
    /**
     * 
     * @return Server Port
     */
    public int getServerPort();
    /**
     *  Set Connection Listener
     * @param listener 
     */
    public void setConnectActionListener(ActionListener listener);
    /**
     * Set Quit Listener
     * @param listener 
     */
    public void setQuitActionListener(ActionListener listener);
    /**
     * Close Form
     */
    public void close();
}
