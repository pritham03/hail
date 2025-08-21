import java.awt.*;
import java.awt.event.*;
public class Calculator extends Frame implements ActionListener
{
 TextField display;
 String operator="";
 double num1,num2,result;
 public Calculator()
 {
  display=new TextField();
  display.setEditable(false);
  setLayout(new BorderLayout());
  Panel buttons=new Panel(new GridLayout(4,4));
  String[] buttonLabels={"7","8","9","/","4","5","6","*","1","2","3","-","C","0","=","+"};
  for(String label:buttonLabels)
  {
   Button button=new Button(label);
   button.addActionListener(this);
   buttons.add(button);
  }
  add(display,BorderLayout.NORTH);
  add(buttons,BorderLayout.SOUTH);
  addWindowListener(new WindowAdapter()
  {
   public void windowClosing(WindowEvent e)
   {
    System.exit(0);
   }
  });
  setTitle("Calculator");
  setSize(300,300);
  setVisible(true);
 }
 public void actionPerformed(ActionEvent e)
 {
  String command=e.getActionCommand();
  if("0123456789".contains(command))
  {
   display.setText(display.getText()+command);
  }
  else if("+-*/".contains(command))
  {
   num1=Double.parseDouble(display.getText());
   operator=command;
   display.setText("");
  }
  else if(command.equals("="))
  {
   num2=Double.parseDouble(display.getText());
   switch(operator)
   {
    case "+":result=num1+num2;
             break;
    case "-":result=num1-num2;
             break;
    case "*":result=num1*num2;
             break;
    case "/":result=num2!=0?num1/num2:Double.NaN;
             break;
   }
   display.setText(String.valueOf(result));
  }
  else if(command.equals("C"))
  {
   display.setText("");
   num1=num2=result=0;
   operator="";
  }
 }
 public static void main(String[] args)
 {
  new Calculator();
 }
}