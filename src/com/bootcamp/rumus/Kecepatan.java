package com.bootcamp.rumus;

public class Kecepatan {
	public double kecepatan(String jarak, String waktu) {
		if (jarak.isEmpty() || waktu.isEmpty()) {
			return 0;
		} else {
			return Double.parseDouble(jarak) / Double.parseDouble(waktu);
		}
	}
}
