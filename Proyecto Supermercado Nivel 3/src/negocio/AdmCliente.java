package negocio;

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;

public class AdmCliente {
    private List<Cliente> lstCliente = new ArrayList<Cliente>();

	public AdmCliente(List<Cliente> lstCliente) {
		this.lstCliente = lstCliente;
	}
    public AdmCliente() {
    	
    }
	public List<Cliente> getLstCliente() {
		return lstCliente;
	}

	public void setLstCliente(List<Cliente> lstCliente) {
		this.lstCliente = lstCliente;
	}
	
	@Override
	public String toString() {
		String ret = "";
		for(Cliente c: lstCliente) {
			ret = ret + c.toString() + "\n";
		}
		return ret;
	}
	public Cliente traerCliente(int idCliente) {
		Cliente cliente = null;
		int indice = 0;
		while(cliente == null && indice<lstCliente.size()) {
			  if(lstCliente.get(indice).getIdCliente() == idCliente) {
				  cliente = lstCliente.get(indice);
			  }
			indice++;
		}
		return cliente;
	}
	public Cliente traerCliente(String cliente) {
		Cliente cliente1 = null;
		int indice = 0;
		while(cliente1 == null && indice<lstCliente.size()) {
			  if(lstCliente.get(indice).getCliente().equalsIgnoreCase(cliente)) {
				  cliente1= lstCliente.get(indice);
			  }
			indice++;
		}
		return cliente1;
	}
	public boolean agregarCliente(String cliente,long dni,String direccion) throws Exception {
		int indice = 0;
		while(indice<lstCliente.size()) {
			if(lstCliente.get(indice).getDni() == dni) {
				throw new Exception("Error: El cliente ya existe en el sistema");
			}
			indice++;
		}
		
		return lstCliente.add(new Cliente(indice+1, cliente,dni,direccion));
		
	}
	
	//10) +eliminarCliente(int idCliente): boolean
     public boolean eliminarCliente(int idCliente) throws Exception {
    	  Cliente cliente = traerCliente(idCliente);
    	  if(cliente == null) {
    		  throw new Exception("Error: El cliente no existe");
    	  }
    	  int indice = 0;
    	  while(indice<lstCliente.size()) {
    		  if(lstCliente.get(indice).getIdCliente() == idCliente) {
    			  cliente = lstCliente.get(indice);
    		  }
    		  indice++;
    	  }
    	  return lstCliente.remove(cliente);
     }
    
}
