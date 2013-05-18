/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.tlowry.nbgolang.filetypes.nodes;

import com.github.tlowry.nbgolang.core.Globals;
import com.github.tlowry.nbgolang.filetypes.project.GolangProject;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.event.ChangeListener;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ui.support.NodeFactory;
import org.netbeans.spi.project.ui.support.NodeList;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;

/**
 *
 * @author tony.lowry
 */
@NodeFactory.Registration(projectType = Globals.PROJECT_TYPE, position = 10)
public class GoNodeFactory implements NodeFactory {

    @Override
    public NodeList<?> createNodes(Project project) {
        GolangProject p = project.getLookup().lookup(GolangProject.class);
        assert p != null;
        return new TextsNodeList(p);
    }

    class TextsNodeList implements NodeList<Node> {

        GolangProject project;

        public TextsNodeList(GolangProject project) {
            this.project = project;
        }

        @Override
        public List<Node> keys() {
            Enumeration<? extends FileObject> en = project.getProjectDirectory().getFolders(true);
            List<Node> result = new ArrayList<Node>();
            while (en.hasMoreElements()) {
                FileObject folder = (FileObject) en.nextElement();

                try {
                    result.add(DataObject.find(folder).getNodeDelegate());
                } catch (DataObjectNotFoundException ex) {
                    Exceptions.printStackTrace(ex);
                }

            }
            return result;
        }

        @Override
        public Node node(Node node) {
            return new FilterNode(node);
        }

        @Override
        public void addNotify() {
        }

        @Override
        public void removeNotify() {
        }

        @Override
        public void addChangeListener(ChangeListener cl) {
        }

        @Override
        public void removeChangeListener(ChangeListener cl) {
        }
    }
}
