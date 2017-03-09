import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.util.Scanner; 

public class EventSeatingMap{
	
	 private boolean isVIP = false;		// true if VIP transaction
	 private boolean isBulk = false;		// true if numSeats > 4
	 private int[] vipMembers = {159,7913,753};	//dummy values of VIP members
	 private String title = "Seat Selection";	//title of seat selection window
	 private double currTotal = 5000;	// total as seats are being selected
	 private double finalPrice = 4500;	// absolute final price
	 private double vipDiscount = 0.80;	//multiply to apply discount
	 private double bulkDiscount = 0.90;	//multiply to apply discount
	 private int numSeatsSelected = 0;	// number of seats user picks
	 private boolean isMovie = false;
	 private boolean isTheatre = false;
	 private boolean isAirline = false;
	 private Seat[] movieSeats = new Seat[60];
	 private Seat[][] airSeats;
	 private Scanner scnr = new Scanner(System.in);
	
	 int numSeatsRemaining; // optional
	
	/* Creates pop-up to confirm purchase total*/
	private void displayPrice(){
		if(isVIP){
			finalPrice = currTotal * vipDiscount;
		}
		else if(isBulk){
			finalPrice = currTotal * bulkDiscount;
		}
		JFrame checkout = new JFrame("Verify Checkout Details ");
		checkout.setLayout(new GridLayout(4,1));
		
		JLabel headerLabel = new JLabel("Cost of all seats: $ " + currTotal);
		JLabel savingsLabel = new JLabel("You saved: $" + (currTotal - finalPrice));
		JLabel finPriceLabel = new JLabel("Total Amount Due is: $" + finalPrice);
		JButton statusLabel = new JButton();
		statusLabel.setActionCommand("checkout");
		statusLabel.addActionListener(new ButtonClickListener());
		statusLabel.setText("Continue to Enter Paymet Information");		
		checkout.add(headerLabel);		
		checkout.add(finPriceLabel);
		checkout.add(savingsLabel);
		checkout.add(statusLabel);
		checkout.setSize(350, 200);
		checkout.setVisible(true);
		//checkout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	/* Totals up cost for seats selected before any discounts.*/
	private void addSeat(int index){
		if(isMovie){
			currTotal += movieSeats[index].getPrice();
		}
		else if(isTheatre){
			
		}
		else if(isAirline){
			int row = 0;
			while(index >= airSeats[0].length){
				index -= airSeats[0].length;
				row++;
			}
			currTotal +=airSeats[row][index].getPrice();
		}
	}
	/* Gets the event the user is attending*/
	private void getEvent(){
		String[] choices = { "Movie Theater", "Stage Theatre", "Airline" };
		String input = (String) JOptionPane.showInputDialog(null, "Select the event you want to purchase seats for...",
        "Event Seating Map", JOptionPane.QUESTION_MESSAGE, null, // Use   // default  // icon
        choices, // Array of choices
        choices[2]); // Initial choice
    System.out.println(input);
		
		if(input == "Movie Theater"){
			createMovieTheater();
		}
		else if(input == "Stage Theatre"){
			createStageTheatre();
		}
		else if(input == "Airline"){
			createAirline();
		}
		else{
			System.out.println("Choice not recognized / menu option not available.");
		}		
	}
	/* Determines if Bulk Purchase*/
	private void checkBulk(){
		if(numSeatsSelected > 4){
			isBulk = true;
		}
	}
	/* Checks if a valid VIP user is cheking out*/
	private void checkVip(){
		//Scanner scnr = new Scanner(System.in);
		System.out.print("Enter VIP verification code: ");
		int ID = scnr.nextInt();
		for(int i = 0; i < vipMembers.length; i++){
			if(ID == vipMembers[i]){
				isVIP = true;
				System.out.println("Welcome back valued customer.");
				break;
			}
		}
	}
	/* Creates movie theater layout*/
	private void createMovieTheater(){
		isMovie = true;
		int seatCounter = 0;							//Counter for the seats.
		Seat[] seats = new Seat[50];						//The array to keep the seats.
		JPanel panel = new JPanel();						//The panel for the seats.
		JPanel screen = new JPanel();						//The panel for the screen.
		JLabel sc = new JLabel("SCREEN");					//The label for the screen.
		JFrame frame = new JFrame("Movie Theater " + title);			//The main frame for the layout.
		frame.setSize(900, 900);
		panel.setLayout(new GridLayout(13, 5));
		
		//For loop to add the seats to the panel and the space between the seats.
		for(int i = 0; i < 60; i++){
			if(i < 15){				//The cheapest seats available 0-14.
				seats[seatCounter] = new Seat(5.00, "A" + i);
				movieSeats[seatCounter] = seats[seatCounter];
				seats[seatCounter].setText(seats[seatCounter].getSeatName());
				seats[seatCounter].setActionCommand(Integer.toString(seatCounter));
				seats[seatCounter].addActionListener(new ButtonClickListener());
				panel.add(seats[seatCounter++]);
			}
			if(i >= 15 && i < 20){			//Space between cheapest seats and the more expensive seats.
				panel.add(new JLabel());
			}
			if(i >= 20 && i < 45){			//The more expensive seats 15-40.
				seats[seatCounter] = new Seat(8.00, "B" + i);
				seats[seatCounter].setText(seats[seatCounter].getSeatName());
				seats[seatCounter].setActionCommand(Integer.toString(seatCounter));
				seats[seatCounter].addActionListener(new ButtonClickListener());
				movieSeats[seatCounter] = seats[seatCounter];
				panel.add(seats[seatCounter++]);
			}
			if(i >= 45 && i < 50){			//Space between more expensive seats and the most expensive seats.
				panel.add(new JLabel(""));
			}
			if(i >= 50 && i < 60){			//The most expensive seats 40-49.
				seats[seatCounter] = new Seat(10.00, "C" + i);
				seats[seatCounter].setText(seats[seatCounter].getSeatName());
				seats[seatCounter].setActionCommand(Integer.toString(seatCounter));
				seats[seatCounter].addActionListener(new ButtonClickListener());
				movieSeats[seatCounter] = seats[seatCounter];
				panel.add(seats[seatCounter++]);
			}
		}
		//movieSeats = seats;
		sc.setForeground(Color.red);    				//Set the color of the screen string.
		sc.setFont(new Font("Verdana", 1, 100));
		screen.setBorder(new LineBorder(Color.black));			//Border line around the panel for the screen.
		screen.add(sc);
		frame.add(panel);
		frame.add(screen, BorderLayout.SOUTH);				//Add the screen to the bottom of the frame.
		frame.add(new JPanel(), BorderLayout.EAST);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	/* Creates stage theatre layout*/
	private void createStageTheatre(){
		isTheatre = true;
		
	}
	/* Creates airline layout*/
	private void createAirline(){
		isAirline = true;
		JFrame planeLayout = new JFrame();
		JPanel panel = new JPanel();
		JPanel front = new JPanel();
		JLabel fr = new JLabel("Front", SwingConstants.CENTER);//used to show where the front is
		Seat[][] seats = new Seat[6][12];//creates a 2d array of uninitialized seat buttons
		planeLayout.setTitle("Airplane " + title);
      		planeLayout.setVisible(true);
      		panel.setLayout(new GridLayout(6,12));
      		planeLayout.setSize(900,400);
      		planeLayout.setResizable(true);	

		for(int i = 0; i < 6; i++){
        		for(int j = 0; j < 12; j++)
     		 {
       			 if(j < 4 && i != 3){
				seats[i][j] = new Seat(200.00, "A" + i+j + "");//first class
				   seats[i][j].setActionCommand(Integer.toString(i+j));
				   seats[i][j].addActionListener(new ButtonClickListener());
				   seats[i][j].setText(seats[i][j].getSeatName());
				//seats[i][j].addActionListener(this);
				panel.add(seats[i][j]);				
				}	

			if((j >= 4 && j < 8) && i != 3){
				seats[i][j] = new Seat(150.00, "B" + i+j + "");//business
				seats[i][j].setActionCommand(Integer.toString(i+j));
				seats[i][j].addActionListener(new ButtonClickListener());
				seats[i][j].setText(seats[i][j].getSeatName());
				//seats[i][j].addActionListener(this);
				panel.add(seats[i][j]);
				}
				
			if(j >= 8 && i != 3){
				seats[i][j] = new Seat(100.00, "C" + i+j + "");//economy
				//seats[i][j].addActionListener(this);
				seats[i][j].setActionCommand(Integer.toString(i+j));
				seats[i][j].addActionListener(new ButtonClickListener());
				seats[i][j].setText(seats[i][j].getSeatName());
				panel.add(seats[i][j]);
				}

			if(i == 3){
				seats[i][j] = new Seat(0, "");//emulates the row between seats on a plane
				seats[i][j].setEnabled(false);
				seats[i][j].setAvailable(false);
				seats[i][j].setBorderPainted(false);
				panel.add(seats[i][j]);
				}				
			}
			airSeats = seats;
			planeLayout.add(panel);
      			planeLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		fr.setFont(new Font("Times New Roman", 1, 12));
		front.add(fr);
		planeLayout.add(front, BorderLayout.WEST);
	}		
	
	/* When a seat is clicked and selected.*/
	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if(command == "checkout"){
			//	System.CLOSE;
			}
			int i = Integer.parseInt(command);
			numSeatsSelected++;
			if(numSeatsSelected >4){
				isBulk = true;
			}
			addSeat(i);
			System.out.println(currTotal);			
		}		
	}
	/* Main method to execute calls*/
	public static void main(String[] args){
		EventSeatingMap map = new EventSeatingMap();
		map.checkVip();
		map.getEvent();
		map.displayPrice();
		
	}
}
