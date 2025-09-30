package LibraryManagementSystemLLD.stratergy;

import java.util.List;
import java.util.stream.Collectors;

import LibraryManagementSystemLLD.entites.LibraryItem;

public class SearchByAuthor implements Search{

    @Override
    public List<LibraryItem> search(List<LibraryItem> items, String key) {
        return items.stream().filter(item->item.getAuthorPublisher().contains(key)).collect(Collectors.toList());
    }
    
}
