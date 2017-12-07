package com.github.pocketkid2.logic;

// This class represents a truth table with any given inputs and outputs
public class TruthTable {

	// Let's set some reasonable limits for the moment
	public static final int MAX_INPUTS = 16;
	public static final int MAX_OUTPUTS = 16;

	// This is the truth table, defined as follows:
	// - The first dimension refers to each OUTPUT column
	// - The second dimension refers to the row corresponding to the binary value of the inputs IN ORDER
	private boolean[][] table;
	
	// These are the arrays that hold the characters representing the inputs and outputs.
	private char[] inputs;
	private char[] outputs;
	
	/**
	 * Creates a truth table given an array of characters to represent the inputs and an array of characters to
	 * represent the outputs. Arrays must not be null
	 *
	 * @param inputs
	 * @param outputs
	 */
	public TruthTable(char[] inputs, char[] outputs) {
		
		// Check for null, better safe than sorry
		if (inputs == null) throw new IllegalArgumentException("Input array cannot be null!");
		
		if (outputs == null) throw new IllegalArgumentException("Output array cannot be null!");
		
		// Check that the array size is within reason
		if (inputs.length > MAX_INPUTS)
			throw new IllegalArgumentException("Input array cannot be greater than " + MAX_INPUTS);
		
		if (outputs.length > MAX_OUTPUTS)
			throw new IllegalArgumentException("Output array cannot be greater than " + MAX_OUTPUTS);

		// We must also make sure that there are no duplicate characters
		if (duplicates(inputs, outputs))
			throw new IllegalArgumentException("All input and output characters must be unique");
		
		// Initialize the needed variables
		byte rows = (byte) (1 << inputs.length);
		// byte rows = ()(byte) Math.pow(2, inputs.length);
		byte columns = (byte) outputs.length;
		
		// Initialize the boolean array
		table = new boolean[rows][columns];
		
		// Save the characters
		this.inputs = inputs;
		this.outputs = outputs;
		
	}

	/**
	 * Set the output column that matches the output character to the given new values
	 *
	 * @param c
	 *            The character to match output column with
	 * @param values
	 */
	public void setOutput(char ch, boolean[] values) {
		
		// Find which index the output is
		int n = String.valueOf(outputs).indexOf(ch);

		// If there is none, throw an exception
		if (n == -1) throw new IllegalArgumentException("Character does not exist in output");
		
		// Check to make sure that values is the correct length
		if (values.length != table.length) throw new IllegalArgumentException("Boolean array is incorrect length");

		// Set the new values
		for (int i = 0; i < values.length; i++) {
			table[i][n] = values[i];
		}
	}
	
	/**
	 * Prints this truth table to the console with some formatting
	 */
	public void print() {

		// Set the string that runs down the middle
		String middle = " | | ";

		// Create both sides of the header and join them
		String header1 = String.join(" | ", String.valueOf(inputs).split("(?!^)"));
		String header2 = String.join(" | ", String.valueOf(outputs).split("(?!^)"));
		String header = header1 + middle + header2;
		
		// Print the header
		System.out.println(header);

		// Create the dash to start the table
		StringBuilder sb = new StringBuilder();
		int n = header1.length() + header2.length() + middle.length();
		for (int i = 0; i < n; i++) {
			sb.append('-');
		}
		String line = sb.toString();

		// Print the dash line
		System.out.println(line);

		// For each row
		for (int i = 0; i < table.length; i++) {
			// Create the binary string
			sb = new StringBuilder();

			// Format row number into an x bit unsigned binary number, where x is the number of inputs
			String rowInputs = String.format("%" + inputs.length + "s", Integer.toBinaryString(i)).replace(' ', '0');

			// Format the output data replacing the integer values 0 and 1 with the character value 0 and 1
			String rowOutputs = binaryString(table[i]);

			// Create both sides and join them
			String side1 = String.join(" | ", rowInputs.split("(?!^)"));
			String side2 = String.join(" | ", rowOutputs.split("(?!^)"));
			String finalRow = side1 + middle + side2;

			// And print
			System.out.println(finalRow);
		}

	}

	/**
	 * A helper method for converting a boolean array into a string with it's associated binary representation
	 *
	 * @param bs
	 * @return
	 */
	private String binaryString(boolean[] bs) {

		// Create a string builder
		StringBuilder sb = new StringBuilder();

		// Loop through all boolean values
		for (boolean b : bs) {

			// If it is true, append a 1, if not, append a 0
			sb.append(b ? '1' : '0');
		}

		// Return the final value
		return sb.toString();
	}
	
	/**
	 * A helper method for checking if there are ANY duplicates in both arrays combined.
	 *
	 * @param one
	 * @param two
	 * @return true if there are duplicates, false if not
	 */
	private boolean duplicates(char[] one, char[] two) {

		// Create an array with enough space for both
		char[] joined = new char[one.length + two.length];

		// Copy over the first array
		System.arraycopy(one, 0, joined, 0, one.length);

		// Copy over the second array
		System.arraycopy(two, 0, joined, one.length, two.length);

		// Loop through each index twice
		for (int i = 0; i < joined.length; i++) {
			for (int j = 0; j < joined.length; j++) {

				// If we're not at the same index but the chars are the same, we have a duplicate
				if (i != j && joined[i] == joined[j]) return true;

			}
		}
		
		// If we did not return true above, then there are no duplicates so return false
		return false;
	}

}
