/*
 * 5. 메인(GameMain)

- 메인메소드가 존재하며 여기서 프로그램이 실행됩니다.

- 플레이어의 이름을 정할 수 있습니다.

- 주사위는 5번 던지는것으로 하겠습니다.

 

 

 

요구사항

1) 클래스이름은 위 설명에서 괄호안의 이름을 사용하면 됩니다.

2) 패키지를 꼭 구분하여 작성해 주세요.

3) 배열은 사용하지 않습니다. 컬렉션 프레임워크(List 또는 Map)를 사용해주세요.

4) 어떤메소드든 10줄이상 넘어가지 않도록 작성해주세요.
 */
package diceGame;

public class GameMain {
	
	//게임에 필요한 심판은 하나만 있으면 된다.
	static Judge judge;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		judge = new Judge();
		if(judge != null)
		{
		 judge.gameStart();	
		}
		else {
		 System.out.println("Fail to Start");
		}
	}
	//사용자가 집어넣은 이름으로 플레이어들을 생성한다.

}
