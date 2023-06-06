package arvores;

public class NoArvoreBST<T extends Comparable<T>> extends NoArvoreBinaria<T> {

    public NoArvoreBST(T info) {
        super(info);
    }

    public void inserir(T info) {
        if (info.compareTo(this.getInfo()) < 0) {
            if (this.getEsq() != null) {
                this.getEsq().inserir(info);
            } else {
                this.setEsq(new NoArvoreBST<T>(info));
            }
        } else {
            if (this.getDir() != null) {
                this.getDir().inserir(info);
            } else {
                this.setDir(new NoArvoreBST<T>(info));
            }
        }
    }

    public NoArvoreBST<T> buscar(T info) {
        if (this.getInfo().equals(info)) {
            return this;
        }
        if (this.getEsq() != null && info.compareTo(this.getEsq().getInfo()) < 0) {
            return this.getEsq().buscar(info);
        }
        if (this.getDir() != null) {
            return this.getDir().buscar(info);
        }
        return null;
    }

    public NoArvoreBST<T> getEsq() {
        return (NoArvoreBST<T>) super.getEsq();
    }

    public NoArvoreBST<T> getDir() {
        return (NoArvoreBST<T>) super.getDir();
    }

    public short getGrau() {
        short grau = 0;
        if (this.getDir() != null) grau++;
        if (this.getEsq() != null) grau++;
        return grau;
    }

    public String toStringOrdered() {
        String text = "";
        if (this.getEsq() != null) {
            text += this.getEsq().toStringOrdered() + ",";
        }

        text += this.getInfo().toString();

        if (this.getDir() != null) {
            text += "," + this.getDir().toStringOrdered();
        }
        return text;
    }
    
}
