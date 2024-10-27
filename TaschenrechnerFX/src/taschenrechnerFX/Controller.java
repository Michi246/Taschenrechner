package taschenrechnerFX;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Controller {
	
	@FXML Button beenden, berechnen;
	@FXML TextField eingabe1, eingabe2;
	@FXML RadioButton plus, minus, mal, geteilt;
	@FXML Label ergebnis;
	
	
	@FXML 
	//methode zum beenden der anwendung mit vorheriger warnung das die Anwendung geschlossen wird 
	protected void buttonBeenden() {
		Alert meinDialog = new Alert(AlertType.WARNING, "Das Programm wird beendet!");
		meinDialog.setTitle("Beenden");
		meinDialog.showAndWait();
		Platform.exit();
	}
	
	@FXML
	//methode um das ergebnis auszugenben
	private void berechnen(ActionEvent event) {
		ergebnis.setText(buttonBerechnen());
	}
	
	
	@FXML
	//methode zum formatieren und berechnen der eingegebenen parameter
	protected String buttonBerechnen() {
		
		double zahl1, zahl2, ergebnis = 0;;
		boolean fehlerFlag = false;
		
		//Fehlerbehandlung und Ausgabe der Meldung durch eine eigene Methode
				try {
					//für das Konvertieren
					Number wert = NumberFormat.getNumberInstance(Locale.GERMANY).parse(eingabe1.getText());
					zahl1 = wert.doubleValue();
				}
				catch (Exception ParseException) {
					fehlermeldung(eingabe1);
					//das Ergebnis ist nicht definiert
					return ("Nicht definiert");
				}
				
				try {
					//für das Konvertieren
					Number wert = NumberFormat.getNumberInstance(Locale.GERMANY).parse(eingabe2.getText());
					zahl2 = wert.doubleValue();
				}
				catch (Exception ParseException) {
					fehlermeldung(eingabe2);
					//das Ergebnis ist nicht definiert
					return ("Nicht definiert");
				}
		//Das Zahlenformat festlegen
		DecimalFormat formatFolge = new DecimalFormat("0.##");
		//konvertierung von text auf zahl
		//überprüfung welcher RadioButton ausgewählt wurde
		if(plus.isSelected())
			ergebnis = zahl1 + zahl2;
		if(minus.isSelected())
			ergebnis = zahl1 - zahl2;
		if(mal.isSelected())
			ergebnis = zahl1 * zahl2;
		if(geteilt.isSelected()) {
			if(zahl2 != 0)
			ergebnis = zahl1 / zahl2;
			else
				fehlerFlag = true;
		}
		if(fehlerFlag == false)
			//Das vorgegebene zahlenformat verwenden
			return (formatFolge.format(ergebnis));
		else
			return ("Nicht definiert");
	
	}
	//methode zur ausgabe der fehlermeldung
	private void fehlermeldung(TextField eingabefeld){
		Alert meinDialog = new Alert(AlertType.WARNING, "Falsche oder keine Eingabe!");
		meinDialog.setTitle("Fehler");
		meinDialog.showAndWait();
}
	}

	