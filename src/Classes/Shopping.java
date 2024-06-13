package Classes;

import java.util.Arrays;

public class Shopping {
    // Atributos
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;

    // Construtor
    public Shopping(String nome, Endereco endereco, int quantidadeMaximaLojas) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[quantidadeMaximaLojas];
    }

    // Métodos de acesso (getters e setters)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Loja[] getLojas() {
        return lojas;
    }

    public void setLojas(Loja[] lojas) {
        this.lojas = lojas;
    }

    // Método insereLoja
    public boolean insereLoja(Loja loja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] == null) {
                lojas[i] = loja;
                return true;
            }
        }
        return false; // Não há espaço disponível
    }

    // Método removeLoja
    public boolean removeLoja(String nomeLoja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] != null && lojas[i].getNome().equals(nomeLoja)) {
                lojas[i] = null;
                return true;
            }
        }
        return false; // Loja não encontrada
    }

    // Método quantidadeLojasPorTipo
    public int quantidadeLojasPorTipo(String tipoLoja) {
        int count = 0;
        for (Loja loja : lojas) {
            if (loja != null) {
                switch (tipoLoja.toLowerCase()) {
                    case "cosmetico":
                        if (loja instanceof Cosmetico) count++;
                        break;
                    case "vestuario":
                        if (loja instanceof Vestuario) count++;
                        break;
                    case "bijuteria":
                        if (loja instanceof Bijuteria) count++;
                        break;
                    case "alimentacao":
                        if (loja instanceof Alimentacao) count++;
                        break;
                    case "informatica":
                        if (loja instanceof Informatica) count++;
                        break;
                    default:
                        return -1; // Tipo de loja inválido
                }
            }
        }
        return count;
    }

    // Método lojaSeguroMaisCaro
    public Informatica lojaSeguroMaisCaro() {
        Informatica maisCaro = null;
        for (Loja loja : lojas) {
            if (loja instanceof Informatica) {
                Informatica lojaInformatica = (Informatica) loja;
                if (maisCaro == null || lojaInformatica.getSeguroEletronicos() > maisCaro.getSeguroEletronicos()) {
                    maisCaro = lojaInformatica;
                }
            }
        }
        return maisCaro; // Retorna a loja de informática com seguro mais caro ou null se não houver
    }

    // Método toString
    @Override
    public String toString() {
        return "Shopping{" +
                "nome='" + nome + '\'' +
                ", endereco=" + endereco.toString() +
                ", lojas=" + Arrays.toString(lojas) +
                '}';
    }
}
