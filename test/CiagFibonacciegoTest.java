import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CiagFibonacciegoTest {
	int[] oczekiwane = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 };

	@Test
	public void powinien_wyznaczyc_kolejne_wartosci_fibonacci() {
		sprawdz(0);
		sprawdz(1);
		sprawdz(2);
		sprawdz(3);
		sprawdz(4);
		sprawdz(5);
		sprawdz(6);
		sprawdz(7);
		sprawdz(8);
		sprawdz(9);
		sprawdz(10);
		sprawdz(11);
		sprawdz(12);
	}

	public void sprawdz(int index) {
		assertEquals("fibonacci(" + index + ")", oczekiwane[index], CiagFibonacciego.fibonaccie(index));
	}
}
