/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Het
 */
import java.util.List;

public interface IndyWinnerDAO {
    List<IndyWinner> getWinners(int limit, int offset) throws Exception;
    int getWinnerCount() throws Exception;
}

