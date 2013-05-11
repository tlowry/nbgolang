/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.tlowry.nbgolang.Editor;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.netbeans.api.lexer.Language;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 *
 * @author tony.lowry
 */
public class GolangLanguageHierarchy extends LanguageHierarchy<GolangTokenId> {

    private static List<GolangTokenId> tokens;
    private static Map<Integer, GolangTokenId> idToToken;
    private static final Language<GolangTokenId> language = new GolangLanguageHierarchy().language();

    public GolangLanguageHierarchy() {
    }

    private static void init() {
        AntlrTokenReader reader = new AntlrTokenReader();
        tokens = reader.readTokenFile();
        idToToken = new HashMap<Integer, GolangTokenId>();
        for (GolangTokenId token : tokens) {
            idToToken.put(token.ordinal(), token);
        }
    }

    static synchronized GolangTokenId getToken(int id) {
        if (idToToken == null) {
            init();
        }
        return idToToken.get(id);
    }

    @Override
    protected Collection<GolangTokenId> createTokenIds() {
        if (tokens == null) {
            init();
        }
        return tokens;
    }

    @Override
    protected Lexer<GolangTokenId> createLexer(LexerRestartInfo<GolangTokenId> info) {
        return new NBGolangLexer(info);
    }

    @Override
    protected String mimeType() {
        return Globals.GOLANG_MIME_TYPE;
    }

    public Language<GolangTokenId> getLanguage() {
        return this.language;
    }
}
