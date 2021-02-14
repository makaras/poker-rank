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
import static pl.maciejkaras.poker.model.PokerHand.STRAIGHT;

class StraightTest {

    private Straight straight;

    @BeforeEach
    void setUp() {
        straight = new Straight();
    }

    @Test
    void shouldValidateWithPositive() {
        Set<Card> straightCards = straightCards();

        Optional<PokerHand> pokerHand = straight.identify(straightCards);

        assertThat(pokerHand).hasValue(STRAIGHT);
    }

    @Test
    void shouldValidateWithNegative() {
        Set<Card> otherDeckOfCards = otherDeckOfCards();

        Optional<PokerHand> pokerHand = straight.identify(otherDeckOfCards);

        assertThat(pokerHand).isEmpty();
    }

    private Set<Card> straightCards() {
        Set<Card> straightCards = new HashSet<>();
        straightCards.add(new Card(EIGHT, Colour.HEART));
        straightCards.add(new Card(SEVEN, Colour.CLUB));
        straightCards.add(new Card(SIX, Colour.DIAMOND));
        straightCards.add(new Card(FIVE, Colour.SPADE));
        straightCards.add(new Card(FOUR, Colour.HEART));
        return straightCards;
    }

    private Set<Card> otherDeckOfCards() {
        Set<Card> otherDeckOfCards = new HashSet<>();
        otherDeckOfCards.add(new Card(ACE, Colour.HEART));
        otherDeckOfCards.add(new Card(ACE, Colour.HEART));
        otherDeckOfCards.add(new Card(SIX, Colour.HEART));
        otherDeckOfCards.add(new Card(FOUR, Colour.SPADE));
        otherDeckOfCards.add(new Card(TWO, Colour.DIAMOND));
        return otherDeckOfCards;
    }
}