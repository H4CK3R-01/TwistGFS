import java.time.LocalDateTime;

import de.florian.twist.Main;
import de.florian.twist.UI;

public class CustomThreadEncryptWort extends Thread
{
	private String wortNeu;
	private String wort;
	private String urspruenglichesWort;
	private String ersterBuchstabe;
	private String letzterBuchstabe;

	public CustomThreadEncryptWort(String s)
	{
		this.wort = s;
		this.urspruenglichesWort = s;
	}

	public void run()
	{
		Main.console.setText(
				"[ " + LocalDateTime.now().format(Main.df) + " ] " + Main.languageFile.getString("startedEncrypt"));
		UI.statusBar.setMessage(Main.languageFile.getString("startedEncrypt"));
		wort = wort.replaceAll("[^A-Za-z�������]", ""); // Alle Sonderzeichen entfernen

		if (wort.length() > 3) // Wenn W�rter k�rzer als 3 Buchstaben sind werden sie einfach wieder zur�ckgegeben, ansonsten werden sie verschl�sselt
		{
			ersterBuchstabe = wort.substring(0, 1); // Ersten Buchstaben speichern
			letzterBuchstabe = wort.substring(wort.length() - 1, wort.length()); // Letzten Buchstaben speichern
			wort = delFirstLastChar(wort); // Wort ohne ersten und letzten Buchstaben speichern
			urspruenglichesWort = delFirstLastChar(urspruenglichesWort); // Urpr�ngliches Wort ohne ersten und letzten Buchstaben speichern
			wortNeu = buchstabenTauschen(); // Wort verschl�sseln
		}
		else
		{
			wortNeu = wort;
		}
		Main.console
				.setText("[ " + LocalDateTime.now().format(Main.df) + " ] " + Main.languageFile.getString("finished"));
		UI.statusBar.setMessage(Main.languageFile.getString("finished"));
	}

	private String buchstabenTauschen()
	{
		for (int i = 0; i < (wort.length() / 2); i++) // Je l�nger der String ist, desto �fters werden zwei Buchstaben getauscht
		{
			int zufallswert1 = (int) (Math.random() * (wort.length() - 1) + 0.5); // Zufallszahl zwischen 1 und der L�nge des Strings wird generiert
			int zufallswert2 = (int) (Math.random() * (wort.length() - 1) + 0.5); // Zufallszahl zwischen 1 und der L�nge des Strings wird generiert
			wort = Main.swapCharactersOfString(wort, zufallswert1, zufallswert2);
		}

		if (!wort.equals(urspruenglichesWort)) // Wenn das neue Wort gleich wie das Urspr�ngliche Wort ist, wird die Methode 'buchstabenTauschen()' nocheinmal aufgerufen
		{
			return ersterBuchstabe + wort + letzterBuchstabe; // Neu generiertes Wort wird inklusive erstem und letzem Buchstabn zur�ckgegeben
		}
		else
		{
			return buchstabenTauschen();
		}
	}

	public String delFirstLastChar(String wort)
	{
		return wort.substring(1, wort.length() - 1); // erster und letzer Buchstabe wird gel�scht
	}

	public String getWortNeu()
	{
		return wortNeu;
	}
}