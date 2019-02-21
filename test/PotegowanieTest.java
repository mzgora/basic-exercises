import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PotegowanieTest {
	Potegowanie logika = new Potegowanie();

	@Test
	public void powinien_potegowac_do_pierwszej_potegi() {
		sprawdz(1, 1);
		sprawdz(2, 1);
		sprawdz(3, 1);
		sprawdz(10, 1);
	}

	@Test
	public void powinien_potegowac_do_kwadratu() {
		sprawdz(2, 2);
		sprawdz(3, 2);
		sprawdz(10, 2);
	}

	@Test
	public void powinien_potegowac_do_potegi_wiekszej_niz_2() {
		sprawdz(2, 8);
		sprawdz(2, 3);
		sprawdz(2, 8);
	}

	@Test
	public void powinien_potegowac_do_poteg_ujemnych() {
		sprawdz(-4, 1);
		sprawdz(-4, 2);
		sprawdz(-2, 3);
	}

	@Test
	public void powinien_potegowac_do_potegi_0() {
		sprawdz(10, 0);
		sprawdz(-10, 0);
		sprawdz(1, 0);
	}

	@Test
	public void powinien_potegowac_0_do_dowolnej_potegi() {
		sprawdz(0, 1);
		sprawdz(0, 1000);
	}

	private void sprawdz(int podstawa, int potega) {
		int wynik = Potegowanie.potega(podstawa, potega);
		System.out.println(podstawa + " ^ " + potega + " = " + wynik + "\t" + ((int) Math.pow(podstawa, potega) == wynik ? "OK"
						: "BLAD, oczekiwano:\t" + (int) Math.pow(podstawa, potega)));
		assertEquals(podstawa + " ^ " + potega + " = ", (int) Math.pow(podstawa, potega), wynik);
	}
}
