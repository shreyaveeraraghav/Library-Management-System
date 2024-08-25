import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
class Borrow_books extends JFrame implements ActionListener
{
 JButton disp;
 JTextField book,auth,id,pr,num;
 JLabel heading,head,head1,head2,head3,head4,status;

Borrow_books()
 {
 super("LIBRARY MANAGEMENT SYSTEM-SHREYA VEERARAGHAV 53");
 disp=new JButton("Submit");
 heading=new JLabel("Enter book to be borrowed");
 head=new JLabel("Details of borrowed book");
 head1=new JLabel("Author");
 head2=new JLabel("Book ID");
 head3=new JLabel("Price");
 head4=new JLabel("Number of books left");
 status=new JLabel(" ");
 book=new JTextField(20);
 auth=new JTextField(20);
 id=new JTextField(10);
 pr=new JTextField(10);
 num=new JTextField(20);
 add(heading);
 add(head);
 add(head1);
 add(head2);
 add(head3);
 add(head4);
 add(status);
 add(disp);
 add(book);
 add(auth);
 add(id);
 add(pr);
 add(num);
 
 setLayout(null);
 heading.setBounds(240,20,200,20);
 book.setBounds(250,60,150,20);
 disp.setBounds(270,100,100,50);
 status.setBounds(230,170,250,20);
 head.setBounds(240,210,250,20);
 head1.setBounds(220,250,150,20);
 auth.setBounds(220,290,200,20);
 head2.setBounds(220,330,150,20);
 id.setBounds(220,370,200,20);
 head3.setBounds(220,410,150,20);
 pr.setBounds(220,450,200,20);
 head4.setBounds(220,490,150,20);
 num.setBounds(220,530,200,20);
 
 setSize(660,660);
 setVisible(true);
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 disp.addActionListener(this);
 }
 
public void actionPerformed(ActionEvent ae)
 {
   try
    {
     int c,n,flag=0;
     String bn;
     bn=book.getText();
     Class.forName("com.mysql.jdbc.Driver");
     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","password");
     Statement stm=con.createStatement();
     Statement st=con.createStatement();
     String qry1="update Books set count=count-1 where name='"+bn+"'";
     c=st.executeUpdate(qry1);
     String qry="select * from Books";
     ResultSet rs=stm.executeQuery(qry);
     if(c!=0)
       {
        while(rs.next()==true)
             {
                if((rs.getString(2).equalsIgnoreCase(bn))==true)
                   {
                     n=rs.getInt(5);
                     flag=1;
                     if(n<0)
                     {
                      status.setText("Status:No book available now");  
                     }
                     else
                     {
                     status.setText("Status:Request successful");
                     auth.setText(rs.getString(3));
                     id.setText(Integer.toString(rs.getInt(1)));
                     pr.setText(Double.toString(rs.getDouble(4)));
                     num.setText(Integer.toString(rs.getInt(5)));
                     break;
                     }
                   }
                
            }
       }
    if(flag==0)
       {
        status.setText("Status:Specified book not present");

       } 
     rs.close();
     stm.close();
     st.close();
     con.close();
    }
 catch(ClassNotFoundException e)
     {
     System.out.println(e);
     }
 catch(SQLException e)
     {
     System.out.println(e);
     }
 
 }
 public static void main(String args[])
 {
  Borrow_books obj=new Borrow_books();
 }
}
