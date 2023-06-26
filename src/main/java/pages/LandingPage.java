package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utils.PropertiesParser;

import java.util.Objects;

public class LandingPage extends Form {
    private final int firstCountElement = Objects.requireNonNull(PropertiesParser.getTestData()).getFirstCountElement();
    private final int lastCountElement = PropertiesParser.getTestData().getLastCountElement();

    public LandingPage() {
        super(By.xpath("//section[@class='todoapp']"), "Header");
    }

    private final ITextBox notesCount = getElementFactory().getTextBox
            (By.xpath("//span[@class='todo-count']"), "Count of notes");
    private final ITextBox fieldInput = getElementFactory().getTextBox
            (By.xpath("//input[@placeholder='What needs to be done?']"), "Input field");

    private ITextBox createdNote(int count) {
        return getElementFactory().getTextBox(By.xpath(String.format("(//div[@class='view'])[%d]", count)), "Note input field");
    }

    private IButton destroyButton(int count) {
        return getElementFactory().getButton
                (By.xpath(String.format("(//button[@class='destroy'])[%d]", count)), "Destroy button");
    }

    private ITextBox editedNote(int count) {
        return getElementFactory().getTextBox
                (By.xpath(String.format("(//input[@class='edit'])[%d]", count)), "Edited not input");
    }

    public String getCountOfNotes() {
        return notesCount.getText().substring(firstCountElement, lastCountElement);
    }

    public String getCounterText() {
        return notesCount.getText();
    }

    public void sendTextToInput(String text) {
        fieldInput.sendKeys(text);
    }

    public void acceptInput() {
        fieldInput.sendKeys(Keys.ENTER);
    }

    public boolean createdNoteIsDisplayed(int count) {
        return createdNote(count).state().isDisplayed();
    }

    public String getCreatedNoteText(int count) {
        return createdNote(count).getText();
    }

    public void editCreatedNote(int count) {
        createdNote(count).getMouseActions().doubleClick();
    }

    public void clearEditNoteInputField(int count) {
        String aLetter = "a";
        editedNote(count).sendKeys(Keys.chord(Keys.CONTROL + aLetter));
        editedNote(count).sendKeys(Keys.DELETE);
    }

    public void acceptEditedField(int count) {
        editedNote(count).sendKeys(Keys.ENTER);
    }

    public void focusOnNextElement(int count) {
        editedNote(count).sendKeys(Keys.TAB);
    }

    public void sendTextToEditNote(int count, String text) {
        editedNote(count).sendKeys(text);
    }

    public boolean destroyButtonIsDisplayed(int count) {
        return destroyButton(count).state().isDisplayed();
    }

    public void hoverTheCreatedNote(int count) {
        createdNote(count).getMouseActions().moveMouseToElement();
    }

    public void clickOnDestroyButton(int count) {
        destroyButton(count).click();
    }
}