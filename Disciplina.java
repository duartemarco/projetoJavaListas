
public class Disciplina {
	String nome;
	String nota;

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	Disciplina proximo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Disciplina getProximo() {
		return proximo;
	}

	public void setProximo(Disciplina proximo) {
		this.proximo = proximo;
	}

}
