package ru.mephi.labs.lab5;


import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PriceRepository {
    private static  final String[] namesCode = {"EU","USD","JPY", "RUB"};
    private static  final String[] namesValuate = {"Euro","Dollar","Jen", "Ruble"};
    private static  int id = 0;
    private static String getRandomNC(int i){
        return  namesCode[i];
    }
    private static String getRandomNV(int i){
        return  namesValuate[i];
    }
    private static Price getRandomPrice(){
        int index = 0;
        return new Price.PriceBuilder()
                .priceId(id++)
                .lot((long)(Math.random()*20))
                .numCode(getRandomNC(index = (int)(Math.random() * namesCode.length)))
                .name(getRandomNV(index))
                .value(BigDecimal.valueOf(Math.random() * 70))
                .build();
    }
    @Getter
    private List<Price> priceList;

    public  PriceRepository ()throws IllegalArgumentException{
        //Just do default "database request"
        if(namesValuate.length != namesCode.length)
            throw  new IllegalStateException("Wrong Data of values");
        priceList = new ArrayList<>();
        int index = 0;
        var Pr = getRandomPrice();
        Collections.addAll(priceList,
                getRandomPrice(),
                getRandomPrice(),
                getRandomPrice(),
                getRandomPrice(),
                getRandomPrice(),
                getRandomPrice(),
                getRandomPrice(),
                getRandomPrice(),
                null,
                null
//                new Price.PriceBuilder()
//                        .lot(null)
//                        .name(null)
//                        .priceId(id++)
//                        .numCode(null)
//                        .build()

        );
    }
}
