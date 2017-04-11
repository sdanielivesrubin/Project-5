package prj5;

/**
 * Input Class runs the program, accepts user input files in argument
 * 
 * @author Yasmine Belghith (byasmine)
 * @version 2016.11.07
 *
 */

public class Input {

    /**
     * Checks if there are user input files to run, otherwise runs default
     * files, creates a GUIWindow, prints out the SongList sorted by Genre and
     * by Title
     * 
     * @param args
     *            the array containing the files input
     */
    public static void main(String[] args)

    {
        SurveyReader reader = null;

        String surveyFile;

        String songFile;

        if (args.length >= 2)

        {

            surveyFile = args[0];

            songFile = args[1];

            reader = new SurveyReader(surveyFile, songFile);

        }

        else

        {

            reader = new SurveyReader("MusicSurveyData.csv", "SongList.csv");

        }
        GUIWindow window = new GUIWindow(reader.getSongs());
        SongList<Song> output = reader.getSongs();
        output.sortByGenre();
        System.out.print(output.toString());
        output.sortByTitle();
        System.out.println(output.toString());

    }

}
