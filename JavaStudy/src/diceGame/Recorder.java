package diceGame;

import java.util.HashMap;
import java.util.Vector;

/*
 * 4. 기록원(Recorder)

- 기록원은 게임의 진행상황과 결과를 기록하는 역할을 담당합니다.

- 기록은 System.out.println(); 으로 처리합니다.

- 두가지를 기록할 수 있습니다.

모든 플레이어의 스코어를 기록하며, 사기주사위를 쓰는 플레이어의 경우 주사위의 상태까지 보여줍니다.

ex) 

[ 최강훈:6[NORMAL] 김준하:6 ]

[ 최강훈:8[NORMAL] 김준하:10 ]

[ 최강훈:13[STRONG] 김준하:14 ]

[ 최강훈:16[STRONG] 김준하:17 ]

[ 최강훈:21[STRONG] 김준하:23 ]

승자를 기록합니다.

ex)

김준하가 승리했습니다!

 
 */

public class Recorder {

	//게임의 중간 과정을 기록한다.
	Vector<String> logs;

	
	Recorder()
	{
		logs = new Vector<String>();
	}
	
	void recordGame(Player player1, Player player2)
	{
	String log = "";
	log += "[" + player1.getName() + ":" + player1.getScore() + showDiceState(player1);
	log += player2.getName() + ":" + player2.getScore() + showDiceState(player2) + "]";
	System.out.println(log);
	logs.addElement(log);
	
	}
	
	//Player가 FraudPlayer인지 여부를 따져 맞으면 주사위의 세기(모드)를 받아온다.
	String showDiceState(Player player)
	{
		if(player.getClass() == FraudPlayer.class)
		{
			return "[" + ((FraudPlayer) player).getDiceMode().name() +"] ";
		}
		else
			return "";
	}
	
	
}
