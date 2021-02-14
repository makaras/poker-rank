package pl.maciejkaras.poker.model;

import java.util.Objects;

public class Card {

    private final Figure figure;
    private final Colour colour;

    public Card(Figure figure, Colour colour) {
        this.figure = figure;
        this.colour = colour;
    }

    public Figure getFigure() {
        return figure;
    }

    public Colour getColour() {
        return colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return figure == card.figure &&
                colour == card.colour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(figure, colour);
    }

    @Override
    public String toString() {
        return "Card{" +
                "figure=" + figure +
                ", colour=" + colour +
                '}';
    }
}
