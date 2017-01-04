package com.rogek.typlingo;

/**
 * Created by raz on 07/11/2016.
 */

public class Keys {
    /*

    Codes and Java Unicode keys are stored in a jsonString Format
    128 = א
    129 = ב
    130 = ג
    131 = ד
    132 = ה
    133 = ו
    134 = ז
    135 = ח
    136 = ט
    137 = י
    138 = ך
    139 = כ
    140 = ל
    141 = ם
    142 = מ
    143 = ן
    144 = נ
    145 = ס
    146 = ע
    147 = ף
    148 = פ
    149 = ץ
    150 = צ
    151 = ק
    152 = ר
    153 = ש
    154 = ת
    NIS = 1001
    */
    public static Keys keys = null;
    private final String codes = "{"
            + "		\"128\":\"\u05D0\","
            + "		\"129\":\"\u05D1\","
            + "		\"130\":\"\u05D2\","
            + "		\"131\":\"\u05D3\","
            + "		\"132\":\"\u05D4\","
            + "		\"133\":\"\u05D5\","
            + "		\"134\":\"\u05D6\","
            + "		\"135\":\"\u05D7\","
            + "		\"136\":\"\u05D8\","
            + "		\"137\":\"\u05D9\","
            + "		\"138\":\"\u05DA\","
            + "		\"139\":\"\u05DB\","
            + "		\"140\":\"\u05DC\","
            + "		\"141\":\"\u05DD\","
            + "		\"142\":\"\u05DE\","
            + "		\"143\":\"\u05DF\","
            + "		\"144\":\"\u05E0\","
            + "		\"145\":\"\u05E1\","
            + "		\"146\":\"\u05E2\","
            + "		\"147\":\"\u05E3\","
            + "		\"148\":\"\u05E4\","
            + "		\"149\":\"\u05E5\","
            + "		\"150\":\"\u05E6\","
            + "		\"151\":\"\u05E7\","
            + "		\"152\":\"\u05E8\","
            + "		\"153\":\"\u05E9\","
            + "		\"154\":\"\u05EA\","
            + "     \"1001\":\"\u20AA\""
            + "}";


    public Keys(){}

    public static Keys getInstance(){
        if (keys==null)
            keys = new Keys();
        return keys;
    }

    public String getCodes(){
        return codes;
    }

}

