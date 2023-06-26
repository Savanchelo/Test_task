package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LandingPage extends Form {

    private final ITextBox notesCount = getElementFactory().getTextBox
            (By.xpath("//span[@class='todo-count']"), "Count of notes");
    private final ITextBox fieldInput = getElementFactory().getTextBox
            (By.xpath("//input[@placeholder='What needs to be done?']"), "Input field");

    private ITextBox createdNote(String count) {
        return getElementFactory().getTextBox(By.xpath(String.format("(//div[@class='view'])[%s]", count)), "Note input field");
    }

    private IButton destroyButton(String count) {
        return getElementFactory().getButton
                (By.xpath(String.format("(//button[@class='destroy'])[%s]", count)), "Destroy button");
    }
    private ITextBox editedNote(String count) {
       return getElementFactory().getTextBox
                (By.xpath(String.format("(//input[@class='edit'])[%s]", count)), "Edited not input");
    }

    public LandingPage() {
        super(By.xpath("//section[@class='todoapp']"), "Header");
    }

    public String getCountOfNotes() {
        return notesCount.getText().substring(0, 1);
    }

    public String getCounterText(){
        return notesCount.getText();
    }

    public void sendTextToInput(String text) {
        fieldInput.sendKeys(text);
    }

    public void acceptInput() {
        fieldInput.sendKeys(Keys.ENTER);
    }

    public boolean createdNoteIsDisplayed(String count) {
        return createdNote(count).state().isDisplayed();
    }

    public String getCreatedNoteText(String count) {
        return createdNote(count).getText();
    }

    public void editCreatedNote(String count) {
        createdNote(count).getMouseActions().doubleClick();
    }

    public void clearEditNoteInputField(String count) {
        editedNote(count).sendKeys(Keys.chord(Keys.CONTROL + "a"));
        editedNote(count).sendKeys(Keys.DELETE);
    }

    public void acceptEditedField(String count) {
        editedNote(count).sendKeys(Keys.ENTER);
    }

    public void focusOnNextElement(String count) {
        editedNote(count).sendKeys(Keys.TAB);
    }

    public void sendTextToEditNote(String count, String text) {
        editedNote(count).sendKeys(text);
    }

    public boolean destroyButtonIsDisplayed(String count) {
        return destroyButton(count).state().isDisplayed();
    }

    public void hoverTheCreatedNote(String count) {
        createdNote(count).getMouseActions().moveMouseToElement();
    }

    public void clickOnDestroyButton(String count) {
        destroyButton(count).click();
    }
}