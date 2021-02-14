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

class RoyalFlushTest {

    private RoyalFlush royalFlush;

    @BeforeEach
    void setUp() {
        royalFlush = new RoyalFlush();
    }

    @Test
    void shouldValidateWithPositive() {
        Set<Card> royalFlushCards = royalFlushCard();

        Optional<PokerHand> pokerHand = royalFlush.identify(royalFlushCards);

        assertThat(pokerHand).hasValue(PokerHand.ROYAL_FLUSH);
    }

    @Test
    void shouldValidateWithNegative() {
        Set<Card> otherDeckOfCards = otherDeckOfCards();

        Optional<PokerHand> pokerHand = royalFlush.identify(otherDeckOfCards);

        assertThat(pokerHand).isEmpty();
    }

    private Set<Card> royalFlushCard() {
        Set<Card> royalFlushCards = new HashSet<>();
        royalFlushCards.add(new Card(ACE, Colour.HEART));
        royalFlushCards.add(new Card(KING, Colour.HEART));
        royalFlushCards.add(new Card(QUEEN, Colour.HEART));
        royalFlushCards.add(new Card(JACK, Colour.HEART));
        royalFlushCards.add(new Card(TEN, Colour.HEART));
        return royalFlushCards;
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