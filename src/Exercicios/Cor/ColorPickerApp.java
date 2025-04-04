package Exercicios.Cor;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorPickerApp extends JFrame {
    private JComboBox<String> colorComboBox;
    private DrawPanel drawPanel;

    public ColorPickerApp() {
        setTitle("Selecionador de Cores");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Criando um JComboBox com as cores da ColorPalette
        colorComboBox = new JComboBox<>(seletorCor.getColors().toArray(new String[0]));
        JButton drawButton = new JButton("Desenhar");

        // Painel superior para selecionar a cor
        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Escolha uma cor:"));
        controlPanel.add(colorComboBox);
        controlPanel.add(drawButton);

        // Painel de desenho
        drawPanel = new DrawPanel();

        // Adicionando componentes à tela
        add(controlPanel, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);

        // Ação do botão
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColor = (String) colorComboBox.getSelectedItem();
                drawPanel.setColor(seletorCor.getColor(selectedColor));
                drawPanel.repaint();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ColorPickerApp app = new ColorPickerApp();
            app.setVisible(true);
        });
    }
}

// Painel de desenho que exibe um círculo na cor selecionada
class DrawPanel extends JPanel {
    private Color color = Color.BLACK;

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillOval(100, 100, 150, 150); // Desenha um círculo
    }
}
