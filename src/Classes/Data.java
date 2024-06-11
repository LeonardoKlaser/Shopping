package Classes;

public class Data {
    // Atributos
    private int dia;
    private int mes;
    private int ano;

    // Método Construtor
    public Data(int dia, int mes, int ano) {
        if (!validaData(dia, mes, ano)) {
            System.out.println("Data inválida. Alterando para 1/1/2000.");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        } else {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }
    }

    // Métodos de acesso (getters e setters)
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    // Método toString
    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }

    // Método que verifica se o ano é bissexto
    public boolean verificaAnoBissexto() {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    // Método privado para validar a data
    private boolean validaData(int dia, int mes, int ano) {
        if (ano < 1 || mes < 1 || mes > 12 || dia < 1 || dia > diasNoMes(mes, ano)) {
            return false;
        }
        return true;
    }

    // Método privado para obter o número de dias no mês
    private int diasNoMes(int mes, int ano) {
        switch (mes) {
            case 2:
                return verificaAnoBissexto() ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }
    
    public int compareTo(Data outraData) {
        if (this.ano != outraData.ano) {
            return Integer.compare(this.ano, outraData.ano);
        }
        if (this.mes != outraData.mes) {
            return Integer.compare(this.mes, outraData.mes);
        }
        return Integer.compare(this.dia, outraData.dia);
    }
}
