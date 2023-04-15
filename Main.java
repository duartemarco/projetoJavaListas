import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// criando uma lista sequencial de alunos
		ListaSequencial listasequencial = new ListaSequencial();

		System.out.println(
				"Grupo: Antônio Albuquerque de Oliveira Neto; Júlio César Toscano Ximenes Júnior; Marcelo Camilo Gomes; Marco Túlio Souto Maior Duarte.\n");

		int n = 0;
		do {
			System.out.println(
					"\n1- Cadastrar aluno \n2- Buscar aluno via RGM \n3- Mostrar todos os alunos \n4- Remover um aluno \n5- Sair do sistema");
			@SuppressWarnings("resource")
			Scanner entrada = new Scanner(System.in);
			n = entrada.nextInt();
			entrada.nextLine();

			String saida = "1";

			switch (n) {
			case 1:
				System.out.println("Cadastrando aluno.");
				Aluno alunoTemp = new Aluno();
				System.out.println("Informe o RGM: ");
				alunoTemp.rgm = entrada.nextLine();

				ListaEncadeada listaDisciplinasTemp = new ListaEncadeada();

				do {

					Disciplina disciplinaTemp = new Disciplina();
					System.out.println("Cadastre uma disciplina: \n0- para sair");

					saida = entrada.next();
					if (saida.equals("0")) {
						break;
					}
					disciplinaTemp.nome = saida;

					System.out.println("Nota da disciplina: ");
					disciplinaTemp.nota = entrada.next();

					listaDisciplinasTemp.inserirNoInicio(disciplinaTemp);
				} while (saida != "0");

				alunoTemp.disciplinas = listaDisciplinasTemp;

				listasequencial.inserirAlunoOrdenado(alunoTemp);

				break;
			case 2:
				System.out.println("Informe o RGM para busca: ");
				String i = entrada.nextLine();

				alunoTemp = listasequencial.buscarPorRgm(i);

				if (alunoTemp != null) {
					System.out.println("As disciplinas do aluno são: \n");
					alunoTemp.disciplinas.exibirLista();
				} else {
					System.out.println("Aluno não está na lista");
				}
				break;
			case 3:

				for (int y = 0; y < listasequencial.tamanho; y++) {
					System.out.println("\nRGM: " + listasequencial.alunos[y].getRgm() + "\nDisciplinas: \n ");
					listasequencial.alunos[y].disciplinas.exibirLista();
				}

				break;
			case 4:
				System.out.println("Informe o RGM do aluno a ser removido: ");
				String j = entrada.nextLine();
				listasequencial.removerAluno(j);
				break;
			case 5:
				System.out.println("Saindo do sistema");
				break;
			default:
				System.out.println("Pare de tentar quebrar meu código");
			}
		} while (n != 5);

	}

}
