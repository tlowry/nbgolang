/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.tlowry.nbgolang.Editor;

import org.netbeans.api.lexer.TokenId;

/**
 *
 * @author tony.lowry
 */
public class GolangTokenId implements TokenId {

    private final String name;
    private final String primaryCategory;
    private final int id;

    public GolangTokenId(String name, String primaryCategory, int id) {
        this.name = name;
        this.primaryCategory = primaryCategory;
        this.id = id;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public int ordinal() {
        return this.id;
    }

    @Override
    public String primaryCategory() {
        return this.primaryCategory;
    }
}
