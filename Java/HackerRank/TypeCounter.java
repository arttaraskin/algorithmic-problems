public class TypeCounter {
    public static void main(String[] args) {
        typeCounter("  5 5.  0. 43 r  ");
    }

    public static void typeCounter(String sentence) {
        if(sentence == null || sentence.replaceFirst("^\\s+", "").isEmpty()) {
            System.out.println("string 0");
            System.out.println("integer 0");
            System.out.println("double 0");
        }

        String[] words = sentence.replaceFirst("^\\s+", "").split("\\s+");
        int countInteger = 0;
        int countDouble = 0;
        int countString = 0;

        for (String word : words) {
            if (word.isEmpty()) continue;
            try {
                Integer.parseInt(word);
                countInteger++;
            } catch (NumberFormatException eInteger) {
                try {
                    Double.parseDouble(word);
                    countDouble++;
                } catch (NumberFormatException eDouble) {
                    countString++;
                }
            }
        }
        System.out.println("string " + countString);
        System.out.println("integer " + countInteger);
        System.out.println("double " + countDouble);
    }
}