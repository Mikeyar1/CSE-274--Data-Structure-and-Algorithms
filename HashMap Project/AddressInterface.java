/**
*
* Class: AddressInterface
* @author Mikey Arias
* @version 2022-06 (4.24.0)
* Course : CSE 274,Fall 2023
* Written: November 12, 2023
*
* Purpose: – The AddressInterface class initializes the address directory, reads
addresses from a file,
* and provides a user interface for searching addresses.
*/
public class AddressInterface {
/**
* The main method initializes the address book and starts the user interface.
*/
public static void main(String[] args) {
AddressDirectory addressBook = new AddressDirectory();
addressBook.readAddress("addresses.txt");
addressBook.SearchAddress();
}
}
