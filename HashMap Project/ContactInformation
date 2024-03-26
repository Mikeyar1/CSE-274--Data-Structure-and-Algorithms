
/**
*
* Class: AddressInterface
* @author Mikey Arias
* @version 2022-06 (4.24.0)
* Course : CSE 274,Fall 2023
* Written: November 12, 2023
*
* Purpose: This class represents a person's contact information, including name,
address, and phone number.
* It is designed for sorting by the person's name.
*/
class ContactInformation implements Comparable<ContactInformation> {
private String firstName;
private String lastName;
private int zipCode;
private String streetAddress;
private String phoneNumber;
/**
* Constructor
*
* @param firstName
* @param lastName
* @param zipcode
* @param streetAddress
* @param phoneNumber
*/
public ContactInformation(String firstName, String lastName, int zipcode,
String streetAddress, String phoneNumber) {
this.firstName = firstName;
this.lastName = lastName;
this.zipCode = zipcode;
this.streetAddress = streetAddress;
this.phoneNumber = phoneNumber;
}
/**
* Compares this address with another address entry for order.
*
* @param other .
* @return A negative integer, zero, or a positive integer as this object
*/
@Override
public int compareTo(ContactInformation other) {
int lastNameComparison = this.lastName.compareTo(other.lastName);
if (lastNameComparison != 0) {
return lastNameComparison;
}
// If last names are the same, compare first names
return this.firstName.compareTo(other.firstName);
}
/**
* @return A string with the individual's full name, address, and phone number.
*/
@Override
public String toString() {
return firstName + " " + lastName + "\n" + streetAddress + "\n" + zipCode +
"\n" + phoneNumber + "\n";
}
}
