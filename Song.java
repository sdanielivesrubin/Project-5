package prj5;

/**
 * Song Class stores all the information about the song including the title,
 * artist, genre, date, as well as the likes and heard tallies for each student
 * type, also calculates the percentages for likes and heard for all types of
 * students and stores them in arrays
 * 
 * @author Yasmine Belghith (byasmine)
 * @version 2016.11.07
 *
 */
public class Song {

    private String title;
    private String artist;
    private String genre;
    private String date;
    private int[] majors;
    private int[] hobbies;
    private int[] states;
    public int[] majorsPercentages;
    public int[] hobbiesPercentages;
    public int[] statesPercentages;
    public int[] totalStudents;
    public int[] totalStudentsForLikes;

    private int likePercentage;
    private int heardPercentage;

    private static final int CAPACITY = 8;
    private static final int READ_INDEX = 0;
    private static final int ART_INDEX = 2;
    private static final int SPORT_INDEX = 4;
    private static final int MUSIC_INDEX = 6;

    private static final int CS_INDEX = 0;
    private static final int ENGE_INDEX = 2;
    private static final int MATH_INDEX = 4;
    private static final int OTHER_INDEX = 6;

    private static final int NORTH_EAST_INDEX = 0;
    private static final int SOUTH_EAST_INDEX = 2;
    private static final int REST_US_INDEX = 4;
    private static final int OUTSIDE_US_INDEX = 6;

    /**
     * Instantiates arrays to hold the data
     * 
     * @param name
     *            the title of the song
     * @param singer
     *            the artist
     * @param type
     *            the genre of the song
     * @param year
     *            the release year of the song
     */
    public Song(String name, String singer, String type, String year) {
        title = name;
        artist = singer;
        genre = type;
        date = year;

        majors = new int[CAPACITY];
        hobbies = new int[CAPACITY];
        states = new int[CAPACITY];

        totalStudents = new int[12];
        totalStudentsForLikes = new int[12];

        majorsPercentages = new int[CAPACITY];
        hobbiesPercentages = new int[CAPACITY];
        statesPercentages = new int[CAPACITY];

    }

    /**
     * Gets the title of the Song
     * 
     * @return title the title of the song
     */
    public String getTitle() {
        return title;

    }

    /**
     * Gets the Artist of the Song
     * 
     * @return artist the field artist of the Song
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Gets the Genre of the Song
     * 
     * @return genre the field genre of the Song
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Gets the Date of the Song
     * 
     * @return date the field date of the Song
     */
    public String getDate() {
        return date;
    }

    /**
     * Updates the total number of students who answered the "Have you heard"
     * questions for each major, hobby and/or state
     * 
     * @param type
     *            the characteristic of each student counted in
     */
    public void updateTotalStudents(String type) {
        if (type.equals("Computer Science")) {
            totalStudents[0] += 1;
        }
        if (type.equals("Other Engineering")) {
            totalStudents[1] += 1;
        }
        if (type.equals("Math or CMDA")) {
            totalStudents[2] += 1;
        }
        if (type.equals("Other")) {
            totalStudents[3] += 1;
        }
        if (type.equals("reading")) {
            totalStudents[4] += 1;
        }
        if (type.equals("art")) {
            totalStudents[5] += 1;
        }
        if (type.equals("sports")) {
            totalStudents[6] += 1;
        }
        if (type.equals("music")) {
            totalStudents[7] += 1;
        }
        if (type.equals("Northeast")) {
            totalStudents[8] += 1;
        }
        if (type.equals("Southeast")) {
            totalStudents[9] += 1;
        }
        if (type.equals("United States (other than Southeast or Northwest)")) {
            totalStudents[10] += 1;
        }
        if (type.equals("Outside of United States")) {
            totalStudents[11] += 1;
        }
    }

    /**
     * Updates the total number of students who answered the "Do you like"
     * questions for each major, hobby and/or state
     * 
     * @param type
     *            the characteristic of each student counted in
     */
    public void updateTotalStudentsForLikes(String type) {
        if (type.equals("Computer Science")) {
            totalStudentsForLikes[0] += 1;
        }
        if (type.equals("Other Engineering")) {
            totalStudentsForLikes[1] += 1;
        }
        if (type.equals("Math or CMDA")) {
            totalStudentsForLikes[2] += 1;
        }
        if (type.equals("Other")) {
            totalStudentsForLikes[3] += 1;
        }
        if (type.equals("reading")) {
            totalStudentsForLikes[4] += 1;
        }
        if (type.equals("art")) {
            totalStudentsForLikes[5] += 1;
        }
        if (type.equals("sports")) {
            totalStudentsForLikes[6] += 1;
        }
        if (type.equals("music")) {
            totalStudentsForLikes[7] += 1;
        }
        if (type.equals("Northeast")) {
            totalStudentsForLikes[8] += 1;
        }
        if (type.equals("Southeast")) {
            totalStudentsForLikes[9] += 1;
        }
        if (type.equals("United States (other than Southeast or Northwest)")) {
            totalStudentsForLikes[10] += 1;
        }
        if (type.equals("Outside of United States")) {
            totalStudentsForLikes[11] += 1;
        }
    }

    /**
     * Updates the heard tally for the different majors
     * 
     * @param type
     *            the type of major to update for
     */
    public void updateHeardMajors(String type) {
        if (type.equals("Computer Science")) {
            majors[CS_INDEX] += 1;
        }
        if (type.equals("Other Engineering")) {
            majors[ENGE_INDEX] += 1;
        }
        if (type.equals("Math or CMDA")) {
            majors[MATH_INDEX] += 1;
        }
        if (type.equals("Other")) {
            majors[OTHER_INDEX] += 1;
        }

    }

    /**
     * Updates the like tally for the different majors
     * 
     * @param type
     *            the type of major to update for
     */
    public void updateLikeMajors(String type) {
        if (type.equals("Computer Science")) {
            majors[CS_INDEX + 1] += 1;
        }
        if (type.equals("Other Engineering")) {
            majors[ENGE_INDEX + 1] += 1;
        }
        if (type.equals("Math or CMDA")) {
            majors[MATH_INDEX + 1] += 1;
        }
        if (type.equals("Other")) {
            majors[OTHER_INDEX + 1] += 1;
        }

    }

    /**
     * Updates the heard tally for the different hobbies
     * 
     * @param type
     *            the type of hobby to update for
     */
    public void updateHeardHobbies(String type) {
        if (type.equals("reading")) {
            hobbies[READ_INDEX] += 1;
        }
        if (type.equals("art")) {
            hobbies[ART_INDEX] += 1;
        }
        if (type.equals("sports")) {
            hobbies[SPORT_INDEX] += 1;
        }
        if (type.equals("music")) {
            hobbies[MUSIC_INDEX] += 1;
        }

    }

    /**
     * Updates the like tally for the different hobbies
     * 
     * @param type
     *            the type of hobby to update for
     */
    public void updateLikeHobbies(String type) {
        if (type.equals("reading")) {
            hobbies[READ_INDEX + 1] += 1;
        }
        if (type.equals("art")) {
            hobbies[ART_INDEX + 1] += 1;
        }
        if (type.equals("sports")) {
            hobbies[SPORT_INDEX + 1] += 1;
        }
        if (type.equals("music")) {
            hobbies[MUSIC_INDEX + 1] += 1;
        }

    }

    /**
     * Updates the heard tally for the different regions
     * 
     * @param type
     *            the type of region to update for
     */
    public void updateHeardStates(String type) {
        if (type.equals("Northeast")) {
            states[NORTH_EAST_INDEX] += 1;
        }
        if (type.equals("Southeast")) {
            states[SOUTH_EAST_INDEX] += 1;
        }
        if (type.equals("United States (other than Southeast or Northwest)")) {
            states[REST_US_INDEX] += 1;
        }
        if (type.equals("Outside of United States")) {
            states[OUTSIDE_US_INDEX] += 1;
        }

    }

    /**
     * Updates the like tally for the different regions
     * 
     * @param type
     *            the type of region to update for
     */
    public void updateLikeStates(String type) {
        if (type.equals("Northeast")) {
            states[NORTH_EAST_INDEX + 1] += 1;
        }
        if (type.equals("Southeast")) {
            states[SOUTH_EAST_INDEX + 1] += 1;
        }
        if (type.equals("United States (other than Southeast or Northwest)")) {
            states[REST_US_INDEX + 1] += 1;
        }
        if (type.equals("Outside of United States")) {
            states[OUTSIDE_US_INDEX + 1] += 1;
        }

    }

    /**
     * Gets the like tally for a certain major, hobby or state
     * 
     * @param type
     *            the major, hobby, or state to get the likes of
     * @return the like tally for the type passed in, or zero if the type does
     *         not exist
     */
    public int getLike(String type) {
        if (type.equals("Computer Science")) {
            return majors[CS_INDEX + 1];
        }
        if (type.equals("Other Engineering")) {
            return majors[ENGE_INDEX + 1];
        }
        if (type.equals("Math or CMDA")) {
            return majors[MATH_INDEX + 1];
        }
        if (type.equals("Other")) {
            return majors[OTHER_INDEX + 1];
        }
        if (type.equals("reading")) {
            return hobbies[READ_INDEX + 1];
        }
        if (type.equals("art")) {
            return hobbies[ART_INDEX + 1];
        }
        if (type.equals("sports")) {
            return hobbies[SPORT_INDEX + 1];
        }
        if (type.equals("music")) {
            return hobbies[MUSIC_INDEX + 1];
        }
        if (type.equals("Northeast")) {
            return states[NORTH_EAST_INDEX + 1];
        }
        if (type.equals("Southeast")) {
            return states[SOUTH_EAST_INDEX + 1];
        }
        if (type.equals("United States (other than Southeast or Northwest)")) {
            return states[REST_US_INDEX + 1];
        }
        if (type.equals("Outside of United States")) {
            return states[OUTSIDE_US_INDEX + 1];
        }
        return 0;
    }

    /**
     * Gets the heard tally for a certain major, hobby or state
     * 
     * @param type
     *            the major, hobby, or state to get the heard of
     * @return the heard tally for the type passed in, or zero if the type does
     *         not exist
     */
    public int getHeard(String type) {
        if (type.equals("Computer Science")) {
            return majors[CS_INDEX];
        }
        if (type.equals("Other Engineering")) {
            return majors[ENGE_INDEX];
        }
        if (type.equals("Math or CMDA")) {
            return majors[MATH_INDEX];
        }
        if (type.equals("Other")) {
            return majors[OTHER_INDEX];
        }
        if (type.equals("reading")) {
            return hobbies[READ_INDEX];
        }
        if (type.equals("art")) {
            return hobbies[ART_INDEX];
        }
        if (type.equals("sports")) {
            return hobbies[SPORT_INDEX];
        }
        if (type.equals("music")) {
            return hobbies[MUSIC_INDEX];
        }
        if (type.equals("Northeast")) {
            return states[NORTH_EAST_INDEX];
        }
        if (type.equals("Southeast")) {
            return states[SOUTH_EAST_INDEX];
        }
        if (type.equals("United States (other than Southeast or Northwest)")) {
            return states[REST_US_INDEX];
        }
        if (type.equals("Outside of United States")) {
            return states[OUTSIDE_US_INDEX];
        }
        return 0;
    }

    /**
     * Calculates the like percentages for 2 values passed in
     * 
     * @param like
     *            the number of likes for a type of students
     * @param total
     *            the total number of the type of students
     * @return likePercentage the calculated percentage
     */
    private int calculateLikePercentage(int like, int total) {
        if (total == 0) {
            likePercentage = 0;
            return likePercentage;
        }
        else {
            likePercentage = (int) (((double) like / (double) total) * 100);
        }
        return likePercentage;

    }

    /**
     * Calculates the heard percentages for each major based on the students
     * from that major who heard the song and the total number of students from
     * that major who answered the heard question
     */
    public void updateMajorsHeardPercentages() {
        int csLike = this.calculateHeardPercentage(
                this.getHeard("Computer Science"), totalStudents[0]);
        majorsPercentages[CS_INDEX] = csLike;
        int engeLike = this.calculateHeardPercentage(
                this.getHeard("Other Engineering"), totalStudents[1]);
        majorsPercentages[ENGE_INDEX] = engeLike;
        int mathLike = this.calculateHeardPercentage(
                this.getHeard("Math or CMDA"), totalStudents[2]);
        majorsPercentages[MATH_INDEX] = mathLike;
        int otherLike = this.calculateHeardPercentage(this.getHeard("Other"),
                totalStudents[3]);
        majorsPercentages[OTHER_INDEX] = otherLike;
    }

    /**
     * Calculates the like percentages for each major based on the students from
     * that major who liked the song and the total number of students from that
     * major who answered the like question
     */
    public void updateMajorsLikePercentages() {
        int csLike = this.calculateLikePercentage(
                this.getLike("Computer Science"), totalStudentsForLikes[0]);
        majorsPercentages[CS_INDEX + 1] = csLike;
        int engeLike = this.calculateLikePercentage(
                this.getLike("Other Engineering"), totalStudentsForLikes[1]);
        majorsPercentages[ENGE_INDEX + 1] = engeLike;
        int mathLike = this.calculateLikePercentage(
                this.getLike("Math or CMDA"), totalStudentsForLikes[2]);
        majorsPercentages[MATH_INDEX + 1] = mathLike;
        int otherLike = this.calculateLikePercentage(this.getLike("Other"),
                totalStudentsForLikes[3]);
        majorsPercentages[OTHER_INDEX + 1] = otherLike;
    }

    /**
     * Calculates the heard percentages for each hobby based on the students
     * from that hobby who heard the song and the total number of students from
     * that hobby who answered the heard question
     */
    public void updateHobbiesHeardPercentages() {
        int csLike = this.calculateHeardPercentage(this.getHeard("reading"),
                totalStudents[4]);
        hobbiesPercentages[READ_INDEX] = csLike;
        int engeLike = this.calculateHeardPercentage(this.getHeard("art"),
                totalStudents[5]);
        hobbiesPercentages[ART_INDEX] = engeLike;
        int mathLike = this.calculateHeardPercentage(this.getHeard("sports"),
                totalStudents[6]);
        hobbiesPercentages[SPORT_INDEX] = mathLike;
        int otherLike = this.calculateHeardPercentage(this.getHeard("music"),
                totalStudents[7]);
        hobbiesPercentages[MUSIC_INDEX] = otherLike;
    }

    /**
     * Calculates the like percentages for each hobby based on the students from
     * that hobby who liked the song and the total number of students from that
     * hobby who answered the like question
     */
    public void updateHobbiesLikePercentages() {
        int csLike = this.calculateLikePercentage(this.getLike("reading"),
                totalStudentsForLikes[4]);
        hobbiesPercentages[READ_INDEX + 1] = csLike;
        int engeLike = this.calculateLikePercentage(this.getLike("art"),
                totalStudentsForLikes[5]);
        hobbiesPercentages[ART_INDEX + 1] = engeLike;
        int mathLike = this.calculateLikePercentage(this.getLike("sports"),
                totalStudentsForLikes[6]);
        hobbiesPercentages[SPORT_INDEX + 1] = mathLike;
        int otherLike = this.calculateLikePercentage(this.getLike("music"),
                totalStudentsForLikes[7]);
        hobbiesPercentages[MUSIC_INDEX + 1] = otherLike;
    }

    /**
     * Calculates the heard percentages for each state based on the students
     * from that state who heard the song and the total number of students from
     * that state who answered the heard question
     */
    public void updateStatesHeardPercentages() {
        int csLike = this.calculateHeardPercentage(this.getHeard("Northeast"),
                totalStudents[8]);
        statesPercentages[NORTH_EAST_INDEX] = csLike;
        int engeLike = this.calculateHeardPercentage(this.getHeard("Southeast"),
                totalStudents[9]);
        statesPercentages[SOUTH_EAST_INDEX] = engeLike;
        int mathLike = this.calculateHeardPercentage(
                this.getHeard(
                        "United States (other than Southeast or Northwest)"),
                totalStudents[10]);
        statesPercentages[REST_US_INDEX] = mathLike;
        int otherLike = this.calculateHeardPercentage(
                this.getHeard("Outside of United States"), totalStudents[11]);
        statesPercentages[OUTSIDE_US_INDEX] = otherLike;
    }

    /**
     * Calculates the like percentages for each state based on the students from
     * that state who liked the song and the total number of students from that
     * state who answered the like question
     */
    public void updateStatesLikePercentages() {
        int csLike = this.calculateLikePercentage(this.getLike("Northeast"),
                totalStudentsForLikes[8]);
        statesPercentages[NORTH_EAST_INDEX + 1] = csLike;
        int engeLike = this.calculateLikePercentage(this.getLike("Southeast"),
                totalStudentsForLikes[9]);
        statesPercentages[SOUTH_EAST_INDEX + 1] = engeLike;
        int mathLike = this.calculateLikePercentage(
                this.getLike(
                        "United States (other than Southeast or Northwest)"),
                totalStudentsForLikes[10]);
        statesPercentages[REST_US_INDEX + 1] = mathLike;
        int otherLike = this.calculateLikePercentage(
                this.getLike("Outside of United States"),
                totalStudentsForLikes[11]);
        statesPercentages[OUTSIDE_US_INDEX + 1] = otherLike;
    }

    /**
     * Calculates the heard percentages for 2 values passed in
     * 
     * @param like
     *            the number of heard for a type of students
     * @param total
     *            the total number of the type of students
     * @return heardPercentage the calculated percentage
     */
    private int calculateHeardPercentage(int heard, int total) {
        if (total == 0) {
            heardPercentage = 0;
            return heardPercentage;

        }
        else {
            heardPercentage = (int) (((double) heard / (double) total) * 100);
        }
        return heardPercentage;
    }

    /**
     * Prints a string representation of the song, including the percentages for
     * the hobbies
     * 
     * @return a string representation of a song
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("song title " + this.getTitle() + "\n");
        builder.append("song artist " + this.getArtist() + "\n");
        builder.append("song genre " + this.getGenre() + "\n");
        builder.append("song year " + this.getDate() + "\n");
        builder.append("heard\n");
        builder.append("reading" + hobbiesPercentages[0] + " art"
                + hobbiesPercentages[2]);
        builder.append(" sports" + hobbiesPercentages[4] + " music"
                + hobbiesPercentages[6] + "\n");
        builder.append("likes\n");
        builder.append("reading" + hobbiesPercentages[1] + " art"
                + hobbiesPercentages[3]);
        builder.append(" sports" + hobbiesPercentages[5] + " music"
                + hobbiesPercentages[7]);
        builder.append("\n\n");
        return builder.toString();
    }

    /**
     * Gets the majors array
     * 
     * @return majors the integer array
     */
    public int[] getMajors() {
        return majors;
    }

    /**
     * Gets the hobbies array
     * 
     * @return hobbies the integer array
     */
    public int[] getHobbies() {
        return hobbies;
    }

    /**
     * Gets the states array
     * 
     * @return states the integer array
     */
    public int[] getStates() {
        return states;
    }
}
