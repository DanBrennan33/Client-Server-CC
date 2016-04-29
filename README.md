# Client-Server-CC

Part 1 - CardValidation.java
Takes a credit card long variable. Creates a list of individual digits from 
long variable which sums the digits to determine whether this credit card
value is valid. Implements several methods to breakdown the long value into
a list, which is then reversed, some digits are then doubled and then the 
overall sum is evaluated to determine its validity.

Part 2 - CreditCard.java
This class is used for sending objects of type CreditCard over the net.
implements several methods and variables, utilizing serialization.

Part 3 - CreditCardServer.java
The server runs on a local host using a port number that is provided
by my student ID#. This server receives a CreditCard object and 
validates this number, which is then sent back to the client.

Part 4 - CreditCardClient.java
The client sends a CreditCard object to server, which receives back
the object with validation. The client prints the object before and 
after server invocation.
