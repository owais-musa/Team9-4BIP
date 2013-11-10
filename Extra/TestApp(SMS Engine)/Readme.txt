This is a sample project whch uses and tests the SMS capabilities of Android. This project contains the function SendSMS(), which will be integrated into the main project later. 

API specification-

Function SendSMS(String message, String phoneNo)-
  Type-void.
  Arguments - String message (Text of message), string phoneNo (Recipient's number).
  Actions- Sends given SMS text to given phone number.
  Output - Provides Toasts with following texts-
	  "Please enter both phone number and message." - If the message/phone number are not inputed.
	  "SMS sent" - Success.
	  "Generic failure" - Generic failure.
	  "No service" - No Service.
	  "Null PDU" - Null PDU.
	  "Radio off" - Radio is off.
	  "SMS delivered" - SMS was delivered.
	  "SMS not delivered" - SMS wasn't delivered.
	  Writes the SMS in question to the sent directory if it was valid.
	   