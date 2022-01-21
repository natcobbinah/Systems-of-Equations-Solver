package com.blogsport.nat.systemsofequation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class About extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel infopanel;
	private JPanel closepanel;
	private JButton closebutton;
	private JTextArea txtarea;
	private Font font;

	public About() {
		super("About SYSTEMS OF EQUATIONS SOLVER");
		layoutdesign();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - (getSize()).width / 2, dim.height / 2 - (getSize()).height / 2);
		setSize(400, 300);
		setResizable(false);
		setVisible(true);
	}

	private void layoutdesign() {
		setLayout(new BorderLayout());
		Border outerBorder = BorderFactory.createEtchedBorder();
		Border innerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border compoundBorder = BorderFactory.createCompoundBorder(outerBorder, innerBorder);
		this.txtarea = new JTextArea(15, 1);
		this.txtarea.setBackground(Color.WHITE);
		
		StringBuilder aboutMsg = new StringBuilder()
								.append("Version 1.0\n")
								.append("Author: Nathaniel Cobbinah\n")
								.append("Email:fmg3ckali@gmail.com\nEmail2:baby.hugo74@yahoo.com\n")
								.append("(c) Copyright Tank Contributors and Others 2020\n")
								.append("All rights reserved.\n")
								.append("This Systems of Equations Calculator Support as many unknown\n")
								.append("as can be computed on the supported system");
		
		this.txtarea.setEditable(false);
		this.font = new Font("Monospace", 0, 11);
		this.txtarea.setFont(this.font);
		this.txtarea.setText(aboutMsg.toString());
		this.infopanel = new JPanel();
		this.infopanel.add(this.txtarea);
		this.infopanel.setBackground(Color.red);
		this.closebutton = new JButton("Close");
		this.closebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				About.this.setVisible(false);
			}
		});
		this.closepanel = new JPanel();
		this.closepanel.add(this.closebutton);
		this.closepanel.setLayout(new FlowLayout(2));
		this.closepanel.setBorder(compoundBorder);
		add(this.closepanel, "South");
		add(this.infopanel, "Center");
	}
}
