/*------------------------------------------------------
My name: Andrew Titmuss
My subject code: DPIT111/CSIT111
My student number: 6123521
My email address: at740@uowmail.edu.au
Assignment number: 3
-------------------------------------------------------*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;

class ToDoList {

    // Create an ArrayList to put our Task objects in
    // Very appropriately named, thanks UML diagrams
    private ArrayList<Task> list;

    public static void main(String[] args) {

        /* main() only runs displayMenu(), which also
         * handles exiting the application. i.e. the application
         * would still run the same if displayMenu()'s code
         * was moved to main(). I suppose this makes it more
         * verbose, but I'm just following the UML
         */
        displayMenu();

    }

    public ToDoList() {
        // default constructor, initilise ArrayList
        this.list = new ArrayList<Task>();
    }

    public Task[] getSortedList() {

        // convert ArrayList to Array
        Task[] taskArray = list.toArray(new Task[0]);

        /* // bubblesort the taskArray array using the isEarlier() method
        // https://www.javatpoint.com/bubble-sort-in-java
        for (int i = 0; i < taskArray.length; i++) {
            for (int j = 1; j < (taskArray.length - i); j++) {
                if (taskArray[j].isEarlier(taskArray[j-1])) {
                    Task temp = taskArray[j-1];
                    taskArray[j-1] = taskArray[j];
                    taskArray[j] = temp;
                }
            }
        }
        */

        /* insertion sort the taskArray using the isEarlier() method
         * http://www.java2novice.com/java-sorting-algorithms/insertion-sort/
         * this doesn't always improve or worsen speed over bubble sort (both have
         * the same performance and complexity) but it's good to know
         * how to do both
         */
        for (int i = 0; i < taskArray.length; i++) {
            for (int j = i; j > 0; j--) {
                if (taskArray[j].isEarlier(taskArray[j-1])) {
                    Task temp = taskArray[j-1];
                    taskArray[j-1] = taskArray[j];
                    taskArray[j] = temp;
                }
            }
        }

        // return the sorted taskArray
        return taskArray;

    }

    // add a task to the task ArrayList
    public void addTask(Task task) {
        list.add(task);
    }

    /* delete a task from the ArrayList given its taskID
     * list.removeIf() is new in Java 8, it takes O(n) time
     * and can be improved to O(1) if a HashMap is used
     * instead of an ArrayList
     */
    public void deleteTask(int taskID) {

        // this is a nice way to do it but probably worse and
        // it's not in the lectures so I can't use it anyway
        /*
        Iterator<Task> iter = list.iterator();
        while (iter.hasNext()) {
            Task delID = iter.next();

            if (delID.getTaskID() == taskID) {
                iter.remove();
            }
        }
        */

        for (int i=0; i < list.size(); i++) {
            Task toRemove = list.get(i);
            if (toRemove.getTaskID() == taskID) {
                list.remove(i);
            }
        }
    }

    /* delete all tasks from the ArrayList. this has two options,
     * clear() or removeAll(). clear() is much faster taking O(n) time
     * vs removeAll()'s O(n^2). I think removeAll() frees up memory and also
     * returns the state of the operation, whereas clear() just clears the
     * instance, which is all we're concerned with so the speed increase
     * is nice
     * https://stackoverflow.com/questions/7032070/what-is-the-difference-between-arraylist-clear-and-arraylist-removeall
     */
    public void deleteAllTasks() {
        list.clear();
    }

    public void printList(Task[] taskArray) {

        /* print opening line,
         * loop over taskArray printing each task
         * print closing line
         */
        System.out.println("---------------------------------------------");
        for (int i=0; i < taskArray.length; i++){
            taskArray[i].printTask();
        }
        System.out.println("---------------------------------------------");

    }

    public int getTaskNumber() {
        return list.size();
    }

    private static void displayMenu() {

        /* just the one scanner object this time,
         * don't want to break banshee again
         */
        Scanner input = new Scanner(System.in);

        /* create an instance of the ToDoList class so its methods can be used
         * in the static context.
         */
        ToDoList tdl = new ToDoList();

        /* using while(true) here is one method (and likely the simplest)
         * of making the program run continuously until told not to.
         * another method would be to set a boolean outside the loop and have
         * option 5 set this to false, which is the same as breaking out
         * of the loop anyway
         */
        while(true) {
            // print the menu options
            System.out.println("#########################");
            System.out.println("1: Add a task");
            System.out.println("2: List all tasks");
            System.out.println("3: Delete a task");
            System.out.println("4: Delete all tasks");
            System.out.println("5: Exit the program");
            System.out.println("#########################");

            // user selects the option from the menu
            System.out.print("Please select an action from above: ");
            int option = input.nextInt();
            /* this is weird but needed, it absorbs the \n character that
             * comes after input.nextInt(); processes the line.
             * without it, the title option gets skipped over
             */
            input.nextLine();

            // switch ensures we can have a default case so
            // the program doesn't crash from unexpected input
            switch(option) {
                case 1:
                    /* get the task title. the extra input.nextLine(); isn't needed
                     * again here because this one DOES absorb the \n.
                     */
                    System.out.print("Please input the new task title: ");
                    String title = input.nextLine();

                    /* I spoke with a tutor (Hooman) and the lecturer (Fenghui) about this
                     * and was told by Fenghui that I can make the otherwise useless
                     * default constructors get the current system time and date
                     * and Hooman told me I can make it useful by using the default
                     * constructor if the user does not input a date or time
                     * I took this further by adding rudimentary input validation,
                     * so if the date or time is impossible (32nd of the 13th month etc)
                     * it will ask for the date or time again.
                     * I'm assuming the test cases don't use invalid data anyway so this
                     * shouldn't be an issue, but that's the explanation for if things break
                     * (which they shouldn't, I've tested on Banshee)
                     */

                    /* get the date for the task. way overcomplicated so I can do
                     * some kind of input validation to make sure its a valid date
                     * and if no date is entered use the current system date
                     */

                    // create the date object with the default constructor, use
                    // current system date
                    Date date = new Date();

                    // use a while loop to keep asking for the day until
                    // a valid date is entered
                    boolean goodDate = false;
                    while(!goodDate) {
                        System.out.print("Please input the task date (dd mm yyyy): ");

                        /* this is the easy way, which I would use if I wasn't
                         * checking if the input was empty
                         * int day = input.nextInt();
                         * int month = input.nextInt();
                         * int year = input.nextInt();
                         */

                        // take the input as a string so I can check .isEmpty()
                        String dateString = input.nextLine();

                        // check if the input is empty and break out of the loop
                        if (dateString.isEmpty()) {
                            break;
                        }

                        // parse the day, month and year from dateString by splitting
                        // at each space (" ")
                        int day = Integer.parseInt(dateString.split(" ")[0]);
                        int month = Integer.parseInt(dateString.split(" ")[1]);
                        int year = Integer.parseInt(dateString.split(" ")[2]);

                        // check if the date is valid. this isn't bullet proof (doesn't
                        // check if the month should only have 30/29/28 days)
                        if (day <= 31 && month <= 12) {
                            goodDate = true;
                            // set the date object's variables to the inputted date
                            date.setDay(day);
                            date.setMonth(month);
                            date.setYear(year);
                        }
                    }

                    // time input. works the same way as date input

                    // create the time object. uses current system time from
                    // default constructor
                    Time time = new Time();
                    // while loop to check if time input is valid
                    boolean goodTime = false;
                    while(!goodTime) {

                        System.out.print("Please input the task time (hh mm): ");

                        /* this is the easy way, which I would use if I wasn't
                         * checking if the input was empty
                         * int hour = input.nextInt();
                         * int min = input.nextInt();
                         */

                        // take time input as a string so we can check .isEmpty()
                        String timeString = input.nextLine();

                        if (timeString.isEmpty()) {
                            // break from loop if empty
                            break;
                        }

                        // parse the string into the hour and minute variables
                        int hour = Integer.parseInt(timeString.split(" ")[0]);
                        int min = Integer.parseInt(timeString.split(" ")[1]);

                        // check if time is valid, if yes, update the time object
                        if (hour <= 23 && min <= 59) {
                            goodTime = true;
                            time.setHour(hour);
                            time.setMin(min);
                        }
                    }

                    // get the time input
                    System.out.print("Please input the location: ");
                    String location = input.nextLine();

                    /* the taskID is calculated by finding the last element in the
                     * ArrayList and getting its taskID, and adding 1 to it.
                     * if the list is empty, just set the taskID to 1. the next task
                     * will use the calculation.
                     */
                    int taskID;
                    if (tdl.getTaskNumber() > 0) {
                        taskID = tdl.list.get(tdl.getTaskNumber() - 1).getTaskID() + 1;
                    } else {
                        taskID = 1;
                    }

                    /* create a new Task object from the inputted (and calculated)
                     * data and add it to the ArrayList
                     */
                    Task task = new Task(time, date, title, location, taskID);
                    tdl.addTask(task);

                    // inform the user the process is complete and show the new list
                    System.out.printf("Task %d is added. The To-Do list is follows:\n", taskID);
                    tdl.printList(tdl.getSortedList());

                    // break from the case, start the while loop again
                    break;
                case 2:
                    // just print the (sorted by date and time) list
                    tdl.printList(tdl.getSortedList());
                    break;
                case 3:
                    /* show the sorted list,
                     * ask for the task to delete,
                     * delete it,
                     * inform the user it's deleted and show the new list
                     */
                    tdl.printList(tdl.getSortedList());
                    System.out.print("Please input the task ID to be deleted: ");
                    int delID = input.nextInt();
                    tdl.deleteTask(delID);
                    System.out.printf("Task %d is deleted. The To-Do list is as follows:\n", delID);
                    tdl.printList(tdl.getSortedList());
                    break;
                case 4:
                    // delete all the tasks and tell the user it's done
                    tdl.deleteAllTasks();
                    System.out.println("All tasks are deleted. The To-Do list is empty.");
                    break;
                case 5:
                    /* exit the program. return is used instead of break as
                     * it applies to the entire method displayMenu() rather than just
                     * the switch statement
                     */
                    System.out.println("Thanks for using my To-Do List program, Goodbye!");
                    return;
            }
        }
    }

}

class Date {

    // initialise the variables used in this class
    private int day, month, year;

    // default constructor
    public Date() {

        // create a calendar instance to get the current date
        Calendar cal = Calendar.getInstance();
        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH) + 1; // MONTH is zero-indexed
        year = cal.get(Calendar.YEAR);

    }

    // constructor, sets the class variables to the user input
    public Date(int day, int month, int year) {

        this.day = day;
        this.month = month;
        this.year = year;

    }

    // getter for day
    public int getDay() {
        return day;
    }

    // getter for month
    public int getMonth() {
        return month;
    }

    // getter for year
    public int getYear() {
        return year;
    }

    // setter for day
    public void setDay(int day) {
        this.day = day;
    }

    // setter for month
    public void setMonth(int month) {
        this.month = month;
    }

    // setter for year
    public void setYear(int year) {
        this.year = year;
    }

    // return a formatted date string in the form dd/mm/yyyy
    public String toString() {
        return String.format("%d/%d/%d", day, month, year);
    }

    // check if the instance date is earlier than the input date
    public boolean isEarlier(Date date) {

        /* convert the dates to ISO8601, this way we can just
         * check which date is earlier by seeing which integer
         * is smaller. doing this for isEarlier(Task) would
         * have been a better solution, but this sticks to
         * the UML provided
         */
        int originalDate = Integer.parseInt(String.format("%04d%02d%02d", this.year, this.month, this.day));
        int newDate = Integer.parseInt(String.format("%04d%02d%02d", date.year, date.month, date.day));

        /* if the instance date is a lower integer than the
         * new date, it must be earlier, so return true
         * else, return false
         */
        if (originalDate < newDate) {
            return true;
        } else {
            return false;
        }

    }

}

class Time {

    // initialise variables used in this class
    private int hour, min;

    // default constructor
    public Time() {

        // create a Calendar instance to get the current time
        Calendar cal = Calendar.getInstance();
        hour = cal.get(Calendar.HOUR_OF_DAY); // HOUR is 12 hour time, HOUR_OF_DAY is 24 hour time
        min = cal.get(Calendar.MINUTE);

    }

    // constructor, sets the class variables to the user input
    public Time(int hour, int min) {

        this.hour = hour;
        this.min = min;

    }

    // getter for hour
    public int getHour() {
        return hour;
    }

    // getter for minute
    public int getMin() {
        return min;
    }

    // setter for hour
    public void setHour(int hour) {
        this.hour = hour;
    }

    // setter for minute
    public void setMin(int min) {
        this.min = min;
    }

    // returns a formatted time string in the form hh:mm
    public String toString() {
        return String.format("%02d:%02d", hour, min);
    }

    // checks if the instance time is earlier than the input date
    public boolean isEarlier(Time time) {

        /* creates full integers of the time in hhmm, again it
         * would be nice to just use full ISO8601 in Task.isEarlier()
         * but this works fine
         */
        int originalTime = Integer.parseInt(String.format("%02d%02d", this.hour, this.min));
        int newTime = Integer.parseInt(String.format("%02d%02d", time.hour, time.min));

        /* if the instance time is lower than the inputted time,
         * it must be earlier, so return true. otherwise,
         * return false
         */
        if (originalTime < newTime) {
            return true;
        } else {
            return false;
        }

    }

}

class Task {

    // initialise the class variables
    private Time time;
    private Date date;
    private String title;
    private String location;
    private int taskID;

    // default constructor
    public Task() {

        time = new Time();
        date = new Date();
        title = "Title";
        location = "Location";
        taskID = 0;

    }

    // contstructor from user input and calculated taskID
    public Task(Time time, Date date, String title, String location, int taskID) {

        this.time = time;
        this.date = date;
        this.title = title;
        this.location = location;
        this.taskID = taskID;

    }

    // getter for time
    public Time getTime() {
        return time;
    }

    // getter for date
    public Date getDate() {
        return date;
    }

    // getter for title
    public String getTitle() {
        return title;
    }

    // getter for location
    public String getLocation() {
        return location;
    }

    // getter for taskID
    public int getTaskID() {
        return taskID;
    }

    // setter for time
    public void setTime(Time time) {
        this.time = time;
    }

    // setter for date
    public void setDate(Date date) {
        this.date = date;
    }

    // setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // setter for location
    public void setLocation(String location) {
        this.location = location;
    }

    /* prints the task in the form
     * * Task taskID: title, date, time, location
     */
    public void printTask() {
        System.out.printf("* Task %d: %s, %s, %s, %s\n", taskID, title, date.toString(), time.toString(), location);
    }

    // checks if a task is earlier than another task
    public boolean isEarlier(Task task) {

        /* if the date is earlier, the task must be earlier
         * regardless of the time. if not, check if it's the same date.
         * if it's the same, check if the time is earlier.
         * if the date isn't the same, it must be later,
         * so the condition short circuits and returns false.
         * if the date is the same, check if the time is earlier and
         * return true or false depending on if the time is earlier
         * or later
         */

        if (this.date.isEarlier(task.date)) {
            return true;
        } else if (this.date.toString().equals(task.date.toString())) {
            if (this.time.isEarlier(task.time)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

}
