package prj5;

import java.awt.Color;

import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;
import list.AList;

/**
 * GUI Window class generates the display in a window with the appropriate
 * buttons, the Glyphs, the textShapes and a legend
 * 
 * @author Yasmine Belghith (byasmine)
 * @version 2016.11.11
 *
 */
public class GUIWindow {

    // private GlyphGenerator generator;
    private SongList<Song> songs;
    private Window window;

    private Shape legend;
    private TextShape legendTitle;
    private TextShape option1;
    private TextShape option2;
    private TextShape option3;
    private TextShape option4;
    private TextShape songTitle;
    private TextShape heardSide;
    private TextShape likedSide;
    private Shape seperator;

    private Button next;
    private Button previous;
    private Button hobby;
    private Button major;
    private Button state;
    private Button title;
    private Button artist;
    private Button genre;
    private Button date;
    private Button quit;

    private int clicked;
    private int currentNum;
    private String currentRepresent;
    private Boolean lastPage;

    /**
     * Constructor that initializes the GlyphGenerator, the SongList, the
     * window, the legend, and the buttons
     */
    public GUIWindow(SongList<Song> list) {
        songs = list;
        // generator = new GlyphGenerator(songs);
        window = new Window();
        window.setSize(1000, 1000);

        clicked = 0;
        currentNum = 0;
        currentRepresent = "title";
        lastPage = false;

        this.addLegend();

        previous = new Button("Previous");
        window.addButton(previous, WindowSide.NORTH);
        previous.onClick(this, "clickedPrevious");

        artist = new Button("Sort by Artist Name");
        window.addButton(artist, WindowSide.NORTH);
        artist.onClick(this, "clickedArtist");

        title = new Button("Sort by Song Title");
        window.addButton(title, WindowSide.NORTH);
        title.onClick(this, "clickedTitle");

        date = new Button("Sort by Release Year");
        window.addButton(date, WindowSide.NORTH);
        date.onClick(this, "clickedDate");

        genre = new Button("Sort by Genre");
        window.addButton(genre, WindowSide.NORTH);
        genre.onClick(this, "clickedGenre");

        next = new Button("Next");
        window.addButton(next, WindowSide.NORTH);
        next.onClick(this, "clickedNext");

        hobby = new Button("Represent Hobby");
        window.addButton(hobby, WindowSide.SOUTH);
        hobby.onClick(this, "clickedHobby");

        major = new Button("Represent Major");
        window.addButton(major, WindowSide.SOUTH);
        major.onClick(this, "clickedMajor");

        state = new Button("Represent Region");
        window.addButton(state, WindowSide.SOUTH);
        state.onClick(this, "clickedState");

        quit = new Button("Quit");
        window.addButton(quit, WindowSide.SOUTH);
        quit.onClick(this, "clickedQuit");

    }

    /**
     * Gets the window field
     * 
     * @return window the window field
     */
    public Window getWindow() {
        return window;

    }

    /**
     * Shows the next set of glyphs on the window
     * 
     * @param source
     *            the button clicked
     */
    public void clickedNext(Button source) {
        
        if (songs.size() > currentNum + 9 )
        {
            currentNum += 9;
        }

        
        if(currentNum + 9 > songs.size())
        {
            lastPage = true;
        }
        
        
        window.removeAllShapes();
        this.addLegend();
        this.addTitles(clicked);
        this.addGlyphs(currentRepresent);

        if (currentRepresent == "state")
        {
            this.updateLegendText(RepresentEnum.STATE);
        }
        
        if (currentRepresent == "major")
        {
            this.updateLegendText(RepresentEnum.MAJOR);
        }
        
        if (currentRepresent == "hobby")
        {
            this.updateLegendText(RepresentEnum.HOBBY);
        }
        

    }

    /**
     * Shows the previous set of glyphs on the window
     * 
     * @param source
     *            the button clicked
     */
    public void clickedPrevious(Button source) {

        if(currentNum != 0)
        {
            currentNum -= 9; 
        }
        
        if(currentNum + 9 <= songs.size())
        {
            lastPage = false;
        }
        window.removeAllShapes();
        this.addLegend();
        this.addTitles(clicked);
        this.addGlyphs(currentRepresent);

        if (currentRepresent == "state")
        {
            this.updateLegendText(RepresentEnum.STATE);
        }
        
        if (currentRepresent == "major")
        {
            this.updateLegendText(RepresentEnum.MAJOR);
        }
        
        if (currentRepresent == "hobby")
        {
            this.updateLegendText(RepresentEnum.HOBBY);
        }

    }

    /**
     * Closes the window
     * 
     * @param source
     *            the button clicked
     */
    public void clickedQuit(Button source) {
        System.exit(0);
    }

    /**
     * Represents the glyphs by hobby, and updates the legend
     * 
     * @param source
     *            the button clicked
     */
    public void clickedHobby(Button source) {

        window.removeAllShapes();
        this.addLegend();
        this.updateLegendText(RepresentEnum.HOBBY);
        this.addTitles(clicked);
        currentRepresent =  "hobby";
        this.addGlyphs( "hobby");


    }

    /**
     * Represents the glyphs by major, and updates the legend
     * 
     * @param source
     *            the button clicked
     */
    public void clickedMajor(Button source) {

        window.removeAllShapes();
        this.addLegend();
        this.updateLegendText(RepresentEnum.MAJOR);
        this.addTitles(clicked);
        currentRepresent =  "major";
        this.addGlyphs( "major");

    }

    /**
     * Represents the glyphs by state, and updates the legend
     * 
     * @param source
     *            the button clicked
     */
    public void clickedState(Button source) {
        window.removeAllShapes();
        this.addLegend();
        this.updateLegendText(RepresentEnum.STATE);
        this.addTitles(clicked);
        currentRepresent =  "state";
        this.addGlyphs( "state");
    }
    
    /**
     * Create Glyphys
     * 
     * @param type
     *            the glyphs to create
     */
    private void addGlyphs(String type)
    {      
        
        
        
        GlyphGenerator gen = new GlyphGenerator(songs);
        AList<Glyph> current =  null;
        
        if (type == "state")
        {
             current = gen.createGlyphsByState();
             currentRepresent = "state";
        }
        
        if (type == "major")
        {
             current = gen.createGlyphsByMajor();
             currentRepresent = "major";
        }
        
        if (type == "hobby")
        {
             current = gen.createGlyphsByHobby();
             currentRepresent = "hobby";

        }
        
        
        int plusNine = currentNum + 9;
        if (lastPage)
        {
            plusNine = songs.size();
        }
              
        for (int i = currentNum; i < plusNine; i++) {
            
            for (int j = 1; j < 5; j++) {
                Shape shape = current.getEntry(i).getShapes()[j];
                shape.setX(143 + ((i % 3) * 279));
                shape.setY(145 + (j * 12) + (i % 9 / 3) * 300);
                window.addShape(shape);
            }
            for (int k = 5; k < 9; k++) {
                Shape shape = current.getEntry(i).getShapes()[k];
                shape.setX(138 + ((i % 3) * 279) - shape.getWidth());
                shape.setY(145 + ((k - 4) * 12) + (i % 9 / 3) * 300);
                window.addShape(shape);
            }
        }
        
        
        
    }

    /**
     * Displays the songs sorted by title
     * 
     * @param source
     *            the button clicked
     */
    public void clickedTitle(Button source) {
        songs.sortByTitle();
        window.removeAllShapes();
        clicked = 0;
        this.addLegend();
        this.addTitles(clicked);
        this.addGlyphs(currentRepresent);

    }

    /**
     * Displays the songs sorted by artist
     * 
     * @param source
     *            the button clicked
     */
    public void clickedArtist(Button source) {
        songs.sortByArtist();
        window.removeAllShapes();
        clicked = 1;
        this.addLegend();
        this.addTitles(clicked);
        this.addGlyphs(currentRepresent);
    }

    /**
     * Displays the songs sorted by genre
     * 
     * @param source
     *            the button clicked
     */
    public void clickedGenre(Button source) {
        songs.sortByGenre();
        window.removeAllShapes();
        clicked = 2;
        this.addLegend();
        this.addTitles(clicked);
        this.addGlyphs(currentRepresent);
    }

    /**
     * Displays the songs sorted by date
     * 
     * @param source
     *            the button clicked
     */
    public void clickedDate(Button source) {
        songs.sortByDate();
        window.removeAllShapes();
        clicked = 3;
        this.addLegend();
        this.addTitles(clicked);
        this.addGlyphs(currentRepresent);

    }

    private void addTitles(int number) {
        
        int plusNine = currentNum + 9;
        if (lastPage)
        {
            plusNine = songs.size();
        }
        
        
        for (int i = currentNum; i < plusNine; i++) {
            int x = 143 + ((i % 3) * 279) - 100;
            int y = 100 + (i % 9 / 3) * 300;
            Song current = songs.get(i);
            String str = "";
            String str2 = "";
            if (number == 0) {
                str = current.getTitle();
                str2 = "by: " + current.getArtist();
            }
            if (number == 1) {
                str = current.getTitle();
                str2 = "by: " + current.getArtist();
            }
            if (number == 2) {
                str = current.getTitle();
                str2 = "genre: " + current.getGenre();
            }
            if (number == 3) {
                str = current.getTitle();
                str2 = "release year: " + current.getDate();
            }
            TextShape titlePart1 = new TextShape(x, y - 10, str);
            TextShape titlePart2 = new TextShape(x, y + 10, str2);
            titlePart1.setBackgroundColor(Color.WHITE);
            titlePart2.setBackgroundColor(Color.WHITE);
            window.addShape(titlePart1);
            window.addShape(titlePart2);
        }
    }

    private void addLegend() {
        final int WIDTH = 120;
        final int HEIGHT = 210;
        final int GAP = 155;
        final int GAP2 = 20;
        final int GAP3 = 1;
        final int GAP4 = 15;
        final int HEARDX = 850;
        final int LIKEDX = 905;
        int x = window.getGraphPanelWidth() - WIDTH - GAP2;
        int y = window.getGraphPanelHeight() - HEIGHT - (GAP2 * 3);
        legend = new Shape(x, y, WIDTH, HEIGHT);
        legend.setBackgroundColor(Color.WHITE);
        legend.setForegroundColor(Color.BLACK);
        seperator = new Shape(897, y + GAP, 3, 50);
        seperator.setBackgroundColor(Color.BLACK);
        seperator.setForegroundColor(Color.BLACK);
        window.addShape(seperator);
        legendTitle = new TextShape(x + (GAP3 * 3), y + (GAP3 * 2),
                "Hobby Legend");
        legendTitle.setBackgroundColor(Color.WHITE);
        window.addShape(legendTitle);
        option1 = new TextShape(x + GAP3, y + GAP2, "read");
        option1.setForegroundColor(Color.PINK);
        option1.setBackgroundColor(Color.WHITE);
        window.addShape(option1);
        option2 = new TextShape(x + GAP3, y + GAP2 + GAP4, "art");
        option2.setForegroundColor(Color.BLUE);
        option2.setBackgroundColor(Color.WHITE);
        window.addShape(option2);
        option3 = new TextShape(x + GAP3, y + GAP2 + (GAP4 * 2), "sports");
        option3.setForegroundColor(Color.YELLOW);
        option3.setBackgroundColor(Color.WHITE);
        window.addShape(option3);
        option4 = new TextShape(x + GAP3, y + GAP2 + (GAP4 * 3), "music");
        option4.setForegroundColor(Color.GREEN);
        option4.setBackgroundColor(Color.WHITE);
        window.addShape(option4);
        songTitle = new TextShape(x + (GAP3 * 3), y + (GAP2 * 5), "Song Title");
        songTitle.setBackgroundColor(Color.WHITE);
        window.addShape(songTitle);
        heardSide = new TextShape(HEARDX, y + GAP, "Heard");
        heardSide.setBackgroundColor(Color.WHITE);
        window.addShape(heardSide);
        likedSide = new TextShape(LIKEDX, y + GAP, "Likes");
        likedSide.setBackgroundColor(Color.WHITE);
        window.addShape(likedSide);
        window.addShape(legend);

        Shape vertical = new Shape(138, 145, 5, 83);
        vertical.setBackgroundColor(Color.BLACK);
        window.addShape(vertical);

        Shape vertical2 = new Shape(418, 145, 5, 83);
        vertical2.setBackgroundColor(Color.BLACK);
        window.addShape(vertical2);

        Shape vertical3 = new Shape(697, 145, 5, 83);
        vertical3.setBackgroundColor(Color.BLACK);
        window.addShape(vertical3);

        Shape vertical4 = new Shape(138, 435, 5, 83);
        vertical4.setBackgroundColor(Color.BLACK);
        window.addShape(vertical4);

        Shape vertical5 = new Shape(418, 435, 5, 83);
        vertical5.setBackgroundColor(Color.BLACK);
        window.addShape(vertical5);

        Shape vertical6 = new Shape(697, 435, 5, 83);
        vertical6.setBackgroundColor(Color.BLACK);
        window.addShape(vertical6);

        Shape vertical7 = new Shape(138, 726, 5, 83);
        vertical7.setBackgroundColor(Color.BLACK);
        window.addShape(vertical7);

        Shape vertical8 = new Shape(418, 726, 5, 83);
        vertical8.setBackgroundColor(Color.BLACK);
        window.addShape(vertical8);

        Shape vertical9 = new Shape(697, 726, 5, 83);
        vertical9.setBackgroundColor(Color.BLACK);
        window.addShape(vertical9);
    }

    /**
     * Updates the textShapes in the legend
     * 
     * @param represent
     *            the enumerator passed in
     */
    public void updateLegendText(RepresentEnum represent) {
        if (represent == RepresentEnum.HOBBY) {
            legendTitle.setText("Hobby Legend");
            option1.setText("read");
            option2.setText("art");
            option3.setText("sports");
            option4.setText("music");
        }
        else if (represent == RepresentEnum.MAJOR) {
            legendTitle.setText("Major Legend");
            option1.setText("Computer Science");
            option2.setText("Other Engineering");
            option3.setText("Math or CMDA");
            option4.setText("Other");
        }
        else if (represent == RepresentEnum.STATE) {
            legendTitle.setText("Region Legend");
            option1.setText("Northeast");
            option2.setText("Southeast");
            option3.setText("Rest of the US");
            option4.setText("Outside of the US");
        }

    }

}
