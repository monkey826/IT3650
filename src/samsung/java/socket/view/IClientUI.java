package samsung.java.socket.view;

import java.awt.event.ActionListener;

public interface IClientUI {
	public String getServerAddress();
	public int getServerPort();
	public void setConnectActionListener(ActionListener listener);
	public void setQuitActionListener(ActionListener listener);
	public void close();
}

