import java.util.*;
 class Sudoku {
	 public boolean isSafe(char[][] board,int row,int col,int number) {
		 for(int i=0;i<9;i++) {
			 if(board[i][col]==(char)(number+'0')) {
				 return false;
			 }
			 if(board[row][i]==(char)(number+'0')) {
				 return false;
			 }
			 int sr=(row/3)*3;
			 int sc=(col/3)*3;
			 for(  i=sr;i<sr+3;i++) {
				 for(int j=sc;j<sc+3;j++) {
					 if(board[i][j]==(char)(number+'0')) {
						 return false;
					 }
				 }
				 
			 }
		 }
		 return false;
		 
	 }
	
	 public boolean helper(char[][] board,int row,int col) {
		 int nrow=0;
		 int ncol=0;
		if(col!=board.length-1) {
			ncol=col+1;
			nrow=row;
		}
		if(col==board.length-1) {
			ncol=0;
			nrow=row+1;
			
		}
		//check wheather the block is blank or not
		if(board[row][col]=='.') {
			if(helper(board,nrow,ncol)) {
				return true;
			}
			
		}
		else {
			for(int i=0;i<=9;i++) {
				if(isSafe(board,nrow,ncol,i)) {
					board[row][col]=(char)(i+'0');
					if(helper(board,nrow,ncol)) {
						return true;
					}
					else {
						board[row][col]='.';
					}
				}
				
			}
		}
		return false;
	 }
	 public void solveSodoku(char[][] board) {
		 helper(board,0,0);
	 }
	 public static void permut(String s,String answer) {
		 if(s.length()==0) {
			 System.out.println(answer);
			 return;
		 }
		 for(int i=0;i<s.length();i++) {
			 char ch=s.charAt(i);
			 String lef_str=s.substring(0,i);
			 String rig_str=s.substring(i+1);
			 String rest=lef_str+rig_str;
			 permut(rest,answer+ch);
			 
		 }
	 }
	
public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);
  String answer="";
  
  System.out.println("enter the strnig");
  String s=sc.nextLine();
  
  String sn=s.substring(0,1);
  String sn1=s.substring(1+1);
  
//  for(int i=0;i<s.length();i++) {
//	  char ch=s.charAt(i);
//    sn=s.substring(0,i);
//    sn1=s.substring(i+1);
//  }
  System.out.println(sn);
  System.out.println(sn1);
//  System.out.println("answer of the String is");
//  permut(s,answer);
}
}
 
