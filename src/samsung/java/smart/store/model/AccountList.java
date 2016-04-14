package samsung.java.smart.store.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringTokenizer;


/**
 * @author Bui Trong Tung The AccountList class implementing IAccountList
 *         contains the accounts of the Smart Store application
 */
public class AccountList implements IAccountList {
	private IAccount[] userList;
	private int numberOfAccount;

	/**
	 * Construct a AccountList containing account data by reading from text file
	 */
	public AccountList() {
		this.userList = new Account[10];
		Path filePath = Paths.get(IAccountList.ACCOUNT_FILE);
		numberOfAccount = 0;
		try (BufferedReader rd = Files.newBufferedReader(filePath)) {
			String line, userID, password;
			int permission = 0;
			StringTokenizer tk;
			while ((line = rd.readLine()) != null) {
				tk = new StringTokenizer(line);
				userID = tk.nextToken();
				password = tk.nextToken();
				try{
					permission = Integer.parseInt(tk.nextToken());
				}
				catch (NumberFormatException nfe){
					System.out.println(nfe.getMessage());
				}
				userList[numberOfAccount] = new Account(userID, password,permission);
				numberOfAccount++;
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * samsung.java.smart.store.model.IAccountList#addAccount(samsung.java.smart
	 * .store.model.IAccount)
	 */
	@Override
	public boolean addAccount(IAccount acc) {
		if (numberOfAccount <= 9) {
			userList[numberOfAccount] = acc;
			numberOfAccount++;
			try (FileWriter fw = new FileWriter(IAccountList.ACCOUNT_FILE, true)) {
				BufferedWriter rd = new BufferedWriter(fw);
				rd.newLine();
				rd.write(acc.getID() + " " + acc.getPassword() + " " + acc.getPermission());
				rd.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			return true;
		} else {
			return false;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * samsung.java.smart.store.model.IAccountList#check(samsung.java.smart.
	 * store .model.IAccount)
	 */
	@Override
	public int check(String name, String password) {
		int found = -1;
		for (int i = 0; i < numberOfAccount; i++)
			if ((name.compareToIgnoreCase(userList[i].getID()) == 0)
					&& password.compareTo(userList[i].getPassword()) == 0) {
				found = userList[i].getPermission();
				break;
			}
		return found;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see samsung.java.smart.store.model.IAccountList#checkAcc(samsung.java.smart.store
	 *      .model.IAccount)
	 */
	@Override
	public boolean checkAcc(String name) {
		for (int i = 0; i < numberOfAccount; i++)
			if ((name.compareToIgnoreCase(userList[i].getID()) == 0))
				return true;
		return false;
	}
}
