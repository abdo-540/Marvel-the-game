package model.abilities;

public class Ability {
	String name;
	private int manaCost;
	private int baseCooldown;
	private int currentCooldown;
	private int castRange;
	private int requiredActionPoints;
	AreaOfEffect castArea;
	public Ability(String name,int cost, int baseCoolDown, int castRange, AreaOfEffect area ,
			int required) {
		this.name=name;
		this.manaCost=cost;
		this.baseCooldown=baseCoolDown;
		this.castRange=castRange;
		this.castArea=area;
		this.requiredActionPoints=required;
	}
	public String getName() {
		return name;
	}
	public int getManaCost() {
		return manaCost;
	}
	public int getBaseCooldown() {
		return baseCooldown;
	}
	public int getCurrentCooldown() {
		return currentCooldown;
	}
	public void setCurrentCooldown(int currentCooldown) {
		this.currentCooldown = currentCooldown;
	}
	public int getCastRange() {
		return castRange;
	}
	public int getRequiredActionPoints() {
		return requiredActionPoints;
	}
	public AreaOfEffect getCastArea() {
		return castArea;
	}
	
	
}
