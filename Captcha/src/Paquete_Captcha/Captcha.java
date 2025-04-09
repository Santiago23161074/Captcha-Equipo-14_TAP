package Paquete_Captcha;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.*;

public class Captcha extends Validacion_Captcha
{
    private Random rand = new Random();
    public Captcha ()
    {
        
    }
    public String GenerarCaptcha (int N, int Tipo)
    {
        String caracteres ="";
        switch (Tipo) 
        {
            case 1:
                caracteres = "0123456789";
                break;
            case 2:
                caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
                break;
            case 3:
                caracteres = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
                break;
        }
        StringBuilder captcha = new StringBuilder();
        for (int x = 0; x < N; x++) 
        {
            int posicion = rand.nextInt(caracteres.length());
            captcha.append(caracteres.charAt(posicion));
        }
        return captcha.toString();
    }
    
    public void Restricciones_TxT (JTextField Campo_de_Texto, int Tipo)
    {
        switch (Tipo)
        {
            case 1:
                Campo_de_Texto.addKeyListener(new KeyAdapter() 
                {
                    public void keyTyped(KeyEvent Evento) 
                    {
                        char caracter = Evento.getKeyChar();
                        if (!Character.isDigit(caracter)) 
                        {
                            Evento.consume();
                        }
                    }
                });
                break;
            case 2:
                Campo_de_Texto.addKeyListener(new KeyAdapter() 
                {
                    public void keyTyped(KeyEvent Evento) 
                    {
                        char caracter = Evento.getKeyChar();
                        if (!Character.isLetterOrDigit(caracter) && caracter != ' ' && caracter != 'ñ' && caracter != 'Ñ') {
                            Evento.consume();
                        }
                    }
                });
                break;
        }
    }
    public Image CrearImagen(String Captcha_A_Escribir) 
    {
        int width = 400; 
        int height = 40;
        BufferedImage Imagen_Captcha = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics TextoImagen = Imagen_Captcha.getGraphics();
        TextoImagen.setColor(Color.WHITE);
        TextoImagen.fillRect(0, 0, width, height);
        TextoImagen.setColor(Color.BLACK);
        TextoImagen.setFont(new Font("Arial", Font.BOLD, 20));
        TextoImagen.drawString(Captcha_A_Escribir, 20, 25);
        TextoImagen.dispose();
        return Imagen_Captcha;
    }

    public boolean ValidarCaptcha(String CaptchaIngresado, String CaptchaVerdadero,JLabel resultLabel) 
    {
        if (CaptchaIngresado.equals(CaptchaVerdadero)) 
        {
            resultLabel.setVisible(true);
            resultLabel.setText("Correcto!");
            return true;
        } 
        else 
        {
            resultLabel.setVisible(true);
            resultLabel.setText("Incorrecto. Intente de nuevo.");
            return false;
        }
    }
    
    public void AgregarImagen (Image CaptchaCreado, JLabel lblImagen)
    {
        ImageIcon icono = new ImageIcon (CaptchaCreado);
        lblImagen.setIcon(icono);
        lblImagen.repaint();
    }
}