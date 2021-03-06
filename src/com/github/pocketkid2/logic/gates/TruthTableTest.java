package com.github.pocketkid2.logic.gates;

import org.junit.jupiter.api.Test;

class TruthTableTest {

	@Test
	void test() {
		System.out.println("NOT GATE");
		TruthTable notGate = new TruthTable(new char[] { 'A' }, new char[] { 'Y' });
		notGate.setOutput('Y', new boolean[] { true, false });
		notGate.print();

		System.out.println();
		System.out.println();

		System.out.println("AND GATE");
		TruthTable andGate = new TruthTable(new char[] { 'A', 'B' }, new char[] { 'Y' });
		andGate.setOutput('Y', new boolean[] { false, false, false, true });
		andGate.print();

		System.out.println();
		System.out.println();
		
		System.out.println("OR GATE");
		TruthTable orGate = new TruthTable(new char[] { 'A', 'B' }, new char[] { 'Y' });
		orGate.setOutput('Y', new boolean[] { false, true, true, true });
		orGate.print();

		System.out.println();
		System.out.println();

		System.out.println("NAND GATE");
		andGate.invert();
		andGate.print();
		
		System.out.println();
		System.out.println();

		System.out.println("NOR GATE");
		orGate.invert();
		orGate.print();
	}

}
