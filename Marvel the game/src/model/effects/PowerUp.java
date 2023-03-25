package model.effects;

public class PowerUp extends Effect{
	
	public PowerUp(int duration) {
		super("Power up", duration, EffectType.BUFF);
	}
}
