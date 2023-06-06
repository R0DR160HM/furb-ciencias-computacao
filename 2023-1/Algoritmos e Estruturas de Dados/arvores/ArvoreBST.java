package arvores;

public class ArvoreBST<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {
    
    public void inserir(T info) {
        if (this.getRaiz() == null) {
            NoArvoreBinaria<T> no = new NoArvoreBST<>(info);
            this.setRaiz(no);
        } else {
            NoArvoreBST<T> raiz = (NoArvoreBST<T>) this.getRaiz();
            raiz.inserir(info);
        }
    }

    public T menorElemento() {
        NoArvoreBST<T> no = (NoArvoreBST<T>) this.getRaiz();
        if (no == null) {
            return null;
        }
        while (no.getEsq() != null) {
            no = no.getEsq();
        }
        return no.getInfo();
    }

    public T maiorElemento() {
        NoArvoreBST<T> no = (NoArvoreBST<T>) this.getRaiz();
        if (no == null) {
            return null;
        }
        while (no.getDir() != null) {
            no = no.getDir();
        }
        return no.getInfo();
    }
    
    public NoArvoreBST<T> buscar(T info) {
        if (this.getRaiz() == null) {
            return null;
        }
        NoArvoreBST<T> raiz = (NoArvoreBST<T>) this.getRaiz();
        return raiz.buscar(info);
    }

    public void retirar(T info) {
        NoArvoreBST<T> noParaRemover = this.buscar(info);
        if (noParaRemover != null) {
            this.remover(noParaRemover);
        } else {
            throw new IllegalArgumentException("Valor não existe!");
        }
    }

    private void remover(NoArvoreBST<T> noParaRemover) {
        NoArvoreBST<T> noPai = this.buscarPai(noParaRemover);
        switch (noParaRemover.getGrau()) {
            case 0: // número de filhos
                if (noPai == null) {
                    this.setRaiz(null);
                } else if (noPai.getEsq() == noParaRemover) {
                    noPai.setEsq(null);
                } else {
                    noPai.setDir(null);
                }
                break;
            case 1:
                NoArvoreBST<T> noFilho = this.bucarFilho(noParaRemover);
                if (noPai == null) {
                    this.setRaiz(noFilho);
                } if (noPai.getEsq() == noParaRemover) {
                    noPai.setEsq(noFilho);
                } else {
                    noPai.setDir(noFilho);
                }
                break;
            case 2:
                NoArvoreBST<T> noSucessor = this.buscarSucessor(noParaRemover);
                T info = noSucessor.getInfo();
                this.remover(noSucessor);
                noParaRemover.setInfo(info);
                break;
        }
    }

    private NoArvoreBST<T> buscarSucessor(NoArvoreBST<T> no) {
        if (no.getGrau() == 2) {
            NoArvoreBST<T> sucessor = no.getDir();
            while (sucessor.getEsq() != null) {
                sucessor = sucessor.getEsq();
            }
            return sucessor;
        }
        if (no.getGrau() == 1) {
            if (no.getDir() != null) {
                NoArvoreBST<T> sucessor = no.getDir();
                while (sucessor.getEsq() != null) {
                    sucessor = sucessor.getEsq();
                }
                return sucessor;
            } else {
                NoArvoreBST<T> sucessor = no.getEsq();
                while (sucessor.getDir() != null) {
                    sucessor = sucessor.getDir();
                }
                return sucessor;
            }
        }
        return null;
        // if (no.getDir() == null) {
        //     throw new IllegalArgumentException("Não há sucessor!");
        // }
    }

    private NoArvoreBST<T> bucarFilho(NoArvoreBST<T> noParaRemover) {
        NoArvoreBST<T> filho = noParaRemover.getEsq();
        if (filho == null) {
            filho = noParaRemover.getDir();
        }
        return filho;
    }

    private NoArvoreBST<T> buscarPai(NoArvoreBST<T> noFilho) {
        if (noFilho == this.getRaiz()) {
            return null;
        }
        NoArvoreBST<T> noPai = (NoArvoreBST<T>) this.getRaiz();
        while (noPai.getEsq() != noFilho && noPai.getDir() != noFilho) {
            if (noFilho.getInfo().compareTo(noPai.getInfo()) < 0) {
                noPai = noPai.getEsq();
            } else {
                noPai = noPai.getDir();
            }
        }
        return noPai;
    }

    public String toStringOrdered() {
        if (this.getRaiz() == null) {
            return "<>";
        }
        NoArvoreBST<T> raiz = (NoArvoreBST<T>) this.getRaiz();
        return "<" + raiz.toStringOrdered() + ">";
    }

}
