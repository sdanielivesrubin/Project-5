package prj5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Survey Reader Class parses through 2 files, creates a SongList to store the
 * data parsed and a GlyphGenerator that takes in the update SongList
 * 
 * @author Yasmine Belghith (byasmine)
 * @version 2016.11.07
 *
 */
public class SurveyReader {

    private SongList<Song> songs;

    /**
     * Creates a SongList and a GlyphGenerator. Completes the parsing
     * 
     * @param songFile
     *            the input file containing the songs to be parsed
     * @param surveyFile
     *            the input file containing the answers to be parsed
     */
    public SurveyReader(String surveyFile, String songFile) {
        songs = this.readSurveyFiles(songFile, surveyFile);
        GlyphGenerator generator = new GlyphGenerator(songs);

    }

    public SongList<Song> getSongs() {
        return songs;
    }

    /**
     * Instantiates a SongList, and scanners that parse through the files and
     * store the data in the SongList, updates the information of each song
     * according to the survey file
     * 
     * @param songFile
     *            the file passed in
     * @param surveyFile
     *            the file passed in
     * @throws FileNotFoundException
     *             if the fileName is not valid
     * @return SongList the SongList holding the information
     * 
     */
    public SongList<Song> readSurveyFiles(String songFile, String surveyFile) {
        SongList<Song> tempList = new SongList<Song>();
        Song song = null;
        BufferedReader file = null;
        BufferedReader file2 = null;
        try {
            file = new BufferedReader(new FileReader(songFile));

            String line = "";

            line = file.readLine();
            while ((line = file.readLine()) != null) {

                String[] arrayLine = line.split(",");
                String title = arrayLine[0];
                String artist = arrayLine[1];
                String year = arrayLine[2];
                String genre = arrayLine[3];
                song = new Song(title, artist, genre, year);
                tempList.add(song);

            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(0);

        }
        finally {
            try {
                file.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            file2 = new BufferedReader(new FileReader(surveyFile));
            String line2 = "";

            line2 = file2.readLine();

            while ((line2 = file2.readLine()) != null) {

                String[] arrayLine2 = line2.split(",", -1);
                int i = 5;
                for (int j = 0; j < tempList.size(); j++) {
                    Song tempSong = tempList.get(j);
                    if (arrayLine2.length > i && arrayLine2.length > (i + 1)) {

                        if (arrayLine2[i].equals("Yes")
                                || arrayLine2[i].equals("No")) {
                            tempSong.updateTotalStudents(arrayLine2[4]);
                            tempSong.updateTotalStudents(arrayLine2[2]);
                            tempSong.updateTotalStudents(arrayLine2[3]);
                        }
                        if (arrayLine2[i + 1].equals("Yes")
                                || arrayLine2[i + 1].equals("No")) {
                            tempSong.updateTotalStudentsForLikes(arrayLine2[4]);
                            tempSong.updateTotalStudentsForLikes(arrayLine2[2]);
                            tempSong.updateTotalStudentsForLikes(arrayLine2[3]);
                        }
                        if (arrayLine2[i].equals("Yes")) {
                            tempSong.updateHeardHobbies(arrayLine2[4]);
                            tempSong.updateHeardMajors(arrayLine2[2]);
                            tempSong.updateHeardStates(arrayLine2[3]);
                        }
                        if (arrayLine2[i + 1].equals("Yes")) {
                            tempSong.updateLikeHobbies(arrayLine2[4]);
                            tempSong.updateLikeMajors(arrayLine2[2]);
                            tempSong.updateLikeStates(arrayLine2[3]);
                        }

                    }
                    i += 2;
                }
                for (int k = 0; k < tempList.size(); k++) {
                    Song tempSong = tempList.get(k);
                    tempSong.updateMajorsHeardPercentages();
                    tempSong.updateHobbiesHeardPercentages();
                    tempSong.updateStatesHeardPercentages();
                    tempSong.updateMajorsLikePercentages();
                    tempSong.updateHobbiesLikePercentages();
                    tempSong.updateStatesLikePercentages();
                }
            }

        }

        catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

        return tempList;
    }

}
