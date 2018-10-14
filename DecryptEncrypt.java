import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DecryptEncrypt
{
	public static ArrayList<String> readFile(String file)
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
	
	
	public static ArrayList<String> removeWords(char firstChar, char lastChar, int length, ArrayList<String> wordList)
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
	
	public static int fakultaet(int wert)
	{
		if (wert > 1)
		{
			return (wert * fakultaet(wert - 1));
		}
		else
		{
			return 1;
		}
	}
}
