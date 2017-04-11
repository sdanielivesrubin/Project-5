package prj5;

import student.TestCase;

/**
 * Song Test Class
 * 
 * @author Yasmine Belghith (byasmine)
 * @version 11/09/2016
 *
 */
public class SongTest extends TestCase {

    private Song song;

    /**
     * Sets up all test methods
     */
    public void setUp() {
        song = new Song("Banana Pancakes", "Jack Johnson", "Accoustic", "2008");
    }

    /**
     * Checks if the method return the correct title
     */
    public void testGetTitle() {
        assertEquals("Banana Pancakes", song.getTitle());
    }

    /**
     * Checks if the method return the correct artist
     */
    public void testGetArtist() {
        assertEquals("Jack Johnson", song.getArtist());
    }

    /**
     * Checks if the method return the correct genre
     */
    public void testGetGenre() {
        assertEquals("Accoustic", song.getGenre());
    }

    /**
     * Checks if the method return the correct date
     */
    public void testGetDate() {
        assertEquals("2008", song.getDate());
    }

    /**
     * Checks that the majors array gets updated correctly for the heard values
     */
    public void testUpdateHeardMajors() {
        song.updateHeardMajors("Computer Science");
        assertEquals(1, song.getMajors()[0]);
        song.updateHeardMajors("Other Engineering");
        assertEquals(1, song.getMajors()[2]);
        song.updateHeardMajors("Math or CMDA");
        assertEquals(1, song.getMajors()[4]);
        song.updateHeardMajors("Other");
        assertEquals(1, song.getMajors()[6]);
        song.updateHeardMajors("CompSci");
        assertEquals(1, song.getMajors()[0]);
    }

    /**
     * Checks that the majors array gets updated correctly for the like values
     */
    public void testUpdateLikeMajors() {
        song.updateLikeMajors("Computer Science");
        assertEquals(1, song.getMajors()[1]);
        song.updateLikeMajors("Other Engineering");
        assertEquals(1, song.getMajors()[3]);
        song.updateLikeMajors("Math or CMDA");
        assertEquals(1, song.getMajors()[5]);
        song.updateLikeMajors("Other");
        assertEquals(1, song.getMajors()[7]);
        song.updateLikeMajors("Others");
        assertEquals(1, song.getMajors()[7]);
    }

    /**
     * Checks that the hobbies array gets updated correctly for the heard values
     */
    public void testUpdateHeardHobbies() {
        song.updateHeardHobbies("reading");
        assertEquals(1, song.getHobbies()[0]);
        assertEquals(1, song.getHeard("reading"));
        song.updateHeardHobbies("art");
        assertEquals(1, song.getHobbies()[2]);
        song.updateHeardHobbies("sports");
        assertEquals(1, song.getHobbies()[4]);
        song.updateHeardHobbies("music");
        assertEquals(1, song.getHobbies()[6]);
        song.updateHeardHobbies("musics");
        assertEquals(1, song.getHobbies()[6]);
    }

    /**
     * Checks that the hobbies array gets updated correctly for the like values
     */
    public void testUpdateLikeHobbies() {
        song.updateLikeHobbies("reading");
        assertEquals(1, song.getHobbies()[1]);
        song.updateLikeHobbies("art");
        assertEquals(1, song.getHobbies()[3]);
        song.updateLikeHobbies("sports");
        assertEquals(1, song.getHobbies()[5]);
        song.updateLikeHobbies("sport");
        assertEquals(1, song.getHobbies()[5]);
        song.updateLikeHobbies("music");
        assertEquals(1, song.getHobbies()[7]);

    }

    /**
     * Checks that the states array gets updated correctly for the heard values
     */
    public void testUpdateHeardStates() {
        song.updateHeardStates("Northeast");
        assertEquals(1, song.getStates()[0]);
        song.updateHeardStates("Southeast");
        assertEquals(1, song.getStates()[2]);
        song.updateHeardStates(
                "United States (other than Southeast or Northwest)");
        assertEquals(1, song.getStates()[4]);
        song.updateHeardStates("Outside of United States");
        assertEquals(1, song.getStates()[6]);
    }

    /**
     * Checks that the states array gets updated correctly for the like values
     */
    public void testUpdateLikeStates() {
        song.updateLikeStates("Northeast");
        assertEquals(1, song.getStates()[1]);
        assertEquals(1, song.getLike("Northeast"));
        song.updateLikeStates("Southeast");
        assertEquals(1, song.getStates()[3]);
        song.updateLikeStates(
                "United States (other than Southeast or Northwest)");
        assertEquals(1, song.getStates()[5]);
        song.updateLikeStates("Outside of United States");
        assertEquals(1, song.getStates()[7]);
        song.updateLikeStates("Outside of US");
        assertEquals(1, song.getStates()[7]);
    }

    /**
     * Checks that getLike returns the correct value when called with different
     * arguments
     */
    public void testGetLike() {
        assertEquals(0, song.getLike("Computer Science"));
        assertEquals(0, song.getLike("Other Engineering"));
        assertEquals(0, song.getLike("Math or CMDA"));
        assertEquals(0, song.getLike("Other"));
        assertEquals(0, song.getLike("read"));
        assertEquals(0, song.getLike("art"));
        assertEquals(0, song.getLike("sports"));
        assertEquals(0, song.getLike("music"));
        assertEquals(0, song.getLike("Northeast"));
        assertEquals(0, song.getLike("Southeast"));
        assertEquals(0, song
                .getLike("United States (other than Southeast or Northwest)"));
        assertEquals(0, song.getLike("Outside of United States"));
        assertEquals(0, song.getLike("CompSci"));
    }

    /**
     * Checks that getHeard returns the correct value when called with different
     * arguments
     */
    public void testGetHeard() {
        assertEquals(0, song.getHeard("Computer Science"));
        assertEquals(0, song.getHeard("Other Engineering"));
        assertEquals(0, song.getHeard("Math or CMDA"));
        assertEquals(0, song.getHeard("Other"));
        assertEquals(0, song.getHeard("read"));
        assertEquals(0, song.getHeard("art"));
        assertEquals(0, song.getHeard("sports"));
        assertEquals(0, song.getHeard("music"));
        assertEquals(0, song.getHeard("Northeast"));
        assertEquals(0, song.getHeard("Southeast"));
        assertEquals(0, song
                .getHeard("United States (other than Southeast or Northwest)"));
        assertEquals(0, song.getHeard("Outside of United States"));
        assertEquals(0, song.getHeard("CompSci"));
    }

    /**
     * Checks if toString returns the expected value
     */
    public void testToString() {
        assertEquals("song title Banana Pancakes\n"
                + "song artist Jack Johnson\nsong genre Accoustic\nsong year "
                + "2008\nheard\nreading0 art0 sports0 music0\nlikes\nreading0 "
                + "art0 sports0 music0\n\n", song.toString());
    }

    /**
     * Checks that the number of students gets incremented correctly
     */
    public void testUpdateTotalStudents() {
        song.updateTotalStudents("Computer Science");
        assertEquals(1, song.totalStudents[0]);
        song.updateTotalStudents("Other Engineering");
        assertEquals(1, song.totalStudents[1]);
        song.updateTotalStudents("Math or CMDA");
        assertEquals(1, song.totalStudents[2]);
        song.updateTotalStudents("Other");
        assertEquals(1, song.totalStudents[3]);
        song.updateTotalStudents("reading");
        assertEquals(1, song.totalStudents[4]);
        song.updateTotalStudents("art");
        assertEquals(1, song.totalStudents[5]);
        song.updateTotalStudents("sports");
        assertEquals(1, song.totalStudents[6]);
        song.updateTotalStudents("music");
        assertEquals(1, song.totalStudents[7]);
        song.updateTotalStudents("Northeast");
        assertEquals(1, song.totalStudents[8]);
        song.updateTotalStudents("Southeast");
        assertEquals(1, song.totalStudents[9]);
        song.updateTotalStudents(
                "United States (other than Southeast or Northwest)");
        assertEquals(1, song.totalStudents[10]);
        song.updateTotalStudents("Outside of United States");
        assertEquals(1, song.totalStudents[11]);
        song.updateTotalStudents("CompSci");
        assertEquals(1, song.totalStudents[0]);
    }

    /**
     * Checks that the number of students gets incremented correctly
     */
    public void updateTotalStudentsForLikes() {
        song.updateTotalStudentsForLikes("Computer Science");
        assertEquals(1, song.totalStudentsForLikes[0]);
        song.updateTotalStudentsForLikes("Other Engineering");
        assertEquals(1, song.totalStudentsForLikes[1]);
        song.updateTotalStudentsForLikes("Math or CMDA");
        assertEquals(1, song.totalStudentsForLikes[2]);
        song.updateTotalStudentsForLikes("Other");
        assertEquals(1, song.totalStudentsForLikes[3]);
        song.updateTotalStudentsForLikes("reading");
        assertEquals(1, song.totalStudentsForLikes[4]);
        song.updateTotalStudentsForLikes("art");
        assertEquals(1, song.totalStudentsForLikes[5]);
        song.updateTotalStudentsForLikes("sports");
        assertEquals(1, song.totalStudentsForLikes[6]);
        song.updateTotalStudentsForLikes("music");
        assertEquals(1, song.totalStudentsForLikes[7]);
        song.updateTotalStudentsForLikes("Northeast");
        assertEquals(1, song.totalStudentsForLikes[8]);
        song.updateTotalStudentsForLikes("Southeast");
        assertEquals(1, song.totalStudentsForLikes[9]);
        song.updateTotalStudentsForLikes(
                "United States (other than Southeast or Northwest)");
        assertEquals(1, song.totalStudentsForLikes[10]);
        song.updateTotalStudentsForLikes("Outside of United States");
        assertEquals(1, song.totalStudentsForLikes[11]);
        song.updateTotalStudentsForLikes("CompSci");
        assertEquals(1, song.totalStudentsForLikes[0]);
    }

    /**
     * Checks that the percentages are calculated correctly
     */
    public void testUpdateMajorsHeardPercentages() {
        assertEquals(0, song.majorsPercentages[0]);
        assertEquals(0, song.majorsPercentages[2]);
        assertEquals(0, song.majorsPercentages[4]);
        assertEquals(0, song.majorsPercentages[6]);
    }

    /**
     * Checks that the percentages are calculated correctly
     */
    public void testUpdateMajorsLikePercentages() {
        assertEquals(0, song.majorsPercentages[1]);
        assertEquals(0, song.majorsPercentages[3]);
        assertEquals(0, song.majorsPercentages[5]);
        assertEquals(0, song.majorsPercentages[7]);
    }

    /**
     * Checks that the percentages are calculated correctly
     */
    public void testUpdateHobbiesHeardPercentages() {
        assertEquals(0, song.hobbiesPercentages[0]);
        assertEquals(0, song.hobbiesPercentages[2]);
        assertEquals(0, song.hobbiesPercentages[4]);
        assertEquals(0, song.hobbiesPercentages[6]);
    }

    /**
     * Checks that the percentages are calculated correctly
     */
    public void testUpdateHobbiesLikePercentages() {
        assertEquals(0, song.hobbiesPercentages[1]);
        assertEquals(0, song.hobbiesPercentages[3]);
        assertEquals(0, song.hobbiesPercentages[5]);
        assertEquals(0, song.hobbiesPercentages[7]);
    }

    /**
     * Checks that the percentages are calculated correctly
     */
    public void testUpdateStatesHeardPercentages() {
        assertEquals(0, song.statesPercentages[0]);
        assertEquals(0, song.statesPercentages[2]);
        assertEquals(0, song.statesPercentages[4]);
        assertEquals(0, song.statesPercentages[6]);
    }

    /**
     * Checks that the percentages are calculated correctly
     */
    public void testUpdateStatesLikePercentages() {
        assertEquals(0, song.statesPercentages[1]);
        assertEquals(0, song.statesPercentages[3]);
        assertEquals(0, song.statesPercentages[5]);
        assertEquals(0, song.statesPercentages[7]);
    }
}
