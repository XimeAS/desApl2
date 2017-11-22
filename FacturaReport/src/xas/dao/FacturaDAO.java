package xas.dao;

import java.util.List;

import xas.model.Factura;

public interface FacturaDAO {
	void createFactura(Factura factura);
	Factura readFactura(Long id);
	List<Factura> readAllFacturas();
	void updateFactura(Factura factura);
	void deleteFactura(Long id);
}
