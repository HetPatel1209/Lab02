/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Het
 */
public class IndyWinner {
    private final int year;
    private final String winnerName;
    private final String carName;

    public IndyWinner(int year, String winnerName, String carName) {
        this.year = year;
        this.winnerName = winnerName;
        this.carName = carName;
    }

    public int getYear() {
        return year;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public String getCarName() {
        return carName;
    }
}
