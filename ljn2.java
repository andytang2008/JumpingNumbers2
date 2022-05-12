// Finds and prints all jumping numbers smaller than or
// equal to x.
import java.util.*;
import java.lang.*;
import java.io.*;

class ljn2 //Largest jumping numbers
{

    // Prints all jumping numbers smaller than or equal to x starting
    // with 'num'. It mainly does BFS starting from 'num'.
    public void jumpingNumber(int x, int num)
    {
        // Create a queue and enqueue 'i' to it
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(num);



        // Do BFS starting from i
        while (!q.isEmpty()) {
            num = q.peek();  //get the value of queue head which is first in first out.
            q.poll();
            if (num <= x) {
                System.out.print("Number="+num + " ");
                int last_digit = num % 10;

                // If last digit is 0, append next digit only
                if (last_digit == 0) {
                    q.add((num * 10) + (last_digit + 1));
					printQueue(q,"*");
                }
				


                // If last digit is 9, append previous digit only
                else if (last_digit == 9) {
                    q.add((num * 10) + (last_digit - 1));
					printQueue(q,"^");
                }

                // If last digit is neither 0 nor 9, append both
                // previous and next digits
                else {
                    q.add((num * 10) + (last_digit - 1));
                    q.add((num * 10) + (last_digit + 1));
					printQueue(q,"#");
                }
            }
        }
    }
	
	public void printQueue(Queue<Integer> queue, String sign){
		for(Integer s : queue) { 
		  System.out.print("  "+sign+sign+s.toString()+"  ");
		}

	}

    // Prints all jumping numbers smaller than or equal to
    // a positive number x
    public void printJumping(int x)
    {
        System.out.println("0 ");

        for (int i = 1; i <= 9 && i <= x; i++) {
			System.out.println();
			System.out.println(" **The "+i+" time is running!** ");
            this.jumpingNumber(x, i);
			System.out.println();
        }
    }

    // Driver program
    public static void main(String[] args) throws IOException
    {
        int x = 105;
        ljn2 ljn = new ljn2();
        ljn.printJumping(x);
    }
}
