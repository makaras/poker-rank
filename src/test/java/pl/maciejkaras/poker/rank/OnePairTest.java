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
import static pl.maciejkaras.poker.model.PokerHand.ONE_PAIR;

class OnePairTest {
    private OnePair onePair;

    @BeforeEach
    void setUp() {
        onePair = new OnePair();
    }

    @Test
    void shouldValidateWithPositive() {
        Set<Card> onePairCards = onePairCards();

        Optional<PokerHand> pokerHand = onePair.identify(onePairCards);

        assertThat(pokerHand).hasValue(ONE_PAIR);
    }

    @Test
    void shouldValidateWithNegative() {
        Set<Card> otherDeckOfCards = otherDeckOfCards();

        Optional<PokerHand> pokerHand = onePair.identify(otherDeckOfCards);

        assertThat(pokerHand).isEmpty();
    }

    private Set<Card> onePairCards() {
        Set<Card> onePairCards = new HashSet<>();
        onePairCards.add(new Card(KING, Colour.HEART));
        onePairCards.add(new Card(KING, Colour.SPADE));
        onePairCards.add(new Card(NINE, Colour.DIAMOND));
        onePairCards.add(new Card(EIGHT, Colour.SPADE));
        onePairCards.add(new Card(FOUR, Colour.HEART));
        return onePairCards;
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