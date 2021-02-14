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
import static pl.maciejkaras.poker.model.PokerHand.FULL_HOUSE;

class FullHouseTest {
    private FullHouse fullHouse;

    @BeforeEach
    void setUp() {
        fullHouse = new FullHouse();
    }

    @Test
    void shouldValidateWithPositive() {
        Set<Card> fullHouseCards = fullHouseCards();

        Optional<PokerHand> pokerHand = fullHouse.identify(fullHouseCards);

        assertThat(pokerHand).hasValue(FULL_HOUSE);
    }

    @Test
    void shouldValidateWithNegative() {
        Set<Card> otherDeckOfCards = otherDeckOfCards();

        Optional<PokerHand> pokerHand = fullHouse.identify(otherDeckOfCards);

        assertThat(pokerHand).isEmpty();
    }

    private Set<Card> fullHouseCards() {
        Set<Card> fullHouseCards = new HashSet<>();
        fullHouseCards.add(new Card(KING, Colour.HEART));
        fullHouseCards.add(new Card(KING, Colour.DIAMOND));
        fullHouseCards.add(new Card(KING, Colour.SPADE));
        fullHouseCards.add(new Card(NINE, Colour.CLUB));
        fullHouseCards.add(new Card(NINE, Colour.HEART));
        return fullHouseCards;
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