import java.io.*;

import java.io.IOException;

import java.util.Scanner;


public class StudentClass {

//Declaring scope variables

private String studentFirstName;

private String studentLastName;

private int testScore;

private char grade;

//Default constructor StudentClass invoked without parameters
public StudentClass() {

}

//Constructor StudentClass with parameters invoked to create object
public StudentClass(String studentFName, String studentLName, int testScore, char grade)
{

    //Super calls default constructor
    super();

    this.studentFirstName = studentFName;

    this.studentLastName = studentLName;

    this.testScore = testScore;

    this.grade = grade;

}

//Getter and Setter functions to retrieve and set Students information
//Consisting of first and last name, and their grades
public String getStudentFName()
{

    return studentFirstName;

}

public void setStudentFName(String studentFName)
{

    this.studentFirstName = studentFName;

}

public String getStudentLName()
{

    return studentLastName;

}

public void setStudentLName(String studentLName)
{

    this.studentLastName = studentLName;

}

public int getTestScore()
{

    return testScore;

}

public void setTestScore(int testScore)
{

    this.testScore = testScore;

}

public char getGrade()
{

    return grade;

}

public void setGrade(char grade)
{

    this.grade = grade;

}

static StudentClass studentData[] = null;

//Main function consists of mostly function calls
public static void main(String[] args) {

//Setting StudentData array to 20 elements
studentData = new StudentClass[20];

//Calls readData function to read student data from Data.txt
readData();

//Calls function assignGrade to look for students' grades
assignGrade();


int highestScore = findHighestScore();

//Calls function printHighScoreStudents to display the students with the highest grades
printHighScoreStudents(highestScore);

}

//This method will print the output data to the out file
private static void printHighScoreStudents(int highestScore)
{
    File f = new File("Out.txt");

    try {

        FileWriter fw = new FileWriter(f);

        fw.write("Student Name\t\tTest Score Grade\n\r");

        System.out.println("Student Name\t\tTest Score\tGrade\n");

        for(int i = 0; i < studentData.length; i++)
        {

            fw.write("\n\n\r" + studentData[i].getStudentLName() + ", " + studentData[i].getStudentFName() +"   " +"  \t  " + studentData[i].getTestScore() + "      " + studentData[i].getGrade() + "\n\r");

            System.out.printf("%s, %-10s\t%d\t\t%c\n", studentData[i].getStudentLName(), studentData[i].getStudentFName(), studentData[i].getTestScore(), studentData[i].getGrade());

        }

    fw.write("\n\r");
    fw.write("\n\n\r" + "Highest Test Score: " + highestScore + "\n\n\r");

    System.out.println("\n\nHighest Test Score: " + highestScore + "\n");

    fw.write("\n\n\r" + "Students having the highest test score: " + "\n\n\r");

    System.out.println("Students having the highest test score:\n");

    for(int i = 0; i < studentData.length; i++)
    {

        if(studentData[i].getTestScore() == highestScore)
        {

            fw.write("\n\n\r" + studentData[i].getStudentLName() + ", " + studentData[i].getStudentFName() + "\n\r");

            System.out.println(studentData[i].getStudentLName() + ", " + studentData[i].getStudentFName());

        }

    }

fw.close();

} catch (IOException e) {

    e.printStackTrace();

    }

}

//This method will find the highest score of the student
private static int findHighestScore()
{

    int max;

    max = studentData[0].getTestScore();

    for(int i = 0; i< studentData.length; i++)
    {

        if(max < studentData[i].getTestScore())

        max = studentData[i].getTestScore();

    }

    return max;

}

//This method will find the grade letter of each student
private static void assignGrade()
{

    for(int i = 0; i < studentData.length; i++)
    {

        if (studentData[i].getTestScore() >= 90)

        studentData[i].setGrade('A');

        else if (studentData[i].getTestScore() >= 80 && studentData[i].getTestScore() < 90)

        studentData[i].setGrade('B');

        else if (studentData[i].getTestScore() >= 70 && studentData[i].getTestScore() < 80)

        studentData[i].setGrade('C');

        else if (studentData[i].getTestScore() >= 60 && studentData[i].getTestScore() < 70)

        studentData[i].setGrade('D');

        else if (studentData[i].getTestScore() < 60)

        studentData[i].setGrade('F');

    }

}

//Thismethod will read the data and populate into Student class array
private static void readData()
{

    String fname, lname;

    int score;

    int i = 0;

    try {

        Scanner readData = new Scanner(new File("Data.txt"));

        while(readData.hasNext())
        {

            fname = readData.next();

            lname = readData.next();

            score = readData.nextInt();

            StudentClass studentInfo = new StudentClass();

            studentInfo.setStudentFName(fname);

            studentInfo.setStudentLName(lname);

            studentInfo.setTestScore(score);

            studentData[i] = studentInfo;

            i++;

        }

    } catch (FileNotFoundException e) {

        e.printStackTrace();

        }

    }

}
