package com.blogsport.nat.systemsofequation;

import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class Manual extends JOptionPane {
	private static final long serialVersionUID = 1L;

	public Manual() {
		StringBuilder msg = new StringBuilder().append("-------------------------------------------------------\n")
				.append("SOLVING SYSTEMS OF EQUATIONS\n")
				.append("-------------------------------------------------------\n")
				.append("Key in the desired *systems of equation* to solve in the following manner\n")
				.append("eg; x + y - z = 4\n").append("x - 2y + 3z = -6\n").append(" 2x + 3y + z = 7\n")
				.append("Considering the equation above:\n")
				.append("Under Matrix[][], key in the numeric values separated by commas as:\n")
				.append("1 \t 1 \t -1\n").append(" 1 \t-1\t  3\n").append("2 \t 3 \t  1\n")
				.append(" And under Vector[], key in the values at other side of the equal sign as:\n")
				.append("4\n-6\n7\n")
				.append(" Then, press the button to solve, using either (Gaussian) or (Gauss Jordan) to get desired answer\n")
				.append("X[0] = 1, X[1] = 2, X[2] = -1\n")
				.append("This is only an illustration, and it can be used to solve up to more than 10 unknown variables :)");

		setFont(new Font("Serif", 0, 15));
		setBorder(BorderFactory.createLoweredBevelBorder());
		JOptionPane.showMessageDialog(this, msg);
	}
}
