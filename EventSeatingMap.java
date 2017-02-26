import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner; 

public class EventSeatingMap{
	
	private boolean isVIP = false;		// true if VIP transaction
	private boolean isBulk = false;		// true if numSeats > 4
	private int[] vipMembers = {159,7913,753};	//dummy values of VIP members
	private String title = "Seat Selection";	//title of seat selection window
	private double currTotal = 0;	// total as seats are being selected
	private double finalPrice = 0;	// absolute final price
	private double vipDiscount = 0.80;	//multiply to apply discount
	private double bulkDiscount = 0.90;	//multiply to apply discount
	private int numSeatsSelected = 0;	// number of seats user picks
	
	private int numSeatsRemaining; // optional
	
	/* Creates pop-up to confirm purchase total*/
	private void displayPrice(){
		if(isVip){
			finalPrice = currTotal * vipDiscount;
		}
		else if(isBulk){
			finalPrice = currTotal * bulkDiscount;
		}
		JFrame checkout = new JFrame("Verify Checkout Details ");
		checkout.setLayout(new GridLayout(2,1));
		JLabel headerLabel = new JLabel(" Your total due is: " );
		JButton statusLabel = new JButton();
		statusLabel.setText("Continue to enter paymet information");		
		checkout.add(headerLabel);
		checkout.add(statusLabel);
		checkout.setSize(350, 200);
		checkout.setVisible(true);
		
	}
	/* Totals up cost for seats selected before any discounts.*/
	private void addSeat(){
		currTotal += seats[x].getPrice();
	}
	/* Gets the event the user is attending*/
	private void getEvent(){
		
	}
	/* Determines if Bulk Purchase*/
	private void checkBulk(){
		if(numSeatsSelected > 4){
			isbulk = true;
		}
	}
	/* Checks if a valid VIP user is cheking out*/
	private void checkVip(){
		Scanner scnr = new Scanner(System.in);
		System.out.print("Enter VIP verification code: ");
		int ID = scnr.nextInt();
		for(int i = 0; i < vipMembers.length; i++){
			if(ID == vipMembers[i]){
				isVIP = true;
				break;
			}
		}
	}
	/* Creates movie theater layout*/
	private void createMovieTheater(){
		
	}
	/* Creates stage theatre layout*/
	private void createStageTheatre(){
		
	}
	/* Creates airline layout*/
	private void createAirline(){
		
	}
	/* When a seat is clicked and selected.*/
	private class ButtonClickListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
	
	/* Main method to execute calls*/
	public static void main(String[] args){
		
	}
}