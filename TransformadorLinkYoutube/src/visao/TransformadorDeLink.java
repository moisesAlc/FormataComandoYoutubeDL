package visao;

import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TransformadorDeLink {

	private JFrame frame;
	private JTextField entrada;
	private JButton mudar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransformadorDeLink window = new TransformadorDeLink();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TransformadorDeLink() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 100);
		frame.setTitle("Mudar link com playlist para com audio");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		ImageIcon img = new ImageIcon("/home/moises/Imagens/M.png");

		frame.setIconImage(img.getImage());
		frame.getContentPane().setLayout(null);
		entrada = new JTextField();
		entrada.setBounds(10, 10, 400, 20);
		mudar = new JButton("mudar");
		String comando = "youtube-dl -f 251 ";
		mudar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String strComPlaylist = entrada.getText();
				String link = strComPlaylist.split("&")[0];
				
				entrada.setText("");
				entrada.setRequestFocusEnabled(true);

				StringSelection stringSelection = new StringSelection(comando.concat(link));
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
				
				
			}
		});
		mudar.setBounds(110, 40, 200, 20);
		frame.getContentPane().add(entrada);
		frame.getContentPane().add(mudar);
		
	}

}
