import org.testng.annotations.Test;
import steps.LandingPageSteps;

public class TestCases extends BaseTest {
    LandingPageSteps landingPageSteps = new LandingPageSteps();

    @Test
    public void noteCanBeCreated() {
        logger.info("the note can be created");
        landingPageSteps.noteCanBeCreated();
    }

    @Test
    public void createdNoteTextIsCorrect() {
        logger.info("created note text is displays correctly");
        landingPageSteps.createdNoteTextIsCorrect();
    }

    @Test
    public void singleNoteCanBeDeleted() {
        logger.info("the single note can be deleted by destroy button");
        landingPageSteps.singleNoteCanBeDeleted();
    }

    @Test
    public void countOfNotesDisplaysCorrectly() {
        logger.info("count of notes in counter are equals to count of added rows ");
        landingPageSteps.countOfNotesDisplaysCorrectly();
    }

    @Test
    public void deleteNoteButtonIsDisplays() {
        logger.info("the delete note button is displays");
        landingPageSteps.deleteNoteButtonIsDisplays();
    }

    @Test
    public void multiplyNotesCanBeAdded() {
        logger.info("the multiply notes can be added to the list");
        landingPageSteps.multiplyNotesCanBeAdded();
    }

    @Test
    public void createdNoteCanBeEdited() {
        logger.info("the created note can be edited");
        landingPageSteps.createdNoteCanBeEdited();
    }

    @Test
    public void emptyNoteCannotBeAdded() {
        logger.info("empty input can't be added to the list");
        landingPageSteps.emptyNoteCannotBeAdded();
    }

    @Test
    public void specialCharactersDisplaysCorrectly() {
        logger.info("note with a special characters is displays");
        landingPageSteps.specialCharactersDisplaysCorrectly();
    }

    @Test
    public void duplicateNotesAreDisplays() {
        logger.info("duplicate notes are displays");
        landingPageSteps.duplicateNotesAreDisplays();
    }

    @Test
    public void editedNoteIsDeletedWhenFieldIsEmptyAndClickOutside() {
        logger.info("the edited note is deleted when leave the empty field and click outside");
        landingPageSteps.editedNoteIsDeletedWhenFieldIsEmptyAndClickOutside();
    }

    @Test
    public void longTextIsDisplaysCorrectly() {
        logger.info("note with long text is displays correctly");
        landingPageSteps.longTextIsDisplaysCorrectly();
    }

    @Test
    public void counterTextMatchCountOfRows(){
        logger.info("the counter text is match the count of rows");
        landingPageSteps.counterTextMatchCountOfRows();
    }
}