package com.revature.project3spring.services;

import com.revature.project3spring.entities.ReadList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReadListService {
	ReadList saveReadList(ReadList list);
	List<ReadList> getAllReadList();
	ReadList deleteReadList(long readListId);
	List<ReadList> getAllReadListByUserId(long userId);
}
