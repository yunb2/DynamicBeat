package dynamic_beat_1;

import javax.swing.JFrame;

public class DynamicBeat extends JFrame {

	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); 
		setLocationRelativeTo(null); // 창이 정중앙에 뜨게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 껐을 때 게임이 종료되도록
		setVisible(true);
	}
	
}
