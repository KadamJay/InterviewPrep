package StackQueues;

/**
 * @author jakadam on 2019-12-19
 */

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 */

import java.util.*;

class QueueUsingTwoStacks {
  Stack<Integer> pushStack;
  Stack<Integer> popStack;

  public QueueUsingT
    pushStack = new Stack<>();
    popStack = new Stack<>();
  }

  public void push(int x) {
    pushStack.push(x);
  }

  public int pop() {
    if (!popStack.isEmpty()) {
      return popStack.pop();
    } else {
      while (!pushStack.isEmpty()) {
        popStack.push(pushStack.pop());
      }
      return popStack.pop();
    }
  }

  public int peek() {
    if (!popStack.isEmpty()) {
      return popStack.peek();
    } else {
      while (!pushStack.isEmpty()) {
        popStack.push(pushStack.pop());
      }
      return popStack.peek();
    }
  }

  public boolean empty() {
    if (pushStack.isEmpty() && popStack.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }
}


 /**
  *
             n 
 
             Time: O( 1 ) - 
  *
  * Video- https://www.youtube.com/watch?v=Wg8IiY1LbII
 * 
 *
 * 
 * 
 *  a set of operations.
 *
 * The definition of ADT only mentions what operations are to be performed but not how these
 * operations will be implemented. It does not specify how data will be organized in memory and what
 * algorithms will be used for implementing the operations. It is called “abstract” because it gives
 * an implementation-independent view. The process of providing only the essentials and hiding the
 * details is known as abstraction.
 * 
 *
 **/

 * 
 * 
 * 
 * 