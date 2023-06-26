package steps;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.LandingPage;
import utils.PropertiesParser;
import utils.TextGenerator;

public class LandingPageSteps {
    LandingPage landingPage = new LandingPage();

    public void noteCanBeCreated() {
        landingPage.sendTextToInput(TextGenerator.randomText());
        landingPage.acceptInput();
        Assert.assertTrue(landingPage.createdNoteIsDisplayed
                (String.valueOf(PropertiesParser.getTestData().getFirstRow())), "Created note is displayed");
    }

    public void createdNoteTextIsCorrect() {
        String expectedText = TextGenerator.randomText();
        landingPage.sendTextToInput(expectedText);
        landingPage.acceptInput();
        Assert.assertEquals(landingPage.getCreatedNoteText
                (String.valueOf(PropertiesParser.getTestData().getFirstRow())), expectedText, "Note text is not equals to expected");
    }

    public void countOfNotesDisplaysCorrectly() {
        landingPage.sendTextToInput(TextGenerator.randomText());
        landingPage.acceptInput();
        landingPage.sendTextToInput(TextGenerator.randomText());
        landingPage.acceptInput();
        Assert.assertEquals(landingPage.getCountOfNotes(),
                String.valueOf(PropertiesParser.getTestData().getTwoRowsCounter()), "Number of notes in counter is not correct");
    }

    public void deleteNoteButtonIsDisplays() {
        landingPage.sendTextToInput(TextGenerator.randomText());
        landingPage.acceptInput();
        landingPage.hoverTheCreatedNote(String.valueOf(PropertiesParser.getTestData().getFirstRow()));
        Assert.assertTrue(landingPage.destroyButtonIsDisplayed
                (String.valueOf(PropertiesParser.getTestData().getFirstRow())), "Destroy note button is not displayed");
    }

    public void singleNoteCanBeDeleted() {
        landingPage.sendTextToInput(TextGenerator.randomText());
        landingPage.acceptInput();
        landingPage.sendTextToInput(TextGenerator.randomText());
        landingPage.acceptInput();
        landingPage.hoverTheCreatedNote(String.valueOf(PropertiesParser.getTestData().getFirstRow()));
        landingPage.clickOnDestroyButton(String.valueOf(PropertiesParser.getTestData().getFirstRow()));
        Assert.assertEquals(landingPage.getCountOfNotes(),
                String.valueOf(PropertiesParser.getTestData().getFirstRow()), "Count of notes is not equals to expected");
    }

    public void multiplyNotesCanBeAdded() {
        landingPage.sendTextToInput(TextGenerator.randomText());
        landingPage.acceptInput();
        landingPage.sendTextToInput(TextGenerator.randomText());
        landingPage.acceptInput();
        landingPage.sendTextToInput(TextGenerator.randomText());
        landingPage.acceptInput();
        landingPage.sendTextToInput(TextGenerator.randomText());
        landingPage.acceptInput();
        Assert.assertEquals(landingPage.getCountOfNotes(),
                String.valueOf(PropertiesParser.getTestData().getFourRowsCounter()), "Count of notes is not equals to expected");
    }

    public void createdNoteCanBeEdited() {
        landingPage.sendTextToInput(TextGenerator.randomText());
        landingPage.acceptInput();
        landingPage.editCreatedNote(String.valueOf(PropertiesParser.getTestData().getFirstRow()));
        landingPage.clearEditNoteInputField(String.valueOf(PropertiesParser.getTestData().getFirstRow()));
        String editedText = TextGenerator.randomText();
        landingPage.sendTextToEditNote(String.valueOf(PropertiesParser.getTestData().getFirstRow()), editedText);
        landingPage.acceptEditedField(String.valueOf(PropertiesParser.getTestData().getFirstRow()));
        Assert.assertEquals(landingPage.getCreatedNoteText
                (String.valueOf(PropertiesParser.getTestData().getFirstRow())), editedText, "Note text is not equals to expected");
    }

    public void emptyNoteCannotBeAdded() {
        landingPage.sendTextToInput("");
        landingPage.acceptInput();
        Assert.assertFalse(landingPage.createdNoteIsDisplayed
                (String.valueOf(PropertiesParser.getTestData().getFirstRow())), "Created note is not displayed");
    }

    public void specialCharactersDisplaysCorrectly() {
        String specialCharacters = TextGenerator.randomSpecialCharacters();
        landingPage.sendTextToInput(specialCharacters);
        landingPage.acceptInput();
        Assert.assertTrue(landingPage.createdNoteIsDisplayed
                (String.valueOf(PropertiesParser.getTestData().getFirstRow())), "Created note is not displayed");
        Assert.assertEquals(landingPage.getCreatedNoteText
                (String.valueOf(PropertiesParser.getTestData().getFirstRow())), specialCharacters, "Note text is not equals to expected");
    }

    public void longTextIsDisplaysCorrectly() {
        SoftAssert softAssert = new SoftAssert();
        String longText = TextGenerator.randomLongText();
        landingPage.sendTextToInput(longText);
        landingPage.acceptInput();
        softAssert.assertTrue(landingPage.createdNoteIsDisplayed
                (String.valueOf(PropertiesParser.getTestData().getFirstRow())), "Created note is not displayed");
        softAssert.assertEquals(landingPage.getCreatedNoteText
                (String.valueOf(PropertiesParser.getTestData().getFirstRow())), longText, "Note text is not equals to expected");
        softAssert.assertAll();
    }

    public void duplicateNotesAreDisplays() {
        landingPage.sendTextToInput(TextGenerator.generateText());
        landingPage.acceptInput();
        landingPage.sendTextToInput(TextGenerator.generateText());
        landingPage.acceptInput();
        Assert.assertEquals(landingPage.getCountOfNotes(),
                String.valueOf(PropertiesParser.getTestData().getTwoRowsCounter()), "Count of notes is not equals to expected");
    }

    public void editedNoteIsDeletedWhenFieldIsEmptyAndClickOutside() {
        landingPage.sendTextToInput(TextGenerator.generateText());
        landingPage.acceptInput();
        landingPage.editCreatedNote(String.valueOf(PropertiesParser.getTestData().getFirstRow()));
        landingPage.clearEditNoteInputField(String.valueOf(PropertiesParser.getTestData().getFirstRow()));
        landingPage.focusOnNextElement(String.valueOf(PropertiesParser.getTestData().getFirstRow()));
        Assert.assertFalse(landingPage.createdNoteIsDisplayed
                (String.valueOf(PropertiesParser.getTestData().getFirstRow())), "Empty note is displayed");
    }

    public void counterTextMatchCountOfRows(){
        landingPage.sendTextToInput(TextGenerator.generateText());
        landingPage.acceptInput();
        Assert.assertTrue(landingPage.getCounterText().contains
                (PropertiesParser.getTestData().getCounterTextWithOneRow()), "Counter text is not match number of rows");
        landingPage.sendTextToInput(TextGenerator.generateText());
        landingPage.acceptInput();
        Assert.assertTrue(landingPage.getCounterText().contains
                (PropertiesParser.getTestData().getCounterTextWithSomeRows()), "Counter text is not match number of rows");
    }
}