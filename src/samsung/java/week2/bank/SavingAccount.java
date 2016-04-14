package samsung.java.week2.bank;

import java.util.Date;

/** Information about saving account
 * Include 5 attributes : <u> accountID</u> , <u> accountName</u> , <u> Assets </u>, <u> dateGive </u> , <u> iRate </u>
 * @author monkey
 * 
 * 
 */
public class SavingAccount {
	private String accountID;
	private String accountName;
	private Double Assets;
	private Date dateGive;
	private Double iRate; // Interest rate
	/** Constructor initiate new account with full of information
	 * 
	 * @param id : Set Account id
	 * @param name : Set Account name
	 * @param assets : Set assets
	 * @param date : Set date given
	 * @param rate :Set rate
	 */
	public SavingAccount(String id, String name,double assets,Date date,Double rate){
		id.trim();
		name.trim();
		if ( !id.equals("") && !name.equals("")){
			setAccountID(id);
			setAccountName(name);
			setAssets(assets);
			setDateGive(date);
			setIRate(rate);
		}
		else System.out.println(" This account cannot create. ");
	}
	/** Constructor init new account with id and name
	 * 
	 * @param id : Set Account id
	 * @param name : Set Account name
	 */
	public SavingAccount(String id, String name){
		id.trim();
		name.trim();
		if ( !id.equals("") && !name.equals("")){
			setAccountID(id);
			setAccountName(name);
			setAssets(0.0);
			setDateGive(null);
			setIRate(0.0);
		}
		else System.out.println(" This account cannot create. ");
	}
	// *********************** Get,Set method. ******************************
	/** Get Date give money
	 * 
	 * @return : Date give money
	 */
	public Date getDateGive() {
		return dateGive;		
	}
	/** Setter Date give 
	 * 
	 * @param dateGive
	 */
	public void setDateGive(Date dateGive) {
		this.dateGive = dateGive;
	}
	/** Getter: Take interest rate
	 * 
	 * @return
	 */
	public Double getIRate() {
		return iRate;
	}
	/**  Setter: set interest rate : Lãi suất 
	 * 
	 * @param iRate
	 */
	public void setIRate(Double iRate) {
		this.iRate = iRate;
	}
	/** Getter : Take account id
	 * 
	 * @return
	 */
	public String getAccountID() {
		return accountID;
	}
	/**  Setter: Set account id
	 * 
	 * @param accountID
	 */
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	/** Getter : Take account name
	 * 
	 * @return
	 */
	public String getAccountName() {
		return accountName;
	}
	/** Setter : Account name
	 * 
	 * @param accountName
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	/** Getter root saving account
	 * 
	 * @return : root saving account
	 */
	public Double getAssets() {
		return Assets;
	}
	/** Setter root saving account
	 * 
	 * @param assets
	 */
	public void setAssets(Double assets) {
		Assets = assets;
	}
	// ********************** End Get,Set Method ******************************
	
	/** Check information : assets, rate  are exist on this account
	 * 
	 * @return 
	 *  <p> True if this account have asset,rate. </p>
	 *  <p> False if not .... </p>
	 */
	public boolean isExist(){
		if ( getAssets() == 0 && getIRate() == 0  )
			return false;
		return true;
	}
	/** Calculate number of days from day given.
	 * 
	 */
	public long getDays(){
		if (getDateGive() == null){
			return 0;
		}
		else {
			Date date = new Date();
			if (date.getTime()>getDateGive().getTime())
				return (date.getTime()-getDateGive().getTime())/(3600*24*1000);
			else return 0;
		}
		
	}
	/** Money a way from a total
 	 * 
	 * @return  Full of money
	 */
	public double getTotalAssets() {
		return getBalance()+getAssets();
	}
	/** Get Balance
	 * 
	 * @return  balance of this saving account
	 */
	public double getBalance(){
		return getAssets()*getIRate()*getDays()/100;
	}
	/** Withdraw all balance 
	 *  <p> DateGiven = Now </p>
	 */
	public void withdrawInterest(){
		if (isExist()){
			System.out.println(" Your money withdrew: " + getBalance());
			setDateGive(new Date());
		}
		else System.out.println(" This account don't have money");
	}
	/** Withdraw partially, all balance and some part of assets
	 * <p> DateGiven = Now </p>
	 * @param money : this argument mean how much money user want to withdraw from root account (assets)
	 * @return 
	 *  0: if this account don't give money in bank<br>
	 *  1: if this account give money in bank
	 */
	public int withdrawPartially(double money){
		if (isExist()){
			if ( money <= 0 || money > getAssets())
				System.out.println(" This number is not valid");
			else {
				System.out.println(" Partially withdrew = " + (getBalance()+money));
				setAssets(getAssets()-money);
				setDateGive(new Date());
			}
			return 1;
		}
		else {
			System.out.println(" This account don't have money");
			return 0;
		}
	}
	/**
	 *  Withdraw totally , all money in this account.
	 *  <p> DateGiven = Now </p>
	 */
	public void withdrawTotally(){
		if (isExist()){
			System.out.println(" Totally withdrew = " + getTotalAssets());
			setAssets(0.0);
			setDateGive(new Date());
		}
		else System.out.println(" This account don't have money");	
		
	}
	/**Give money in bank <br>
	 * Show all balance <br>
	 * DateGiven = Now <br>
	 * @param money : how much money that user give money to the bank
	 */
	public void Deposit(double money,double rate){
		if (isExist()){
			System.out.println(" Your balance : " + getBalance());
		}
		else {
			System.out.println(" This account didn't have money before.");	
		}
		setAssets(getTotalAssets()+money);
		setDateGive(new Date());
		setIRate(rate);
		System.out.println(" Deposit successful");	
	}
	
}
