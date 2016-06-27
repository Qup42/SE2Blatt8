package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlung;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BezahlWerkzeug
{

    public static void main(String[] args)
    {
        // TODO: Nur zum Debuggen? -> Entfernen
        BezahlWerkzeug a = new BezahlWerkzeug();
        System.out
            .println(a.berechne(21000, "König der Löwen", "26.06.2016", 42));
        System.out
            .println(a.berechne(1500, "König der Löwen", "26.06.2016", 3));
    }

    private BezahlWerkzeugUI _ui;
    private boolean erfolgreich;

    public BezahlWerkzeug()
    {
        _ui = new BezahlWerkzeugUI();

        _ui.getAbbruchButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    erfolgreich = false;
                    _ui.getDialog()
                        .dispose();
                }
            });

        _ui.getOkButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    erfolgreich = true;
                    _ui.getDialog()
                        .dispose();
                }
            });
    }

    public boolean berechne(final int preis, String vorstellung, String datum,
            int plaetze)
    {
        setzeInfo(vorstellung, datum, plaetze);
        setzePreis(preis);
        setzeRueckbetrag(-preis);

        // In Variable speichern, damit dieser später wieder entfernt werden kann
        // Für spätere Aufrufe notwendig, ansonsten aktualisiert der als erstes hinzgefügte
        // Listener immer den Restbetrag -> Höhe der ersten Rechnung bleibt fälschlicherweise erhalten
        DocumentListener a = new DocumentListener()
        {
            private void aktualisieren()
            {
                try
                {
                    int rueckbetrag = getGegeben() - preis;
                    setzeRueckbetrag(rueckbetrag);

                    if (rueckbetrag >= 0)
                        _ui.getOkButton()
                            .setEnabled(true);
                    else
                        _ui.getOkButton()
                            .setEnabled(false);
                }
                catch (NumberFormatException e)
                {
                    _ui.getOkButton()
                        .setEnabled(false);
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e)
            {
                aktualisieren();
            }

            @Override
            public void removeUpdate(DocumentEvent e)
            {
                aktualisieren();
            }

            @Override
            public void changedUpdate(DocumentEvent e)
            {
                aktualisieren();
            }
        };

        _ui.getGegebenTextField()
            .getDocument()
            .addDocumentListener(a);

        erfolgreich = false;
        _ui.getOkButton()
            .setEnabled(false);
        _ui.getGegebenTextField()
            .setText("");

        _ui.getDialog()
            .setVisible(true);
        _ui.getGegebenTextField()
            .getDocument()
            .removeDocumentListener(a);
        return erfolgreich;
    }

    private void setzeInfo(String vorstellung, String datum, int plaetze)
    {
        _ui.getInfoLabel()
            .setText("Vorstellung: " + vorstellung + "\r\n" + "Datum: " + datum
                    + "\r\n" + "Anzahl der Plätze: " + plaetze);
    }

    private void setzePreis(int eurocent)
    {
        _ui.getPreisLabel()
            .setText("Preis: " + eurocent + "ct");
    }

    private void setzeRueckbetrag(int eurocent)
    {
        _ui.getRueckbetragLabel()
            .setText(String.valueOf(eurocent));
    }

    private int getGegeben() throws NumberFormatException
    {
        return Integer.parseInt(_ui.getGegebenTextField()
            .getText());
    }

}
