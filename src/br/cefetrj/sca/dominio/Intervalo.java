package br.cefetrj.sca.dominio;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Embeddable;

/**
 * Esta classe fornece funcionalidade para representar intervalos de tempo.
 * 
 * @author <a href="mailto:edubezerra@gmail.com">Eduardo Bezerra</a>
 */
@Embeddable
public class Intervalo implements Cloneable {
	/**
	 * Formatador usado para trasformar as strings passadas na construção do
	 * objeto em objeto da classe {@link Date} .
	 */
	private static DateFormat formatador = new SimpleDateFormat("HH:mm");

	/** inicio do intervalo. */
	private Date inicio;

	/** fim do intervalo. */
	private Date fim;

	private Intervalo() {
	}

	/**
	 * 
	 * @param strInicio
	 *            início do intervalo (e.g., "10:30")
	 * @param strFim
	 *            fim do intervalo (e.g., "12:00")
	 * @throws IllegalArgumentException
	 *             se o início não for anterior ao fim.
	 */
	public Intervalo(final String strInicio, final String strFim) {
		try {
			this.inicio = (Date) formatador.parse(strInicio);
			this.fim = (Date) formatador.parse(strFim);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Argumentos inválidos: ("
					+ strInicio + ", " + strFim + ")", e);
		}
		if (inicio.after(fim)) {
			throw new IllegalArgumentException(
					"Início do intervalo deve ser anterior ao fim.");
		}
	}

	/**
	 * 
	 * @param dtInicio
	 *            início do intervalo (e.g., "10:30")
	 * @param dtFim
	 *            fim do intervalo (e.g., "12:00")
	 */
	private Intervalo(final Date dtInicio, final Date dtFim) {
		if (dtInicio.after(dtFim)) {
			throw new IllegalArgumentException(
					"Início deve ser anterior ao fim.");
		}
		this.inicio = dtInicio;
		this.fim = dtFim;
	}

	@Override
	public Object clone() {
		Intervalo copia = new Intervalo((Date) inicio.clone(),
				(Date) fim.clone());
		return copia;
	}

	/**
	 * Retorna o fim do intervalo.
	 * 
	 * @return o fim do intervalo, no formato hh:mm.
	 */
	public final String getFim() {
		return formatador.format(this.fim);
	}

	/**
	 * Retorna o in�cio do intervalo.
	 * 
	 * @return o in�cio do intervalo, no formato hh:mm
	 */
	public String getInicio() {
		return formatador.format(this.inicio);
	}

	/**
	 * Verifica se h� colis�o entre dois intervalos.
	 * 
	 * @param outroIntervalo
	 *            o intervalo com o qual a comparação é feita.
	 * @return true se há colisão entre os intervalos; false em caso contr�rio.
	 */
	public Boolean colide(final Intervalo outroIntervalo) {
		return !outroIntervalo.inicio.before(this.inicio)
				&& !outroIntervalo.fim.after(this.fim);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fim == null) ? 0 : fim.hashCode());
		result = prime * result + ((inicio == null) ? 0 : inicio.hashCode());
		return result;
	}

	/**
	 * Verifica se h� colis�o dois intervalos s�o iguais. Dois intervalos s�o
	 * iguais se eles possuem os mesmos in�cio e fim.
	 * 
	 * @param outroIntervalo
	 *            o intervalo com o qual a comparação é feita.
	 * @return true se há colisão entre os intervalos; false em caso contr�rio.
	 */
	@Override
	public boolean equals(Object outroIntervalo) {
		if (this == outroIntervalo) {
			return true;
		}
		if (outroIntervalo == null) {
			return false;
		}
		if (getClass() != outroIntervalo.getClass()) {
			return false;
		}

		Intervalo other = (Intervalo) outroIntervalo;
		String inicioA = formatador.format(this.inicio);
		String inicioB = formatador.format(other.inicio);
		String fimA = formatador.format(this.fim);
		String fimB = formatador.format(other.fim);

		if (fim == null) {
			if (other.fim != null) {
				return false;
			}
		} else if (!fimA.equals(fimB)) {
			return false;
		}
		if (inicio == null) {
			if (other.inicio != null) {
				return false;
			}
		} else if (!inicioA.equals(inicioB)) {
			return false;
		}
		return true;
	}

	public Intervalo unir(Intervalo outro) {
		Intervalo primeiro, segundo;
		if (this.inicio.equals(outro.fim)) {
			primeiro = outro;
			segundo = this;
		} else if (outro.inicio.equals(this.fim)) {
			primeiro = this;
			segundo = outro;
		} else {
			throw new IllegalArgumentException(
					"Intervalos não são compatíveis para união.");
		}
		Intervalo unido = new Intervalo(primeiro.getInicio(), segundo.getFim());
		return unido;
	}

}