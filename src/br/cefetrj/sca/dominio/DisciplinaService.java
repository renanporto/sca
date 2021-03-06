package br.cefetrj.sca.dominio;

import org.springframework.beans.factory.annotation.Autowired;

import br.cefetrj.sca.dominio.repositorio.DisciplinaRepositorio;

public class DisciplinaService {
	@Autowired
	private DisciplinaRepositorio dao;

	public Disciplina getDisciplinaPorCodigo(String codigoDisciplina, String siglaCurso, String versaoCurso) {
		return dao.getByCodigo(codigoDisciplina, siglaCurso, versaoCurso);
	}

	public Disciplina getDisciplinaPorNome(String nomeDisciplina, String siglaCurso, String versaoCurso) {
		return dao.getByNome(nomeDisciplina, siglaCurso, versaoCurso);
	}
}
