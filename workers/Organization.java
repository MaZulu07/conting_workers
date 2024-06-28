import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Organization {
    private List<Worker> workers;

    public Organization() {
        this.workers = new ArrayList<>();
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    public int countWorkersByRole(String role) {
        int count = 0;
        for (Worker worker : workers) {
            if (worker.getRole().equalsIgnoreCase(role)) {
                count++;
            }
        }
        return count;
    }

    public Map<String, Integer> getRoleCounts() {
        Map<String, Integer> roleCounts = new HashMap<>();
        for (Worker worker : workers) {
            String role = worker.getRole();
            roleCounts.put(role, roleCounts.getOrDefault(role, 0) + 1);
        }
        return roleCounts;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void displayWorkers() {
        if (workers.isEmpty()) {
            System.out.println("No workers found.");
        } else {
            for (Worker worker : workers) {
                System.out.println(worker);
            }
        }
    }
}
