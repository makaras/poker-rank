package pl.maciejkaras.poker;

import pl.maciejkaras.poker.model.Card;
import pl.maciejkaras.poker.model.PokerHand;
import pl.maciejkaras.poker.rank.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static pl.maciejkaras.poker.model.PokerHand.HIGH_CARD;

class PokerService {

    private final List<PokerRank> pokerRankList;

    PokerService() {
        pokerRankList = Arrays.asList(
                new RoyalFlush(), new StraightFlush(), new FourOfAKind(),
                new FullHouse(), new Flush(), new Straight(),
                new ThreeOfAKind(), new TwoPair(), new OnePair());
    }

    PokerHand identityHand(Set<Card> cards) {
        validate(cards);
        return pokerRankList.stream()
                .map(pokerRank -> pokerRank.identify(cards))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElse(HIGH_CARD);
    }

    private void validate(Set<Card> cards) {
        if (cards.size() != 5) {
            throw new IllegalStateException("Provide exactly 5 different cards");
        }
    }

}
