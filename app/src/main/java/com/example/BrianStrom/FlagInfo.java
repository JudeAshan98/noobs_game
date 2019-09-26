package com.example.BrianStrom;

public class FlagInfo {

    static FlagInfo flagInfo;

    static Integer[] images = {

            R.drawable.be,

            R.drawable.gb,
          //  R.drawable.gb_eng,

            R.drawable.in,

            R.drawable.jm,

            R.drawable.jp,

            R.drawable.nz,

            R.drawable.um,

            R.drawable.za,

    };


    static String[] flagsNames = {


            "Belgium",

            "United Kingdom",

            "India",

            "Jamaica",

            "Japan",

            "New Zealand",

            "United States",

            "South Africa",

    };

    private FlagInfo(){}

    public static FlagInfo getFlagInfo() {

        if (flagInfo == null)
            return new FlagInfo();

        return flagInfo;
    }
}
