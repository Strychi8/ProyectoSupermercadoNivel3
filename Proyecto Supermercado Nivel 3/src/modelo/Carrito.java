package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
	private int idCarrito;
	private LocalDate fecha;
	private LocalTime hora;
	private List<ItemCarrito> lstItem = new ArrayList<ItemCarrito>();
	private Cliente cliente;

	public Carrito(int idCarrito, LocalDate fecha, LocalTime hora, Cliente cliente) {
		this.idCarrito = idCarrito;
		this.fecha = fecha;
		this.hora = hora;
		this.cliente = cliente;
		this.lstItem = new ArrayList<ItemCarrito>();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public List<ItemCarrito> getLstItem() {
		return lstItem;
	}

	public void setLstItem(List<ItemCarrito> lstItem) {
		this.lstItem = lstItem;
	}
	
    @Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", fecha=" + fecha + ", hora=" + hora + ", lstItem=" + lstItem
				+ ", cliente=" + cliente + "]";
	}

	public ItemCarrito traerItem(int idItem) {
		ItemCarrito item = null;
		int indice = 0;
		while(item == null && indice<lstItem.size()) {
			if(lstItem.get(indice).getIdItem() == idItem) {
				item = lstItem.get(indice);
			}
			indice++;
		}
		return item;
	}
	public ItemCarrito traerItem(Producto producto) {
		ItemCarrito item = null;
		int indice = 0;
		while(item == null && indice<lstItem.size()) {
			if(lstItem.get(indice).getIdItem() == producto.getIdProducto()) {
				item = lstItem.get(indice);
			}
			indice++;
		}
		return item;
	}
	public boolean agregarItem(Producto producto,int cantidad) {
		ItemCarrito item = traerItem(producto);
		
		int id=1;
		boolean itemAgregado = true;
		if (item==null) {
			if (lstItem.size()>0) {
				id=lstItem.get(lstItem.size()-1).getIdItem()+1;
			}
			ItemCarrito nItem = new ItemCarrito(id,producto,cantidad);
			itemAgregado=lstItem.add(nItem);
		}
		else {
			item.setCantidad(item.getCantidad()+cantidad);
		}
		return itemAgregado;
	}
      
	
	
	public boolean eliminarItem(Producto producto,int cantidad) throws Exception {
		ItemCarrito item = traerItem(producto);
		boolean itemEliminado = true;
		if(item == null) {
			throw new Exception("Error: Ese producto no existe");
		}
		
		int cantActual = item.getCantidad();
		
		if(cantidad == cantActual) {
			itemEliminado = lstItem.remove(item);
		}else if(cantidad < cantActual) {
			item.setCantidad(cantActual - cantidad);
		}
		return itemEliminado;
	}
	
	public float calcularTotal() {
		float total = 0;
		for(ItemCarrito item: lstItem) {
			total+=item.calcularSubTotal();
		}
		return total;
	}
}