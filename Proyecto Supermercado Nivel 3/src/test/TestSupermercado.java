package test;

import java.time.LocalDate;
import java.time.LocalTime;

import negocio.AdmCarrito;
import negocio.AdmCliente;
import negocio.AdmProducto;
import negocio.Supermercado;

public class TestSupermercado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdmProducto admProductos = new AdmProducto();
		AdmCliente admClientes = new AdmCliente();
		AdmCarrito admCarritos = new AdmCarrito();
		Supermercado coto = new Supermercado(admProductos, admClientes, admCarritos);
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();

		try {
			System.out.println("Metodo Agregar(Producto): " + coto.agregarProducto("Bananas", 500));
			System.out.println("Metodo Agregar(Producto): " + coto.agregarProducto("Manzanas", 300) + "\n");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Metodo Agregar(Producto): " + e.getMessage());
		}

		System.out.println("Metodo Traer Producto: " + coto.traerProducto(2));

		try {
			System.out.println(
					"Metodo Agregar(Cliente): " + coto.agregarCliente("Marcos Alonso", 42828997, "Andrade 783"));
			System.out
					.println("Metodo Agregar(Cliente): " + coto.agregarCliente("Juan Carlos", 43002032, "Cavour 232"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Metodo Agregar(Cliente): " + e.getMessage());
		}

		// System.out.println("Metodo Traer Cliente: " + coto.traerCliente(2));

		try {
			System.out.println("Metodo Agregar(Carrito): " + coto.agregarCarrito(date, time, coto.traerCliente(1)));
			System.out.println("Metodo Agregar(Carrito): " + coto.agregarCarrito(date, time, coto.traerCliente(2)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Metodo Agregar(Carrito): " + e.getMessage());
		}

		System.out.println("Metodo Agregar(Item): " + coto.traerCarrito(1).agregarItem(coto.traerProducto(1), 2));
		System.out.println("Metodo Agregar(Item): " + coto.traerCarrito(2).agregarItem(coto.traerProducto(2), 5));

		System.out.println("Metodo Traer Carrito: " + coto.traerCarrito(2));
		System.out.println("Metodo Traer Carrito: " + coto.traerCarrito(1));
		// Calculables
		try {
			System.out.println("Total Cliente ----> " + coto.calcularTotal(coto.traerCliente(2)));
			System.out.println("Total Cliente ----> " + coto.calcularTotal(coto.traerCliente(1)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Metodo CalcularCliente(Cliente): " + e.getMessage());
		}

		System.out.println("Total Cliente DNI ----> " + coto.calcularTotal(42828997));
		System.out.println("Total Fecha Inicio y Fecha Fin ----> " + coto.calcularTotal(date, date));
		System.out.println("Total Fecha  ----> " + coto.calcularTotal(date));
		try {
			System.out.println("Total Mes y Anio ----> " + coto.calcularTotal(9, 2022));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println("Metodo CalcularTot(Mes y Anio): " + e1.getMessage());
		}
        try {
			System.out.println("Total Fecha Inicio, Fecha Fin y Cliente ----> " + coto.calcularTotal(date, date, coto.traerCliente("Juan Carlos")));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println("Metodo CalcularTotal(Fecha inicio,fin y cliente): " + e1.getMessage());
		}
        try {
			System.out.println("Total Fecha y Cliente ----> " + coto.calcularTotal(date, coto.traerCliente("Juan Carlos")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Metodo CalcularTotal(Fecha y Cliente): " + e.getMessage());
		}
        try {
			System.out.println("Total Mes,Anio y Cliente ----> " + coto.calcularTotal(9, 2022, coto.traerCliente("Juan Carlos")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Metodo CalcularTotal(Mes,Anio y Cliente): " + e.getMessage());
		}
        try {
			System.out.println("Total Mes,Anio y Dni Cliente ----> " + coto.calcularTotal(9, 2022, 42828997));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Metodo CalcularTotal(Mes,Anio y DNI Cliente): " + e.getMessage());
		}
        // METODOS ELIMINAR
      
		/*try {
			System.out.println("Metodo Eliminar(Item): " + coto.traerCarrito(1).eliminarItem(coto.traerProducto(1), 2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Metodo Eliminar(Item): " + e.getMessage());
		}
		  try {
				System.out.println("Metodo Eliminar(Producto): " + coto.eliminarProducto(1) + "\n");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Metodo Eliminar(Producto): " + e.getMessage() + "\n");
			}

		try {
			System.out.println("Metodo Eliminar(Carrito): " + coto.eliminarCarrito(1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Metodo Eliminar(Carrito): " + e.getMessage());
		}

		try {
			System.out.println("Metodo Eliminar(Cliente): " + coto.eliminarCliente(2) + "\n");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Metodo Eliminar(Cliente): " + e.getMessage());
		}*/

	}

}