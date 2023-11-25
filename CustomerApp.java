# Online-Movie-Ticket-Booking-System-Java
import java.text.*;
import java.io.*;
import java.util.*;

public class CustomersApp{
  public static void main (String[] args){
    Scanner tehaznis = new Scanner(System.in);
    Scanner tehaznis1 = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("#,###.00");
    
    //Step 1 : Declare array of object
    System.out.print("Enter size of array : ");
    int size = tehaznis.nextInt();
    int cntT = 0,cntR = 0, cntC = 0;
    
    BookTicket bt[] = new BookTicket[size];
    String[] title = new String [size];
    
    //Step 2 : Input(Customers)
    for(int i = 0; i < size; i++){
    System.out.print("Enter Customer's Name : ");
    String cn = tehaznis1.nextLine();
    System.out.print("Enter Customer's Phone Number : ");
    String cp = tehaznis1.nextLine();
    System.out.print("Enter Customer's Email : ");
    String ce = tehaznis1.nextLine();
    
      
    //Step 2 : Input(Movie)  
    System.out.print("Enter movie genre [Thriller, Romance, Comedy] : ");
    String gr = tehaznis1.nextLine();
    if (gr.equalsIgnoreCase("Thriller")){
      System.out.print("Enter Movie Title [The Conjuring, SCREAM, The Nun] :  ");
         title[i] = tehaznis1.nextLine();
         cntT++;
    }
    
    else if (gr.equalsIgnoreCase("Romance")){
      System.out.print("Enter Movie Title [Elemental, Love Again, What About Love] : ");
         title[i] = tehaznis1.nextLine(); 
           cntR++;
    }
    
    else if (gr.equalsIgnoreCase("Comedy")){
      System.out.print("Enter Movie Title [Lost City, Detective Chinatown, MR Bean's Holiday] : ");
       title[i] = tehaznis1.nextLine();
         cntC++; 
    }
            
    //Step 2 : Input(DateTime)
    System.out.print("Enter Day : ");
    String dy = tehaznis1.nextLine();
    System.out.print("Enter Month : ");
    String mh = tehaznis1.nextLine();
    System.out.print("Enter Year : ");
    String yr = tehaznis1.nextLine();
    System.out.print("Enter Time : ");
    String tm = tehaznis1.nextLine();
    
    
    
    //Step 2 : Input(BookTicket)
    System.out.print("Choose Seat Type [Adult OR Child ] : ");
    String st = tehaznis1.nextLine();
    System.out.print("Enter Quantity : ");
    int qt = tehaznis.nextInt();
    System.out.print("Enter Discount Code [True OR False] : ");
    boolean dc = tehaznis.nextBoolean();
    
    //Step 2 : Input(Movie)
    System.out.print("Enter Packages Type [A - 1 Popcorn & 1 Drink OR B - 2 Popcorns & 2 Drinks] : ");
    char pc = tehaznis1.nextLine().charAt(0);
    
    
    //Step 3 : Store onto object
    bt[i] = new Movie(cn,cp,ce,st,qt,dc,gr,pc,dy,mh,yr,tm);
    
    }//end input
    
    //Step 4 : Manipulation
    double[] pricePc = new double[size];
    double priceBt = 0.0;
    double totPrice = 0.0;  
    for(int i = 0; i < size; i++){
      if(bt[i] instanceof Movie){
        Movie mv = (Movie)bt[i];
          pricePc[i] = bt[i].discPrice() + mv.calculatePrice();
          totPrice += pricePc[i];
      }
    }
    //Manipulation for total payment
    for(int i = 0; i < size; i++){
      priceBt = bt[i].discPrice()  ;
    }
   
    //Step 1 : Exception Handling(Block Try)
    
    try {
      
      //Step 2 : Open ALL Files
      PrintWriter outMovie = new PrintWriter (new BufferedWriter(new FileWriter("Movie.txt")));
      PrintWriter outMovieGenre = new PrintWriter (new BufferedWriter(new FileWriter("MovieGenre.txt")));
       
        outMovie.println("----------------------YOUR PURCHASE DETAIL----------------------");
        outMovieGenre.println("----------------------THE MOST POPULAR GENRE----------------------");
        
        for(int i = 0; i < bt.length; i++){
          if(bt[i] instanceof Movie){
            
            Movie mv = (Movie)bt[i];
            outMovieGenre.println(bt[i].getDetail()+"\nGenre :" +mv.getGenre()+"\nMovie Title : "+title[i]);
            outMovie.println(mv.toString()+"\nPrice to pay: RM"+df.format(pricePc[i]));
            
          }
           outMovie.println("\n-----------------------------------------------");
        }
        
    	outMovie.println("\nTotal Payment for everyone : RM "+df.format(totPrice));
    	outMovieGenre.println("\n---------------------------------------------------"); 
      	
      	if (cntT > cntR && cntT > cntC){
            outMovieGenre.println("\nPopular Genre : THRILLER");
            
          }
         else if (cntR > cntT && cntR > cntC){
            outMovieGenre.println("\nPopular Genre : ROMANCE");
          }  
         else if (cntC > cntT && cntC > cntR){
            outMovieGenre.println("\nPopular Genre : COMEDY");
          }
       
      //Close ALL Files
      outMovie.close();
      outMovieGenre.close();
      
    }//End Try (Step 10 : End Block Try)
    
    //Step 11 : Exception handling (Catch Block)
    catch(FileNotFoundException fe){
      System.out.println(fe.getMessage());
    }
    
    catch(IOException iox){
      System.out.println(iox.getMessage());
    }
    
    catch(Exception e){
      System.out.println("Problem : "+e.getMessage());
    }
    
  }
}
