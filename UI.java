import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UI implements ActionListener
{
	// Main Frame
	public static JFrame window = new JFrame("Twist");
	
	public static StatusBar statusBar = new StatusBar();

	// Tabpane
	public static JTabbedPane tabpane = new JTabbedPane(JTabbedPane.BOTTOM, JTabbedPane.SCROLL_TAB_LAYOUT);

	// Panel
	public static JPanel textPanel = new JPanel();
	public static JPanel wortPanel = new JPanel();

	// MenuBar
	public static JMenuBar menu = new JMenuBar();
	public static JMenu menuDatei = new JMenu();
	public static JMenu menuHelp = new JMenu();
	public static JMenuItem dateiOpen = new JMenuItem();
	public static JMenuItem dateiSave = new JMenuItem();
	public static JMenuItem dateiExit = new JMenuItem();
	public static JMenu helpSwitchWordList = new JMenu();
	public static ButtonGroup wortlisteRadioButtons = new ButtonGroup();
	public static JMenuItem helpUpdateProgram = new JMenuItem();
	public static JMenuItem helpKonsole = new JMenuItem();
	public static JMenuItem helpSettings = new JMenuItem();
	public static JMenuItem helpHelp = new JMenuItem();
	public static ImageIcon save = new ImageIcon("img/icon_save.png");
	public static ImageIcon open = new ImageIcon("img/icon_open.png");
	public static ImageIcon exit = new ImageIcon("img/icon_exit.png");
	public static ImageIcon updates = new ImageIcon("img/icon_updates.png");
	public static ImageIcon settings = new ImageIcon("img/icon_settings.png");
	public static ImageIcon help = new ImageIcon("img/icon_help.png");

	// Text Panel
	public static JTextArea text1 = new JTextArea(8, 80);
	public static JTextArea text2 = new JTextArea(8, 80);
	public static JScrollPane text1ScrollPane = new JScrollPane();
	public static JScrollPane text2ScrollPane = new JScrollPane();
	public static JLabel text1Label = new JLabel();
	public static JLabel text2Label = new JLabel();
	public static JButton textEntschluesseln = new JButton();
	public static JButton textVerschluesseln = new JButton();

	// Wort Panel
	public static JTextArea wort1 = new JTextArea(8, 80);
	public static JTextArea wort2 = new JTextArea(8, 80);
	public static JScrollPane wort1ScrollPane = new JScrollPane();
	public static JScrollPane wort2ScrollPane = new JScrollPane();
	public static JLabel wort1Label = new JLabel();
	public static JLabel wort2Label = new JLabel();
	public static JButton wortEntschluesseln = new JButton();
	public static JButton wortVerschluesseln = new JButton();

	// Dialoge
	public static JFileChooser dateiauswahl = new JFileChooser();
	public static JOptionPane optionDialog = new JOptionPane();
	public static JDialog helpDialog = new JDialog();

	// Einstellungen
	public static JPanel settingsContentPane = new JPanel();
	public static JFrame settingsSettings = new JFrame();
	public static GridBagLayout settingsGridBagLayout = new GridBagLayout();
	public static JLabel settingsZahlAnzeigenText = new JLabel();
	public static JPanel settingsPanel = new JPanel();
	public static GridBagLayout settingsgbl_panel = new GridBagLayout();
	public static JRadioButton settingsZahlAnzeigenJa = new JRadioButton();
	public static GridBagConstraints settingsGbc_zahlAnzeigenJa = new GridBagConstraints();
	public static JRadioButton settingsZahlAnzeigenNein = new JRadioButton();
	public static GridBagConstraints settingsGbc_zahlAnzeigenNein = new GridBagConstraints();
	public static ButtonGroup settingsZahlAnzeigen = new ButtonGroup();
	public static JLabel settingsLanguageChangeText = new JLabel();
	public static GridBagConstraints settingsGbc_languageChangeText = new GridBagConstraints();
	public static JComboBox<String> settingsLanguageComboBox = new JComboBox<String>();
	public static GridBagConstraints settingsGbc_languageComboBox = new GridBagConstraints();
	public static JLabel settingsAddWortListeText = new JLabel();
	public static GridBagConstraints settingsGbc_addWortListeText = new GridBagConstraints();
	public static JButton settingsAddWortListeBtn = new JButton();
	public static GridBagConstraints settingsGbc_addWortListeBtn = new GridBagConstraints();
	public static JPanel settingsOptions = new JPanel();
	public static GridBagConstraints settingsGbc_stdWortlisteText = new GridBagConstraints();
	public static JLabel settingsStdWortlisteText = new JLabel();
	public static JComboBox<String> settingsStdWortlisteComboBox = new JComboBox<String>();
	public static GridBagConstraints settingsGbc_stdWortlisteComboBox = new GridBagConstraints();
	public static GridBagLayout settingsGbl_options = new GridBagLayout();
	public static GridBagConstraints settingsGbc_options = new GridBagConstraints();
	public static JSeparator settingsSeparator = new JSeparator();
	public static GridBagConstraints settingsGbc_separator = new GridBagConstraints();
	public static JButton settingsBtnSpeichern = new JButton();
	public static GridBagConstraints settingsGbc_btnSpeichern = new GridBagConstraints();
	public static JButton settingsBtnAbbrechen = new JButton();
	public static GridBagConstraints settingsGbc_btnAbbrechen = new GridBagConstraints();

	// Console
	public static JFrame konsole = new JFrame();
	public static JTextArea konsoleArea = new JTextArea();
	public static GridBagConstraints constraints = new GridBagConstraints();

	// Andere UI-Elemente
	public static JTextArea helpText = new JTextArea();
	public static FileNameExtensionFilter filter;
	public static ArrayList<JRadioButtonMenuItem> wortlistenAuswahlMenu = new ArrayList<>();

	@SuppressWarnings("deprecation")
	public UI()
	{
		Main.readSettingsFile(); // Einstellungen einlesen
		// Sprach-Datei einlesen
		if (Main.language == 1)
		{
			Main.languageFile = ResourceBundle.getBundle("de.florian.twist.en");
		}
		else
		{
			Main.languageFile = ResourceBundle.getBundle("de.florian.twist.de");
		}

		// Icons von Men� festlegen
		save = new ImageIcon(save.getImage().getScaledInstance(16, 16, java.awt.Image.SCALE_DEFAULT));
		open = new ImageIcon(open.getImage().getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH));
		exit = new ImageIcon(exit.getImage().getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH));
		updates = new ImageIcon(updates.getImage().getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH));
		settings = new ImageIcon(settings.getImage().getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH));
		help = new ImageIcon(help.getImage().getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH));

		// Dateifilter f�r Dateiauswahl
		filter = new FileNameExtensionFilter("Text", "txt", "text"); // Nur Text Dateien		
		
		// Fenster konfigurieren
		window.setSize(850, 440); // Fenster-Gr��e festlegen
		//window.setResizable(false); // Gr��e des Fensters kann nich ge�ndert werden
		window.setLocationRelativeTo(null); // Position des Fensters wird festgelegt (Mitte)
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setIconImage(new ImageIcon("img/Twist.png").getImage()); // Icon des Fensters festlegen
		window.getContentPane().add(statusBar, BorderLayout.SOUTH);
		window.getContentPane().add(tabpane, BorderLayout.CENTER); // Tabpane zum Fenster hinzuf�gen
		window.setVisible(true); // Fenster ist sichtbar

		// Men� zusammensetzen
		window.setJMenuBar(menu); // Menu zum Fenster hinzuf�gen
		dateiOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK)); // Tastenkombination f�r '�ffnen'
		dateiOpen.setIcon(open); // Icon f�r '�ffnen'
		dateiOpen.addActionListener(new ActionHandler()); // ActionHandler f�r '�ffnen'
		dateiSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK)); // Tastenkombination f�r 'Speichern'
		dateiSave.setIcon(save); // Icon f�r 'Speichern'
		dateiSave.addActionListener(new ActionHandler()); // ActionHandler f�r 'Speichern'
		dateiExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK)); // Tastenkombination f�r 'Beenden'
		dateiExit.setIcon(exit); // Icon f�r 'Beenden'
		dateiExit.addActionListener(new ActionHandler()); // ActionHandler f�r 'Beenden'
		menuDatei.add(dateiOpen); // '�ffnen' zum Datei-Men� hinzuf�gen
		menuDatei.add(dateiSave); // 'Speichern' zum Datei-Men� hinzuf�gen
		menuDatei.addSeparator(); // Trennstrich zum Datei-Men� hinzuf�gen
		menuDatei.add(dateiExit); // 'Beenden' zum Datei-Men� hinzuf�gen

		for (int i = 0; i < Main.verfuegbareWortlisten.size(); i++)
		{
			wortlistenAuswahlMenu.add(new JRadioButtonMenuItem(Main.verfuegbareWortlisten.get(i))); // Radiobuttons f�r Wortlistenauswahl erstellen
		}
		for (int i = 0; i < Main.verfuegbareWortlisten.size(); i++)
		{
			if (Main.verfuegbareWortlisten.get(i).contains(Main.stdWortliste))
			{
				wortlistenAuswahlMenu.get(i).setSelected(true);
			}
			helpSwitchWordList.add(wortlistenAuswahlMenu.get(i)); // Radiobuttons zum 'Wortliste ausw�hlen'-Men� hinzuf�gen
			wortlisteRadioButtons.add(wortlistenAuswahlMenu.get(i));
			settingsStdWortlisteComboBox.addItem(Main.verfuegbareWortlisten.get(i)); // Wortlisten zum Auswahlmen� in den Einstellungen hinzuf�gen
		}

		settingsStdWortlisteComboBox.setSelectedItem(Main.stdWortliste); // Standardm��ig ausgew�hlte Wortliste ausw�hlen (aus Datei ausgelesen)
		helpKonsole.addActionListener(new ActionHandler()); // ActionHandler f�r 'Konsole'
		helpKonsole.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK)); // Tastenkombination f�r 'Konsole'
		helpUpdateProgram.setIcon(updates); // Icon f�r 'Updates'
		helpUpdateProgram.addActionListener(new ActionHandler()); // ActionHandler f�r 'Updates'
		helpSettings.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK)); // Tastenkombination f�r 'Einstellungen'
		helpSettings.setIcon(settings); // Icon f�r 'Settings'
		helpSettings.addActionListener(new ActionHandler()); // ActionHandler f�r 'Settings'
		helpHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.CTRL_MASK)); // Tastenkombination f�r 'Hilfe'
		helpHelp.setIcon(help); // Icon f�r 'Hilfe'
		helpHelp.addActionListener(new ActionHandler()); // ActionHandler f�r 'Hilfe'
		menuHelp.add(helpSwitchWordList); // 'Wortliste ausw�hlen' zum Datei-Men� hinzuf�gen
		menuHelp.add(helpKonsole); // 'Konsole' zum Datei-Men� hinzuf�gen
		menuHelp.add(helpUpdateProgram); // 'Update' zum Datei-Men� hinzuf�gen
		menuHelp.addSeparator(); // Trennstrich zum Datei-Men� hinzuf�gen
		menuHelp.add(helpSettings); // 'Einstellungen' zum Datei-Men� hinzuf�gen
		menuHelp.add(helpHelp); // 'Hilfe' zum Datei-Men� hinzuf�gen

		menu.add(menuDatei); // Datei-Men� zum Men� hinzuf�gen
		menu.add(menuHelp); // Hilfe-Men� zum Men� hinzuf�gen

		// Text Panel konfigurieren
		text1.setLineWrap(true);
		text1.setWrapStyleWord(true);
		text1.setFont(new Font("Arial", Font.PLAIN, 13));
		textPanel.add(text1Label);
		text1ScrollPane.setViewportView(text1);
		textPanel.add(text1ScrollPane);
		text2.setLineWrap(true);
		text2.setWrapStyleWord(true);
		text2.setFont(new Font("Arial", Font.PLAIN, 13));
		textPanel.add(text2Label);
		text2ScrollPane.setViewportView(text2);
		textPanel.add(text2ScrollPane);
		textEntschluesseln.addActionListener(new ActionHandler());
		textPanel.add(textEntschluesseln);
		textVerschluesseln.addActionListener(new ActionHandler());
		textPanel.add(textVerschluesseln);

		// Wort Panel konfigurieren
		wort1.setLineWrap(true);
		wort1.setWrapStyleWord(true);
		wort1.setFont(new Font("Arial", Font.PLAIN, 13));
		wortPanel.add(wort1Label);
		wort1ScrollPane.setViewportView(wort1);
		wortPanel.add(wort1ScrollPane);
		wort2.setLineWrap(true);
		wort2.setWrapStyleWord(true);
		wort2.setFont(new Font("Arial", Font.PLAIN, 13));
		wortPanel.add(wort2Label);
		wort2ScrollPane.setViewportView(wort2);
		wortPanel.add(wort2ScrollPane);
		wortEntschluesseln.addActionListener(new ActionHandler());
		wortPanel.add(wortEntschluesseln);
		wortVerschluesseln.addActionListener(new ActionHandler());
		wortPanel.add(wortVerschluesseln);

		// Pr�fen ob das Programm das erste mal gestartet wurde
		if (Main.firstStart == 1)
		{
			int auswahl = JOptionPane.showOptionDialog(null,
					"Mit diesem Programm k�nnen Sie W�rter bzw. Texte ver- oder entschl�sseln.\n\nUm W�rter zu ver- oder entschl�sseln wechseln Sie auf den Tab 'Wort', f�r Texte wechseln Sie auf 'Text'.",
					"Erster Start", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon("Twist.png"), new String[] { "OK" }, "OK");
			if (auswahl == 0)
			{
				Main.firstStart = 0;
				Main.saveSettingsFile();
			}
		}

		dateiauswahl.setCurrentDirectory(new java.io.File("."));
		dateiauswahl.setAcceptAllFileFilterUsed(false);
		dateiauswahl.setFileFilter(filter); // Dateifilter festlegen

		// Wortliste ausw�hlen
		String file = "";
		for (int i = 0; i < UI.wortlistenAuswahlMenu.size(); i++)
		{
			if (UI.wortlistenAuswahlMenu.get(i).isSelected())
			{
				file = "wordlist/woerter" + i + ".txt";
			}
		}

		// Wortliste einlesen
		Main.wordList = Main.readWordListFile(file);
		elementeBeschriften();
		statusBar.setMessage("Bereit");
	}

	public static void elementeBeschriften()
	{
		//Men�
		menuDatei.setText(Main.languageFile.getString("file")); // Datei
		menuHelp.setText(Main.languageFile.getString("help")); // Hilfe

		dateiOpen.setText(Main.languageFile.getString("open")); // �ffnen
		dateiSave.setText(Main.languageFile.getString("save")); // Speichern
		dateiExit.setText(Main.languageFile.getString("exit")); // Beenden

		helpSwitchWordList.setText(Main.languageFile.getString("changeWordlist")); // Wortliste ausw�hlen
		helpKonsole.setText(Main.languageFile.getString("consoleOpen")); // Konsole �ffnen/schlie�en
		helpUpdateProgram.setText(Main.languageFile.getString("update")); // Program aktualisieren
		helpSettings.setText(Main.languageFile.getString("settings")); // Einstellungen
		helpHelp.setText(Main.languageFile.getString("help")); // Hilfe

		// Tabs
		tabpane.removeAll();
		tabpane.addTab(Main.languageFile.getString("word"), wortPanel); // Wort
		tabpane.addTab(Main.languageFile.getString("text"), textPanel); // Text
		text1Label.setText(Main.languageFile.getString("decryptedText")); // Verschl�sselten Text hier eingeben
		text2Label.setText(Main.languageFile.getString("encryptedText")); // Unverschl�sselten Text hier eingeben
		textEntschluesseln.setText(Main.languageFile.getString("decrypt")); // Entschl�sseln
		textVerschluesseln.setText(Main.languageFile.getString("encrypt")); // Verschl�sseln
		wort1Label.setText(Main.languageFile.getString("decryptWord")); // Verschl�sseltes Wort hier eingeben
		wort2Label.setText(Main.languageFile.getString("encryptWord")); // Unverschl�sseltes Wort hier eingeben
		wortEntschluesseln.setText(Main.languageFile.getString("decrypt")); // Entschl�sseln
		wortVerschluesseln.setText(Main.languageFile.getString("encrypt")); // Verschl�sseln

		// Settings
		settingsSettings.setTitle(Main.languageFile.getString("settings")); // Einstellungen
		settingsZahlAnzeigenText.setText(Main.languageFile.getString("numberBehindWords")); // Soll die Zahl hinter den W�rtern bei 'Text' stehen
		settingsZahlAnzeigenJa.setText(Main.languageFile.getString("yes")); // Ja
		settingsZahlAnzeigenNein.setText(Main.languageFile.getString("no")); // Nein
		settingsLanguageChangeText.setText(Main.languageFile.getString("changeLanguage")); // Sprache ausw�hlen
		settingsAddWortListeText.setText(Main.languageFile.getString("newWordlist")); // Neue Wortliste zum Programm hinzuf�gen
		settingsAddWortListeBtn.setText(Main.languageFile.getString("newWordlistBtn")); // Wortliste ausw�hlen
		settingsStdWortlisteText.setText(Main.languageFile.getString("changeStdWordlist")); // Standard Wortliste ausw�hlen
		settingsBtnSpeichern.setText(Main.languageFile.getString("save")); // Speichern
		settingsBtnAbbrechen.setText(Main.languageFile.getString("abort")); // Abbrechen

		// Sonstige
		helpText.setText(Main.languageFile.getString("helpText")); // Text der im Hilfe-Fenster angezeigt wird
		helpDialog.setTitle(Main.languageFile.getString("help")); // Hilfe
		dateiauswahl.setDialogTitle(Main.languageFile.getString("changeWordlist")); // Wortliste ausw�hlen
		settingsLanguageComboBox.removeAllItems();
		settingsLanguageComboBox.addItem(Main.languageFile.getString("german")); // Deutsch
		settingsLanguageComboBox.addItem(Main.languageFile.getString("english")); // Englisch
		settingsLanguageComboBox.setSelectedIndex(Main.language);
	}

	public void actionPerformed(ActionEvent e)
	{

	}
}
