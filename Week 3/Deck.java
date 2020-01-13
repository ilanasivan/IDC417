import java.lang.Math;

/**
 * Provides services for creating and shuffling a deck of cards.
 */
public class Deck {

    public static void main(String[] args) {
        String[] deck = createDeck();
        printDeck(deck);
        printDeck(shuffled(deck));
        printDeck(deck);
    }

    /**
     * Builds and returns a deck of cards. Each card has a suit and a rank.
     */
    public static String[] createDeck() {
        // Builds a deck of cards
        String[] suit = {"\u2660", "\u2666", "\u2665", "\u2663"};
        //String[] suit = { "Clubs", "Diamonds", "Hearts", "Spades" };
        String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9",
                "10", "J", "Q", "K", "A"};
        int Nsuit = suit.length;
        int Nrank = rank.length;
        int N = Nsuit * Nrank;

        String[] deck = new String[N];
        for (int i = 0; i < Nrank; i++) {
            for (int j = 0; j < Nsuit; j++) {
                deck[Nsuit * i + j] = suit[j] + rank[i];
            }
        }
        return deck;
    }

    /**
     * Prints the given deck of cards.
     */
    public static void printDeck(String[] deck) {
        // Prints the shuffled decks
        int N = deck.length;
        for (int i = 0; i < N; i++)
            System.out.print(deck[i] + " ");
        System.out.println();
    }

    /**
     * Returns a new, shuffled deck of cards. The given deck is not changed.
     */
    public static String[] shuffled(String[] deck) {

        int N = deck.length;
        String[] shuffledDeck = new String[N];

        for (int i = 0; i < N; i++) {
            int min = 0;
            int range = N;
            int randomizedIndex = (int) (Math.random() * range) + min;

            while (shuffledDeck[randomizedIndex] != null) {
                if (randomizedIndex + 1 == N) {
                    randomizedIndex = 0;
                } else {
                    randomizedIndex++;
                }
            }
            shuffledDeck[randomizedIndex] = deck[i];
        }
        return shuffledDeck;
    }
}
