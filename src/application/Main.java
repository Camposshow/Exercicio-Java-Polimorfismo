package application;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.enums.ImportedProduct;
import entities.enums.Product;
import entities.enums.UsedProduct;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>(); // Criando a lista do tipo classe Product 
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //Criando um formato para data padrão Brasil
		
		System.out.print("Digite a quantidade de produtos: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.print("Produto #" + i + ": ");
			System.out.print("Comum, usado ou importado? (c/u/i)?"); // String para verificar qual produto o usurio quer inserir 
			char type = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Preço: ");
			Double price= sc.nextDouble();
			
			
			// if para realizar o comando de acordo com o tipo de produto, caso ele seja usado, será instanciado com a subclasse UsedProduct(Upcasting), caso seja importado , será instanciado com a subclasse importedProduct(Upcasting) e caso seja comum será instanciado o objeto da propria classe Product
			if(type == 'u') {
				System.out.print("Data de fabricação (dd/mm/aa): ");
				String date = sc.next();
				LocalDate manufactureDate = LocalDate.parse(date, fmt1); // Gerando a data para o formato criado acima, usando a String recebida do usuario.
				Product x = new UsedProduct(name, price, manufactureDate); // Polimorfismo
				list.add(x); // Adicionando o objeto na lista
			}
			if(type == 'i') {
				System.out.print("Taxa: ");
				Double customFee = sc.nextDouble();
				Product x = new ImportedProduct(name, price, customFee); // Polimorfismo
				list.add(x); // Adicionando o objeto na lista
			}
			if(type == 'c'){
				Product x = new Product(name, price); // Polimorfismo
				list.add(x); // Adicionando o objeto na lista
			} 
			
		}
		
		System.out.printf("\n");
		
		System.out.printf("PREÇOS: \n");
		for(Product x : list) {
			System.out.println(x.priceTag());
		}
		
		   sc.close();
		}
}
