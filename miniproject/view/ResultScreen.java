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

public class ResultScreen extends JDialog {

    private ServiceIMC service = new ServiceIMC();
    private JPanel center = new JPanel();
    private JPanel south = new JPanel();
    private JLabel labelClassification = new JLabel();
    private JLabel labelResult = new JLabel();
    private Entity data;
   
    public ResultScreen(Entity data) {
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

        try {
            double result = service.calculate(this.data);

            if (result < 18.5) {
                labelClassification.setText("Abaixo do peso\n");
                labelResult.setText(String.format("\nO resultado do seu IMC é igual a %.2f", result));
            } else if (result >= 18.5 && result <= 24.9) {
                labelClassification.setText("Peso normal\n");
                labelResult.setText(String.format("\nO resultado do seu IMC é igual a %.2f", result));
            } else if (result >= 25 && result <= 29.9) {
                labelClassification.setText("Sobrepeso\n");
                labelResult.setText(String.format("\nO resultado do seu IMC é igual a %.2f", result));
            } else if (result >= 30 && result <= 34.9) {
                labelClassification.setText("Obesidade grau I\n");
                labelResult.setText(String.format("\nO resultado do seu IMC é igual a %.2f", result));
            } else if (result >= 35 && result <= 39.9) {
                labelClassification.setText("Obesidade grau II\n");
                labelResult.setText(String.format("\nO resultado do seu IMC é igual a %.2f", result));
            } else if (result >= 40) {
                labelClassification.setText("Obesidade grau III\n");
                labelResult.setText(String.format("\nO resultado do seu IMC é igual a %.2f", result));
            } else {
                labelClassification.setText("Não foi possível calcular o seu IMC com os dados inseridos!\n");
            }
        } catch (InvalidValueException exc) {
            JOptionPane.showMessageDialog(null, exc.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }

        add(center, "Center");
        center.setBorder(BorderFactory.createTitledBorder("Cálculo IMC"));
        center.setLayout(new GridBagLayout());

        GridBagConstraints cons = new GridBagConstraints();
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.insets = new InsetsUIResource(5, 5, 5, 5);

        cons.gridx = 0;
        cons.gridy = 0;
        center.add(labelClassification, cons);

        cons.gridx = 0;
        cons.gridy = 1;
        center.add(labelResult, cons);
    }

}
