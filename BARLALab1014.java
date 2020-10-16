// CSUN Fall 2020   COMP182-15
//  xxxxxLab1014.java
import java.util.*;
import java.io.*;

public class BARLALab1014 {
	// class Variables
	private int n, count;
	String arr[];

	PrintStream prt = System.out;

	// xxxxxLab1014 Constructor
	BARLALab1014(int k){
		count = 0;
		n =  k;
		//   Allocate Space for array
		arr = new String[n+1];// index 0 is not used
		prt.printf("\tCreating array of size %2d:",n);
	} // end constructor

	//insert x at position p, for successful
	//insertion: list should not be full(count=n) and
	//1 <= p <= count+1
	public int insert(String x,  int p){
		int i;
		prt.printf("\n  Insert %10s at position %2d:", x, p);
		if (count == n || p < 1 || p > count+1)
			return 0;  // invalid insertion
		//shift array elements from position p to right
		for (i = count ; i >= p ; i--)
			arr[i+1] = arr[i];
		// end for

		arr[p] = x;   // insert x at position p
		count++; // increment no. of elements.
		return 1; // successful insertion
	} // end insert

	//insert x in a sorted list(array)
	public int insertsorted(String x){
		prt.printf("\nInsert %10s in a sorted list: ", x);
		int i,j;
		for (i = count+1; count<= n ; i++) {
			arr[i] = x;
			j = i - 1;
			while(j>=1 && arr[j].compareTo(x)>0) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = x;
			count++;
			return 1;
		}
		return 0;
	} // end insertsorted


	// sequential search for x in the list
	// if successful return position of x in the
	// list otherwise return 0;
	public int search(String x){
		int i;
		prt.printf("\nSearch for  %10s:", x);
		for (i = 1; i <= count; i++){
			if(arr[i].equals(x)) {
				return i;
			}
		}
		return 0;
	} // end search

	// print list elements formatted
	public void printlist(){
		int i;
		prt.print("\n\tList contents: ");
		for (i = 1; i <= count; i++)
			prt.printf("%s, ", arr[i]);
		// enf for
	} // end printlist

	public static void main(String args[]) throws Exception{
		int j, m, k, p, s; String x;
		try{
			// open input file
			Scanner inf = new Scanner(System.in);
			// read list size
			k = inf.nextInt();
			// Create a List of type Integer of size n
			BARLALab1014 lst = new BARLALab1014(k);

			//read no. of elements to insert
			m = inf.nextInt();
			System.out.printf("\n\tInsert %2d elements in the list.", m);
			for(j = 1; j <= m; j++){
				x = inf.next();   // read x
				//p = inf.nextInt();  // read position
				//s = lst.insert(x, p);//insert x at position p
				s = lst.insertsorted(x);//insert x in a sorted list

				if (s == 1)
					System.out.printf(" Successful insertion.");
				else
					System.out.printf(" Can not insert.");
			} // end for
			lst.printlist(); // print array elements

			//read no. of Strings to search in the list
			s = inf.nextInt();
			System.out.printf("\n\tSearch %d elements in the list.", s);
			for(j = 1; j <= s; j++){
				x = inf.next();   // read next String
				p = lst.search(x);   //delete position p
				if (p > 0)
					System.out.printf(" found at position %d", p);
				else
					System.out.printf(" not found.");
			}// end for

			inf.close();   // close input file
		} catch (Exception e) {
			System.out.print("\nException " + e + "\n");}
	} // end main
} // end class xxxxxLab1014