package servidores;

import java.util.Arrays;

public class Red implements IPable{
    protected int ip1;
    protected int ip2;
    protected int ip3;
    protected int ip4;
    protected int bitsRed;
    protected String nombre;
    protected Ordenador[] ordenadores = new Ordenador[1024];
    protected int nOrdenadores = 0;
    protected Servidor servidor;

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
        if (UtilBin.confirmarIp(ip1,ip2,ip3,ip4)){
            this.ip1 = ip1;
            this.ip2 = ip2;
            this.ip3 = ip3;
            this.ip4 = ip4;
            this.bitsRed = bitsRed;
            this.nombre = nombre;
        }else {
            establecer(0,0,0,0,0,"");
        }
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
        if (this.servidor == null){
            return "RED[" + nombre + "]" +
                    "\n\tIP:[" + ip1 + ip2 + ip3 + ip4+
                    "] \t BITS DE RED: " + bitsRed;
        }
        return "RED[" + nombre + "]" + "SERVIDOR[" + (servidor.getTipo()==1?"Windows":"Linux") + "]" +
                "\n\tIP:[" + ip1 + ip2 + ip3 + ip4+
                "] \t BITS DE RED: " + bitsRed;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Red)) return false;

        Red red = (Red) o;
        return ip1 == red.ip1 && ip2 == red.ip2 && ip3 == red.ip3 &&
                ip4 == red.ip4 && bitsRed == red.bitsRed;
    }

    public boolean unir(Ordenador o){
        for (int i = 0; i < ordenadores.length; i++){
            if (ordenadores[i] == null){
                ordenadores[i] = o;
                nOrdenadores++;
                return true;
            }
        }
        return false;
    }

    public boolean retirar(Ordenador o){
        for (int i = 0; i < this.ordenadores.length; i++){
            if (this.ordenadores[i] != null){
                if (ordenadores[i].equals(o)){
                    this.ordenadores[i] = null;
                    this.nOrdenadores--;
                    return true;
                }
            }
        }
        return false;
    }

    public String[] mostarOrdenadores(){
        String[] ordenadoresList = new String[this.nOrdenadores];
        int nOrd = 0;
        if (this.nOrdenadores > 0){
            for (Ordenador o : this.ordenadores) {
                if (o != null) {
                    ordenadoresList[nOrd] = o.toString();
                    nOrd++;
                }
            }
            return ordenadoresList;
        }else {
            return null;
        }
    }

    public void asignarServidor(Servidor servidor){
        this.servidor = servidor;
    }
}
