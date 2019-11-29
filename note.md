## :musical_score: How To Make Java Rhythm Game

> <a href="https://www.youtube.com/playlist?list=PLRx0vPvlEmdDySO3wDqMYGKMVH4Qa4QhR" >자바(JAVA) 리듬게임 만들기 강좌</a>



#### 더블버퍼링

- 현재 프로그램의 전체 화면의 크기에 맞는 이미지를 매순간마다 생성하여 원하는 컴포넌트만 출력하는 방식

  ```java
  public class DynamicBeat extends JFrame {
  
  	private Image screenImage;
  	private Graphics screenGraphic;
  	
  	private Image introBackground;
  	
  	public DynamicBeat() {
  		...
  	}
  	
  	public void paint(Graphics g) {
  		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
  		screenGraphic = screenImage.getGraphics();
  		screenDraw(screenGraphic);
  		g.drawImage(screenImage, 0, 0, null);
  	}
  	
  	public void screenDraw(Graphics g) {
  		g.drawImage(introBackground, 0, 0, null);
  		this.repaint();
  	}
  	
  }
  
  ```

  