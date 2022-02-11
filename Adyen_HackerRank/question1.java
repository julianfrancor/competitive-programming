import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /**
     * An entity to hold bin range details. A bin range is a pair of 12 digit numbers that
     * mark the boundaries of the range which is maped to other bin range properties such
     * as a card type. The range boundaries are inclusive.
     */
    static final class BinRange {
        final String start;
        final String end;
        final String cardType;

        BinRange(String start, String end, String cardType) {
            this.start = start;
            this.end = end;
            this.cardType = cardType;
        }
    }

    interface CardTypeCache {
        /**
         * @param cardNumber 12 to 23 digit card number.
         *
         * @return the card type for this cardNumber or null if the card number does not
         *      fall into any valid bin ranges.
         */
        String get(String cardNumber);
    }

    /**
     * @param binRanges the list of card bin ranges to build a cache from.
     *
     * @return an implementation of CardTypeCache.
     */
    public static CardTypeCache buildCache(List<BinRange> binRanges) {
        return new CardTypeCache() {
            @Override
            public String get(String cardNumber) {
                Long cardNumbLong = Long.parseLong(cardNumber.substring(0, 12));
                for(int i=0; i<binRanges.size(); i++){
                    Long numberStart = Long.parseLong(binRanges.get(i).start);
                    Long numberEnd = Long.parseLong(binRanges.get(i).end);
                    if(numberStart <= cardNumbLong && cardNumbLong <= numberEnd){
                        return binRanges.get(i).cardType;
                    }
                }
                return null;
            }
        };
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        try (final Scanner scanner = new Scanner(System.in)) {
            List<Result.BinRange> binRanges = new ArrayList<>();

            String cardNumber = scanner.next();
            scanner.nextLine();

            scanner.useDelimiter("[,\n]");

            while (scanner.hasNext()) {
                String start = scanner.next();
                String end = scanner.next();
                String cardType = scanner.next();
                binRanges.add(new Result.BinRange(start, end, cardType));
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }

            Result.CardTypeCache cache = Result.buildCache(binRanges);
            if (cache != null) {
                bufferedWriter.write(String.valueOf(cache.get(cardNumber)));
            }
        }

        bufferedWriter.newLine();
        bufferedWriter.close();
    }
}