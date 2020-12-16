## Student Roster II
In this assignment, you will practice one-to-many relationships by building upon the Student Roster I assignment. In addition to what we already have, we will have a way to create dorm and place students in various dorms. Analyze the wireframe below and create the appropriate domain models with the correct relationships.

**Wireframe**

![dorms](dorms.png)

### Set Up
Creating the web view for this assignment will be optional (only if you are behind schedule). We will continue using the ```ApiService``` from the previous Student Roster assignment. Complete each task below.

**Tasks:**

● Have a method handler in the controller for the following example url: ```/dorms/create?name=Manza```. Create 4 dorms with this method.

● Have a method handler in the controller for the following example url: ```/dorms/3/add?student=1```. This method should add student with id 1 to the dorm with id 3. Add multiple student to different dormitories.

● Have a method handler in the controller for the following example url: ```/dorms/3/remove?student=1```. This method should remove student with id 1 from the dorm with id 3. Remove multiple students from a single dormitory.

● Have a method handler in the controller for the following example url: ```/dorms/1```. Display all the students that belong to the dorm with id 1. This method should work with any dorm as well.

**Optional (Only if behind):**

● Create the web view for this assignment.

● Create a page where you can create dormitories

● In the dormitory show page, allow the ability to add students to each dorm. Once added, update the student table for each dorm.

● If a student already belongs to a dorm, remove the option add them to any other dorm.

● Allow the ability to remove a student from a specific dorm.

**Topics:**

● 1:n relationships

● JPA methods

