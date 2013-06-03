/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.tlowry.nbgolang.filetypes.filetype.actions.callables;

import com.github.tlowry.nbgolang.core.Globals;
import java.util.Map;
import org.openide.filesystems.FileObject;

/**
 *
 * @author tony
 */
public class GoBuildCallable extends GolangCallable {

    private final String packageName;

    public GoBuildCallable(FileObject projectDir, String packageName) {
        super(projectDir);
        this.packageName = packageName;

    }

    @Override
    public Process call() throws Exception {
        ProcessBuilder b = new ProcessBuilder("go", "build", packageName);
        setGoPath(b, projectDir.getPath());
        return b.start();
    }

    private void setGoPath(ProcessBuilder builder, String projectDir) {
        Map<String, String> env = builder.environment();
        env.put("GOPATH", projectDir);
        env.put(Globals.GOLANG_GOPATH_VAR, projectDir);
    }
}
