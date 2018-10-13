import java.io.*;
import java.util.ArrayList;

public class DecryptTwist
{
	private ArrayList<String> moeglicheWoerter = new ArrayList<>();

	public DecryptTwist()
	{
		moeglicheWoerter.clear();
	}

	/**
	 * Mit dem BufferedReader wird die Datei die als Parameter �bergeben wird
	 * Zeilenweise in eine Liste eingelesen.
	 * 
	 * @param file String des Dateinamens und Pfades, der Datei, die eingelesen
	 *             werden soll
	 * @return Liste, die alle W�rter aus der Datei enth�lt
	 */
	public ArrayList<String> readFile(String file)
	{
		ArrayList<String> list = new ArrayList<>();

		try
		{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = br.readLine()) != null)
			{
				list.add(line);
			}
			br.close();
		} catch (IOException e)
		{
			System.err.println(
					file + ": Datei konnte nicht ge�ffnet werden. M�glicherweise wurde sie gel�scht oder verschoben.");
		}

		return list;
	}

	/**
	 * W�rter die einen falschen Anfangsbuchstaben, einen falschen Endbuchstaben
	 * oder eine falsche L�nge haben werden aus der Liste mit allen W�rtern gel�scht
	 * 
	 * @param firstChar Variable f�r den Anfangsbuchstaben
	 * @param lastChar  Variable f�r den Endbuchstaben
	 * @param length    Variable f�r die L�nge des Wortes
	 * @return Liste, die die gel�schten W�rter nicht mehr enth�lt
	 */
	public ArrayList<String> getWords(char firstChar, char lastChar, int length, ArrayList<String> wordList)
	{

		// W�rter mit falschem ertsten Buchstaben aus Liste l�schen
		for (int i = 0; i < wordList.size(); i++)
		{
			if (wordList.get(i).charAt(0) != firstChar)
			{
				wordList.remove(i);
				i--;
			}
		}

		// W�rter mit falschem letzten Buchstaben aus Liste l�schen
		for (int i = 0; i < wordList.size(); i++)
		{
			if (wordList.get(i).charAt(wordList.get(i).length() - 1) != lastChar)
			{
				wordList.remove(i);
				i--;
			}
		}

		// W�rter mit falscher L�nge aus Liste l�schen
		for (int i = 0; i < wordList.size(); i++)
		{
			if (length != wordList.get(i).length())
			{
				wordList.remove(i);
				i--;
			}
		}

		return wordList;
	}

	/**
	 * Vergleicht das Wort mit den W�rtern, die die Methode permutation()
	 * zur�ckgibt. �bereinstimmungen werden ausgegeben
	 * 
	 * @param wort verschl�sseltes Wort, dass entschl�sselt werden soll
	 * @return Liste mit allen m�glichen W�rtern
	 */
	public ArrayList<String> decrypt(String wort)
	{
		ArrayList<String> wordList = new ArrayList<>();

		wordList = readFile("woerter.txt");
		// System.out.println("Datei fertig " + wordList.size());

		wordList = getWords(wort.charAt(0), wort.charAt(wort.length() - 1), wort.length(), wordList);
		// System.out.println(wordList.size());

		// Buchstaben vergleichen
		permutation("", wort);

		// System.out.println(moeglicheWoerter.size());
		// System.out.println("permutation fertig");

		for (int i = 0; i < moeglicheWoerter.size(); i++)
		{
			String moeglichesWort = moeglicheWoerter.get(i);
			if (!wordList.contains(moeglichesWort))
			{
				moeglicheWoerter.remove(i);
				i--;
			}
		}

		return moeglicheWoerter;
	}

	/**
	 * Tauscht die Reihenfolge der Buchstaben des Wortes so lange, bis jede
	 * M�glichkeit einmal vorkommt. Ruft sich rekursiv immer weiter auf
	 * 
	 * @param prefix Variable, die den ersten Teil des Wortes enth�lt
	 * @param str    Variable, die den anderen Teil des Wortes enth�lt
	 */
	public void permutation(String prefix, String str)
	{
		int n = str.length();
		if (n == 0)
		{
			if (!moeglicheWoerter.contains(prefix))
				moeglicheWoerter.add(prefix);
		} else
		{
			for (int i = 0; i < n; i++)
			{
				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
			}
		}
	}

	/**
	 * L�scht den ersten und letzten Buchstaben des Wortes, dass �bergeben wird
	 * 
	 * @param wort Wort das �begeben wird
	 * @return Wort, ohne den ersten und letzten Buchstaben
	 */
	public String delFirstLastChar(String wort)
	{
		String wortNeu = null;
		for (int i = 0; i < wort.length(); i++)
		{
			wortNeu += wort.charAt(i);
		}
		return wortNeu;

	}
}
