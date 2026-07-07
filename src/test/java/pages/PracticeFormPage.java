package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.TableResultsComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {
    CalendarComponent calendar = new CalendarComponent();
    TableResultsComponent tableResults = new TableResultsComponent();

    private final SelenideElement userFirstNameInput = $("#firstName");
    private final SelenideElement userLastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement genterWrapperInput = $("#genterWrapper");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbyInput = $("#hobbiesWrapper");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement addressInput = $("#currentAddress");
    private final SelenideElement stateCityContainer = $("#stateCity-wrapper");
    private final SelenideElement stateSelector = $("#state");
    private final SelenideElement citySelector = $("#city");


    @Step ("Open registration form \"{value}\"")
    public PracticeFormPage openPage(String value) {
        open(value);
        return this;
    }

    @Step ("Type first user name \"{value}\"")
    public PracticeFormPage typeFirstUserName(String value) {
        userFirstNameInput.val(value);
        return this;
    }

    @Step ("Type last user name \"{value}\"")
    public PracticeFormPage typeLastUserName(String value) {
        userLastNameInput.val(value);
        return this;
    }

    @Step ("Type user email \"{value}\"")
    public PracticeFormPage typeUserEmail(String value) {
        userEmailInput.val(value);
        return this;
    }

    @Step ("Type user number \"{value}\"")
    public PracticeFormPage typeUserNumber(String value) {
        userNumberInput.val(value);
        return this;
    }

    @Step ("Set gender \"{value}\"")
    public PracticeFormPage setGender(String value) {
        genterWrapperInput.$(byText(value)).click();
        return this;
    }

    @Step ("Set date of birth")
    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    @Step ("Set subject \"{value}\"")
    public PracticeFormPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    @Step ("Type hobby \"{value}\"")
    public PracticeFormPage typeHobby(String value) {
        hobbyInput.$(byText(value)).click();
        return this;
    }

    @Step ("Upload picture")
    public PracticeFormPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    @Step ("Type address")
    public PracticeFormPage typeAddress(String value) {
        addressInput.val(value);
        return this;
    }

    @Step ("Set state")
    public PracticeFormPage setState(String value) {
        stateSelector.click();
        stateCityContainer.$(byText(value)).click();
        return this;
    }

    @Step ("Set city")
    public PracticeFormPage setCity(String value) {
        citySelector.click();
        stateCityContainer.$(byText(value)).click();
        return this;
    }

    @Step ("Set state and city")
    public PracticeFormPage setStateAndCity(String state, String city) {
        setState(state);
        setCity(city);
        return this;
    }

    @Step ("Submit form")
    public PracticeFormPage submitForm() {
        submitButton.click();
        return this;
    }

    @Step ("Check field \"{label}\" has relult  \"{value}\"")
    public PracticeFormPage checkField(String label, String value) {
        tableResults.checkField(label, value);
        return this;
    }

    @Step ("Check field not visible")
    public PracticeFormPage checkFieldNotVisible() {
        tableResults.checkFieldNotVisible();
        return this;
    }
}
