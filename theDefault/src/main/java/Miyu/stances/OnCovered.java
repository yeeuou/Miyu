package Miyu.stances;

import Miyu.DefaultMod;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.StanceStrings;
import com.megacrit.cardcrawl.stances.AbstractStance;

public class OnCovered extends AbstractStance {
	private static final String STANCE_ID = DefaultMod.makeID(OnCovered.class.getSimpleName());
	private static final StanceStrings stanceString = CardCrawlGame.languagePack.getStanceString(STANCE_ID);

	public OnCovered() {
		this.ID = STANCE_ID;
		this.name = stanceString.NAME;
		this.updateDescription();
	}

	@Override
	public void updateDescription() {
		this.description = stanceString.DESCRIPTION[0];
	}
}
