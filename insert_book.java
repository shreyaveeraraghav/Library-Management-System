import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;
 import javax.swing.*;
 import java.awt.event.*;
 class Minipro extends JFrame implements ActionListener
 {
 JButton insert;
 JTextField i,n,a,p,c;
 JLabel heading,id,nam,au,pri,cou;
 Minipro()
 {
 super("Library Management:Rhea john 30");
 insert=new JButton("Insert");
 heading= new JLabel("Library Management");
 id= new JLabel("Enter ID");
 nam= new JLabel("Name");
 au= new JLabel("Author");
 pri= new JLabel("Price");
 cou= new JLabel("Count");
 i=new JTextField(10);
 n=new JTextField(10);
 a=new JTextField(10);
 p=new JTextField(10);
 c=new JTextField(10);
 add(heading);
 add(id);
 add(nam);
 add(au);
 add(pri);
 add(cou);
 add(insert);
 add(i);
 add(n);
 add(a);
 add(p);
 add(c);
 setLayout(null);
 insert.setBounds(200,40,150,175);
 id.setBounds(10,40,100,20);
 i.setBounds(10,60,150,20);
nam.setBounds(10,100,100,20);
 n.setBounds(10,120,150,20);
 pri.setBounds(10,160,100,20);
 p.setBounds(10,180,150,20);
 cou.setBounds(10,220,100,20);
 c.setBounds(10,240,150,20);
 au.setBounds(10,280,100,20);
 a.setBounds(10,300,150,20);
 heading.setBounds(20,10,150,20);
 setSize(500,400);
 setVisible(true);
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 insert.addActionListener(this);
 }
 public void actionPerformed(ActionEvent ae)
 {
 int idc,count,rs;
 String name,authorname;
 double price;
 try{
 idc=Integer.parseInt(i.getText());
 count=Integer.parseInt(c.getText());
 name=n.getText();
 price=Double.parseDouble(p.getText());
 authorname=a.getText();
 Class.forName("com.mysql.cj.jdbc.Driver");
 Connection
 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","password");
 Statement stm=con.createStatement();
 String qry="insert into
 Books(id,name,author,price,count)values("+idc+",'"+name+"','"+authorname+"',"+price+","+count
 +")";
 rs=stm.executeUpdate(qry);
 }
 catch(ClassNotFoundException e)
 {
System.out.println(e);
 }
 catch(Exception e)
 {
 System.out.println(e);
 }
 }
 public static void main(String args[])
 {
 Minipro obj=new Minipro();
 }
 }
