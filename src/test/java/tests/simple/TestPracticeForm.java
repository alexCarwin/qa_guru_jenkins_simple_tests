package tests.simple;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static io.qameta.allure.Allure.step;
import static tests.simple.testdata.TestData.*;


@Story("Registration form")
public class TestPracticeForm extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    //Позитивный сценарий
    @Test
    @DisplayName("Successful Registration")
    void SuccessfulRegistrationFormTest() {

        step("Open registration page", () ->
                practiceFormPage.openPage(practiceFormUrl));
        step("Fill registration form", () -> {
            practiceFormPage
                    .typeFirstUserName(testData.firstName)
                    .typeLastUserName(testData.lastName)
                    .typeUserEmail(testData.userEmail)
                    .setGender(testData.gender)
                    .typeUserNumber(testData.userNumber)
                    .setDateOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                    .setSubject(testData.subjectsInput)
                    .typeHobby(testData.hobby)
                    .uploadPicture(imageName)
                    .typeAddress(testData.currentAddress)
                    .setStateAndCity(testData.state, testData.city)
                    .submitForm();
        });
        step("Check registration form results", () -> {
            practiceFormPage
                    .checkField("Student Name", testData.firstName + " " + testData.lastName)
                    .checkField("Student Email", testData.userEmail)
                    .checkField("Gender", testData.gender)
                    .checkField("Mobile", testData.userNumber)
                    .checkField("Date of Birth", testData.dayOfBirth + " " + testData.monthOfBirth + "," + testData.yearOfBirth)
                    .checkField("Subjects", testData.subjectsInput)
                    .checkField("Hobbies", testData.hobby)
                    .checkField("Picture", imageName)
                    .checkField("Address", testData.currentAddress)
                    .checkField("State and City", testData.state + " " + testData.city);
        });
    }


    //Негативный сценарий
    @Test
    @DisplayName("Failed Registration")
    void FailedRegistrationFormTest() {

        step("Open registration page", () ->
                practiceFormPage
                        .openPage(practiceFormUrl));
        step("Fill registration form", () -> {
            practiceFormPage
                    .typeFirstUserName(testData.firstName)
                    .typeLastUserName(testData.lastName)
                    .typeUserEmail(testData.userEmail)
                    .setGender(testData.gender)
                    .typeUserNumber(testData.userNumber)
                    .setDateOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                    .setSubject(testData.subjectsInput)
                    .typeHobby(testData.hobby)
                    .uploadPicture(imageName)
                    .typeAddress(testData.currentAddress)
                    .setStateAndCity(testData.state, testData.city)
                    .submitForm();
        });
        step("Check registration form results", () -> {
            practiceFormPage
                    .checkField("Student Name", testData.firstName + " BROKEN" + testData.lastName)
                    .checkField("Student Email", testData.userEmail)
                    .checkField("Gender", testData.gender)
                    .checkField("Mobile", testData.userNumber)
                    .checkField("Date of Birth", testData.dayOfBirth + " " + testData.monthOfBirth + "," + testData.yearOfBirth)
                    .checkField("Subjects", testData.subjectsInput)
                    .checkField("Hobbies", testData.hobby)
                    .checkField("Picture", imageName)
                    .checkField("Address", testData.currentAddress)
                    .checkField("State and City", testData.state + " " + testData.city);
        });
    }

    //Позитивный сценарий 2
    @Test
    void PositiveOnlyRequiredFieldsTest() {

        practiceFormPage
                .openPage(practiceFormUrl)
                .typeFirstUserName(testData.firstName)
                .typeLastUserName(testData.lastName)
                .setGender(testData.gender)
                .typeUserNumber(testData.userNumber)
                .submitForm()
                .checkField("Student Name", testData.firstName + " " + testData.lastName)
                .checkField("Gender", testData.gender)
                .checkField("Mobile", testData.userNumber);
    }

//    //Негативный сценарий: вводим только имя и фамилию
//    @Test
//    void NegativeOnlyNameFieldTest() {
//        practiceFormPage
//                .openPage(practiceFormUrl)
//                .typeFirstUserName(testData.firstName)
//                .typeLastUserName(testData.lastName)
//                .submitForm()
//                .checkFieldNotVisible();
//    }
//
//    //Негативный сценарий: вводим только гендер
//    @Test
//    void NegativeOnlyGenderFieldTest() {
//        practiceFormPage
//                .openPage(practiceFormUrl)
//                .setGender(testData.gender)
//                .submitForm()
//                .checkFieldNotVisible();
//    }
//
//    //Негативный сценарий: вводим некоректный номер
//    @Test
//    void NegativeOnlyUserNumberFieldTest() {
//        practiceFormPage
//                .openPage(practiceFormUrl)
//                .typeFirstUserName(testData.firstName)
//                .typeLastUserName(testData.lastName)
//                .setGender(testData.gender)
//                .typeUserNumber(testData.incorrectUserNumber)
//                .submitForm()
//                .checkFieldNotVisible();
//    }
}
