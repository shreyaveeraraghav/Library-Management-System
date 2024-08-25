 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.ResultSet;
 import java.sql.Statement;
 import javax.swing.JButton;
 import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JTextField;
 class Book extends JFrame implements ActionListener
 {
    JButton update;
    JTextField n1,r1,t1,t2,t3,t4;
    JLabel heading,n2,p1,a1,b1,c1,d1,r2;
 Book()
    {
       super("Shreya Sunil 52");
        update=new JButton("UPDATE");
        heading= new JLabel("LIBRARY");
        n2= new JLabel("Enter book to be updated:");
        p1= new JLabel("Enter new name of the book:");
        r2= new JLabel("Updated Details:");
        a1= new JLabel("Id:");
        b1= new JLabel("Book Name:");
        c1= new JLabel("Author:");
        d1= new JLabel("Price");
        n1=new JTextField(10);
        r1=new JTextField(10);
        t1=new JTextField(10);
        t2=new JTextField(10);
        t3=new JTextField(15);
        t4=new JTextField(10);
       add(heading);
        add(n2);
        add(p1);
       add(a1);
        add(b1);
        add(c1);
        add(d1);
        add(update);
        add(n1);
        add(r1);
        add(r2);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        setLayout(null);
        update.setBounds(150,120,250,30);
        n2.setBounds(20,40,210,20);
        n1.setBounds(20,70,210,20);
        p1.setBounds(320,40,220,20);
        r1.setBounds(320,70,220,20);
        a1.setBounds(150,190,100,20);
        t1.setBounds(150,220,150,20);
       b1.setBounds(150,270,100,20);
        t2.setBounds(150,300,150,20);
       c1.setBounds(150,330,100,20);  
        t3.setBounds(150,360,150,20);
        d1.setBounds(150,400,100,20);
        t4.setBounds(150,430,100,20);
        r2.setBounds(150,160,200,20);
        heading.setBounds(250,5,150,30);
        setSize(580,600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        update.addActionListener(this);
    }
    {
       public void actionPerformed(ActionEvent ae)
        Object source=ae.getSource();
        String str1,str2;
       try
         {
           int numrows=0,cnt;
           str1=n1.getText();
           str2=r1.getText();
           Class.forName("com.mysql.cj.jdbc.Driver");
 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306                  
/Library","root","password");
           Statement st=con.createStatement();
           String q="update Books set name ='"+str2+"' where name='"+str1+"'";
           cnt=st.executeUpdate(q);
           Statement stm=con.createStatement();
           String qry="select * from Books";
           ResultSet rs=stm.executeQuery(qry);
           System.out.println("Shreya Sunil 52");
           if(source==update)
           {
           if(cnt!=0)
           {
           while(rs.next()==true)
           {
             if(rs.getString(2).equalsIgnoreCase(str2)==true)
              {
              }
                  t1.setText(" "+rs.getInt(1));
                  t2.setText(" "+rs.getString(2));
                 t3.setText(" "+rs.getString(3));
                  t4.setText(" "+rs.getDouble(4));
                  break;
              numrows++;
            }
          }
             if(numrows>0)
           {
           }
               System.out.println(numrows+"rows retrieved 1");
           else
           {
           }
               System.out.println("Data not found");
           rs.close();
           stm.close();
           st.close();
           con.close();
        }
      }
    catch(ClassNotFoundException e)
      {  System.out.println(e);
      }
   catch(Exception e)
      {  System.out.println(e);
      }
     }
    public static void main(String args[])
    { Book obj=new Book();
    }
 }
