package com.apress.prospring4.ch3.xml;

import com.apress.prospring4.ch3.Oracle;

public class BookwormOracle implements Oracle {

//    private Encyclopedia encyclopedia;
//
//    public void setEncyclopedia(Encyclopedia encyclopedia) {
//        this.encyclopedia = encyclopedia;
//    }

    @Override
    public String defineMeaningOfLife() {
        return "Encyclopedias are а waste of money - use the Internet";
    }
}
