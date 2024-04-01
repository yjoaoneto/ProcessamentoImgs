package untitled;

import java.awt.*;
import java.awt.image.BufferedImage;


public class FiltrosPontuais {

    // Método para extrair a banda vermelha de uma imagem
    public static BufferedImage bandaR(BufferedImage imgEntrada) {

        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();

        // Cria uma nova imagem de saída com as mesmas dimensões da imagem de entrada e tipo RGB - 1°
        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_RGB);

        // Repete sobre os pixels da imagem
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {

                // Pega a cor de cada pixel da imagem
                Color cor = new Color(imgEntrada.getRGB(w, h));

                // Separa a parte vermelha da imagem, sem exibir a parte verde e azul
                Color novaCor = new Color (cor.getRed(), 0 ,0);

                // Define a cor no pixel da nova imagem
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    // Método para extrair a banda verde de uma imagem - 2°
    public static BufferedImage bandaG(BufferedImage imgEntrada) {


        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();


        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_RGB);

        // Repete sobre os pixels da imagem
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                // Pega a cor de cada pixel da imagem
                Color cor = new Color(imgEntrada.getRGB(w, h));


                Color novaCor = new Color (0, cor.getGreen() ,0);


                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    // Método para extrair a banda azul de uma imagem - 3°
    public static BufferedImage bandaB(BufferedImage imgEntrada) {

        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();


        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_RGB);


        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {

                Color cor = new Color(imgEntrada.getRGB(w, h));


                Color novaCor = new Color (0, 0 ,cor.getBlue());


                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    // Método para converter uma imagem em tons de cinza apenas na banda azul - 1°
    public static BufferedImage FiltroCinzaParaBandaB(BufferedImage imgEntrada) {
        // Obtém a largura e a altura da imagem de entrada
        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();

        // Cria uma nova imagem de saída com as mesmas dimensões da imagem de entrada e tipo RGB
        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_RGB);

        // Itera sobre os pixels da imagem
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                // Obtém a cor do pixel na posição (w, h)
                Color cor = new Color(imgEntrada.getRGB(w, h));

                // Cria uma nova cor usando apenas a componente azul como valor de intensidade para todas as bandas de cor (R, G, B)
                Color novaCor = new Color (cor.getBlue(), cor.getBlue() ,cor.getBlue());

                // Define a cor no pixel da nova imagem
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    // Método para converter uma imagem em tons de cinza apenas na banda vermelha - 2°
    public static BufferedImage FiltroCinzaParaBandaR(BufferedImage imgEntrada) {

        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();


        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_RGB);


        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {

                Color cor = new Color(imgEntrada.getRGB(w, h));


                Color novaCor = new Color (cor.getRed(), cor.getRed() ,cor.getRed());


                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    // Método para converter uma imagem em tons de cinza apenas na banda verde - 3°
    public static BufferedImage FiltroCinzaParaBandaG(BufferedImage imgEntrada) {

        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();


        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_RGB);


        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {

                Color cor = new Color(imgEntrada.getRGB(w, h));


                Color novaCor = new Color (cor.getGreen(), cor.getGreen() ,cor.getGreen());


                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    // Método para converter uma imagem para tons de cinza pela média das componentes RGB
    public static BufferedImage FiltroCinzaParaMedia(BufferedImage imgEntrada) {
        // Obtém a largura e a altura da imagem de entrada
        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();

        // Cria uma nova imagem de saída com as mesmas dimensões da imagem de entrada e tipo RGB
        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_RGB);

        // Itera sobre os pixels da imagem
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                // Obtém a cor do pixel na posição (w, h)
                Color cor = new Color(imgEntrada.getRGB(w, h));

                // Calcula a média das componentes RGB
                int green = cor.getGreen();
                int blue = cor.getBlue();
                int red = cor.getRed();
                int media = (green + blue + red) / 3;

                // Cria uma nova cor usando a média como valor de intensidade para todas as bandas de cor (R, G, B)
                Color novaCor = new Color (media, media ,media);

                // Define a nova cor no pixel da imagem de saída
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    // Método para aplicar um filtro de limiarização em uma imagem em tons de cinza
    public static BufferedImage FiltroLimiarizacao(BufferedImage imgEntrada) {
        // Obtém a largura e a altura da imagem de entrada
        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();

        // Cria uma nova imagem de saída com as mesmas dimensões da imagem de entrada e tipo RGB
        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_RGB);

        // Converte a imagem de entrada para tons de cinza pela média das componentes RGB
        BufferedImage imgnewSaida = FiltrosPontuais.FiltroCinzaParaMedia(imgEntrada);

        // Cor para representar pixels pretos e brancos na imagem de saída
        Color novaCor;

        // Itera sobre os pixels da imagem
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                // Obtém a cor do pixel na posição (w, h)
                Color cor = new Color(imgnewSaida.getRGB(w, h));

                // Se a intensidade for menor que 170, considera-se como branco, caso contrário, como preto
                if (cor.getRed() < 170) {
                    novaCor = new Color (255, 255 ,255); // Branco
                } else {
                    novaCor = new Color (0, 0 ,0); // Preto
                }

                // Define a nova cor no pixel da imagem de saída
                imgnewSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgnewSaida;
    }

    public static BufferedImage filtroNegativo(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage imgSaida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Itera sobre todos os pixels da imagem
        for(int h = 0; h < height; h++) {
            for(int w = 0; w < width; w++) {
                // Obtém a cor do pixel atual
                Color cor = new Color(img.getRGB(w, h));
                // Calcula o negativo da cor e atribui à nova cor
                Color novaCor = new Color(255 - cor.getRed(), 255 - cor.getGreen() ,255 - cor.getBlue());
                // Define a nova cor no pixel correspondente na imagem de saída
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imgSaida;
    }
}
