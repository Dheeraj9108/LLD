package LinkedinLLD.services;

import java.util.List;
import java.util.stream.Collectors;

import LinkedinLLD.entites.Member;

public class SearchService {
    
    public List<Member> searchByName(List<Member> members , String key){
        return members.stream().filter(member->member.getName().contains(key)).collect(Collectors.toList());
    }
}
