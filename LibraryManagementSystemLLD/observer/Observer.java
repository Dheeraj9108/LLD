package LibraryManagementSystemLLD.observer;

import LibraryManagementSystemLLD.entites.LibraryItem;

public interface Observer {
    public void update(LibraryItem item);
}
