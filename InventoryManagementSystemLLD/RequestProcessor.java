package InventoryManagementSystemLLD;

import InventoryManagementSystemLLD.command.InventoryRequest;

public class RequestProcessor implements Runnable{

    InventoryService service;
    RequestQueue requestQueue;
    
    public RequestProcessor(RequestQueue requestQueue, InventoryService service) {
        this.requestQueue = requestQueue;
        this.service = service;
    }

    @Override
    public void run() {
        while(true){
            try {
                InventoryRequest r = requestQueue.dequeu();
                r.process(service);  
                System.out.println("Processing r");  
            } catch (Exception e) {
            }
        }    
    }
    
}
