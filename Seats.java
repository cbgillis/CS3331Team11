import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Seats extends JButton
{
  private double price;
  private boolean available;
  
  public Seats(double p)//the only constructor for now
  {
    price = p;
    setEnabled(true);
  }
  
  public double getPrice()
  {
    return price;
  }
  
  public void setPrice(double price)
  {
    this.price = price;
  }
  
  public boolean getAvailable()
  {
    return available;
  }
  
  public void setAvailable(boolean available)
  {
    this.available = available;
  }
//  i commented this out cuz i wasn't sure whether to have the action listener here or in the main
//  i think it should be in the main...
//  public void actionPerformed(ActionEvent e)
//  {
//    e.getSource();
//    double seatValue = getPrice();
//    setAvailable(false);
//    setEnabled(false);
//  }
}
