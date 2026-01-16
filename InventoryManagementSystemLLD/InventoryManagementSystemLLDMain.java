package InventoryManagementSystemLLD;

import InventoryManagementSystemLLD.command.AddRequest;
import InventoryManagementSystemLLD.command.RemoveRequest;
import InventoryManagementSystemLLD.entites.InventoryItem;

public class InventoryManagementSystemLLDMain {
    public static void main(String[] args) throws InterruptedException {
        InventoryRepo repository = new InventoryRepo();
        repository.addProduct("P1", new InventoryItem(100));

        InventoryService service = InventoryService.getInstance(repository);
        RequestQueue requestQueue = new RequestQueue();

        // Start worker thread
        Thread worker = new Thread(new RequestProcessor(requestQueue, service));
        worker.start();

        // Simulate incoming requests
        requestQueue.enqueue(new AddRequest("P1", 50));
        requestQueue.enqueue(new RemoveRequest("P1", 30));
        requestQueue.enqueue(new RemoveRequest("P1", 150));
        requestQueue.enqueue(new AddRequest("P1", 20));

        // Allow processing
        Thread.sleep(1000);

        // Final stock
        System.out.println("Final stock of P1: " + service.checkStock("P1"));

        // Stop worker
        worker.interrupt();
    }
}
