package model.abilities;

public class HealingAbility extends Ability{
	private int healAmount;
	public HealingAbility(String name,int manaCost, int baseCooldown, int castRange, AreaOfEffect castArea ,
			int requiredActionPoints,int healAmount) {
		super(name,manaCost,baseCooldown,castRange,castArea,requiredActionPoints);
		this.healAmount=healAmount;
    }
	public int getHealAmount() {
		return healAmount;
	}
	public void setHealAmount(int healAmount) {
		this.healAmount = healAmount;
	}
	
}
