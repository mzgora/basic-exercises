import static org.junit.Assert.assertEquals;

import java.util.stream.IntStream;

import org.junit.Test;

public class CzyLiczbaPierwszaTest {
	int[] liczbyPierwszeDo100 = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
			73, 79, 83, 89, 97 };
	CzyLiczbaPierwsza logika = new CzyLiczbaPierwsza();

	@Test
	public void powinien_stwierdzic_ze_0_nie_jest_liczba_pierwsza() {
		sprawdz(0);
	}

	@Test
	public void powinien_stwierdzic_ze_1_nie_jest_liczba_pierwsza() {
		sprawdz(1);
	}

	@Test
	public void powinien_okreslic_czy_liczby_z_zakresu_1_do_100_sa_liczbami_pierwszymi() {
		for (int sprawdzana = 0; sprawdzana <= 100; sprawdzana++) {
			sprawdz(sprawdzana);
		}
	}

	private void sprawdz(int sprawdzana) {
		assertEquals("czyLiczbaPierwsza(" + sprawdzana + ")",
				IntStream.of(liczbyPierwszeDo100).anyMatch(value -> value == sprawdzana),
				logika.czyLiczbaPierwsza(sprawdzana));
	}
}
