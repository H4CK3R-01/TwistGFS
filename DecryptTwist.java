import java.io.*;
import java.util.ArrayList; 

public class DecryptTwist
{
	private ArrayList<String> wortListeMitAllenWoerternNachPermutation = new ArrayList<>();

	public DecryptTwist()
	{

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
		}
		catch (IOException e)
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
	 * @param wordList  Liste aus der die W�rter gel�scht werden sollen
	 * @return Liste, die die gel�schten W�rter nicht mehr enth�lt
	 */
	public ArrayList<String> removeWords(char firstChar, char lastChar, int length, ArrayList<String> wordList)
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
		wordList = removeWords(wort.charAt(0), wort.charAt(wort.length() - 1), wort.length(), wordList);

		// Buchstaben vergleichen
		wortListeMitAllenWoerternNachPermutation.clear();
		permute(wort, 0, wort.length() - 1);

		for (int i = 0; i < wortListeMitAllenWoerternNachPermutation.size(); i++)
		{
			if (!wordList.contains(wortListeMitAllenWoerternNachPermutation.get(i)))
			{
				wortListeMitAllenWoerternNachPermutation.remove(i);
				i--;
			}
		}

		return wortListeMitAllenWoerternNachPermutation;
	}

	/**
	 * permutation function
	 * 
	 * @param str string to calculate permutation for
	 * @param l   starting index
	 * @param r   end index
	 */
	public void permute(String str, int l, int r) // -------------------------------verstehen---------------------------------
	{
		if (l == r)
		{
			if (!wortListeMitAllenWoerternNachPermutation.contains(str))
				wortListeMitAllenWoerternNachPermutation.add(str);
		}
		else
		{
			for (int i = l; i <= r; i++)
			{
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	/**
	 * Swap Characters at position
	 * 
	 * @param a string value
	 * @param i position 1
	 * @param j position 2
	 * @return swapped string
	 */
	public String swap(String a, int i, int j)
	{
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	} // -----------------------------------------------------------verstehen----------------------------------------------------------------

	public ArrayList<String> getMoeglicheWoerter()
	{
		return wortListeMitAllenWoerternNachPermutation;
	}

}
