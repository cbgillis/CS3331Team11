import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Seats extends JButton
{
  private double price;
  private boolean available;
  
  public Seats(double p)
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
//  
//  public void actionPerformed(ActionEvent e)
//  {
//    e.getSource();
//    double seatValue = getPrice();
//    setAvailable(false);
//    setEnabled(false);
//  }
}