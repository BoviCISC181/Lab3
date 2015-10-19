package pokerBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import pokerEnums.eCardNo;
import pokerEnums.eHandStrength;
import pokerEnums.eRank;
import pokerEnums.eSuit;

public class Wild_Test {

	@Test
	public void FourOfAKind_1() {

		ArrayList<Card> Wilds = new ArrayList<Card>();

		Wilds.add(new Card(eSuit.CLUBS, eRank.TWO, true));
		Wilds.add(new Card(eSuit.SPADES, eRank.TWO, true));
		Wilds.add(new Card(eSuit.HEARTS, eRank.TWO, true));
		Wilds.add(new Card(eSuit.DIAMONDS, eRank.TWO, true));

		int NbrOfJokers = 0;
		
		Deck d = new Deck(NbrOfJokers,Wilds);
		Hand h = new Hand();
		
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, true));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h = Hand.EvalHand(h);


		System.out.println(h.getHandStrength());
		
		assertTrue(h.getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 1);

		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());

		// Check to see if the kicker is a NINE
		assertTrue(c1.getRank().getRank() == eRank.NINE.getRank());

	}

	@Test
	public void FourOfAKind_2() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h = Hand.EvalHand(h);
		;

		assertTrue(h.getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 1);
	}
	
	@Test
	public void FullHouse() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h = Hand.EvalHand(h);
		;

		assertTrue(h.getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == eRank.KING.getRank());
		assertTrue(h.getKicker() == null);
	}
	
	@Test
	public void FullHouse_2() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, true));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h = Hand.EvalHand(h);
		;

		assertTrue(h.getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.KING.getRank());
		assertTrue(h.getLowPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getKicker() == null);
	}
	
	@Test
	public void FiveOfAKind() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, 0));
		h = Hand.EvalHand(h);
		;

		assertTrue(h.getHandStrength() == eHandStrength.FiveOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}
	
	@Test
	public void FiveOfAKind_2() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, true));
		h = Hand.EvalHand(h);
		;

		assertTrue(h.getHandStrength() == eHandStrength.FiveOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}

	@Test
	public void RoyalFlush() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TWO, true));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.QUEEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.ACE, 0));
		h = Hand.EvalHand(h);
		;

		assertTrue(h.getHandStrength() == eHandStrength.RoyalFlush.getHandStrength());
		assertTrue(h.getHighPairStrength() == 0);
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}
	
	@Test
	public void StraightFlush() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.THREE, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.FOUR, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.FIVE, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, true));
		h = Hand.EvalHand(h);
		;

		assertTrue(h.getHandStrength() == eHandStrength.StraightFlush.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.ACE.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}
	
	@Test
	public void Flush() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.FOUR, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.KING, true));
		h = Hand.EvalHand(h);
		;

		assertTrue(h.getHandStrength() == eHandStrength.Flush.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.ACE.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}
	
	@Test
	public void Straight() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.THREE, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.FOUR, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.FIVE, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, true));
		h = Hand.EvalHand(h);
		;

		assertTrue(h.getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.ACE.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}
	
	@Test
	public void ThreeOfAKind() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.SIX, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, true));
		h = Hand.EvalHand(h);
		;

		assertTrue(h.getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TWO.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 2);
	
		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());

		// Check to see if the kicker is a JACK
		assertTrue(c1.getRank().getRank() == eRank.JACK.getRank());
		
	}
	
//Program will always prefer three of a kind over two pair
	
	//	@Test
//	public void TwoPair() {
//		Deck d = new Deck();
//		Hand h = new Hand();
//		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TWO, 0));
//		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TWO, 0));
//		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.SIX, 0));
//		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JACK, 0));
//		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, true));
//		h = Hand.EvalHand(h);
//		;
//
//		assertTrue(h.getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
//		assertTrue(h.getHighPairStrength() == eRank.JACK.getRank());
//		assertTrue(h.getLowPairStrength() == eRank.TWO.getRank());
//		assertTrue(h.getKicker().size() == 1);
//	
//		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
//
//		// Check to see if the kicker is a JACK
//		assertTrue(c1.getRank().getRank() == eRank.JACK.getRank());
//		
//	}	
	
	@Test
	public void Pair() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.SEVEN, 0 ));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.SIX, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, true));
		h = Hand.EvalHand(h);
		;

		assertTrue(h.getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.JACK.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 3);
	
		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());

		// Check to see if the kicker is a JACK
		assertTrue(c1.getRank().getRank() == eRank.SEVEN.getRank());
		
	}
	
//Program will always prefer at least a pair over a high card.
	
	//	@Test
//	public void HighCard() {
//		Deck d = new Deck();
//		Hand h = new Hand();
//		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TWO, 0));
//		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.THREE, 0));
//		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.SIX, 0));
//		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JACK, 0));
//		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, true));
//		h = Hand.EvalHand(h);
//		;
//
//		assertTrue(h.getHandStrength() == eHandStrength.HighCard.getHandStrength());
//		assertTrue(h.getHighPairStrength() == eRank.TWO.getRank());
//		assertTrue(h.getLowPairStrength() == 0);
//		assertTrue(h.getKicker().size() == 2);
//	
//		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
//
//		// Check to see if the kicker is a JACK
//		assertTrue(c1.getRank().getRank() == eRank.JACK.getRank());
//		
//	}
	
}
