package chat.gui;

import javax.swing.*;
import java.awt.*;

public class ConnectionDialog extends JDialog {
    private final JTextField campoIP;
    private final JTextField campoPorta;
    private final JButton botaoConectar;

    public ConnectionDialog(JFrame frame) {
        super(frame, "Conectar", true);

        JPanel painel = new JPanel(new GridLayout(3, 2));

        JLabel labelIP = new JLabel("IP:");
        campoIP = new JTextField();
        JLabel labelPorta = new JLabel("Porta:");
        campoPorta = new JTextField();

        botaoConectar = new JButton("Conectar");
        botaoConectar.addActionListener(e -> dispose());

        painel.add(labelIP);
        painel.add(campoIP);
        painel.add(labelPorta);
        painel.add(campoPorta);
        painel.add(botaoConectar);

        add(painel);

        pack();
        setLocationRelativeTo(frame);
        setResizable(false);
    }

    public String getIP() {
        return campoIP.getText();
    }

    public int getPorta() {
        return Integer.parseInt(campoPorta.getText());
    }
}
