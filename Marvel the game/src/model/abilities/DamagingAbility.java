package model.abilities;

public class DamagingAbility extends Ability{
	private int damageAmount;
	public DamagingAbility(String name,int manaCost, int baseCooldown, int castRange, AreaOfEffect castArea ,
			int requiredActionPoints,int damageAmount) {
		super(name,manaCost,baseCooldown,castRange,castArea,requiredActionPoints);
		this.damageAmount=damageAmount;
	}
	public int getDamageAmount() {
		return damageAmount;
	}
	public void setDamageAmount(int damageAmount) {
		this.damageAmount = damageAmount;
	}
	
}
