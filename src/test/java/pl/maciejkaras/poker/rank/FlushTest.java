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

class FlushTest {
    private Flush flush;

    @BeforeEach
    void setUp() {
        flush = new Flush();
    }

    @Test
    void shouldValidateWithPositive() {
        Set<Card> flushCards = flushCards();

        Optional<PokerHand> pokerHand = flush.identify(flushCards);

        assertThat(pokerHand).hasValue(PokerHand.FLUSH);
    }

    @Test
    void shouldValidateWithNegative() {
        Set<Card> otherDeckOfCards = otherDeckOfCards();

        Optional<PokerHand> pokerHand = flush.identify(otherDeckOfCards);

        assertThat(pokerHand).isEmpty();
    }

    private Set<Card> flushCards() {
        Set<Card> flushCards = new HashSet<>();
        flushCards.add(new Card(KING, Colour.HEART));
        flushCards.add(new Card(TWO, Colour.HEART));
        flushCards.add(new Card(SIX, Colour.HEART));
        flushCards.add(new Card(EIGHT, Colour.HEART));
        flushCards.add(new Card(QUEEN, Colour.HEART));
        return flushCards;
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