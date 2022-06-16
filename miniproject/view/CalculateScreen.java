package miniproject.view;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.InsetsUIResource;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import miniproject.entity.Entity;
import miniproject.exception.InvalidValueException;
import miniproject.service.ServiceIMC;

public class CalculateScreen extends JDialog{

    private ServiceIMC service = new ServiceIMC();
    private JPanel center = new JPanel();
    private JPanel south = new JPanel();
    private JLabel label_one = new JLabel();
    private JLabel label_two = new JLabel();
    private Entity data;
   
    public CalculateScreen(Entity data) {
        
        this.data = data;
        
        setSize(350, 250);
        setLocationRelativeTo(null);
        setTitle("Resultado");
        createScreen();
        setModal(true);
        setVisible(true);
    }

    private void createScreen() {

        add(south, "South");
        south.setBackground(new ColorUIResource(130, 188, 224));

        float calc = 0;

        try {
            calc = service.calculate(this.data);
        } catch (InvalidValueException exc) {
            JOptionPane.showMessageDialog(null, exc.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        if (calc < 18.5f) {
            label_one.setText("Abaixo do peso\n");
            label_two.setText(String.format("\nO resultado do seu IMC é igual a %.2f", calc));
        } else if (calc >= 18.5f && calc <= 24.9f) {
            label_one.setText("Peso normal\n");
            label_two.setText(String.format("\nO resultado do seu IMC é igual a %.2f", calc));
        } else if (calc >= 25f && calc <= 29.9f) {
            label_one.setText("Sobrepeso\n");
            label_two.setText(String.format("\nO resultado do seu IMC é igual a %.2f", calc));
        } else if (calc >= 30f && calc <= 34.9f) {
            label_one.setText("Obesidade grau I\n");
            label_two.setText(String.format("\nO resultado do seu IMC é igual a %.2f", calc));
        } else if (calc >= 35f && calc <= 39.9f) {
            label_one.setText("Obesidade grau II\n");
            label_two.setText(String.format("\nO resultado do seu IMC é igual a %.2f", calc));
        } else if (calc >= 40) {
            label_one.setText("Obesidade grau III\n");
            label_two.setText(String.format("\nO resultado do seu IMC é igual a %.2f", calc));
        } else {
            label_one.setText("Vazio\n");
        }

        add(center, "Center");
        center.setBorder(BorderFactory.createTitledBorder("Cálculo Imc"));
        center.setLayout(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.insets = new InsetsUIResource(5, 5, 5, 5);

        cons.gridx = 0;
        cons.gridy = 0;
        center.add(label_one, cons);

        cons.gridx = 0;
        cons.gridy = 1;
        center.add(label_two, cons);
    }
}
