
public class ListaSequencial extends Aluno {

	Aluno[] alunos = new Aluno[59];
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

	public boolean compara(Aluno a1, Aluno a2) {
		return (a1.rgm.equals(a2.rgm));
	}

	public int retornarPosicao(Aluno aluno) {
		for (int i = 0; i <= tamanho; i++)
			if (compara(alunos[i], aluno))
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

	public Aluno removerAluno(String rgm) {
		if (buscarPorRgm(rgm) == null) {
			System.out.println("Não é possível remover aluno inexistente.");
			return null;
		}
		int pos = retornarPosicao(buscarPorRgm(rgm));

		if ((pos > tamanho) || (pos < 0))
			return null;
		Aluno aux = alunos[pos];
		deslocarParaEsquerda(pos);
		aux.disciplinas.primeiro = null;
		aux.disciplinas.ultimo = null;
		aux.disciplinas.tamanho = 0;
		tamanho--;
		return aux;
	}

	public void exibirLista() {
		for (int i = 0; i < tamanho; i++)
			System.out.println("\nAluno " + (i + 1) + "\nRGM: " + alunos[i].rgm);
	}

	public Aluno buscarPorRgm(String rgm) {
		for (int i = 0; i <= tamanho; i++) {

			if (alunos[i] != null) {

				if (alunos[i].rgm.equals(rgm)) {
					return alunos[i];
				}
			}

		}
		return null;

	}

	public int getPosicaoOrdenada(String rgm) {
		int i;

		for (i = 0; i < tamanho; i++) {
			if ((alunos[i].rgm).compareTo(rgm) > 0) {
				return i;
			}
		}

		return i;
	}

	public void inserirAlunoOrdenado(Aluno a1) {

		if (estaCheia()) {
			System.out.println("A lista está cheia.");
			return;
		}

		if (estaVazia()) {
			this.inserirAluno(0, a1);
		} else {
			this.inserirAluno(getPosicaoOrdenada(a1.rgm), a1);
		}

	}

}
