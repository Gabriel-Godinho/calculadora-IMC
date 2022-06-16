package miniproject.view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.InsetsUIResource;

import miniproject.controller.ScreenController;
import miniproject.entity.Entity;
import miniproject.exception.InvalidValueException;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class Screen extends JFrame{
    
    private JPanel center = new JPanel();
    private JPanel south = new JPanel();
    private JButton calc = new JButton("Calcular");
    private JTextField weight = new JTextField(8);
    private JTextField high = new JTextField(8);
    private JLabel weightLabel = new JLabel("Peso (Kg)");
    private JLabel highLabel = new JLabel("Altura (em metros)");
    private ScreenController controller = new ScreenController(this);
        
    public Screen() {
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("IMC");
        createScreen();
        setVisible(true);
    }

    private void createScreen() {       
        add(south, "South");
        south.setBackground(new ColorUIResource(130, 188, 224));

        add(center, "Center");
        center.setBorder(BorderFactory.createTitledBorder("Cálculo IMC"));
        center.setLayout(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.insets = new InsetsUIResource(5, 5, 5, 5);

        cons.gridx = 0;
        cons.gridy = 0;
        center.add(weightLabel, cons);

        cons.gridx = 1;
        cons.gridy = 0;
        center.add(weight, cons);

        cons.gridx = 0;
        cons.gridy = 1;
        center.add(highLabel, cons);

        cons.gridx = 1;
        cons.gridy = 1;
        center.add(high, cons);

        south.add(calc);
        calc.addActionListener(controller);
    }
    
    public Entity getData() throws InvalidValueException{
        Entity newEntity = new Entity();

        try {
            newEntity.setHigh(Float.parseFloat(high.getText()));
            newEntity.setWeight(Float.parseFloat(weight.getText()));
        } catch (NumberFormatException e) {
            throw new InvalidValueException("Erro de conversão! Insira apenas números.");
        }
        
        return newEntity;
    }
}
