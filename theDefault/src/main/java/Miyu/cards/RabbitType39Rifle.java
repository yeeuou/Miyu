package Miyu.cards;

import Miyu.DefaultMod;
import Miyu.actions.NextTargetAction;
import Miyu.characters.TheDefault;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import java.util.Iterator;

import static Miyu.DefaultMod.makeCardPath;

public class RabbitType39Rifle extends AbstractDynamicCard {

	public static final String ID = DefaultMod.makeID(RabbitType39Rifle.class.getSimpleName()); // USE THIS ONE FOR THE
																								// TEMPLATE;
	public static final String IMG = makeCardPath("RabbitType39Rifle.png");// "public static final String IMG =
																			// makeCardPath("PebbleMagic.png");
	// This does mean that you will need to have an image with the same NAME as the card in your image folder for it to
	// run correctly.
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	// /TEXT DECLARATION/

	// STAT DECLARATION

	private static final CardRarity RARITY = CardRarity.UNCOMMON; // Up to you, I like auto-complete on these
	private static final CardTarget TARGET = CardTarget.ENEMY; // since they don't change much.
	private static final CardType TYPE = CardType.ATTACK; //
	public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

	private static final int COST = -2;
	private static final int DAMAGE = 39;
	private static final int UPGRADE_PLUS_DAMAGE = 15;
	private static final int MAGIC = 0;

	// /STAT DECLARATION/

	public RabbitType39Rifle() {
		super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
		this.baseDamage = DAMAGE;
		this.baseMagicNumber = this.magicNumber = MAGIC;
		this.cardsToPreview = new CockedRifle();
	}

	public void triggerWhenDrawn() {
		this.baseMagicNumber++;
		this.magicNumber = this.baseMagicNumber;
		this.isMagicNumberModified = true;
		if (this.baseMagicNumber == 2) {
			this.baseMagicNumber = 0;
			if (this.upgraded) {
				AbstractCard c = new CockedRifle();
				c.upgrade();
				addToBot(new MakeTempCardInHandAction(c, 1));
			} else {
				addToBot(new MakeTempCardInHandAction(new CockedRifle(), 1));
			}
		}
	}
	//
	// public void triggerOnGlowCheck() {
	// boolean glow = true;
	// if (baseMagicNumber <= 1) {
	// glow = false;
	// }
	// if (glow) {
	// this.glowColor = AbstractCard.GOLD_BORDER_GLOW_COLOR.cpy();
	// } else {
	// this.glowColor = AbstractCard.BLUE_BORDER_GLOW_COLOR.cpy();
	// }
	// }
	public boolean canUse(AbstractPlayer p, AbstractMonster m) {
		return false;
	}

	@Override
	public void use(AbstractPlayer p, AbstractMonster m) {
	}

	public AbstractCard makeCopy() {
		return new RabbitType39Rifle();
	}

	// Upgraded stats.
	@Override
	public void upgrade() {
		if (!upgraded) {
			upgradeName();
			upgradeDamage(UPGRADE_PLUS_DAMAGE);
			this.cardsToPreview.upgrade();
			this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
			initializeDescription();
		}
	}
}
