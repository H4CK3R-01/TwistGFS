import java.awt.Font;
import java.awt.event.*; 
import javax.swing.*;

public class UI implements ActionListener
{
	// Main Frame
	public static JFrame window = new JFrame("Twist");

	// Tabpane
	public static JTabbedPane tabpane = new JTabbedPane(JTabbedPane.BOTTOM, JTabbedPane.SCROLL_TAB_LAYOUT);

	// Panel
	public static JPanel textPanel = new JPanel();
	public static JPanel wortPanel = new JPanel();

	// MenuBar
	public static JMenuBar menu = new JMenuBar();
	public static JMenu menuDatei = new JMenu("Datei");
	public static JMenu menuHelp = new JMenu("Hilfe");
	public static JMenuItem dateiOpen = new JMenuItem("�ffnen");
	public static JMenuItem dateiSave = new JMenuItem("Speichern");
	public static JMenuItem dateiExit = new JMenuItem("Beenden");
	public static JMenuItem helpSettings = new JMenuItem("Einstellungen");
	public static JMenuItem helpVersion = new JMenuItem("Version pr�fen");
	public static JMenuItem helpHelp = new JMenuItem("Hilfe");

	// Text
	public static JTextArea text1 = new JTextArea(8, 80);
	public static JTextArea text2 = new JTextArea(8, 80);
	public static JScrollPane text1ScrollPane = new JScrollPane();
	public static JScrollPane text2ScrollPane = new JScrollPane();
	public static JButton textEntschluesseln = new JButton("Entschl�sseln");
	public static JButton textVerschluesseln = new JButton("Verschl�sseln");
	public static JLabel textLabel = new JLabel("oder");

	// Wort
	public static JTextArea wort1 = new JTextArea(8, 80);
	public static JTextArea wort2 = new JTextArea(8, 80);
	public static JScrollPane wort1ScrollPane = new JScrollPane();
	public static JScrollPane wort2ScrollPane = new JScrollPane();
	public static JButton wortEntschluesseln = new JButton("Entschl�sseln");
	public static JButton wortVerschluesseln = new JButton("Verschl�sseln");
	public static JLabel wortLabel = new JLabel("oder");

	// Dialoge
	public static JFileChooser dateiauswahl = new JFileChooser();
	public static JOptionPane optionDialog = new JOptionPane();
	public static JDialog dialog = new JDialog();

	// Variablen
	public static JTextArea helpText = new JTextArea(
			"Mithilfe des Tabs 'Text' k�nnen Sie ganze Texte ver- oder entschl�sseln. Beim entschl�sseln wird, wenn f�r ein verschl�sseltes Wort mehrere m�gliche W�rter passen w�rden, immer das erste Wort, das gefunden wird, ausgegeben. Die Zahl in Klammern dahinter zeigt, wieviele m�glichen W�rter es gibt."
					+ "\n\nMithilfe des Tabs 'Wort' k�nnen Sie einzelne W�rter ver- oder entschl�sseln. Beim entschl�sseln werden im Gegensatz zu dem 'Text'-Tab alle W�rter ausgegeben.");
	public static boolean settigsZahl = true;
	public static boolean firstStart = true;

	@SuppressWarnings("deprecation")
	public UI()
	{
		// Fenster konfigurieren
		window.setSize(850, 400);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setIconImage(new ImageIcon("Twist.png").getImage());
		window.add(tabpane);
		window.setVisible(true);

		// Men� zusammensetzen
		window.setJMenuBar(menu);
		menu.add(menuDatei);
		dateiOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		dateiOpen.addActionListener(new ActionHandler());
		menuDatei.add(dateiOpen);
		dateiSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		dateiSave.addActionListener(new ActionHandler());
		menuDatei.add(dateiSave);
		dateiExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		dateiExit.addActionListener(new ActionHandler());
		menuDatei.add(dateiExit);

		menu.add(menuHelp);
		helpSettings.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		helpSettings.addActionListener(new ActionHandler());
		menuHelp.add(helpSettings);
		helpVersion.addActionListener(new ActionHandler());
		menuHelp.add(helpVersion);
		helpHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.CTRL_MASK));
		helpHelp.addActionListener(new ActionHandler());
		menuHelp.add(helpHelp);

		// Text Panel
		text1.setLineWrap(true);
		text1.setWrapStyleWord(true);
		text1.setFont(new Font("Arial", Font.PLAIN, 13));
		text1.setText("Verschl�sselten Text hier eingeben");
		text1ScrollPane.setViewportView(text1);
		textPanel.add(text1ScrollPane);
		textPanel.add(textLabel);
		text2.setLineWrap(true);
		text2.setWrapStyleWord(true);
		text2.setFont(new Font("Arial", Font.PLAIN, 13));
		text2.setText("Entschl�sselten Text hier eingeben");
		text2ScrollPane.setViewportView(text2);
		textPanel.add(text2ScrollPane);
		textEntschluesseln.addActionListener(new ActionHandler());
		textPanel.add(textEntschluesseln);
		textVerschluesseln.addActionListener(new ActionHandler());
		textPanel.add(textVerschluesseln);
		tabpane.addTab("Text ", textPanel);

		// Wort Panel
		wort1.setLineWrap(true);
		wort1.setWrapStyleWord(true);
		wort1.setFont(new Font("Arial", Font.PLAIN, 13));
		wort1.setText("Verschl�sseltes Wort hier eingeben");
		wort1ScrollPane.setViewportView(wort1);
		wortPanel.add(wort1ScrollPane);
		wortPanel.add(wortLabel);
		wort2.setLineWrap(true);
		wort2.setWrapStyleWord(true);
		wort2.setFont(new Font("Arial", Font.PLAIN, 13));
		wort2.setText("Entschl�sseltes Wort hier eingeben");
		wort2ScrollPane.setViewportView(wort2);
		wortPanel.add(wort2ScrollPane);
		wortEntschluesseln.addActionListener(new ActionHandler());
		wortPanel.add(wortEntschluesseln);
		wortVerschluesseln.addActionListener(new ActionHandler());
		wortPanel.add(wortVerschluesseln);
		tabpane.addTab("Wort", wortPanel);
	}

	public void actionPerformed(ActionEvent e)
	{

	}
}
