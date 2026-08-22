public class Mesa {
    private int numero;
    private String identificadorMesero;

    public Mesa(int numero, String identificadorMesero) {
        this.numero = numero;
        this.identificadorMesero = identificadorMesero;
    }

    public int getNumero() {
        return numero;
    }

    public String getIdentificadorMesero() {
        return identificadorMesero;
    }
}