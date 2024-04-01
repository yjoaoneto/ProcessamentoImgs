package untitled;

import java.awt.*;
import java.awt.image.BufferedImage;
import untitled.FiltrosPontuais;
import untitled.aumentoTonalidade;
import untitled.Converter;

public class Main {

    public static void main(String[] args)  {

        // Carrega uma imagem do arquivo selecionado usando o método abrirImagem
        BufferedImage imagem = ManipulaImagem.abrirImagem("morumbi.jpg");

        // Ao exibir a imagem com o uso do método, passamos nos parâmetros a imagem desejada, sem a necessidade de instânciar as classes graças a importação,
        // puxamos o métodos de manipulação que quisermos, seja ele de luminosidade da imagem, ou de coloração por meio dos pixels RGB
        ManipulaImagem.exibirImagem(imagem,FiltrosPontuais.FiltroCinzaParaBandaG(imagem));

        // Salva a imagem original em um arquivo do formato JPG sobreescrevendo a imagem com o método ImageIO.write da classe salvarImagem
        ManipulaImagem.salvarImagem(imagem, "jpg", "morumbi.png");

    }






}