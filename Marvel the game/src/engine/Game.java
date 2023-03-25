package engine;

import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import model.abilities.*;
import model.world.Cover;
import model.world.Champion;

public class Game {
	private Player firstPlayer;
	private Player secondPlayer;
	private boolean firstLeaderAbilityUsed;
	private boolean secondLeaderAbilityUsed;
	private Object[][] board;
	private static ArrayList<Champion> availableChampions;
	private static ArrayList<Ability> availableAbilities;
	private PriorityQueue turnOrder;
	private static final int BOARDHEIGHT = 500;
	private static final int BOARDWIDTH = 500;
	private Random ran;
	
	public Game(Player first, Player second) {
		firstPlayer = first;
		secondPlayer = second;
		board = new Object[5][5];
		ran = new Random();
		placeChampions();
		placeCovers();
	}
	
	//get and sets
	
	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public Player getSecondPlayer() {
		return secondPlayer;
	}

	public boolean isFirstLeaderAbilityUsed() {
		return firstLeaderAbilityUsed;
	}

	public boolean isSecondLeaderAbilityUsed() {
		return secondLeaderAbilityUsed;
	}

	public Object[][] getBoard() {
		return board;
	}

	public static ArrayList<Champion> getAvailableChampions() {
		return availableChampions;
	}

	public static ArrayList<Ability> getAvailableAbilities() {
		return availableAbilities;
	}

	public PriorityQueue getTurnOrder() {
		return turnOrder;
	}

	public static int getBOARDHEIGHT() {
		return BOARDHEIGHT;
	}

	public static int getBOARDWIDTH() {
		return BOARDWIDTH;
	}
	
	//other
	
	
	private void placeChampions() {
		board [1] [0] = firstPlayer.getTeam().get(0);
		board [2] [0] = firstPlayer.getTeam().get(1);
		board [3] [0] = firstPlayer.getTeam().get(2);
		board [1] [4] = secondPlayer.getTeam().get(0);
		board [2] [4] = secondPlayer.getTeam().get(1);
		board [3] [4] = secondPlayer.getTeam().get(2);
	}
	
	private void placeCovers() {
		int i = 0;
		while(i < 5) {
			int x = ran.nextInt(5);
			int y = ran.nextInt(5);
			if(x != 0 && y != 0 && x != 4 && y != 4) {
				board [x] [y] = new Cover(x, y);
				i++;
			}
			
		}
	}
	
	public static void loadAbilities(String filePath) throws Exception{
		BufferedReader br= new BufferedReader(new FileReader("Abilities.csv"));
		String [] x = br.readLine().split(",");
		AreaOfEffect area = null;
		
		for(int i = 0;i < 45;i++) {
			area = (x[5].equals("SELFTARGET"))? AreaOfEffect.SELFTARGET: (x[5].equals("DIRECTIONAL"))? AreaOfEffect.DIRECTIONAL: (x[5].equals("SINGLETARGET")? AreaOfEffect.SINGLETARGET:(x[5].equals("TEAMTARGET")? AreaOfEffect.TEAMTARGET:AreaOfEffect.SURROUND));
			availableAbilities.add(new Ability(x[1], Integer.parseInt(x[2]), Integer.parseInt(x[3]),Integer.parseInt(x[4]), area, Integer.parseInt(x[6])));
		}
		br.close();
	}
	
	public static void loadChampions(String filePath) throws Exception{
		BufferedReader br= new BufferedReader(new FileReader("Champions.csv"));
		String [] x = br.readLine().split(",");
		
		for(int i = 0;i < 15;i++) {
			availableChampions.add(new Champion(x[1], Integer.parseInt(x[2]), Integer.parseInt(x[3]), Integer.parseInt(x[4]), Integer.parseInt(x[5]), Integer.parseInt(x[6]), Integer.parseInt(x[7])));
		}
		br.close();
	}
}
