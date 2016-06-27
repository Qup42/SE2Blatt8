package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlung;

import javax.swing.*;
import java.awt.*;

public class BezahlWerkzeugUI
{

    private JDialog _dialog;
    private JTextArea _infoTextArea;
    private JLabel _preisLabel;
    private JTextField _gegebenTextField;
    private JLabel _rueckbetragLabel;
    private JButton _abbruchButton;
    private JButton _okButton;

    public BezahlWerkzeugUI()
    {
        _dialog = new JDialog();
        _dialog.setModal(true);
        _dialog.setTitle("Rechnung");
        _dialog.setLayout(new GridBagLayout());
        _dialog.setMinimumSize(new Dimension(350, 175));
        // X Knopf vom Fenster ist nicht leicht zu deaktivieren, also einfach Funktion entfernen
        _dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);

        /*
         * GridBagLayout Schema:
         *          0             1              2              3
         *   +---------------------------------------------------------+
         *   ¦ Vorstellung: ______       ¦                             ¦
         * 0 ¦ Datum: ______             ¦ Preis: _______              ¦ <- Verbundene Zellen
         *   ¦ Anzahl der Plätze: _____  ¦                             ¦
         *   +-------------+-------------+---------------+-------------¦
         * 1 ¦ Gegeben:    ¦ _______     ¦ Rückbetrag:   ¦ ______      ¦
         *   +-------------+-------------+---------------+-------------¦
         * 2 ¦ Abbruch                   ¦ OK                          ¦ <- Verbundene Zellen
         *   +---------------------------------------------------------+
         */

        _infoTextArea = new JTextArea(3, 15);
        _infoTextArea.setBackground(_dialog.getBackground());
        _infoTextArea.setEditable(false);
        _infoTextArea.setFont(_dialog.getFont());
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        _dialog.add(_infoTextArea, c);

        _preisLabel = new JLabel();
        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 2;
        _dialog.add(_preisLabel, c);

        JLabel gegebenBeschriftung = new JLabel("Gegeben:");
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        _dialog.add(gegebenBeschriftung, c);

        _gegebenTextField = new JTextField();
        _gegebenTextField.setColumns(8);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        _dialog.add(_gegebenTextField, c);

        JLabel rueckbetragBeschriftung = new JLabel("Rückbetrag:");
        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = 1;
        _dialog.add(rueckbetragBeschriftung, c);

        _rueckbetragLabel = new JLabel();
        c.gridx = 3;
        c.gridy = 1;
        c.gridwidth = 1;
        _dialog.add(_rueckbetragLabel, c);

        _abbruchButton = new JButton("Abbruch");
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        _dialog.add(_abbruchButton, c);

        _okButton = new JButton("OK");
        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 2;
        _dialog.add(_okButton, c);

        _dialog.pack();
    }

    public JDialog getDialog()
    {
        return _dialog;
    }

    public JTextArea getInfoLabel()
    {
        return _infoTextArea;

    }

    public JLabel getPreisLabel()
    {
        return _preisLabel;
    }

    public JTextField getGegebenTextField()
    {
        return _gegebenTextField;
    }

    public JLabel getRueckbetragLabel()
    {
        return _rueckbetragLabel;
    }

    public JButton getAbbruchButton()
    {
        return _abbruchButton;
    }

    public JButton getOkButton()
    {
        return _okButton;
    }
}