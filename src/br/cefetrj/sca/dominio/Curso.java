package br.cefetrj.sca.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Curso {

	@Id
	@GeneratedValue
	Long id;

	String sigla;

	String nome;

	private Curso() {
	}

	public Curso(String siglaCurso, String nomeCurso) {
		this.sigla = siglaCurso;
		this.nome = nomeCurso;
	}

	public String getSigla() {
		return sigla;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Curso [sigla=" + sigla + ", nome=" + nome + "]";
	}

}
