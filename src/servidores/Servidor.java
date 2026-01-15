package servidores;

public class Servidor implements IPable{
    protected int tipo;

    public Servidor(String nombre){

    }

    public Servidor(int ip1, int ip2, int ip3, int ip4){

    }

    public Servidor(int ip1, int ip2, int ip3, int ip4, int bitsRed){

    }

    public Servidor(int ip1, int ip2, int ip3, int ip4, int bitsRed, int tipo){

    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public void establecer(int ip1, int ip2, int ip3, int ip4, int bitsRed, String nombre){

    }

    @Override
    public IPable objeterHost() {
        return null;
    }

    @Override
    public IPable obtenerRed() {
        return null;
    }

    @Override
    public int obtenerBinarioInt(String binario) {
        int bin;
        if (binario.matches("[10]+")){
            bin = Integer.parseInt(binario);
            return bin;
        }
        return -1;
    }

    @Override
    public String obtenerBin(int entero) {
        String bin = String.valueOf(entero);
        if (bin.matches("[10]+")){
            return bin;
        }
        return "";
    }
}
