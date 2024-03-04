#US_077 As a user, should not able to add an address successfully by providing with invalid data
#
#*Create Event
#*title should be at least two character and can not be blank if so user will see warning message "Please enter a valid title."
#*address should be at least one character and can not be blank if so user will see warning message "Please enter a valid address."
#*User should be able to add date. can not be blank if so user will see warning message "Please fill in this field."
#*User should be able to add time. can not be blank if so user will see warning message "Please fill in this field."
#*After adding Attendee, schedule , description and terms and conditions
#*If user not provide valid data to the reqired field and clicks submit button should not able to create an event by seeing warnig message.


#US_077 Kullanıcı olarak, geçersiz veriler sağlayarak başarıyla adres ekleyememelisiniz
#*Etkinlik oluşturmak
#*başlık en az iki karakter olmalı ve boş bırakılmamalıdır, boş bırakılmaması durumunda kullanıcı "Lütfen geçerli bir başlık giriniz" uyarı mesajını görecektir.
#*adres en az bir karakter olmalı ve boş bırakılmamalıdır, boş bırakılmaması durumunda kullanıcı "Lütfen geçerli bir adres giriniz" uyarı mesajını görecektir.
#*Kullanıcı tarih ekleyebilmelidir. Boş bırakılamazsa kullanıcı "Lütfen bu alanı doldurunuz" uyarı mesajını görecektir.
#*Kullanıcı saat ekleyebilmelidir. Boş bırakılamazsa kullanıcı "Lütfen bu alanı doldurunuz" uyarı mesajını görecektir.
#*Katılımcı, program, açıklama ve şartlar ve koşullar eklendikten sonra
#*Kullanıcı gerekli alana geçerli veri sağlamaz ve gönder butonuna basarsa uyarı mesajını görerek etkinlik oluşturamayacaktır.
@wip5
@UI
@Login2
Feature: As a user, should not able to add an address successfully by providing with invalid data

  Background:
    #Given User goes to homepage
    #When User clicks on Login module
    #And User logs in
    When User click to My Events btn at the button
    When User click to Create New Event btn at the button

  Scenario: TC_01 Title should be at least two character and can not be blank if so user will see warning message "Please enter a valid title."
    When User enter blank title
    And User enter address
    And User enter date
    And User enter time
    And User enter Attendee, schedule , description and terms and conditions and click submit button
    Then User see Please enter a valid title message

  Scenario: TC_02 address should be at least one character and can not be blank if so user will see warning message "Please enter a valid address."
    When User enter title
    And User enter blank address
    And User enter date
    And User enter time
    And User enter Attendee, schedule , description and terms and conditions and click submit button
    Then User see Please select an address message


  Scenario: TC_03 User should be able to add date. can not be blank if so user will see warning message "Please fill in this field."
    When User enter title
    And User enter address
    And User enter blank date
    And User enter time
    And User enter Attendee, schedule , description and terms and conditions and click submit button
    Then User see Please fill in this field message for date

  Scenario: TC_04 User should be able to add time. can not be blank if so user will see warning message "Please fill in this field."
    When User enter title
    And User enter address
    And User enter date
    And User enter blank time
    And User enter Attendee, schedule , description and terms and conditions and click submit button
    Then User see Please fill in this field message for time






