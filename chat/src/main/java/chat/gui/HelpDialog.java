package chat.gui;

import javax.swing.*;

public class HelpDialog extends JDialog {
    public HelpDialog(JFrame frame) {
        super(frame, "Ajuda", true);

        JTextArea areaTexto = new JTextArea(
                "Este programa permite a comunicação por texto entre duas máquinas\n"
                        + "via TCP/IP. Para começar, abra uma conexão informando o IP e a porta.\n"
                        + "Depois, basta digitar as mensagens na caixa de texto e pressionar Enter."
        );
        areaTexto.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(areaTexto);

        add(scrollPane);

        setSize(300, 200);
        setLocationRelativeTo(frame);
        setResizable(false);
    }
}
