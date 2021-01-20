package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String brackets) {
		char opening = '{';
		char closing = '}';
		Stack <Character> bracks = new Stack <Character>();
		//1. Use a for loop to iterate through your brackets String 
		for(int i = 0; i<brackets.length(); i++) {
    			//2.  If the current character is an '{'
				if(brackets.charAt(i)==opening) {
        			//3.  Push an '{' onto the stack 
					bracks.push(brackets.charAt(i));
				}
    			//4.  else if the character is a '}'
				else if(brackets.charAt(i)==closing) {
        			//6.  if the stack is empty (i.e. there is no matching opening bracket)
					if(bracks.isEmpty()) {
            				//7.  return false 
							return false;
					}
        			//5.  Pop a character from the stack
					bracks.pop();
				}
		}
		//8.  if the stack is not empty (i.e. there were too many opening brackets)
		if(!bracks.isEmpty()) {
    			//9. return false 
				return false;
		}
		//10. else (i.e. everything matched correctly)
		else {
    			//11. return true 
				return true;
		}
	}
}
