package servidores;

public interface IPable {
    void establecer(int ip1, int ip2, int ip3, int ip4, int bitsRed, String nombre);
    IPable objeterHost();
    IPable obtenerRed();
}
