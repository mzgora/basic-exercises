import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class LiczbyPierwszeTest {
	Map<Integer, int[]> oczekiwane = new HashMap<>();

	@Before
	public void before() {
		oczekiwane.clear();
		oczekiwane.put(0, new int[] {});
		oczekiwane.put(1, new int[] {});
		oczekiwane.put(2, new int[] { 2 });
		oczekiwane.put(3, new int[] { 2, 3 });
		oczekiwane.put(4, new int[] { 2, 3 });
		oczekiwane.put(10, new int[] { 2, 3, 5, 7 });
		oczekiwane.put(100, new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73,
				79, 83, 89, 97 });
	}

	@Test
	public void powinien_stwierdzic_brak_liczb_pierwszy_mniejszych_rownych_0() {
		sprawdz(0);
	}

	@Test
	public void powinien_stwierdzic_brak_liczb_pierwszy_mniejszych_rownych_1() {
		sprawdz(1);
	}

	@Test
	public void powinien_wyznaczyc_2_jako_liczbe_pierwsza() {
		sprawdz(2);
	}

	@Test
	public void powinien_wyznaczyc_2_oraz_3_jako_liczbe_pierwsza() {
		sprawdz(3);
		sprawdz(4);
	}

	@Test
	public void powinien_wyznaczyc_4_liczby_pierwsza() {
		sprawdz(10);
	}

	@Test
	public void powinien_wyznaczyc_wszystkie_liczby_pierwsza_mniejsze_od_100() {
		sprawdz(100);
	}

	public void sprawdz(int maksimum) {
		int[] wynik = LiczbyPierwsze.liczbyPierwsze(maksimum);
		System.out.println("liczbyPierwsze(" + maksimum + ") = " + Arrays.toString(wynik) + "\n\t"
				+ sprawdz(wynik, oczekiwane.get(maksimum)));
		assertArrayEquals("liczbyPierwsze(" + maksimum + ") ", oczekiwane.get(maksimum), wynik);
	}

	private String sprawdz(int[] wynik, int[] oczekiwane) {
		Set<Integer> brak = new HashSet<>();
		Set<Integer> nadmiar = new HashSet<>();
		for (int i = 0; i < oczekiwane.length; i++) {
			if (Arrays.binarySearch(wynik, oczekiwane[i]) < 0) {
				brak.add(oczekiwane[i]);
			}
		}
		for (int i = 0; i < wynik.length; i++) {
			if (Arrays.binarySearch(oczekiwane, wynik[i]) < 0) {
				nadmiar.add(wynik[i]);
			}
		}
		return brak.isEmpty() && nadmiar.isEmpty() 
				? "OK"
				: "BLAD" 
					+ (brak.isEmpty() 
							? "" 
							: "\n\t brakuje liczb pierwszych:" + Arrays.toString(brak.toArray()))
					+ (nadmiar.isEmpty() 
							? ""
							: "\n\t to nie sa liczby pierwsze:" + Arrays.toString(nadmiar.toArray()));
	}
}
