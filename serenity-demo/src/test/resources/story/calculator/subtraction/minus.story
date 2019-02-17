Calculator Subtraction Operation

Meta:
@tag tool:jbehave

Scenario: JBehave - Can perform subtraction
Given Mason has calculator
When Mason perform subtraction <minuend> minus <subtrahend>
Then Calculator should return <difference>
Examples:     
|minuend|subtrahend|difference|
|5|4|1|
|10|20|-10|
|100|20|80|
|1|20|-19|