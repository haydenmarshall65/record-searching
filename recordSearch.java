import java.util.Scanner;
class recordSearch{

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter EID (format: 123456):");
        int EID = scanner.nextInt();
        while(EID < 100000 || EID > 999999){
            System.out.print("Please enter a valid EID:");
            EID = scanner.nextInt();
        }

        //gather employee first and last names
        System.out.println("Please enter employee first name: ");
        scanner.nextLine(); //to account for the enter from the previous nextInt()
        String firstName = scanner.nextLine();

        System.out.println("Please enter employee last name: ");
        String lastName = scanner.nextLine();

        //gather employee age and ensure age is older than 18 but not 3 digits
        System.out.print("Please enter employee age: ");
        int empAge = scanner.nextInt();
        while(empAge < 18 && empAge < 100) {
            System.out.print("Please enter a valid age: ");
            empAge = scanner.nextInt();
        }

        //gather employee rating but make sure its between 1 and 100
        System.out.println("Please enter employee rating (out of 100, i.e. 99)");
        int rating = scanner.nextInt();
        while(rating < 1 || rating > 100){
            System.out.println("Please enter a valid employee rating (out of 100): ");
            rating = scanner.nextInt();
        }

        //concatenate the names so its all one with no space
        String fullName = firstName + lastName;

        //add record to files
        recordKeeper.add(EID, fullName, empAge, rating);

        System.out.println("Please enter record to search for (EID): ");
        int searchID = scanner.nextInt();

        recordKeeper.search(searchID);
        
        scanner.close();
    }
}