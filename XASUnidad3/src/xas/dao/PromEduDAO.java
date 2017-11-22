package xas.dao;

import java.util.List;

import xas.model.PromEdu;

public interface PromEduDAO {
	void createPrograma(PromEdu programa);
	PromEdu readPrograma(Long id);
	List<PromEdu> readAllProgramas();
	void updatePrograma(PromEdu programa);
	void deletePrograma(Long id);
}
