package chat.gui;

import javax.swing.*;
import java.awt.*;

public class AboutDialog extends JDialog {
    public AboutDialog(JFrame frame) {
        super(frame, "Sobre", true);

        JPanel painel = new JPanel(new GridLayout(2, 1));

        JLabel labelCreditos = new JLabel("Créditos de autoria:");

        ImageIcon imagem1 = new ImageIcon("caminho/para/imagem1.jpg"); // Substitua pelo caminho da imagem
        ImageIcon imagem2 = new ImageIcon("caminho/para/imagem2.jpg"); // Substitua pelo caminho da imagem

        JLabel labelIntegrante1 = new JLabel("Nome do Integrante 1", imagem1, JLabel.CENTER);
        JLabel labelIntegrante2 = new JLabel("Nome do Integrante 2", imagem2, JLabel.CENTER);

        painel.add(labelCreditos);
        painel.add(labelIntegrante1);
        painel.add(labelIntegrante2);

        add(painel);

        pack();
        setLocationRelativeTo(frame);
        setResizable(false);
    }
}
