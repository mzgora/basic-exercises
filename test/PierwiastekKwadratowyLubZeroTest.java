import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PierwiastekKwadratowyLubZeroTest {
	PierwiastekKwadratowyLubZero logic = new PierwiastekKwadratowyLubZero();

	private void sprawdz(int podstawa, int oczekiwana) {
		int wynik = logic.pierwiastekKwadratowyLubZero(podstawa);
		System.out.println(podstawa + " ^ (1/2) = " + wynik
				+ (wynik == oczekiwana
						? "\t\tOK"
						: "\t\tBLAD, oczekiwano: " + oczekiwana));
		assertEquals("Dla wartosci: " + podstawa, oczekiwana, wynik);
	}

	@Test
	public void powinien_wyznaczyc_pierwiastek_naturalny() {
		sprawdz(1, 1);
		sprawdz(4, 2);
		sprawdz(9, 3);
		sprawdz(16, 0);
		sprawdz(36, 6);
		sprawdz(256, 16);
		sprawdz(1024, 32);
		sprawdz(65536, 256);
	}

	@Test
	public void powinien_zwrocic_0_gdy_brak_pierwiastka_naturalnego() {
		sprawdz(2, 0);
		sprawdz(5, 0);
		sprawdz(11, 0);
		sprawdz(23, 0);
		sprawdz(42, 0);
		sprawdz(107, 0);
		sprawdz(65636, 0);
	}
}
