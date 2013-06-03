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
public class GoInstallCallable extends GolangCallable {

    private final String packageName;

    public GoInstallCallable(FileObject projectDir, String packageName) {
        super(projectDir);
        this.packageName = packageName;

    }

    @Override
    public Object call() throws Exception {
        ProcessBuilder b = new ProcessBuilder("go", "install", packageName);
        //ProcessBuilder b = new ProcessBuilder("C:\\dev\\ek.bat");
        setGoPath(b, projectDir.getPath());
        return b.start();
    }

    private void setGoPath(ProcessBuilder builder, String projectDir) {
        Map<String, String> env = builder.environment();
        env.put("GOPATH", projectDir);
        env.put(Globals.GOLANG_GOPATH_VAR, projectDir);
    }
}
