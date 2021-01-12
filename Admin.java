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
						String Login_id=jt.getText();
						String Password=jp.getText();
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						Connection cn=DriverManager.getConnection("jdbc:odbc:admin");
						Statement st=cn.createStatement();
						if(e.getSource()==jb){
							ResultSet rs=st.executeQuery("select * from admin where Login_id='"+Login_id+"'");
							if(rs.next()){
								if(rs.getString(2).equals(Password)){
									Home i=new Home("Home");
									i.setSize(500,500);
									i.setVisible(true);
									this.setVisible(false);
								}
								else{
									JOptionPane.showMessageDialog(null,"Invalid password");
								}	
							}
							else{
								JOptionPane.showMessageDialog(null,"Invalid email id");
							}
							
						}
								
					}
					catch(Exception er){
						System.out.println(er.getMessage());
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
			b4.setBounds(450,0,50,20);
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
				if(e.getSource()==b1){
						Student i=new Student("Student");
						i.setSize(500,500);
						i.setVisible(true);
						this.setVisible(false);
				}
				else if(e.getSource()==b2){
							Company u=new Company("Company");
							u.setSize(500,500);
							u.setVisible(true);
							this.setVisible(false);
					}
					/*else if(e.getSource()==b3){
							Search d=new Search("Search");
							d.setSize(1000,1000);
							d.setVisible(true);
							this.setVisible(false);
						}*/
						else if(e.getSource()==b4){
								Admin h=new Admin("Admin");
								h.setSize(500,500);
								h.setVisible(true);
								this.setVisible(false);
						}
						
							
							
		}
		
		
		
	}
class Student extends JFrame implements ActionListener{
		JButton b,b1,b2,b3,b4,b5,b6;
		JLabel l;
		Student(String s){
			super(s);
			setLayout(null);
			l=new JLabel("Student Panel");
			b=new JButton("Home");
			b1=new JButton("company");
			b2=new JButton("Search");
			b3=new JButton("Add");
			b4=new JButton("Update");
			b5=new JButton("Delete");
			b6=new JButton("Exit");
			l.setBounds(150,0,200,50);
			b.setBounds(50,100,100,50);
			b1.setBounds(170,100,100,50);
			b2.setBounds(290,100,100,50);
			b3.setBounds(50,300,100,50);
			b4.setBounds(170,300,100,50);
			b5.setBounds(290,300,100,50);
			b6.setBounds(450,0,50,20);
			b.addActionListener(this);
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);
			b5.addActionListener(this);
			b6.addActionListener(this);
			add(b);
			add(b1);
			add(b2);
			add(b3);
			add(b4);
			add(b4);
			add(b5);
			add(b6);
			add(l);
		}
		public void actionPerformed(ActionEvent e){
				if(e.getSource()==b){
					Home h=new Home("Home");
					h.setSize(500,500);
					h.setVisible(true);
					this.setVisible(false);
				}
				else if(e.getSource()==b1){
						Company u=new Company("Company");
						u.setSize(500,500);
						u.setVisible(true);
						this.setVisible(false);
					}
					/*else if(e.getSource()==b2){
							Search d=new Search("Search");
							d.setSize(500,500);
							d.setVisible(true);
							this.setVisible(false);
						}*/
						else if(e.getSource()==b3){
								Add d=new Add("Add");
								d.setSize(700,1000);
								d.setVisible(true);
								this.setVisible(false);
							}
						else if(e.getSource()==b4){
								Update d=new Update("Update");
								d.setSize(1000,1000);
								d.setVisible(true);
								this.setVisible(false);
							}
						else if(e.getSource()==b5){
								Delete d=new Delete("Delete");
								d.setSize(500,500);
								d.setVisible(true);
								this.setVisible(false);
							}
							else if(e.getSource()==b6){
								Admin d=new Admin("Admin");
								d.setSize(500,500);
								d.setVisible(true);
								this.setVisible(false);
							}
		}
}


 class Add extends JFrame implements ActionListener{
		String s[]={"CS","IT","ME","EE","EC","CIVIL"};
		JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
		JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
		JRadioButton r,r1;
		JCheckBox c,c1;
		JComboBox jc;
		JButton b,b1,b2,b3;
		String x,y;
		Add(String s1){
				super(s1);
				setLayout(null);
				l=new JLabel("First_Name");
				l1=new JLabel("Last_Name");
				l2=new JLabel("Father_Name");
				l3=new JLabel("Email_Id");
				l4=new JLabel("Mobile_No");
				l5=new JLabel("Gender");
				l6=new JLabel("Language");
				l7=new JLabel("Branch");
				l8=new JLabel("Backlogs");
				l9=new JLabel("Aggregate");
				l10=new JLabel("Address");
				l11=new JLabel("City");
				l12=new JLabel("Pin_code");
				l13=new JLabel("State");
				t=new JTextField(30);
				t1=new JTextField(30);
				t2=new JTextField(30);
				t3=new JTextField(30);
				t4=new JTextField(30);
				r=new JRadioButton("male");
				r1=new JRadioButton("female");
				ButtonGroup bg=new ButtonGroup();
				bg.add(r);
				bg.add(r1);
				c=new JCheckBox("C");
				c1=new JCheckBox("C++");
				jc=new JComboBox(s);
				t5=new JTextField(5);
				t6=new JTextField(20);
				t7=new JTextField(50);
				t8=new JTextField(20);
				t9=new JTextField(10);
				t10=new JTextField(20);
				b=new JButton("RESET");
				b1=new JButton("SUBMIT");
				b2=new JButton("Exit");
				b3=new JButton("Home");
				l.setBounds(100,50,100,30);
				l1.setBounds(100,100,100,30);
				l2.setBounds(100,150,100,30);
				l3.setBounds(100,200,100,30);
				l4.setBounds(100,250,100,30);
				l5.setBounds(100,300,100,30);
				l6.setBounds(100,350,100,30);
				l7.setBounds(100,400,100,30);
				l8.setBounds(100,450,100,30);
				l9.setBounds(100,500,100,30);
				l10.setBounds(100,550,100,30);
				l11.setBounds(100,600,100,30);
				l12.setBounds(100,650,100,30);
				l13.setBounds(100,700,100,30);
				t.setBounds(300,50,100,30);
				t1.setBounds(300,100,100,30);
				t2.setBounds(300,150,100,30);
				t3.setBounds(300,200,100,30);
				t4.setBounds(300,250,100,30);
				r.setBounds(300,300,100,30);
				r1.setBounds(400,300,100,30);
				c.setBounds(300,350,50,30);
				c1.setBounds(350,350,50,30);
				jc.setBounds(300,400,50,30);
				t5.setBounds(300,450,100,30);
				t6.setBounds(300,500,100,30);
				t7.setBounds(300,550,100,30);
				t8.setBounds(300,600,100,30);
				t9.setBounds(300,650,100,30);
				t10.setBounds(300,700,100,30);
				b.setBounds(200,800,100,50);
				b1.setBounds(320,800,100,50);
				b2.setBounds(650,0,50,30);
				b3.setBounds(440,800,100,50);
				add(l);
				add(l1);
				add(l2);
				add(l3);
				add(l4);
				add(l5);
				add(l6);
				add(l7);
				add(l8);
				add(l9);
				add(l10);
				add(l11);
				add(l12);
				add(l13);
				add(t);
				add(t1);
				add(t2);
				add(t3);
				add(t4);
				add(t5);
				add(t6);
				add(t7);
				add(t8);
				add(t9);
				add(t10);
				add(r);
				add(r1);
				add(c);
				add(c1);
				add(jc);
				add(b);
				add(b1);
				add(b2);
				add(b3);
				b.addActionListener(this);
				b1.addActionListener(this);
				b2.addActionListener(this);
				b3.addActionListener(this);
				
				
		}
		public void actionPerformed(ActionEvent e){
			try{
				String language="";
				String pt="";
								
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection cn=DriverManager.getConnection("jdbc:odbc:admin");
				Statement st=cn.createStatement();
				
				if(e.getSource()==b1){
								String Fn=t.getText();
								String Ln=t1.getText();
								String Fathern=t2.getText();
								String Email=t3.getText();
								String Mb =t4.getText();
								if(r.isSelected()){
									x="male";
									}
								else if(r1.isSelected()){
									 x="female";
									}
								if(c.isSelected()){
										 language=language+pt+"c";
										 pt=",";
								}
								if(c1.isSelected()){
									 language=language+pt+"c++";
									}
								
								String branch=jc.getSelectedItem().toString();
								int backs=Integer.parseInt(t5.getText());
								int agg=Integer.parseInt(t6.getText());
								String address=t7.getText();
								String city=t8.getText();
								String pin=t9.getText();
								String state=t10.getText();
								
						st.execute("insert into student values('"+Fn+"','"+Ln+"','"+Fathern+"','"+Email+"','"+Mb+"','"+x+"','"+language+"','"+branch+"',"+backs+","+agg+",'"+address+"','"+city+"','"+pin+"','"+state+"') ");
						JOptionPane.showMessageDialog(null,"Record insert");
					}
					else if(e.getSource()==b2){
							Admin u=new Admin("Admin");
							u.setSize(500,500);
							u.setVisible(true);
							this.setVisible(false);
						}
						else if(e.getSource()==b3){
								Home h=new Home("Home");
								h.setSize(500,500);
								h.setVisible(true);
								this.setVisible(false);	
							}
							else if(e.getSource()==b){ 
								
									Add h=new Add("Add");
									h.setSize(700,1000);
									h.setVisible(true);
									this.setVisible(false);
							}
							
							
					cn.close();
					
			}	
			catch(Exception em){
				System.out.println(em.getMessage());
			}
			
		}
	}


class Update extends JFrame implements ActionListener{
		String s[]={"CS","IT","ME","EE","EC","CIVIL"};
		JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
		JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
		JRadioButton r,r1;
		JCheckBox c,c1;
		JComboBox jc;
		JButton b,b1,b2,b3;
		String x,y;	
		Update(String s2){
			super(s2);
				setLayout(null);
				l=new JLabel("First_Name");
				l1=new JLabel("Last_Name");
				l2=new JLabel("Father_Name");
				l3=new JLabel("Email_Id");
				l4=new JLabel("Mobile_No");
				l5=new JLabel("Gender");
				l6=new JLabel("Language");
				l7=new JLabel("Branch");
				l8=new JLabel("Backlogs");
				l9=new JLabel("Aggregate");
				l10=new JLabel("Address");
				l11=new JLabel("City");
				l12=new JLabel("Pin_code");
				l13=new JLabel("State");
				t=new JTextField(30);
				t1=new JTextField(30);
				t2=new JTextField(30);
				t3=new JTextField(30);
				t4=new JTextField(30);
				r=new JRadioButton("male");
				r1=new JRadioButton("female");
				ButtonGroup bg=new ButtonGroup();
				bg.add(r);
				bg.add(r1);
				c=new JCheckBox("C");
				c1=new JCheckBox("C++");
				jc=new JComboBox(s);
				t5=new JTextField(5);
				t6=new JTextField(20);
				t7=new JTextField(50);
				t8=new JTextField(20);
				t9=new JTextField(10);
				t10=new JTextField(20);
				b=new JButton("Update");
				b1=new JButton("Edit");
				b2=new JButton("Exit");
				b3=new JButton("Home");
				l.setBounds(100,50,100,30);
				l1.setBounds(100,100,100,30);
				l2.setBounds(100,150,100,30);
				l3.setBounds(100,200,100,30);
				l4.setBounds(100,250,100,30);
				l5.setBounds(100,300,100,30);
				l6.setBounds(100,350,100,30);
				l7.setBounds(100,400,100,30);
				l8.setBounds(100,450,100,30);
				l9.setBounds(100,500,100,30);
				l10.setBounds(100,550,100,30);
				l11.setBounds(100,600,100,30);
				l12.setBounds(100,650,100,30);
				l13.setBounds(100,700,100,30);
				t.setBounds(300,50,100,30);
				t1.setBounds(300,100,100,30);
				t2.setBounds(300,150,100,30);
				t3.setBounds(300,200,100,30);
				t4.setBounds(300,250,100,30);
				r.setBounds(300,300,50,30);
				r1.setBounds(350,300,50,30);
				c.setBounds(300,350,50,30);
				c1.setBounds(350,350,50,30);
				jc.setBounds(300,400,50,30);
				t5.setBounds(300,450,100,30);
				t6.setBounds(300,500,100,30);
				t7.setBounds(300,550,100,30);
				t8.setBounds(300,600,100,30);
				t9.setBounds(300,650,100,30);
				t10.setBounds(300,700,100,30);
				b.setBounds(200,800,100,50);
				b1.setBounds(500,300,100,50);
				b2.setBounds(650,0,50,30);
				b3.setBounds(320,800,100,50);
				add(l);
				add(l1);
				add(l2);
				add(l3);
				add(l4);
				add(l5);
				add(l6);
				add(l7);
				add(l8);
				add(l9);
				add(l10);
				add(l11);
				add(l12);
				add(l13);
				add(t);
				add(t1);
				add(t2);
				add(t3);
				add(t4);
				add(t5);
				add(t6);
				add(t7);
				add(t8);
				add(t9);
				add(t10);
				add(r);
				add(r1);
				add(c);
				add(c1);
				add(jc);
				add(b);
				add(b1);
				add(b2);
				add(b3);
				b.addActionListener(this);
				b1.addActionListener(this);
				b2.addActionListener(this);
				b3.addActionListener(this);
		}
		public void actionPerformed(ActionEvent e){
			try{
				String Email=t3.getText();
				String language="";
				String pt="";
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection cn=DriverManager.getConnection("jdbc:odbc:admin");
				Statement st=cn.createStatement();
				if(e.getSource()==b){
								String Fn=t.getText();
								String Ln=t1.getText();
								String Fathern=t2.getText();
								
								String Mb=t4.getText();
								if(r.isSelected()){
										x="male";
									}
								else if(r1.isSelected()){
										x="female";
									}
								if(c.isSelected()){
										 language=language+pt+"c";
										 pt=",";
								}
								if(c1.isSelected()){
									 language=language+pt+"c++";
									}
								
								String branch=jc.getSelectedItem().toString();
								int backs=Integer.parseInt(t5.getText());
								int agg=Integer.parseInt(t6.getText());
								String address=t7.getText();
								String city=t8.getText();
								String pin=t9.getText();
								String state=t10.getText();
								st.execute("update student set First_name='"+Fn+"',Last_name='"+Ln+"',Father_name='"+Fathern+"',email_id='"+Email+"',mobile_no='"+Mb+"',gender='"+x+"',lang='"+language+"',brch='"+branch+"',backlogs="+backs+",aggregates="+agg+",addres='"+address+"',city='"+city+"',pin_code='"+pin+"',stat='"+state+"' where email_id='"+Email+"'");
								JOptionPane.showMessageDialog(null,"Record update");
				}
				else if(e.getSource()==b1){
							
							ResultSet rs=st.executeQuery("select * from student where email_id='"+Email+"'");
							if(rs.next()){
								t.setText(rs.getString(1));
								t1.setText(rs.getString(2));
								t2.setText(rs.getString(3));
								t4.setText(rs.getString(5));
								jc.setSelectedItem(rs.getString(8));
								t5.setText(rs.getInt(9)+"");
								t6.setText(rs.getInt(10)+"");
								t7.setText(rs.getString(11));
								t8.setText(rs.getString(12));
								t9.setText(rs.getString(13));
								t10.setText(rs.getString(14));
								if(rs.getString(6).equals("male")){
									r.setSelected(true);
								}
								else {
									r1.setSelected(true);
								}
								if(rs.getString(7).equals("c")){
									c.setSelected(true);									
								}
								else if(rs.getString(7).equals("c++")){
									
										c1.setSelected(true);
								}
								else{
										c.setSelected(true);
										c1.setSelected(true);
								}
						    }
				}
				
				else if(e.getSource()==b2){
							Admin u=new Admin("Admin");
							u.setSize(500,500);
							u.setVisible(true);
							this.setVisible(false);
					}
					else if(e.getSource()==b3){
							Home h=new Home("Home");
							h.setSize(500,500);
							h.setVisible(true);
							this.setVisible(false);
				}
				cn.close();
			}
		
			catch(Exception er){
				System.out.println(er.getMessage());
			}
		}
}
 class Delete extends JFrame implements ActionListener{
			JLabel l;
			JTextField t;
			JButton b,b1,b2,b3;
		Delete(String s){
			super(s);
			setLayout(null);
		    l=new JLabel("Email ID:");
			t=new JTextField(30);
			b=new JButton("Delete Record");
			b1=new JButton("Home");
			b2=new JButton("Student");
			b3=new JButton("Exit");
			l.setBounds(150,150,100,30);
			t.setBounds(300,150,100,30);
			b.setBounds(225,250,200,50);
			b1.setBounds(100,350,100,50);
			b2.setBounds(300,350,100,50);
			b3.setBounds(400,0,70,30);
			add(l);
			add(t);
			add(b);
			add(b1);
			add(b2);
			add(b3);
			b.addActionListener(this);
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
		}
		public void actionPerformed(ActionEvent e){
			try{
				String Email=t.getText();
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection cn=DriverManager.getConnection("jdbc:odbc:admin");
				Statement st=cn.createStatement();
				if(e.getSource()==b){
						st.execute("delete from student where email_id='"+Email+"'");
						JOptionPane.showMessageDialog(null,"Record Delete");
				}
				else if(e.getSource()==b1){
							Home h=new Home("Home");
							h.setSize(500,500);
							h.setVisible(true);
							this.setVisible(false);
				}
				else if(e.getSource()==b2){
						Student i=new Student("Student");
						i.setSize(500,500);
						i.setVisible(true);
						this.setVisible(false);
				}
				else if(e.getSource()==b3){
							Admin u=new Admin("Admin");
							u.setSize(500,500);
							u.setVisible(true);
							this.setVisible(false);
				}
				cn.close();
			}
			catch(Exception er){
					System.out.println(er.getMessage());
					
			}
		}
 }
 class Company extends JFrame implements ActionListener{
				JButton b,b1,b2,b3,b4,b5,b6;
				JLabel l;
		Company(String s){
			super(s);
			setLayout(null);
			l=new JLabel("Company Panel");
			b=new JButton("Home");
			b1=new JButton("Student");
			b2=new JButton("Search");
			b3=new JButton("Add");
			b4=new JButton("Update");
			b5=new JButton("Delete");
			b6=new JButton("Exit");
			l.setBounds(150,0,200,50);
			b.setBounds(50,100,100,50);
			b1.setBounds(170,100,100,50);
			b2.setBounds(290,100,100,50);
			b3.setBounds(50,300,100,50);
			b4.setBounds(170,300,100,50);
			b5.setBounds(290,300,100,50);
			b6.setBounds(450,0,50,20);
			b.addActionListener(this);
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);
			b5.addActionListener(this);
			b6.addActionListener(this);
			add(b);
			add(b1);
			add(b2);
			add(b3);
			add(b4);
			add(b4);
			add(b5);
			add(b6);
			add(l);
		}
		public void actionPerformed(ActionEvent e){
				if(e.getSource()==b){
					Home h=new Home("Home");
					h.setSize(500,500);
					h.setVisible(true);
					this.setVisible(false);
				}
				else if(e.getSource()==b1){
						Student u=new Student("Student");
						u.setSize(500,500);
						u.setVisible(true);
						this.setVisible(false);
					}
					/*else if(e.getSource()==b2){
							Search d=new Search("Search");
							d.setSize(500,500);
							d.setVisible(true);
							this.setVisible(false);
						}*/
						else if(e.getSource()==b3){
								Addc d=new Addc("Add");
								d.setSize(700,1000);
								d.setVisible(true);
								this.setVisible(false);
							}
						else if(e.getSource()==b4){
								Updatec d=new Updatec("Update");
								d.setSize(1000,1000);
								d.setVisible(true);
								this.setVisible(false);
							}
						else if(e.getSource()==b5){
								Deletec d=new Deletec("Delete");
								d.setSize(500,500);
								d.setVisible(true);
								this.setVisible(false);
							}
							else if(e.getSource()==b6){
								Admin d=new Admin("Admin");
								d.setSize(500,500);
								d.setVisible(true);
								this.setVisible(false);
							}
		}
 }
class Addc extends JFrame implements ActionListener{
			
		JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9;
		JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9;
		JButton b,b1,b2,b3;
		String x,y;
		Addc(String s1){
				super(s1);
				setLayout(null);
				l=new JLabel("COMPANY_ID");
				l1=new JLabel("COMPANY_Name");
				l2=new JLabel("OFFICIAL_WEBSITE");
				l3=new JLabel("OFFICE_ADDRESS");
				l4=new JLabel("BACKS_ALLOWED");
				l5=new JLabel("REQUIREMENT");
				l6=new JLabel("POST_AVAILABLE");
				l7=new JLabel("DATE_OF_EXAMINATION");
				l8=new JLabel("PASSING_MARKS");
				l9=new JLabel("MAX_PACKAGE");
				t=new JTextField(30);
				t1=new JTextField(30);
				t2=new JTextField(30);
				t3=new JTextField(50);
				t4=new JTextField(30);
				t5=new JTextField(30);
				t6=new JTextField(30);
				t7=new JTextField(30);
				t8=new JTextField(20);
				t9=new JTextField(20);
				b=new JButton("RESET");
				b1=new JButton("SUBMIT");
				b2=new JButton("Exit");
				b3=new JButton("Home");
				l.setBounds(100,50,200,30);
				l1.setBounds(100,100,200,30);
				l2.setBounds(100,150,200,30);
				l3.setBounds(100,200,200,30);
				l4.setBounds(100,250,200,30);
				l5.setBounds(100,300,200,30);
				l6.setBounds(100,350,200,30);
				l7.setBounds(100,400,200,30);
				l8.setBounds(100,450,200,30);
				l9.setBounds(100,500,200,30);
				t.setBounds(300,50,100,30);
				t1.setBounds(300,100,100,30);
				t2.setBounds(300,150,100,30);
				t3.setBounds(300,200,100,30);
				t4.setBounds(300,250,100,30);
				t5.setBounds(300,300,100,30);
				t6.setBounds(300,350,100,30);
				t7.setBounds(300,400,100,30);
				t8.setBounds(300,450,100,30);
				t9.setBounds(300,500,100,30);
				b.setBounds(200,800,100,50);
				b1.setBounds(320,800,100,50);
				b2.setBounds(650,0,50,30);
				b3.setBounds(440,800,100,50);
				add(l);
				add(l1);
				add(l2);
				add(l3);
				add(l4);
				add(l5);
				add(l6);
				add(l7);
				add(l8);
				add(l9);
				add(t);
				add(t1);
				add(t2);
				add(t3);
				add(t4);
				add(t5);
				add(t6);
				add(t7);
				add(t8);
				add(t9);
				add(b);
				add(b1);
				add(b2);
				add(b3);
				b.addActionListener(this);
				b1.addActionListener(this);
				b2.addActionListener(this);
				b3.addActionListener(this);
				
				
		}
		public void actionPerformed(ActionEvent e){
			try{
				
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection cn=DriverManager.getConnection("jdbc:odbc:admin");
				Statement st=cn.createStatement();	
				if(e.getSource()==b){
						Addc h=new Addc("Add");
						h.setSize(700,1000);
						h.setVisible(true);
						this.setVisible(false);
					}
					else if(e.getSource()==b2){
							Admin u=new Admin("Admin");
							u.setSize(500,500);
							u.setVisible(true);
							this.setVisible(false);
						}
						else if(e.getSource()==b3){
								Home h=new Home("Home");
								h.setSize(500,500);
								h.setVisible(true);
								this.setVisible(false);	
							}
							else if(e.getSource()==b1){ 
								String cid=t.getText();
								String con=t1.getText();
								String web=t2.getText();
								String addres=t3.getText();
								int backs=Integer.parseInt(t4.getText());
								String req=t5.getText();
								int pa=Integer.parseInt(t6.getText());
								String doe=t7.getText();
								int pm=Integer.parseInt(t8.getText());
								String maxp=t9.getText();
								
								st.execute("insert into company values('"+cid+"','"+con+"','"+web+"','"+addres+"',"+backs+",'"+req+"',"+pa+",'"+doe+"',"+pm+",'"+maxp+"') ");
								JOptionPane.showMessageDialog(null,"Record insert");		
							}
							
							
					cn.close();
					
			}	
			catch(Exception em){
				System.out.println(em.getMessage());
			}
			
		}
	}
class Updatec extends JFrame implements ActionListener{
		JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9;
		JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9;
		JButton b,b1,b2,b3;
		String x;
		Updatec(String s1){
				super(s1);
				setLayout(null);
				l=new JLabel("COMPANY_ID");
				l1=new JLabel("COMPANY_Name");
				l2=new JLabel("OFFICIAL_WEBSITE");
				l3=new JLabel("OFFICE_ADDRESS");
				l4=new JLabel("BACKS_ALLOWED");
				l5=new JLabel("REQUIREMENT");
				l6=new JLabel("POST_AVAILABLE");
				l7=new JLabel("DATE_OF_EXAMINATION");
				l8=new JLabel("PASSING_MARKS");
				l9=new JLabel("MAX_PACKAGE");
				t=new JTextField(30);
				t1=new JTextField(30);
				t2=new JTextField(30);
				t3=new JTextField(50);
				t4=new JTextField(30);
				t5=new JTextField(30);
				t6=new JTextField(30);
				t7=new JTextField(30);
				t8=new JTextField(20);
				t9=new JTextField(20);
				b=new JButton("UPDATE");
				b1=new JButton("EDIT");
				b2=new JButton("Exit");
				b3=new JButton("Home");
				l.setBounds(100,50,200,30);
				l1.setBounds(100,100,200,30);
				l2.setBounds(100,150,200,30);
				l3.setBounds(100,200,200,30);
				l4.setBounds(100,250,200,30);
				l5.setBounds(100,300,200,30);
				l6.setBounds(100,350,200,30);
				l7.setBounds(100,400,200,30);
				l8.setBounds(100,450,200,30);
				l9.setBounds(100,500,200,30);
				t.setBounds(300,50,100,30);
				t1.setBounds(300,100,100,30);
				t2.setBounds(300,150,100,30);
				t3.setBounds(300,200,100,30);
				t4.setBounds(300,250,100,30);
				t5.setBounds(300,300,100,30);
				t6.setBounds(300,350,100,30);
				t7.setBounds(300,400,100,30);
				t8.setBounds(300,450,100,30);
				t9.setBounds(300,500,100,30);
				b.setBounds(200,800,100,50);
				b1.setBounds(500,300,100,50);
				b2.setBounds(650,0,50,30);
				b3.setBounds(440,800,100,50);
				add(l);
				add(l1);
				add(l2);
				add(l3);
				add(l4);
				add(l5);
				add(l6);
				add(l7);
				add(l8);
				add(l9);
				add(t);
				add(t1);
				add(t2);
				add(t3);
				add(t4);
				add(t5);
				add(t6);
				add(t7);
				add(t8);
				add(t9);
				add(b);
				add(b1);
				add(b2);
				add(b3);
				b.addActionListener(this);
				b1.addActionListener(this);
				b2.addActionListener(this);
				b3.addActionListener(this);
				
				
		}
		public void actionPerformed(ActionEvent e){
			try{
				String cid=t.getText();
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection cn=DriverManager.getConnection("jdbc:odbc:admin");
				Statement st=cn.createStatement();
				if(e.getSource()==b){
						String con=t1.getText();
						String web=t2.getText();
						String addres=t3.getText();
						int backs=Integer.parseInt(t4.getText());
						String req=t5.getText();
						int pa=Integer.parseInt(t6.getText());
						String doe=t7.getText();
						int pm=Integer.parseInt(t8.getText());
						String maxp=t9.getText();
						st.execute("update company set company_name='"+con+"',official_website='"+web+"',office_address='"+addres+"',back_allowed="+backs+",requirement='"+req+"',post_available="+pa+",date_of_examination='"+doe+"',passing_marks="+pm+",max_package='"+maxp+"' where company_id='"+cid+"' ");
						JOptionPane.showMessageDialog(null,"Record Update");
					}
					else if(e.getSource()==b2){
							Admin u=new Admin("Admin");
							u.setSize(500,500);
							u.setVisible(true);
							this.setVisible(false);
						}
						else if(e.getSource()==b3){
								Home h=new Home("Home");
								h.setSize(500,500);
								h.setVisible(true);
								this.setVisible(false);	
							}
							else if(e.getSource()==b1){ 
								ResultSet rs=st.executeQuery("select * from company where company_id='"+cid+"'");
								if(rs.next()){
									t1.setText(rs.getString(2));
									t2.setText(rs.getString(3));
									t3.setText(rs.getString(4));
									t4.setText(rs.getInt(5)+"");
									t5.setText(rs.getString(6));
									t6.setText(rs.getInt(7)+"");
									t7.setText(rs.getString(8));
									t8.setText(rs.getInt(9)+"");
									t9.setText(rs.getString(10));
								}	
							}
							
							
					cn.close();
					
			}	
			catch(Exception em){
				System.out.println(em.getMessage());
			}
			
		}
	}
class Deletec extends JFrame implements ActionListener{
				JLabel l;
			JTextField t;
			JButton b,b1,b2,b3;
		Deletec(String s){
			super(s);
			setLayout(null);
		    l=new JLabel("Company ID:");
			t=new JTextField(30);
			b=new JButton("Delete Record");
			b1=new JButton("Home");
			b2=new JButton("Company");
			b3=new JButton("Exit");
			l.setBounds(150,150,100,30);
			t.setBounds(300,150,100,30);
			b.setBounds(225,250,200,50);
			b1.setBounds(100,350,100,50);
			b2.setBounds(300,350,100,50);
			b3.setBounds(400,0,70,30);
			add(l);
			add(t);
			add(b);
			add(b1);
			add(b2);
			add(b3);
			b.addActionListener(this);
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
		}
		public void actionPerformed(ActionEvent e){
			try{
				String cid=t.getText();
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection cn=DriverManager.getConnection("jdbc:odbc:admin");
				Statement st=cn.createStatement();
				if(e.getSource()==b){
						st.execute("delete from company where company_id='"+cid+"'");
						JOptionPane.showMessageDialog(null,"Record Delete");
				}
				else if(e.getSource()==b1){
							Home h=new Home("Home");
							h.setSize(500,500);
							h.setVisible(true);
							this.setVisible(false);
				}
				else if(e.getSource()==b2){
						Company i=new Company("Company");
						i.setSize(500,500);
						i.setVisible(true);
						this.setVisible(false);
				}
				else if(e.getSource()==b3){
							Admin u=new Admin("Admin");
							u.setSize(500,500);
							u.setVisible(true);
							this.setVisible(false);
				}
				cn.close();
			}
			catch(Exception er){
					System.out.println(er.getMessage());
					
			}
		}
 }
				