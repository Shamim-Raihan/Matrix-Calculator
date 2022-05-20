
package calculator;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
public class CalcuLator extends JFrame{
    private Font f,hf,af,mf,rcf;
    private JButton plus,minus,multi,equal,add,add2,transpf,transps,addrc;
    private JLabel heading,hd2;  
    private JTextField num;
    private JTextArea ans,first,second,middle,numside;
    private Container c;
    private JRadioButton one,two;
    private ButtonGroup grp,frstchkgrp,secndchkgrp,anschkgrp;
    private JCheckBox frstchk,secndchk,anschk,frstchk2,secndchk2,anschk2;
    private JComboBox r1,r2,c1,c2;
    private JScrollPane fr,sc,an;
    private ImageIcon icon;
    int []getn=new int[50];
    int []geta=new int[50];
    int [][]mat1=new int[50][50];
    int [][]matf=new int[50][50];
    int [][]mat2=new int[50][50];
    int [][]mats=new int[50][50];
    int [][]mul=new int[50][50];
    int []transitf=new int[50];
    int [][]transits=new int[50][50];
    String []optionrc={"1","2","3","4","5","6"};
    int i=0,g=0,j=0;
    int rowf=0,rows=0,colf=0,cols=0;
    int mt=0,rm=0,cm=0,sum=0;
    int row1=0,col1=0,row2=0,col2=0,fnum1=0,fnum2=0;
    CalcuLator()
    {
        init();
    }
    public void init()
    {
        f=new Font("Arial",Font.BOLD,17);
        hf=new Font("Arial",Font.BOLD,24);
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.blue);
        this.setTitle(" [Matrix Calculator]");
        
        icon=new ImageIcon(getClass().getResource("matrix.png"));
        this.setIconImage(icon.getImage());
        heading=new JLabel("Matrix Calculator");
        heading.setBackground(Color.darkGray);
        heading.setForeground(Color.red);
        heading.setFont(hf);
        heading.setBounds(145,20,200,50);
        heading.setOpaque(true);
        c.add(heading);
        
        plus=new JButton("+");
        minus=new JButton("-");
        multi=new JButton("X");
        equal=new JButton("Clr");
        plus.setBounds(340,200,50,45);
        minus.setBounds(400,200,50,45);
        multi.setBounds(340,260,50,45);
        equal.setBounds(400,260,50,45);
        plus.setFont(hf);
        minus.setFont(hf);
        multi.setFont(hf);
        plus.setBackground(Color.white);
        minus.setBackground(Color.white);
        multi.setBackground(Color.white);
        equal.setBackground(Color.white);
        plus.setForeground(Color.red);
        minus.setForeground(Color.red);
        multi.setForeground(Color.red);
        equal.setForeground(Color.red);
        c.add(plus);
        c.add(minus);
        c.add(multi);
        c.add(equal);
        
        hd2=new JLabel("Enter Num:");
        hd2.setFont(f);
        hd2.setBounds(30,150,150,50);
        hd2.setForeground(Color.black);
        c.add(hd2);
        
        numside=new JTextArea();
        numside.setBounds(10,200,20,50);
        numside.setBackground(Color.BLUE);
        numside.setForeground(Color.YELLOW);
        numside.setFont(f);
        c.add(numside);
        
        num=new JTextField();
        num.setBounds(30,200,180,50);
        num.setBackground(Color.LIGHT_GRAY);
        num.setForeground(Color.BLUE);
        num.setFont(hf);
        num.setHorizontalAlignment(JTextField.CENTER);
        c.add(num);
        
        add=new JButton("Add");
        add.setBounds(30,265,58,35);
        add.setBackground(Color.LIGHT_GRAY);
        add.setForeground(Color.red);
        af=new Font("Arial",Font.BOLD,12);
        add.setFont(af);
        c.add(add);
        
        add2=new JButton("Add2");
        add2.setBounds(100,265,65,35);
        add2.setBackground(Color.LIGHT_GRAY);
        add2.setForeground(Color.red);
        add2.setFont(af);
        c.add(add2);
        
        first=new JTextArea();
        first.setBackground(Color.gray);
        first.setForeground(Color.black);
        first.setFont(hf);
        c.add(first);
        fr=new JScrollPane(first);
        fr.setBounds(30,340,160,115);
        fr.setBackground(Color.red);
        c.add(fr);
        
        middle=new JTextArea();
        middle.setBounds(220,370,55,45);
        middle.setBackground(Color.blue);
        middle.setForeground(Color.black);
        mf=new Font("Arial",Font.BOLD,50);
        middle.setFont(mf);
        c.add(middle);
        
        second=new JTextArea();
        second.setBackground(Color.gray);
        second.setForeground(Color.black);
        second.setFont(hf);
        c.add(second); 
        sc=new JScrollPane(second);
        sc.setBounds(290,340,160,115);
        c.add(sc);
        
        transpf=new JButton("Make It Transpose");
        transps=new JButton("Make It Transpose");
        transpf.setBounds(30,455,160,15);
        transps.setBounds(290,455,160,15);
        transpf.setBackground(Color.black);
        transps.setBackground(Color.black);
        transpf.setForeground(Color.yellow);
        transps.setForeground(Color.yellow);
        c.add(transpf);
        c.add(transps);
        
        ans=new JTextArea();
        ans.setBounds(30,475,260,130);
        ans.setBackground(Color.gray);
        ans.setForeground(Color.black);
        ans.setFont(hf);
        c.add(ans);
        an=new JScrollPane(ans);
        an.setBounds(30,475,260,130);
        c.add(an);
        
        one=new JRadioButton("2x2");
        two=new JRadioButton("3x3");
        one.setBounds(160,150,70,50);
        two.setBounds(230,150,70,50);
        one.setBackground(Color.blue);
        two.setBackground(Color.blue);
        one.setForeground(Color.red);
        two.setForeground(Color.red);
        one.setFont(f);
        two.setFont(f);
        c.add(one);
        c.add(two);
        
        grp=new ButtonGroup();
        grp.add(one);
        grp.add(two);
        
        frstchk=new JCheckBox();
        secndchk=new JCheckBox();
        anschk=new JCheckBox();
        frstchk.setBounds(10,340,20,20);
        anschk.setBounds(10,470,20,20);
        secndchk.setBounds(450,340,20,20);
        frstchk.setBackground(Color.blue);
        secndchk.setBackground(Color.blue);
        anschk.setBackground(Color.blue);
        c.add(frstchk);
        c.add(secndchk);
        c.add(anschk);
        
        frstchk2=new JCheckBox();
        secndchk2=new JCheckBox();
        anschk2=new JCheckBox();
        frstchk2.setBounds(10,360,20,20);
        anschk2.setBounds(10,490,20,20);
        secndchk2.setBounds(450,360,20,20);
        frstchk2.setBackground(Color.blue);
        secndchk2.setBackground(Color.blue);
        anschk2.setBackground(Color.blue);
        c.add(frstchk2);
        c.add(secndchk2);
        c.add(anschk2);
        
        r1=new JComboBox(optionrc);
        r1.setBounds(215, 200,40,15);
        r1.setEditable(true);
        c.add(r1);
        r2=new JComboBox(optionrc);
        r2.setBounds(254, 200,40,15);
        r2.setEditable(true);
        c.add(r2);
        c1=new JComboBox(optionrc);
        c1.setBounds(215, 220,15,30);
        c1.setEditable(true);
        c.add(c1);
        c2=new JComboBox(optionrc);
        c2.setBounds(280, 220,15,30);
        c2.setEditable(true);
        c.add(c2);
        
        addrc=new JButton("In");
        addrc.setBounds(232, 223,47,20);
        addrc.setBackground(Color.lightGray);
        c.add(addrc);
       
        frstchkgrp=new ButtonGroup();
        frstchkgrp.add(frstchk);
        frstchkgrp.add(frstchk2);
        secndchkgrp=new ButtonGroup();
        secndchkgrp.add(secndchk);
        secndchkgrp.add(secndchk2);
        anschkgrp=new ButtonGroup();
        anschkgrp.add(anschk);
        anschkgrp.add(anschk2);
     
       class hand implements ActionListener
        {
           public void actionPerformed(ActionEvent e)
           {
               if(e.getSource()==one)
               {
                   one.setForeground(Color.green);
                   two.setForeground(Color.red);
                   row1=2;
                   col1=2;
                   row2=2;
                   col2=2;
                   fnum1=4;
                   fnum2=4;
                   r1.setSelectedItem("2");r2.setSelectedItem("2");c1.setSelectedItem("2");c2.setSelectedItem("2");
                   i=0;
                   g=0;
               }
               else if(e.getSource()==two)
               {
                   one.setForeground(Color.red);
                   two.setForeground(Color.green);
                   row1=3;
                   col1=3;
                   row2=3;
                   col2=3;
                   fnum1=9;
                   fnum2=9;
                   r1.setSelectedItem("3");r2.setSelectedItem("3");c1.setSelectedItem("3");c2.setSelectedItem("3");
                   i=0;
                   g=0;
               }
               else if(e.getSource()==equal)
               {
                   colorback();
                   heading.setBackground(Color.blue);
                   heading.setForeground(Color.MAGENTA);
                   addrc.setForeground(Color.black);
                   equal.setBackground(Color.yellow);
                   int cl=0;
                   for(cl=0;cl<20;cl++)
                   {
                     geta[cl]=0;
                     getn[cl]=0;
                   }
                     i=0;
                     g=0;
                      numside.setText("");
                     row1=0;row2=0;col1=0;col2=0;fnum1=0;fnum2=0;
                     first.setText("");
                     middle.setText("");
                     second.setText("");
                     ans.setText("");
                     r1.setBackground(Color.yellow);
                     r1.setSelectedItem("");
                     r2.setBackground(Color.yellow);
                     r2.setSelectedItem("");
                     c1.setBackground(Color.yellow);
                     c1.setSelectedItem("");
                     c2.setBackground(Color.yellow);
                     c2.setSelectedItem("");
                     one.setForeground(Color.red);
                     two.setForeground(Color.red);
               }
               else if(e.getSource()==add)
               {   
                   colorback();
                   add.setBackground(Color.yellow);
                   if(row1<1 || row2<1 || col1<1 || col2<1)
                       JOptionPane.showMessageDialog(null,"Cheak Entered Row Colum");
                   else
                   {
                  numside.setText(String.valueOf(i+1));   
                  if(num.getText().isEmpty())
                      JOptionPane.showMessageDialog(null,"Plese Insert Number");
                  else
                  {
                  getn[i]=Integer.parseInt(num.getText());
                  i++;
                  }
                  if(i>=fnum1)
                      JOptionPane.showMessageDialog(null,"1st Array Full");
                  num.setText("");  
                   }
               }
               else if(e.getSource()==add2)
               { 
                   colorback();
                   add2.setBackground(Color.yellow);
                   if(row1<1 || row2<1 || col1<1 || col2<1)
                       JOptionPane.showMessageDialog(null,"Cheak Entered Row Colum");
                   else
                   {
                   numside.setText(String.valueOf(g+1)); 
                   if(num.getText().isEmpty())
                      JOptionPane.showMessageDialog(null,"Plese Insert Number");
                  else
                  {
                  geta[g]=Integer.parseInt(num.getText());
                  g++;
                  }
                  if(g>=fnum2)
                      JOptionPane.showMessageDialog(null,"2nd Array Full");
                  num.setText("");  
                   }
               }
               else if(e.getSource()==addrc)
               {
                   colorback();
                   addrc.setBackground(Color.yellow);
                   addrc.setForeground(Color.red);
                   row1=Integer.parseInt(String.valueOf(r1.getSelectedItem()));
                   row2=Integer.parseInt(String.valueOf(r2.getSelectedItem()));
                   col1=Integer.parseInt(String.valueOf(c1.getSelectedItem()));
                   col2=Integer.parseInt(String.valueOf(c2.getSelectedItem()));
                   if(row1!=2 && row2!=2 && col1!=2 && col2!=2)
                   {
                       one.setForeground(Color.red);
                   }
                   if(row1!=3 && row2!=3 && col1!=3 && col2!=3)
                   {
                       two.setForeground(Color.red);
                   }
                   if(row1!=2 || row2!=2 || col1!=3 || col2!=3)
                   {
                       one.setForeground(Color.red);
                       two.setForeground(Color.red);
                   }
                   if(row1==2 && row2==2 && col1==2 && col2==2)
                   {
                       one.setForeground(Color.green);
                       two.setForeground(Color.red);
                   }
                   if(row1==3 && row2==3 && col1==3 && col2==3)
                   {
                       two.setForeground(Color.green);
                       one.setForeground(Color.red);
                   }
                   fnum1=row1*col1;
                   fnum2=row2*col2;
                   i=0;
                   g=0;
                   r1.setToolTipText("");
                   r2.setToolTipText("");
                   c1.setToolTipText("");
                   c2.setToolTipText("");
                   r1.setBackground(Color.green);
                   r2.setBackground(Color.green);
                   c1.setBackground(Color.green);
                   c2.setBackground(Color.green);
               }
               else if(e.getSource()==multi)
               {
                   colorback();
                   multi.setBackground(Color.yellow);
                   middle.setText("X");
                   ans.setText("");
                   ans.append("\n");
                   heading.setBackground(Color.blue);
                   heading.setForeground(Color.black);
                   if(col1==row2)
                   {
                   int gn=0;
                   for(rowf=0;rowf<row1;rowf++)
                   {
                       for(colf=0;colf<col1;colf++)
                       {
                           mat1[rowf][colf]=getn[gn];
                           gn++;
                       }
                   }
                   
                   int ga=0;
                   for(rows=0;rows<row2;rows++)
                   {
                       for(cols=0;cols<col2;cols++)
                       {
                           mat2[rows][cols]=geta[ga];
                           ga++;
                       }
                   }
                   
                   for(rm=0;rm<row1;rm++)
                   {
                       for(cm=0;cm<col2;cm++)
                       {
                           for(mt=0;mt<col1;mt++)
                           {
                               sum=sum+(mat1[rm][mt]*mat2[mt][cm]);
                           }
                          
                           mul[rm][cm]=sum;
                           sum=0;
                       }
                   }
                   
                   for(rm=0;rm<row1;rm++)
                   {
                        ans.append("        ");
                       for(cm=0;cm<col2;cm++)
                       {
                           String smul=String.valueOf(mul[rm][cm]);
                           ans.append(smul+" ");
                       }
                       ans.append("\n");
                   }
                   }
                   else
                       JOptionPane.showMessageDialog(null,"Multiplication Is Not Possible");
               }
               else if(e.getSource()==plus)
               {
                   colorback();
                   plus.setBackground(Color.yellow);
                   heading.setBackground(Color.blue);
                   heading.setForeground(Color.yellow);
                   int m=0;
                   middle.setText("+");
                   ans.setText("");
                   anschk.setSelected(true);
                   if(row1==row2 && col1==col2)
                   {
                   ans.append("\n");
                  int []plusres=new int[50];
                  for(int k=0;k<row1;k++)
                       {   
                            ans.append("        ");
                           for(int l=0;l<col2;l++)
                           {
                           
                           int []finplus=new int[20];
                           finplus[m]=getn[m]+geta[m];
                         String shon=String.valueOf(finplus[m]+" ");
                             m++;
                             ans.append(shon);
                           }
                           ans.append("\n");
                       }
                   }
                   else
                       JOptionPane.showMessageDialog(null,"Addition Is Not Possible");
               }
               else if(e.getSource()==minus)
               {
                   colorback();
                   minus.setBackground(Color.yellow);
                   heading.setBackground(Color.blue);
                   heading.setForeground(Color.pink);
                   int m=0;
                   middle.setText("-");
                   ans.setText("");
                   anschk.setSelected(true);
                   if(row1==row2 && col1==col2)
                   {
                   ans.append("\n");
                  int []plusres=new int[50];
                  for(int k=0;k<row1;k++)
                       {  
                          ans.append("        ");
                           for(int l=0;l<col2;l++)
                           {
                           
                           int []finplus=new int[20];
                           finplus[m]=getn[m]-geta[m];
                         String shon=String.valueOf(finplus[m]+" ");
                             m++;
                             ans.append(shon);
                           }
                           ans.append("\n");
                       }
                   }
                   else
                       JOptionPane.showMessageDialog(null,"Subtruction Is Not Possible");

               }
               else if(e.getSource()==frstchk)
               {
                   first.setText("");
                   int f=0;
                   for(int k=0;k<row1;k++)
                       {  
                            first.append("  ");
                           for(int l=0;l<col1;l++)
                           {
                           String shon=String.valueOf(getn[f]+" ");
                             f++;
                             first.append(shon);
                           }
                           first.append("\n");
                       }
                }
               else if(e.getSource()==frstchk2)
               {
                   first.setText("");
               }
               else if(e.getSource()==secndchk2)
               {
                   second.setText("");
               }
               else if(e.getSource()==anschk2)
               {
                   ans.setText("");
               }
               else if(e.getSource()==secndchk)
               {
                   {
                       second.setText("");
                   }
                   second.setText("");
                   int q=0;
                   for(int o=0;o<row2;o++)
                       {    
                           second.append("  ");
                           for(int p=0;p<col2;p++)
                           {
                           String shon=String.valueOf(geta[q]+" ");
                             q++;
                             second.append(shon);
                           }
                           second.append("\n");
                       }
               }
               else if(e.getSource()==transps)
               {
                   ans.setText("");
                   anschk.setSelected(true);
                   middle.setText("");
                   ans.append("\n");
                   int ga=0;
                   for(rowf=0;rowf<row2;rowf++)
                   {
                       for(colf=0;colf<col2;colf++)
                       {
                           mat2[rowf][colf]=geta[ga];
                           ga++;
                       }
                   }
                   
                   for(rowf=0;rowf<row2;rowf++)
                   {
                       for(colf=0;colf<col2;colf++)
                       {
                           mats[colf][rowf]=mat2[rowf][colf];
                          
                       }
                   }
                   
                   for(rowf=0;rowf<col2;rowf++)
                   {
                       int smt2=0;
                        ans.append("        ");
                       for(colf=0;colf<row2;colf++)
                       {
                          smt2=mats[rowf][colf];
                          String strans=String.valueOf(smt2);
                           ans.append(strans+" ");
                       }
                       ans.append("\n");
                   }
                   
               }
               else if(e.getSource()==transpf)
               {
                   ans.setText("");
                   anschk.setSelected(true);
                   middle.setText("");
                   int gn=0;
                   ans.append("\n");
                   for(rowf=0;rowf<row1;rowf++)
                   {
                       for(colf=0;colf<col1;colf++)
                       {
                           mat1[rowf][colf]=getn[gn];
                           gn++;
                       }
                   }
                   
                   for(rowf=0;rowf<row1;rowf++)
                   {
                       for(colf=0;colf<col1;colf++)
                       {
                           matf[colf][rowf]=mat1[rowf][colf];
                       }
                   }
                   
                   for(rowf=0;rowf<col1;rowf++)
                   {
                       int smt1=0;
                      ans.append("        ");
                       for(colf=0;colf<row1;colf++)
                       {
                          smt1=matf[rowf][colf];
                          String strans=String.valueOf(smt1);
                           ans.append(strans+" ");
                       }
                       ans.append("\n");
                   }

               }
               
           }
           public void colorback()
           {
               add.setBackground(Color.lightGray);
               add2.setBackground(Color.lightGray);
               plus.setBackground(Color.white);
               minus.setBackground(Color.white);
               equal.setBackground(Color.white);
               multi.setBackground(Color.white);
               addrc.setBackground(Color.lightGray);
           }
        }     
        hand hn=new hand();
        add.addActionListener(hn);
        equal.addActionListener(hn);
        one.addActionListener(hn);
        two.addActionListener(hn);
        add2.addActionListener(hn);
        plus.addActionListener(hn);
        minus.addActionListener(hn);
        multi.addActionListener(hn);
        frstchk.addActionListener(hn);
        frstchk2.addActionListener(hn);
        secndchk.addActionListener(hn);
        secndchk2.addActionListener(hn);
        anschk2.addActionListener(hn);
        transpf.addActionListener(hn);
        transps.addActionListener(hn);
        addrc.addActionListener(hn);
    }
    public static void main(String[] args) {
        CalcuLator fr=new CalcuLator();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setBounds(500, 200,485,650);
    
    }
    
}
