package steps;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.LandingPage;
import utils.PropertiesParser;
import utils.TextGenerator;

import java.util.Objects;

public class LandingPageSteps {
    private static final LandingPage landingPage = new LandingPage();
    private static final int firstRow = Objects.requireNonNull(PropertiesParser.getTestData()).getFirstRow();
    private static final String oneRowCounter = String.valueOf(PropertiesParser.getTestData().getOneRowCounter());
    private static final String twoRowsCounter = String.valueOf(PropertiesParser.getTestData().getTwoRowsCounter());
    private static final String fourRowsCounter = String.valueOf(PropertiesParser.getTestData().getFourRowsCounter());
    private static final String counterTextWithOneRow = PropertiesParser.getTestData().getCounterTextWithOneRow();
    private static final String counterTextWithSomeRows = PropertiesParser.getTestData().getCounterTextWithSomeRows();

    private LandingPageSteps() {
    }

    public static void noteCanBeCreated() {
        landingPage.sendTextToInput(TextGenerator.randomText());
        landingPage.acceptInput();
        Assert.assertTrue(landingPage.createdNoteIsDisplayed(firstRow), "Created note is displayed");
    }

    public static void createdNoteTextIsCorrect() {
        String expectedText = TextGenerator.randomText();
        landingPage.sendTextToInput(expectedText);
        landingPage.acceptInput();
        Assert.assertEquals(landingPage.getCreatedNoteText(firstRow), expectedText, "Note text is not equals to expected");
    }

    public static void countOfNotesDisplaysCorrectly() {
        landingPage.sendTextToInput(TextGenerator.randomText());
        landingPage.acceptInput();
        landingPage.sendTextToInput(TextGenerator.randomText());
        landingPage.acceptInput();
        Assert.assertEquals(landingPage.getCountOfNotes(), twoRowsCounter, "Number of notes in counter is not correct");
    }

    public static void deleteNoteButtonIsDisplays() {
        landingPage.sendTextToInput(TextGenerator.randomText());
        landingPage.acceptInput();
        landingPage.hoverTheCreatedNote(firstRow);
        Assert.assertTrue(landingPage.destroyButtonIsDisplayed(firstRow), "Destroy note button is not displayed");
    }

    public static void singleNoteCanBeDeleted() {
        landingPage.sendTextToInput(TextGenerator.randomText());
        landingPage.acceptInput();
        landingPage.sendTextToInput(TextGenerator.randomText());
        landingPage.acceptInput();
        landingPage.hoverTheCreatedNote(firstRow);
        landingPage.clickOnDestroyButton(firstRow);
        Assert.assertEquals(landingPage.getCountOfNotes(), oneRowCounter, "Count of notes is not equals to expected");
    }

    public static void multiplyNotesCanBeAdded() {
        landingPage.sendTextToInput(TextGenerator.randomText());
        landingPage.acceptInput();
        landingPage.sendTextToInput(TextGenerator.randomText());
        landingPage.acceptInput();
        landingPage.sendTextToInput(TextGenerator.randomText());
        landingPage.acceptInput();
        landingPage.sendTextToInput(TextGenerator.randomText());
        landingPage.acceptInput();
        Assert.assertEquals(landingPage.getCountOfNotes(), fourRowsCounter, "Count of notes is not equals to expected");
    }

    public static void createdNoteCanBeEdited() {
        landingPage.sendTextToInput(TextGenerator.randomText());
        landingPage.acceptInput();
        landingPage.editCreatedNote(firstRow);
        landingPage.clearEditNoteInputField(firstRow);
        String editedText = TextGenerator.randomText();
        landingPage.sendTextToEditNote(firstRow, editedText);
        landingPage.acceptEditedField(firstRow);
        Assert.assertEquals(landingPage.getCreatedNoteText(firstRow), editedText, "Note text is not equals to expected");
    }

    public static void emptyNoteCannotBeAdded() {
        landingPage.sendTextToInput("");
        landingPage.acceptInput();
        Assert.assertFalse(landingPage.createdNoteIsDisplayed(firstRow), "Created note is not displayed");
    }

    public static void specialCharactersDisplaysCorrectly() {
        String specialCharacters = TextGenerator.randomSpecialCharacters();
        landingPage.sendTextToInput(specialCharacters);
        landingPage.acceptInput();
        Assert.assertTrue(landingPage.createdNoteIsDisplayed(firstRow), "Created note is not displayed");
        Assert.assertEquals(landingPage.getCreatedNoteText(firstRow), specialCharacters, "Note text is not equals to expected");
    }

    public static void longTextIsDisplaysCorrectly() {
        SoftAssert softAssert = new SoftAssert();
        String longText = TextGenerator.randomLongText();
        landingPage.sendTextToInput(longText);
        landingPage.acceptInput();
        softAssert.assertTrue(landingPage.createdNoteIsDisplayed(firstRow), "Created note is not displayed");
        softAssert.assertEquals(landingPage.getCreatedNoteText(firstRow), longText, "Note text is not equals to expected");
        softAssert.assertAll();
    }

    public static void duplicateNotesAreDisplays() {
        landingPage.sendTextToInput(TextGenerator.generateText());
        landingPage.acceptInput();
        landingPage.sendTextToInput(TextGenerator.generateText());
        landingPage.acceptInput();
        Assert.assertEquals(landingPage.getCountOfNotes(), twoRowsCounter, "Count of notes is not equals to expected");
    }

    public static void editedNoteIsDeletedWhenFieldIsEmptyAndClickOutside() {
        landingPage.sendTextToInput(TextGenerator.generateText());
        landingPage.acceptInput();
        landingPage.editCreatedNote(firstRow);
        landingPage.clearEditNoteInputField(firstRow);
        landingPage.focusOnNextElement(firstRow);
        Assert.assertFalse(landingPage.createdNoteIsDisplayed(firstRow), "Empty note is displayed");
    }

    public static void counterTextMatchCountOfRows() {
        landingPage.sendTextToInput(TextGenerator.generateText());
        landingPage.acceptInput();
        Assert.assertTrue(landingPage.getCounterText().contains(counterTextWithOneRow), "Counter text is not match number of rows");
        landingPage.sendTextToInput(TextGenerator.generateText());
        landingPage.acceptInput();
        Assert.assertTrue(landingPage.getCounterText().contains(counterTextWithSomeRows), "Counter text is not match number of rows");
    }
}