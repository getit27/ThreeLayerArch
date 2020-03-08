package cn.edu.nju.userinterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import cn.edu.nju.businesslayer.AppData;
import cn.edu.nju.businesslayer.CustomerRecord;
import cn.edu.nju.businesslayer.InvalidTelephoneException;
import cn.edu.nju.businesslayer.PhoneNumber;

public class MainGUI extends JFrame {
	public MainGUI(String statusText) throws HeadlessException {
		super();
		this.statusText = statusText;
	}

	public MainGUI() {
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

	}

	private String statusText;

	public static void main(String[] args) {

		final JFrame myMainFrame = new MainGUI();
		JPanel myMainPanel = new JPanel();
		myMainPanel.setLayout(new BoxLayout(myMainPanel, BoxLayout.Y_AXIS));
		myMainPanel.setVisible(true);
		
		myMainFrame.setTitle("Customer Information");
		myMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myMainFrame.setVisible(true);

		JLabel label = new JLabel(" Registration Date:");
		final JTextField text = new JTextField(20);
		JButton b = new JButton("Select Date");

		JPanel p = new JPanel();
		p.add(label);
		p.add(text);
		p.add(b);
		p.setBackground(Color.white);
		
		myMainFrame.getContentPane().add(myMainPanel);
		myMainFrame.setVisible(true);

		myMainPanel.add(p);

		final JPanel horizontal = new JPanel();
		horizontal.setLayout(new BoxLayout(horizontal, BoxLayout.Y_AXIS));
		myMainPanel.add(horizontal);
		horizontal.setBackground(Color.white);
		
		JPanel row1 = new JPanel();
		row1.setLayout(new BoxLayout(row1, BoxLayout.X_AXIS));
		horizontal.add(row1);
		JLabel firstName = new JLabel(" First Name      ");
		final JTextField firstNameInput = new JTextField();
		row1.add(firstName);
		row1.add(firstNameInput);
		
		JLabel lastName = new JLabel(" Last Name       ");
		JLabel emailAddress = new JLabel(" Email Address ");
		JLabel phoneNumber = new JLabel(" Phone Number");
		JLabel address = new JLabel(" Address          ");
		JLabel city = new JLabel(" City                 ");
		JLabel state = new JLabel(" State               ");
		JLabel zipCode = new JLabel(" Zip Code         ");

		final JTextField lastNameInput = new JTextField();
		final JTextField emailAddressInput = new JTextField();
		final JTextField phoneNumberInput = new JTextField();
		final JTextField addressInput = new JTextField();
		final JTextField cityInput = new JTextField();
		final JTextField stateInput = new JTextField();
		final JTextField zipCodeInput = new JTextField();

		int width = 370;
		int height = 30;
		
		firstNameInput.setMaximumSize(new Dimension(width, height));
		firstNameInput.setPreferredSize(new Dimension(width, height));

		lastNameInput.setMaximumSize(new Dimension(width, height));
		lastNameInput.setPreferredSize(new Dimension(width, height));

		emailAddressInput.setMaximumSize(new Dimension(width, height));
		emailAddressInput.setPreferredSize(new Dimension(width, height));

		phoneNumberInput.setMaximumSize(new Dimension(width, height));
		phoneNumberInput.setPreferredSize(new Dimension(width, height));

		addressInput.setMaximumSize(new Dimension(width, height));
		addressInput.setPreferredSize(new Dimension(width, height));

		cityInput.setMaximumSize(new Dimension(width, height));
		cityInput.setPreferredSize(new Dimension(width, height));
		
		stateInput.setMaximumSize(new Dimension(width, height));
		stateInput.setPreferredSize(new Dimension(width, height));
		
		zipCodeInput.setMaximumSize(new Dimension(width, height));
		zipCodeInput.setPreferredSize(new Dimension(width, height));
		
		JPanel row2 = new JPanel();
		row2.setLayout(new BoxLayout(row2, BoxLayout.X_AXIS));
		horizontal.add(row2);
		row2.add(lastName);
		row2.add(lastNameInput);

		JPanel row3 = new JPanel();
		row3.setLayout(new BoxLayout(row3, BoxLayout.X_AXIS));
		horizontal.add(row3);
		row3.add(emailAddress);
		row3.add(emailAddressInput);

		JPanel row4 = new JPanel();
		row4.setLayout(new BoxLayout(row4, BoxLayout.X_AXIS));
		horizontal.add(row4);
		row4.add(phoneNumber);
		row4.add(phoneNumberInput);

		JPanel row5 = new JPanel();
		row5.setLayout(new BoxLayout(row5, BoxLayout.X_AXIS));
		horizontal.add(row5);
		row5.add(address);
		row5.add(addressInput);

		JPanel row6 = new JPanel();
		row6.setLayout(new BoxLayout(row6, BoxLayout.X_AXIS));
		horizontal.add(row6);
		row6.add(city);
		row6.add(cityInput);

		JPanel row7 = new JPanel();
		row7.setLayout(new BoxLayout(row7, BoxLayout.X_AXIS));
		horizontal.add(row7);
		row7.add(state);
		row7.add(stateInput);

		JPanel row8 = new JPanel();
		row8.setLayout(new BoxLayout(row8, BoxLayout.X_AXIS));
		horizontal.add(row8);
		row8.add(zipCode);
		row8.add(zipCodeInput);

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				text.setText(new DatePicker(myMainFrame).setPickedDate());
			}
		});

		JPanel row12 = new JPanel();
		row12.setLayout(new BoxLayout(row12, BoxLayout.X_AXIS));
		horizontal.add(row12);
		JButton saveButton = new JButton("  Save Record  ");

		row12.add(saveButton);

		saveButton.setActionCommand("Save it");

		JPanel row13 = new JPanel();
		row13.setLayout(new BoxLayout(row13, BoxLayout.X_AXIS));
		horizontal.add(row13);

		JButton getCustomerRecordButton = new JButton("           Search For Record           ");
		JButton findAllRecordsButton = new JButton("Print All Records");
		JButton deleteCustomerRecordButton = new JButton("             Delete A Record              ");

		row13.add(getCustomerRecordButton);
		row12.add(findAllRecordsButton);
		row13.add(deleteCustomerRecordButton);

		getCustomerRecordButton.setActionCommand("Find it");
		findAllRecordsButton.setActionCommand("Print them all");
		deleteCustomerRecordButton.setActionCommand("Delete it");

		JPanel row14 = new JPanel();
		row14.setLayout(new BoxLayout(row14, BoxLayout.X_AXIS));
		horizontal.add(row14);
		final JTextField getCustomerRecordField = new JTextField("Enter last name");
		final JTextField deleteCustomerRecordField = new JTextField();

		int width2 = 250;
		getCustomerRecordField.setMaximumSize(new Dimension(width2, height));
		getCustomerRecordField.setPreferredSize(new Dimension(width2, height));

		deleteCustomerRecordField.setMaximumSize(new Dimension(width2, height));
		deleteCustomerRecordField.setPreferredSize(new Dimension(width2, height));

		deleteCustomerRecordField.setText("Enter last name");
		getCustomerRecordField.setForeground(Color.LIGHT_GRAY);
		deleteCustomerRecordField.setForeground(Color.LIGHT_GRAY);

		row14.add(getCustomerRecordField);
		row14.add(deleteCustomerRecordField);

		JPanel row15 = new JPanel();
		row15.setLayout(new BoxLayout(row15, BoxLayout.X_AXIS));
		horizontal.add(row15);
		final String statusText = "Status: ";
		JLabel statusUpdate = new JLabel(statusText);

		final JLabel statusUpdate2 = new JLabel("Awaiting Selection");

		row15.add(statusUpdate);
		row15.add(statusUpdate2);
		row15.setVisible(true);

		final JLabel recordsPrinted = new JLabel();
		final JPanel row16 = new JPanel();
		row16.setLayout(new BoxLayout(row16, BoxLayout.X_AXIS));
		row16.add(recordsPrinted);

		final JFrame scroll = new JFrame();
		final JScrollPane scrPane = new JScrollPane(row16);
		scroll.add(scrPane);
		scrPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.getContentPane().add(scrPane);
		scrPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrPane.setMinimumSize(new Dimension(160, 200));
		scrPane.setPreferredSize(new Dimension(160, 200));

		final JPanel closePanel = new JPanel();
		horizontal.add(closePanel);
		final JButton close = new JButton("Close Records Window");
		close.setActionCommand("close this");
		closePanel.add(close);
		closePanel.setVisible(false);
		
		
		//design
		row1.setBackground(Color.white);
		row2.setBackground(Color.white);
		row3.setBackground(Color.white);
		row4.setBackground(Color.white);
		row5.setBackground(Color.white);
		row6.setBackground(Color.white);
		row7.setBackground(Color.white);
		row8.setBackground(Color.white);
		row12.setBackground(Color.white);
		row13.setBackground(Color.white);
		row14.setBackground(Color.white);
		row15.setBackground(Color.white);
		row16.setBackground(Color.white);
		closePanel.setBackground(Color.white);
		scroll.setBackground(Color.white);


//		lastNameInput.setForeground(Color.DARK_GRAY);;
//		emailAddressInput.setForeground(Color.DARK_GRAY);
//		phoneNumberInput.setForeground(Color.DARK_GRAY);
//		addressInput.setForeground(Color.DARK_GRAY);
//		cityInput.setForeground(Color.DARK_GRAY);
//		 stateInput.setForeground(Color.DARK_GRAY);
//		 zipCodeInput.setForeground(Color.DARK_GRAY);

		myMainFrame.pack();
		

		// This listens for the click of the 'Save Record' button
		// Once clicked, the customer info is stored in the database
		// and the 'Status' display confirms that the record was saved.
		// A registration date and last name are required for saving.
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				if (command.equals("Save it")) {
					if (text.getText().length() > 0 && lastNameInput.getText().length() > 0) {
						String date = text.getText();
						String firstNameEntry = firstNameInput.getText();
						String lastNameEntry = lastNameInput.getText();
						String emailAddressEntry = emailAddressInput.getText();
						String addressEntry = addressInput.getText();
						String cityEntry = cityInput.getText();
						String stateEntry = stateInput.getText();
						String zipCodeEntry = zipCodeInput.getText();

						String phoneNumberDraft = phoneNumberInput.getText();
						if (phoneNumberDraft.length() != 0) {
							String phoneNumberEntry = null;
							try {
								phoneNumberEntry = new PhoneNumber(phoneNumberDraft).toString();
							} catch (InvalidTelephoneException e1) {
								System.out.println();
							}
						} else {
							String phoneNumberEntry = phoneNumberInput.getText();
						}
						String phoneNumberEntry = phoneNumberInput.getText();

						AppData.getAppData().addCalendarEntry(
								new CustomerRecord(date, firstNameEntry, lastNameEntry, emailAddressEntry,
										phoneNumberEntry, addressEntry, cityEntry, stateEntry, zipCodeEntry));
						statusUpdate2.setText("Record saved.");

					} else {
						statusUpdate2.setText("Record not saved. Last Name and Date required.");
					}
				}

			}
		});

		// This listens for the click of the 'Print All Records' button
		// Once clicked, the all customer record are retrieved and
		// printed to the GUI. A button is generated allowing user to close
		// the record view.
		findAllRecordsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				if (command.equals("Print them all")) {

					AppData.getAppData().printSchedule();

					recordsPrinted.setText("<html>" + AppData.getAppData().printSchedule() + "</html>");
					horizontal.add(scrPane);
					closePanel.setVisible(true);
					scrPane.setVisible(true);
					scroll.pack();
					statusUpdate2.setText("All records printed");
					myMainFrame.pack();

					close.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String command = e.getActionCommand();
							if (command.equals("close this")) {
								statusUpdate2.setText("Awaiting selection");
								scrPane.setVisible(false);
								closePanel.setVisible(false);
								myMainFrame.pack();
							}
						}
					});

				}
			}
		});

		// This listens for the click of the 'Search For Record' button
		// Once clicked, the record is found by the lastName and the record
		// is printed to the GUI. A button is generated allowing user to close
		// the record view.
		getCustomerRecordButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				if (command.equals("Find it")) {
					statusUpdate2.setText("Retrieving all records...");
					String searchName = getCustomerRecordField.getText();

					if (AppData.getAppData().selectPerson(searchName) != null) {
						recordsPrinted.setText("<html>" + AppData.getAppData().selectPerson(searchName) + "</html>");
						horizontal.add(scrPane);
						closePanel.setVisible(true);
						scrPane.setVisible(true);
						scroll.pack();
						statusUpdate2.setText("Customer record printed");
						myMainFrame.pack();

						close.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								String command = e.getActionCommand();
								if (command.equals("close this")) {
									statusUpdate2.setText("Awaiting selection");
									scrPane.setVisible(false);
									closePanel.setVisible(false);
									myMainFrame.pack();
								}
							}
				
						});
					} else {
						statusUpdate2.setText("Enter First and Last Name For Search");
					}
				}
			}
		});

		// This listens for a click of the 'Delete a Record' button. If the last
		// name entered into the textfield matches the last name of a record,
		// that
		// that record is deleted.
		deleteCustomerRecordButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				if (command.equals("Delete it")) {
					int initialCount = AppData.getAppData().countRows();
					String deleteName = deleteCustomerRecordField.getText();
					if (deleteName.length() > 0) {
						AppData.deleteRecord(deleteName, statusText);
						statusUpdate2.setText("Customer: " + deleteName + " deleted.");
					} else {
						statusUpdate2.setText("here");
					}
					int finalCount = AppData.getAppData().countRows();
					if (initialCount != finalCount) {
						statusUpdate2.setText("Record deleted");
					} else {
						statusUpdate2.setText("Record not found");
					}

				}
			}
		});

	}
}

// Creates date picker where user can select date from calendar
class DatePicker {
	int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
	int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);;
	JLabel l = new JLabel("", JLabel.CENTER);
	String day = "";
	JDialog d;
	JButton[] button = new JButton[49];

	public DatePicker(JFrame parent) {
		d = new JDialog();
		d.setModal(true);
		String[] header = { "Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat" };
		JPanel p1 = new JPanel(new GridLayout(7, 7));
		p1.setPreferredSize(new Dimension(430, 120));

		for (int x = 0; x < button.length; x++) {
			final int selection = x;
			button[x] = new JButton();
			button[x].setFocusPainted(false);
			button[x].setBackground(Color.white);
			if (x > 6)
				button[x].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						day = button[selection].getActionCommand();
						d.dispose();
					}
				});
			if (x < 7) {
				button[x].setText(header[x]);
				button[x].setForeground(Color.red);
			}
			p1.add(button[x]);
		}
		JPanel p2 = new JPanel(new GridLayout(1, 3));
		JButton previous = new JButton("<< Previous");
		previous.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				month--;
				displayDate();
			}
		});
		p2.add(previous);
		p2.add(l);
		JButton next = new JButton("Next >>");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				month++;
				displayDate();
			}
		});
		p2.add(next);
		d.add(p1, BorderLayout.CENTER);
		d.add(p2, BorderLayout.SOUTH);
		d.pack();
		d.setLocationRelativeTo(parent);
		displayDate();
		d.setVisible(true);
	}

	public void displayDate() {
		for (int x = 7; x < button.length; x++)
			button[x].setText("");
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MMMM yyyy");
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(year, month, 1);
		int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
		int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
		for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++)
			button[x].setText("" + day);
		l.setText(sdf.format(cal.getTime()));
		d.setTitle("Date Picker");
	}

	public String setPickedDate() {
		if (day.equals(""))
			return day;
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(year, month, Integer.parseInt(day));
		return sdf.format(cal.getTime());
	}

}
