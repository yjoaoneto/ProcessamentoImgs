package untitled;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
// Classe para manipulação de imagens
public class ManipulaImagem {
    // Método para abrir uma imagem a partir do caminho especificado
    public static BufferedImage abrirImagem(String path)  {
        try {
            // Tenta ler a imagem do arquivo no caminho especificado e retorna
            return ImageIO.read(new File(path));
        } catch(IOException e) {
            // Em caso de exceção ao carregar a imagem, exibe uma mensagem de erro e lança uma exceção RuntimeException
            System.out.println("Erro ao carregar imagem.");
            throw new RuntimeException(e);
        }
    }

    // Método para exibir uma ou mais imagens em uma janela JFrame
    public static void exibirImagem(BufferedImage... imagens) {
        // Cria uma nova janela JFrame com o título "Processamento de imagens"
        JFrame jframe = new JFrame("Processamento de imagens");
        // Define o layout da janela como FlowLayout
        jframe.getContentPane().setLayout(new FlowLayout());
        // Itera sobre todas as imagens fornecidas
        for(BufferedImage img : imagens) {
            // Cria um JLabel com a imagem e adiciona à janela
            JLabel jlabel = new JLabel(new ImageIcon(img));
            jframe.getContentPane().add(jlabel);
        }

        // Faz com que a janela ajuste seu tamanho automaticamente
        jframe.pack();
        // Torna a janela visível
        jframe.setVisible(true);
        // Define o comportamento padrão ao fechar a janela como encerrar o programa
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Método para salvar uma imagem em um arquivo no formato especificado
    public static void salvarImagem(BufferedImage imagem, String formato, String path) {
        try {
            // Tenta escrever a imagem no arquivo no caminho especificado, no formato especificado
            ImageIO.write(imagem, formato, new File(path));
        } catch (IOException e) {
            // Em caso de exceção ao salvar a imagem, exibe uma mensagem de erro e lança uma exceção RuntimeException
            System.out.println("Erro a salvar imagem.");
            throw new RuntimeException(e);
        }
    }
}
