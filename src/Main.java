/*
* GPA formula : total points/ total credits
* GPA for a subject : points obtained/ credits for the subject
* points for a class = grade value * credits
* */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of courses taken in the semester :");
        int numOfCourses = sc.nextInt();
        sc.nextLine();
        List<String> credits = new ArrayList<>();
        List<String> grades = new ArrayList<>();
        getCreditsAndGrades(numOfCourses,credits,grades);
        System.out.println("GPA : "+ calculateGPA(credits,grades));
        sc.close();
    }

    private static void getCreditsAndGrades(int numOfCourses, List<String> credits, List<String> grades) {
        Scanner sc = new Scanner(System.in);
        do{
            boolean validInput = false;
            String credit;
            String grade;
            do {
                System.out.println("Enter the number of credits for the class:");
                credit = sc.nextLine();
                try{
                    Validation.validateCredit(credit);
                    validInput = true;
                    credits.add(credit);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }while(validInput == false);
            validInput = false;
            do {
                System.out.println("Enter the grade obtained for the class:");
                grade = sc.nextLine();
                try{
                    Validation.validateGrade(grade);
                    validInput = true;
                    grades.add(grade);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }while(validInput == false);
            numOfCourses--;
        }while(numOfCourses!=0);
        sc.close();
    }

    private static double calculateGPA(List<String> credits, List<String> grades) {
        double numericGrade = 0;
        double points = 0.0;
        double totalCredits = 0;
        for(int i=0;i<credits.size();i++){
             numericGrade = getNumericGrade(grades.get(i));
             points += numericGrade * Double.valueOf(credits.get(i));
             totalCredits += Double.valueOf(credits.get(i));
        }

        return (points/totalCredits);
    }

    private static double getNumericGrade(String grade) {
        switch(grade.toUpperCase()){
            case "A" : return 4.0;
            case "B" : return 3.0;
            case "C" : return 2.0;
            case "D" : return 1.0;
            case "F" : return 0.0;
        }
        return -1d;
    }
}
