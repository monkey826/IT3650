package samsung.java.socket.view;

import java.awt.event.ActionListener;

public interface IServerUI {
	public int getServerPort();
	public void setStartActionListener(ActionListener listener);
	public void setStopActionListener(ActionListener listener);
	public void close();
	
}
