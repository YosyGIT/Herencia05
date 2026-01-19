package servidores;

public class UtilBin{
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
        int resto;
        String binarioRev = "";
        String binarioFin = "";
        if(entero > 0) {
            while (entero > 0){
                resto = entero % 2;
                binarioRev += resto;
                entero /= 2;
            }
            for (int i = binarioRev.length() - 1; i >= 0; i--){
                binarioFin += binarioRev.charAt(i);
            }
            return binarioFin;
        }
        else{
            return "-1";
        }

    }

    public static String obtenerBinario8 (int numero){
        String binario = obtenerBin(numero);
        if (binario.isEmpty() || binario.length() > 8){
            return "-1";
        }else{
            String ceros = "";
            for (int i = 0; i <= 8 - binario.length(); i++){
                ceros += "0";
            }
            return ceros + binario;
        }
    }

    public static boolean confirmarIp(int ip1, int ip2, int ip3, int ip4){
        return (ip1 >= 0 && ip1 <= 255) && (ip2 >= 0 && ip2 <= 255) &&
                (ip3 >= 0 && ip3 <= 255) && (ip4 >= 0 && ip4 <= 255);
    }
}
