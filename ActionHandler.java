import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class ActionHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		DecryptTwist Twist = new DecryptTwist();
		ArrayList<String> woerterText = new ArrayList<>();
		ArrayList<ArrayList<String>> woerterWort = new ArrayList<>();

		if (e.getSource() == UI.open)
		{
			if (UI.tabpane.getSelectedIndex() == 0)
			{
				int auswahl = JOptionPane.showOptionDialog(null,
						"Wollen Sie einen verschl�sselten Text oder einen entschl�sselten Text �ffnen?", "�ffnen",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("Twist.png"),
						new String[] { "Verschl�sselt", "Entschl�sselt" }, "Entschl�sselt");
				int returnVal = UI.dateiauswahl.showOpenDialog(UI.window);
				if (returnVal == JFileChooser.APPROVE_OPTION)
				{
					try
					{
						BufferedReader br = new BufferedReader(new FileReader(UI.dateiauswahl.getSelectedFile()));
						String line = "";
						String s = "";
						if (auswahl == 1)
						{
							while ((line = br.readLine()) != null)
							{
								s += line;
							}
							UI.TextArea2.setText(s);
						}
						else
						{
							while ((line = br.readLine()) != null)
							{
								s += line;
							}
							UI.TextArea1.setText(s);
						}
						br.close();
					}
					catch (IOException e1)
					{
					}
				}
			}
			else
			{
				int auswahl = JOptionPane.showOptionDialog(null,
						"Wollen Sie eine verschl�sseltes Wort oder ein entschl�sseltes Wort �ffnen?", "�ffnen",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("Twist.png"),
						new String[] { "Verschl�sselt", "Entschl�sselt" }, "Entschl�sselt");
				int returnVal = UI.dateiauswahl.showOpenDialog(UI.window);
				if (returnVal == JFileChooser.APPROVE_OPTION)
				{
					try
					{
						BufferedReader br = new BufferedReader(new FileReader(UI.dateiauswahl.getSelectedFile()));
						String line = "";
						String s = "";
						if (auswahl == 1)
						{
							while ((line = br.readLine()) != null)
							{
								s += line;
							}
							UI.WortArea2.setText(s);
						}
						else
						{
							while ((line = br.readLine()) != null)
							{
								s += line;
							}
							UI.WortArea1.setText(s);
						}
						br.close();
					}
					catch (IOException e1)
					{
					}
				}
			}
		}
		else if (e.getSource() == UI.save)
		{
			if (UI.tabpane.getSelectedIndex() == 0)
			{
				int auswahl = JOptionPane.showOptionDialog(null,
						"Wollen Sie den verschl�sselten Text oder den entschl�sselten Text speichern?", "Speichern",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("Twist.png"),
						new String[] { "Verschl�sselt", "Entschl�sselt" }, "Entschl�sselt");
				int returnVal = UI.dateiauswahl.showOpenDialog(UI.window);
				if (returnVal == JFileChooser.APPROVE_OPTION)
				{
					try
					{
						BufferedWriter bw = new BufferedWriter(new FileWriter(UI.dateiauswahl.getSelectedFile()));
						if (auswahl == 1)
						{
							bw.write(UI.TextArea2.getText());
						}
						else
						{
							bw.write(UI.TextArea1.getText());
						}
						bw.close();
					}
					catch (IOException e1)
					{
					}
				}
			}
			else
			{
				int auswahl = JOptionPane.showOptionDialog(null,
						"Wollen Sie das verschl�sselte Wort oder das/die entschl�sselte/n Wort/e speichern?",
						"Speichern", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon("Twist.png"), new String[] { "Verschl�sselt", "Entschl�sselt" }, "Entschl�sselt");
				int returnVal = UI.dateiauswahl.showOpenDialog(UI.window);
				if (returnVal == JFileChooser.APPROVE_OPTION)
				{
					try
					{
						BufferedWriter bw = new BufferedWriter(new FileWriter(UI.dateiauswahl.getSelectedFile()));
						if (auswahl == 1)
						{
							bw.write(UI.WortArea2.getText());
						}
						else
						{
							bw.write(UI.WortArea1.getText());
						}
						bw.close();
					}
					catch (IOException e1)
					{
					}
				}
			}
		}
		else if (e.getSource() == UI.exit)
		{
			System.exit(0);
		}
		else if (e.getSource() == UI.help)
		{
			UI.dialog.setTitle("Hilfe");
			UI.dialog.setSize(300, 200);
			UI.dialog.setResizable(false);
			UI.helpText.setLineWrap(true);
			UI.helpText.setWrapStyleWord(true);
			UI.helpText.setFont(new Font("Arial", Font.PLAIN, 13));
			UI.helpText.setEditable(false);
			UI.dialog.add(UI.helpText);
			UI.dialog.setModal(true);
			UI.dialog.setVisible(true);

		}
		else if (e.getSource() == UI.version)
		{
			int auswahl = JOptionPane.showOptionDialog(null,
					"Aktuell verwenden sie Version " + Main.version + " des Programms.\n\nDie neuste Version ist "
							+ Main.versionNew + "\n\nWollen Sie die neue Version herunterladen?",
					"Version pr�fen", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon("Twist.png"), new String[] { "Nein", "Ja" }, "Ja");
			if (auswahl == 1)
			{
				try
				{
					Desktop.getDesktop().browse(new URL(Main.versionNewURL).toURI());
				}
				catch (IOException | URISyntaxException e1)
				{
				}

			}
		}
		else if (e.getSource() == UI.btnEntschluesselnText) // Text Entschl�sseln
		{
			String text = UI.TextArea1.getText();
			String[] splited = text.split("\\s+");

			UI.TextArea2.setText("");
			for (int i = 0; i < splited.length; i++)
			{
				woerterText.add(Twist.decrypt(splited[i]).get(0));
			}

			for (int i = 0; i < woerterText.size(); i++)
			{
				UI.TextArea2.setText(UI.TextArea2.getText() + woerterText.get(i) + " ");
			}
		}
		else if (e.getSource() == UI.btnVerschluesselnText)
		{
			System.out.println("Verschl�sseln Text");
		}
		else if (e.getSource() == UI.btnEntschluesselnWort) // Wort Entschl�sseln
		{
			String wort = UI.WortArea1.getText();

			UI.WortArea2.setText("");

			woerterWort.clear();
			woerterWort.add(Twist.decrypt(wort));
			for (int i = 0; i < woerterWort.get(0).size(); i++)
			{
				UI.WortArea2.setText(UI.WortArea2.getText() + woerterWort.get(0).get(i) + "\n");
			}
		}
		else if (e.getSource() == UI.btnVerschluesselnWort)
		{
			System.out.println("Verschl�sseln Wort");
		}
		else
		{

		}
	}
}
