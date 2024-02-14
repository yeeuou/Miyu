package Miyu.actions;

import Miyu.characters.TheDefault;
import Miyu.stances.OnCovered;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.stances.NeutralStance;

/*
* 엄폐할 때 이 액션을 호출합니다.
* true 이면 쓰레기통에 들어간 모습이 되고,
* false 이면 쓰레기통에서 나옵니다.
*/
public class TakingCoverAction extends AbstractGameAction {
	private final boolean isCovered;
	public TakingCoverAction(boolean isCovered) {
		this.isCovered = isCovered;
		if (isCovered) {
			System.out.println(getClass().getName() + ":: into cover");
		} else {
			System.out.println(getClass().getName() + ":: exit cover");
		}
	}
	@Override
	public void update() {
		if (!(AbstractDungeon.player instanceof TheDefault))
			return;

		if (isCovered)
			AbstractDungeon.player.stance = new OnCovered();
		else
			AbstractDungeon.player.stance = new NeutralStance();

		((TheDefault) AbstractDungeon.player).updateState(AbstractDungeon.player.stance.ID);
		this.isDone = true;
	}
}
