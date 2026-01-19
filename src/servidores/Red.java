package servidores;

public class Red implements IPable{
    protected int ip1;
    protected int ip2;
    protected int ip3;
    protected int ip4;
    protected int bitsRed;
    protected String nombre;

    public Red (String nombre){
        establecer(0,0,0,0,0, nombre);
    }

    public Red (int ip1, int ip2, int ip3, int ip4){
        establecer(ip1, ip2, ip3, ip4, 0, "");
    }

    public Red (int ip1, int ip2, int ip3, int ip4, int bitsRed){
        establecer(ip1, ip2, ip3, ip4, bitsRed, "");
    }

    public Red (int ip1, int ip2, int ip3, int ip4, int bitsRed, String nombre){
        establecer(ip1, ip2, ip3, ip4, bitsRed, nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        //Se le aplica la red a 0 porque una red no tiene parte de Host
        return new Red(0,0,0,0);
    }

    @Override
    public IPable obtenerRed() {
        return new Red(ip1, ip2, ip3, ip4, bitsRed);
    }

    @Override
    public String toString() {
        return "RED[" + nombre + "]" +
                "IP: " + ip1 + ip2 + ip3 + ip4+
                "\t BITS DE RED: " + bitsRed;
    }
}
