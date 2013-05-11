/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.tlowry.nbgolang.Editor;

import com.github.tlowry.nbgolang.Editor.antlr.GolangLexer;
import org.netbeans.api.lexer.Token;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 *
 * @author tony.lowry
 */
class NBGolangLexer implements Lexer<GolangTokenId> {
    private final LexerRestartInfo<GolangTokenId> info;
    private GolangLexer lexer;

    public NBGolangLexer(LexerRestartInfo<GolangTokenId> info) {
        this.info = info;
        ANTLRCharStream charStream = new ANTLRCharStream(info.input(), "NBGolang", true);
        lexer = new GolangLexer(charStream);
    }

    @Override
    public org.netbeans.api.lexer.Token<GolangTokenId> nextToken() {
        org.antlr.runtime.Token token = lexer.nextToken();                

        Token<GolangTokenId> createdToken = null;

        if (token.getType() != -1){
            GolangTokenId tokenId  = GolangLanguageHierarchy.getToken(token.getType());
            createdToken = info.tokenFactory().createToken(tokenId);
        }  else if(info.input().readLength() > 0){
            GolangTokenId tokenId  = GolangLanguageHierarchy.getToken(GolangLexer.WS);
            createdToken = info.tokenFactory().createToken(tokenId);
        }

        return createdToken;
    }

    @Override
    public Object state() {
        return null;
    }

    @Override
    public void release() {
    }
    
}
