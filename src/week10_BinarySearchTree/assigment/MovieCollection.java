package week10_BinarySearchTree.assigment;

import java.util.HashSet;
import java.util.Set;
import week10_BinarySearchTree.*;

/**
 *
 * @author Jeremy Santorelli
 */
public class MovieCollection extends BinarySearchTree<Movie> {

    public String getMoviesIn(String genre) {

        String ret = findGenre(super.getRoot(), genre);
        String newRet = ret.replace("\n\n", "\n");
        String finalRet = newRet.replace("\n\n", "\n");
        return finalRet;

    }

    private String findGenre(Node<Movie> root, String genre) {
        if (root == null) {
            return "";
        }
        if (root.getKey().getGenre().equals(genre)) {
            return root.getKey().toString() + "\n" + findGenre(
                    root.getLeft(), genre) + "\n"
                    + findGenre(root.getRight(), genre);
        }
        return findGenre(root.getLeft(), genre) + "\n"
                + findGenre(root.getRight(), genre);
    }

    public String getMoviesBetween(int year1, int year2) {
        if (year1 < 1200 || year2 < 1200) {
            return "";
        }
        int from, to;
        if (year1 > year2) {
            from = year2;
            to = year1;
        } else {
            to = year2;
            from = year1;
        }
        String ret = findMovieRange(from, to, super.getRoot());
        String newRet = ret.replace("\n\n", "\n");
        String finalRet = newRet.replace("\n\n", "\n");
        return finalRet;
    }

    private String findMovieRange(int from, int to, Node<Movie> root) {

        if (root == null) {
            return "";
        }
        if (Integer.parseInt(root.getKey().getYear()) >= from
                && Integer.parseInt(root.getKey().getYear()) <= to) {

            return root.getKey().toString() + "\n" + findMovieRange(from,
                    to, root.getLeft()) + "\n"
                    + findMovieRange(from, to, root.getRight());
        } else {
            return "" + findMovieRange(from, to, root.getLeft()) + "\n"
                    + findMovieRange(from, to, root.getRight());
        }

    }

    public Set<Movie> getMoviesDirectedBy(String director) {

        return moviesByDirector(director, super.getRoot(),
                new HashSet<>());
    }

    private Set<Movie> moviesByDirector(String director,
            Node<Movie> root, Set<Movie> m) {

        if (root == null) {
            return m;
        }
        if (root.getKey().getDirector().equals(director)) {
            if (!m.contains(root.getKey())) {
                m.add(root.getKey());
            }

        }

        m.addAll(moviesByDirector(director, root.getLeft(), m));
        m.addAll(moviesByDirector(director, root.getRight(), m));

        return m;

    }
}
