package servidores;

public class UtilBin {
    /*
    public static int obtenerBinario2(String binario){
        int bin;
        int [] conversion = new int [binario.length()];
        if (binario.matches("[01]+")){
            bin = Integer.parseInt(binario);
            for (int i = (binario.length() - 1); i > 0; i--){
                conversion[i] = bin % 2;
                if (i == 1){
                    conversion[i] = bin / 2;
                }
            }
            bin =
            return bin;
        }
        return -1;
    }*/

    public static int obtenerBinario(String binario){
        int resultado = 0;
        int peso = 1;
        if(binario.matches("[01]+")) {
            for (int i = binario.length()-1; i >= 0; i--) {
                resultado += (binario.charAt(i) - '0') * peso;
                peso *= 2;
            }
            return resultado;
        }
        else{
            return -1;
        }
    }

    public static String obtenerBin(int entero){
        String resultado;
        while(entero != 0){

        }
        return "";
    }
}
