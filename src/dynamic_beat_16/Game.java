package dynamic_beat_16;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {

	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image blueFlareImage;
	
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	
	ArrayList<Note> noteList = new ArrayList<>();
	
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		
		for(int i=0; i<noteList.size(); ++i) {
			Note note = noteList.get(i);
			if(note.getY()>620) blueFlareImage = null;
			if(!note.isProceeded()) {
				noteList.remove(i);
				--i;
				break;
			}
			note.screenDraw(g);
		}
		
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);
		
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString("000000", 565, 702);
		g.drawImage(blueFlareImage, 160, 250, null);
	}
	
	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumBig1.mp3", false).start();
	}
	
	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	@Override
	public void run() {
		dropNotes(this.titleName);
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt(); // thread Á¾·á
	}
	
	public void dropNotes(String titleName) {
		Beat[] beats = null;
		int startTime = 0;
		int gap = 0;
		switch(titleName) {
		case "Joakim Karud - Mighty Love":
			if(difficulty.equals("Easy")) {
				startTime = 4460 - Main.REACH_TIME * 1000;
				gap = 125;
				beats = new Beat[] {
						new Beat(startTime+gap*1, "S"),
						new Beat(startTime+gap*3, "D"),
						new Beat(startTime+gap*5, "S"),
						new Beat(startTime+gap*7, "D"),
						new Beat(startTime+gap*9, "S"),
						new Beat(startTime+gap*11, "D"),
						new Beat(startTime+gap*13, "S"),
						new Beat(startTime+gap*15, "D"),
						new Beat(startTime+gap*18, "J"),
						new Beat(startTime+gap*20, "K"),
						new Beat(startTime+gap*22, "J"),
						new Beat(startTime+gap*24, "K"),
						new Beat(startTime+gap*26, "J"),
						new Beat(startTime+gap*28, "K"),
						new Beat(startTime+gap*30, "J"),
						new Beat(startTime+gap*32, "K"),
						new Beat(startTime+gap*35, "S"),
						new Beat(startTime+gap*37, "D"),
						new Beat(startTime+gap*39, "S"),
						new Beat(startTime+gap*41, "D"),
						new Beat(startTime+gap*43, "S"),
						new Beat(startTime+gap*45, "D"),
						new Beat(startTime+gap*48, "J"),
						new Beat(startTime+gap*49, "K"),
						new Beat(startTime+gap*50, "L"),
						new Beat(startTime+gap*52, "F"),
						new Beat(startTime+gap*52, "Space"),
						new Beat(startTime+gap*52, "J"),
						new Beat(startTime+gap*54, "S"),
						new Beat(startTime+gap*56, "D"),
						new Beat(startTime+gap*59, "F"),
						new Beat(startTime+gap*59, "Space"),
						new Beat(startTime+gap*59, "J"),
						new Beat(startTime+gap*61, "L"),
						new Beat(startTime+gap*63, "K"),
						new Beat(startTime+gap*65, "F"),
						new Beat(startTime+gap*65, "Space"),
						new Beat(startTime+gap*65, "J"),
						new Beat(startTime+gap*70, "S"),
						new Beat(startTime+gap*72, "S"),
						new Beat(startTime+gap*74, "S"),
						new Beat(startTime+gap*78, "J"),
						new Beat(startTime+gap*79, "K"),
						new Beat(startTime+gap*80, "L"),
						new Beat(startTime+gap*83, "Space"),
						new Beat(startTime+gap*85, "S"),
						new Beat(startTime+gap*87, "D"),
						new Beat(startTime+gap*89, "S"),
						new Beat(startTime+gap*91, "D"),
						new Beat(startTime+gap*93, "F"),
						new Beat(startTime+gap*96, "Space"),
						new Beat(startTime+gap*98, "L"),
						new Beat(startTime+gap*100, "Space"),
						new Beat(startTime+gap*102, "S"),
						new Beat(startTime+gap*104, "D"),
						new Beat(startTime+gap*106, "Space"),
						new Beat(startTime+gap*109, "Space"),
						new Beat(startTime+gap*112, "Space"),
						new Beat(startTime+gap*118, "S"),
						new Beat(startTime+gap*119, "D"),
						new Beat(startTime+gap*120, "F"),
						new Beat(startTime+gap*123, "S"),
						new Beat(startTime+gap*124, "D"),
						new Beat(startTime+gap*125, "F"),
						new Beat(startTime+gap*126, "J"),
						new Beat(startTime+gap*127, "K"),
						new Beat(startTime+gap*130, "J"),
						new Beat(startTime+gap*133, "K"),
						new Beat(startTime+gap*136, "L"),
						new Beat(startTime+gap*138, "S"),
						new Beat(startTime+gap*140, "Space"),
						new Beat(startTime+gap*142, "S"),
						new Beat(startTime+gap*144, "Space"),
						new Beat(startTime+gap*146, "Space"),
						new Beat(startTime+gap*150, "Space"),
						new Beat(startTime+gap*152, "Space"),
						new Beat(startTime+gap*157, "J"),
						new Beat(startTime+gap*161, "K"),
						new Beat(startTime+gap*165, "L"),
						new Beat(startTime+gap*167, "S"),
						new Beat(startTime+gap*169, "D"),
						new Beat(startTime+gap*171, "F"),
						new Beat(startTime+gap*174, "S"),
						new Beat(startTime+gap*176, "D"),
						new Beat(startTime+gap*178, "F"),
						new Beat(startTime+gap*180, "Space"),
						new Beat(startTime+gap*181, "L"),
						new Beat(startTime+gap*184, "Space"),
						new Beat(startTime+gap*187, "L"),
						new Beat(startTime+gap*188, "K"),
						new Beat(startTime+gap*189, "J"),
						new Beat(startTime+gap*192, "S"),
						new Beat(startTime+gap*192, "Space"),
						new Beat(startTime+gap*196, "D"),
						new Beat(startTime+gap*196, "Space"),
						new Beat(startTime+gap*200, "S"),
						new Beat(startTime+gap*200, "Space"),
						new Beat(startTime+gap*207, "J"),
						new Beat(startTime+gap*207, "Space"),
						new Beat(startTime+gap*211, "K"),
						new Beat(startTime+gap*211, "Space"),
						new Beat(startTime+gap*216, "L"),
						new Beat(startTime+gap*216, "Space"),
						new Beat(startTime+gap*218, "Space"),
						new Beat(startTime+gap*221, "J"),
						new Beat(startTime+gap*223, "K"),
						new Beat(startTime+gap*225, "L"),
						new Beat(startTime+gap*227, "S"),
						new Beat(startTime+gap*227, "Space"),
						new Beat(startTime+gap*231, "D"),
						new Beat(startTime+gap*231, "Space"),
						new Beat(startTime+gap*235, "S"),
						new Beat(startTime+gap*235, "Space"),
						new Beat(startTime+gap*242, "S"),
						new Beat(startTime+gap*242, "Space"),
						new Beat(startTime+gap*242, "L"),
						new Beat(startTime+gap*246, "D"),
						new Beat(startTime+gap*246, "Space"),
						new Beat(startTime+gap*246, "K"),
						new Beat(startTime+gap*250, "F"),
						new Beat(startTime+gap*250, "Space"),
						new Beat(startTime+gap*250, "J"),
						new Beat(startTime+gap*255, "J"),
						new Beat(startTime+gap*257, "K"),
						new Beat(startTime+gap*259, "K"),
						new Beat(startTime+gap*262, "S"),
						new Beat(startTime+gap*262, "Space"),
						new Beat(startTime+gap*266, "D"),
						new Beat(startTime+gap*266, "Space"),
						new Beat(startTime+gap*270, "S"),
						new Beat(startTime+gap*270, "Space"),
						new Beat(startTime+gap*275, "J"),
						new Beat(startTime+gap*277, "K"),
						new Beat(startTime+gap*279, "L"),
						new Beat(startTime+gap*282, "J"),
						new Beat(startTime+gap*284, "K"),
						new Beat(startTime+gap*286, "L"),
						new Beat(startTime+gap*289, "J"),
						new Beat(startTime+gap*291, "K"),
						new Beat(startTime+gap*293, "L"),
						new Beat(startTime+gap*295, "J"),
						new Beat(startTime+gap*297, "F"),
						new Beat(startTime+gap*299, "D"),
						new Beat(startTime+gap*301, "S"),
						new Beat(startTime+gap*304, "F"),
						new Beat(startTime+gap*306, "D"),
						new Beat(startTime+gap*308, "S"),
						new Beat(startTime+gap*310, "F"),
						new Beat(startTime+gap*312, "D"),
						new Beat(startTime+gap*314, "S"),
						new Beat(startTime+gap*317, "F"),
						new Beat(startTime+gap*319, "D"),
						new Beat(startTime+gap*321, "S"),
						new Beat(startTime+gap*323, "F"),
						new Beat(startTime+gap*325, "D"),
						new Beat(startTime+gap*327, "S"),
						new Beat(startTime+gap*330, "F"),
						new Beat(startTime+gap*332, "S"),
						new Beat(startTime+gap*332, "Space"),
						new Beat(startTime+gap*336, "D"),
						new Beat(startTime+gap*336, "Space"),
						new Beat(startTime+gap*340, "S"),
						new Beat(startTime+gap*340, "Space")
				};
			}
			break;
		case "Joakim Karud - Wild Flower":
			startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space")
			};
			break;
		case "Bendsound - Energy":
			startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space")
			};
			break;
		}
		
		int i=0; 
		
		gameMusic.start();
		while(i<beats.length && !isInterrupted()) {
			boolean dropped = false;
			if(beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
			
	}
	
	public void judge(String input) {
		for(int i=0; i < noteList.size(); ++i) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}
	
	public void judgeEvent(String judge) {
		if(judge.equals("None")) return;
		blueFlareImage = new ImageIcon(Main.class.getResource("../images/blueFlare.png")).getImage();
	}
	
}
