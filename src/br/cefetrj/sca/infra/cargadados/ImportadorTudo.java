package br.cefetrj.sca.infra.cargadados;

public class ImportadorTudo {
	public static void main(String[] args) {

		try {
//			ImportadorQuestionarioAvaliacao.run();
			ImportadorCursos.main(args);
			ImportadorDisciplinas.main(args);
			ImportadorPreReqs.main(args);
			ImportadorDiscentes.main(args);
			ImportadorDocentes.main(args);
			ImportadorDepartamentos.main(args);
			ImportadorTurmas.main(args);
			ImportadorAlocacoesProfessoresEmTurmas.main(args);
			ImportadorLocais.main(args);
			ImportadorAulas.main(args);
			ImportadorHistoricosEscolares.main(args);
		} catch (IllegalArgumentException | IllegalStateException ex) {
			System.err.println(ex.getMessage());
			System.exit(1);
		} finally {
		}

		System.out.println("Importação finalizada!");
	}
}
