/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidParameterException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Andrés Marín
 */
public class Correos {

    final String username = "soportefbanimal@gmail.com";
    final String password = "xxgjhykacynexeeh";

    public void probandoCorreo(String asunto, String correoReceptor, String mensaje) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            // Define message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setSubject(asunto);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setText(mensaje);
            // Envia el mensaje
            Transport.send(message);
        } catch (Exception e) {
            System.out.println("Holaaa error" + e);
        }
    }

    public boolean Mensajes(String asunto, String correoReceptor, String mensaje) {
        String result = "";
        try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);
            String correoRemitente = "soportefbanimal@gmail.com";
            String passwordRemitente = "xxgjhykacynexeeh";
//            String asunto = "Recuperación de contraseña | Fundación Bello Animal";
//            String mensaje = "<table style=\" max-width: 600px; padding: 10px; margin: 0 auto; border-collapse: collapse; \" > <tr> <td style=\"background-color: #656565; border-radius: 30px\"> <div style=\" color: #fff; margin: 4% 10% 2%; text-align: justify; font-family: sans-serif; \" > <h2 style=\"color: #0ed1f0; margin: 0 0 7px\">Hola, " + u.getNombre() + "!</h2> <p style=\"margin: 2px; font-size: 15px\"> Lorem ipsum dolor sit amet consectetur adipiscing elit, turpis ullamcorper orci fusce quam consequat malesuada convallis, molestie nostra non commodo ante lacinia. Semper ultricies purus blandit class molestie aliquam pulvinar vitae ad duis lacinia, tristique nisl ultrices suspendisse primis quisque et integer habitant. Aenean eleifend tincidunt nec dictum platea ut egestas, velit nisl proin convallis sapien vivamus luctus, volutpat aptent ante a lectus facilisis. </p> <br><br> <p style=\"margin: 2px; font-size: 15px\"> ¡No te preocupes te ayudamos a recuperar tú contraseña! </p> <div style=\" width: 100%; margin: 20px 0; display: inline-block; text-align: center; \" > <h3 style=\"margin: 2px; font-size: 18px\">La contraseña registrada es: " + passDesencriptada + "</h3> </div> <div style=\"width: 100%; text-align: center\"> <a style=\" text-decoration: none; border-radius: 5px; padding: 11px 23px; color: white; background-color: #3498db; \" href=\"http://localhost:8080/Fundacion_BA/login.jsp\" >Ingresar al sitio web</a > </div> <p style=\" color: #b3b3b3; font-size: 12px; text-align: center; margin: 30px 0 0; \" > Fundacion Bello Animal </p> </div> </td> </tr> </table>";

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje, "ISO-8859-1", "html");

            try ( Transport t = session.getTransport("smtp")) {
                t.connect(correoRemitente, passwordRemitente);
                t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            }

            result = "Enviado";

        } catch (AddressException ex) {
            System.out.println("Errro en addres ee + " + ex);
        } catch (MessagingException ex) {
            System.out.println("Errro en message e22qe +" + ex);
        }

        return "Enviado".equals(result);
    }

    public boolean enviarCorreo(String mensaje, String asunto) {
        boolean enviado = false;
        try {
            String de = "soportefbanimal@gmail.com";
            String clave
                    = "xxgjhykacynexeeh";
            String para = "felipemarin0152@gmail.com";
            String host = "smtp.gmail.com";

            Properties prop = System.getProperties();

            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.host", host);
            prop.put("mail.smtp.user", de);
            prop.put("mail.smtp.password", clave);
            prop.put("mail.smtp.port", 587);
            prop.put("mail.smtp.auth", "true");

            Session sesion = Session.getDefaultInstance(prop, null);

            MimeMessage message = new MimeMessage(sesion);

            message.setFrom(new InternetAddress(de));

            message.setRecipient(Message.RecipientType.TO, new InternetAddress(para));

            message.setSubject("rfrqrqeqwqwq");
            message.setText("holasasasaas");

            Transport transport = sesion.getTransport("smtp");

            transport.connect(host, de, clave);

            transport.sendMessage(message, message.getAllRecipients());

            transport.close();

            enviado = true;

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return enviado;
    }
 

}
