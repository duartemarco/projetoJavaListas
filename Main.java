import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// criando uma lista sequencial de alunos
		ListaSequencial listasequencial = new ListaSequencial();

//		System.out.println("Quantos alunos você deseja cadastrar?");

		System.out.println(
				"1- Cadastrar aluno \n2- Buscar aluno via RGM \n3- Mostrar todos os alunos \n4- Remover um aluno \n5- Sair do sistema");
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		int n = entrada.nextInt();

		switch (n) {
		case 1:

		case 2:
			System.out.println("Informe o RGM para busca: ");
			int i = entrada.nextInt();
			listasequencial.buscar(i);
		case 3:
			listasequencial.exibirLista();
		case 4:
			System.out.println("Informe o RGM do aluno a ser removido: ");
			int j = entrada.nextInt();
			listasequencial.removerAluno(j);
		case 5:
		default:
		}

		Aluno a1 = new Aluno();
		a1.nome = "Joao";
		a1.rgm = "01";

		Aluno a2 = new Aluno();
		a2.nome = "Maria";
		a2.rgm = "02";

		Aluno a3 = new Aluno();
		a3.nome = "Jose";
		a3.rgm = "03";

		listasequencial.inserirAluno(0, a1);
		listasequencial.inserirAluno(1, a2);
		listasequencial.inserirAluno(2, a3);

		listasequencial.exibirLista();
		System.out.println("A lista tem " + listasequencial.tamanhoLista() + " elementos");

	}

}
