package dispositivos;

public class Ordenador {
    protected int ram;
    protected int hd;
    protected String procesador;
    protected String nombre;
    protected boolean encendido;

    public Ordenador(String nombre){
        this(nombre,4,512,"i3");
        /*
        this.nombre = nombre;
        this.ram = 4;
        this.hd = 512;
        this.procesador = "i3";*/
    }

    public Ordenador(String nombre, int ram, int hd, String procesador){
        this.nombre = nombre;
        this.ram = ram;
        this.hd = hd;
        this.procesador = procesador;
    }


    public void encender(){
        this.encendido = true;
    }

    public void apagar(){
        this.encendido = false;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHd(int hd) {
        this.hd = hd;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String escribir() {
        return "ORDENADOR {" + nombre + "}" +
                "\nRAM: " + ram +
                "\nHD: " + hd +
                "\nPROCESADOR: " + procesador +
                "\nNOMBRE: " + nombre +
                "\nENCENDIDO: " + encendido;
    }
}
