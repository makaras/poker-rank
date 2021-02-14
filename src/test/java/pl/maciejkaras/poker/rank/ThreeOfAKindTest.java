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
import static pl.maciejkaras.poker.model.PokerHand.THREE_OF_A_KIND;

class ThreeOfAKindTest {
    private ThreeOfAKind threeOfAKind;

    @BeforeEach
    void setUp() {
        threeOfAKind = new ThreeOfAKind();
    }

    @Test
    void shouldValidateWithPositive() {
        Set<Card> threeOfAKindCards = threeOfAKindCards();

        Optional<PokerHand> pokerHand = threeOfAKind.identify(threeOfAKindCards);

        assertThat(pokerHand).hasValue(THREE_OF_A_KIND);
    }

    @Test
    void shouldValidateWithNegative() {
        Set<Card> otherDeckOfCards = otherDeckOfCards();

        Optional<PokerHand> pokerHand = threeOfAKind.identify(otherDeckOfCards);

        assertThat(pokerHand).isEmpty();
    }

    private Set<Card> threeOfAKindCards() {
        Set<Card> threeOfAKind = new HashSet<>();
        threeOfAKind.add(new Card(QUEEN, Colour.HEART));
        threeOfAKind.add(new Card(QUEEN, Colour.CLUB));
        threeOfAKind.add(new Card(QUEEN, Colour.SPADE));
        threeOfAKind.add(new Card(SEVEN, Colour.HEART));
        threeOfAKind.add(new Card(TWO, Colour.CLUB));
        return threeOfAKind;
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