package InventoryManagementSystemLLD;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import InventoryManagementSystemLLD.command.InventoryRequest;

public class RequestQueue {
    private BlockingQueue<InventoryRequest> queue = new LinkedBlockingDeque<>();

    public void enqueue(InventoryRequest r){
        queue.add(r);
    }

    public InventoryRequest dequeu() throws InterruptedException{
        return queue.take();
    }
}
