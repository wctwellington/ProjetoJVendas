package controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Gravartxt {
	
public  void Gravar_txt(/*String[][] pedido,double ValorTotal,*/int Npedido,String ultPedido, String CPF)throws IOException{
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
		FileWriter arq;
		PrintWriter gravararq;
		try {
			arq = new FileWriter ("010.txt");
			gravararq = new PrintWriter(arq);
			int cont =0;
			gravararq.println("----------------Numero do Pedido:"+Npedido+"----------------");
			double	ValorTotal = 150.50;
			String [][] pedido = new String[][]{ 
					{"123456789","Arroz","25.70","1","25.7"}, 
					{"123456788","Feijão","23.80","2","47.6"}, 
					{"1478963","Macarrão","25.70","1","25.7"}
					};
			for(int i=1;i<100;i++){
				
				
			
				if(pedido[cont][0]!=null && pedido[cont][0]!=""){
					
					gravararq.println(dateFormat.format(date));
					gravararq.println(Integer.parseInt(pedido[cont][0]));	
					gravararq.println(pedido[cont][1]);
					gravararq.println(Double.parseDouble(pedido[cont][2]));
					gravararq.println(Integer.parseInt(pedido[cont][3]));
					gravararq.println(Double.parseDouble(pedido[cont][4]));
					System.out.println(pedido[cont][0]);
					cont++;
					gravararq.close();
					}
				else{
					gravararq.close();
					i=101;
				}
				gravararq.println("Total do pedido: " +ValorTotal + "%nCEF: " +CPF);	

			}
		} catch (IOException e) {
			System.out.println("Erro");
			e.printStackTrace();
		}		
		
		//Grava um novo txt com o numero do ultimo pedido.
		
		
		File UltPedido = new File("UltPedido.txt");
		PrintWriter gravarUlt; 
			try {
				gravarUlt = new PrintWriter(UltPedido);
				gravarUlt.println(ultPedido);
			} catch (FileNotFoundException e) {
				System.out.println("Erro");
				e.printStackTrace();
			}
						
}
}