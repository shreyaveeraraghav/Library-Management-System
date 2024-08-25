import java.sql.*;
 import javax.swing.*;
 import java.awt.event.*;
 class Project extends JFrame implements ActionListener
 {
    JButton find;
    JTextField i,n,a,p,c;
    JLabel heading,id,nam,au,pri,cou;
    Project()
    {
        super("Library Management: RENU LIJO");
        find=new JButton("Display");
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
        add(find);
        add(i);
        add(n);
        add(a);
        add(p);
        add(c);
        setLayout(null);
        find.setBounds(200,60,150,60);
        heading.setBounds(20,10,150,20);
        id.setBounds(10,50,150,20);
        i.setBounds(10,80,150,20);
        nam.setBounds(10,120,150,20);
        n.setBounds(10,150,150,20);
        au.setBounds(10,190,150,20);  
        a.setBounds(10,220,150,20);
        pri.setBounds(10,260,150,20);  
        p.setBounds(10,290,150,20);
        cou.setBounds(10,330,150,20);
        c.setBounds(10,360,150,20);
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        find.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
   {
        Object source=ae.getSource();
        int id,flag=0;
        String str;
        id=Integer.parseInt(i.getText());
        try
         {
           int numrows=0;
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection 
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","pass
 word");
           Statement stm=con.createStatement();
           String qry="select * from Books";
           ResultSet rs=stm.executeQuery(qry);
           System.out.println("renu lijo");
           while(rs.next())
           {
           if(source==find)
           {
              if((rs.getInt(1))==id)
              {
                n.setText(" "+rs.getString(2));
                a.setText(" "+rs.getString(3));
                p.setText(" "+rs.getDouble(4));
                c.setText(" "+rs.getDouble(5));
                flag=1;
                break;
              }
              numrows++;
           }
           }
           if(flag==0)
             {
              n.setText("not found");
                a.setText("not found");
                p.setText("not found");
                c.setText("not found");
              }
           if(numrows>0)
           {
               System.out.println(numrows+"rows retrieved 1");
           }
           else
           {
               System.out.println("Data not found");
           }
           rs.close();
           stm.close();
           con.close();
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
         Project obj=new Project();
    }
 }
