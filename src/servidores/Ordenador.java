package servidores;

public class Ordenador implements IPable{
    protected int ip1;
    protected int ip2;
    protected int ip3;
    protected int ip4;
    protected int bitsRed;
    protected String nombre;

    public Ordenador(String nombre){
        this.nombre = nombre;
    }

    public Ordenador(int ip1, int ip2, int ip3, int ip4){
        establecer(ip1, ip2, ip3, ip4, 0, "");
    }

    public Ordenador(int ip1, int ip2, int ip3, int ip4, int bitsRed){
        this(ip1, ip2, ip3, ip4);
    }

    public Ordenador(int ip1, int ip2, int ip3, int ip4, int bitsRed, String nombre){
        this(ip1, ip2, ip3, ip4);

    }

    @Override
    public void establecer(int ip1, int ip2, int ip3, int ip4, int bitsRed, String nombre) {
        this.ip1 = ip1;
        this.ip2 = ip2;
        this.ip3 = ip3;
        this.ip4 = ip4;
        this.bitsRed = bitsRed;
        this.nombre = nombre;
    }

    @Override
    public IPable objeterHost() {
        return null;
    }

    @Override
    public IPable obtenerRed() {
        return null;
    }
}
