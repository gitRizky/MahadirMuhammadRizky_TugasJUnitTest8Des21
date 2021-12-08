package com.bootcamp.test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.bootcamp.rumus.Kecepatan;

public class KecepatanTestCode {
	Kecepatan formula;
	String skenario;

	@Before
	public void setUp() throws Exception {
		this.formula = new Kecepatan();
		// lokasi skenario test
		this.skenario = "C:\\Users\\Lenovo\\eclipse-workspace\\MahadirMuhammadRizky_TugasJUnitTest8Des21\\src\\com\\bootcamp\\test\\skenario.csv";
	}

	@Test
	public void testKecepatan() {
		// Input Jarak dan Waktu pada table
		for (String isi : readFile(skenario)) {
			String[] temp = isi.split(",");
			assertEquals(Double.parseDouble(temp[2]), formula.kecepatan(temp[0], temp[1]), 0.9);
		}
		// Masukan bukan angka
		assertEquals("error", formula.kecepatan("x", "y"), 0.9);
		// Masukan angka negatif
		for (String isi : readFile(skenario)) {
			String[] temp = isi.split(",");
			String jarak = "-" + temp[0];
			String waktu = "-" + temp[1];
			assertEquals(Double.parseDouble(temp[2]), formula.kecepatan(jarak, waktu), 0.9);
		}
		// Tidak dimasukan angka
		assertEquals(0, formula.kecepatan("", ""), 0.9);
	}

	public List<String> readFile(String nameFile) {
		List<String> temp = new ArrayList<String>();
		try {
			File myFile = new File(nameFile);
			Scanner scan = new Scanner(myFile);
			while (scan.hasNextLine()) {
				temp.add(scan.nextLine());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}

}
