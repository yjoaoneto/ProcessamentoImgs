package untitled;

import java.awt.*;
import java.awt.image.BufferedImage;
import untitled.aumentoTonalidade;

// Classe para realizar conversões entre espaços de cores e operações relacionadas
public class Converter {

    // Método para converter uma imagem do espaço de cores RGB para YIQ
    static BufferedImage rbgParaYIQ(BufferedImage img) {
        // Declaração de variáveis para as componentes YIQ
        int Ycolor, Icolor, Qcolor;

        // Obtém a largura e a altura da imagem
        int width = img.getWidth();
        int height = img.getHeight();

        // Cria uma nova imagem de saída com as mesmas dimensões da imagem original e tipo RGB
        BufferedImage imgSaida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Itera sobre os pixels da imagem
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                // Obtém a cor do pixel na posição (w, h)
                Color cor = new Color(img.getRGB(w, h));

                // Obtém as intensidades de vermelho, verde e azul do pixel
                int newgree = cor.getGreen();
                int newblue = cor.getBlue();
                int newred = cor.getRed();

                // Calcula as componentes YIQ
                Ycolor = (int) (0.299 * newred + 0.587 * newgree + 0.114 * newblue);
                Icolor = (int) (0.596 * newred - 0.274 * newgree - 0.322 * newblue);
                Qcolor = (int) (0.211 * newred - 0.523 * newgree + 0.312 * newblue);

                // Imprime os valores das componentes YIQ para depuração
                System.out.println(Ycolor + "-y");
                System.out.println(Icolor + "-i");
                System.out.println(Qcolor + "-q");

                // Valida os valores das componentes YIQ
                Ycolor = aumentoTonalidade.validarCor(Ycolor);
                Icolor = aumentoTonalidade.validarCor(Icolor);
                Qcolor = aumentoTonalidade.validarCor(Qcolor);

                // Cria uma nova cor com as componentes YIQ e define no pixel da imagem de saída
                Color novaCor = new Color(Ycolor, Icolor, Qcolor);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }

        // Retorna a imagem de saída no espaço de cores YIQ
        return imgSaida;
    }

    // Método para converter uma imagem do espaço de cores RGB para YIQ e retornar uma matriz de valores YIQ
    static double[][][] rbgParaYIQmatriz(BufferedImage img) {
        // Declaração de variáveis para as componentes YIQ
        int Ycolor, Icolor, Qcolor;

        // Obtém a largura e a altura da imagem
        int width = img.getWidth();
        int height = img.getHeight();

        // Cria uma matriz para armazenar os valores YIQ de cada pixel da imagem
        double matriz[][][] = new double[width][height][3];

        // Itera sobre os pixels da imagem
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                // Obtém a cor do pixel na posição (w, h)
                Color cor = new Color(img.getRGB(w, h));

                // Obtém as intensidades de vermelho, verde e azul do pixel
                int newgree = cor.getGreen();
                int newblue = cor.getBlue();
                int newred = cor.getRed();

                // Calcula as componentes YIQ
                Ycolor = (int) (0.299 * newred + 0.587 * newgree + 0.114 * newblue);
                Icolor = (int) (0.596 * newred - 0.274 * newgree - 0.322 * newblue);
                Qcolor = (int) (0.211 * newred - 0.523 * newgree + 0.312 * newblue);

                // Imprime os valores das componentes YIQ para depuração
                System.out.println(Ycolor + "-y");
                System.out.println(Icolor + "-i");
                System.out.println(Qcolor + "-q");
                System.out.println("-------------------------------");

                // Armazena os valores YIQ na matriz
                matriz[w][h][0] = Ycolor;
                matriz[w][h][1] = Icolor;
                matriz[w][h][2] = Qcolor;
            }
        }

        // Retorna a matriz de valores YIQ
        return matriz;
    }

    // Método para aplicar um efeito de negativo na componente Y (luminância) de uma imagem no espaço de cores YIQ
    static BufferedImage negativoY(BufferedImage img) {
        // Obtém a largura e a altura da imagem
        int width = img.getWidth();
        int height = img.getHeight();

        // Cria uma nova imagem de saída com as mesmas dimensões da imagem original e tipo RGB
        BufferedImage imgSaida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Converte a imagem para o espaço de cores YIQ
        double[][][] matriz = rbgParaYIQmatriz(img);

        // Itera sobre os valores de luminância na matriz YIQ e aplica o efeito de negativo
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j][0] = 255 - matriz[i][j][0]; // Negativo da componente Y
            }
        }

        // Converte a imagem de volta para o espaço de cores RGB e retorna
        return converterRGB(matriz, imgSaida);
    }

    // Método para converter uma matriz de valores YIQ de volta para o espaço de cores RGB
    // Método para converter uma imagem do espaço de cores YIQ de volta para o espaço de cores RGB
    static BufferedImage converterRGB(double[][][] matrizYIQ, BufferedImage img) {
        // Obtém a largura e a altura da imagem
        int width = img.getWidth();
        int height = img.getHeight();

        // Cria uma nova imagem de saída com as mesmas dimensões da imagem original e tipo RGB
        BufferedImage imgSaida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Itera sobre os pixels da imagem
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                // Calcula os valores das componentes de cor RGB a partir da matriz YIQ
                int r = (int) (1 * matrizYIQ[i][j][0] + 0.956 * matrizYIQ[i][j][1] + 0.621 * matrizYIQ[i][j][2]);
                int g = (int) (1 * matrizYIQ[i][j][0] - 0.272 * matrizYIQ[i][j][1] - 0.647 * matrizYIQ[i][j][2]);
                int b = (int) (1 * matrizYIQ[i][j][0] - 1.106 * matrizYIQ[i][j][1] + 1.703 * matrizYIQ[i][j][2]);

                // Valida os valores das componentes de cor RGB para garantir que estejam no intervalo [0, 255]
                int resultBlue = aumentoTonalidade.validarCor(r);
                int resultnewGreen = aumentoTonalidade.validarCor(g);
                int resultnewRed = aumentoTonalidade.validarCor(b);

                // Cria uma nova cor com as componentes de cor RGB validadas
                Color color = new Color(resultBlue, resultnewGreen, resultnewRed);

                // Define a nova cor no pixel correspondente da imagem de saída
                imgSaida.setRGB(i, j, color.getRGB());
            }
        }

        // Retorna a imagem de saída convertida para o espaço de cores RGB
        return imgSaida;
    }
}

