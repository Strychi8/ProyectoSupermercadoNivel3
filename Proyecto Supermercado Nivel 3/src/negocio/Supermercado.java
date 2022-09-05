package negocio;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Carrito;
import modelo.Cliente;
import modelo.Producto;

public class Supermercado {
    private AdmProducto admProducto = new AdmProducto();
    private AdmCliente admCliente = new AdmCliente();
    private AdmCarrito admCarrito = new AdmCarrito();
	
    public Supermercado(AdmProducto admProducto, AdmCliente admCliente, AdmCarrito admCarrito) {
		this.admProducto = admProducto;
		this.admCliente = admCliente;
		this.admCarrito = admCarrito;
	}
    
	public AdmProducto getAdmProducto() {
		return admProducto;
	}

	public void setAdmProducto(AdmProducto admProducto) {
		this.admProducto = admProducto;
	}

	public AdmCliente getAdmCliente() {
		return admCliente;
	}

	public void setAdmCliente(AdmCliente admCliente) {
		this.admCliente = admCliente;
	}

	public AdmCarrito getAdmCarrito() {
		return admCarrito;
	}

	public void setAdmCarrito(AdmCarrito admCarrito) {
		this.admCarrito = admCarrito;
	}

	//Producto
    public boolean agregarProducto(String producto,float precio) throws Exception{
    	return admProducto.agregarProducto(producto, precio);
    }
    
    public Producto traerProducto(int idProducto) {
    	return admProducto.traerProducto(idProducto);
    }
    public boolean modificarProducto(int idProducto,String producto,double precio) throws Exception{
    	return admProducto.modificarProducto(idProducto, producto, precio);
    }
    public boolean eliminarProducto(int idProducto) throws Exception{
    	return admProducto.eliminarProducto(idProducto);
    }
    //Cliente
    public Cliente traerCliente(int idCliente) {
    	return admCliente.traerCliente(idCliente);
    }
    public Cliente traerCliente(String cliente) {
    	return admCliente.traerCliente(cliente);
    }
    public boolean agregarCliente(String cliente,long dni,String direccion) throws Exception {
    	return admCliente.agregarCliente(cliente, dni, direccion);
    }
    public boolean eliminarCliente(int idCliente) throws Exception{
    	return admCliente.eliminarCliente(idCliente);
    }
    //Carrito
    public Carrito traerCarrito(int idCarrito) {
    	return admCarrito.traerCarrito(idCarrito);
    }
    public Carrito traerCarrito(Cliente cliente) {
    	return admCarrito.traerCarrito(cliente);
    }
    public boolean agregarCarrito(LocalDate fecha,LocalTime hora,Cliente cliente) throws Exception{
    	return admCarrito.agregarCarrito(fecha, hora, cliente);
    }
    public boolean eliminarCarrito(int idCarrito) throws Exception{
    	return admCarrito.eliminarCarrito(idCarrito);
    }
    
     //Calculables
    public float calcularTotal(Cliente cliente) throws Exception {
    	return admCarrito.calcularTotal(cliente);
    }
    
    public float calcularTotal(long dniCliente) {
    	return admCarrito.calcularTotal(dniCliente);
    }
    public float calcularTotal(LocalDate fechaInicio,LocalDate fechaFin) {
    	return admCarrito.calcularTotal(fechaInicio, fechaFin);
    }
    public float calcularTotal(LocalDate fecha) {
    	return admCarrito.calcularTotal(fecha);
    }
    public float calcularTotal(int mes,int anio) throws Exception {
    	return admCarrito.calcularTotal(mes,anio);
    }
    public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin,Cliente cliente) throws Exception{
    	return admCarrito.calcularTotal(fechaInicio, fechaFin, cliente);
    }
    public float calcularTotal(LocalDate fecha,Cliente cliente) throws Exception{
    	return admCarrito.calcularTotal(fecha, cliente);
    }
    public float calcularTotal(int mes,int anio,Cliente cliente) throws Exception{
    	return admCarrito.calcularTotal(mes, anio, cliente);
    }
    public float calcularTotal(int mes,int anio,long dniCliente) throws Exception{
    	return admCarrito.calcularTotal(mes, anio, dniCliente);
    }
}
