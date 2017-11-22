package xas.dao;

import java.util.List;

import xas.model.PromEdu;

public class TestConnection {
	public static void main(String[] args) {
		PromEduDAOImpl promEduDAOImpl = new PromEduDAOImpl();
		promEduDAOImpl.createPrograma(new PromEdu(4L, 20, "Multimedia", "Edficio F"));
		
		
		List<PromEdu> programas = promEduDAOImpl.readAllProgramas();
		for(PromEdu programa: programas) {
			System.out.println(programa);
		}
	}
}
