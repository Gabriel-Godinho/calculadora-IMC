package miniproject.controller;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

import miniproject.exception.InvalidValueException;
import miniproject.view.CalculateScreen;
import miniproject.view.Screen;

public class ScreenController implements ActionListener{
    
    private Screen sc;
    
    public ScreenController(Screen sc) {
        this.sc = sc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            var dados = sc.getData();
            CalculateScreen calculate = new CalculateScreen(dados);
            calculate.getX();
        } catch (InvalidValueException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }   
}
