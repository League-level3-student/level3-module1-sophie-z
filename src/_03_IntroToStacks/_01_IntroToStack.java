package _03_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		//1. Create a Stack of Doubles
		//   Don't forget to import the Stack class
		Stack<Double> doubles = new Stack<Double>();
		//2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		for(int i = 0; i<100; i++) {
			double Random = new Random().nextDouble();
			doubles.push(Random);
		}
		//3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
		String answer1 = JOptionPane.showInputDialog("Enter a number between 0 and 100, inclusive.");
		String answer2 = JOptionPane.showInputDialog("Enter a different number between 0 and 100, inclusive.");
		//4. Pop all the elements off of the Stack. Every time a double is popped that is
		//   between the two numbers entered by the user, print it to the screen.) 
		int number1 = Integer.parseInt(answer1);
		int number2 = Integer.parseInt(answer2);
		int smaller = 0;
		int bigger = 0;
		if(number1<number2) {
			smaller = number1;
			bigger = number2;
		}
		else if(number1>number2) {
			smaller = number2;
			bigger = number1;
		}
		while(!doubles.isEmpty()) {
			Double popped = doubles.pop();
			if(popped>smaller && popped<bigger) {
				System.out.println("Integers between " + smaller + "and" + bigger + ": " + popped);
			}
		}
		
		
		//   EXAMPLE:
		//   NUM 1: 65
		//   NUM 2: 75
		
		//   Popping elements off stack...
		//   Elements between 65 and 75:
		//   66.66876846
		//   74.51651681
		//   70.05110654
		//   69.21350456
		//   71.54506465
		//   66.47984807
		//   74.12121224
	}
}
