package pl.maciejkaras.poker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.maciejkaras.poker.model.Card;
import pl.maciejkaras.poker.model.Colour;
import pl.maciejkaras.poker.model.PokerHand;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pl.maciejkaras.poker.model.Figure.*;
import static pl.maciejkaras.poker.model.PokerHand.*;

class PokerTest {
    private PokerService pokerService;

    @BeforeEach
    void setUp() {
        pokerService = new PokerService();
    }

    @ParameterizedTest
    @MethodSource("provideCards")
    void shouldResolveAllPokerHand(Set<Card> cards, PokerHand pokerHand) {
        PokerHand pokerHandResult = pokerService.identityHand(cards);

        assertThat(pokerHandResult).isEqualTo(pokerHand);
    }

    @Test
    void shouldThrowExceptionWhenCardsNotValid() {
        assertThrows(IllegalStateException.class, () -> pokerService.identityHand(otherCards()));
    }

    private static Stream<Arguments> provideCards() {
        return Stream.of(
                Arguments.of(royalFlush(), ROYAL_FLUSH),
                Arguments.of(straightFlush(), STRAIGHT_FLUSH),
                Arguments.of(fourOfAKind(), FOUR_OF_A_KIND),
                Arguments.of(fullHouse(), FULL_HOUSE),
                Arguments.of(flush(), FLUSH),
                Arguments.of(straight(), STRAIGHT),
                Arguments.of(threeOfAKind(), THREE_OF_A_KIND),
                Arguments.of(twoPair(), TWO_PAIR),
                Arguments.of(onePair(), ONE_PAIR),
                Arguments.of(highCard(), HIGH_CARD)
        );
    }

    private static Set<Card> royalFlush() {
        Set<Card> royalFlushCards = new HashSet<>();
        royalFlushCards.add(new Card(ACE, Colour.HEART));
        royalFlushCards.add(new Card(KING, Colour.HEART));
        royalFlushCards.add(new Card(QUEEN, Colour.HEART));
        royalFlushCards.add(new Card(JACK, Colour.HEART));
        royalFlushCards.add(new Card(TEN, Colour.HEART));
        return royalFlushCards;
    }

    private static Set<Card> straightFlush() {
        Set<Card> straightFlush = new HashSet<>();
        straightFlush.add(new Card(KING, Colour.HEART));
        straightFlush.add(new Card(QUEEN, Colour.HEART));
        straightFlush.add(new Card(JACK, Colour.HEART));
        straightFlush.add(new Card(TEN, Colour.HEART));
        straightFlush.add(new Card(NINE, Colour.HEART));
        return straightFlush;
    }

    private static Set<Card> fourOfAKind() {
        Set<Card> fourOfAKind = new HashSet<>();
        fourOfAKind.add(new Card(KING, Colour.HEART));
        fourOfAKind.add(new Card(KING, Colour.DIAMOND));
        fourOfAKind.add(new Card(KING, Colour.SPADE));
        fourOfAKind.add(new Card(KING, Colour.CLUB));
        fourOfAKind.add(new Card(NINE, Colour.HEART));
        return fourOfAKind;
    }

    private static Set<Card> fullHouse() {
        Set<Card> fullHouse = new HashSet<>();
        fullHouse.add(new Card(KING, Colour.HEART));
        fullHouse.add(new Card(KING, Colour.DIAMOND));
        fullHouse.add(new Card(KING, Colour.SPADE));
        fullHouse.add(new Card(NINE, Colour.CLUB));
        fullHouse.add(new Card(NINE, Colour.HEART));
        return fullHouse;
    }

    private static Set<Card> flush() {
        Set<Card> flush = new HashSet<>();
        flush.add(new Card(KING, Colour.HEART));
        flush.add(new Card(TWO, Colour.HEART));
        flush.add(new Card(SIX, Colour.HEART));
        flush.add(new Card(EIGHT, Colour.HEART));
        flush.add(new Card(QUEEN, Colour.HEART));
        return flush;
    }

    private static Set<Card> straight() {
        Set<Card> straight = new HashSet<>();
        straight.add(new Card(EIGHT, Colour.HEART));
        straight.add(new Card(SEVEN, Colour.CLUB));
        straight.add(new Card(SIX, Colour.DIAMOND));
        straight.add(new Card(FIVE, Colour.SPADE));
        straight.add(new Card(FOUR, Colour.HEART));
        return straight;
    }

    private static Set<Card> threeOfAKind() {
        Set<Card> threeOfAKind = new HashSet<>();
        threeOfAKind.add(new Card(QUEEN, Colour.HEART));
        threeOfAKind.add(new Card(QUEEN, Colour.CLUB));
        threeOfAKind.add(new Card(QUEEN, Colour.SPADE));
        threeOfAKind.add(new Card(SEVEN, Colour.HEART));
        threeOfAKind.add(new Card(TWO, Colour.CLUB));
        return threeOfAKind;
    }

    private static Set<Card> twoPair() {
        Set<Card> twoPair = new HashSet<>();
        twoPair.add(new Card(JACK, Colour.HEART));
        twoPair.add(new Card(JACK, Colour.SPADE));
        twoPair.add(new Card(NINE, Colour.SPADE));
        twoPair.add(new Card(NINE, Colour.DIAMOND));
        twoPair.add(new Card(FIVE, Colour.CLUB));
        return twoPair;
    }

    private static Set<Card> onePair() {
        Set<Card> onePair = new HashSet<>();
        onePair.add(new Card(KING, Colour.HEART));
        onePair.add(new Card(KING, Colour.SPADE));
        onePair.add(new Card(NINE, Colour.DIAMOND));
        onePair.add(new Card(EIGHT, Colour.SPADE));
        onePair.add(new Card(FOUR, Colour.HEART));
        return onePair;
    }

    private static Set<Card> highCard() {
        Set<Card> highCard = new HashSet<>();
        highCard.add(new Card(ACE, Colour.HEART));
        highCard.add(new Card(QUEEN, Colour.CLUB));
        highCard.add(new Card(SIX, Colour.HEART));
        highCard.add(new Card(FOUR, Colour.SPADE));
        highCard.add(new Card(TWO, Colour.DIAMOND));
        return highCard;
    }

    private static Set<Card> otherCards() {
        Set<Card> highCard = new HashSet<>();
        highCard.add(new Card(ACE, Colour.HEART));
        highCard.add(new Card(ACE, Colour.HEART));
        highCard.add(new Card(SIX, Colour.HEART));
        highCard.add(new Card(FOUR, Colour.SPADE));
        highCard.add(new Card(TWO, Colour.DIAMOND));
        return highCard;
    }
}