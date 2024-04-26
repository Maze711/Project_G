import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

public class MTMBIncomingPage {

	private JFrame frame;
	DefaultTableModel model;
	private JTable table;
	private JTextField SearchBar;
	private final MTMBDBCONN conn = new MTMBDBCONN();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MTMBIncomingPage window = new MTMBIncomingPage();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
					window.frame.setResizable(false);
					window.frame.setTitle("MTMB");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void refresh() {
	    fetchData(); // Update table data from the database
	}

	public MTMBIncomingPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 1044, 808);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

//		CUSTOM FONT FAMILY STYLE
		Font PrimaryFont = FontLoader.getFont("Primary", 64);
		Font SecondaryFont = FontLoader.getFont("Secondary", 24);
		Font PrimaryEBFont = FontLoader.getFont("PrimaryEB32", 24);
		Font SemiB = FontLoader.getFont("SemiB", 24);
		Font SemiB16 = FontLoader.getFont("SemiB", 16);
		Font PrimaryEB48Font = FontLoader.getFont("PrimaryEB32", 48);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1028, 768);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		// Navigation Panel
		JPanel NavigationPanel = new JPanel();
		NavigationPanel.setBounds(0, 0, 293, 768);
		panel.add(NavigationPanel);
		NavigationPanel.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(269, 386, 24, 42);
		lblNewLabel_4.setIcon(new ImageIcon("Resources\\Icons\\Slider.png"));
		NavigationPanel.add(lblNewLabel_4);

		JLabel MTMBLogo = new JLabel("");
		MTMBLogo.setBounds(52, 38, 132, 147);
		MTMBLogo.setIcon(new ImageIcon("Resources\\Images\\MTMBLogo.png"));
		NavigationPanel.add(MTMBLogo);

		JLabel Dashboard = new JLabel("Dashboard");
		Dashboard.setBounds(52, 220, 141, 36);
		Dashboard.setForeground(new Color(255, 255, 255));
		Dashboard.setFont(SemiB);
		NavigationPanel.add(Dashboard);

		JLabel Home = new JLabel("Home");
		Home.setBounds(100, 277, 74, 36);
		Home.setForeground(Color.WHITE);
		Home.setFont(SemiB);
		NavigationPanel.add(Home);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(52, 269, 42, 42);
		lblNewLabel_5.setIcon(new ImageIcon("Resources\\Icons\\IHome.png"));
		NavigationPanel.add(lblNewLabel_5);

		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setBounds(52, 327, 42, 42);
		lblNewLabel_5_1.setIcon(new ImageIcon("Resources\\Icons\\Database.png"));
		NavigationPanel.add(lblNewLabel_5_1);

		JLabel Records = new JLabel("Records");
		Records.setBounds(100, 333, 102, 36);
		Records.setForeground(Color.WHITE);
		Records.setFont(SemiB);
		NavigationPanel.add(Records);

		JLabel lblNewLabel_5_1_1 = new JLabel("");
		lblNewLabel_5_1_1.setBounds(52, 386, 42, 42);
		lblNewLabel_5_1_1.setIcon(new ImageIcon("Resources\\Icons\\Download.png"));
		NavigationPanel.add(lblNewLabel_5_1_1);

		JLabel Incoming = new JLabel("Incoming");
		Incoming.setBounds(100, 386, 120, 36);
		Incoming.setForeground(Color.WHITE);
		Incoming.setFont(SemiB);
		NavigationPanel.add(Incoming);

		JLabel lblNewLabel_5_1_1_1 = new JLabel("");
		lblNewLabel_5_1_1_1.setBounds(52, 445, 42, 42);
		lblNewLabel_5_1_1_1.setIcon(new ImageIcon("Resources\\Icons\\Upload.png"));
		NavigationPanel.add(lblNewLabel_5_1_1_1);

		JLabel Releasing = new JLabel("Releasing");
		Releasing.setBounds(100, 445, 120, 36);
		Releasing.setForeground(Color.WHITE);
		Releasing.setFont(SemiB);
		NavigationPanel.add(Releasing);

		JLabel lblNewLabel_5_1_1_1_1 = new JLabel("");
		lblNewLabel_5_1_1_1_1.setBounds(52, 543, 42, 42);
		lblNewLabel_5_1_1_1_1.setIcon(new ImageIcon("Resources\\Icons\\Logout.png"));
		NavigationPanel.add(lblNewLabel_5_1_1_1_1);

		JLabel Logout = new JLabel("Logout");
		Logout.setBounds(100, 543, 120, 36);
		Logout.setForeground(Color.WHITE);
		Logout.setFont(SemiB);
		NavigationPanel.add(Logout);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 293, 768);
		lblNewLabel.setIcon(new ImageIcon("Resources\\Images\\BG info.png"));
		NavigationPanel.add(lblNewLabel);

		JPanel RecordPanel = new JPanel();
		RecordPanel.setBounds(292, 0, 736, 768);
		panel.add(RecordPanel);
		RecordPanel.setLayout(null);

		JLabel SearchIcon = new JLabel("");
		SearchIcon.setBounds(10, 77, 42, 42);
		RecordPanel.add(SearchIcon);

		// Header
		JPanel InsideRecordPanel = new JPanel();
		InsideRecordPanel.setBounds(0, 0, 736, 70);
		RecordPanel.add(InsideRecordPanel);
		InsideRecordPanel.setLayout(null);

		JLabel Record = new JLabel("INCOMING");
		Record.setBounds(30, 23, 189, 36);
		Record.setFont(PrimaryEBFont);
		InsideRecordPanel.add(Record);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 130, 716, 627);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		RecordPanel.add(scrollPane);

		table = new JTable();
		table.setShowHorizontalLines(false);
		model = new DefaultTableModel();
		Object[] column = { "Ctrl No.", "Type", "Plate No.", "Color", "Date", "Status" };
		model.setColumnIdentifiers(column);
		table.setModel(model);
		table.setEnabled(false);
		table.setFont(SemiB16);
		table.setForeground(new Color(101, 95, 95));
		table.getTableHeader().setReorderingAllowed(false);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < column.length; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		// Add a MouseWheelListener to both the table and the scroll pane
		MouseWheelListener mouseWheelListener = new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				int notches = e.getWheelRotation();
				JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
				// Increase scrolling speed by a factor of 10
				verticalScrollBar
						.setValue(verticalScrollBar.getValue() + (verticalScrollBar.getUnitIncrement() * notches * 10));
			}
		};
		table.addMouseWheelListener(mouseWheelListener);
		scrollPane.addMouseWheelListener(mouseWheelListener);

		JTableHeader header = table.getTableHeader();
		header.setFont(SemiB16);
		header.setBackground(new Color(11, 30, 51));
		header.setForeground(Color.WHITE);
		table.setRowHeight(50);
		table.setFocusable(true);
		table.setTableHeader(header);

		// Add the table to the scroll pane
		scrollPane.setViewportView(table);

		JButton FilterButton = new RoundButton("Filter", 16, Color.decode("#D3D9E0"));
		FilterButton.setBounds(420, 81, 80, 38);
		FilterButton.setFont(SemiB16);
		FilterButton.setForeground(new Color(11, 30, 51));
		RecordPanel.add(FilterButton);

		JButton AddButton = new RoundButton("ADD+", 16, Color.decode("#FFBA42"));
		AddButton.setBounds(510, 81, 90, 38);
		AddButton.setFont(SemiB16);
		FilterButton.setForeground(new Color(11, 30, 51));
		RecordPanel.add(AddButton);

		JButton importButton = new RoundButton("Import", 16, Color.decode("#00537A"));
		importButton.setBounds(609, 81, 117, 38);
		importButton.setFont(SemiB16);
		importButton.setForeground(Color.WHITE);
		importButton.addActionListener(e -> {
		    // Prompt user to enter table name
		    String tableName = JOptionPane.showInputDialog(frame, "Enter table name:");
		    if (tableName != null && !tableName.isEmpty()) {
		        // Browse file
		        JFileChooser fileChooser = new JFileChooser();

		        // Set file filter to show only Excel files (*.xlsx)
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel files", "xlsx");
		        fileChooser.setFileFilter(filter);

		        int result = fileChooser.showOpenDialog(frame);
		        if (result == JFileChooser.APPROVE_OPTION) {
		            File selectedFile = fileChooser.getSelectedFile();
		            String filePath = selectedFile.getAbsolutePath();

		            SwingUtilities.invokeLater(() -> {
		                MTMBImporter importer = new MTMBImporter();
		                // Call importExcelFile with additional parameters including the current frame
		                // and this instance
		                importer.importExcelFile(filePath, tableName, frame, this).thenRun(() -> {
		                    System.out.println("Import completed successfully!");
		                    // Call the refresh method after successful import
		                    refresh(); 
		                }).exceptionally(ex -> {
		                    ex.printStackTrace();
		                    return null;
		                });
		            });
		        }
		    }
		});


		// Only add importButton to RecordPanel, not to the frame
		RecordPanel.add(importButton);

		SearchBar = new RoundTxtField(18, new Color(132, 132, 132), 1);
		SearchBar.setText("Search");
		SearchBar.setBounds(10, 81, 292, 38);
		SearchBar.setFont(SemiB16);
		RecordPanel.add(SearchBar);
		SearchBar.setColumns(10);

		fetchData();
	}

	private void fetchData() {
		try (Connection connection = conn.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM 2024mtmbrecord")) {

			// Clear existing table data
			model.setRowCount(0);

			// Populate table with data from the database
			while (resultSet.next()) {
				int id = resultSet.getInt("CTRLNo");
				String type = resultSet.getString("Type");
				String plateno = resultSet.getString("PlateNo");
				String color = resultSet.getString("Color");
				String date = resultSet.getString("Date");
				String status = resultSet.getString("Status");

				model.addRow(new Object[] { id, type, plateno, color, date, status });
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
