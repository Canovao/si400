package chat.gui;

import javax.swing.*;

public class ChatWindow extends JFrame {
    private final JTextArea areaTexto;

    public ChatWindow() {
        setTitle("Chat");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        add(scrollPane);

        setVisible(true);
    }

    public void adicionarMensagem(String mensagem) {
        areaTexto.append(mensagem + "\n");
    }

    public void limparAreaTexto() {
        areaTexto.setText("");
    }
}
