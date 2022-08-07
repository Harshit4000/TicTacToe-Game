package tictactoe;
import java.util.Scanner;


public class tictactoemanager {
	 private Player player1,player2;
	 private Board board;
	 public static void main(String args[]) {
		 tictactoemanager t= new tictactoemanager();
		 t.startgame();
	 }
	 public void startgame() {
		 // Player input
		 Scanner s= new Scanner (System.in);
		 player1=takePlayerinput(1);
		 player2=takePlayerinput(1);
		 while(player1.getsymbol()==player2.getsymbol()) {// this condition is taken because
			 System.out.println("Symbol Aready taken! please take another symbol!");
		 }
		 char symbol= s.next().charAt(0);
		 player2.setsymbol(symbol);
//		 crate Board
		 board= new Board(player1.getsymbol(),player2.getsymbol());
//		 conduct game
		 boolean player1turn=false;
		 int status=Board.INCOMPLETE;
		 while(status==Board.INCOMPLETE || status==Board.INVALID) {// condition is taken such because if player1 wins or player2 wins or if ut get draw the we have stop game;
			 if(player1turn) {
			System.out.println("Player1 -"+ player1.getName()+"'s turn");
			System.out.println("Enter x cordinate: ");
			int x= s.nextInt();
			System.out.println("Enter y cordinate: ");
			int y= s.nextInt();
			status= board.move(player1.getsymbol(),x,y);// this function  has been made in board class to make move on board and is returned into a status variable with defined conventions for status
			if(status!=Board.INVALID) {// it means one player has played its chance
					player1turn=false;
					board.print();
			}
			else
			{
				System.out.println("Invalid move! Try again!");
			}
			 }else {
				 System.out.println("Player2 -"+ player2.getName()+"'s turn");
					System.out.println("Enter x cordinate: ");
					int x= s.nextInt();
					System.out.println("Enter y cordinate: ");
					int y= s.nextInt();
					 status= board.move(player2.getsymbol(),x,y);// this function  has been made in board class to make move on board and is returned into a status variable with defined conventions for status
					if(status!=Board.INVALID) {
					 
					
						player1turn=true;
						board.print();
					}else {
						System.out.println("Invalid move! Try again!");
					}
					
				 
			 }
		 }
		 
		 
	 
	 if(status == Board.PLAYER1_WINS){
			System.out.println("Player 1 - " + player1.getName() +" wins !!");
		}else if(status == Board.PLAYER2_WINS){
			System.out.println("Player 2 - " + player2.getName() +" wins !!");
		}else{
			System.out.println("Draw !!");
		}
	}
	 private Player takePlayerinput(int num) {
		 Scanner s= new Scanner(System.in);
		 System.out.println("Enter Player"+ num+ " name: ");
		 String name= s.nextLine();
		 System.out.println("Enter Player"+ num+ " symbol: ");
		 char symbol=s.next().charAt(0);
		 Player p= new Player(name,symbol);
		 return p;
		 
	 }
	 

}
