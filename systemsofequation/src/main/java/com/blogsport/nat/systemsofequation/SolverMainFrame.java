package com.blogsport.nat.systemsofequation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class SolverMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private SolverEqntxtfd solverEqnfds;
	private About about;
	private Manual manual;

	public SolverMainFrame() {
		super("Systems of Equations Solver");
		createGUI();
		setJMenuBar(createMenuBar());
	}

	public void createGUI() {
		setLayout(new BorderLayout());
		setSize(900, 530);
		setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - (getSize()).width / 2, dim.height / 2 - (getSize()).height / 2);
		this.solverEqnfds = new SolverEqntxtfd();
		add(this.solverEqnfds, "Center");
		setDefaultCloseOperation(3);
		setVisible(true);
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem exitItem = new JMenuItem("Exit");
		fileMenu.add(exitItem);
		JMenu windowMenu = new JMenu("Help");
		JMenuItem aboutmenuItem = new JMenuItem("About");
		JMenuItem manualmenuItem = new JMenuItem("Manual");
		windowMenu.add(aboutmenuItem);
		windowMenu.add(manualmenuItem);
		menuBar.add(fileMenu);
		menuBar.add(windowMenu);
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(SolverMainFrame.this,
						"Do you really want to exit the application?", "Confirm Exit", 2);
				if (action == 0)
					System.exit(0);
			}
		});
		aboutmenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SolverMainFrame.this.about = new About();
			}
		});
		manualmenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SolverMainFrame.this.manual = new Manual();
			}
		});
		return menuBar;
	}
}
