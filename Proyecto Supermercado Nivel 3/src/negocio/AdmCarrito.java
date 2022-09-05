package negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import modelo.Carrito;
import modelo.Cliente;

public class AdmCarrito {
    private List<Carrito> lstCarrito = new ArrayList<Carrito>();

	public AdmCarrito(List<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
	}
    public AdmCarrito() {
    	
    }
	public List<Carrito> getLstCarrito() {
		return lstCarrito;
	}

	public void setLstCarrito(List<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
	}
    
	
	@Override
	public String toString() {
		String ret = "";
		for(Carrito c: lstCarrito) {
			ret = ret + c.toString() + "\n";
		}
		return ret;
	}
	public Carrito traerCarrito(int idCarrito) {
		Carrito carrito = null;
		int indice = 0;
		while(carrito == null && indice<lstCarrito.size()) {
			  if(lstCarrito.get(indice).getIdCarrito() == idCarrito) {
				  carrito = lstCarrito.get(indice);
			  }
			indice++;
		}
		return carrito;
	}
	public Carrito traerCarrito(Cliente cliente) {
		Carrito carrito = null;
		int indice = 0;
		while(carrito == null && indice<lstCarrito.size()) {
			if(lstCarrito.get(indice).getIdCarrito() == cliente.getIdCliente()) {
				carrito= lstCarrito.get(indice);
			}
			indice++;
		}
		return carrito;
	}
	public boolean agregarCarrito(LocalDate fecha,LocalTime hora,Cliente cliente) throws Exception {
		int indice = 0;
		while(indice<lstCarrito.size()) {
			if(lstCarrito.get(indice).getCliente().equals(cliente) && lstCarrito.get(indice).getFecha() == fecha && lstCarrito.get(indice).getHora() == hora) {
				throw new Exception("Error: El carrito ya esta en el sistema");
			}
			indice++;
		}
		return lstCarrito.add(new Carrito(indice+1, fecha,hora, cliente));
	}
      
	//13) +eliminarCarrito(int idCarrito): boolean
     public boolean eliminarCarrito(int idCarrito) throws Exception {
    	 Carrito carrito = traerCarrito(idCarrito);
    	 if(carrito == null) {
    		 throw new Exception("Error: El carrito no existe en el sistema");
    	 }
    	 int indice = 0;
    	 while(indice<lstCarrito.size()) {
    		 if(lstCarrito.get(indice).getIdCarrito() == idCarrito) {
    			 carrito = lstCarrito.get(indice);
    		 }
    		 indice++;
    	 }
    	 return lstCarrito.remove(carrito);
     }
     public float calcularTotal(Cliente cliente) throws Exception {
    	 if(cliente == null) {
    		 throw new Exception("Error: El cliente no existe en el sistema");
    	 }
    	 int indice = 0;
    	 float total = 0;
    	 while(indice<lstCarrito.size()) {
    		 if(lstCarrito.get(indice).getCliente().equals(cliente)) {
    			 total = total + lstCarrito.get(indice).calcularTotal();
    		 }
    		 indice++;
    	 }
    	 return total;
    	 
     }
     
     //15) +calcularTotal(long dniCliente): float
     public float calcularTotal(long dniCliente) {
          float total = 0;
          int indice = 0;
    	 while(indice<lstCarrito.size()) {
    		 if(lstCarrito.get(indice).getCliente().getDni() == dniCliente) {
    			 total = total + lstCarrito.get(indice).calcularTotal();
    		 }
    		 indice++;
    	 }
    	 return total;
     }
     //16) +calcularTotal(LocalDate fechaInicio, LocalDate fechaFin): float
      public float calcularTotal(LocalDate fechaInicio,LocalDate fechaFin) {
    	  float total = 0;
    	  int indice = 0;
    	  while(indice<lstCarrito.size()) {
    		  if(lstCarrito.get(indice).getFecha().compareTo(fechaInicio) >= 0 && lstCarrito.get(indice).getFecha().compareTo(fechaFin) <= 0) {
    			  total = total + lstCarrito.get(indice).calcularTotal();
    		  }
    		  indice++;
    	  }
    	  return total;
      }
      //17) +calcularTotal(LocalDate fecha): float
       public float calcularTotal(LocalDate fecha) {
    	   float total = 0;
    	   int indice = 0;
    	   while(indice<lstCarrito.size()) {
    		   if(lstCarrito.get(indice).getFecha().compareTo(fecha) == 0) {
    			   total = total + lstCarrito.get(indice).calcularTotal();
    		   }
    		   indice++;
    	   }
    	   return total;
       }
       //18) +calcularTotal(int mes, int anio): float
       public float calcularTotal(int mes,int anio) throws Exception {
    	   float total = 0;
    	   int indice = 0;
    	   if(mes>12 || mes<1) {
    		   throw new Exception("Error: El mes que acaba de mencionar no existe");
    	   }
    	   while(indice<lstCarrito.size()) {
    		   if(lstCarrito.get(indice).getFecha().getMonthValue() == mes && lstCarrito.get(indice).getFecha().getYear() == anio) {
    			   total = total + lstCarrito.get(indice).calcularTotal();
    		   }
    		   indice++;
    	   }
    	   return total;
       }
       //19) +calcularTotal(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente)
       
       public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin,Cliente cliente) throws Exception {
    	   if(cliente == null) {
    		   throw new Exception("Error: El cliente no existe en el sistema");
    	   }
    	   float total = 0;
    	   int indice = 0;
    	   while(indice<lstCarrito.size()) {
    		   if(lstCarrito.get(indice).getFecha().compareTo(fechaInicio) >= 0 && lstCarrito.get(indice).getFecha().compareTo(fechaFin) <= 0
    				   && lstCarrito.get(indice).getCliente().equals(cliente)) {
    			   total = total + lstCarrito.get(indice).calcularTotal();
    		   }
    		   indice++;
    	   }
    	   return total;
       }
       public float calcularTotal(LocalDate fecha,Cliente cliente) throws Exception {
    	   if(cliente == null) {
    		   throw new Exception("Error: El cliente no existe en el sistema");
    	   }
    	   float total = 0;
    	   int indice = 0;
    	   while(indice<lstCarrito.size()) {
    		   if(lstCarrito.get(indice).getFecha().compareTo(fecha) == 0 && lstCarrito.get(indice).getCliente().equals(cliente)) {
    			   total = total + lstCarrito.get(indice).calcularTotal();
    		   }
    			   indice++;
    	   }
    	   return total;
       }
       public float calcularTotal(int mes,int anio,Cliente cliente) throws Exception {
    	   if(mes>12 || mes<1 || cliente == null) {
    		   throw new Exception("Error: El cliente y/o el mes no existen");
    	   }
    	   float total = 0;
    	   int indice = 0;
    	   while(indice<lstCarrito.size()) {
    		   if(lstCarrito.get(indice).getFecha().getMonthValue() == mes && lstCarrito.get(indice).getFecha().getYear() == anio 
    				   && lstCarrito.get(indice).getCliente().equals(cliente)) {
    			   total = total + lstCarrito.get(indice).calcularTotal();
    		   }
    		   indice++;
    	   }
    	   return total;
       }
       public float calcularTotal(int mes,int anio,long dniCliente) throws Exception{
    	   if(mes>12 || mes<1) {
    		   throw new Exception("Error: El cliente y/o el mes no existen");
    	   }
    	   float total = 0;
    	   int indice = 0;
    	   while(indice<lstCarrito.size()) {
    		   if(lstCarrito.get(indice).getFecha().getMonthValue() == mes && lstCarrito.get(indice).getFecha().getYear() == anio 
    				   && lstCarrito.get(indice).getCliente().getDni() == dniCliente) {
    			   total = total + lstCarrito.get(indice).calcularTotal();
    		   }
    		   indice++;
    	   }
    	   
    	   
    	   return total;
       }
       
}