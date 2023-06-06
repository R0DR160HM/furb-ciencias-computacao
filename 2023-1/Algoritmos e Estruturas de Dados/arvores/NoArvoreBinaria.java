package arvores;

public class NoArvoreBinaria<T> { // contribui��o Maria Clara
	private T info;
	private NoArvoreBinaria<T> esq;
	private NoArvoreBinaria<T> dir;

	public NoArvoreBinaria(T info) {
		this.setInfo(info);
		this.setEsq(null);
		this.setDir(null);
	}

	public NoArvoreBinaria(T info, NoArvoreBinaria<T> esq, NoArvoreBinaria<T> dir) {
		this.setInfo(info);
		this.setEsq(esq);
		this.setDir(dir);
	}

	public T getInfo() {
		return this.info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public void setEsq(NoArvoreBinaria<T> esq) {
		this.esq = esq;
	}
	
	public void setDir(NoArvoreBinaria<T> dir) {
		this.dir = dir;
	}

	public NoArvoreBinaria<T> getEsq() {
		return this.esq;
	}

	public NoArvoreBinaria<T> getDir() {
		return this.dir;
	}
	
	public NoArvoreBinaria<T> pertence(T info) {

		if (this.info.equals(info)) {
			return this;
		} else {
			NoArvoreBinaria<T> noEncontrado = null;

			if (this.esq != null) {
				noEncontrado = this.esq.pertence(info);
			}

			if (noEncontrado == null && this.dir != null) {
				noEncontrado = this.dir.pertence(info);
			}

			return noEncontrado;
		}
	}


	public String imprimePre() {
		String str = "";

		str += "<" + this.info.toString();
		str += this.esq != null ? this.esq.imprimePre() : "<>";
		str += this.dir != null ? this.dir.imprimePre() : "<>";

		return str + ">";
	}

}