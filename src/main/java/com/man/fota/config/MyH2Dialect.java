package com.man.fota.config;

import org.hibernate.dialect.H2Dialect;

public class MyH2Dialect extends H2Dialect {

    @Override
    public boolean dropConstraints() {
        return true;
    }

}