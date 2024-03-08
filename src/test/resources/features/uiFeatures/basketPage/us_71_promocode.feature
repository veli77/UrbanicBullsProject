@UI @Kubra @US71
Feature: As a user, after entering valid information, I should be able to perform various actions in the Welcome Page

  @Login2
  Scenario: US71-TC01 Enter prome code menu should be functional
    Given User enters cart
    And User adds order on cart page
    Then Promocode menu should be clickable
    Then User should be enter promocode
    Then After entering the Promo Code, you should receive the same discount
    And User completes the purchase


  @Login2
  Scenario: US71-TC02 Prome code must not be greater than or equal to the total amount
    Given User enters cart
    And User adds order on cart page
    Then Promocode is entered greater than the total amount and an error message is expected.
    Then Promocode is entered equal to the total amount and an error message is expected.
    Then Undefined promocode is entered and an error message is expected.
    And User completes the purchase

  @Login2
  Scenario: US71-TC03 Post payment promecode should show correct result
    Given User enters cart
    And User adds order on cart page
    Then Promocode is entered less than the total amount and the same discount will be seen on the total amount.
    And User completes the purchase












   #Enter prome code menu should be functional
   #Code must be entered in the Enter prome code menu
   #After entering the code, click the Apply button.
   #After the code is entered, the code rate should give results
   #Prome code must not be greater than or equal to the total amount
   #After entering the promecode that is greater than or equal to the total amount, the alert should appear.
   #Alert: You can't apply this promecode due to greater or equal than your total amount
   #Post payment promecode should show correct result
   #Undefined promecode cannot be entered
   #Undefined promecode code soner Invalid Prome-Code. No such prome code is defined. alert should appear
   #Then proceed from the Proceed to checkout button and complete the payment.

  #Prome kodunu girin menüsü işlevsel olmalıdır
  #Promosyon kodunu girin menüsünde #Kod girilmelidir
    #Kodu girdikten sonra Uygula butonuna tıkla.
    #Kod girildikten sonra kod oranı sonuç vermeli
    #Prome kodu toplam tutardan büyük veya ona eşit olmamalıdır
    #Toplam tutardan büyük veya ona eşit olan promosyon kodunu girdikten sonra uyarı görünmelidir.
    #Uyarı: Toplam tutarınızdan büyük veya eşit olması nedeniyle bu promosyon kodunu uygulayamazsınız
    #Ödeme sonrası promecode doğru sonucu göstermelidir
    #Tanımsız promecode girilemez
    #UnDefinition Promecode code soner Geçersiz Prome-Code. Böyle bir promosyon kodu tanımlanmamıştır. uyarı görünmeli
    #Ardından Ödeme işlemine geç düğmesinden ilerleyin ve ödemeyi tamamlayın.