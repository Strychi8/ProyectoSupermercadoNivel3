package negocio;

import java.util.ArrayList;
import java.util.List;

import modelo.Producto;

public class AdmProducto {
    private List<Producto> lstProducto = new ArrayList<Producto>();

	public AdmProducto(List<Producto> lstProducto) {
		this.lstProducto = lstProducto;
	}
    public AdmProducto() {
       
    }
	public List<Producto> getLstProducto() {
		return lstProducto;
	}

	public void setLstProducto(List<Producto> lstProducto) {
		this.lstProducto = lstProducto;
	}
    
	@Override
	public String toString() {
		String ret = "";
		for(Producto p: lstProducto) {
			ret = ret + p.toString() + "\n";
		}
		return ret;
	}
	public boolean agregarProducto(String producto,float precio) throws Exception {
		int indice = 0;
		while(indice<lstProducto.size()) {
			if(lstProducto.get(indice).getProducto().equalsIgnoreCase(producto)) {
				throw new Exception("Error: Ese producto existe");
			}
			indice++;
		}
		return lstProducto.add(new Producto(indice+1,producto,precio));
	}
	
	public Producto traerProducto(int idProducto) {
	      int indice=0;
	      Producto product = null;
	      while(product == null && indice<lstProducto.size()) {
	    	  if(lstProducto.get(indice).getIdProducto() == idProducto) {
	    		  product = lstProducto.get(indice);
	    	  }
	    	  indice++;
	      }
		
		return product;
	}
	
	public boolean modificarProducto(int idProducto,String producto,double precio) throws Exception {
        Producto product = traerProducto(idProducto);
        float precio1 = (float) precio;
        if(product == null) {
        	throw new Exception("Error: Ese producto no existe");
        }
       
       product.setProducto(producto);
       product.setPrecio(precio1);
       return true;
        
	}
	public boolean eliminarProducto(int idProducto) throws Exception {
		Producto product = traerProducto(idProducto);
		if(product == null) {
			throw new Exception("Error: Ese producto no existe");
		}
		int indice = 0;
		while(indice<lstProducto.size()) {
			if(lstProducto.get(indice).getIdProducto() == idProducto) {
				product = lstProducto.get(indice);
			}
			indice++;
		}
		return lstProducto.remove(product);
	}
}