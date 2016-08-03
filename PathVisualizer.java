package rosen.tools;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PathVisualizer {

    private static char node = '+';
    private static char nodeConncetor = '|';
    private static char lastNode = '\\';
    private static String decoration = "---";
    private static String spaces = "   ";

    private static List<String> visualize2(File parent) {
        List<String> charPath = new ArrayList<String>();
        File[] children = parent.listFiles();
        for (int i = 0; i < children.length; i++) {
            File child = children[i];
            if (child.isDirectory()) {
                if (i != children.length - 1) {
                    charPath.add(node + decoration + child.getName());
                } else {
                    charPath.add(lastNode + decoration + child.getName());
                }
                List<String> temp = visualize2(child);
                for (String t : temp) {
                    if (i != children.length - 1) {
                        charPath.add(nodeConncetor + spaces + t);
                    } else {
                        charPath.add(" " + spaces + t);
                    }
                }
            } else {
                if (i != children.length - 1) {
                    charPath.add(node + decoration + child.getName());
                } else {
                    charPath.add(lastNode + decoration + child.getName());
                }
            }
        }
        return charPath;
    }

    public static String visualize(File root) {
        if (!root.isDirectory()) {
            throw new IllegalArgumentException("The parameter root should be a directory");
        }
        List<String> lines = visualize2(root);
        String out = "";
        for (String line : lines) {
            out += line + System.getProperty("line.separator");
        }
        return out;
    }

    public static char getNode() {
        return node;
    }

    public static void setNode(char node) {
        PathVisualizer.node = node;
    }

    public static char getNodeConncetor() {
        return nodeConncetor;
    }

    public static void setNodeConncetor(char nodeConncetor) {
        PathVisualizer.nodeConncetor = nodeConncetor;
    }

    public static char getLastNode() {
        return lastNode;
    }

    public static void setLastNode(char lastNode) {
        PathVisualizer.lastNode = lastNode;
    }

    public static String getDecoration() {
        return decoration;
    }

    public static void setDecoration(String decoration) {
        PathVisualizer.decoration = decoration;
        int len = decoration.length();
        String t = "";
        for (int i = 0; i < len; i++) {
            t += " ";
        }
        spaces = t;
    }

    public static void main(String[] args) {
        System.out.println(PathVisualizer.visualize(new File("X:\\TutorialVideos")));
        PathVisualizer.setDecoration("-------");
        System.out.println(PathVisualizer.visualize(new File("X:\\TutorialVideos")));
    }
}
