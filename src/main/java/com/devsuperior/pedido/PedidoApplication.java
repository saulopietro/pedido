package com.devsuperior.pedido;

import com.devsuperior.entities.Order;
import com.devsuperior.services.OrderService;
import com.devsuperior.services.ShippingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class PedidoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedidoApplication.class, args);
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Codigo do pedido: ");
		Integer code = sc.nextInt();
		System.out.println("Valor basico do pedido: ");
		double basic = sc.nextDouble();
		System.out.println("Desconto do pedido: ");
		double discount = sc.nextDouble();


		Order order = new Order(code, basic, discount);

		ShippingService shippingService = new ShippingService();

		OrderService orderService = new OrderService(shippingService);

		System.out.println("Código do pedido: " + order.getCode());
		System.out.println("Valor total: " + orderService.total(order));
	}

}
