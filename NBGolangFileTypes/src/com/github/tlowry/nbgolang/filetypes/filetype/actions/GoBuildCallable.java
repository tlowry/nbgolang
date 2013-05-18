/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.tlowry.nbgolang.filetypes.filetype.actions;

import com.github.tlowry.nbgolang.core.Globals;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 *
 * @author tony
 */
public class GoBuildCallable implements Callable<Object> {

    private final String projectDir;
    private final String packageName;

    public GoBuildCallable(String projectDir, String packageName) {
        this.projectDir = projectDir;
        this.packageName = packageName;

    }

    @Override
    public Object call() throws Exception {
        ProcessBuilder b = new ProcessBuilder("go", "build", packageName);
        setGoPath(b, projectDir);
        return b.start();
    }

    private void setGoPath(ProcessBuilder builder, String projectDir) {
        Map<String, String> env = builder.environment();
        env.put("GOPATH", projectDir);
        env.put(Globals.GOLANG_GOPATH_VAR, projectDir);
    }
}
