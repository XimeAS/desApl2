package xas.dao;

import java.util.List;

import xas.model.Factura;

public class TestConnection {
	public static void main(String[] args) {
		FacturaDAOImpl facturaDAOImpl = new FacturaDAOImpl();
		facturaDAOImpl.createFactura(new Factura(4L, "Amazon Mexico Services, Inc.","17/07/2017", 1098 , "Viridiana Ramirez Gallardo"));
		
		
		List<Factura> facturas = facturaDAOImpl.readAllFacturas();
		for(Factura factura: facturas) {
			System.out.println(factura);
		}
	}
}
