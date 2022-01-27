package com.blogsport.nat.systemsofequation;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

public class SolverEqntxtfd extends JPanel {

	private static final long serialVersionUID = 1L;

	public JTextArea _solverArea_Array1;
	public JTextArea _solverArea_Array2;
	public JTextArea _answertxtArea;
	private List<JButton> computeAndClearButtons;
	private List<Font> fontTypes;

	public SolverEqntxtfd() {
		setLayout(new GridBagLayout());
		this._solverArea_Array1 = new JTextArea(7, 30);
		this._solverArea_Array2 = new JTextArea(7, 30);
		this._answertxtArea = new JTextArea(6, 62);

		computeAndClearButtons = Arrays.asList(new JButton("Solve with Gaussian Elimination"),
				new JButton("Solve with Gauss Jordan Elimation"), new JButton("Clear Fields"));

		fontTypes = Arrays.asList(new Font("Courier", 1, 15), new Font("Courier", 1, 15), new Font("Courier", 1, 15));

		this._solverArea_Array1.setFont(fontTypes.get(0));
		this._solverArea_Array2.setFont(fontTypes.get(1));
		this._answertxtArea.setFont(fontTypes.get(2));
		this._solverArea_Array1.setEditable(true);
		this._solverArea_Array2.setEditable(true);
		this._answertxtArea.setEditable(false);

		GridBagConstraints gcx = new GridBagConstraints();
		gcx.gridx = 0;
		gcx.gridy = 0;
		add(new JLabel("Matrix[ ][ ]"), gcx);
		gcx.gridx = 0;
		gcx.gridy = 1;
		add(new JScrollPane(this._solverArea_Array1), gcx);
		gcx.gridx = 1;
		gcx.gridy = 0;
		add(new JLabel("Vector[ ]"), gcx);
		gcx.gridx = 1;
		gcx.gridy = 1;
		add(new JScrollPane(this._solverArea_Array2), gcx);
		gcx.gridx = 0;
		gcx.gridy = 2;
		add(new JLabel("Solution"), gcx);
		gcx.gridx = 0;
		gcx.gridy = 3;
		gcx.gridwidth = 2;
		add(new JScrollPane(this._answertxtArea), gcx);
		gcx.gridx = 0;
		gcx.gridy = 4;
		gcx.gridwidth = 1;
		add(this.computeAndClearButtons.get(0), gcx);
		gcx.gridx = 1;
		gcx.gridy = 4;
		gcx.gridwidth = 1;
		add(this.computeAndClearButtons.get(1), gcx);
		gcx.gridx = 0;
		gcx.gridy = 5;
		gcx.gridwidth = 1;
		add(this.computeAndClearButtons.get(2), gcx);

		this.computeAndClearButtons.get(0).addActionListener((ActionEvent e) -> {
			clearTextArea(_answertxtArea);
			String[] lineIntxtArea = SolverEqntxtfd.this._solverArea_Array1.getText().split("\\n");
			double size = lineIntxtArea.length;
			String[] values = new String[(int) size];
			String[][] matrix = new String[(int) size][(int) size];
			double[][] matrixConverted = new double[(int) size][(int) size];

			for (int i = 0; i < size; i++) {
				values[i] = lineIntxtArea[i];
				values[i] = values[i].trim();
				String[] single_Value = values[i].split(",");
				for (int k = 0; k < single_Value.length; k++)
					matrixConverted[i][k] = Double.parseDouble(single_Value[k]);
			}

			String[] lineIntxtvectorArea = SolverEqntxtfd.this._solverArea_Array2.getText().split("\\n");
			double Vctsize = lineIntxtvectorArea.length;
			double[] Vctvalues = new double[(int) size];
			int k;
			for (k = 0; k < Vctsize; k++)
				Vctvalues[k] = Double.parseDouble(lineIntxtvectorArea[k]);
			SolvingSysofEqns.gaussian(matrixConverted, Vctvalues);
			for (k = 0; k < matrixConverted.length; k++)
				SolverEqntxtfd.this._answertxtArea.append("X[" + k + "] = " + Vctvalues[k] + "\n");

		});

		this.computeAndClearButtons.get(1).addActionListener((ActionEvent e) -> {
			clearTextArea(_answertxtArea);
			String[] lineIntxtArea = SolverEqntxtfd.this._solverArea_Array1.getText().split("\\n");
			double size = lineIntxtArea.length;
			String[] values = new String[(int) size];
			String[][] matrix = new String[(int) size][(int) size];
			double[][] matrixConverted = new double[(int) size][(int) size];
			for (int i = 0; i < size; i++) {
				values[i] = lineIntxtArea[i];
				values[i] = values[i].trim();
				String[] single_Value = values[i].split(",");
				for (int k = 0; k < single_Value.length; k++)
					matrixConverted[i][k] = Double.parseDouble(single_Value[k]);
			}
			String[] lineIntxtvectorArea = SolverEqntxtfd.this._solverArea_Array2.getText().split("\\n");
			double Vctsize = lineIntxtvectorArea.length;
			double[] Vctvalues = new double[(int) size];
			int j;
			for (j = 0; j < Vctsize; j++)
				Vctvalues[j] = Double.parseDouble(lineIntxtvectorArea[j]);
			SolvingSysofEqns.gaussJordan(matrixConverted, Vctvalues);
			for (j = 0; j < matrixConverted.length; j++)
				SolverEqntxtfd.this._answertxtArea.append("X[" + j + "] = " + Vctvalues[j] + "\n");

		});

		this.computeAndClearButtons.get(2).addActionListener((ActionEvent e) -> {
			clearTextArea(_solverArea_Array1);
			clearTextArea(_solverArea_Array2);
			clearTextArea(_answertxtArea);
		});
		setVisible(true);
	}

	public void clearTextArea(JTextComponent textComponent) {
		textComponent.setText("");
	}
}
