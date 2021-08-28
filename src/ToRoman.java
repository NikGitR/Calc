public  class ToRoman {
    public static String intToRoman(Integer arabic) {
        if (arabic == 1) {
            return "I";
        } else if (arabic == 2) {
            return "II";
        } else if (arabic == (3)) {
            return "III";
        } else if (arabic == (4)) {
            return "IV";
        } else if (arabic == (5)) {
            return "V";
        } else if (arabic == (6)) {
            return "VI";
        } else if (arabic == (7)) {
            return "VII";
        } else if (arabic == (8)) {
            return "VIII";
        } else if (arabic == (9)) {
            return "IX";
        } else if (arabic == (10)) {
            return "X";
        } else {
            return null;
        }
    }
}
