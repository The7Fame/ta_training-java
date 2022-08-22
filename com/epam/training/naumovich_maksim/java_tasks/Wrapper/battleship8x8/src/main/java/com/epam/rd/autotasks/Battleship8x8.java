package com.epam.rd.autotasks;

import java.math.BigInteger;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {

        this.ships = ships;
    }

    public boolean shoot(String shot) {
        String binaryShots = String.format("%64s", Long.toBinaryString(shots)).replaceAll(" ", "0");
        String binaryShips = String.format("%64s", Long.toBinaryString(ships)).replaceAll(" ", "0");
        int column = (int) shot.charAt(0) - 65;
        shot = shot.substring(1, 2);
        int row = Integer.parseInt(shot);
        row--;

        char[] tmp = binaryShots.toCharArray();
        tmp[row * 8 + column] = '1';
        binaryShots = new String(tmp);

        shots = new BigInteger(binaryShots, 2).longValue();

        return binaryShips.charAt(row * 8 + column) == '1';
    }

    public String state() {
        String map = "";
        String binaryShips = String.format("%64s", Long.toBinaryString(ships)).replaceAll(" ", "0");
        String binaryShots = String.format("%64s", Long.toBinaryString(shots)).replaceAll(" ", "0");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char shipsCell = binaryShips.charAt(i * 8 + j);
                char shotsCell = binaryShots.charAt(i * 8 + j);
                if (shipsCell == '1' && shotsCell == '1') {
                    map += "☒";
                } else if (shipsCell == '1' && shotsCell == '0') {
                    map += "☐";
                } else if (shipsCell == '0' && shotsCell == '1') {
                    map += "×";
                } else {
                    map += ".";
                }
            }
            map += "\n";
        }
        return map;
    }
}
