package pl.maciejkaras.poker.rank.common;

import pl.maciejkaras.poker.model.Card;
import pl.maciejkaras.poker.model.Colour;
import pl.maciejkaras.poker.model.Figure;

import java.util.HashSet;
import java.util.Set;

public class PokerRankCommon {

    public static boolean isFlush(Set<Card> cards) {
        Set<Colour> colourSet = new HashSet<>();
        cards.stream()
                .map(Card::getColour)
                .forEach(colourSet::add);
        return colourSet.size() == 1;
    }

    public static boolean isStraight(Set<Card> cards) {
        int[] cardIndexArray = cardIndexArray(cards);
        int nextFigureNumber = 0;

        for (int i = 0; i < cardIndexArray.length - 1; i++) {
            if (cardIndexArray[i] == 1 && cardIndexArray[i + 1] == 1) {
                nextFigureNumber++;
            }
        }

        return nextFigureNumber == 4;
    }

    public static boolean isNumberOfKind(Set<Card> cards, int numberOfKind) {
        int[] cardIndexArray = cardIndexArray(cards);
        boolean isNumberOfKind = false;

        for (int value : cardIndexArray) {
            if (value == numberOfKind) {
                isNumberOfKind = true;
                break;
            }
        }

        return isNumberOfKind;
    }

    public static int[] cardIndexArray(Set<Card> cards) {
        int[] cardIndexArray = new int[13];
        cards.stream()
                .map(Card::getFigure)
                .map(Figure::getValue)
                .forEach(figureValue -> cardIndexArray[figureValue]++);
        return cardIndexArray;
    }

}
