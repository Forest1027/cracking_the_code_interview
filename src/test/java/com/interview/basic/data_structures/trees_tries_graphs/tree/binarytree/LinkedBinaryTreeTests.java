package com.interview.basic.data_structures.trees_tries_graphs.tree.binarytree;

import com.interview.basic.data_structures.trees_tries_graphs.Position;
import com.interview.basic.data_structures.trees_tries_graphs.tree.Tree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.stream.Stream;

public class LinkedBinaryTreeTests {
    private LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();

    @BeforeEach
    private void insertData() {
        Position<String> root = tree.addRoot("Paper");
        tree.addLeft(root, "Title");
        Position<String> rootRight = tree.addRight(root, "Abstract");
        Position<String> posLeft = tree.addLeft(rootRight, "§1");
        Position<String> posRight = tree.addRight(rootRight, "§2");
        tree.addLeft(posLeft, "§1.1");
        tree.addRight(posLeft, "§1.2");
        tree.addLeft(posRight, "§2.1");
        tree.addRight(posRight, "§2.2");
    }

    @Test
    public void testInorderTraversal() {
        // set x and y
        Iterable<Position<String>> positions = tree.inorder();
        for (Position<String> child : positions
        ) {
            System.out.println(child.getElement() + " (" + child.getX() + "," + child.getY() + ")");
        }

    }

    /**
     * preorder traversal
     * can be used to print out a table of content with added indentation
     * the indentation is the the depth of the position multiplied by certain number (2 in this example)
     */
    @Test
    public void testPreorderTraversal() {
        Iterable<Position<String>> positions = tree.preorder();
        StringBuilder sb = new StringBuilder();
        for (Position<String> child :
                positions) {
            sb.append(" ".repeat(2 * tree.depth(child)) + child.getElement());
            sb.append("\n");
        }
        String expectedResult = "Paper\n" +
                "  Title\n" +
                "  Abstract\n" +
                "    §1\n" +
                "      §1.1\n" +
                "      §1.2\n" +
                "    §2\n" +
                "      §2.1\n" +
                "      §2.2\n";
        assert expectedResult.equals(sb.toString());
    }


    @Test
    public void testPostorderTraversal() {

    }

    @Test
    public void breadthFirstTraversal() {
        Iterable<Position<String>> positions = tree.breadthfirst();
        int depth = 0;
        for (Position<String> child : positions
        ) {
            if (tree.depth(child) != depth) {
                System.out.println();
                depth++;
            }
            System.out.print(child.getElement() + " ");
        }
    }

}
