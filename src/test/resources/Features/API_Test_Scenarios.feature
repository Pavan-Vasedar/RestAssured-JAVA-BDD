#Verify RESTful webservices for trade information
#Author: Pavankumar Vasedar
Feature: To verify API automation with Rest Assured

  @API_Test
  Scenario Outline: To verify Rest service - POST Method "<testcase>"
    Given To initiate Rest service to get trade information by passing "<payload>"
    Then Respose status code should be "<code>"
    And Respose status should be "<status>"
    And response message should be "<message>"

    Examples: 
      |	testcase																													| payload               | code | status  | message                                                        |
      |	Positive Scenario																									| ./payload/body.txt    |  200 | SUCCESS | null                                                           |
      |	value date cannot be before trade date														| ./payload/common1.txt |  200 | ERROR   | [Value date 2017-08-10 cannot be null and it has to be after trade date 2017-08-11 ] |
      |	value date cannot fall on weekend/non-working day for currency(Sun)|./payload/common2.txt |  200 | ERROR   | [Value date [2019-09-08] cannot fall on Saturday/Sunday]				|
      |	value date cannot fall on weekend/non-working day for currency(Sat)|./payload/common2_1.txt|  200| ERROR   | [Value date [2019-09-07] cannot fall on Saturday/Sunday]				|
      |	if the counterparty is one of the supported ones (PLUTO1,PLUTO2)  | ./payload/common3.txt |  200 | ERROR   | [Counterparty [PLUTO3] is not supported. Supported counterparties: [[PLUTO2, PLUTO1]]] |
      |	only one legal entity is used: CS Zurich	(BUG)										| ./payload/common4.txt |  200 | SUCCESS | null																														|
      |	validate currencies if they are valid ISO codes (ISO 4217)				| ./payload/common5.txt |  200 | ERROR   | [Invalid currency pair [EUT]]																	|
      |	the style can be either American or European											| ./payload/option1.txt	|  200 | ERROR   | [Invalid option style [ INDIAN ]. Valid option styles are: [AMERICAN, EUROPEAN]]	|
      |	American option style will have in addition the exerciseStartDate, which has to be after the trade date but before the expiry date (BUG) | ./payload/option2.txt |  200 | SUCCESS | null	|
      |	expiryDate and premium date shall be before deliveryDate					| ./payload/option3.txt |  200 | ERROR	 | [Premium date 2017-09-01 has to be before delivery date 2017-08-11 ]	|
      |	expiryDate and premium date shall be before deliveryDate					| ./payload/option3_1.txt |  200 | ERROR | [Expiry date 2017-09-21 has to be before delivery date 2017-08-22 ]	|
