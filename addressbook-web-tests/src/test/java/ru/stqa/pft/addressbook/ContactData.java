package ru.stqa.pft.addressbook;

public class ContactData {
    private final String firstName;
    private final String lastName;
    private final String company;
    private final String address;
    private final String mobilePhone;
    private final String email;
    private final String dayOfBirth;
    private final String monthOfBirth;
    private final String yearOfBirth;

    public ContactData(String firstName, String lastName, String company,
                       String address, String mobilePhone, String email,
                       String dayOfBirth, String monthOfBirth, String yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;

        this.company = company;
        this.address = address;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public String getMonthOfBirth() {
        return monthOfBirth;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }
}
