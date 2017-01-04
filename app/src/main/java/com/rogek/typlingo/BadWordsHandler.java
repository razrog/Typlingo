package com.rogek.typlingo;


import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by raz on 14/11/2016.
 */

public class BadWordsHandler implements IBadWords{

    private static BadWordsHandler badWordsHandler = null;
    private ConcurrentHashMap<String,Boolean> badWords = null;

    private BadWordsHandler(){
        initMap("heb");
    }


    public static BadWordsHandler getInstance(){

        synchronized (BadWordsHandler.class){
            if (badWordsHandler == null)
                badWordsHandler = new BadWordsHandler();
            return badWordsHandler;
        }
    }

    public ConcurrentHashMap getMap(){
        return this.badWords;
    }

    @Override
    public void initMap(String local) {
        badWords = new ConcurrentHashMap();
        syncDictionary();

    }

    @Override
    public void syncDictionary() {
        try {
            badWords.put("פרוצה",true);
            badWords.put("זונה",true);
            badWords.put("טמבל",true);
            badWords.put("מעפן",true);
            badWords.put("חרם",true);
            badWords.put("טיפש",true);
            badWords.put("דפוק",true);
            badWords.put("ישמעלי",true);
            badWords.put("זבל",true);
            badWords.put("מנוול",true);
            badWords.put("מסריח",true);
            badWords.put("קקה",true);
            badWords.put("חרא",true);
            badWords.put("פלגמט",true);
            badWords.put("מזדיין",true);
            badWords.put("שמגג",true);
            badWords.put("fuck",true);
            badWords.put("Fuckwit",true);
            badWords.put("Useless",true);
            badWords.put("Breeder",true);
            badWords.put("Lesbian",true);
            badWords.put("Cocklump",true);
            badWords.put("Creampie",true);
            badWords.put("Cum",true);
            badWords.put("Semen",true);
            badWords.put("Cuntface",true);
            badWords.put("Doublelift",true);
            badWords.put("Trash",true);
            badWords.put("Dumbcunt",true);
            badWords.put("Fairy",true);
            badWords.put("Masturbate",true);
            badWords.put("Fuck!",true);
            badWords.put("Fuck!",true);
            badWords.put("HTF?",true);
            badWords.put("Hell",true);
            badWords.put("Heck",true);
            badWords.put("Incest",true);
            badWords.put("Masturbate",true);
            badWords.put("Jizz",true);
            badWords.put("Semen",true);
            badWords.put("Lesbian",true);
            badWords.put("Magasika",true);
            badWords.put("Mimbo",true);
            badWords.put("Man-Bimbo",true);
            badWords.put("Nmadid",true);
            badWords.put("Damn",true);
            badWords.put("Penis",true);
            badWords.put("Poopuncher",true);
            badWords.put("Penis",true);
            badWords.put("S.W.A.G",true);
            badWords.put("Sandler",true);
            badWords.put("Shag",true);
            badWords.put("Shitfaced",true);
            badWords.put("Stinkhoer",true);
            badWords.put("Teabagger",true);
            badWords.put("Penis",true);
            badWords.put("WTF???",true);
            badWords.put("Masturbate",true);
            badWords.put("Wank",true);
            badWords.put("Masturbate",true);
            badWords.put("Wanker",true);
            badWords.put("a-hole",true);
            badWords.put("cocaine",true);
            badWords.put("bumfucka",true);
            badWords.put("cockeye",true);
            badWords.put("crotte",true);
            badWords.put("turd",true);
            badWords.put("whore",true);
            badWords.put("cuntlapper",true);
            badWords.put("cus",true);
            badWords.put("dipshit",true);
            badWords.put("douchebag",true);
            badWords.put("bitch",true);
            badWords.put("idiot",true);
            badWords.put("dumf",true);
            badWords.put("faggot",true);
            badWords.put("feck",true);
            badWords.put("flamer",true);
            badWords.put("foah",true);
            badWords.put("ball",true);
            badWords.put("frocio",true);
            badWords.put("faggot",true);
            badWords.put("fruitcake",true);
            badWords.put("fucktwat",true);
            badWords.put("fuckwit",true);
            badWords.put("fudgenuts",true);
            badWords.put("whore",true);
            badWords.put("english",true);
            badWords.put("jaggi",true);
            badWords.put("cocksucker",true);
            badWords.put("kunja",true);
            badWords.put("bitch",true);
            badWords.put("kurijode",true);
            badWords.put("kusa",true);
            badWords.put("pussy",true);
            badWords.put("manwhore",true);
            badWords.put("mentak",true);
            badWords.put("muff",true);
            badWords.put("vagina",true);
            badWords.put("lesbian",true);
            badWords.put("nuts",true);
            badWords.put("testicles",true);
            badWords.put("orgazm",true);
            badWords.put("orgasm",true);
            badWords.put("orospu",true);
            badWords.put("cocksucker",true);
            badWords.put("piizda",true);
            badWords.put("cunt",true);
            badWords.put("pipele",true);
            badWords.put("dick",true);
            badWords.put("pissprat",true);
            badWords.put("bullshit",true);
            badWords.put("poesnaaier",true);
            badWords.put("poesprop",true);
            badWords.put("tampon",true);
            badWords.put("poesteef",true);
            badWords.put("punk",true);
            badWords.put("pussy",true);
            badWords.put("wimp",true);
            badWords.put("pust",true);
            badWords.put("scoundrel",true);
            badWords.put("Pussy",true);
            badWords.put("sanger",true);
            badWords.put("sauage",true);
            badWords.put("seks",true);
            badWords.put("sex",true);
            badWords.put("senti",true);
            badWords.put("cunt",true);
            badWords.put("shaatdapne",true);
            badWords.put("shit",true);
            badWords.put("feces",true);
            badWords.put("shitfar",true);
            badWords.put("sik",true);
            badWords.put("fuck",true);
            badWords.put("sikis",true);
            badWords.put("sikmek",true);
            badWords.put("skank",true);
            badWords.put("whore",true);
            badWords.put("slag",true);
            badWords.put("bitch",true);
            badWords.put("whore",true);
            badWords.put("spiceny",true);
            badWords.put("spanish",true);
            badWords.put("sumbitch",true);
            badWords.put("teringteef",true);
            badWords.put("thagari",true);
            badWords.put("titties",true);
            badWords.put("boobs",true);
            badWords.put("vymrdany",true);
            badWords.put("wankbox",true);
            badWords.put("mastubater",true);
            badWords.put("wanker",true);
            badWords.put("jerkoff",true);
            badWords.put("dick",true);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
