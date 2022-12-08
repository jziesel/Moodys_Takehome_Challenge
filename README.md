# Moodys_Takehome_Challenge

The first part is about writing automated tests. Code quality is very important here (and getting the tests to work is, of course, essential). We prefer Java, TestNG for this task.

The second part is about writing test cases for API automation. Code quality is important. We prefer to use REST Assured Library with TestNG.

PART 1:

In a programming language of Java, create a PaginationHelper class that might be used for
implementation of pagination UI components and a set of Unit tests to properly test it.

Expectation is to write the code based on the information provided below and write the related test cases.

Here is a class description:

/*
The class is designed to take in an array of values and an integer indicating how many items will be allowed per each page. The types of values contained within the collection/array are not relevant.
The following are some examples of how this class is used:

helper = PaginationHelper.new(['a','b','c','d','e','f'], 4)
helper.pageCount() # should == 2
helper.itemCount() # should == 6
helper.pageItemCount(0) # should == 4
helper.pageItemCount(1) # last page - should == 2
helper.pageItemCount(2) # should == -1 since the page is invalid
'# page_index takes an item index and returns the page that it belongs on
helper.pageIndex(5) # should == 1 (zero based index)
helper.pageIndex(2) # should == 0
helper.pageIndex(20) # should == -1
helper.pageIndex(-10) # should == -1 because negative indexes are invalid
*/

PART 2:

This exercise aims at getting an automated test solution for some scenarios using the open API https://gorest.co.in/
Please, refer to the corresponding documentation whenever required.

Testing objectives:
1. Create a new user in the system. Make the corresponding assertions to confirm the data persists. 
2. Rename the user and check it was correctly updated in the system. 
3. Create a post with 1 comment as the above user. Check the comment persists and is related with the correct user. 
4. Now delete the user. Confirm the previously generated data is no longer accessible. Some additional notes:
   
Even though we recommend using TestNG framework, it's up to the candidate to go for any other alternative.

# My Take on the Challenge

Per the Challenge request, I did utilize Java and TestNG. I also decided to use Maven, json-simple, and gson libraries.

Part 1:

Wanted to extend the PaginationHelper class from the Driver class. Ran into some issues with this (TestNG-related? need to check that out). From reading the requirements, I initially thought about creating one instance of the class from the Driver class, but some of the examples such as .pageItemCount() and .pageIndex() made me question my interpretation. A few questions I would have for the statement:

helper = PaginationHelper.new(['a','b','c','d','e','f'], 4)

First, is the array of values meant to represent a count of specific pages to be accessed and maniplated via the instance of the helper class? And second, would the "items allowed per page" be for each "page" (element in the array), or for the entire array? The above example could be interpreted as "for each page in the array allow four items per page."

I have to admit I was struggling to envision a real world example of how to design and implement a class based on the requirements provided. That is why I only have one method currently included in my TestNG suite.


Part 2:

I decided to base my code upon the Rest Assured library. The code will successfully create a new user with a distinct email address created during runtime. Based on the gorest.co.in site, I also added tests to listUsers() and getSpecificUser(). During the createUser Test, the code will deserialize (via Gson) to the JSONSuccessResponse class, and from that get the unique system generated id value which is then assigned to the private idField. The idField value is used for the getSpecificUser() method.