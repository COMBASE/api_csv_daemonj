package net.combase.cloud.buttler.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.json.JSONObject;

import net.combase.api.service.AbstractApiService;
import net.combase.api.service.ProductApiService;
import net.combase.cloud.buttler.api.ApiUtil;
import net.combase.cloud.buttler.db.DbReader;

/**
 * Diese Klasse ist für die Oberfläche verantwortlich
 *
 * @author Gordon Bosch
 *
 */
public class ProductListener implements KeyListener {

	private JFrame frmShowProduct;
	private static JTextField textField_nr;
	private static JTextArea textArea_info;
	private static JTextField textField_name;

	public static JTextField getTextField_name() {
		return textField_name;
	}

	public JFrame getFrmShowProduct() {
		return frmShowProduct;
	}

	public void setFrmShowProduct(JFrame frmShowProduct) {
		this.frmShowProduct = frmShowProduct;
	}

	public static JTextField getTextField() {
		return textField_nr;
	}

	public static JTextArea getTextArea() {
		return textArea_info;
	}

	public ProductListener() {
		initialize();
	}

	/**
	 * hier wird die GUI zusammengesetzt, Swing as usual
	 *
	 */
	private void initialize() {
		frmShowProduct = new JFrame();
		textField_nr = new JTextField();
		textArea_info = new JTextArea();
		textField_nr.setHorizontalAlignment(SwingConstants.CENTER);
		JButton btnShow = new JButton("show");

		frmShowProduct.setTitle("Show Product");
		frmShowProduct.setBounds(100, 100, 450, 300);
//		frmShowProduct.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textField_nr.setColumns(10);

		JLabel lblProductkey = new JLabel("Productnr:");

		JLabel lblProductname = new JLabel("Productname:");

		textField_name = new JTextField();
		textField_name.setColumns(10);

		JButton btnSave = new JButton("Save");
		GroupLayout groupLayout = new GroupLayout(frmShowProduct.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addGap(39)
						.addGroup(
								groupLayout
										.createParallelGroup(Alignment.LEADING, false)
										.addGroup(
												groupLayout
														.createSequentialGroup()
														.addComponent(lblProductname)
														.addGap(40)
														.addComponent(textField_name, GroupLayout.PREFERRED_SIZE, 136,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnSave))
										.addComponent(textArea_info, GroupLayout.PREFERRED_SIZE, 373,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(
												groupLayout
														.createSequentialGroup()
														.addComponent(lblProductkey, GroupLayout.PREFERRED_SIZE, 100,
																GroupLayout.PREFERRED_SIZE)
														.addGap(35)
														.addComponent(textField_nr, GroupLayout.PREFERRED_SIZE, 80,
																GroupLayout.PREFERRED_SIZE)
														.addGap(41)
														.addComponent(btnShow, GroupLayout.PREFERRED_SIZE, 117,
																GroupLayout.PREFERRED_SIZE))).addGap(34)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addGap(12)
						.addGroup(
								groupLayout
										.createParallelGroup(Alignment.LEADING)
										.addGroup(
												groupLayout.createSequentialGroup().addGap(5)
														.addComponent(lblProductkey))
										.addGroup(
												groupLayout
														.createSequentialGroup()
														.addGap(3)
														.addComponent(textField_nr, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(btnShow))
						.addGap(18)
						.addComponent(textArea_info, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(
								groupLayout
										.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblProductname)
										.addComponent(btnSave)
										.addComponent(textField_name, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(23)));
		frmShowProduct.getContentPane().setLayout(groupLayout);
		btnShow.addActionListener(new ActionListener() { // der Button-Druck
															// triggert die
															// Produktsuche
			public void actionPerformed(ActionEvent e) {
				try {
					requestProduct();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSave.addActionListener(new ActionListener() { // der Button-Druck
															// triggert die
															// Produktsuche
			public void actionPerformed(ActionEvent e) {
				try {
					postProduct();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		textField_nr.addKeyListener(this);
		textField_name.addKeyListener(this);
	}

	public void keyTyped(KeyEvent e) {
	}

	/**
	 * hier implementieren wir die Abfrage, ob Enter gedrückt wurde und welche
	 * Fkt es betrifft
	 */
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			try {
				if (textField_nr.hasFocus()) {
					requestProduct();
				}
				if (textField_name.hasFocus()) {
					postProduct();
				}

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void keyReleased(KeyEvent e) {
	}

	/**
	 * Wirft einen Error-Popup, wenn benötigt
	 *
	 * @param message
	 *            die Error-Message
	 */
	public static void throwPopup(String message, int i) {
		String title = "Error";
		if (i == JOptionPane.INFORMATION_MESSAGE)
			title = "Gespeichert";
		JOptionPane.showMessageDialog(null, message, title, i);
	}

	/**
	 * Hier wird der Namechange des Produktes implementiert Das entsprechende
	 * Produkt ausgelesen, dessen Name ersetzt und an den Connector versandt
	 *
	 * @throws IOException
	 */
	private void postProduct() throws IOException {
		if (!getTextArea().getText().isEmpty() && getTextField_name().getText().length() > 0) {
			JSONObject postData = ApiUtil.fetchObject("products", getTextField().getText());
			JSONObject result = postData.getJSONObject("result");
			String name = result.get("name").toString();
			JSONObject new_product = new JSONObject(postData.toString().replace(name, getTextField_name().getText()));
			ApiUtil.postData(AbstractApiService.KoronaApiUrl + AbstractApiService.KoronaApiVersion + "/" + DbReader.getToken() + "/products/save/",
					new_product.getJSONObject("result"));
		} else {
			if (getTextField_name().getText().length() == 0)
				throwPopup("Sie müssen einen neuen Produktnamen eingaben", JOptionPane.ERROR_MESSAGE);
			if (getTextArea().getText().isEmpty())
				throwPopup("Sie müssen zuerst ein Produkt auswählen", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * requestProduct prüft ob wir eine Eingabe im Textfeld haben, und ob die
	 * auch eine Zahl ist und erfragt die Daten lässt sie formatieren und setzt
	 * am Ende das Textfeld
	 *
	 * @throws IOException
	 */
	public static void requestProduct() throws IOException {
		if (getTextField().getText().length() > 0 && getTextField().getText().matches("[0-9]+")) {
			getTextArea().setText(ApiUtil.formatOutput(ApiUtil.fetchObject("products", getTextField().getText())));
			
			ProductApiService.getByNumber(DbReader.getToken(), Long.valueOf(getTextField().getText()));
			
			System.out.println(ApiUtil.fetchObject("products", getTextField().getText()));
		} else {
			if (getTextField().getText() == null)
				throwPopup("Bitte geben sie eine Zahl im Feld Productnr an", JOptionPane.ERROR_MESSAGE);
			if (!getTextField().getText().matches("[0-9]+"))
				throwPopup("Die Eingabe darf nur eine Zahl sein", JOptionPane.ERROR_MESSAGE);
		}
	}
}
