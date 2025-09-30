package LibraryManagementSystemLLD.stratergy;

import java.util.List;

import LibraryManagementSystemLLD.entites.LibraryItem;

public interface Search {
    public List<LibraryItem> search(List<LibraryItem> items, String key);
}
