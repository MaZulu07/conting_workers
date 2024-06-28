import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Organization organization = new Organization();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Worker");
            System.out.println("2. Display Workers");
            System.out.println("3. Count Workers by Role");
            System.out.println("4. Display Role Counts");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter worker name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter worker ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter worker role: ");
                    String role = scanner.nextLine();
                    Worker worker = new Worker(name, id, role);
                    organization.addWorker(worker);
                    System.out.println("Worker added!");
                    break;
                case 2:
                    organization.displayWorkers();
                    break;
                case 3:
                    System.out.print("Enter role to count: ");
                    String roleToCount = scanner.nextLine();
                    int count = organization.countWorkersByRole(roleToCount);
                    System.out.println("Number of workers with role " + roleToCount + ": " + count);
                    break;
                case 4:
                    Map<String, Integer> roleCounts = organization.getRoleCounts();
                    for (Map.Entry<String, Integer> entry : roleCounts.entrySet()) {
                        System.out.println("Role: " + entry.getKey() + ", Count: " + entry.getValue());
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
