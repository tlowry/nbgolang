/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.tlowry.nbgolang.Editor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.openide.util.Exceptions;

/**
 *
 * @author tony.lowry
 */
public class AntlrTokenReader {

    private HashMap<String, String> tokenTypes = new HashMap<String, String>();
    private ArrayList<GolangTokenId> tokens = new ArrayList<GolangTokenId>();

    public AntlrTokenReader() {
        init();
    }

    /**
     * Initializes the map to include any keywords in the Hop Programming language.
     */
    private void init() {

        tokenTypes.put("TYPE_INT", "type");
        tokenTypes.put("TYPE_CHAR", "type");
        
        tokenTypes.put("FOR", "keyword");

        tokenTypes.put("ID", "identifier");
        tokenTypes.put("INT", "number");
        
    }

    /**
     * Reads the token file from the ANTLR parser and generates
     * appropriate tokens.
     *
     * @return
     */
    public List<GolangTokenId> readTokenFile() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inp = classLoader.getResourceAsStream("com/github/tlowry/nbgolang/syntaxHighlighting/antlr/golang.tokens");
        BufferedReader input = new BufferedReader(new InputStreamReader(inp));
        readTokenFile(input);
        return tokens;
    }

    /**
     * Reads in the token file.
     *
     * @param buff
     */
    private void readTokenFile(BufferedReader buff) {
        String line = null;
        try {
            while ((line = buff.readLine()) != null) {
                String[] splLine = line.split("=");
                String name = splLine[0];
                int tok = Integer.parseInt(splLine[1].trim());
                GolangTokenId id;
                String tokenCategory = tokenTypes.get(name);
                if (tokenCategory != null) {
                    //if the value exists, put it in the correct category
                    id = new GolangTokenId(name, tokenCategory, tok);
                } else {
                    //if we don't recognize the token, consider it to a separator
                    id = new GolangTokenId(name, "separator", tok);
                }
                //add it into the vector of tokens
                tokens.add(id);
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
