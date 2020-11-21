package dev.ivanqueiroz.jbin3dec.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Conversor {
    private Conversor() {
    }

    public static double bin2dec(String bin) {

        double resultado = 0.0;
        int count = 0;
        StringBuilder calculo = new StringBuilder();

        for (int i = bin.length() - 1; i >= 0; i--) {

            final int binVal = Character.getNumericValue(bin.charAt(count));
            if (binVal != 1 && binVal != 0) {
                throw new IllegalArgumentException("Só é permitido números binários!");
            }
            final double potenciaVal = Math.pow(2, i);
            resultado += binVal * potenciaVal;

            calculo.append("(").append(binVal).append(" x 2^").append(i).append(") + ");
            count++;
        }
        calculo.replace(calculo.lastIndexOf("+"), calculo.length(), "");
        log.info(calculo.toString());
        return resultado;
    }
}
