package com.devsuperior.pedidos;

import com.devsuperior.pedidos.entities.Order;
import com.devsuperior.pedidos.services.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
import java.util.Locale;

@SpringBootApplication
public class PedidosApplication  implements CommandLineRunner {

	private final OrderService orderService;

	public PedidosApplication(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(PedidosApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);  // Configura o Scanner para aceitar o ponto como separador decimal

		// Recebe os dados do usuári
		System.out.println("Digite o código do pedido: ");
		int orderCode = sc.nextInt();

		System.out.println("Digite o valor do pedido: ");
		double orderBasic = sc.nextDouble();

		System.out.println("Digite o valor do desconto do pedido: ");
		double discount = sc.nextDouble();

		//Passamos os valores pelo contrutor
		Order order = new Order(orderCode, orderBasic, discount);

		double totalValue = orderService.calculateOrderTotal(order);

		System.out.println("Pedido código: " + order.getCode());
		System.out.printf("Valor total do pedido (com frete): R$ %.2f%n", totalValue);

		sc.close();
		System.exit(0);
	}




}
