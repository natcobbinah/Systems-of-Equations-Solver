package com.blogsport.nat.systemsofequation;

import javax.swing.SwingUtilities;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SolverMainFrame();
			}
		});
	}
}
