import java.util.*;
public class gradeCalc{
        public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        int choice;
        boolean flag = true;
        while (flag){
            choice = 0;
            System.out.println("1. Course Grade");
            System.out.println("2. GWA ");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            try{
                choice = Integer.parseInt(scan.nextLine());
                switch (choice) {
                    case 1:
                        courseGradeCalc();
                        break;
                
                    case 2:
                        GWAcalc();
                        break;
                    
                    case 3:
                        flag = false;
                        break;

                    default:
                        throw new NumberFormatException();
                }
            }catch(NumberFormatException e){
                System.out.println("Enter only numbers from 1 to 3!");
                flag = continuePrompt();
            } 
            catch(Exception e){
                System.out.println("Enter only numbers!");
                flag = continuePrompt();
            }
        }
    }

    public static boolean continuePrompt(){
        char choice;
        System.out.println("Continue? y/n");
        try{
            choice = scan.nextLine().toUpperCase().charAt(0);
        } catch (Exception e){
            System.out.println("Enter only y or n. Exiting...");
            return false;
        }
        
        if(choice == 'Y'){
            return true;
        }
        else{
            return false;
        }
    }

    public static void courseGradeCalc(){
        System.out.println("===============COURSE GRADE CALCULATOR==============="); 
        boolean flag = true;
        double  prelim, midterm, preFi, finals;
        while(flag){
            try{
                prelim = 0;
                midterm = 0;
                preFi = 0;
                finals = 0;

                System.out.print("Enter prelim grade: ");
                prelim = nonFinalCalc(Double.parseDouble(scan.nextLine()));

                System.out.print("Enter midterm grade: ");
                midterm = nonFinalCalc(Double.parseDouble(scan.nextLine()));
                
                System.out.print("Enter Pre Finals grade: ");
                preFi = nonFinalCalc(Double.parseDouble(scan.nextLine()));

                System.out.print("Enter finals grade: ");
                finals = finalCalc(Double.parseDouble(scan.nextLine()));

                displayCalculatedGrade(prelim, midterm, preFi, finals);
                flag = continuePrompt();
            } catch(NumberFormatException e){
                System.out.println("Enter numbers only!");
                flag = continuePrompt();
            }
        }
        System.out.println("====================================================="); 
    }

    public static double nonFinalCalc(double grade){
        grade = grade * 0.2;
        return grade;
    }
    
    public static double finalCalc(double grade){
        grade = grade * 0.4;
        return grade;
    }

    public static void displayCalculatedGrade(double grade1, double grade2, double grade3, double grade4){
        double finalGrade = grade1 + grade2 + grade3 + grade4;
        System.out.printf("Final Grade: %.2f%n", finalGrade);
    }

    public static void GWAcalc(){
        System.out.println("===============GWA CALCULATOR===============");
        boolean flag = true;
        int numberOfCourse, numberOfUnits, totalUnits;
        double courseGrade, totalCreditPoints;
        ArrayList<Double> creditPointsPerCourse;
        ArrayList<Integer> units;

        while(flag){
            numberOfCourse = 0;
            totalUnits = 0;
            totalCreditPoints = 0;
            creditPointsPerCourse = new ArrayList<>();
            units = new ArrayList<>();

            try{
                System.out.print("Enter number of courses: ");
                numberOfCourse = Integer.parseInt(scan.nextLine());

                for (int loop = 0; loop < numberOfCourse; loop++) {
                    courseGrade = 0;
                    numberOfUnits = 0;
                    System.out.print("Enter Course Grade for Course #" + (loop + 1) + ":    ");
                    courseGrade = Double.parseDouble(scan.nextLine());
                    System.out.print("Enter Number of Units for Course #" + (loop + 1) + ": ");
                    numberOfUnits = Integer.parseInt(scan.nextLine());

                    units.add(numberOfUnits);
                    creditPointsPerCourse.add(courseGrade * numberOfUnits);
                }

                System.out.println("--------------------------------------------");
                for (Integer unit : units) {
                    totalUnits += unit;
                } 
                System.out.println("Total Number of Units: " + totalUnits);

                for (Double credit : creditPointsPerCourse) {
                    totalCreditPoints += credit;
                }

                System.out.printf("Total Credit Points: %.2f%n", totalCreditPoints);
                System.out.printf("GWA: %.2f%n", (totalCreditPoints / totalUnits));

                flag = continuePrompt();

            } catch(NumberFormatException e){
                System.out.println("Invalid number!");
                flag = continuePrompt();
            }
        }

        System.out.println("============================================");
    }
}