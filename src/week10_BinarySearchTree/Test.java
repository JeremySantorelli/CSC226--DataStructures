package week10_BinarySearchTree;
import java.util.Random;
import week10_BinarySearchTree.assigment.*;
import week10_BinarySearchTree.assigment.MovieCollection;
/**
 *
 * @author Jeremy Santorelli
 */
public class Test {

    public static void main(String[] args) {

        /**
         * ******QUESTION 1**********************
         */
        System.out.println("QUESTION 1\n");
        
        QuestionOne tree = new QuestionOne();

        tree.insert(50); tree.insert(30); tree.insert(20);
        tree.insert(40); tree.insert(70); tree.insert(60);
        tree.insert(80);

        QuestionOne treeCopy = new QuestionOne();

        treeCopy.insert(5); treeCopy.insert(3); treeCopy.insert(2);
        treeCopy.insert(4); treeCopy.insert(7); treeCopy.insert(6);
        treeCopy.insert(8);

        QuestionOne treeNotMatching = new QuestionOne();

        treeNotMatching.insert(5); treeNotMatching.insert(2);
        treeNotMatching.insert(4); treeNotMatching.insert(7);
        treeNotMatching.insert(6); treeNotMatching.insert(8);

        System.out.println("Leaf Count 'tree': " + tree.leafCount());
        System.out.println("Leaf Count 'treeCopy': "
                + treeCopy.leafCount());
        System.out.println("Leaf Count 'treeNotMAtching': "
                + treeNotMatching.leafCount());

        System.out.println("Single Parent Count 'tree': "
                + tree.singleParent());
        System.out.println("Single Parent Count 'treeCopy': "
                + treeCopy.singleParent());
        System.out.println("Single Parent Count 'treeNotMatching': "
                + treeNotMatching.singleParent() + "\n");

        System.out.println("'tree' \n" + tree.toString());

        System.out.println("'treeCopy' \n" + treeCopy.toString());
        System.out.println("'tree' similar to 'treeCopy'? "
                + tree.similarTrees(treeCopy) + "\n");
        System.out.println("'treeNotMatching' \n"
                + treeNotMatching.toString());
        System.out.println("'tree' similar to 'treeNotMatching'? "
                + tree.similarTrees(treeNotMatching));

        /**
         * ******QUESTION 2******************************
         */
        System.out.println("\n\nQUESTION 2\n");
        MovieCollection mc = new MovieCollection();
        String[] genre = {"action", "drama", "comedy", "thriller"};
        String[] title = {"Cloudy with a Chance of Meatballs", "Harvey",
            "Mr. Smith Goes to Washington", "L.A. Confidential",
            "Little Miss Sunshine", "The Future", "Howard the Duck",
            "Howard’s End", "The Innkeeper", "Revolutionary Road"};
        String[] director = {"Steven Speilberg", "Ron Howard", "John Woo"};
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            mc.insert(new Movie(title[i],
                    director[r.nextInt(3)],
                    "201" + r.nextInt(9),
                    genre[r.nextInt(4)]));
        }

        mc.inorder();
        System.out.println("\n\nCOMEDIES\n    ");
        System.out.println(mc.getMoviesIn("comedy"));

        System.out.println("\n\nIN RANGE");
        System.out.println(mc.getMoviesBetween(2017, 2018));

        System.out.println("\n\nBY DIRECTOR STEVEN SPEILBERG");
        System.out.println(mc.getMoviesDirectedBy("Steven Speilberg")
                .toString());

    }

}
