package arvores;

public abstract class ArvoreBinariaAbstract<T> {  // contribui��o Maria Clara
	private NoArvoreBinaria<T> raiz;

	public ArvoreBinariaAbstract() {
		this.raiz = null;
	}

	protected void setRaiz(NoArvoreBinaria<T> no) {
		this.raiz = no;
	}

	protected NoArvoreBinaria<T> getRaiz() {
		return this.raiz;
	}

	public boolean vazia() {
		return this.raiz == null;
	}

	public NoArvoreBinaria<T> pertence(T info) {
		if (this.vazia()) {
			return null;
		}
		return this.raiz.pertence(info);
	}

	public String toString() {
		if (this.vazia()) {
			return "<>";
		}
		return this.raiz.imprimePre();

	}

}
