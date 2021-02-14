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
import static pl.maciejkaras.poker.model.PokerHand.TWO_PAIR;

class TwoPairTest {
    private TwoPair twoPair;

    @BeforeEach
    void setUp() {
        twoPair = new TwoPair();
    }

    @Test
    void shouldValidateWithPositive() {
        Set<Card> twoPairCards = twoPairCards();

        Optional<PokerHand> pokerHand = twoPair.identify(twoPairCards);

        assertThat(pokerHand).hasValue(TWO_PAIR);
    }

    @Test
    void shouldValidateWithNegative() {
        Set<Card> otherDeckOfCards = otherDeckOfCards();

        Optional<PokerHand> pokerHand = twoPair.identify(otherDeckOfCards);

        assertThat(pokerHand).isEmpty();
    }

    private Set<Card> twoPairCards() {
        Set<Card> twoPairCards = new HashSet<>();
        twoPairCards.add(new Card(JACK, Colour.HEART));
        twoPairCards.add(new Card(JACK, Colour.SPADE));
        twoPairCards.add(new Card(NINE, Colour.SPADE));
        twoPairCards.add(new Card(NINE, Colour.DIAMOND));
        twoPairCards.add(new Card(FIVE, Colour.CLUB));
        return twoPairCards;
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