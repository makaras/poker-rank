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
import static pl.maciejkaras.poker.model.PokerHand.STRAIGHT_FLUSH;

class StraightFlushTest {

    private StraightFlush straightFlush;

    @BeforeEach
    void setUp() {
        straightFlush = new StraightFlush();
    }

    @Test
    void shouldValidateWithPositive() {
        Set<Card> straightFlushCards = straightFlushCard();

        Optional<PokerHand> pokerHand = straightFlush.identify(straightFlushCards);

        assertThat(pokerHand).hasValue(STRAIGHT_FLUSH);
    }

    @Test
    void shouldValidateWithNegative() {
        Set<Card> straightFlushCards = otherDeckOfCards();

        Optional<PokerHand> pokerHand = straightFlush.identify(straightFlushCards);

        assertThat(pokerHand).isEmpty();
    }

    private Set<Card> straightFlushCard() {
        Set<Card> straightFlushCard = new HashSet<>();
        straightFlushCard.add(new Card(KING, Colour.HEART));
        straightFlushCard.add(new Card(QUEEN, Colour.HEART));
        straightFlushCard.add(new Card(JACK, Colour.HEART));
        straightFlushCard.add(new Card(TEN, Colour.HEART));
        straightFlushCard.add(new Card(NINE, Colour.HEART));
        return straightFlushCard;
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