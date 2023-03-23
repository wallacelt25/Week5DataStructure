import java.util.*;

public class InfixtoPostfix
{
  public static int priority(char ch)
  {
  if(ch=='+' || ch=='-')
  return 1;
  else if(ch=='*' || ch=='/')
  return 2;  
 
  return 0;
}

public static String IconverttoP(String exp)
{
 Stack<Character> ops = new Stack<>();
 Stack<String> postfix = new Stack<>();
 
 for(int i=0;i<exp.length();i++)
 {
  char ch=exp.charAt(i);        
 
  if(ch=='(')
   ops.push(ch);
 
  else if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z'))
   postfix.push(ch+"");
 
  else if(ch==')')
  {
   while(ops.peek()!= '(')
   {
       
    char op = ops.pop();
 
    String one = postfix.pop();          
    String two = postfix.pop();
 
    String new_postFix = two+one+op;  
 
 postfix.push(new_postFix);     
   }
 
   ops.pop();    
  }
 else if(ch=='+' || ch=='-' || ch== '*' || ch== '/')
  {
   while(ops.size()>0 && ops.peek()!='(' && priority(ch) <= priority(ops.peek()))
   {
   char op = ops.pop();
 
   String one = postfix.pop();
   String two = postfix.pop();
 
   String new_postFix = two+one+op;
 
   postfix.push(new_postFix);
   }
 
  ops.push(ch);
  }
 }
 while(ops.size()>0)
 {
  char op = ops.pop();
 
  String one = postfix.pop();
  String two = postfix.pop();
 
  String new_postFix = two+one+op;
 
  postfix.push(new_postFix);
  }
 
  return postfix.pop();  
}
public static void main(String args[])
{
  //Uppercase
  String infixExpression = "B*(C-D)/E+F";
  System.out.println("The Infix Expression is: "+infixExpression);
  String result = IconverttoP(infixExpression);
  System.out.println("The Postfix of the given Infix Expression is: "+result);
  System.out.println();
  
  //Lowercase
  infixExpression = "b*(c-d+e)/f";
  System.out.println("The Infix Expression is: "+infixExpression);
  result = IconverttoP(infixExpression);
  System.out.println("The Postfix of the given Infix Expression is: "+result);
}
}
