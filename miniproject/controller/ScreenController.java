package miniproject.controller;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import miniproject.exception.InvalidValueException;
import miniproject.view.CalculateScreen;
import miniproject.view.Screen;

public class ScreenController implements ActionListener, KeyListener{
    
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

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            try {
                var dados = sc.getData();
                CalculateScreen calculate = new CalculateScreen(dados);
                calculate.getX();
            } catch (InvalidValueException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}   
}
