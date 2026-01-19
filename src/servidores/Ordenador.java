package servidores;

import java.util.Objects;

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
        establecer(ip1, ip2, ip3, ip4,  bitsRed, "");
    }

    public Ordenador(int ip1, int ip2, int ip3, int ip4, int bitsRed, String nombre){
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
        String ip = UtilBin.obtenerBinario8(this.ip1) + UtilBin.obtenerBinario8(this.ip2) +
                UtilBin.obtenerBinario8(this.ip3) + UtilBin.obtenerBinario8(this.ip4);
        String host = "";
        int i1, i2, i3, i4;

        for (int i = 0; i < ip.length(); i++) {
            if (i < bitsRed) {
               host += "0";
            }else{
                host += ip.charAt(i);
            }
        }

        i1 = UtilBin.obtenerBinario(host.substring(0, 8));
        i2 = UtilBin.obtenerBinario(host.substring(8, 16));
        i3 = UtilBin.obtenerBinario(host.substring(16, 24));
        i4 = UtilBin.obtenerBinario(host.substring(24, 32));

        return new Ordenador(i1, i2, i3, i4, bitsRed,"HOST: " + nombre);
    }

    @Override
    public IPable obtenerRed() {
        String ip = UtilBin.obtenerBinario8(this.ip1) + UtilBin.obtenerBinario8(this.ip2) +
                UtilBin.obtenerBinario8(this.ip3) + UtilBin.obtenerBinario8(this.ip4);
        String red = "";
        int i1, i2, i3, i4;

        for (int i = 0; i < ip.length(); i++) {
            if (i < bitsRed) {
                red += ip.charAt(i);
            }else{
                red += "0";
            }
        }

        i1 = UtilBin.obtenerBinario(red.substring(0, 8));
        i2 = UtilBin.obtenerBinario(red.substring(8, 16));
        i3 = UtilBin.obtenerBinario(red.substring(16, 24));
        i4 = UtilBin.obtenerBinario(red.substring(24, 32));

        return new Ordenador(i1, i2, i3, i4, bitsRed,"RED: " + nombre);
    }

    @Override
    public String toString() {
        return "ORDENADOR[" + nombre + "]" +
                "\n\tIP:[" + ip1 + ip2 + ip3 + ip4 +
                "] \t BITS DE RED: " + bitsRed ;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Ordenador)) return false;

        Ordenador ord = (Ordenador) o;
        return ip1 == ord.ip1 && ip2 == ord.ip2 && ip3 == ord.ip3
                && ip4 == ord.ip4 && bitsRed == ord.bitsRed;
    }
}
