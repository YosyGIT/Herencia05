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

    /**
     * Metodos getters and setters
     * @return get devuelve el tipo
     * set cambia su valor
     */
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
}
