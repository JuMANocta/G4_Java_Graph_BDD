package com.example;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Form extends JFrame {
    // de créer une fenetre de formulaire
    // contenant des inputs afin de remplir d'informations
    // la BDD
    // les informations sont : Nom Prénom Age Sexe Adresse Code postale Ville
    JLabel labelNom = new JLabel("Nom");
    JLabel labelPrenom = new JLabel("Prénom");
    JLabel labelAge = new JLabel("Age");
    JLabel labelSexe = new JLabel("Sexe");
    JLabel labelAdresse = new JLabel("Adresse");
    JLabel labelCodePostal = new JLabel("Code postal");
    JLabel labelVille = new JLabel("Ville");
    
    JTextField nom = new JTextField();
    JTextField prenom = new JTextField();
    JTextField age = new JTextField();
    JTextField sexe = new JTextField();
    JTextField adresse = new JTextField();
    JTextField codePostale = new JTextField();
    JTextField ville = new JTextField();

    JButton envoyer = new JButton("Envoyer");
    JButton select = new JButton("Select");


    public Form() {
        super("Formulaire");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);
        labelNom.setBounds(10, 10, 200, 20);
        labelPrenom.setBounds(10, 40, 200, 20);
        labelAge.setBounds(10, 70, 200, 20);
        labelSexe.setBounds(10, 100, 200, 20);
        labelAdresse.setBounds(10, 130, 200, 20);
        labelCodePostal.setBounds(10, 160, 200, 20);
        labelVille.setBounds(10, 190, 200, 20);

        nom.setBounds(120, 20, 100, 20);
        prenom.setBounds(120, 50, 100, 20);
        age.setBounds(120, 80, 100, 20);
        sexe.setBounds(120, 110, 100, 20);
        adresse.setBounds(120, 140, 100, 20);
        codePostale.setBounds(120, 170, 100, 20);
        ville.setBounds(120, 200, 100, 20);

        envoyer.setBounds(120, 230, 100, 20);
        envoyer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                BDmodel bd = new BDmodel(BD.DBConnection());
                bd.insert(nom.getText(), prenom.getText(), age.getText(), sexe.getText(), adresse.getText(), codePostale.getText(), ville.getText());
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                envoyer.setText("BAMMMM");
            }
        });
        select.setBounds(120, 260, 100, 20);
        select.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                BDmodel bd = new BDmodel(BD.DBConnection());
                bd.select();
            }
        });

        add(labelNom);
        add(labelPrenom);
        add(labelAge);
        add(labelSexe);
        add(labelAdresse);
        add(labelCodePostal);
        add(labelVille);

        add(nom);
        add(prenom);
        add(age);
        add(sexe);
        add(adresse);
        add(codePostale);
        add(ville);

        add(envoyer);
        add(select);
    }

}
