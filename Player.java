package tictactoe;

public class Player {
	private String name;
	 private char symbol;
	public Player(String name,char symbol){
		 setName(name);
		 setsymbol(symbol);
	 }
	 public void setName(String name) {
		 if(!name.isEmpty()) {
			 this.name=name;
		 }
	 }
	 public String getName() {
		 return this.name;
	 }
	 public void setsymbol(char symbol) {
		 if(symbol!='\0')
			 this.symbol=symbol;
	 }
	 public char getsymbol() {
		 return this.symbol;
	 }
	 

}
