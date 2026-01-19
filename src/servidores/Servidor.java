package servidores;

public class Servidor extends Ordenador{
    protected int tipo;

    public Servidor(String nombre) {
        super(nombre);
        this.tipo = 1;
    }

    public Servidor(int ip1, int ip2, int ip3, int ip4) {
        super(ip1, ip2, ip3, ip4);
        this.tipo = 1;
    }

    public Servidor(int ip1, int ip2, int ip3, int ip4, int bitsRed) {
        super(ip1, ip2, ip3, ip4, bitsRed);
        this.tipo = 1;
    }

    public Servidor(int ip1, int ip2, int ip3, int ip4, int bitsRed, String nombre) {
        super(ip1, ip2, ip3, ip4, bitsRed, nombre);
        this.tipo = 1;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        if (tipo == 1 || tipo == 2){
            this.tipo = tipo;
        }
    }
}
