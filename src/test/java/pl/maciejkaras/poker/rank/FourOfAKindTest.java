package pl.maciejkaras.poker.rank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.maciejkaras.poker.model.Card;
import pl.maciejkaras.poker.model.Colour;
import pl.maciejkaras.poker.model.PokerHand;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.maciejkaras.poker.model.Figure.*;

class FourOfAKindTest {

    private FourOfAKind fourOfAKind;

    @BeforeEach
    void setUp() {
        fourOfAKind = new FourOfAKind();
    }

    @Test
    void shouldValidateWithPositive() {
        Set<Card> fourOfAKindCards = fourOfAKindCards();

        Optional<PokerHand> pokerHand = fourOfAKind.identify(fourOfAKindCards);

        assertThat(pokerHand).hasValue(PokerHand.FOUR_OF_A_KIND);
    }

    @Test
    void shouldValidateWithNegative() {
        Set<Card> otherDeckOfCards = otherDeckOfCards();

        Optional<PokerHand> pokerHand = fourOfAKind.identify(otherDeckOfCards);

        assertThat(pokerHand).isEmpty();
    }

    private Set<Card> fourOfAKindCards() {
        Set<Card> fourOfAKindCards = new HashSet<>();
        fourOfAKindCards.add(new Card(KING, Colour.HEART));
        fourOfAKindCards.add(new Card(KING, Colour.DIAMOND));
        fourOfAKindCards.add(new Card(KING, Colour.SPADE));
        fourOfAKindCards.add(new Card(KING, Colour.CLUB));
        fourOfAKindCards.add(new Card(NINE, Colour.HEART));
        return fourOfAKindCards;
    }

    private Set<Card> otherDeckOfCards() {
        Set<Card> otherDeckOfCards = new HashSet<>();
        otherDeckOfCards.add(new Card(ACE, Colour.HEART));
        otherDeckOfCards.add(new Card(KING, Colour.SPADE));
        otherDeckOfCards.add(new Card(QUEEN, Colour.HEART));
        otherDeckOfCards.add(new Card(JACK, Colour.HEART));
        otherDeckOfCards.add(new Card(TEN, Colour.HEART));
        return otherDeckOfCards;
    }
}