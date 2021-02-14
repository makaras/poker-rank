package pl.maciejkaras.poker.rank;

import pl.maciejkaras.poker.model.Card;
import pl.maciejkaras.poker.model.PokerHand;

import java.util.Optional;
import java.util.Set;

import static pl.maciejkaras.poker.model.Figure.ACE;
import static pl.maciejkaras.poker.model.PokerHand.ROYAL_FLUSH;
import static pl.maciejkaras.poker.rank.common.PokerRankCommon.isFlush;
import static pl.maciejkaras.poker.rank.common.PokerRankCommon.isStraight;

public class RoyalFlush implements PokerRank {

    @Override
    public Optional<PokerHand> identify(Set<Card> cards) {
        if (!isFlush(cards)) {
            return Optional.empty();
        }

        if (!isStraight(cards)) {
            return Optional.empty();
        }

        if (!isAce(cards)) {
            return Optional.empty();
        }

        return Optional.of(ROYAL_FLUSH);
    }

    private boolean isAce(Set<Card> cards) {
        return cards.stream()
                .map(Card::getFigure)
                .anyMatch(figure -> ACE.getValue() == figure.getValue());
    }

}
