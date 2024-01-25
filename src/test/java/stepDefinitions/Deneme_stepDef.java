package stepDefinitions;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.ConfigurationReader;

import java.util.List;
import java.util.Map;

public class Deneme_stepDef {
  private   String user1_email = "user1@gmail.com";



    // scenario 2 datayi configReader dan cekerek
    @Given("Configuration properties kullanarak")
    public void configurationPropertiesKullanarak() {

        System.out.println("user name :" + ConfigurationReader.getProperty("user1_email") + " password : " + ConfigurationReader.getProperty("user1_password"));
    }

    // scenario 3 datalari step icerisinde gondererek
    @Given("Scenariom icinde string olarak {string}")
    public void scenariomIcindeStringOlarak(String arg0) {

        System.out.println(arg0);

    }

    @Given("Scenariom icinde int olarak {int}")
    public void scenariomIcindeIntOlarak(int arg0) {
        System.out.println(arg0);

    }

    @Given("Scenariom icinde double olarak {double}")
//    public void scenariomIcindeDoubleOlarak(int arg0, int arg1) {
    public void scenariomIcindeDoubleOlarak(double arg0) {
        System.out.println(arg0);

    }

    @Given("Scenariom icinde boolean olarak {string}")
    public void scenariomIcindeBooleanOlarak(String arg0) {
        System.out.println(Boolean.parseBoolean(arg0));

    }

    @Given("Scenariom icinde genel olarak {string} , {int} , {double} ve {string}")
    public void scenariomIcindeGenelOlarakVe(String arg0, int arg1, double arg2, String arg3) {
        System.out.println(arg0);
        System.out.println(arg1);
        System.out.println(arg2);
        System.out.println(Boolean.parseBoolean(arg3));
    }

    // scenario 4 datatable kullanarak
    @Given("Data table kullanarak")
    public void data_table_kullanarak(DataTable dataTable) {
        List<String> usernames = dataTable.column(0);
        List<String> password = dataTable.column(1);

        for (int i = 0; i < usernames.size(); i++) {

            System.out.println("usernames.get(i) = " + usernames.get(i));
            System.out.println("password.get(i) = " + password.get(i));
        }

    }

    @Then("bir basamak daha olsa datalar icin")
    public void bir_basamak_daha_olsa(DataTable dataTable) {
        List<Map<String, String>> maps = dataTable.asMaps();

        String navbar = maps.get(0).get("navbar");
        System.out.println("navbar = " + navbar);

    }

    // scenario 5 scenario outline kullanarak
    @Given("Scenariom Outline {string} and {int} {double} {string}")
    public void scenariom_outline_and(String string, int int1, double double1, String string2) {
        System.out.println("username : " + string + " rakam : " + int1 + " kusurat : " + double1 + " dogru : " + Boolean.parseBoolean(string2));
    }

    @Then("bir basamak daha olsa {int}")
    public void bir_basamak_daha_olsa(int int1) {
        System.out.println("rakam : " + int1);
    }


    @Given("tag kullanarak")
    public void tagKullanarak() {
        System.out.println("tag kullanarak cagirildi");
      //  driver.get("https://stackoverflow.com");


    }

  /*  @Given("Enum kullanarak")
    public void enumKullanarak() {
        EnumCalismasi.USER1.login();

    }  */

    @Given("user goes to production page")
    public void userGoesToProductionPage() {
        System.out.println("I am going product environment");

    }

    @Given("user goes to test page")
    public void userGoesToTestPage() {
        System.out.println("I am going test environment");
    }


    @Given("Scenariom icinde genel olarak {string} and {int} ve {double} and {string}")
    public void scenariomIcindeGenelOlarakAndVeAnd(String arg0, int arg1, int arg2, int arg3, String arg4) {
    }

    @Given("Step Definition icinde user and password")
    public void step_definition_icinde_user_and_password() {

    }
    @Given("Enum kullanarak")
    public void enum_kullanarak() {

    }




}
