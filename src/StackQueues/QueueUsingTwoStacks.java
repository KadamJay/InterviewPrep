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

  public QueueUsingTwoStacks() {
      pushStack = new Stack<>();
      popStack = new Stack<>();
  }
  
  public void push(int x) {
      pushStack.push(x);
  }
  
  public int pop() {
      if(!popStack.isEmpty()) {
          return popStack.pop();
      }else{
          while(!pushStack.isEmpty()){
              popStack.push(pushStack.pop());
          }
          return popStack.pop(); 
      }
  }
  
  public int peek() {
      if(!popStack.isEmpty()){
          return popStack.peek();
      }else{
          while(!pushStack.isEmpty()){
              popStack.push(pushStack.pop());
          }
          return popStack.peek(); 
      }
  }
  
  public boolean empty() {
      if(pushStack.isEmpty() && popStack.isEmpty()){
          return true;
      }else{
          return false;
      }
  }
}

/**
* Your QueueUsingTwoStacks object will be instantiated and called as such:
* QueueUsingTwoStacks obj = new QueueUsingTwoStacks();
* obj.push(x);
* int param_2 = obj.pop();
* int param_3 = obj.peek();
* boolean param_4 = obj.empty();
*/