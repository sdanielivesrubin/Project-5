package prj5;

import java.awt.Color;

import CS2114.Shape;

/**
 * Glyph class represents the graphs showing the heard and like percentages that
 * will be displayed on the GUIWindow
 * 
 * @author Yasmine Belghith (byasmine)
 * @version 2016.11.07
 */
public class Glyph {

    private Shape[] shapes;

    private Shape topBarLikes;

    private Shape midTopBarLikes;

    private Shape midBottomBarLikes;

    private Shape bottomBarLikes;

    private Shape topBarHeard;

    private Shape midTopBarHeard;

    private Shape midBottomBarHeard;

    private Shape bottomBarHeard;

    private Shape vertical;

    private final static int HEIGHT = 10;

    private final static int VERTICAL_WIDTH = 5;

    private final static int MARGIN = 3;

    private final static int START = 0;

    /**
     * Constructor for Glyph, initializes the 4 different bars
     */
    public Glyph() {
        shapes = new Shape[9];
        vertical = new Shape(START, START, VERTICAL_WIDTH,
                (HEIGHT * 8) + MARGIN);
        vertical.setBackgroundColor(Color.BLACK);
        shapes[0] = vertical;

        topBarLikes = new Shape(START, START, START, HEIGHT);
        topBarLikes.setBackgroundColor(Color.PINK);
        shapes[1] = topBarLikes;
        midTopBarLikes = new Shape(START, START, START, HEIGHT);
        midTopBarLikes.setBackgroundColor(Color.BLUE);
        shapes[2] = midTopBarLikes;
        midBottomBarLikes = new Shape(START, START, START, HEIGHT);
        midBottomBarLikes.setBackgroundColor(Color.YELLOW);
        shapes[3] = midBottomBarLikes;
        bottomBarLikes = new Shape(START, START, START, HEIGHT);
        bottomBarLikes.setBackgroundColor(Color.GREEN);
        shapes[4] = bottomBarLikes;

        topBarHeard = new Shape(START, START, START, HEIGHT);
        topBarHeard.setBackgroundColor(Color.PINK);
        shapes[5] = topBarHeard;
        midTopBarHeard = new Shape(START, START, START, HEIGHT);
        midTopBarHeard.setBackgroundColor(Color.BLUE);
        shapes[6] = midTopBarHeard;
        midBottomBarHeard = new Shape(START, START, START, HEIGHT);
        midBottomBarHeard.setBackgroundColor(Color.YELLOW);
        shapes[7] = midBottomBarHeard;
        bottomBarHeard = new Shape(START, START, START, HEIGHT);
        bottomBarHeard.setBackgroundColor(Color.GREEN);
        shapes[8] = bottomBarHeard;
    }

    public Shape[] getShapes() {
        return shapes;
    }

    /**
     * Updates a specific bar based on the like and heard percentage
     * 
     * @param shapePosition
     *            one of the 4 positions of the bars
     * @param like
     *            the like percentage to be represented
     * @throws IllegalArgumentException
     *             when the shapePosition entered is not valid
     */
    public void createLikeBar(int shapePosition, int like) {
        if (shapePosition == 1) {
            this.topBarLikes = new Shape(START, START, like, HEIGHT);
            topBarLikes.setBackgroundColor(Color.PINK);
            shapes[1] = topBarLikes;
        }
        else if (shapePosition == 2) {
            this.midTopBarLikes = new Shape(START, START, like, HEIGHT);
            midTopBarLikes.setBackgroundColor(Color.BLUE);
            shapes[2] = midTopBarLikes;
        }
        else if (shapePosition == 3) {
            this.midBottomBarLikes = new Shape(START, START, like, HEIGHT);
            midBottomBarLikes.setBackgroundColor(Color.GREEN);
            shapes[3] = midBottomBarLikes;
        }
        else if (shapePosition == 4) {
            this.bottomBarLikes = new Shape(START, START, like, HEIGHT);
            bottomBarLikes.setBackgroundColor(Color.YELLOW);
            shapes[4] = bottomBarLikes;
        }
        else {
            throw new IllegalArgumentException(
                    "Cannot find the right position");
        }
    }

    /**
     * Updates a specific bar based on the like and heard percentage
     * 
     * @param shapePosition
     *            one of the 4 positions of the bars
     * @param heard
     *            the heard percentage to be represented
     * @throws IllegalArgumentException
     *             when the shapePosition entered is not valid
     */
    public void createHeardBar(int shapePosition, int heard) {
        if (shapePosition == 5) {
            this.topBarHeard = new Shape(START, START, heard, HEIGHT);
            topBarHeard.setBackgroundColor(Color.PINK);
            shapes[5] = topBarHeard;
        }
        else if (shapePosition == 6) {
            this.midTopBarHeard = new Shape(START, START, heard, HEIGHT);
            midTopBarHeard.setBackgroundColor(Color.BLUE);
            shapes[6] = midTopBarHeard;
        }
        else if (shapePosition == 7) {
            this.midBottomBarHeard = new Shape(START, START, heard, HEIGHT);
            midBottomBarHeard.setBackgroundColor(Color.GREEN);
            shapes[7] = midBottomBarHeard;
        }
        else if (shapePosition == 8) {
            this.bottomBarHeard = new Shape(START, START, heard, HEIGHT);
            bottomBarHeard.setBackgroundColor(Color.YELLOW);
            shapes[8] = bottomBarHeard;
        }
        else {
            throw new IllegalArgumentException(
                    "Cannot find the right position");
        }
    }
}
