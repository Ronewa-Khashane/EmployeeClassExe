package za.ac.cput.service;

import org.springframework.stereotype.Service;

@Service
public interface IService <T, ID>{
T create (T t);
ID read (ID id);

T update (T t);

}
