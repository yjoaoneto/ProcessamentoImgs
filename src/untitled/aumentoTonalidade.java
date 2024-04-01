package untitled;

import java.awt.Color;
import java.awt.image.BufferedImage;

// Classe para aumentar a tonalidade de uma imagem
public class aumentoTonalidade {

    // Método para alterar a banda vermelha da imagem
    static BufferedImage mudarBandaR(BufferedImage img, float valor) {
        // Obtém a largura e a altura da imagem
        int width = img.getWidth();
        int height = img.getHeight();

        // Cria uma nova imagem de saída com as mesmas dimensões da imagem original e tipo RGB
        BufferedImage imgSaida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Itera sobre os pixels da imagem
        for(int h = 0; h < height; h++) {
            for(int w = 0; w < width; w++) {
                // Obtém a cor do pixel na posição (w, h)
                Color cor = new Color(img.getRGB(w, h));

                // Calcula a nova intensidade vermelha aplicando a função de validação
                int newred = validarCor((int) valor, cor.getRed());

                // Cria uma nova cor com a intensidade vermelha alterada e as mesmas intensidades de verde e azul
                Color novaCor = new Color(newred, cor.getGreen(), cor.getBlue());

                // Define a nova cor do pixel na imagem de saída
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }

        // Retorna a imagem de saída com a banda vermelha modificada
        return imgSaida;
    }

    // Método para alterar a banda verde da imagem
    static BufferedImage mudarBandaG(BufferedImage img, float valor) {
        // Obtém a largura e a altura da imagem
        int width = img.getWidth();
        int height = img.getHeight();

        // Cria uma nova imagem de saída com as mesmas dimensões da imagem original e tipo RGB
        BufferedImage imgSaida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Itera sobre os pixels da imagem
        for(int h = 0; h < height; h++) {
            for(int w = 0; w < width; w++) {
                // Obtém a cor do pixel na posição (w, h)
                Color cor = new Color(img.getRGB(w, h));

                // Calcula a nova intensidade verde aplicando a função de validação
                int newgree = validarCor((int) valor, cor.getGreen());

                // Cria uma nova cor com a intensidade verde alterada e as mesmas intensidades de vermelho e azul
                Color novaCor = new Color(cor.getRed(), newgree, cor.getBlue());

                // Define a nova cor do pixel na imagem de saída
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }

        // Retorna a imagem de saída com a banda verde modificada
        return imgSaida;
    }

    // Método para alterar a banda azul da imagem
    static BufferedImage mudarBandaB(BufferedImage img, float valor) {
        // Obtém a largura e a altura da imagem
        int width = img.getWidth();
        int height = img.getHeight();

        // Cria uma nova imagem de saída com as mesmas dimensões da imagem original e tipo RGB
        BufferedImage imgSaida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Itera sobre os pixels da imagem
        for(int h = 0; h < height; h++) {
            for(int w = 0; w < width; w++) {
                // Obtém a cor do pixel na posição (w, h)
                Color cor = new Color(img.getRGB(w, h));

                // Calcula a nova intensidade azul aplicando a função de validação
                int newblue = validarCor((int) valor, cor.getBlue());

                // Cria uma nova cor com a intensidade azul alterada e as mesmas intensidades de vermelho e verde
                Color novaCor = new Color(cor.getRed(), cor.getGreen(), newblue);

                // Define a nova cor do pixel na imagem de saída
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }

        // Retorna a imagem de saída com a banda azul modificada
        return imgSaida;
    }

    // Método para mudar todas as bandas de cor da imagem
    static BufferedImage mudarTodasBandas(BufferedImage img, float valor) {
        // Obtém a largura e a altura da imagem
        int width = img.getWidth();
        int height = img.getHeight();

        // Cria uma nova imagem de saída com as mesmas dimensões da imagem original e tipo RGB
        BufferedImage imgSaida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Itera sobre os pixels da imagem
        for(int h = 0; h < height; h++) {
            for(int w = 0; w < width; w++) {
                // Obtém a cor do pixel na posição (w, h)
                Color cor = new Color(img.getRGB(w, h));

                // Calcula as novas intensidades de cada banda de cor aplicando a função de validação
                int resultBlue = validarCor((int) valor, cor.getBlue());
                int resultnewGreen = validarCor((int) valor, cor.getGreen());
                int resultnewRed = validarCor((int) valor, cor.getRed());

                // Cria uma nova cor com as intensidades de todas as bandas alteradas
                Color novaCor = new Color(resultnewRed, resultnewGreen, resultBlue);

                // Define a nova cor do pixel na imagem de saída
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }

        // Retorna a imagem de saída com todas as bandas de cor modificadas
        return imgSaida;
    }

    // Método para aumentar o componente Y (luminância) de uma imagem no espaço de cores YIQ
    static BufferedImage mudarAditivoY(BufferedImage img, float valor) {
        // Obtém a largura e a altura da imagem
        int width = img.getWidth();
        int height = img.getHeight();

        // Cria uma nova imagem de saída com as mesmas dimensões da imagem original e tipo RGB
        BufferedImage imgSaida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Converte a imagem para o espaço de cores YIQ
        double[][][] matriz = Converter.rbgParaYIQmatriz(img);

        // Itera sobre os valores de luminância na matriz YIQ e aumenta o valor
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j][0] = matriz[i][j][0] + valor;
            }
        }

        // Converte a imagem de volta para o espaço de cores RGB e retorna
        return Converter.converterRGB(matriz, imgSaida);
    }

    // Função para validar o valor de uma componente de cor (R, G, ou B)
    static int validarCor(int valor, int cor) {
        cor += valor;

        // Verificar se o valor está dentro do intervalo válido [0, 255]
        if(cor > 255)
            return 255;
        else if (cor < 0)
            return 0;
        return cor;
    }

    // Função para validar o valor de uma componente de cor (R, G, ou B)
    // Não aceita valores negativos, apenas força o valor para dentro do intervalo válido [0, 255]
    static int validarCor(int cor) {
        if(cor > 255)
            return 255;
        else if (cor < 0)
            return 0;
        return cor;
    }
}