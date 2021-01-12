import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.sql.*;
public class Admin extends JFrame implements ActionListener{
		JLabel jl,jl1;
		JButton jb;
		JTextField jt;
		JPasswordField jp;
		Admin(String s){
			super(s);
			setLayout(null);
			jl=new JLabel("Login_id");
			jl1=new JLabel("Password");
			jt=new JTextField(30);
			jp=new JPasswordField(30);
			jb=new JButton("Submit");
			jl.setBounds(50,100,100,30);
			jl1.setBounds(50,200,100,30);
			jt.setBounds(250,100,100,30);
			jp.setBounds(250,200,100,30);
			jb.setBounds(150,300,100,50);
			jb.addActionListener(this);
			add(jl);
			add(jl1);
			add(jt);
			add(jp);
			add(jb);
		}
			public void actionPerformed(ActionEvent e){
					try{
						int Login_id=Integer.parseInt(jt.getText());
						int Password=Integer.parseInt(jp.getText());
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						Connection cn=DriverManager.getConnection("jdbc:odbc:admin");
						Statement st=cn.createStatement();
						if(e.getSource()==jb){
							ResultSet rs=st.executeQuery("select * from Student where Login_id="+Login_id);
							if(rs.next()){
								if(jp.getText()==rs.getString(2)){
									Home i=new Home("Home");
									i.setSize(500,500);
									i.setVisible(true);
									this.setVisible(false);
								}
							}
						}
								
					}
					catch(Exception er){
						System.out.println("Error");
					}
			}
			public static void main(String []arr){
				Admin h=new Admin("Admin");
				h.setSize(500,500);
				h.setVisible(true);
				
			}
		
}
class Home extends JFrame implements ActionListener{
		JButton b1,b2,b3,b4;
		Home(String s){
			super(s);
			setLayout(null);
			b1=new JButton("Student");
			b2=new JButton("Company");
			b3=new JButton("Search");
			b4=new JButton("Exit");
			b1.setBounds(100,100,300,50);
			b2.setBounds(100,200,300,50);
			b3.setBounds(100,300,300,50);
			b4.setBounds(0,450,50,20);
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);
			add(b1);
			add(b2);
			add(b3);
			add(b4);
		}
		public void actionPerformed(ActionEvent e){
				/*if(e.getSource()==b1){
						Student i=new Student("Student");
						i.setSize(1000,1000);
						i.setVisible(true);
						this.setVisible(false);
				}
				else if(e.getSource()==b2){
							Company u=new Company("Company");
							u.setSize(1000,1000);
							u.setVisible(true);
							this.setVisible(false);
					}
					else if(e.getSource()==b3){
							Search d=new Search("Search");
							d.setSize(1000,1000);
							d.setVisible(true);
							this.setVisible(false);
						}
						else */if(e.getSource()==b4){
								Admin h=new Admin("Admin");
								h.setSize(500,500);
								h.setVisible(true);
								this.setVisible(false);
						}
						
							
							
		}
		
		
		
	}

/* class Student extends JFrame implements ActionListener{
		String s[]={"CS","IT","ME","EE","EC","CIVIL"};
		JLabel l,l1,l2,l3,l4,l5,l6,l8,l9;
		JTextField t,t1,t2,t3,t4;
		JRadioButton r,r1;
		JCheckBox c,c1;
		JComboBox jc;
		Student(String s1){
				super(s1);
				setLayout(null);
				l=new JLabel("Student_Name");
				l1=new JLabel("Roll_number");
				l9=new JLabel("Branch");
				l2=new JLabel("Father's_Name");
				l3=new JLabel("Email_Id");
				l4=new Jlabel("Mobile_No");
				l5=new JLabel("Gender");
				l6=new JLabel("Language");
				l7=new JLabel("Address");
				l8=new JLabel("Backlogs");
				t=new JTextField(30);
				t1=new JTextField(20);
				jc=new JComboBox(s);
				t2=new JTextField(30);
				t3=new JTextField(20);
				t4=new JTextField(10);
				r=new JRadioButton("male");
				r1=new JRadioButton("female");
				ButtonGroup bg=new ButtonGroup();
				bg.add(r);
				bg.add(r1);
				c=new JCheckBox("C");
				c1=new JCheckBox("C++");
				t5=new JTextField(40);
				t6=new JTextField(20);
				l.setBounds(
				jl.setBounds(100,50,100,20);
				jl1.setBounds(100,120,100,20);
				jl2.setBounds(100,190,100,20);
				jt.setBounds(250,50,100,20);
				jt1.setBounds(250,120,100,20);
				jt2.setBounds(250,190,100,20);
				jb.setBounds(400,50,100,40);
				jb1.setBounds(200,260,100,40);
				jb2.setBounds(400,140,100,40);
				
				
				
				
		}
		public void actionPerformed(ActionEvent e){
				if(e.getSource()==b4){
						Home h=new Home("Home");
						h.setSize(500,500);
						h.setVisible(true);
						this.setVisible(false);
				}
				else if(e.getSource()==b5){
							Update u=new Update("Update");
							u.setSize(500,500);
							u.setVisible(true);
							this.setVisible(false);
					}
					else{
						Delete d=new Delete("Delete");
						d.setSize(500,500);
						d.setVisible(true);
						this.setVisible(false);
					}
		}
}

class Update extends Frame implements ActionListener{
			Button b7,b8,b9;
		Update(String s){
			super(s);
			b7=new Button("Home");
			b8=new Button("Insert");
			b9=new Button("Delete");
			b7.setBounds(100,100,300,50);
			b8.setBounds(100,200,300,50);
			b9.setBounds(100,300,300,50);
			b7.addActionListener(this);
			b8.addActionListener(this);
			b9.addActionListener(this);
			add(b7);
			add(b8);
			add(b9);
		}
		public void actionPerformed(ActionEvent e){
				if(e.getSource()==b7){
						Home h=new Home("Home");
						h.setSize(500,500);
						h.setVisible(true);
						this.setVisible(false);
				}
				else if(e.getSource()==b8){
							Insert i=new Insert("Insert");
							i.setSize(500,500);
							i.setVisible(true);
							this.setVisible(false);
					}
					else{
						Delete d=new Delete("Delete");
						d.setSize(500,500);
						d.setVisible(true);
						this.setVisible(false);
					}
		}
}
 class Delete extends Frame implements ActionListener{
			Button b10,b11,b12;
		Delete(String s){
			super(s);
			b10=new Button("Home");
			b11=new Button("Insert");
			b12=new Button("Update");
			b10.setBounds(100,100,300,50);
			b11.setBounds(100,200,300,50);
			b12.setBounds(100,300,300,50);
			b10.addActionListener(this);
			b11.addActionListener(this);
			b12.addActionListener(this);
			add(b10);
			add(b11);
			add(b12);
		}
		public void actionPerformed(ActionEvent e){
				if(e.getSource()==b10){
						Home h=new Home("Home");
						h.setSize(500,500);
						h.setVisible(true);
						this.setVisible(false);
				}
				else if(e.getSource()==b11){
							Insert i=new Insert("Insert");
							i.setSize(500,500);
							i.setVisible(true);
							this.setVisible(false);
					}
					else{
						Update u=new Update("Update");
						u.setSize(500,500);
						u.setVisible(true);
						this.setVisible(false);
					}
		}
}*/