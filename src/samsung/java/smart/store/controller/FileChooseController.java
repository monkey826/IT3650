package samsung.java.smart.store.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

import samsung.java.smart.store.model.IProduct;
import samsung.java.smart.store.model.IProductList;
import samsung.java.smart.store.model.ProductList;
import samsung.java.smart.store.view.IMainView;

public class FileChooseController {
	public FileChooseController(IMainView mainWindow) {

		// / Set file chooser and show information
		mainWindow.setButtonFileChooserActionListener(new ActionListener() {
			// / Display all information from file product to this program
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// / windows background
				LookAndFeel old = UIManager.getLookAndFeel();
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (Throwable ex) {
					old = null;
				}
				// / Add window choose file
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File f = fileChooser.getSelectedFile();
					String path = f.getPath();
					System.out.println(path);
					IProductList productList = new ProductList(path);
					String colName[] = { "Product ID", "Product Name", "Amount" };
					int numberOfProduct = productList.getNumberOfProduct();
					String rowData[][] = new String[numberOfProduct][3];
					IProduct[] list = productList.getList();
					for (int i = 0; i < numberOfProduct; i++) {
						rowData[i][0] = new String(list[i].getID());
						System.out.println(rowData[i][0]);
						rowData[i][1] = new String(list[i].getName());
						rowData[i][2] = new String();
						rowData[i][2] += list[i].getAmount();
					}
					// create table
					mainWindow.createTable(rowData, colName);
				}
				new FileChooseController(mainWindow);
			}
		});
	}
}
