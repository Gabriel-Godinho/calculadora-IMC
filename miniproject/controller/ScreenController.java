package miniproject.controller;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import miniproject.entity.Entity;
import miniproject.exception.InvalidValueException;
import miniproject.view.ResultScreen;
import miniproject.view.Screen;

public class ScreenController implements ActionListener, KeyListener {
    
    private final Screen MAIN_SCREEN;
    
    public ScreenController(Screen sc) {
        this.MAIN_SCREEN = sc;
    }

    private void showResultScreen() {
        try {
            Entity data = MAIN_SCREEN.getData();
            ResultScreen resultScreen = new ResultScreen(data);
        } catch (InvalidValueException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        showResultScreen();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            showResultScreen();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

}
