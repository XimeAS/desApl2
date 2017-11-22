package xas.model;

import java.io.Serializable;

public class Factura implements Serializable {

	private Long id;
	private String proveedor;
	private String fecha;
	private float importe;
	private String empleado;
	
	public Factura(Long id, String proveedor, String fecha, float importe, String empleado) {
		super();
		this.id = id;
		this.proveedor = proveedor;
		this.fecha = fecha;
		this.importe = importe;
		this.empleado = empleado;
	}

	public Factura() {
		this(0L,"","",0,"");
		
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public String getEmpleado() {
		return empleado;
	}

	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", proveedor=" + proveedor + ", fecha=" + fecha + ", importe=" + importe
				+ ", empleado=" + empleado + "]";
	}

	
}
