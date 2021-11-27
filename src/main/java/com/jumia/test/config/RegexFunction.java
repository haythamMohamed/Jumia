package com.jumia.test.config;

import org.sqlite.Function;

import java.sql.SQLException;
import java.util.regex.Pattern;

public class RegexFunction extends Function {

    @Override
    protected void xFunc() throws SQLException {
        String expression = value_text(0);
        String value = value_text(1);
        if (value == null)
            value = "";

        Pattern pattern= Pattern.compile(expression);
        result(pattern.matcher(value).find() ? 1 : 0);
    }
}

