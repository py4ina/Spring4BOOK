package com.apress.prospring4.ch3.annotation;

import com.apress.prospring4.ch3.Oracle;
import org.springframework.stereotype.Service;

@Service("oracle")
public class BookwormOracle implements Oracle {

    @Override
    public String defineMeaningOfLife() {
        return "Encyclopedias are а waste of money - use the Internet";
    }
}
