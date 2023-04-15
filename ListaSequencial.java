
public class ListaSequencial extends Aluno {

	Aluno[] alunos = new Aluno[100];
	int tamanho = 0;

	public boolean estaVazia() {
		return (tamanho == 0);
	}

	public boolean estaCheia() {
		return (tamanho == alunos.length);
	}

	public int tamanhoLista() {
		return (tamanho);
	}

	public Aluno buscar(int pos) {
		// verifica se pos e valida
		if (pos < 0 || pos >= tamanho)
			return null;

		return alunos[pos];
	}

	public boolean Compara(Aluno a1, Aluno a2) {
		return (a1.nome.equals(a1.nome)) && (a2.rgm.equals(a2.rgm));
	}

	public int retornarPosicao(Aluno aluno) {
		for (int i = 0; i <= tamanho; i++)
			if (Compara(alunos[i], aluno))
				return i;
		return -1;
	}

	public void deslocarParaDireita(int pos) {
		for (int i = tamanho; i > pos; i--)
			alunos[i] = alunos[i - 1];
	}

	public boolean inserirAluno(int pos, Aluno a1) {
		if (estaCheia() || (pos > tamanho) || (pos < 0))
			return false;
		deslocarParaDireita(pos);
		alunos[pos] = a1;
		tamanho++;
		return true;
	}

	public void deslocarParaEsquerda(int pos) {
		for (int i = pos; i < (tamanho - 1); i++)
			alunos[i] = alunos[i + 1];
	}

	public Aluno removerAluno(int pos) {
		if ((pos > tamanho) || (pos < 0))
			return null;
		Aluno aux = alunos[pos];
		deslocarParaEsquerda(pos);
		tamanho--;
		return aux;
	}

	public void exibirLista() {
		for (int i = 0; i < tamanho; i++)
			System.out.println("\nAluno " + (i + 1) + "\nNome: " + alunos[i].nome + "\nRGM: " + alunos[i].rgm);
	}

}
