/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.tlowry.nbgolang.filetypes.project;

import com.github.tlowry.nbgolang.filetypes.customizer.GolangCustomizerProvider;
import com.github.tlowry.nbgolang.filetypes.filetype.actions.GoBuildCallable;
import com.github.tlowry.nbgolang.filetypes.filetype.actions.GoBuilder;
import com.github.tlowry.nbgolang.filetypes.filetype.actions.GoInstaller;
import com.sun.jmx.snmp.Enumerated;
import java.awt.Image;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.netbeans.api.annotations.common.StaticResource;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectInformation;
import org.netbeans.spi.project.ActionProvider;
import org.netbeans.spi.project.ProjectState;
import org.netbeans.spi.project.ui.LogicalViewProvider;
import org.netbeans.spi.project.ui.support.CommonProjectActions;
import org.netbeans.spi.project.ui.support.NodeFactorySupport;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataFolder;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;
import org.openide.util.lookup.ProxyLookup;

/**
 *
 * @author tony.lowry
 */
public class GolangProject implements Project {

    private final FileObject projectDir;
    private final ProjectState state;
    private Lookup lkp;

    public GolangProject(FileObject dir, ProjectState state) {
        this.projectDir = dir;
        this.state = state;
    }

    @Override
    public FileObject getProjectDirectory() {
        return projectDir;
    }

    @Override
    public Lookup getLookup() {
        if (lkp == null) {
            lkp = Lookups.fixed(new Object[]{
                this,
                new Info(),
                new GolangProjectLogicalView(this),
                new GolangCustomizerProvider(this),
                new ActionProviderImpl()
            });
        }
        return lkp;
    }

    private final class Info implements ProjectInformation {

        @StaticResource()
        public static final String GOPHER_ICON_24 = "com/github/tlowry/nbgolang/filetypes/resources/gophercolor.png";

        @Override
        public Icon getIcon() {
            return new ImageIcon(ImageUtilities.loadImage(GOPHER_ICON_24));
        }

        @Override
        public String getName() {
            return getProjectDirectory().getName();
        }

        @Override
        public String getDisplayName() {
            return getName();
        }

        @Override
        public void addPropertyChangeListener(PropertyChangeListener pcl) {
            //do nothing, won't change
        }

        @Override
        public void removePropertyChangeListener(PropertyChangeListener pcl) {
            //do nothing, won't change
        }

        @Override
        public Project getProject() {
            return GolangProject.this;
        }
    }

    class GolangProjectLogicalView implements LogicalViewProvider {

        @StaticResource()
        public static final String GOPHER_ICON_24 = "com/github/tlowry/nbgolang/filetypes/resources/gophercolor.png";
        private final GolangProject project;

        public GolangProjectLogicalView(GolangProject project) {
            this.project = project;
        }

        @Override
        public Node createLogicalView() {
            try {
                //Obtain the project directory's node:
                FileObject projectDirectory = project.getProjectDirectory();
                DataFolder projectFolder = DataFolder.findFolder(projectDirectory);
                Node nodeOfProjectFolder = projectFolder.getNodeDelegate();
                //Decorate the project directory's node:
                return new ProjectNode(nodeOfProjectFolder, project);
            } catch (DataObjectNotFoundException donfe) {
                Exceptions.printStackTrace(donfe);
                //Fallback-the directory couldn't be created -
                //read-only filesystem or something evil happened
                return new AbstractNode(Children.LEAF);
            }
        }

        @Override
        public Node findPath(Node root, Object target) {
            return null;
        }

        private final class ProjectNode extends FilterNode {

            final GolangProject project;

            public ProjectNode(Node node, GolangProject project)
                    throws DataObjectNotFoundException {
                super(node,
                        NodeFactorySupport.createCompositeChildren(
                        project,
                        "Projects/org-golang-project/Nodes"),
                        new ProxyLookup(
                        new Lookup[]{
                    Lookups.singleton(project),
                    node.getLookup()
                }));
                this.project = project;
            }

            @Override
            public Action[] getActions(boolean arg0) {
                return new Action[]{
                    CommonProjectActions.customizeProjectAction(),
                    CommonProjectActions.newFileAction(),
                    CommonProjectActions.copyProjectAction(),
                    CommonProjectActions.deleteProjectAction(),
                    CommonProjectActions.closeProjectAction()
                };
            }

            @Override
            public Image getIcon(int type) {
                return ImageUtilities.loadImage(GOPHER_ICON_24);
            }

            @Override
            public Image getOpenedIcon(int type) {
                return getIcon(type);
            }

            @Override
            public String getDisplayName() {
                return project.getProjectDirectory().getName();
            }
        }
    }

    class ActionProviderImpl implements ActionProvider {

        private String[] supported = new String[]{
            ActionProvider.COMMAND_BUILD,
            ActionProvider.COMMAND_CLEAN,
            ActionProvider.COMMAND_COMPILE_SINGLE,
            ActionProvider.COMMAND_COPY,
            ActionProvider.COMMAND_DEBUG,
            ActionProvider.COMMAND_DEBUG_SINGLE,
            ActionProvider.COMMAND_DEBUG_STEP_INTO,
            ActionProvider.COMMAND_DEBUG_TEST_SINGLE,
            ActionProvider.COMMAND_DELETE,
            ActionProvider.COMMAND_MOVE,
            ActionProvider.COMMAND_PROFILE,
            ActionProvider.COMMAND_PROFILE_SINGLE,
            ActionProvider.COMMAND_PROFILE_TEST_SINGLE,
            ActionProvider.COMMAND_REBUILD,
            ActionProvider.COMMAND_RENAME,
            ActionProvider.COMMAND_RUN,
            ActionProvider.COMMAND_RUN_SINGLE,
            ActionProvider.COMMAND_TEST,
            ActionProvider.COMMAND_TEST_SINGLE
        };

        @Override
        public String[] getSupportedActions() {
            return supported;
        }

        @Override
        public void invokeAction(String action, Lookup lookup) throws IllegalArgumentException {

            if (ActionProvider.COMMAND_BUILD.equalsIgnoreCase(action)) {
            } else if (ActionProvider.COMMAND_CLEAN.equalsIgnoreCase(action)) {
            } else if (ActionProvider.COMMAND_COMPILE_SINGLE.equalsIgnoreCase(action)) {
            } else if (ActionProvider.COMMAND_COPY.equalsIgnoreCase(action)) {
            } else if (ActionProvider.COMMAND_DEBUG.equalsIgnoreCase(action)) {
            } else if (ActionProvider.COMMAND_DEBUG_SINGLE.equalsIgnoreCase(action)) {
            } else if (ActionProvider.COMMAND_DEBUG_STEP_INTO.equalsIgnoreCase(action)) {
            } else if (ActionProvider.COMMAND_DEBUG_TEST_SINGLE.equalsIgnoreCase(action)) {
            } else if (ActionProvider.COMMAND_DELETE.equalsIgnoreCase(action)) {
            } else if (ActionProvider.COMMAND_MOVE.equalsIgnoreCase(action)) {
            } else if (ActionProvider.COMMAND_PROFILE.equalsIgnoreCase(action)) {
            } else if (ActionProvider.COMMAND_PROFILE_SINGLE.equalsIgnoreCase(action)) {
            } else if (ActionProvider.COMMAND_PROFILE_TEST_SINGLE.equalsIgnoreCase(action)) {
            } else if (ActionProvider.COMMAND_REBUILD.equalsIgnoreCase(action)) {
                this.doRebuild(lookup);
            } else if (ActionProvider.COMMAND_RENAME.equalsIgnoreCase(action)) {
            } else if (ActionProvider.COMMAND_RUN.equalsIgnoreCase(action)) {
                //GolangProject.this.getProjectDirectory()
                this.doRun(lookup);
            } else if (ActionProvider.COMMAND_RUN_SINGLE.equalsIgnoreCase(action)) {
            } else if (ActionProvider.COMMAND_TEST.equalsIgnoreCase(action)) {
            } else if (ActionProvider.COMMAND_TEST_SINGLE.equalsIgnoreCase(action)) {
            }
        }

        @Override
        public boolean isActionEnabled(String command, Lookup lookup) throws IllegalArgumentException {
            if (ActionProvider.COMMAND_BUILD.equalsIgnoreCase(command)) {
            } else if (ActionProvider.COMMAND_CLEAN.equalsIgnoreCase(command)) {
            } else if (ActionProvider.COMMAND_COMPILE_SINGLE.equalsIgnoreCase(command)) {
            } else if (ActionProvider.COMMAND_COPY.equalsIgnoreCase(command)) {
            } else if (ActionProvider.COMMAND_DEBUG.equalsIgnoreCase(command)) {
            } else if (ActionProvider.COMMAND_DEBUG_SINGLE.equalsIgnoreCase(command)) {
            } else if (ActionProvider.COMMAND_DEBUG_STEP_INTO.equalsIgnoreCase(command)) {
            } else if (ActionProvider.COMMAND_DEBUG_TEST_SINGLE.equalsIgnoreCase(command)) {
            } else if (ActionProvider.COMMAND_DELETE.equalsIgnoreCase(command)) {
            } else if (ActionProvider.COMMAND_MOVE.equalsIgnoreCase(command)) {
            } else if (ActionProvider.COMMAND_PROFILE.equalsIgnoreCase(command)) {
            } else if (ActionProvider.COMMAND_PROFILE_SINGLE.equalsIgnoreCase(command)) {
            } else if (ActionProvider.COMMAND_PROFILE_TEST_SINGLE.equalsIgnoreCase(command)) {
            } else if (ActionProvider.COMMAND_REBUILD.equalsIgnoreCase(command)) {
            } else if (ActionProvider.COMMAND_RENAME.equalsIgnoreCase(command)) {
            } else if (ActionProvider.COMMAND_RUN.equalsIgnoreCase(command)) {
            } else if (ActionProvider.COMMAND_RUN_SINGLE.equalsIgnoreCase(command)) {
            } else if (ActionProvider.COMMAND_TEST.equalsIgnoreCase(command)) {
            } else if (ActionProvider.COMMAND_TEST_SINGLE.equalsIgnoreCase(command)) {
            }
            return true;
        }

        private void doRebuild(Lookup lookup) {
            String projectPath = projectDir.getPath();
            List<String> packageNames = getPackageList(projectDir);
            
            GoInstaller installer = new GoInstaller(projectPath);
            installer.install(packageNames);
            
            GoBuilder builder = new GoBuilder(projectPath);
            builder.build(packageNames);
        }

        private List<String> getPackageList(FileObject projectDir) {
            ArrayList<String> packageList = new ArrayList<String>(5);
            FileObject src = getDirByName(projectDir, "src");
            searchPackages(src, packageList);
            return packageList;
        }

        /*
         * Breadth First search for packages
         */
        public void searchPackages(FileObject root, ArrayList<String> packageList) {
            Queue<FileObject> queue = new LinkedList<FileObject>();
            if (root == null) {
                return;
            }
            queue.clear();
            queue.add(root);
            while (!queue.isEmpty()) {
                FileObject nextDir = queue.remove();
                Enumeration filesUnderDir = nextDir.getChildren(false);
                boolean foundPackage = false;
                while (filesUnderDir.hasMoreElements()) {
                    FileObject file = (FileObject) filesUnderDir.nextElement();
                    if (file.hasExt("go")) {
                        //found a package
                        foundPackage = true;
                    }
                }
                
                if (foundPackage) {
                    // stop searching this branch & save package name
                    String fullPath = nextDir.getPath();
                    String [] splitPaths = fullPath.split("src/");
                    String packageName = "";
                    
                    // Take the relative path component
                    if(splitPaths.length > 1 && splitPaths[1] != null){
                        packageName = splitPaths[1];
                    }
                    packageList.add(packageName);
                    
                } else {
                    // Could be deeper in this branch, keep going
                    Enumeration x = root.getFolders(true);
                    while (x.hasMoreElements()) {
                        queue.add((FileObject) x.nextElement());
                    }
                }

            }

        }

        private FileObject getDirByName(FileObject root, String name) {
            FileObject srcDir = null;
            Enumeration x = root.getFolders(true);
            while (x.hasMoreElements()) {
                FileObject f = (FileObject) x.nextElement();
                if (f.getName().equals(name)) {
                    srcDir = f;
                    break;
                }
            }
            return srcDir;
        }

        private void doRun(Lookup lookup) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
