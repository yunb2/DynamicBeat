package dynamic_beat_16;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {

	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private int x, y = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME;
	private String noteType;
	private boolean proceeded = true;
	
	public String getNoteType() {
		return noteType;
	}
	
	public boolean isProceeded() {
		return proceeded;
	}
	
	public void close() {
		proceeded = false;
	}
	
	public Note(String noteType) {
		switch(noteType) {
		case "S": x = 228; break;
		case "D": x = 332; break;
		case "F": x = 436; break;
		case "Space": x = 540; break;
		case "J": x = 744; break;
		case "K": x = 848; break;
		case "L": x = 952; break;
		}
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics2D g) {
		if(noteType.equals("Space")) {
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x+100, y, null);
		}else {
			g.drawImage(noteBasicImage, x, y, null);
		}
	}
	
	public void drop() {
		y += Main.NOTE_SPEED;
		if(y > 620) {
			System.out.println("MISS");
			close();
		}
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				drop();
				if(proceeded) {
					Thread.sleep(Main.SLEEP_TIME);
				}else {
					interrupt();
					break;
				}
				Thread.sleep(Main.SLEEP_TIME);
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public String judge() {
		if(y>=613) {
			System.out.println("Late");
			close();
			return "Late";
		}else if(y>=600) {
			System.out.println("Good");
			close();
			return "Good";
		}else if(y>=587) {
			System.out.println("Greate");
			close();
			return "Greate";
		}else if(y>=573) {
			System.out.println("Perfect");
			close();
			return "Perfect";
		}else if(y>=565) {
			System.out.println("Greate");
			close();
			return "Greate";
		}else if(y>=550) {
			System.out.println("Good");
			close();
			return "Good";
		}else if(y>=535) {
			System.out.println("Early");
			close();
			return "Early";
		}
		
		return "None";
		
	}
	
	public int getY() {
		return y;
	}
	
}
