public class Spelling {
    public static String writeRub(float rub) {
        int decRubl = (int) rub % 100;
        int ones = decRubl % 10;
        int tens = decRubl / 10;
        if (ones == 1 && tens != 1) {
            return " рубль";
        } else if (ones >= 2 && ones <= 4 && tens != 1) {
            return " рубля";
        } else {
            return " рублей";
        }

    }

}
