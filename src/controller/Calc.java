package controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Calc extends JFrame{
	private Operacoes op = new Operacoes();
	JButton btnCE = new JButton("CE");
	JButton btnMplus = new JButton("M+");
	JButton btnMmenos = new JButton("M-");
	JButton btn1 = new JButton("1");
	JButton btn2 = new JButton("2");
	JButton btn3 = new JButton("3");
	JButton btn4 = new JButton("4");
	JButton btn5 = new JButton("5");
	JButton btn6 = new JButton("6");
	JButton btn7 = new JButton("7");
	JButton btn8 = new JButton("8");
	JButton btn9 = new JButton("9");
	JButton btn0 = new JButton("0");
	JButton btnigual = new JButton("=");
	JButton btndiv = new JButton("/");
	JButton btnmult = new JButton("X");
	JButton btnsub = new JButton("-");
	JButton btnad = new JButton("+");
	JTextField txtResu = new JTextField();
	int memoria = 0;
	int leitura = 0;
	int r;
	int i = 0;
	double  M;
	char status ;
	public Calc(){
		super(",:Calculadora:,");
		Container paine = this.getContentPane();
		
		btnCE.setBounds(20, 80, 85, 30);
		btnCE.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResu.setText("");
				leitura = 0;
				memoria = 0;
			}
		});
		paine.add(btnCE);
		

		btnMplus.setBounds(112, 80, 51, 30);
		paine.add(btnMplus);
		btnMplus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				M= Double.parseDouble(txtResu.getText());
				i++;
				if(i ==1){
					txtResu.setText(""+M);
					
				}
			}
		});
		
		btnMmenos.setBounds(172, 80, 48, 30);
		btnMmenos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

			}
		});
		paine.add(btnMmenos);
		
		btn1.setBounds(20, 120, 60, 30);
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResu.setText(txtResu.getText()+"1");
				 leitura *= 10;
	             leitura += 1;
			}
		});
		paine.add(btn1);
		
		btn2.setBounds(90, 120, 60, 30);
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResu.setText(txtResu.getText()+"2");
				 leitura *= 10;
	                leitura+= 2;
			}
		});
		paine.add(btn2);
		
		btn3.setBounds(160, 120, 60, 30);
		btn3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResu.setText(txtResu.getText()+"3");
				 leitura *= 10;
	                leitura += 3;
			}
		});
		paine.add(btn3);
		
		btn4.setBounds(20, 155, 60, 30);
		btn4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResu.setText(txtResu.getText()+"4");
				 leitura *= 10;
	                leitura += 4;
			}
		});
		paine.add(btn4);
		
		btn5.setBounds(90, 155, 60, 30);
		btn5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResu.setText(txtResu.getText()+"5");
				 leitura *= 10;
	                leitura += 5 ;
			}
		});
		paine.add(btn5);
		
		btn6.setBounds(160, 155, 60, 30);
		btn6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResu.setText(txtResu.getText()+"6");
				 leitura *= 10;
	                leitura += 6;
			}
		});
		paine.add(btn6);
		
		btn7.setBounds(20, 190, 60, 30);
		btn7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResu.setText(txtResu.getText()+"7");
				 leitura *= 10;
	                leitura += 7;
			}
		});
		paine.add(btn7);
		
		btn8.setBounds(90, 190, 60, 30);
		btn8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResu.setText(txtResu.getText()+"8");
				 leitura *= 10;
	                leitura += 8;
			}
		});
		paine.add(btn8);
		
		btn9.setBounds(160, 190, 60, 30);
		btn9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResu.setText(txtResu.getText()+"9");
					leitura *=10;
	                leitura += 9;
			}
		});
		paine.add(btn9);
		
		btn0.setBounds(20, 230, 130, 30);
		btn0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResu.setText(txtResu.getText()+"0");
				 leitura *= 10;

			}
		});
		paine.add(btn0);
		
		btnigual.setBounds(160, 230, 60, 30);
		btnigual.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				 switch (status) {
				 case '+':  r = op.soma(memoria,leitura);
					 		break;
				 case '*': r = op.mult(memoria,leitura);
				 			break;
				 case '/': r = op.div(memoria,leitura);
				 			break;
				 case '-':r = op.sub(memoria,leitura);
				 			break;
				 default: r=leitura;
				 }
			txtResu.setText(""+r);
		
			}
		});
		paine.add(btnigual);
		
		btndiv.setBounds(20, 270, 45, 30);
		btndiv.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResu.setText(txtResu.getText()+"/");
				status = '/';
				memoria += leitura;
				leitura = 0;
				txtResu.setText("");
			}
		});
		paine.add(btndiv);
		
		btnmult.setBounds(73, 270, 45, 30);
		btnmult.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResu.setText(txtResu.getText()+"X");
				status = '*';
				memoria += leitura;
				leitura = 0;
				txtResu.setText("");
			}
		});
		paine.add(btnmult);
		
		btnsub.setBounds(125, 270, 45, 30);
		btnsub.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResu.setText(txtResu.getText()+"-");
				status = '-';
				memoria += leitura;
				leitura = 0;
				txtResu.setText("");
			}
		});
		paine.add(btnsub);
		
		btnad.setBounds(175, 270, 45, 30);
		btnad.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResu.setText(txtResu.getText()+"+");
				status = '+';
				memoria += leitura;
				leitura = 0;
				txtResu.setText("");   
			}
		});
		paine.add(btnad);
		
		txtResu.setBounds(20, 50, 200, 20);
		paine.add(txtResu);
		txtResu.disable();
		

		paine.setLayout(null);
		this.setSize(260, 350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}
	Operacoes res = new Operacoes();
	public static void main(String agrs[]) throws InterruptedException{
		Splash objsplash = new Splash();
		Calc objCalc = new Calc();
		
	}

}
