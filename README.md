# Bingo Ticket Generator

## Overview
This project generates a strip of 6 bingo tickets. Each bingo strip is designed in such a way that every number from 1 to 90 appears on across the 6 tickets, ensuring that there are no duplicate numbers in any ticket. This README provides an overview of the project and how to run the project/tests.

## Features

* Generates a bingo tickets strip consisting of 6 tickets.
* Ensures that there is no duplicate numbers in any tickets and all numbers from 1 to 90 are used.
* Ticket output is on the commandline and in a readable format.
* Testcases are included to verify the compliance with the rules.

## Environment Requirements
* Requires Java 17 or later to execute the code.
* IDE such as Intellij or Eclipse is recommended for code execution.


## Installation

1. Clone the repository:

```
git clone https://github.com/bhargavSai017/bingo_strip_generator.git
cd bingo_strip_generator
```

## Usage

1. Import the project in intellij, go to `File > New > Click on Project from Existing Sources...`, windows select folder screen appears, find the project directory and click on `ok`.
2. Once the project is imported, go to `Run > Click on Run Main` the project will be executed and the output and the test result will shown in a newly opened console at the bottom.

## Code Strucutre
* `src/Main.java`: Main java class which calls Ticket Generator class to create tickets and BingoTester class to run the unit tests.
* `src/TicketGenerator.java`: Contains abstracted logic for generating ticket strip.
* `src/BingoTester.java`: Contains the unit tests.

## Future Enhancements
* Add a graphical user interface (GUI) for better visualization.
* Allow customization of ticket formats.
* Support exporting tickets to PDF or image format.
